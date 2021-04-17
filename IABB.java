/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public interface IABB<K, T> {
	public void Insert(K key, T value);

	public T Find(K key, Association<K, T> actual);

	public int Count();

	public boolean IsEmpty();

	public void InOrder(IVisitar<K, T> visitNode, Association<K, T> actual);
}
