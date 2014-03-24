package expr.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import Expression.Expression;

public class XmlExprParser {
	/**
	 * Builds the expression corresponding to a given XML expression file.
	 * @param file The name of the file
	 * @return The expression described in the file
	 * @throws SAXException An error occurred when parsing the file
	 * @throws IOException The file cannot be opened
	 */
	public static Expression fromFile(String file) throws SAXException, IOException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parseurSax;
		try { parseurSax = factory.newSAXParser(); } catch (ParserConfigurationException e) { return null; }
		ExprHandler trololol = new ExprHandler();
		parseurSax.parse(new File("../xml/exampleE.xml"), trololol);
		return trololol.finalExpression;
	}
}
