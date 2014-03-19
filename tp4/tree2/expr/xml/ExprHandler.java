package expr.xml;

import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;


import Expression.*;
import Expression.Parser.*;

public class ExprHandler extends DefaultHandler{

	private Stack<String> pile = new Stack<String>();
	private Stack<Symbol> pileSymbol = new Stack<Symbol>();
	private Stack<Expression> pileBG = new Stack<Expression>();
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
//		pile.push(String.valueOf(ch, start, length));
		try {
//			pileBG.push(Builder.fromString(String.valueOf(ch, start, length)));
			pileBG.push(new Constant(Integer.valueOf(String.valueOf(ch, start, length))));
		} catch (Exception e) { throw (SAXException)e; }
	}

	@Override
	public void endDocument() throws SAXException {
		/*
		try {
			myExp = Builder.fromString(pile.pop());
		} catch (Exception e) { throw (SAXException)e; }
		System.out.println(myExp);*/
		System.out.println(pileBG.pop());
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName == "binop"){
			/*
			String secondvar = pile.pop();
			String premiervar = pile.pop();
			pile.push("("+premiervar+pile.pop()+secondvar+")");
			*/
			Expression secondvar = pileBG.pop();
			Expression premiervar = pileBG.pop();
			try {
//				pileBG.push(Builder.fromString("("+premiervar+")"+ pileSymbol.pop()+"("+secondvar+")"));
				pileBG.push(new Operation((Operator) pileSymbol.pop(),premiervar,secondvar));
			} catch (Exception e) { throw (SAXException)e; }
		}
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("Error !");
		e.printStackTrace();
		super.error(e);
//		throw e;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(attributes.getLength()>0)
			/*
			switch(attributes.getValue(0)){
				case "add": pile.push("+"); break;
				case "sub": pile.push("-"); break;
				case "mul": pile.push("*"); break;
				case "div": pile.push("/"); break;
				default: pile.push(attributes.getValue(0));
			}
			*/
			try{
			switch(attributes.getValue(0)){
				case "add": pileSymbol.push(new Operator("+")); break;
				case "sub": pileSymbol.push(new Operator("-")); break;
				case "mul": pileSymbol.push(new Operator("*")); break;
				case "div": pileSymbol.push(new Operator("/")); break;
				default: pileBG.push(Builder.fromString(attributes.getValue(0)));
			}
			}catch(Exception e){ throw (SAXException)e; }
	}

}
