
import java.util.ArrayList;

public interface Grafo {
	
//	public void grafo();
	public void agregarVertice(Vertice v); //por elm omento va aser un integer, pero ver de hacer una clase VERTICE
	public void agregarArista(Vertice a, Vertice b); //agrega al grafo una nueva arista dirigida que conecta dos vértices
	public Integer obtenerVertice(Integer claveVert); // encuentra el vértice en el grafo con nombre claveVert.
	public int numVertices(); 
	public int numAristas();
	public boolean existeArista(Vertice a, Vertice b); // devuelve true si existe una arista que conecte los vértices dados.
	public ArrayList<Vertice> obtenerAdyacentes(Integer vertice); // devuelve una lista con todos los vértices alcanzables desde el dado.
	public String toString();
	
}
