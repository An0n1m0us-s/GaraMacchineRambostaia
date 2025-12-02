import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gara {

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
                Thread ta = new Thread(a);
                ls.add(ta);
            }
            System.out.println("Inizio gara!");
            for (Thread t : ls) {
                t.start();
            }
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
            GestoreFile.leggi();
            GestoreFile.scrivi(g.classifica);
        } catch (IOException e) {
            System.err.println("Hai sbagliato a mettere un input");
        }

    }
}
