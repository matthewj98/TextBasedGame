public class Character {
private String name;
private String charClass;
private int hp;
private int level;
private int str;
private int dex;
private int cha;
private int wis;
private int intel;
private int con;

public Character(String newName, String newCharClass, int newLevel ) {
	this.name = newName;
	this.charClass = newCharClass;
	this.level = newLevel;
	this.str = rollStats();
	this.dex = rollStats();
	this.wis = rollStats();
	this.intel = rollStats();
	this.con = rollStats();
	this.cha = rollStats();
	this.hp = this.level * 6;
}

public Character(String charName, int charLevel) {
	this.name = charName;
	this.level = charLevel;
	this.hp = this.level * 6;
}
public Character(String charName) {
	this.name = charName;
	this.charClass = "Fighter";
	this.level = 1;
	this.hp = this.level * 6;
	this.str = rollStats();
	this.dex = rollStats();
	this.wis = rollStats();
	this.intel = rollStats();
	this.con = rollStats();
	this.cha = rollStats();
}

public void showDetails() {
	System.out.println(this.name + " "  + "HP: " + hp + " " + this.charClass + " " + this.level + " STR: " + this.str + " DEX: " + this.dex + " WIS: " + this.wis + " INT: " + this.intel + " CON: " + this.con + " CHA: " + this.cha);
}

public int rollStats() {
	int i = (int)Math.floor(Math.random()*(20-0+1)+0);
	return i;
}



public String getCharClass() {
	return charClass;
}

public void setCharClass(String charClass) {
	this.charClass = charClass;
}

public int getLevel() {
	return level;
}

public void setLevel(int level) {
	this.level = level;
}
}