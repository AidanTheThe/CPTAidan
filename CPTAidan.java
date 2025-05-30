import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console("Hangman", 1280, 720);
		CPTAidanTools.mainMenu(con);
		boolean blnGameOver;
		blnGameOver = false;
		String strTheme;
		String strWordTemp;
		int intNumTemp;
		int intWordCount = 0;
		String strName;
		String strMode;
		strMode = con.readLine();
		int intCount;
		
		// While loop that encases all code excluding startup menu and some variables
		while(blnGameOver == false){
			if(strMode.equalsIgnoreCase("p")){
				// User inputs name and selects theme
				con.println("\nEnter your name");
				strName = con.readLine();
				con.println("");
				CPTAidanTools.themeScreen(con);
				con.println("");
				strTheme = con.readLine();
				System.out.println(strTheme);
				// Counting how many words are in the theme file
				TextInputFile theme = new TextInputFile(strTheme);
				while(theme.eof() == false){
					strWordTemp = theme.readLine();
					intWordCount = intWordCount + 1;
				}
				// close text file
				theme.close();
				// create array and reopen text file
				String strWords[][];
				strWords = new String[intWordCount][2];
				theme = new TextInputFile(strTheme);
				// load words from text file into a 2 dimensional array
				// with a corresponding random integer from 1 - 100
				for(intCount = 0; intCount < intWordCount; intCount++){
					strWords[intCount][0] = theme.readLine();
					intNumTemp = (int)(Math.random() * 100 + 1);
				}
			}else if(strMode.equalsIgnoreCase("v")){
				//print leaderboard
			}else if(strMode.equalsIgnoreCase("a")){
				//player makes theme name
				//player adds words to theme
			}else if(strMode.equalsIgnoreCase("q")){
				//close all files
				//clear screen
			}else if(strMode.equalsIgnoreCase("h")){
				// print help screen
				CPTAidanTools.helpScreen(con);
				strMode = con.readLine();
			}else if(strMode.equalsIgnoreCase("s")){
				// print secret menu
				CPTAidanTools.secretMenu(con);
				strMode = con.readLine();
			}else if(strMode.equalsIgnoreCase("r")){
				// return the player back to the main menu
				CPTAidanTools.mainMenu(con);
				strMode = con.readLine();
			}
		}
	}
}
