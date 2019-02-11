package textfiles;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileData {
	
	private String FilePath;
	public String[] DataArray;
	
	public FileData (String filePath) throws IOException{
		FilePath = filePath;
		DataArray = new String[FileLength()];
		DataArray = OpenFile();
	}
	
	public String[] OpenFile() throws IOException{
		FileReader fileReader = new FileReader(FilePath);
		BufferedReader textReader = new BufferedReader(fileReader);		
		
		int numberOfLines = FileLength();
		
		String[] textData = new String[numberOfLines];
		
		for(int i=0;i<numberOfLines;i++) {
			textData[i] = textReader.readLine();
		}
		textReader.close();
		
		return textData;
	}
	
	int FileLength() throws IOException{
		FileReader fileReader = new FileReader(FilePath);
		BufferedReader textReader = new BufferedReader(fileReader);		
		
		int numberOfLines=0;
		while((textReader.readLine() != null)) {
			numberOfLines++;
		}
		textReader.close();
		return numberOfLines;
	}
	void Sort()
	{
		
	}
}
