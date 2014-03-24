import java.io.IOException;

import org.xml.sax.SAXException;

import expr.xml.XmlExprParser;


public class Ex5 {
public static void main (String argc[]){
	try {
		System.out.print(XmlExprParser.fromFile("../xml/expressionE.xml"));
	} catch (SAXException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
