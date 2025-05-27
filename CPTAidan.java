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
		con.println("Type 1 to Play Game");
		con.println("Type 2 to View Leaderboard");
		con.println("Type 3 to Add Theme");
		con.println("Type 4 to Quit");
	}
}
