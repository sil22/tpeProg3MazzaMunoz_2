package librarySystem;


import java.util.*;
import library.*;
import scanner.Scanner;
import searchStats.SearchStatsGraph;

public class LibrarySystem {
	
	Library library;
	Scanner scanner;
	SearchStatsGraph searchStats;
	
	public LibrarySystem(String pathBooks){
		library = new Library();
		scanner = new Scanner(pathBooks);
		searchStats = new SearchStatsGraph();
		scanner.importBooks(library);
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
	
//	public void searchByGenderList(String genderListImportPath, String searchOutputPath) {
//		
//		// Importa la lista de busquedas. siendo cada busqueda una lista de generos
//		LinkedList<LinkedList<String>> genderLists = scanner.importGenderLists(genderListImportPath);
//		//Realiza la busqueda y la imprime
//		scanner.printBooksByGenderList(multipleSearch(genderLists), searchOutputPath);
//		
//	}
//	
//	private LinkedList<LinkedList<Book>> multipleSearch(List<LinkedList<String>> genderLists) {
//		
//		LinkedList<LinkedList<Book>> booksOutPut = new LinkedList<LinkedList<Book>>();
//		for (LinkedList<String> genderList : genderLists){ 
//			booksOutPut.add(library.searchBooks(genderList)); 
//			searchStats.generateSearchStatGraph(genderList);
//		}
//		return booksOutPut;
//	}

	public static void main(String[] args) {
		
		String importBooksPath = "/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-1ra etapa/dataset1.csv";
		String searchOutputPath = "/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-1ra etapa/salidaDataset1.csv";
		String genderListImportPath = "/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-2da etapa/dataset1b.csv";
		String multipleSearchOutputPath = "/Users/munoz/Documents/TUDAI/Programacion 3 CLASES - 2018/Practicos/datasets-2da etapa/salidaDataset1.csv";
		
		
		LibrarySystem ls = new LibrarySystem(importBooksPath); // Se cargan todos los libros
		System.out.println(ls.getBooks().toString());
		ls.printBooksByGender("drama", searchOutputPath);
		//Servicio 0
		//ls.searchByGenderList(genderListImportPath, multipleSearchOutputPath);
		ls.generateStatsGraph(genderListImportPath);
		System.out.println(ls.printStatsGraph());
	}

	
	
}
