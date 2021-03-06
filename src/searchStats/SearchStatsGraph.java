package searchStats;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import library.Book;
import library.Gender;

public class SearchStatsGraph {
	ArrayList<Vertex> vertices;
	int numVertices;
	int numAristas;

	public SearchStatsGraph(){
		vertices = new ArrayList<Vertex>();
		numVertices = 0;
		numAristas = 0;
	}

	public void addVertice(Vertex v) {
		// TODO Auto-generated method stub
		if(!vertices.contains(v)){
			vertices.add(v);
			numVertices++;
		}
	}

	public void addArista(Vertex a, Vertex b) {
		if(vertices.contains(a)){
			a.setAdyacentes(b);
			numAristas++;
		}
	}
	
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
	}

	public Vertex getVertice(String claveVert) {	
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getValue().equals(claveVert)){
				return vertices.get(i);
			}
		}
		return null;
	}

	public int numVertices() {
		return numVertices;
	}

	public int numAristas() {
		return numAristas;
	}
 
	public boolean existeArista(Vertex a, Vertex b) {
		return a.existeArista(b);
	}

	public Set<Vertex> obtenerAdyacentes(Vertex vertice) {	
		return vertice.getAdyacentes();
	}
	

	public String toString() {
		String grafo = "";
		for (int i = 0; i < vertices.size(); i++) {
			grafo += vertices.get(i).toString() + " \n";
		}
		return grafo;
		
	}
	
	// Generos mas frecuentes  servicio 1
	public ArrayList<Gender> getFrequentlyGenderAfter(Gender gender){
		return null;
		
	}
	
	// Servicio 2
	public ArrayList<Gender> getAllGenderAfterSearching(Gender gender){
		return null;
	}
	
	//servicio 3
	public SearchStatsGraph getRelatedGenders( ){
		return null;
	}
	
	public static void main(String[] args) {
		SearchStatsGraph gd = new SearchStatsGraph();
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		Vertex v0 = new Vertex("Filosofia");
		Vertex v1 = new Vertex("Arte");
		Vertex v2 = new Vertex("Historia");
		Vertex v3 = new Vertex("Derecho");
		Vertex v4 = new Vertex("Politica");
		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);

		for (Vertex vertice : vertices) {
			gd.addVertice(vertice);
		}
		gd.addArista(v0, v1);
		gd.addArista(v0, v1);
		gd.addArista(v0, v2);
		gd.addArista(v0, v3);
		gd.addArista(v1, v2);
		gd.addArista(v2, v3);
		gd.addArista(v3, v1);
	
		
		System.out.println(gd.toString());
		
	}


}
