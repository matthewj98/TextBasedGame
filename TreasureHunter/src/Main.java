import java.util.Scanner;
public class Main {
	
	public static boolean GameStart;
	static Scanner sc = new Scanner(System.in);
	public static int mapSizeInt =0;
	static public Map Avalon;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please Enter Your Characters Name!");
		String charName = sc.nextLine();
		Character PC = new Character(charName, 5);
		Character NPC = new Character("Dredge", 3);
		PC.showDetails();
		enterMap();
		//System.out.println(mapSizeInt);
		//createMap(mapSizeInt);
		boolean GameStart = true;
		
		while(GameStart){
			System.out.println("Enter A Direction! (N, E, S, W)");
			String direction = sc.nextLine();
			Avalon.moveCharacter(direction);
			GameStart = !Avalon.isGameEnd();
		} 
		System.out.println("Congratulatiions you won!");
	}
	
	public static void EndGame() {
		GameStart = false;
		
	}
	
	public static void enterMap() {
		
		System.out.println("Please Enter A Map Size!");	
		String mapSize = sc.nextLine();
		try {
			mapSizeInt = Integer.parseInt(mapSize);
		//	System.out.println(mapSizeInt);
			if(mapSizeInt > 30) {
				System.out.println("Map Size Too Large!");
				enterMap();
				return;
			}
			createMap(mapSizeInt);
		} catch (NumberFormatException e){
			System.out.println("Caught Exception");
			e.printStackTrace();
			enterMap();
		}
		//System.out.println(mapSizeInt);
	}
	
	public static void createMap(int mapInt) {
		try {
			Avalon = new Map(mapInt);
			System.out.println("Map Created!");}
		catch (StackOverflowError e) {
			System.out.println("Error: Number too small");
			enterMap();
		}
	}

}
