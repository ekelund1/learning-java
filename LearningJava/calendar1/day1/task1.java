package day1;
import java.io.IOException;

import textfiles.FileData;

//Task 1 is to compute the final number from a series of numbers.
//Each number is on a different row and each line starts with either a + or a -
public class task1 {
	public static void main(String[] args) throws IOException{
		String filePath = "C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar1\\day1\\task1.txt";
		FileData fileData = new FileData(filePath);		
		int counter = 0;
		
		for(int i=0;i<fileData.DataArray.length;i++) {
			int rowNumber = Integer.parseInt(fileData.DataArray[i].substring(1));
			switch(fileData.DataArray[i].charAt(0)) {
			case '+':
				counter += rowNumber;
				break;
			case '-':
				counter -= rowNumber;
				break;
			}
		}		
		
		System.out.println("Frequency is: "+ Integer.toString(counter));
	}

}
