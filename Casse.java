public class Casse {
	
	
	
	public static void main(String[] args)
	{
		Stone pierre1, pierre2;
		pierre1 = Stone.makeSmallStone();
		System.out.println("pierre1 : "+pierre1.toString());
		pierre2 = pierre1.split();
		//Il y a un effet de bord : split() agit aussi sur pierre1 et renvoit une Stone
		System.out.println("pierre1 : "+pierre1.toString());
		System.out.println("pierre2 : "+pierre2.toString());
	}
}
