/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public class Comparar<K, T> implements IComparator<K, T> {

	/**
	 * metodo para comparar dos objetos
	 * 
	 * @param abb1 objeto 1
	 * @param abb2 objeto 2
	 * @return int si estos son iguales, < o >
	 */
	public int Compare(K abb1, K abb2) {
		String palabra = (String) abb1;
		String palabra2 = (String) abb2;
		return palabra.compareTo(palabra2);
	}
}
