package librarySystem;

import library.*;
import scanner.Scanner;
import searchStats.SearchStatsGraph;

public class LibrarySystem {
	
	Library library;
	Scanner scanner;
	SearchStatsGraph searchStats;
	
	public LibrarySystem(String pathGenders){
		library = new Library();
		scanner = new Scanner(pathGenders);
		searchStats = new SearchStatsGraph();
	}
	
	public BookList getBooks(){
		return library.getBooks();
	}
	
	public void printBooksByGender(String gender, String path){
		scanner.printBooksByGender(library.searchBooks(gender), path);
	}
	
	public void generateStatsGraph(String genderListImportPath) {
		scanner.importGenderLists(genderListImportPath, searchStats);
	}
	
	public String printStatsGraph(){
		return searchStats.toString();
	}
	

	public static void main(String[] args) {
		
		String genderListImportPath = "/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-2da etapa/dataset1b.csv";
				
		LibrarySystem ls = new LibrarySystem(genderListImportPath); // Se cargan todos los libros
		ls.generateStatsGraph(genderListImportPath);
		System.out.println(ls.printStatsGraph());
	}

	
	
}
