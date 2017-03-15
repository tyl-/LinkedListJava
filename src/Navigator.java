//imports
import java.io.*;

public class Navigator {
	public static void main(String a[]) throws IOException {
		System.out.println("Welcome to the Java Linked List Program.");
		LinkedList currentLL = new LinkedList();
		FileManager fileManager = new FileManager(currentLL);
		String userInput;
		BufferedReader br = null;
		try{
			while(true){
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
				switch(userInput){
					case "1":
						System.out.println(currentLL.toString());
						break;
					case "2":
						System.out.println("Enter data:");
						br = new BufferedReader(new InputStreamReader(System.in));
						currentLL.addToHead(br.readLine());
						fileManager.updateFile(currentLL);
						break;
					case "3":
						System.out.println("Enter data:");
						br = new BufferedReader(new InputStreamReader(System.in));
						currentLL.addToTail(br.readLine());
						fileManager.updateFile(currentLL);
						break;
					case "4":
						System.out.println("Enter index:");
						br = new BufferedReader(new InputStreamReader(System.in));
						idx = Integer.parseInt(br.readLine());
						System.out.println("Enter data:");
						currentLL.addBeforeIndex(idx, br.readLine());
						fileManager.updateFile(currentLL);
						break;
					case "5":
						System.out.println("Enter index:");
						br = new BufferedReader(new InputStreamReader(System.in));
						idx = Integer.parseInt(br.readLine());
						System.out.println("Enter data:");
						currentLL.addAfterIndex(idx, br.readLine());
						fileManager.updateFile(currentLL);
						break;
					case "6":
						System.out.println("Enter index:");
						br = new BufferedReader(new InputStreamReader(System.in));
						currentLL.remove(Integer.parseInt(br.readLine()));
						fileManager.updateFile(currentLL);
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
