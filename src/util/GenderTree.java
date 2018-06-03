package util;

import java.util.LinkedList;

import library.*;


public class GenderTree extends BinaryTree {

	public GenderTree(){
		super();
	}
	
	public void addLinkToBook(String genderName, Book book){
		addLinkToBook(new Gender(genderName), root, book);			
	}

	private void addLinkToBook(Gender gender, Node node, Book book) {
		
		Gender currentGender = (Gender)node.getObject();
		
		if(node.isEmpty()){
			node.setObject(gender);
			node.setLeft(new Node());
			node.setRight(new Node());
			gender.addBook(book);	
		}
		else{
			if(currentGender.compareTo(gender) != 0){
				if(node.getObject().compareTo(gender) > -1){
					addLinkToBook(gender, node.getLeft(), book);
				}
				else{
					addLinkToBook(gender, node.getRight(), book);
				}
			}
			else{
				currentGender.addBook(book);
			}
		}
	}

	public LinkedList<Book> getBookList(String genderName) {
		
		return getBookList(genderName, root);
	}


	private LinkedList<Book> getBookList(String genderName,Node node) {
		
		if(node.isEmpty()){
			return null; // No existe genero con ese nombre
		}
		else{
			Gender currentGender = (Gender)node.getObject();	
			if(currentGender.equals(genderName)){  // Encontre el genero, retorno lista
				return currentGender.getbooks();
			}
			else{
				if(currentGender.compareTo(genderName) > -1){
					return getBookList(genderName, node.getLeft());
				}
				else{
					return getBookList(genderName, node.getRight());
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		GenderTree gt = new GenderTree();
		

		
		gt.printInOrder();
		
	}

	
	
}

