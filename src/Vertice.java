
import java.util.ArrayList;

public class Vertice {
	int value;
	int peso;
	int cant;
	Estado estado;
	ArrayList<Vertice> adyacentes;
	
	public Vertice(int value, Estado e) {
		adyacentes = new ArrayList<Vertice>();
		this.value = value;
		this.estado = e;
	}
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setAdyacentes(ArrayList<Vertice> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public ArrayList<Vertice> getAdyacentes() {
		return adyacentes;
	}
	public void setAdyacentes(Vertice b) {
		if(!adyacentes.contains(b)){
		this.adyacentes.add(b);
		}
	}
	
	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(value);
	}
	

	public enum Estado {
		unvisited,
		visiting,
		visited;
	}


}
