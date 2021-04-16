public interface IABB<K,T> {
    public void Insert(K key, T value);
	public T Delete(K key);
	public T Find(K key, Association<K, T> actual);
	public int Count();
	public boolean IsEmpty();
	public void InOrder(IVisitar<K, T> visitNode, Association<K, T> actual);
}
