public class ABB<K,T> implements IABB<K,T> {

    public Association<K, T> _raiz;
	int _count;
	IComparator<K, T> _keyComparator;
	IKeyCalculator<K, T> _keyCalculator;
	
	public ABB(IComparator<K, T> metodoComparar, IKeyCalculator<K, T> metodoCalcularLlave) {
		_keyComparator = metodoComparar;
		_keyCalculator = metodoCalcularLlave;
		_raiz = null;
		_count = 0;
	}
	
	@Override
	public void Insert(K key, T value) {
		Association<K, T> _new = new Association<K, T>(key, value);

		if (_raiz == null) {
			_raiz = _new;
			_count++;
		} else {
			try {
				InsertAux(_raiz, _new);
			} catch(Exception e) {
                System.out.println("Ocurrio un error al insertar el valor al ABB");
				//Manejo de exception
			}
			
		}
	}
	
	private void InsertAux(Association<K, T> _actual, Association<K, T> _new) throws Exception{
		if (_actual != null) {
			
			if (_keyComparator.Compare(_actual._key, _new._key) > 0) { //Entra cuando actual > nuevo Inserta en hijo izquierdo
				if (_actual.hijoIzquierdo == null) { //Puedo insertar en hijo izquierdo
					_actual.hijoIzquierdo = _new;
					_count++;
				} else { //Entra cuando no puedo insertar en el hijo izquierdo de actual ya que está ocupado
					InsertAux(_actual.hijoIzquierdo, _new);
				}
			} else if (_keyComparator.Compare(_actual._key, _new._key) < 0) { //Entra cuando actual < nuevo Inserta en hijo derecho
			
				if (_actual.hijoDerecho == null) { //Puedo insertar en hijo derecho
					_actual.hijoDerecho = _new;
					_count++;
				} else { //Entra cuando no puedo insertar en el hijo derecho de actual ya que está ocupado
					InsertAux(_actual.hijoDerecho, _new);
				}
			} else {
				throw new Exception("Llaves repetidas");
			}
			
		}
	}

	@Override
	public T Delete(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Find(K key, Association<K, T> actual) {
		T temp = null;

		if (actual != null) {

			if((actual._key).equals(key)){
				temp = actual._value;
			}

			if(temp == (null)){
				temp = Find(key, actual.hijoIzquierdo);
			}
			if(temp == (null)){
				temp = Find(key, actual.hijoDerecho);
			}
			
		}

		return temp;
	}

	@Override
	public int Count() {
		return _count;
	}

	@Override
	public boolean IsEmpty() {
		return _count == 0;
	}

	@Override
	public void InOrder(IVisitar<K, T> visitNode, Association<K, T> actual) {
		if (actual != null) {
			InOrder(visitNode, actual.hijoIzquierdo);
			
			visitNode.VisitarNodo(actual);
			
			InOrder(visitNode, actual.hijoDerecho);
		}
		
	}
    
}
