/*
This is the Navigator class. The main function of this is to create
an instance of the linked list, and fileManager and then communicate with
the user through the command line interface.
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

//imports
import java.io.*;

//Navigator class
public class Navigator {
	
	//Main function
	public static void main(String a[]) throws IOException {
		System.out.println("Welcome to the Java Linked List Program.");			
		LinkedList currentLL = new LinkedList();								//Create instance of linkedlist
		FileManager fileManager = new FileManager(currentLL);					//Create instance of filemanager
		String userInput;
		BufferedReader br = null;
		try{
			while(true){														//Menu loop
				System.out.println("What would you like to do?");
				System.out.println("1. Show list");
				System.out.println("2. New head");
				System.out.println("3. New tail");
				System.out.println("4. Add before node");
				System.out.println("5. Add after node");
				System.out.println("6. Remove node");
				System.out.println("7. Quit");
				br = new BufferedReader(new InputStreamReader(System.in));
				userInput = br.readLine();
				int idx;
				switch(userInput){														//User input handler
					case "1":
						System.out.println(currentLL.toString());						//Print out current linked list
						break;
					case "2":
						System.out.println("Enter data:");
						br = new BufferedReader(new InputStreamReader(System.in));		
						currentLL.addToHead(br.readLine());								//Change the 'head' of the list
						fileManager.updateFile(currentLL);								//Update text file
						break;
					case "3":
						System.out.println("Enter data:");
						br = new BufferedReader(new InputStreamReader(System.in));
						currentLL.addToTail(br.readLine());								//Change the 'tail' of the list
						fileManager.updateFile(currentLL);								//Update text file
						break;
					case "4":
						System.out.println("Enter index:");
						br = new BufferedReader(new InputStreamReader(System.in));
						idx = Integer.parseInt(br.readLine());
						System.out.println("Enter data:");
						currentLL.addBeforeIndex(idx, br.readLine());					//Add to the list before an index
						fileManager.updateFile(currentLL);								//Update text file
						break;
					case "5":
						System.out.println("Enter index:");
						br = new BufferedReader(new InputStreamReader(System.in));
						idx = Integer.parseInt(br.readLine());
						System.out.println("Enter data:");
						currentLL.addAfterIndex(idx, br.readLine());					//Add to the list after an index
						fileManager.updateFile(currentLL);								//Update text file
						break;
					case "6":
						System.out.println("Enter index:");
						br = new BufferedReader(new InputStreamReader(System.in));
						currentLL.remove(Integer.parseInt(br.readLine()));				//Remove a node
						fileManager.updateFile(currentLL);								//Update text file
						break;
					case "7":
						return;
					default:
						System.out.println("Invalid choice");
						break;
				}
			}
		}catch(IOException ioe){
			ioe.getMessage();
		}
		
	}
	

}
