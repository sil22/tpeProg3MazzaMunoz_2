package searchStats;

import java.util.HashMap;
import java.util.Map;

public class Vertice {
	int value;
	int cant;
	Estado estado;
	Map<Vertice, Integer> adyacentes;
	
	public Vertice(int value, Estado e) {
		adyacentes = new HashMap<Vertice, Integer>();
		this.value = value;
		estado = e;
	}

	public Map<Vertice, Integer> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(Vertice v) {
		if(adyacentes.containsKey(v)){
			adyacentes.put(v, adyacentes.get(v) + 1);	
		}
		else{
			adyacentes.put(v,1);
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

}
