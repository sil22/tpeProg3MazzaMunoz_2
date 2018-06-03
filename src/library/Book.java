package library;
 public class Book {
	int id;
	static int count = -1;
	String title = "";
	String author = "";
	String pages;
	String genders;

	public Book( String t, String a, String cp, String g){
		count++;
		this.id = count;
		title = t;
		author = a;
		pages = cp;
		genders = g;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getGenders() {
		return genders;
	}

	public void setGenders(String genders) {
		this.genders = genders;
	}
	
	public String toString(){
		return "Libro id:" + id + " title: " + title + " author: " + author +
				" Pags: " + pages + " genders: " + genders; 
	}
}
