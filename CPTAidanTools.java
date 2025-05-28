import arc.*;

public class CPTAidanTools{
	
	// Main Menu
	public static void menu(Console con){
		con.println("Type P to Play Game");
		con.println("Type V to View Leaderboard");
		con.println("Type A to Add Theme");
		con.println("Type Q to Quit");
		con.println("Type H for Help");
	}
	
	// Hangman Drawings 1-7
	// Drawing 1: No body
	public static void Drawing1(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("- - - - -");
	}
	// Drawing 2: Head
	public static void Drawing2(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("- - - - -");
	}
	// Drawing 3: Head + Body
	public static void Drawing3(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |          |");
		con.println("    |");
		con.println("    |");
		con.println("- - - - -");
	}
	// Drawing 4: Head + Body + Left Arm
	public static void Drawing4(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |         \\|");
		con.println("    |");
		con.println("    |");
		con.println("- - - - -");
	}
	// Drawing 5: Head + Body + Arms
	public static void Drawing5(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |        \\|/");
		con.println("    |");
		con.println("    |");
		con.println("- - - - -");
	}
	// Drawing 6: Head + Body + Arms + Left Leg
	public static void Drawing6(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |         \\|/");
		con.println("    |         /");
		con.println("    |");
		con.println("- - - - -");
	}
	// Drawing 7: Head + Body + Arms + Legs
	public static void Drawing7(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |         \\|/");
		con.println("    |         / \\");
		con.println("    |");
		con.println("- - - - -");
	}
}
