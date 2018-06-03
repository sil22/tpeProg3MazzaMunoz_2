package library;

public class BookList {

	Book arr[];
	int size = 0;

	public BookList(){
		arr = new Book[500];
	}

	public BookList(Book arr[]){
		this.arr = arr;
		size = arr.length;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public Object getElement(int pos){
		if(pos < size){
			return arr[pos];
		}
		return null;
	}


	public void insert(Book l){

		if(arr[arr.length-1] != null){
			Book nuevoArreglo[] = new Book[size*2];
			for (int i = 0; i < size; i++) {
				nuevoArreglo[i] = arr[i];
			}
			arr = nuevoArreglo;
		}
		arr[l.getId()] = l;
		size++;
	}


	public boolean isSorted(){

		if(size > 2){
			return isSorted(0);
		}
		return true;
	}

	private boolean isSorted(Integer pos){

		Integer next = pos+1;
		if((int) next < (int)size){
			if((int)arr[pos].getId() <= (int)arr[next].getId()){
				return isSorted(next);
			}
			else{
				return false;
			}
		}
		return true;

	}

	public Object binarySearch(Object o){

		if(!isEmpty() && isSorted()){
			int inicio = 0;
			int fin  = size - 1;
			int medio = inicio+fin/2;
			return binarySearch(inicio, fin, medio, o);
		}
		return null;

	}
	
	public Object binarySearch(int inicio, int fin, int medio, Object o){

		Object current = arr[medio];

		if(o.equals(current)){
			return current;
		}
		if(inicio == fin){
			return null;
		}

		if((int)o < (int)current){
			fin = medio-1;
			medio = (inicio+fin)/2;
		}
		else{
			inicio = medio+1;
			medio = (inicio+fin)/2;
		}
		return binarySearch(inicio, fin, medio, o);
	}

	public String  toString(){
		String result = "";
		for (int i = 0; i < size; i++) {
			result+=(arr[i] + "\n");
		}
		return result;
	}

	public void deleteAll(){
		arr = new Book[10];
		size = 0;
	}

	public BookList copy(){

		BookList copy = new BookList();
		for (int i = 0; i < size; i++) {
			copy.insert(arr[i]);
		}
		return copy;
	}


}
