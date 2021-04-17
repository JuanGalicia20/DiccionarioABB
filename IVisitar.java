/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public interface IVisitar<K, T> {
    public void VisitarNodo(Association<K, T> arbol);
}
