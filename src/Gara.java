import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author An0n1m0us-s
 */

public class Gara {

    /**
     *
     * @param args
     * È il metodo main, quello che contiene
     * l'esecuzione del codice
     *
     * Ho usato BufferedReader per leggere lo stream di input
     * della tastiera
     *
     */
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Giudice g = new Giudice();
        try {
            System.out.println("inserisci il numero di giocatori:");
            int nGioc = Integer.parseInt(in.readLine());
            System.out.println("Inserisci il numero di giri:");
            int nGiri = Integer.parseInt(in.readLine());
            ArrayList<Thread> ls = new ArrayList<>();
            for (int i = 0; i < nGioc; i++) {
                System.out.println("inserisci nome, pass, nome auto del giocatore");
                Auto a = new Auto(in.readLine(), in.readLine(), in.readLine(), nGiri, g);

                /**
                 * Istanzio un nuovo Thread che conterrà
                 * che conterrà i valori dell'oggetto
                 * Auto a, ciò si ripeterà per ogni auto di cui
                 * si inseriscono le informazioni
                 */
                Thread ta = new Thread(a);

                /**
                 * Aggiunge il Thread creato all'ArList "ls"
                 * (ovviamente nel momento in cui verrà aggiunto
                 * all'ArList verrà convertito in String e quindi
                 * non sarà più un Thread)
                 */
                ls.add(ta);
            }
            System.out.println("Inizio gara!");

            /**
             * Ho ciclato ls con un foreach in modo che i valori
             * di ls vengano istanziati come thread e avviati
             * con il metodo start()
             */
            for (Thread t : ls) {
                t.start();
            }

            /**
             * Qui invece ho fatto lo stesso ciclo foreach
             * in modo che i Thread inizino la gara, il
             * metodo join() aatende che il thread precedente
             * finisca prima di farne partire un altro
             */
            for (Thread t : ls) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    System.err.println("Errore");
                }
            }
            System.out.println("Classifica:");
            for (String s : g.classifica) {
                System.out.println(s);
            }

            /**
             * Richiamo i metodi leggi() e scrivi() dichiarati
             * in gestore file
             */
            GestoreFile.leggi();
            GestoreFile.scrivi(g.classifica);
        } catch (IOException e) {
            System.err.println("Hai sbagliato a mettere un input");
        }

    }
}
