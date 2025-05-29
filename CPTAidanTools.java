import arc.*;

public class CPTAidanTools{
	
	// Assistance Screens/Menus
	// Main Menu
	public static void mainMenu(Console con){
		con.println("Type P to Play Game");
		con.println("Type V to View Leaderboard");
		con.println("Type A to Add Theme");
		con.println("Type Q to Quit");
		con.println("Type H for Help");
	}
	// Help Screen
	public static void helpScreen(Console con){
		con.println("Help");
		con.println("\nHow To Play");
		con.println("Each line represents a missing letter");
		con.println("Guess the word by typing it out and pressing Enter");
		con.println("For every wrong guess, a new random letter is revealed and a body part is added to the stickman");
		con.println("The goal is to guess the word before the stickman is fully drawn");
		con.println("\nType R to Return to the Main Menu");
	}
	// Secret Menu
	public static void secretMenu(Console con){
		con.println("I asked the IT guy, 'how do you make a motherboard?'");
		con.println("He said, 'I tell her about my job.'");
		con.println("\nI started a band called 999 Megabytes");
		con.println("We haven't gotten a gig yet");
		con.println("\nWhy do programmers prefer dark mode?");
		con.println("Because light attracts bugs!");
		con.println("\nType R to Return to the Main Menu");
	}
	// Theme Screen
	public static void themeScreen(Console con){
		con.println("Select a theme");
	}
	
	// Hangman Drawings 1-7
	// Drawing 1: No body
	public static void drawing1(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 2: Head
	public static void drawing2(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 3: Head + Body
	public static void drawing3(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |          |");
		con.println("    |");
		con.println("    |");
		con.println("- - - - -");
	}
	// Drawing 4: Head + Body + Left Arm
	public static void drawing4(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |         \\|");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 5: Head + Body + Arms
	public static void drawing5(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |         \\|/");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 6: Head + Body + Arms + Left Leg
	public static void drawing6(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |         \\|/");
		con.println("    |         /");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 7: Head + Body + Arms + Legs
	public static void drawing7(Console con){
		con.println("    /----------|");
		con.println("    |          |");
		con.println("    |          O");
		con.println("    |         \\|/");
		con.println("    |         / \\");
		con.println("    |");
		con.println("---------");
	}
}
