package searchStats;

import java.util.HashMap;
import java.util.Map;

public class Vertice {
	Object value;
	Estado estado;
	Map<Vertice, Integer> adyacentes;
	
	public Vertice(Object value, Estado e) {
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
	
	public Object getValue() {
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
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return value;
//	}

}
