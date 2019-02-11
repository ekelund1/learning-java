package day2;
import textfiles.FileData;
import java.io.IOException;

public class Task2_findLetterMatch {

	public static void main(String[] args) throws IOException{
		FileData fileData = new FileData("C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar2\\day2\\text2.txt");		
		String MatchingBoxID="";
		
		for(int i=0;i<fileData.DataArray.length;i++) {
			for(int j=0;j<fileData.DataArray[i].length();j++) {
				
				if (CompareCharDifferense(fileData.DataArray[i],fileData.DataArray[j])== 1)
				{							
					MatchingBoxID = RemoveNonDuplicateLetters(fileData.DataArray[i],fileData.DataArray[j]);
					System.out.println("CorrectBoxID is: "+MatchingBoxID+" The matched IDs are: "+fileData.DataArray[i]+" and "+fileData.DataArray[j]);

				}
			}
		}
		System.out.println("CorrectBoxID is: "+MatchingBoxID);
	}
	
	public static String RemoveNonDuplicateLetters(String str1, String str2)
	{
		String returnString = "";		
		for(int i = 0;i<str1.length();i++)
		{
			if(str1.charAt(i)==str2.charAt(i))
				returnString+=str1.charAt(i);
		}		
		return returnString;
	}
	public static int CompareCharDifferense(String str1, String str2)
	{
		int charDiff = 0;		
		for(int i = 0;i < str1.length();i++)
		{
			if(str1.charAt(i)!=str2.charAt(i))
				charDiff+=1;
		}
		return charDiff;
	}
}