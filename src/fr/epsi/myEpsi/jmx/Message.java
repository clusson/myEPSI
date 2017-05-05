package fr.epsi.myEpsi.jmx;

public class Message implements MessageBean {

	private static String nom = "MessageBean";
    private int valeur = 100;

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public synchronized void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void getMessages() {
        
    }


}
