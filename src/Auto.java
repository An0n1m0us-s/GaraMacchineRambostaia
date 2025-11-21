import static java.lang.Thread.sleep;

public class Auto implements Runnable {
    protected String giocatore;
    private int posizione;
    private String pass;
    protected String nomeAuto;
    private int giriMassimi;
    private int giroCorrente = 0;
    private Giudice g;

    public Auto(String giocatore, String pass, String nomeAuto, int giri, Giudice g) {
        this.giocatore = giocatore;
        posizione = 0;
        this.pass = pass;
        this.nomeAuto = nomeAuto;
        giriMassimi = giri;
        this.g = g;
    }

    @Override
    public void run() {
        for (giroCorrente = 0; giroCorrente < giriMassimi; giroCorrente++) {
            try {
                sleep(1000);
                System.out.println("Giro "+giroCorrente+" completato per " + giocatore + " con auto: " + nomeAuto);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        g.traguardo(this);
    }

}


