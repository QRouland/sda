package expr.xml;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class LogHandler extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("Characters : "+ String.valueOf(ch, start, length));
		super.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("EndDocument");
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("EndElement : "+qName);
		super.endElement(uri, localName, qName);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("Error !");
		e.printStackTrace();
		super.error(e);
//		throw e;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("StartDocument");
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("StartElement : "+qName);
		for(int i = 0; i < attributes.getLength() ; i++)
			System.out.print(attributes.getQName(i)+" = "+attributes.getValue(i));
		if(attributes.getLength()>0) System.out.println();
		super.startElement(uri, localName, qName, attributes);
	}

}
