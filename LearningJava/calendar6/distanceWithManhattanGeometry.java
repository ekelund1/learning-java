import java.io.IOException;
import textfiles.FileData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class distanceWithManhattanGeometry {
	public static void main(String[] args) throws IOException{
		FileData fileData = new FileData("C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar6\\text6.txt");
		int x=0,y=0;
		ArrayList<Location> LocationList = new ArrayList<Location>();
		int[][] coordinates = new int[x][y];
		for(int i=0;i<fileData.DataArray.length;i++)
		{
			String[] input = fileData.DataArray[i].split(",");
			x = Math.max(x, Integer.parseInt(input[0].trim()));
			y= Math.max(y, Integer.parseInt(input[1].trim()));
			Location location = new Location(Integer.parseInt(input[0].trim()),Integer.parseInt(input[1].trim()),i);
			LocationList.add(location);
		}
		
		
		
		
		
	}
	int[][] PlaceArea(int [][] coordinates,Location location, int distance)
	{
		for(int i=0;i<distance;i++)
		{
			if(coordinates[location.posX][location.posY] == location.id)
			{
				
			}
		}
		
		for(int i=0;i<distance;i++){
			for(int j=0;j<distance*4;j++) {
				
			}			
		}
		return coordinates;
	}
	static class Location{
		int posX;
		int posY;
		int id;
		public Location(int x, int y, int ID=0)
		{
			posX=x;
			posY=y;
			id=ID;
		}
	}
}
