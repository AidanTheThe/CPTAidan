import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console("Hangman", 1280, 720);
		CPTAidanTools.mainMenu(con);
		System.out.println("Menu Loaded");
		boolean blnProgramRunning = true;
		String strModeInput;
		String strMode;
		strModeInput = con.readLine();
		strMode = strModeInput.substring(0,1);
		
		if(strMode.equalsIgnoreCase("p")){
			//load themes
			//load game
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
		}
	}
}
