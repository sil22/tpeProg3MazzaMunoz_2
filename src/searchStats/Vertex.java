package searchStats;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import library.Gender;

public class Vertex {
	String value;
	Estado estado;
	Map<Vertex, Integer> adyacentes;
	
	public Vertex(String value) {
		adyacentes = new HashMap<Vertex, Integer>();
		this.value = value;
		estado = Estado.unvisited;
	}

	public Set<Vertex> getAdyacentes() {
		return adyacentes.keySet();
	}

	public void setAdyacentes(Vertex v) {
		if(adyacentes.containsKey(v)){
			adyacentes.put(v, adyacentes.get(v) + 1);	
		}
		else{
			adyacentes.put(v,1);
		}
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public boolean existeArista(Vertex b) {
		return adyacentes.containsKey(b);
	}
	
	public boolean equals(Object v){
		return this.value.equals(((Vertex) v).getValue());
	}

	public String toString() { 
		// terminar
		return " Vertex Name: " + value.toString() + " Adjacents: " + printAdjacents();
	}

	private String printAdjacents() {
		
		String result = "[";
		Iterator<Entry<Vertex, Integer>> iterator = adyacentes.entrySet().iterator();
		Entry<Vertex, Integer> next;
		while(iterator.hasNext()){
			next = iterator.next();
			result += "Name: " + next.getKey().getValue() + " Weight: " + next.getValue() +  " -- ";  		
		}
		
		return result += "]";
	}

}
