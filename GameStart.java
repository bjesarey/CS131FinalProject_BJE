
/**
 * Creates the number of floors that the player will travel through.
 */
import java.util.*;

/**
 * @author brandonesarey
 * @version 1.3
 * Final Project
 * CS131 
 * Semester year Spring 2023
 */
public class GameStart {
	static Scanner scan = new Scanner(System.in);
	protected int Health;
	protected int PhysAttack;
	protected static int Dungeon;

	public GameStart() {
		setHealth(100);
		setPhysAttack(20);
		setDungeon(Dungeon);
	}// end default constructor

	/**
	 * @param health
	 * @param physAttack
	 * @param hasDragonSlayer
	 * @param dungeon
	 */
	public GameStart(int health, int physAttack, boolean hasDragonSlayer, int dungeon) {
		this.Health = health;
		this.PhysAttack = physAttack;
		GameStart.Dungeon = dungeon;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return Health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		Health = health;
	}

	/**
	 * @return the physAttack
	 */
	public int getPhysAttack() {
		return PhysAttack;
	}

	/**
	 * @param physAttack the physAttack to set
	 */
	public void setPhysAttack(int physAttack) {
		PhysAttack = physAttack;
	}

	/**
	 * @return the dungeon
	 */
	public int getDungeon() {
		return Dungeon;
	}

	/**
	 * @param dungeon the dungeon to set
	 */
	public void setDungeon(int dungeon) {
		Dungeon = dungeon;
	}

	public void Intro() {
		System.out.println("Welcome to Dungeon Depth!");
	}// end Intro()

	public void CreateDungeon() {
		System.out.println("How many floors do you wish to traverse?:");
		Dungeon = scan.nextInt();
		setDungeon(Dungeon);
		System.out.println("You will be travelling through a dungeon with " + getDungeon() + " floors.");
		System.out.println("Your physical attack is " + Health + ", your physical attack is " + PhysAttack
				+ ". Now the game begins.");
	}// end CreateDungeon()

}// end GameStart
