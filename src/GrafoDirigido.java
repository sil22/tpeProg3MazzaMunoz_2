
import java.util.ArrayList;

public class GrafoDirigido implements Grafo {
	ArrayList<Vertice> vertices;
	int numVertices;
	int numAristas;

	public GrafoDirigido(int numVert){
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
	/* agregar arista, si no tiene arista la agrego, y si tiene, agrego +1 A SU PESO 
	 * */
	public void agregarArista(Vertice a, Vertice b) {
		// TODO Auto-generated method stub
		if(vertices.contains(a)){
			vertices.get(a.getValue()).setAdyacentes(b);
			numAristas++;
		}
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	@Override
	public Integer obtenerVertice(Integer claveVert) {
		// TODO Auto-generated method stub		
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getValue() == claveVert){
				return vertices.get(i).getValue();
			}
		}
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
		if(vertices.contains(a)){
			ArrayList<Vertice> adyacentes = new ArrayList<Vertice>();
			adyacentes = vertices.get(a.getValue()).getAdyacentes();
			if(adyacentes.contains(b)){
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Vertice> obtenerAdyacentes(Integer vertice) {
		// TODO Auto-generated method stub
		ArrayList<Vertice> result = new ArrayList<Vertice>();
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getValue() == vertice){
				result = vertices.get(i).getAdyacentes();
				return result;
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
		
		System.out.println(gd.toString());
		
		gd.agregarArista(v0, v1);
		gd.agregarArista(v0, v2);
		gd.agregarArista(v1, v2);
		gd.agregarArista(v1, v3);
		gd.agregarArista(v2, v4);
		gd.agregarArista(v3, v4);
		gd.agregarArista(v4, v2);
		gd.agregarArista(v4, v0);

		System.out.println(v0.getAdyacentes());
		System.out.println(v1.getAdyacentes());
		System.out.println(v2.getAdyacentes());
		System.out.println(v3.getAdyacentes());
		System.out.println(v4.getAdyacentes());
		
		System.out.println(gd.obtenerVertice(2));
		System.out.println(gd.existeArista(v3, v4));
		System.out.println(gd.obtenerAdyacentes(4));
		
	}



}
