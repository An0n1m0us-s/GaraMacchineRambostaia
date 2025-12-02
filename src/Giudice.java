import java.util.ArrayList;

public class Giudice{
    private int contaGiri;
    protected ArrayList<String> classifica = new ArrayList<>();
    private int posizione = 0;

    public Giudice(){

    }

    /**
     *
     * @param auto
     * Prende il valore dell'auto inserito in Gara
     * per indicare quando il giocatore x con auto y
     * finisce la gara e lo inserisce in classifica,
     * incrementando la posizione ad ogni auto che
     * termina la gara.
     *
     */
    public synchronized void traguardo(Auto auto){
        System.out.println("Gara terminata per " +auto.giocatore);
        posizione++;
        classifica.add(posizione+") "+auto.giocatore +" con macchina " + auto.nomeAuto+"\n");
    }
}
