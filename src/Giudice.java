import java.util.ArrayList;

public class Giudice{
    private int contaGiri;
    protected ArrayList<String> classifica = new ArrayList<>();
    private int posizione = 0;

    public Giudice(){

    }

    public synchronized void traguardo(Auto auto){
        System.out.println("Gara terminata per " +auto.giocatore);
        posizione++;
        classifica.add(posizione+") "+auto.giocatore +" con macchina " + auto.nomeAuto+"\n");
    }
}
