import java.util.Scanner;
public class Main {
	
	public static boolean GameStart;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Your Characters Name!");
		String charName = sc.nextLine();
		Character PC = new Character(charName, 5);
		Character NPC = new Character("Dredge", 3);
		PC.showDetails();
		System.out.println("Please Enter A Map Size!");
		String mapSize = sc.nextLine();
		int mapSizeInt = Integer.parseInt(mapSize);
		Map Avalon = new Map(mapSizeInt);
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

}
