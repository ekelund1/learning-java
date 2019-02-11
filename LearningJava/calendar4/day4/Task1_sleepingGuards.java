package day4;
import textfiles.FileData;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Task1_sleepingGuards {
	
	static class Guard{
		int GuardID;
		int Total_Sleep_Min;
		int[] Sleep_Min;
		public Guard(int guardID)
		{
			GuardID=guardID;
			Total_Sleep_Min=0;
			Sleep_Min = new int[60];
		}
		@Override
		public boolean equals(Object o)
		{
			if (this == o)
				return true;
			else if(o instanceof Integer && this.GuardID ==(Integer)o)
				return true;
			else if(o instanceof Guard && this.GuardID == ((Guard) o).GuardID)		
				return true;		
			return false;
		}
		public int GetMostCommonSleepMin()
		{
			int value=0;
			int returnID=0;
			for(int i=0;i<Sleep_Min.length;i++)
			{
				value=Math.max(value, Sleep_Min[i]);
				if(value == Sleep_Min[i])
					returnID=i;
			}
			return returnID;
			
		}
		public int GetMostCommonSleepValue()
		{
			int value=0;
			int returnID=0;
			for(int i=0;i<Sleep_Min.length;i++)
			{
				value=Math.max(value, Sleep_Min[i]);
				if(value == Sleep_Min[i])
					returnID=i;
			}
			return value;
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		FileData fileData = new FileData("C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar4\\day4\\text4.txt");		
		Arrays.sort(fileData.DataArray);
		ArrayList<Guard> GuardList = new ArrayList<>();
		
		int ActiveGuard=-1;		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		int previousDateTime = 0;
		
		for(int i=0;i<fileData.DataArray.length;i++)
		{
			//Checks if it's a guard row
			if(fileData.DataArray[i].contains("Guard #"))
			{
				//If the list does not have a Guard by the same ID. Add a new guard.
				int guardID = Integer.parseInt(fileData.DataArray[i].substring(fileData.DataArray[i].indexOf('#')+1).replaceAll("\\D+",""));
				if(!GuardList.contains(new Guard(guardID)))
					GuardList.add(new Guard(guardID));
				ActiveGuard = GuardList.indexOf(new Guard(guardID));
				
				previousDateTime = Integer.parseInt((fileData.DataArray[i].substring(fileData.DataArray[i].indexOf(':')+1, fileData.DataArray[i].indexOf(']'))));
				
			
			}
			else
			{
				int currentDateTime = Integer.parseInt(fileData.DataArray[i].substring(fileData.DataArray[i].indexOf(':')+1, fileData.DataArray[i].indexOf(']')));
				
				if(fileData.DataArray[i].contains("falls asleep"))
				{				
					previousDateTime = currentDateTime;
				}
				else if(fileData.DataArray[i].contains("wakes up"))
				{
					int SleepTime =  (currentDateTime - previousDateTime)%60;
					GuardList.get(ActiveGuard).Total_Sleep_Min += SleepTime;
					for(int j=0;j<SleepTime;j++)					
						GuardList.get(ActiveGuard).Sleep_Min[previousDateTime+j]+=1;					
					previousDateTime = currentDateTime;
				}
				
			}
		
		}
		Iterator<Guard> iterator = GuardList.iterator();
		while(iterator.hasNext())
		{
			Guard g = iterator.next();
			System.out.println("Guard #"+g.GuardID + "\tSleep time: "+g.Total_Sleep_Min + "\tOccurance:"+g.GetMostCommonSleepValue()+"\tMinuite:"+g.GetMostCommonSleepMin());
		}
		System.out.println("A: Guard with most hours asleep is #1021. Sleep time is 539 min. Their min most asleep was min 30. With an occurance of 14");
		System.out.println("B: Guard with most occurance of same min is #3331. Their most asleep was min 41. With an occurance of 17");

}
 
}
