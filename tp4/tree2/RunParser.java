import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.SAXException;

import expr.xml.*;


public class RunParser {
	
	public static void main(String[] args) throws Exception {
		System.out.println("\\ø/");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		SAXParser parseurSax = factory.newSAXParser();
		System.out.println("\\ø/");
		LogHandler logeur = new LogHandler();
		System.out.println("\\ø/");
/*
		parseurSax.parse(new File("../xml/exampleE.xml"), logeur);
		System.out.println("Parsing terminé de E \\ø/\n");
*/
/*
		parseurSax.parse(new File("../xml/exampleA.xml"), logeur); // prend pas en compte le dtd de base sans validating
		System.out.println("Parsing terminé de A \\ø/\n");
		parseurSax.parse(new File("../xml/exampleB.xml"), logeur); // prend pas en compte le dtd de base sans validating
		System.out.println("Parsing terminé de B \\ø/\n");
		parseurSax.parse(new File("../xml/exampleD.xml"), logeur); // detecte les erreurs xml
		System.out.println("Parsing terminé de D \\ø/\n");

		parseurSax.parse(new File("../xml/comments.xml"), logeur); // deux fois characters() alors qu'on est dans un seul integer !
		System.out.println("Parsing terminé de comments \\ø/\n");
*/
		ExprHandler trololol = new ExprHandler();

		parseurSax.parse(new File("../xml/exampleE.xml"), trololol);
		parseurSax.parse(new File("../xml/decoupage1.xml"), trololol);
		parseurSax.parse(new File("../xml/decoupage2.xml"), trololol);
		parseurSax.parse(new File("../xml/decoupage3.xml"), trololol);
		parseurSax.parse(new File("../xml/decoupage4.xml"), trololol);
		parseurSax.parse(new File("../xml/monster.xml"), trololol);
		parseurSax.parse(new File("../xml/exampleC.xml"), trololol);
	}
	
}