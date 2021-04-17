import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * Programa diccionario de español, ingles y frances utilizando arboles binarios
 * de busqueda
 * 
 * @author Juan Galicia 20298
 */
public class App {

    // atributos
    private static JFileChooser file = new JFileChooser();
    private static File arch;
    private static String ruta = null;

    /**
     * Funcion principal de ejecucion del programa
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<>();
        Comparar comparar = new Comparar<String, Palabra>();
        Key key = new Key<String, Palabra>();
        ABB arbolEn = new ABB<String, Palabra>(comparar, key);
        ABB arbolEs = new ABB<String, Palabra>(comparar, key);
        ABB arbolFr = new ABB<String, Palabra>(comparar, key);
        String op = "";
        while (!op.equals("2")) {
            System.out.println("Bienvenido al diccionario de 3 idiomas\nSeleccione una opcion\n"
                    + "1. Alimentar el diccionario\n" + "2. Salir");
            op = leer.next();

            if (op.equals("1")) {
                readFile(arbolEn, arbolEs, arbolFr);
                Visitar visitar = new Visitar<String, Palabra>();
                arbolEn.InOrder(visitar, arbolEn._raiz);
                Scanner l = new Scanner(System.in);
                System.out.println("\nAhora, por favor ingrese el archivo con la oracion para poder traducirlo");
                palabras = readFileTrad();

                String lenguajeIn = "";
                String lenguajeD = "";
                while (!lenguajeIn.equals("1") && !lenguajeIn.equals("2") && !lenguajeIn.equals("3")) {
                    System.out.println("Seleccione el idioma de origen\n" + "1. Ingles\n" + "2. Español\n"
                            + "3. Francés\n" + "4. Salir");
                    lenguajeIn = l.nextLine();
                }
                while (!lenguajeD.equals("1") && !lenguajeD.equals("2") && !lenguajeD.equals("3")) {
                    System.out.println("Seleccione el idioma de destino\n" + "1. Ingles\n" + "2. Español\n"
                            + "3. Francés\n" + "4. Salir");
                    lenguajeD = l.nextLine();
                }
                String traduccion = "";

                for (int i = 0; i < palabras.size(); i++) {
                    switch (lenguajeIn) {
                    case "1": {
                        switch (lenguajeD) {
                        case "1": {
                            traduccion += " " + palabras.get(i) + " ";
                            break;
                        }

                        case "2": {
                            Palabra p = (Palabra) arbolEn.Find(palabras.get(i).toLowerCase(), arbolEn._raiz);
                            if (p != null) {
                                traduccion += " " + p.getEspanol() + " ";
                            } else {
                                traduccion += " *" + palabras.get(i) + "* ";
                            }
                            break;
                        }

                        case "3": {
                            Palabra p = (Palabra) arbolEn.Find(palabras.get(i).toLowerCase(), arbolEn._raiz);
                            if (p != null) {
                                traduccion += " " + p.getFrances() + " ";
                            } else {
                                traduccion += " *" + palabras.get(i) + "* ";
                            }
                            break;
                        }

                        default: {
                            System.out.println("Opcion no valida, verifique su entrada");
                            break;
                        }
                        }
                        break;
                    }

                    case "2": {
                        switch (lenguajeD) {
                        case "1": {
                            Palabra p = (Palabra) arbolEs.Find(palabras.get(i).toLowerCase(), arbolEs._raiz);
                            if (p != null) {
                                traduccion += " " + p.getIngles() + " ";
                            } else {
                                traduccion += " *" + palabras.get(i) + "* ";
                            }
                            break;
                        }

                        case "2": {
                            traduccion += " " + palabras.get(i) + " ";
                            break;
                        }

                        case "3": {
                            Palabra p = (Palabra) arbolEs.Find(palabras.get(i).toLowerCase(), arbolEs._raiz);
                            if (p != null) {
                                traduccion += " " + p.getFrances() + " ";
                            } else {
                                traduccion += " *" + palabras.get(i) + "* ";
                            }
                            break;
                        }

                        default: {
                            System.out.println("Opcion no valida, verifique su entrada");
                            break;
                        }
                        }
                        break;
                    }

                    case "3": {
                        switch (lenguajeD) {
                        case "1": {
                            Palabra p = (Palabra) arbolFr.Find(palabras.get(i).toLowerCase(), arbolFr._raiz);
                            if (p != null) {
                                traduccion += " " + p.getIngles() + " ";
                            } else {
                                traduccion += " *" + palabras.get(i) + "* ";
                            }
                            break;
                        }

                        case "2": {
                            Palabra p = (Palabra) arbolFr.Find(palabras.get(i).toLowerCase(), arbolFr._raiz);
                            if (p != null) {
                                traduccion += " " + p.getEspanol() + " ";
                            } else {
                                traduccion += " *" + palabras.get(i) + "* ";
                            }
                            break;
                        }

                        case "3": {
                            traduccion += " " + palabras.get(i) + " ";
                            break;
                        }

                        default: {
                            System.out.println("Opcion no valida, verifique su entrada");
                            break;
                        }
                        }
                        break;
                    }

                    default: {
                        System.out.println("Opcion no valida, verifique su entrada");
                        break;
                    }
                    }
                }

                System.out.println(traduccion);
            } else if (op.equals("2")) {
                System.exit(0);
            } else {
                System.out.println("Ingrese una opcion valida");
            }
        }
    }

    /**
     * Metodo que se encarga de leer el archivo
     * 
     * @return ArrayList<String[]> retorna los datos obtenidos
     * @throws IOException
     */
    public static void readFile(ABB arbolEn, ABB arbolEs, ABB arbolFr) throws IOException {

        System.out.println("Bienvenido, primero debe de seleccionar el archivo de palabras");
        ArrayList<String> data = open();

        // CAMBIAR
        for (int i = 0; i < data.size(); i++) {
            String[] l = data.get(i).split(",");
            Palabra palabraEN = new Palabra(l[0].toLowerCase(), l[1].toLowerCase(), l[2].toLowerCase());
            arbolEn.Insert(l[0].toLowerCase(), palabraEN);

            Palabra palabraES = new Palabra(l[0].toLowerCase(), l[1].toLowerCase(), l[2].toLowerCase());
            arbolEs.Insert(l[1].toLowerCase(), palabraES);

            Palabra palabraFR = new Palabra(l[0].toLowerCase(), l[1].toLowerCase(), l[2].toLowerCase());
            arbolFr.Insert(l[2].toLowerCase(), palabraFR);
        }
    }

    /**
     * Metodo que se encarga de leer el archivo
     * 
     * @return ArrayList<String[]> retorna los datos obtenidos
     * @throws IOException
     */
    public static ArrayList<String> readFileTrad() throws IOException {

        // ARREGLAR LEER MAYUSCULAS Y MINUSCULAS----------------------------------------
        ArrayList<String> palabras = new ArrayList<>();
        System.out.println("Bienvenido, debe de seleccionar el archivo de oraciones");
        ArrayList<String> data = open();

        for (int i = 0; i < data.size(); i++) {
            String[] l = data.get(i).split(" ");
            for (String a : l) {
                a = a.replace(".", "");
                palabras.add(a);
            }
        }
        return palabras;
    }

    /**
     * metodo que abre el seleccionador de archivos
     * 
     * @return ArrayList<String> los datos obtenidos
     */
    public static ArrayList<String> open() {
        int r = file.showOpenDialog(null);
        ArrayList<String> data = new ArrayList<>();
        String line = "";

        if (r == JFileChooser.APPROVE_OPTION) {
            arch = file.getSelectedFile();
            ruta = arch.getAbsolutePath();
            System.out.println("\nArchivo a utilizar: " + arch.getAbsolutePath());
            try {
                FileReader read = new FileReader(ruta);
                BufferedReader read1 = new BufferedReader(read);
                data.add(read1.readLine());
                while ((line = read1.readLine()) != null) {
                    line = line.toLowerCase();
                    data.add(line);
                }
            } catch (ArithmeticException | IOException | NumberFormatException e) {
                System.out.println(e.toString());
            }
        }
        return data;
    }
}
