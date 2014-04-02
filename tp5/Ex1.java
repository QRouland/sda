package src;

import src.intset.*;


public class Ex1 {

	public static void main(String[] args) {
		IntegerSet S = new RTIntegerSet();
		System.out.println(S.toRanges());
		S.add(1);
		System.out.println(S.toRanges());
		S.add(2);
		System.out.println(S.toRanges());
		S.add(6);
		System.out.println(S.toRanges());
		S.add(0);
		System.out.println(S.toRanges());
		S.add(1);
		System.out.println(S.toRanges());
		S.add(3);
		System.out.println(S.toRanges());
		S.add(2);
		System.out.println(S.toRanges());
		S.add(4);
		System.out.println(S.toRanges());
		S.add(5);
		System.out.println(S.toRanges());
		S.add(-1);
		System.out.println(S.toRanges());
		S.add(7);
		System.out.println(S.toRanges());

		S.add(1);
		S.add(2);
		S.add(6);
		S.add(0);
		S.add(1);
		S.add(3);
		S.add(2);
		S.add(4);
		S.add(5);
		S.add(-1);
		S.add(7);
		
		System.out.println(S.toRanges());
	}

}
