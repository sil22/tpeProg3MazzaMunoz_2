package scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import library.Book;
import searchStats.SearchStatsGraph;
import searchStats.Vertex;

public class Scanner {
	
	String pathGenders;

	public Scanner(String pathGenders) {
		this.pathGenders = pathGenders;
	}
	
	public void importGenderLists(String genderListImportPath, SearchStatsGraph searchStats)  {

		String line = "";
		String cvsSplitBy = ",";
		long inicio, fin, tiempoTotal;

		try (BufferedReader br = new BufferedReader(new FileReader(genderListImportPath))) {

			inicio = System.nanoTime();
			br.readLine();
			while ((line = br.readLine()) != null) {
				
				String[] genders = line.split(cvsSplitBy);

				searchStats.addVertice(new Vertex(genders[0]));
				for (int i = 1; i < genders.length; i++) {
					Vertex currentV = new Vertex(genders[i]);
					if(!searchStats.getVertices().contains(currentV)){
						searchStats.addVertice(currentV);
						searchStats.addArista(searchStats.getVertice(genders[i-1]), currentV);						
					}
					else {
						searchStats.addArista(searchStats.getVertice(genders[i-1]), currentV);						
					}
				}
				
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
					bw.write("Resultados busqueda n�" + numSearch);
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
