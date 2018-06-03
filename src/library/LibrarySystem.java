package library;

public class LibrarySystem {
	
	Library library;
	Scanner scanner;
	
	public LibrarySystem(String pathBooks, String pathGenders){
		library = new Library();
		scanner = new Scanner(pathBooks, pathGenders);
		scanner.importBooks(library);
		scanner.importGenders(library);
	}
	
	public LibrarySystem(){
		library = null;
		scanner = null;
	}
	
	public void setLibrary(Library l){
		library = l;
	}
	
	public void setScanner(Scanner s){
		scanner = s;
	}
	
	public BookList getBooks(){
		return library.getBooks();
	}
	
	public void printBooksByGender(String gender, String path){
		scanner.printBooksByGender(library.searchBooks(gender), path);
	}
	
	public static void main(String[] args) {
		
		LibrarySystem ls = new LibrarySystem("/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-1ra etapa/dataset1.csv", "/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-2da etapa/dataset1.csv");
		System.out.println(ls.getBooks().toString());
		ls.printBooksByGender("drama", "/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-1ra etapa/salidaDataset1.csv");
	
	}
	
}
