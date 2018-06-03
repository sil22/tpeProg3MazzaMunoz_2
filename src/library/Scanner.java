package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Scanner {
	
	String pathBooks;
	String pathGenders;

	public Scanner(String pathBooks, String pathGenders) {
		this.pathBooks = pathBooks;
		this.pathGenders= pathGenders;
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
	
	public void importGenders(Library l) {

		String line = "";
		String cvsSplitBy = ",";
		long inicio, fin, tiempoTotal;

		try (BufferedReader br = new BufferedReader(new FileReader(pathGenders))) {

			inicio = System.nanoTime();
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				l.addGender(items);
				
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

}
