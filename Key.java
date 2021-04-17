/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public class Key<K, T> implements IKeyCalculator<K, T> {

	/**
	 * metodo para obtener el valor de una lave
	 * 
	 * @param value valor de la llave
	 * @return K objeto encontrado
	 */
	@Override
	public K GetKey(T value) {
		Palabra actual = (Palabra) value;
		return (K) actual.LLave();
	}
}
