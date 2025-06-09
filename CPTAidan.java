// Aidan Brown
// Hangman Game

import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console("Hangman", 1280, 720);
		
		// create/initialize variables
		boolean blnGameOver;
		blnGameOver = false;
		boolean blnPlayAgain;
		blnPlayAgain = true;
		boolean blnGameplayOn;
		blnGameplayOn = true;
		String strPlayAgain = "";
		int intWins = 0;
		String strTheme = "";
		String strWordTemp;
		String strNumTemp;
		String strLetterTemp;
		String strPositionTemp;
		String strRandomTemp;
		int intCount;
		int intCount2;
		int intRand;
		int intWordCount = 0;
		String strName = "";
		String strMode;
		String strWord;
		String strGuess;
		int intWordNum = 0;
		
		// load main menu and get the user's name	
		CPTAidanTools.mainMenu(con);
		strMode = con.readLine();
		con.clear();
		CPTAidanTools.loadingScreen(con);
		con.println("TEST2");
		con.sleep(3000);
		con.clear();
		
		// While loop that encases all code excluding startup menu and some variables
		while(blnGameOver == false){
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			// User enters name and selects theme
			if(strMode.equalsIgnoreCase("p")){
				con.clear();
				if(strName.equalsIgnoreCase("")){
					con.println("Enter your name");
					strName = con.readLine();
					con.clear();
				}
				CPTAidanTools.themeScreen(con);
				con.println("");
				strTheme = con.readLine();
				strTheme = strTheme + ".txt";
				System.out.println(strTheme);
				
				// Counting how many words are in the theme file
				TextInputFile theme = new TextInputFile(strTheme);
				intWordCount = 0;
				while(theme.eof() == false){
					strWordTemp = theme.readLine();
					System.out.println(strWordTemp);
					intWordCount = intWordCount + 1;
				}		
				// close text file
				theme.close();
				System.out.println("Word Count: "+intWordCount);
				
				// create array and reopen text file
				String strWords[][];
				strWords = new String[intWordCount][2];
				theme = new TextInputFile(strTheme);
				
				// load words from text file into a 2 dimensional array
				// with a corresponding random integer from 1 - 100
				for(intCount = 0; intCount < intWordCount; intCount++){
					strWords[intCount][0] = theme.readLine();
					System.out.println(strWords[intCount][0]);
					intRand = (int)(Math.random() * 100 + 1);
					strWords[intCount][1] = intRand + "";
				}	
				// close text file
				theme.close();
				System.out.println("Words have been loaded into the array");
				
				// bubble sort the rows from least to greatest			
				for(intCount2 = 0; intCount2 < intWordCount - 1; intCount2++){
					for(intCount = 0; intCount < intWordCount - 1; intCount++){
						if(Integer.parseInt(strWords[intCount][1]) > Integer.parseInt(strWords[intCount+1][1])){
							// swap words
							strWordTemp = strWords[intCount][0];
							strWords[intCount][0] = strWords[intCount+1][0];
							strWords[intCount+1][0] = strWordTemp;
							// swap numbers
							strNumTemp = strWords[intCount][1];
							strWords[intCount][1] = strWords[intCount+1][1];
							strWords[intCount+1][1] = strNumTemp;
						}
					}
				}			
				System.out.println("Words have been bubble sorted");
				
				// select a word and run game
				// unless the player inputs they do not want to play
				blnPlayAgain = true;
				for(intWordNum = 0; intWordNum < intWordCount && blnPlayAgain == true; intWordNum++){
					// Remove any coloured screens
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					// choosing a word
					strWord = strWords[intWordNum][0];
					// measuring the length of the word
					int intWordLength;
					intWordLength = strWord.length();
					// loading each letter into an array
					String strLetters[][];
					strLetters = new String[intWordLength][3];
					for(intCount = 0; intCount < intWordLength; intCount++){
						strLetters[intCount][0] = strWord.substring(intCount, intCount+1);
						strLetters[intCount][1] = intCount + 1 + "";
						intRand = (int)(Math.random() * 100 + 1);
						strLetters[intCount][2] = intRand + "";
					}
					
					// bubble sort the rows from least to greatest
					for(intCount2 = 0; intCount2 < intWordLength - 1; intCount2++){
						for(intCount = 0; intCount < intWordLength - 1; intCount++){
							if(Integer.parseInt(strLetters[intCount][2]) > Integer.parseInt(strLetters[intCount+1][2])){
								// swapping letters in row 0
								strLetterTemp = strLetters[intCount][0];
								strLetters[intCount][0] = strLetters[intCount+1][0];
								strLetters[intCount+1][0] = strLetterTemp;
								// swapping position numbers in row 1
								strPositionTemp = strLetters[intCount][1];
								strLetters[intCount][1] = strLetters[intCount+1][1];
								strLetters[intCount+1][1] = strPositionTemp;
								// swapping random numbers in row 2
								strRandomTemp = strLetters[intCount][2];
								strLetters[intCount][2] = strLetters[intCount+1][2];
								strLetters[intCount+1][2] = strRandomTemp;
							}
						}
					}
					
					blnGameplayOn = true;
					int intWrongCount;
					intWrongCount = 0;
					
					// loop for each round of the game
					while(intWrongCount < 6 && blnGameplayOn == true){
						// clear the screen
						con.clear();
						// print hangman drawing
						if(intWrongCount == 0){
							CPTAidanTools.drawing1(con);
						}else if(intWrongCount == 1){
							CPTAidanTools.drawing2(con);
						}else if(intWrongCount == 2){
							CPTAidanTools.drawing3(con);
						}else if(intWrongCount == 3){
							CPTAidanTools.drawing4(con);
						}else if(intWrongCount == 4){
							CPTAidanTools.drawing5(con);
						}else if(intWrongCount == 5){
							CPTAidanTools.drawing6(con);
						}
						con.println("");
						// since the letters are in a random order
						// this loop will reveal one random letter
						// for everytime the guesses the word wrong
						for(intCount = 1; intCount <= intWordLength; intCount++){
							for(intCount2 = 0; intCount2 < intWordLength; intCount2++){
								if(Integer.parseInt(strLetters[intCount2][1]) == intCount){
									if(intCount2 <= intWrongCount - 1){
										con.print(strLetters[intCount2][0] + " ");
									}else if(intCount2 > intWrongCount - 1){
										con.print("_ ");
									}
								}
							}
						}
						con.println("("+intWordLength+" letters)");
						con.println("");
						con.println("");
						con.println("");
						con.println("What is your guess?");
						strGuess = con.readLine();
						intWrongCount = intWrongCount + 1;
						
						// if the player guesses the correct word
						// show the win screen
						if(strGuess.equalsIgnoreCase(strWord)){
							blnGameplayOn = false;
							intWins = intWins + 1;
							intWrongCount = 0;
							System.out.println("WINS: "+intWins);
							con.clear();
							CPTAidanTools.winScreen(con);
							strPlayAgain = con.readLine();
							if(intWordNum >= intWordCount - 1){
								con.clear();
								con.setDrawColor(Color.BLACK);
								con.fillRect(0,0,1280,720);
								CPTAidanTools.noWordsScreen(con);
								con.println("3");
								con.sleep(1000);
								con.println("2");
								con.sleep(1000);
								con.println("1");
								con.sleep(1000);
								blnGameplayOn = false;
								blnPlayAgain = false;
								strMode = "r";
							}
							// if the player does not want to play again
							// return to the main menu
							if(strPlayAgain.equalsIgnoreCase("no")){
								intWrongCount = 0;
								TextOutputFile board = new TextOutputFile("leaderboard.txt", true);
								board.println(strName);
								board.println(intWins);
								board.close();
								blnPlayAgain = false;
								blnGameplayOn = false;
								strMode = "r";
							}
						}
					}
					// if they do not guess correctly after 6 attempts
					// fully draw the hangman
					
					if(intWrongCount == 6 && blnGameplayOn == true){
						con.clear();
						CPTAidanTools.drawing7(con);
						// and show the lose screen
						CPTAidanTools.loseScreen(con);
						con.println("");
						con.println("");
						con.println("The word was: "+strWord);
						con.println("");
						strPlayAgain = con.readLine();
						if(intWordNum >= intWordCount - 1){
							con.clear();
							con.setDrawColor(Color.BLACK);
							con.fillRect(0,0,1280,720);
							CPTAidanTools.noWordsScreen(con);
							con.println("3");
							con.sleep(1000);
							con.println("2");
							con.sleep(1000);
							con.println("1");
							con.sleep(1000);
							blnGameplayOn = false;
							blnPlayAgain = false;
							strMode = "r";
						}
						// if the player does not want to play again
						// return to the main menu
						if(strPlayAgain.equalsIgnoreCase("no")){
							intWrongCount = 0;
							TextOutputFile board = new TextOutputFile("leaderboard.txt", true);
							board.println(strName);
							board.println(intWins);
							board.close();
							blnPlayAgain = false;
							blnGameplayOn = false;
							strMode = "r";
						}
					}
				}
				
				// if there are no more words in the array
				// show the no more words screen
				// return to main menu
			}else if(strMode.equalsIgnoreCase("v")){
				// print a leaderboard including the name and wins of previous players
				CPTAidanTools.viewLeaderboard(con);
				strMode = con.readLine();
			}else if(strMode.equalsIgnoreCase("a")){
				// player makes theme name and adds words to theme
				CPTAidanTools.addTheme(con);
				strMode = con.readLine();
			}else if(strMode.equalsIgnoreCase("q")){
				// print game summary
				CPTAidanTools.gameSummary(con, strName, intWins, strTheme);
				blnGameOver = true;
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
			}else{
				// if the player inputs a mode that is not a valid input
				// display an error message
				con.println("Error: Invalid Input - Try Again");
				strMode = con.readLine();
			}
		}
	}
}
