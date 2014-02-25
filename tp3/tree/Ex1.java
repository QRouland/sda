import java.util.*;

public class Ex1
{
    public static void main (String[] args)
    {
        Expression test = Builder.fromString("(a+1)*(b-1)");

        System.out.println("chaine : (a+1)*(b-1)");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());

        Expression test = Builder.fromString("x+delta");

        System.out.println("chaine : x+delta");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());

        Expression test = Builder.fromString("(5)");

        System.out.println("chaine : (5)");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());

        Expression test = Builder.fromString("-5");

        System.out.println("chaine : -5");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());

        Expression test = Builder.fromString("1+x");

        System.out.println("chaine : 1+x");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());

        Expression test = Builder.fromString("+");

        System.out.println("chaine : +");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());

        Expression test = Builder.fromString("x");

        System.out.println("chaine : x");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());

        Expression test = Builder.fromString("1");

        System.out.println("chaine : 1");
        System.out.println("var ref : ",test);
        System.out.println("var name : ",test.getName());
        System.out.println("var type : ",test.getType());
    }
}
