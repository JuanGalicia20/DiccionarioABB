
/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public class ABB<K, T> implements IABB<K, T> {

	public Association<K, T> _raiz;
	int _count;
	IComparator<K, T> _keyComparator;
	IKeyCalculator<K, T> _keyCalculator;

	/**
	 * Constructor
	 * 
	 * @param metodoComparar      metodo para comparar los objetos
	 * @param metodoCalcularLlave metodo para calcular la llave de un nodo
	 */
	public ABB(IComparator<K, T> metodoComparar, IKeyCalculator<K, T> metodoCalcularLlave) {
		_keyComparator = metodoComparar;
		_keyCalculator = metodoCalcularLlave;
		_raiz = null;
		_count = 0;
	}

	/**
	 * metodo de insercion de elementos al arbol
	 * 
	 * @param key   llave del nodo
	 * @param value valor del nodo
	 */
	@Override
	public void Insert(K key, T value) {
		Association<K, T> _new = new Association<K, T>(key, value);

		if (_raiz == null) {
			_raiz = _new;
			_count++;
		} else {
			try {
				InsertAux(_raiz, _new);
			} catch (Exception e) {
				System.out.println("Ocurrio un error al insertar el valor al ABB");
				// Manejo de exception
			}

		}
	}

	/**
	 * metodo para insertar elementos auxiliar
	 * 
	 * @param _actual nodo actual
	 * @param _new    nodo siguiente
	 * @throws Exception
	 */
	private void InsertAux(Association<K, T> _actual, Association<K, T> _new) throws Exception {
		if (_actual != null) {

			if (_keyComparator.Compare(_actual._key, _new._key) > 0) { // Entra cuando actual > nuevo Inserta en hijo
																		// izquierdo
				if (_actual.hijoIzquierdo == null) { // Puedo insertar en hijo izquierdo
					_actual.hijoIzquierdo = _new;
					_count++;
				} else { // Entra cuando no puedo insertar en el hijo izquierdo de actual ya que está
							// ocupado
					InsertAux(_actual.hijoIzquierdo, _new);
				}
			} else if (_keyComparator.Compare(_actual._key, _new._key) < 0) { // Entra cuando actual < nuevo Inserta en
																				// hijo derecho

				if (_actual.hijoDerecho == null) { // Puedo insertar en hijo derecho
					_actual.hijoDerecho = _new;
					_count++;
				} else { // Entra cuando no puedo insertar en el hijo derecho de actual ya que está
							// ocupado
					InsertAux(_actual.hijoDerecho, _new);
				}
			} else {
				throw new Exception("Llaves repetidas");
			}

		}
	}

	/**
	 * metodo para buscar una llave en el ABB
	 * 
	 * @param key    llave a buscar
	 * @param actual llave actual
	 * @return T objeto encontrado
	 */
	@Override
	public T Find(K key, Association<K, T> actual) {
		T temp = null;

		if (actual != null) {

			if ((actual._key).equals(key)) {
				temp = actual._value;
			}

			if (temp == (null)) {
				temp = Find(key, actual.hijoIzquierdo);
			}
			if (temp == (null)) {
				temp = Find(key, actual.hijoDerecho);
			}

		}

		return temp;
	}

	/**
	 * conteo del numero de nodos del arbol
	 * 
	 * @return int
	 */
	@Override
	public int Count() {
		return _count;
	}

	/**
	 * si el arbol se encuentra vacio o no
	 * 
	 * @return boolean
	 */
	@Override
	public boolean IsEmpty() {
		return _count == 0;
	}

	/**
	 * metodo que ordena el arbol de manera InOrder
	 * 
	 * @param visitNode nodo a visitar
	 * @param actual    nodo actual
	 */
	@Override
	public void InOrder(IVisitar<K, T> visitNode, Association<K, T> actual) {
		if (actual != null) {
			InOrder(visitNode, actual.hijoIzquierdo);

			visitNode.VisitarNodo(actual);

			InOrder(visitNode, actual.hijoDerecho);
		}

	}

}
