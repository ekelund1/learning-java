package day2;
import java.io.IOException;
import textfiles.FileData;

public class Task1_duplicateLetters {

	public static void main(String[] args) throws IOException{
		FileData fileData = new FileData("C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar2\\day2\\text2.txt");
		int Counter_Twice=0;
		int Counter_Thrice=0;
		int Increment_Twice=0;
		int Increment_Thrice=0;
		
		
		for(int i=0;i<fileData.DataArray.length;i++) {	
			for(int j=0;j<fileData.DataArray[i].length();j++) {
				char checkThisChar = fileData.DataArray[i].charAt(j);
				long count = fileData.DataArray[i].chars().filter(ch -> ch == checkThisChar).count();
				if(count == 2)
					Increment_Twice=1;
				else if(count==3)
					Increment_Thrice=1;
			}			
			Counter_Twice+=Increment_Twice;
			Counter_Thrice+=Increment_Thrice;
			Increment_Twice=0;
			Increment_Thrice=0;
		}
		int checkSum = Counter_Twice * Counter_Thrice;
		System.out.println("Checksum is "+Counter_Twice+" * "+ Counter_Thrice+" = " + checkSum);
		
	}
}