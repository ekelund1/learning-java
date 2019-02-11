package day1;
import java.io.IOException;
import java.util.*;

import textfiles.FileData;

//Task 2 is to compute the first repeated number the list get to.
//https://adventofcode.com/2018/day/1#part2
//This one takes about 1 min to compute.
public class task2 {
	public static void main(String[] args) throws IOException{
		String filePath = "C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar1\\day1\\task1.txt";
		FileData fileData = new FileData(filePath);		
		int frequencyCounter = 0;
		Stack<Integer> visitedFreq = new Stack<Integer>();
		int i=0;
		
		while(true) {			
			int rowNumber = Integer.parseInt(fileData.DataArray[i].substring(1));
			
			switch(fileData.DataArray[i].charAt(0)) {
			case '+':
				frequencyCounter += rowNumber;
				break;
			case '-':
				frequencyCounter -= rowNumber;
				break;
			
			}
			if(visitedFreq.search(frequencyCounter) > -1) {
				//System.out.println(Integer.toString(frequencyCounter) +" duplicates in stack: "+visitedFreq.search(frequencyCounter));
				break;
			}				
			else
			{
				//System.out.println(Integer.toString(frequencyCounter) +" duplicates in stack: "+visitedFreq.search(frequencyCounter));
				visitedFreq.push(frequencyCounter);
			}
			i++;
			i=i%fileData.DataArray.length;
			
		}
		System.out.println("The first twice visited frequency is: "+ Integer.toString(frequencyCounter));
	}

}
