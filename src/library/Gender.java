package library;
import java.util.Iterator;
import java.util.LinkedList;

public class Gender implements Iterable<Book>, Comparable<Object> {

	String name;
	LinkedList<Book> books;
	
	public Gender(String n) {
		name = n;
		books = new LinkedList<Book>();
	}

	public String getName() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public LinkedList<Book> getbooks() {
		return books;
	}

	public void setbooks(LinkedList<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}

	@Override
	public Iterator<Book> iterator() {
		return books.iterator();
	}

	@Override
	public int compareTo(Object object) {	
		return name.compareTo(object.toString());	
	}
	
	public boolean equals(Object genderName){
		return this.name.equals(genderName);
	}
	
	public String toString(){
		return this.name;
	}
	
	
	
}
