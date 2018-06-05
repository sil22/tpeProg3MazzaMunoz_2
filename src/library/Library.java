package library;

import java.util.*;

//import com.sun.corba.se.impl.orbutil.graph.Graph;

import searchStats.Vertex;
import util.*;


public class Library {
	
	BookList books;
	GenderTree genderIndex;
	
	public Library(){
		books = new BookList();
		genderIndex = new GenderTree();
	}
		
	public BookList getBooks() {
		return books;
	}

	public void setBooks(BookList books) {
		this.books = books;
	}

	public GenderTree getGenderIndex() {
		return genderIndex;
	}

	public void setGenderIndex(GenderTree genderIndex) {
		this.genderIndex = genderIndex;
	}


	public void addBook(String [] items){
		
		String[] genders = items[3].split(" ");
		Book book = new Book(items[0], items[1], items[2], genders);
		addLinkToBook(genders,book);
		books.insert(book);
	}

	private void addLinkToBook(String[] genders, Book book) {
		
		for (String gender : genders) {
			genderIndex.addLinkToBook(gender, book);
		}
	}
	
	public LinkedList<Book> searchBooks(String gender) {
		return genderIndex.getBookList(gender);
	}
	
	// sevicio 0 retornar los libros que cumplan con todos los generos
	public LinkedList<Book> searchBooks(LinkedList<String> genderList){

		LinkedList<Book> searchResult = new LinkedList<Book>();
		Book currentBook; 

		for (int i = 0; i < books.size; i++) {
			currentBook = books.getElement(i);
			if(currentBook.containsAllGenders(genderList)){
				searchResult.add(currentBook);
			}
		}
		return searchResult;
	}
}
