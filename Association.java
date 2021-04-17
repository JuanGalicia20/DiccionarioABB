/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public class Association<K, T> {
	public T _value;
	public K _key;
	public Association<K, T> hijoIzquierdo;
	public Association<K, T> hijoDerecho;

	/**
	 * constructor
	 */
	public Association() {
		hijoIzquierdo = null;
		hijoDerecho = null;
	}

	/**
	 * constructor adicional
	 */
	public Association(K key, T value) {
		_key = key;
		_value = value;
		hijoIzquierdo = null;
		hijoDerecho = null;
	}
}
