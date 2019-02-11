package day5;
import java.io.IOException;

import textfiles.FileData;

public class Task1_ChemicalRecursion {
	public static void main(String[] args) throws IOException{
		FileData fileData = new FileData("C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar5\\day5\\text5.txt");
		//String result = ChemicalRecursion(fileData.DataArray[0],0);
		int min=100000;
		for (int i = 65; i <= 90; i++) 
		{
		    String trimedInput = removeCharFromString(fileData.DataArray[0],(char)i);		
		
			int startPos=0;		
			StringBuilder input=new StringBuilder(trimedInput);	
			
			while(true)
			{
				if(startPos+3 > input.length())	
					break;
				
				char char1 = input.charAt(startPos);
				char char2 = input.charAt(startPos+1);
				char char1_upper = Character.toUpperCase(char1);
				char char2_lower = Character.toLowerCase(char2);
				char char1_lower = Character.toLowerCase(char1);
				char char2_upper = Character.toUpperCase(char2);
				
				if((char1 == char2_lower && char2 == char1_upper) || (char1 == char2_upper && char2 == char1_lower))
				{
					input = input.delete(startPos, startPos+2);
					startPos=0;
					//System.out.println("Deleted: "+char1 +" "+char2);
				}
				else
					startPos++;
				
			}
			System.out.println((char)i+"\t"+input.length());
			min=Math.min(min,input.length());
		}
		System.out.println(min);
	}
	static String removeCharFromString(String input,char replaceChar)
	{
		String replace_Char = Character.toString(replaceChar);
		
		String returnString = input.replace(replace_Char, "");
		returnString = returnString.replace(replace_Char.toLowerCase(), "");
		return returnString;
	}
}
