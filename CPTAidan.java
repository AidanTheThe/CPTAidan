import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console("Hangman", 1280, 720);
		CPTAidanTools.mainMenu(con);
		boolean blnGameOver;
		blnGameOver = false;
		boolean blnPlayAgain;
		blnPlayAgain = true;
		String strTheme;
		String strWordTemp;
		String strNumTemp;
		String strLetterTemp;
		String strPositionTemp;
		String strRandomTemp;
		String strTempPosition;
		String strTempLetter;
		int intCount;
		int intCount2;
		int intRand;
		int intWordCount = 0;
		String strName;
		String strMode;
		strMode = con.readLine();
		String strWord;
		int intWordNum = 0;
		
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
				strTheme = strTheme + ".txt";
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
					intRand = (int)(Math.random() * 100 + 1);
					strWords[intCount][1] = intRand + "";
				}
				// bubble sort the rows from least to greatest
				for(intCount2 = 0; intCount < intWordCount - 1; intCount++){
					for(intCount = 0; intCount < intWordCount; intCount++){
						if(Integer.parseInt(strWords[intCount][1]) > Integer.parseInt(strWords[intCount+1][1])){
							// swapping strings in row 0
							strWordTemp = strWords[intCount][0];
							strWords[intCount][0] = strWords[intCount+1][0];
							strWords[intCount+1][0] = strWordTemp;
							// swapping integers in row 1
							strNumTemp = strWords[intCount][1];
							strWords[intCount][1] = strWords[intCount+1][1];
							strWords[intCount+1][1] = strNumTemp;
						}
					}
				}
				// select a word and run game
				// unless the player inputs they do not want to play
				while(blnPlayAgain == true){
					for(intWordNum = 0; intWordNum < intWordCount; intWordNum++){
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
							strLetters[intCount][1] = intCount + "";
							intRand = (int)(Math.random() * 100 + 1);
							strLetters[intCount][2] = intRand + "";
						}
						// bubble sort the rows from least to greatest
						for(intCount2 = 0; intCount < intWordLength - 1; intCount2++){
							for(intCount = 0; intCount < intWordLength; intCount++){
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
									strLetters[intCount][2] = strLetters[intCount+1][0];
									strLetters[intCount+1][2] = strRandomTemp;
								}
							}
						}
						int intWrongCount;
						for(intWrongCount = 0; intWrongCount <= 6; intWrongCount++){
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
							}else if(intWrongCount == 6){
								CPTAidanTools.drawing7(con);
							}
							con.println("");
							for(intCount = 0; intCount < intWordLength; intCount++){
								for(intCount2 = 0; intCount2 < intWordLength; intCount2++){
								}
							}
						}
						// print "_ " if the row number > intCount
						// print the letter if the row number < intCount
						// ask if the player wants to play again
						// if they choose yes, the loop starts again
						// if they choose no, blnPlayAgain = false, while loop ends, strMode = r
					}
					// if blnPlayAgain = true
					// print no more words left message
					// blnPlayAgain = false, prompt user to type r to return to main menu
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
