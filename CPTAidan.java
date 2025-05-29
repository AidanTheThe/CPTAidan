import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console("Hangman", 1280, 720);
		CPTAidanTools.mainMenu(con);
		System.out.println("Menu Loaded");
		String strModeInput;
		String strMode;
		strModeInput = con.readLine();
		strMode = strModeInput.substring(0,1);
	}
}
