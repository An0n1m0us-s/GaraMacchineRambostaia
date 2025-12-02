import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author "An0n1m0us-s"
 * @see "amendola-scuola"
 *
 */
public class GestoreFile {
    private static final String fileName = "classifica.txt";

    /**
     *
     *  Metodo per leggere e stampare la vecchia classifica
     *
     *
     */
    public static synchronized void leggi() {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File non trovato");
            return;
        }
        System.out.println("\nUltima classifica:");
        try (BufferedReader re = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = re.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Fine della classifica precedente. \n");
        } catch (IOException e) {
            System.err.println("...");
        }
    }

    /**
     *
     * @param classifica
     * Prende come valore la String classfica dell'oggetto
     * Giudice e lo inserisce in un nuovo file che sotituirà
     * la vecchia classifica
     *
     */
    public static synchronized void scrivi(ArrayList<String> classifica) {
        try (FileWriter wr = new FileWriter(fileName)){
            wr.write("Classifica dei passaggi\n");
            for (String auto : classifica){
                wr.write(auto);
            }
            System.out.println("Classifica salvata in "+fileName);
        } catch (IOException e) {
            System.err.println("...");
        }
    }
}
