import java.io.*;
import java.util.Arrays;

public class FileManager {
	FileManager(LinkedList ll){
		loadFile(ll);
	}
	private void loadFile(LinkedList ll){
		try{
			FileReader fr = new FileReader("DataFiles/LL.txt");
			BufferedReader br = new BufferedReader(fr);
			String temp = null;
			while((temp = br.readLine()) !=null){
				ll.addToTail(temp);
			}
			br.close();
			fr.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}
	public void updateFile(LinkedList ll){
		try{
			FileWriter fw = new FileWriter("Datafiles/LL.txt");
			fw.write(ll.toString());
			fw.flush();
			fw.close();
		}catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
		
	}
}
