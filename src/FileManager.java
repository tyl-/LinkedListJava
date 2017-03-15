/*
This is the FileManager class. The Main function of this class is to read
and write to the text file. It will read from a text file and update a
linked list. It will take a linked list's data and create a text file from
it.
*/

/*
MIT License

Copyright (c) 2017 Loyd Maverick Ty

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

//Imports
import java.io.*;
import java.util.Arrays;

//File Manager Class
public class FileManager {
	FileManager(LinkedList ll){
		loadFile(ll);												//Loads default linked list from a text file
	}
	private void loadFile(LinkedList ll){							//Reads from text file
		try{
			FileReader fr = new FileReader("DataFiles/LL.txt");
			BufferedReader br = new BufferedReader(fr);
			String temp = null;
			while((temp = br.readLine()) !=null){
				ll.addToTail(temp);									//Updates linked list
			}
			br.close();
			fr.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}
	public void updateFile(LinkedList ll){							//Writes to text file
		try{
			FileWriter fw = new FileWriter("Datafiles/LL.txt");
			fw.write(ll.toString());								//Takes data from linked list
			fw.flush();
			fw.close();
		}catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
		
	}
}
