
import java.util.ArrayList;

public class DFS {
	GrafoDirigido g;
	
	public DFS(GrafoDirigido g) {
		this.g= g;
	}
	
	public static ArrayList<Vertice> dfs(GrafoDirigido g) {
		ArrayList<Vertice> resultado = new ArrayList<Vertice>();

		for (int i = 0; i < g.getVertices().size(); i++) {
			if(g.getVertices().get(i).getEstado() == Estado.unvisited){
				dfs_visitar(g.getVertices().get(i), resultado);
			}
		}
		return resultado;
	}
	
	//falta chequear los ciclos
	
	private static void dfs_visitar(Vertice v, ArrayList<Vertice> resultado2) {
		v.setEstado(Estado.visiting);
		if(v.getAdyacentes().size() != 0){
			for (int i = 0; i < v.getAdyacentes().size(); i++) {
				if(!resultado2.contains(v)){
				resultado2.add(v);
				}
				if(v.getAdyacentes().get(i) != null && v.getAdyacentes().get(i).getEstado() == Estado.unvisited){
							dfs_visitar(v.getAdyacentes().get(i), resultado2);
					}

				}
			}
		
		v.setEstado(Estado.visited);
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
		gd.agregarArista(v4, v0);
		
		ArrayList<Vertice> dfs_result = new ArrayList<Vertice>();
		dfs_result = dfs(gd);
		for (int i = 0; i < dfs_result.size(); i++) {
			System.out.println(dfs_result.get(i));
		}
	}

}
