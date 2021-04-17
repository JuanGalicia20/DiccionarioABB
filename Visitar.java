/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public class Visitar<K, T> implements IVisitar<K, T> {

	/**
	 * metodo para visitar un nodo y devolver un valor
	 * 
	 * @param arbol arbol a visitar
	 */
	@Override
	public void VisitarNodo(Association<K, T> arbol) {
		Palabra actual = (Palabra) arbol._value;
		String diccionario = "";
		diccionario = "(" + actual.getIngles() + ", " + actual.getEspanol() + ", " + actual.getFrances() + ")";
		System.out.println(diccionario);
	}
}
