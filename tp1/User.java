
public class User {

	public static void main(String[] args)
	{
		Stone pierre1, pierre2;
		int i = 1;
		//		pierre1 = Stone.makeBigStone();
		pierre1 = Stone.makeHugeStone();
		//log n -> augmente legerement passe de 16 a 26
		System.out.println("pierre1 : "+pierre1.toString());
		
		pierre2 = pierre1.split();
		while(pierre2.diameter()>5 || pierre1.diameter()>5) //0 optimisation :)
		{
			pierre2 = pierre1.split();
			i++;
		}
		System.out.println("Nb iteration : "+i);
		System.out.println("pierre1 : "+pierre1.toString());
		System.out.println("pierre2 : "+pierre2.toString());
		
	}
}
