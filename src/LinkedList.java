/*
This is the LinkedList class. The main function of the LinkedList class is to
make changes to the nodes inside the list. It also has a private node class which
are the nodes inside the list.
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

//LinkedList Class
public class LinkedList {
	
	private Node head;							//Head node of the list
	private Node tail;							//Tail node of the list
	private int listSize;						//Size of the list

	public LinkedList(){						
		
	}
	public void addToTail(String dataValue){			//Adds a new node to the back of tail of the list
		if(head == null){								//Initial node
			head = new Node(dataValue);
			listSize = 1;
		}
		else if(tail == null){							//Initial tail
			tail = new Node(dataValue);
			head.setNext(tail);
			head.setPrev(tail);
			tail.setPrev(head);
			tail.setNext(head);
			listSize ++;
		}else{											//Head and tail exists
			String newTailValue = dataValue;
			Node oldTail = new Node(tail.getData());
			oldTail.setPrev(tail.getPrev());
			oldTail.setNext(tail);
			tail.getPrev().setNext(oldTail);
			tail.setData(dataValue);
			tail.setPrev(oldTail);
			listSize ++;
		}
	}
	public void addToHead(String dataValue){			//Adds a new ode to the front of the head of the list
		if(head == null){								//Initial node
			head = new Node(dataValue);
			listSize = 1;
		}
		else if(tail == null){							//Initial tail
			Node temp = head;
			tail = new Node(temp.getData());
			head.setData(dataValue);
			head.setNext(tail);
			head.setPrev(tail);
			tail.setPrev(head);
			tail.setNext(head);
			listSize ++;
		}else{											//Head and tail exists
			Node oldHead = new Node(head.getData());
			oldHead.setPrev(head);
			oldHead.setNext(head.getNext());
			head.getNext().setPrev(oldHead);
			head.setData(dataValue);
			head.setNext(oldHead);
			listSize ++;
		}
	}
	
	public void addBeforeIndex(int index, String dataValue){		//Adds a new node to the front of an index
		if(index < 1 || index > listSize){
			System.out.println("Invalid Index");
		}else{
			Node currentNode = head;
			for(int i = 1; i < index; i++){
				if(currentNode.getNext() == null){
					System.out.println("Broken link.");
				}
				currentNode = currentNode.getNext();
			}
			if(listSize == 1 || listSize == 2 || currentNode == head){	//The same as adding to the front of the head
				addToHead(dataValue);									
			}else{
				Node newNode = new Node(dataValue);
				newNode.setNext(currentNode);
				newNode.setPrev(currentNode.getPrev());
				currentNode.getPrev().setNext(newNode);
				currentNode.setPrev(newNode);
			}
			listSize++;
		}
	}
	
	public void addAfterIndex(int index, String dataValue){				//Adds a new node to the back of an index
		if(index < 1 || index > listSize){
			System.out.println("Invalid Index");
		}else{
			Node currentNode = head;
			for(int i = 1; i < index; i++){
				if(currentNode.getNext() == null){
					System.out.println("Broken link.");
				}
				currentNode = currentNode.getNext();
			}
			if(listSize == 1 || listSize == 2 || currentNode == tail){	//The same as adding to the back of the tail
				addToTail(dataValue);
			}else{
				Node newNode = new Node(dataValue);
				newNode.setPrev(currentNode);
				newNode.setNext(currentNode.getNext());
				currentNode.getNext().setPrev(newNode);
				currentNode.setNext(newNode);
			}
			listSize++;
		}
	}
	
	public void remove(int index){										//Removes a node
		if(index < 1 || index > listSize){
			System.out.println("Could not find that index.");
		}else{
			Node currentNode = head;
			for(int i = 1; i < index; i++){
				if(currentNode.getNext() == null){
					System.out.println("Broken link.");
				}
				currentNode = currentNode.getNext();
			}
			if(listSize == 1){											//Last node
				head = null;
			}
			else if(listSize == 2){										//Tail is removed
				if (currentNode == head){
					head = tail;
				}
				tail = null;
				head.setNext(null);
				head.setPrev(null);
			}else if (currentNode == head){								//Head is removed
				currentNode = head.getNext();							
				currentNode.setPrev(tail);
				head = currentNode;										//Set new head
			}else if(currentNode == tail){								//Tail is removed
				currentNode = tail.getPrev();
				currentNode.setNext(head);
				tail = currentNode;										//Set new tail
			}else{
				currentNode.getNext().setPrev(currentNode.getPrev());	//Delete reference to deleted node
				currentNode.getPrev().setNext(currentNode.getNext());	//Delete reference to deleted node
			}
			listSize--;
		}
	}
	public String toString(){											//Iterate through list and get data as String
		StringBuilder msg = new StringBuilder();
		if(head != null){
			msg.append(head.getData());
			Node nextN = head.getNext();
			while(nextN != null && nextN != tail){
				msg.append(System.lineSeparator() + nextN.getData());
				nextN = nextN.getNext();
			}
			if(tail != null){
				msg.append(System.lineSeparator() + tail.getData());
			}
		}
		return msg.toString();
	}
	
	private class Node{											//Node class
		Node next;												//Next node
		Node prev;												//Previous node
		String data;											//Data stored as string
		public Node(String dataValue){
			next = null;
			data = dataValue;
		}
		
		public String getData(){
			return data;
		}
		public void setData(String dataValue){
			data = dataValue;
		}
		public Node getNext(){
			return next;
		}
		public void setNext(Node nextN){
			next = nextN;
		}
		public Node getPrev(){
			return prev;
		}
		public void setPrev(Node prevN){
			prev = prevN;
		}
	}
	
}
