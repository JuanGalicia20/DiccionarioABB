public class Visitar<K,T> implements IVisitar<K,T>{
    @Override
	public void VisitarNodo(Association<K, T> arbol) {
		Palabra actual = (Palabra)arbol._value;
		String diccionario = "";
		diccionario ="("+actual.getIngles()+", "+actual.getEspanol()+", "+actual.getFrances()+")";
		System.out.println(diccionario);
	}
}
