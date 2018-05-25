
import java.util.ArrayList;

public class GrafoNoDirigido implements Grafo {
	ArrayList<Vertice> vertices;
	int numVertices;
	int numAristas;

	public GrafoNoDirigido(int numVert){
		vertices = new ArrayList<Vertice>();
		numVertices = numVert;
		numAristas = 0;
	}
	@Override
	public void agregarVertice(Vertice v) {
		// TODO Auto-generated method stub
		vertices.add(v);
	}

	@Override
	public void agregarArista(Vertice a, Vertice b) {
		// TODO Auto-generated method stub
		if(vertices.contains(a)){
			vertices.get(a.getValue()).setAdyacentes(b);
			vertices.get(b.getValue()).setAdyacentes(a);
		}
	}

	@Override
	public Integer obtenerVertice(Integer claveVert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return numVertices;
	}

	@Override
	public int numAristas() {
		// TODO Auto-generated method stub
		return numAristas;
	}

	@Override
	public boolean existeArista(Vertice a, Vertice b) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<Vertice> obtenerAdyacentes(Integer vertice) {
		// TODO Auto-generated method stub
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getValue() == vertice){
				ArrayList<Vertice> adyacentes = new ArrayList<Vertice>();
				adyacentes = vertices.get(vertice).getAdyacentes();
				return adyacentes;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String grafo = "";
		for (int i = 0; i < vertices.size(); i++) {
			grafo += vertices.get(i).getValue() + " ";
		}
		return grafo;
	}
	
	public static void main(String[] args) {
		GrafoNoDirigido gnd = new GrafoNoDirigido(5);
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

		for (int i = 0; i < gnd.numVertices(); i++) {
			gnd.agregarVertice(vertices.get(i));
		}
		
		System.out.println(gnd.toString());
		
		gnd.agregarArista(v0, v1);
		gnd.agregarArista(v0, v2);
		gnd.agregarArista(v1, v2);
		gnd.agregarArista(v1, v3);
		gnd.agregarArista(v2, v4);
		gnd.agregarArista(v3, v4);
		gnd.agregarArista(v4, v2);
		gnd.agregarArista(v4, v0);
		
		System.out.println(v4.getAdyacentes());
		System.out.println(gnd.obtenerAdyacentes(4));
		
		
	}

}
