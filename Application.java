/**
 * l
 */

/**
 * @author brandonesarey
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameStart l=new GameStart();
		Battle m = new Battle();
		l.Intro();
		l.CreateDungeon();
		m.Traverse();

	}//end Main()

}//end Application
