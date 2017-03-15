import java.io.*;

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int listSize;

	public LinkedList(){
		
	}
	public void addToTail(String dataValue){
		if(head == null){
			head = new Node(dataValue);
			listSize = 1;
		}
		else if(tail == null){
			tail = new Node(dataValue);
			head.setNext(tail);
			head.setPrev(tail);
			tail.setPrev(head);
			tail.setNext(head);
			listSize ++;
		}else{
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
	public void addToHead(String dataValue){
		if(head == null){
			head = new Node(dataValue);
			listSize = 1;
		}
		else if(tail == null){
			Node temp = head;
			tail = new Node(temp.getData());
			head.setData(dataValue);
			head.setNext(tail);
			head.setPrev(tail);
			tail.setPrev(head);
			tail.setNext(head);
			listSize ++;
		}else{
			Node oldHead = new Node(head.getData());
			oldHead.setPrev(head);
			oldHead.setNext(head.getNext());
			head.getNext().setPrev(oldHead);
			head.setData(dataValue);
			head.setNext(oldHead);
			listSize ++;
		}
	}
	
	public void addBeforeIndex(int index, String dataValue){
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
			if(listSize == 1 || listSize == 2 || currentNode == head){
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
	
	public void addAfterIndex(int index, String dataValue){
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
			if(listSize == 1 || listSize == 2 || currentNode == tail){
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
	
	public void remove(int index){
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
			if(listSize == 1){
				head = null;
			}
			else if(listSize == 2){
				if (currentNode == head){
					head = tail;
				}
				tail = null;
				head.setNext(null);
				head.setPrev(null);
			}else if (currentNode == head){
				currentNode = head.getNext();
				currentNode.setPrev(tail);
				head = currentNode;
			}else if(currentNode == tail){
				currentNode = tail.getPrev();
				currentNode.setNext(head);
				tail = currentNode;
			}else{
				currentNode.getNext().setPrev(currentNode.getPrev());
				currentNode.getPrev().setNext(currentNode.getNext());
			}
			listSize--;
		}
	}
	public String toString(){
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
	
	private class Node{
		Node next;
		Node prev;
		String data;
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
