import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console("Hangman", 1280, 720);
		CPTAidanTools.mainMenu(con);
		boolean blnGameOver;
		blnGameOver = false;
		String strTheme;
		String strMode;
		strMode = con.readLine();
		while(blnGameOver == false){
			if(strMode.equalsIgnoreCase("p")){
				CPTAidanTools.clearScreen(con);
				CPTAidanTools.themeScreen(con);
				strTheme = con.readLine();
				System.out.println(strTheme);
			}else if(strMode.equalsIgnoreCase("v")){
				//print leaderboard
			}else if(strMode.equalsIgnoreCase("a")){
				//player makes theme name
				//player adds words to theme
			}else if(strMode.equalsIgnoreCase("q")){
				//close all files
				//clear screen
			}else if(strMode.equalsIgnoreCase("h")){
				CPTAidanTools.helpScreen(con);
				strMode = con.readLine();
			}else if(strMode.equalsIgnoreCase("s")){
				CPTAidanTools.secretMenu(con);
				strMode = con.readLine();
			}else if(strMode.equalsIgnoreCase("r")){
				CPTAidanTools.mainMenu(con);
				strMode = con.readLine();
			}
		}
	}
}
