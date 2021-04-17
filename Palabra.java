/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public class Palabra {
    private String ingles;
    private String espanol;
    private String frances;

    /**
     * @return String
     */
    public String getIngles() {
        return ingles;
    }

    /**
     * @param ingles
     */
    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    /**
     * @return String
     */
    public String getEspanol() {
        return espanol;
    }

    /**
     * @param espanol
     */
    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    /**
     * @return String
     */
    public String getFrances() {
        return frances;
    }

    /**
     * @param frances
     */
    public void setFrances(String frances) {
        this.frances = frances;
    }

    public Palabra(String ingles, String espanol, String frances) {
        this.ingles = ingles;
        this.espanol = espanol;
        this.frances = frances;
    }

    /**
     * @return String
     */
    public String LLave() {
        return null;
    }

}
