package day3;
import textfiles.FileData;
import java.io.IOException;

public class Task1_fabricAndCoordinates {

	public static void main(String[] args) throws IOException{
		FileData fileData = new FileData("C:\\Users\\je936209\\eclipse-workspace\\LearningJava\\calendar3\\day3\\text3.txt");		
		Claim[] AllClaims = new Claim[fileData.DataArray.length];
		int[][] EntireFabric = new int[1000][1000];
		for(int i = 0; i<fileData.DataArray.length;i++)
		{
			AllClaims[i] = new Claim(fileData.DataArray[i]);			
			EntireFabric = AllClaims[i].PlaceClaim(EntireFabric);
		}
		
		int MultipleClaimedAreas=0;
		for(int i = 0;i<1000;i++) {
			for(int j = 0;j<1000;j++) {
				if(EntireFabric[i][j] > 1)
					MultipleClaimedAreas++;
			}
		}
		System.out.println("MultipleClaimedAreas: "+MultipleClaimedAreas);	
		
		
		for(int i=0;i<AllClaims.length;i++)
		{
			if(!AllClaims[i].CheckUnique(EntireFabric))
				System.out.println("Unique Claim: "+AllClaims[i].ClaimID);	

		}
	}
}
class Claim{
	int ClaimID;
	int posX;
	int posY;
	int Width;
	int Height;
	public Claim(String input)
	{
		ClaimID = Integer.parseInt(input.substring(input.indexOf('#')+1,input.indexOf('@')).trim());
		posX = Integer.parseInt(input.substring(input.indexOf('@')+1,input.indexOf(',')).trim());		
		posY = Integer.parseInt(input.substring(input.indexOf(',')+1,input.indexOf(':')).trim());
		Width = Integer.parseInt(input.substring(input.indexOf(':')+1,input.indexOf('x')).trim());
		Height = Integer.parseInt(input.substring(input.indexOf('x')+1).trim());
		
	}
	public Claim()
	{}
	public int[][] PlaceClaim(int[][] fabric)
	{
		for(int i = 0; i<Width;i++) {
			for(int j = 0; j<Height;j++) {
				fabric[posX+i][posY+j]+=1;
			}
		}
		return fabric;
	}
	public Boolean CheckUnique(int[][] fabric)
	{
		Boolean multipleClaims=false;
		for(int i = 0; i<Width;i++) {
			for(int j = 0; j<Height;j++) {
				if(fabric[posX+i][posY+j]!=1)
					multipleClaims=true;
					
			}
		}
		return multipleClaims;		
	}
}

 