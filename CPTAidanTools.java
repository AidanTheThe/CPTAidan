import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAidanTools{
	
	// Screens/Menus
	
	// Main Menu
	public static void mainMenu(Console con){
		con.clear();
		// set screen background to black
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		// load menu and menu options
		con.println("|--------------------------|");
		con.println("|Type P to Play Game       |");
		con.println("|Type V to View Leaderboard|");
		con.println("|Type A to Add Theme       |");
		con.println("|Type Q to Quit            |");
		con.println("|Type H for Help           |");
		con.println("|--------------------------|");
		con.println("");
		System.out.println("Menu Loaded");
	}

	// Help Screen
	public static void helpScreen(Console con){
		con.clear();
		con.println("Help");
		con.println("");
		con.println("How To Play");
		con.println("Each line represents a missing letter");
		con.println("Guess the word by typing it out and pressing Enter");
		con.println("For every wrong guess, a new random letter is revealed and a body part is added to the stickman");
		con.println("The goal is to guess the word before the stickman is fully drawn");
		con.println("Some answers are tricky and a combination of more than one word");
		con.println("");
		con.println("Type R to Return to the Main Menu");
	}
	
	// Secret Menu
	public static void secretMenu(Console con){
		con.clear();
		con.println("I asked the IT guy, 'how do you make a motherboard?'");
		con.println("He said, 'I tell her about my job.'");
		con.println("");
		con.println("I started a band called 999 Megabytes");
		con.println("We haven't gotten a gig yet");
		con.println("");
		con.println("Why do programmers prefer dark mode?");
		con.println("Because light attracts bugs!");
		con.println("");
		con.println("Type R to Return to the Main Menu");
	}

	// Theme Screen
	public static void themeScreen(Console con){
		con.println("Select and type out a theme:");
		con.println("");
		// open themes.txt
		TextInputFile themes = new TextInputFile("themes.txt");
		System.out.println("Opened themes.txt");
		String strTheme;
		// read and print each line
		while(themes.eof() == false){
			strTheme = themes.readLine();
			con.println(strTheme);
		}
		themes.close();
		System.out.println("Closed themes.txt");
	}
	
	// Win Screen
	public static void winScreen(Console con){
		// show win screen
		BufferedImage imgWin = con.loadImage("Win_Black_Screen.png");
		con.drawImage(imgWin, 0, 0);
	}
	
	// Lose Screen
	public static void loseScreen(Console con){
		// show lose screen
		BufferedImage imgLose = con.loadImage("Lose_Black_Screen.png");
		con.drawImage(imgLose, 0, 0);
	}
	
	// No More Words Screen
	public static void noWordsScreen(Console con){
		int intLength = 0;
		int intLengthRand;
		int intTimeRand;
		// show "no more words" screen
		BufferedImage imgNoWords = con.loadImage("No_More_Words_Screen.png");
		con.drawImage(imgNoWords, 0, 0);
		// print game logo
		gameLogo(con);
		// print loading bar animation
		con.setDrawColor(Color.WHITE);
		con.println("");
		while(intLength <= 1350){
			con.fillRect(0,600,intLength,12);
			intLengthRand = (int)(Math.random() * 61 + 30);
			intLength = intLength + intLengthRand;
			con.println("");
			intTimeRand = (int)(Math.random() * 101 + 100);
			con.sleep(intTimeRand);
		}
		con.println("");
	}
	
	// Loading Screen
	public static void loadingScreen(Console con){
		int intLength = 0;
		int intLengthRand;
		int intTimeRand;
		// print loading screen
		BufferedImage imgLoad = con.loadImage("Loading_Screen.png");
		con.drawImage(imgLoad, 0, 0);
		// print game logo
		gameLogo(con);
		// print loading bar animation
		con.setDrawColor(Color.WHITE);
		con.println("");
		while(intLength <= 1350){
			con.fillRect(0,600,intLength,12);
			intLengthRand = (int)(Math.random() * 31 + 25);
			intLength = intLength + intLengthRand;
			con.println("");
			intTimeRand = (int)(Math.random() * 101 + 50);
			con.sleep(intTimeRand);
		}
		con.println("");
	}
	
	// Game Logo
	public static void gameLogo(Console con){
		// print game logo
		BufferedImage imgLogo = con.loadImage("New_Game_Logo.png");
		con.drawImage(imgLogo, 1180, 0);
	}
	
	// Menu Option Calculations
	
	// View Leaderboard
	public static void viewLeaderboard(Console con){
		// clear screen
		con.clear();
		// create/initalize variables
		int intCount;
		int intCount2;
		int intPlayers;
		intPlayers = 0;
		String strName;
		String strNameTemp;
		String strScore;
		String strScoreTemp;
		// open and close leaderboard.txt
		TextInputFile leader = new TextInputFile("leaderboard.txt");
		while(leader.eof() == false){
			strNameTemp = leader.readLine();
			strScoreTemp = leader.readLine();
			intPlayers = intPlayers + 1;
		}
		leader.close();
		System.out.println("Number of players: "+intPlayers);
		// load data from leaderboard.txt into an array
		String strLeaderboard[][];
		strLeaderboard = new String[intPlayers][2];
		leader = new TextInputFile("leaderboard.txt");
		for(intCount = 0; intCount < intPlayers; intCount++){
			strLeaderboard[intCount][0] = leader.readLine();
			strLeaderboard[intCount][1] = leader.readLine();
		}
		// sort the data from most to least wins
		for(intCount2 = 0; intCount2 < intPlayers - 1; intCount2++){
			for(intCount = 0; intCount < intPlayers - 1; intCount++){
				if(Integer.parseInt(strLeaderboard[intCount][1]) < Integer.parseInt(strLeaderboard[intCount+1][1])){
					strNameTemp = strLeaderboard[intCount][0];
					strLeaderboard[intCount][0] = strLeaderboard[intCount+1][0];
					strLeaderboard[intCount+1][0] = strNameTemp;
					strScoreTemp = strLeaderboard[intCount][1];
					strLeaderboard[intCount][1] = strLeaderboard[intCount+1][1];
					strLeaderboard[intCount+1][1] = strScoreTemp;
				}
			}
		}
		// print out data 
		con.println("Leaderboard");
		con.println("");
		for(intCount = 0; intCount < intPlayers; intCount++){
			if(Integer.parseInt(strLeaderboard[intCount][1]) == 1){
				con.println(strLeaderboard[intCount][0]+" - "+strLeaderboard[intCount][1]+" Win");
			}else{
				con.println(strLeaderboard[intCount][0]+" - "+strLeaderboard[intCount][1]+" Wins");
			}
		}
		con.println("");
		con.println("Type R to Return to the Main Menu");
	}
	
	// Add Theme
	public static String addTheme(Console con){
		// clear screen
		con.clear();
		// create/initialize variables
		String strThemeName;
		String strWord = "";
		con.println("Enter a theme name");
		con.println("Ex: food, movies, superheroes, etc...");
		con.println("Type R to Return to the Main Menu");
		con.println("");
		strThemeName = con.readLine();
		// open themes.txt and print new theme name
		if(!strThemeName.equalsIgnoreCase("r")){
			TextOutputFile themes = new TextOutputFile("themes.txt", true);
			themes.println(strThemeName);
			themes.close();
			// prompt user to input words that relate to the theme
			con.println("");
			con.println("Enter words relating to the theme");
			con.println("And enter 'stop' to stop");
			con.println("");
			// print new words to the newly created theme file
			strThemeName = strThemeName + ".txt";
			TextOutputFile newtheme = new TextOutputFile(strThemeName);
			while(!strWord.equalsIgnoreCase("stop")){
				strWord = con.readLine();
				if(!strWord.equalsIgnoreCase("stop")){
					newtheme.println(strWord);
				}
			}
			con.println("");
			con.println("New Theme Successfully Added");
			con.println("");
			con.println("Type R to Return to the Main Menu");
		}
		return strThemeName;
	}
	
	// Quit Screen
	public static void quitScreen(Console con, String strName, int intWins, String strTheme){
		con.clear();
		// print quit screen
		BufferedImage imgQuit = con.loadImage("Quit_Screen.png");
		con.drawImage(imgQuit, 0, 0);
		// if the user enters a theme, print name, wins, and last played theme
		if(!strTheme.equalsIgnoreCase("")){
			System.out.println("Quit Screen 1");
			con.println("Game Summary");
			con.println("");
			con.println("Name: "+strName);
			con.println("Wins: "+intWins);
			con.println("Last Played Theme: "+strTheme);
			con.println("");
			con.println("Thank you for playing");
		}else{
			// if the user does not enter a theme, only print "Thank you for playing"
			System.out.println("Quit Screen 2");
			con.println("Thank you for playing");
		}
		con.sleep(5000);
		con.closeConsole();
	}
	
	// Hangman Drawings 1-7
	// Drawing 1: No body
	public static void drawing1(Console con){
		con.println("");
		con.println("    /--------|");
		con.println("    |        |");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 2: Head
	public static void drawing2(Console con){
		con.println("");
		con.println("    /--------|");
		con.println("    |        |");
		con.println("    |        O");
		con.println("    |");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 3: Head + Body
	public static void drawing3(Console con){
		con.println("");
		con.println("    /--------|");
		con.println("    |        |");
		con.println("    |        O");
		con.println("    |        |");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 4: Head + Body + Left Arm
	public static void drawing4(Console con){
		con.println("");
		con.println("    /--------|");
		con.println("    |        |");
		con.println("    |        O");
		con.println("    |       \\|");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 5: Head + Body + Arms
	public static void drawing5(Console con){
		con.println("");
		con.println("    /--------|");
		con.println("    |        |");
		con.println("    |        O");
		con.println("    |       \\|/");
		con.println("    |");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 6: Head + Body + Arms + Left Leg
	public static void drawing6(Console con){
		con.println("");
		con.println("    /--------|");
		con.println("    |        |");
		con.println("    |        O");
		con.println("    |       \\|/");
		con.println("    |       /");
		con.println("    |");
		con.println("---------");
	}
	// Drawing 7: Head + Body + Arms + Legs
	public static void drawing7(Console con){
		con.println("");
		con.println("    /--------|");
		con.println("    |        |");
		con.println("    |        O");
		con.println("    |       \\|/");
		con.println("    |       / \\");
		con.println("    |");
		con.println("---------");
	}
}
