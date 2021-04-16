public class Comparar<K,T> implements IComparator<K,T> {
    public int Compare(K abb1, K abb2) {
		String palabra = (String)abb1;
		String palabra2 = (String)abb2;
		return palabra.compareTo(palabra2);
	}
}
