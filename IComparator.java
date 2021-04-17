/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public interface IComparator<K, T> {
	/**
	 * Compara dos llaves dadas por el usuario
	 * 
	 * @param abb1 llave 1
	 * @param abb2 llave 2
	 * @return Devuelve 0 si son iguales, 1 si abb1 es mayor que abb2 (abb1 > abb2)
	 *         y -1 de lo contrario (abb1 < abb2)
	 */
	public int Compare(K abb1, K abb2);
}
