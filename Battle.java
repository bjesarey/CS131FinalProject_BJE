import java.util.*;

/**
 * 
 */

/**
 * @author brandonesarey
 *
 */
public class Battle extends Enemy implements Chest {
	static Scanner scan = new Scanner(System.in);
	private int HealthPotion;
	private int PhysAttackPotion;
	private boolean hasDragonSlayer;
	protected static int Floor;

	public Battle() {
		setHealthPotion(0);
		setPhysAttackPotion(0);
		setHasDragonSlayer(false);
		setFloor(1);
	}

	/**
	 * @param healthPotion
	 * @param physAttackPotion
	 * @param magAttackPotion
	 * @param hasDragonSlayer
	 */
	public Battle(int healthPotion, int physAttackPotion, boolean hasDragonSlayer, int floor) {
		this.HealthPotion = healthPotion;
		this.PhysAttackPotion = physAttackPotion;
		this.hasDragonSlayer = hasDragonSlayer;
		Battle.Floor = floor;
	}

	/**
	 * @return the healthPotion
	 */
	public int getHealthPotion() {
		return HealthPotion;
	}

	/**
	 * @param healthPotion the healthPotion to set
	 */
	public void setHealthPotion(int healthPotion) {
		HealthPotion = healthPotion;
	}

	/**
	 * @return the physAttackPotion
	 */
	public int getPhysAttackPotion() {
		return PhysAttackPotion;
	}

	/**
	 * @param physAttackPotion the physAttackPotion to set
	 */
	public void setPhysAttackPotion(int physAttackPotion) {
		PhysAttackPotion = physAttackPotion;
	}

	/**
	 * @return the hasDragonSlayer
	 */
	public boolean isHasDragonSlayer() {
		return hasDragonSlayer;
	}

	/**
	 * @param b the hasDragonSlayer to set
	 */
	public void setHasDragonSlayer(boolean DragonSlayer) {
		this.hasDragonSlayer = DragonSlayer;
	}

	/**
	 * @return the floor
	 */
	public static int getFloor() {
		return Floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public static void setFloor(int floor) {
		Floor = floor;
	}

	public void Traverse() {
		while (Floor <= GameStart.Dungeon) {
			System.out.println("=====================");
			System.out.println("      FLOOR " + Floor);
			System.out.println("=====================\n");
			Fight();
			Floor++;
		} // end for
	}// end Traverse()

	public void EnemyAttack() {// Allows the enemy to attack the player
		Health = Health - EnemyPhysAttack;
		System.out.println("The monster attacks!");
		System.out.println("You have lost " + EnemyPhysAttack + " health!");

		if (Health <= 0) { // Ends the program if the player's health reaches 0.
			setEnemyHP(0);
			Floor = GameStart.Dungeon;
			System.out.println("\nYou have died. Game over.");
		} // end if
	}// end EnemyAttack()

	public void Fight() {
		@SuppressWarnings("resource")
		Scanner Decision = new Scanner(System.in);
		int Action = 0;
		EnemySpawn();
		while (EnemyHP > 0) {
			System.out.println("\nYour health is " + Health + ".\nThe monster's health is " + super.getEnemyHP()
					+ "\nMake your move. (1=Fight, 2=Item, 3 or higher=Flee)");
			Action = Decision.nextInt();

			if (Action == 1) { // Attacks the enemy with a physical attack and displays damage done and enemy
								// health remaining.
				EnemyHP = EnemyHP - PhysAttack;
				System.out.println("You dealt " + PhysAttack + " points of damage to the monster.");
			} // end if
			
			if(Action == 1 && Floor==Dungeon && hasDragonSlayer==true) {
				setEnemyHP(0);
				System.out.println("With your blade, you managed to smite the dragon with little effort.");
			}

			if (Action == 2) {// Allows the player to use potions they have collected.
				System.out.println("What item would you like to use? You have " + HealthPotion + " health potions and "
						+ PhysAttackPotion + " Attack potions. (1=Health Potion, 2=Attack Potion, 3=BACK)");
				int PotionUse = Decision.nextInt();
				while(PotionUse!=3) {
				if (PotionUse == 1 && HealthPotion > 0) {
					HealthPotion--;
					Health = Health + 30;
					System.out.println("Your Health increased by 30 points.");
					System.out.println(
							"What item would you like to use? You have " + HealthPotion + " health potions and "
									+ PhysAttackPotion + " Attack potions. (1=Health Potion, 2=Attack Potion, 3=BACK)");
					PotionUse = Decision.nextInt();
				} // end if
				
				else if (PotionUse == 1 && HealthPotion == 0) {
					System.out.println("Sorry, you don't have any health potions.");
					System.out.println(
							"What item would you like to use? You have " + HealthPotion + " health potions and "
									+ PhysAttackPotion + " Attack potions. (1=Health Potion, 2=Attack Potion, 3=BACK)");
					PotionUse = Decision.nextInt();
				} // end if

				if (PotionUse == 2 && PhysAttackPotion > 0) {
					PhysAttackPotion--;
					PhysAttack = PhysAttack + 5;
					System.out.println("Your Physical Attack increased by 5 points.");
					System.out.println(
							"What item would you like to use? You have " + HealthPotion + " health potions and "
									+ PhysAttackPotion + " Attack potions. (1=Health Potion, 2=Attack Potion, 3=BACK)");
					PotionUse = Decision.nextInt();
				} // end if
				
				else if (PotionUse == 2 && HealthPotion == 0) {
					System.out.println("Sorry, you don't have any physical attack potions.");
					System.out.println("What item would you like to use? You have " + HealthPotion + " health potions and "
									+ PhysAttackPotion + " Attack potions. (1=Health Potion, 2=Attack Potion, 3=BACK)");
					PotionUse = Decision.nextInt();
				} // end if
				}//end while
			} // end if
			if (Action >= 3) { // Immediately sets Floor equal to Dungeon when the player inputs a number 3 or
								// higher, therefore ending the program.
				Floor = GameStart.Dungeon;
				setEnemyHP(0);
				System.out.println("You decided to flee the dungeon while you still could.");
			} // end if
			
			if (EnemyHP <= 0 && Action < 4 && Floor < Dungeon) {
				System.out.println("The monster has been defeated. On to the next floor.");
				GiveLoot();
			} // end if
			 if(Action==1 && EnemyHP>0)
			 EnemyAttack();
			if (EnemyHP <= 0 && Floor == Dungeon && Health > 0 && Action < 3) {
				System.out.println("\nCongratulations! You Win!");
			} // end if
		} // end while

	}// end Fight()

	@Override
	public void GiveLoot() {
		// TODO Auto-generated method stub
		System.out.println("Oh, the monster dropped a chest");
		Random LootGenerator = new Random();
		String[] LootPicker = { "Health Potion", "Health Potion", "Physical Attack Potion", "Physical Attack Potion", "Dragonslayer's Blade"};
		int Treasure = LootGenerator.nextInt(5);
		if (Treasure == 0 || Treasure==1) {
			HealthPotion++;
			System.out.println("You got a "+LootPicker[Treasure]+"!");
		} // end if
		if (Treasure == 2 || Treasure==3) {
			PhysAttackPotion++;
			System.out.println("You got a "+LootPicker[Treasure]+"!");
		}//end if
		if(Treasure==4) {
			setHasDragonSlayer(true);
			System.out.println("You got the "+LootPicker[Treasure]+". You can now slay a dragon with ease.");
		}//end if

	}// end GiveLoot()

}// end Battle
