import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrafoDirigido {
	ArrayList<Vertice> vertices;
	int numVertices;
	int numAristas;

	public GrafoDirigido(int numVert){
		vertices = new ArrayList<Vertice>();
		numVertices = numVert;
		numAristas = 0;
	}

	public void agregarVertice(Vertice v) {
		// TODO Auto-generated method stub
			vertices.add(v);
	}

	/* agregar arista, si no tiene arista la agrego, y si tiene, agrego +1 A SU PESO 
	 * */
	public void agregarArista(Vertice a, Vertice b) {
		// TODO Auto-generated method stub
		if(vertices.contains(a)){
			a.setAdyacentes(b);
			numAristas++;
		}
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public Integer obtenerVertice(Integer claveVert) {
		// TODO Auto-generated method stub		
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getValue() == claveVert){
				return vertices.get(i).getValue();
			}
		}
		return null;
	}

	public int numVertices() {
		// TODO Auto-generated method stub
		return numVertices;
	}

	public int numAristas() {
		// TODO Auto-generated method stub
		return numAristas;
	}

	public boolean existeArista(Vertice a, Vertice b) {
		// TODO Auto-generated method stub
		if(vertices.contains(a)){
			Map<Vertice, Integer> adyacentes = new HashMap<Vertice, Integer>();
			adyacentes = vertices.get(a.getValue()).getAdyacentes();
			if(adyacentes.containsKey(b)){
				return true;
			}
		}
		return false;
	}

	public Set<Vertice> obtenerAdyacentes(Vertice vertice) {
		// TODO Auto-generated method stub
		Set<Vertice> result = new HashSet<Vertice>();
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getValue() == vertice.getValue()){
				result = vertices.get(i).getAdyacentes().keySet();
				return result;
			}
		}
		return null;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		String grafo = "";
		for (int i = 0; i < vertices.size(); i++) {
			grafo += vertices.get(i).getValue() + " Values"+ vertices.get(i).getAdyacentes().values();
		}
		return grafo;
	}
	
	public static void main(String[] args) {
		GrafoDirigido gd = new GrafoDirigido(5);
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		Vertice v0 = new Vertice(0, Estado.unvisited);
		Vertice v1 = new Vertice(1, Estado.unvisited);
		Vertice v2 = new Vertice(2, Estado.unvisited);
		Vertice v3 = new Vertice(3, Estado.unvisited);
		Vertice v4 = new Vertice(4, Estado.unvisited);
		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);

		for (int i = 0; i < gd.numVertices(); i++) {
			gd.agregarVertice(vertices.get(i));
		}
		gd.agregarArista(v0, v1);
		gd.agregarArista(v0, v1);
	
		
		System.out.println(gd.toString());
		
	}



}
