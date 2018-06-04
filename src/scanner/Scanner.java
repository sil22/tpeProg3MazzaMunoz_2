package scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import library.Book;
import library.Library;

public class Scanner {
	
	String pathBooks;
	String pathGenders;

	public Scanner(String pathBooks) {
		this.pathBooks = pathBooks;
	}

	public void importBooks(Library l) {

		String line = "";
		String cvsSplitBy = ",";
		long inicio, fin, tiempoTotal;

		try (BufferedReader br = new BufferedReader(new FileReader(pathBooks))) {

			inicio = System.nanoTime();
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				l.addBook(items);

			}
			fin = System.nanoTime();
			tiempoTotal = fin - inicio;

			System.out.println(Long.toString(tiempoTotal));// Imprimo tiempo que
															// tarda en leer el
															// archivo

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LinkedList<LinkedList<String>> importGenderLists(String genderListImportPath)  {

		String line = "";
		String cvsSplitBy = ",";
		long inicio, fin, tiempoTotal;
		LinkedList<LinkedList<String>> genderLists = new LinkedList<LinkedList<String>>();

		try (BufferedReader br = new BufferedReader(new FileReader(genderListImportPath))) {

			inicio = System.nanoTime();
			br.readLine();
			while ((line = br.readLine()) != null) {
				
				LinkedList<String> currentGenderList = new LinkedList<String>();
				String[] generos = line.split(cvsSplitBy);
				for (String genero : generos) {
					currentGenderList.add(genero);
				}
				
				genderLists.add(currentGenderList);
				
			}
			fin = System.nanoTime();
			tiempoTotal = fin - inicio;

			System.out.println(Long.toString(tiempoTotal));// Imprimo tiempo que
															// tarda en leer el
															// archivo
			
			return genderLists; // Retorno la lista de listas de generos

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("No se encontro archivo");
		return null;
	}


	public void printBooksByGender(LinkedList<Book> books, String exportPath) {
		// CSVWritter
		BufferedWriter bw = null;
		try {
			File file = new File(exportPath);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			if(books != null){
				Iterator<Book> it = books.iterator();
				while(it.hasNext()){
					bw.write(it.next().toString());
					bw.newLine();				
				}				
			}
			else{
				bw.write("No existe el genero ingresado");
				System.out.println("No existe el genero ingresado");
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}

		}
	}
	
	public void printBooksByGenderList(LinkedList<LinkedList<Book>> booksOutput, String searchOutputPath) {
		

		BufferedWriter bw = null;
		try {
			File file = new File(searchOutputPath);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			if(booksOutput != null){
				
				int numSearch = 0;
				for (LinkedList<Book> bookList : booksOutput) {
					bw.write("Resultados busqueda n°" + numSearch);
					bw.newLine();
					for (Book book : bookList) {
						bw.write(book.toString());
						bw.newLine();
					}
					numSearch++;
				}			
				
			}
			else{
				bw.write("No se encontraron libros con que cumplan con todos los generos ingresados");
				System.out.println("No se encontraron libros con que cumplan con todos los generos ingresados");
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}

		}

		
	}


}
