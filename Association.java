public class Association<K,T> {
    public T _value;
	public K _key;
	public Association<K, T> hijoIzquierdo;
	public Association<K, T> hijoDerecho;
	
	public Association() {
		hijoIzquierdo = null;
		hijoDerecho = null;
	}
	
	public Association(K key, T value) {
		_key = key;
		_value = value;
		hijoIzquierdo = null;
		hijoDerecho = null;
	}
}
