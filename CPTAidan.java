import arc.*;

public class CPTAidan{
	public static void main(String[] args){
		Console con = new Console();
		con.println("Enter a word");
		String strWord = con.readLine();
		String strLetter = strWord.substring(0,1);
		con.println("The first letter is: "+strLetter);
	}
}
