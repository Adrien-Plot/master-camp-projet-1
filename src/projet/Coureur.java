package projet;

public class Coureur {
    String nom;
    int numDossard;

    public Coureur(String name, int num){
        nom = name;
        numDossard = num;
    }

    public String getNom() {
        return nom;
    }

    public int getNumDossard() {
        return numDossard;
    }
}
