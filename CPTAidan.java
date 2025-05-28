import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console();
		menu(con);
		String strModeInput;
		strModeInput = con.readLine();
	}
	
	// Main Menu
	public static void menu(Console con){
		con.println("Type P to Play Game");
		con.println("Type V to View Leaderboard");
		con.println("Type A to Add Theme");
		con.println("Type Q to Quit");
	}
}
