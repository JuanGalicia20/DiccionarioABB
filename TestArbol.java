import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
class TestArbol {

	/**
	 * test de insercion al arbol
	 */
	@Test
	void testInsert() {
		Comparar comparar = new Comparar<String, Palabra>();
		Key key = new Key<String, Palabra>();
		ABB arbolPrueba = new ABB<String, Palabra>(comparar, key);
		Palabra palabra1 = new Palabra("house", "casa", "loger");
		Palabra palabra2 = new Palabra("dog", "perro", "chien");
		arbolPrueba.Insert(palabra1.getIngles(), palabra1);
		arbolPrueba.Insert(palabra2.getIngles(), palabra2);

		int tamano = arbolPrueba.Count();
		assertEquals(2, tamano);
	}

	/**
	 * test de busqueda fallida
	 */
	@Test
	void testSearchF() {
		Comparar comparar = new Comparar<String, Palabra>();
		Key key = new Key<String, Palabra>();
		ABB arbolPrueba = new ABB<String, Palabra>(comparar, key);
		Palabra palabra1 = new Palabra("house", "casa", "loger");
		Palabra palabra2 = new Palabra("dog", "perro", "chien");
		arbolPrueba.Insert(palabra1.getIngles(), palabra1);
		arbolPrueba.Insert(palabra2.getIngles(), palabra2);

		Palabra a = (Palabra) arbolPrueba.Find("hello", arbolPrueba._raiz);

		assertEquals(null, a);
	}

	/**
	 * test de busqueda completada
	 */
	@Test
	void testSearchA() {
		Comparar comparar = new Comparar<String, Palabra>();
		Key key = new Key<String, Palabra>();
		ABB arbolPrueba = new ABB<String, Palabra>(comparar, key);
		Palabra palabra1 = new Palabra("house", "casa", "loger");
		Palabra palabra2 = new Palabra("dog", "perro", "chien");
		arbolPrueba.Insert(palabra1.getIngles(), palabra1);
		arbolPrueba.Insert(palabra2.getIngles(), palabra2);

		Palabra a = (Palabra) arbolPrueba.Find("dog", arbolPrueba._raiz);
		boolean exist = false;
		if (a != null) {
			exist = true;
		} else {
			exist = false;
		}
		assertEquals(true, exist);
	}

}
