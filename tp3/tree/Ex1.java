
public class Ex1
{
    public static void main (String[] args)
    {
        Expression test;
		try {
			test = Builder.fromString("(a+1)*(b-1)");

	        System.out.println("chaine : (a+1)*(b-1)");
	        System.out.println("var ref : ");
	        System.out.println(test);/*
	        System.out.println("var name : ",test.getName());
	        System.out.println("var type : ",test.getType());*/
		} catch (ParsingException e1) {}

        System.out.println("");
        Expression test2;
		try {
			test2 = Builder.fromString("x+delta");

	        System.out.println("chaine : x+delta");
	        System.out.println("var ref : ");
	        System.out.println(test2);/*
	        System.out.println("var name : ",test2.getName());
	        System.out.println("var type : ",test2.getType());*/
		} catch (ParsingException e) {}

        System.out.println("");
        Expression test3;
		try {
			test3 = Builder.fromString("(5)");

	        System.out.println("chaine : (5)");
	        System.out.println("var ref : ");
	        System.out.println(test3);/*
	        System.out.println("var name : ",test3.getName());
	        System.out.println("var type : ",test3.getType());*/
		} catch (ParsingException e) {}

        System.out.println("");
        Expression test4;
		try {
			test4 = Builder.fromString("-5");

	        System.out.println("chaine : -5");
	        System.out.println("var ref : ");
	        System.out.println(test4);/*
	        System.out.println("var name : ",test4.getName());
	        System.out.println("var type : ",test4.getType());*/
		} catch (ParsingException e) {}

        System.out.println("");
        Expression test5;
		try {
			test5 = Builder.fromString("1+x");

	        System.out.println("chaine : 1+x");
	        System.out.println("var ref : ");
	        System.out.println(test5);/*
	        System.out.println("var name : ",test5.getName());
	        System.out.println("var type : ",test5.getType());*/
		} catch (ParsingException e) {}

        System.out.println("");
        Expression test6;
		try {
			test6 = Builder.fromString("+");

	        System.out.println("chaine : +");
	        System.out.println("var ref : ");
	        System.out.println(test6);/*
	        System.out.println("var name : ",test6.getName());
	        System.out.println("var type : ",test6.getType());*/
		} catch (ParsingException e) {}

        System.out.println("");
        Expression test7;
		try {
			test7 = Builder.fromString("x");

	        System.out.println("chaine : x");
	        System.out.println("var ref : ");
	        System.out.println(test7);/*
	        System.out.println("var name : ",test7.getName());
	        System.out.println("var type : ",test7.getType());*/
		} catch (ParsingException e) {}

        System.out.println("");
        Expression test8;
		try {
			test8 = Builder.fromString("1");

	        System.out.println("chaine : 1");
	        System.out.println("var ref : ");
	        System.out.println(test8);/*
	        System.out.println("var name : ",test8.getName());
	        System.out.println("var type : ",test8.getType());*/
		} catch (ParsingException e) {}
    }
}
