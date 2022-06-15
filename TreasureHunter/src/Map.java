
public class Map {
int x, y, currentX, currentY, TreasureX, TreasureY, enemyX, enemyY = 0;
boolean gameEnd;

public Map(int mapSize)
{
	this.x = mapSize;
	this.y = mapSize;
	currentX = (int)Math.floor(Math.random()*(this.x-1+1)+1);
	currentY = (int)Math.floor(Math.random()*(this.y-1+1)+1);
	GenerateTreasure();
	GenerateEnemy();
	PrintMap();
}

public void GenerateTreasure() {
	TreasureX = (int)Math.floor(Math.random()*(this.x-1+1)+1);
	TreasureY = (int)Math.floor(Math.random()*(this.y-1+1)+1);
	if(TreasureX == currentX && TreasureY == currentY)
	{
		GenerateTreasure();
	}
}
public void GenerateEnemy() {
	enemyX = (int)Math.floor(Math.random()*(this.x-1+1)+1);
	enemyY = (int)Math.floor(Math.random()*(this.y-1+1)+1);
	if(enemyX == currentX && enemyY == currentY)
	{
		GenerateEnemy();
	}
	if(enemyX == TreasureX && enemyY == TreasureY)
	{
		GenerateEnemy();
	}
}


public void moveCharacter(String direction) {
	switch(direction) {
	case  "N":
		currentY++;
		if(currentY > y)
		{
			currentY = 1;
		}
		break;
	case "S":
		currentY--;
		if(currentY <= 0)
		{
			currentY = y;
		}
		break;
	case "E":
		currentX++;
		if(currentX > x)
		{
			currentX = 1;
		}
		break;
	case "W":currentX--;
	if(currentX <= 0)
	{
		currentX = x;
	}
		break;
		default:
			break;
	
	}
	boolean treasure = CheckTreasure();
	if(treasure) {
		//System.out.println("happened");
		setGameEnd(true);
	}
	else if(CheckEnemy()) {
		
	}
	else {
		PrintMap();
	}
	
}

public boolean CheckTreasure() {
	//System.out.println(currentX + " " + currentY);
	//System.out.println(TreasureX + " " + TreasureY);
	if(this.TreasureX == this.currentX && this.TreasureY == this.currentY)
	{
		
		return true;
	}
	else {
	return false;
	}
}
public boolean CheckEnemy() {
	if(this.enemyX == this.currentX && this.enemyY == this.currentY)
	{
		
		return true;
	}
	else {
	return false;
	}
}

public void EndGame() {
	Main.EndGame();
}
public void PrintMap() {
	for(int i = y; i >0; i--) {
		
		for(int j =1;j<=this.x; j++)
		{
			if(i == currentY && j == currentX) {
				System.out.print(" O");
			}
			else if(i == TreasureY && j == TreasureX) {
				System.out.print(" X");
			}
			else if(i == enemyY && j == enemyX) {
				System.out.print(" T");
			}
			else {
				System.out.print(" *");
			}
		}
		System.out.println(" ");
	}
}

public boolean isGameEnd() {
	return gameEnd;
}

public void setGameEnd(boolean gameEnd) {
	this.gameEnd = gameEnd;
}

}
