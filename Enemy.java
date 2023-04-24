
/**
 * 
 */
import java.util.*;

/**
 * @author brandonesarey
 *
 */
public class Enemy extends GameStart {
	protected static int EnemyHP;
	protected int EnemyPhysAttack;


	public Enemy() {
		setEnemyHP(0);
		setEnemyPhysAttack(0);
	}

	/**
	 * @param enemyHP
	 * @param enemyPhysAttack

	 */
	public Enemy(int enemyHP, int enemyPhysAttack) {
		Enemy.EnemyHP = enemyHP;
		this.EnemyPhysAttack = enemyPhysAttack;
	}

	/**
	 * @return the enemyHP
	 */
	public int getEnemyHP() {
		return EnemyHP;
	}

	/**
	 * @param enemyHP the enemyHP to set
	 */
	public void setEnemyHP(int enemyHP) {
		EnemyHP = enemyHP;
	}

	/**
	 * @return the enemyPhysAttack
	 */
	public int getEnemyPhysAttack() {
		return EnemyPhysAttack;
	}

	/**
	 * @param enemyPhysAttack the enemyPhysAttack to set
	 */
	public void setEnemyPhysAttack(int enemyPhysAttack) {
		EnemyPhysAttack = enemyPhysAttack;
	}


	public void Skeleton() {
		System.out.println("A Skeleton appears!");
		setEnemyHP(20);
		setEnemyPhysAttack(30);
		System.out.println("Its health is " + getEnemyHP() + " and its physical attack is " + getEnemyPhysAttack() + ".");
	}

	public void Goblin() {
		System.out.println("A Goblin appears!");
		setEnemyHP(30);
		setEnemyPhysAttack(15);
		System.out.println("Its health is " + getEnemyHP() + " and its physical attack is " + getEnemyPhysAttack() + ".");
	}

	public void Ghost() {
		System.out.println("A Ghost appears!");
		setEnemyHP(20);
		setEnemyPhysAttack(10);
		System.out.println("Its health is " + getEnemyHP() + " and its physical attack is " + getEnemyPhysAttack() + ".");
	}

	public void Dragon() {
		setEnemyHP(100);
		setEnemyPhysAttack(40);
		System.out.println("Its health is " + getEnemyHP() + " and its physical attack is " + getEnemyPhysAttack() + ".");
	}
	
	public void Golem() {
		System.out.println("A Golem appears!");
		setEnemyHP(40);
		setEnemyPhysAttack(30);
		System.out.println("Its health is " + getEnemyHP() + " and its physical attack is " + getEnemyPhysAttack() + ".");
	}
	public void Serpent() {
		System.out.println("A Serpent appears!");
		setEnemyHP(30);
		setEnemyPhysAttack(30);
		System.out.println("Its health is " + getEnemyHP() + " and its physical attack is " + getEnemyPhysAttack() + ".");
	}

	
	public void EnemySpawn() {
		Random Spawner = new Random();
		String[] EnemyWheel = { "Skeleton", "Goblin", "Ghost", "Golem", "Serpent"};
		int NewEnemy = Spawner.nextInt(5);
		if (NewEnemy == 0)
			Skeleton();
		if (NewEnemy == 1)
			Goblin();
		if (NewEnemy == 2)
			Ghost();
		if (NewEnemy == 3)
			Golem();
		if (NewEnemy == 4)
			Serpent();
		if (Battle.Floor == Dungeon) {
			System.out.println("\nThe "+ EnemyWheel[NewEnemy] + " was eaten by a Dragon!");
			Dragon();   
		}//end if 
	}// end EnemySpawn()
}// end Enemy
