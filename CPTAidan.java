import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console("Hangman", 1280, 720);
		CPTAidanTools.mainMenu(con);
		System.out.println("Menu Loaded");
		String strModeInput;
		strModeInput = con.readLine();
	}
}
