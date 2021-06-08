package projet;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Veuillez saisir les participants à la course :");
        ArrayList<Coureur> runers = new ArrayList<>();

        Scanner answer1 = new Scanner(System.in);
        System.out.println("Combien de participants il y a t-il : ");
        int length = answer1.nextInt();

        for(int i=0; i<length; i++){
            Scanner answer1_1 = new Scanner(System.in);
            System.out.println("Comment s'appelle le coureur numéro : " + i);
            String name = answer1_1.nextLine();

            Scanner answer1_2 = new Scanner(System.in);
            System.out.println("Quel est son numéro de dossard : ");
            int num = answer1_2.nextInt();

            Coureur runer = new Coureur(name, num);
            runers.add(runer);
        }
        Course run1 = new Course(runers, length);

        Regi roger = new Regi();

        boolean cond = false;
        while (!cond) {
            System.out.println("Bienvenu dans le menu de la course : ");
            System.out.println("0. Quitter le programme");
            System.out.println("1. Afficher les coureurs");
            System.out.println("2. Afficher le classement provisoire");
            System.out.println("3. Enregistrer une arrivée");
            System.out.println("4. Enregistrer un abandon");
            System.out.println("5. Enregistrer une disqualification");
            System.out.println("6. Enregistrer le temps d’arrivée d’un coureur");
            System.out.println("7. Obtenir le temps d’un coureur");
            System.out.println("8. Obtenir l’écart de temps entre deux coureurs donnés\n");

            Scanner answer2 = new Scanner(System.in);
            System.out.println("Faites votre choix parmis la liste d'action suivante :");
            int choice = answer2.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Vous quittez le programme !");
                    cond = true;
                    break;
                case 1:
                    for(int i=0; i<length; i++){
                        System.out.println("Coureur n°" + i + " nom : " + run1.cyclistes.get(i).getNom() + " numéro : " + run1.cyclistes.get(i).getNumDossard() + "\n");
                    }
                    break;
                case 2:
                    for(int i=0; i<length; i++){
                        int j = 0;
                        while (roger.classement.get(i) != run1.cyclistes.get(j).getNumDossard()){
                            j++;
                        }
                        System.out.println("Place n°" + i+1 + " nom : " + run1.cyclistes.get(j).getNom() + " numéro : " + roger.classement.get(i) + "\n");
                        break;
                    }
                    break;
                case 3:
                    Scanner answer3 = new Scanner(System.in);
                    System.out.println("Saisissez le numéro de dossard du cycliste passant la ligne d'arrivée : ");
                    int arrive = answer3.nextInt();
                    int i = 0;
                    while (arrive != run1.cyclistes.get(i).getNumDossard()){
                        i++;
                    }
                    roger.classement.add(run1.cyclistes.get(i).getNumDossard());
                    break;
                case 4:
                    Scanner answer4 = new Scanner(System.in);
                    System.out.println("Saisissez le numéro de dossard du cycliste abandonnant : ");
                    int abandon = answer4.nextInt();
                    int j = 0;
                    while (abandon != run1.cyclistes.get(j).getNumDossard()){
                        j++;
                    }
                    roger.abandon.add(run1.cyclistes.get(j).getNumDossard());
                    break;
                case 5:
                    Scanner answer5 = new Scanner(System.in);
                    System.out.println("Saisissez le numéro de dossard du cycliste disqualifié : ");
                    int disqualification = answer5.nextInt();
                    int k = 0;
                    while (disqualification != run1.cyclistes.get(k).getNumDossard()){
                        k++;
                    }
                    roger.disqualification.add(run1.cyclistes.get(k).getNumDossard());
                    break;
                case 6:
                    roger.timer.add(LocalTime.now());
                    break;
                case 7:
                    Scanner answer6 = new Scanner(System.in);
                    System.out.println("Saisissez le numéro de dossard du cycliste : ");
                    int numero = answer6.nextInt();
                    int l = 0;
                    while (numero != roger.classement.get(l)){
                        l++;
                    }
                    System.out.println("Coureur n°" + numero + " time : " + roger.timer.get(l) + "\n");
                    break;
                case 8:
                    Scanner answer7 = new Scanner(System.in);
                    System.out.println("Saisissez le numéro de dossard du cycliste 1 : ");
                    int numero1 = answer7.nextInt();
                    int m = 0;
                    while (numero1 != roger.classement.get(m)){
                        m++;
                    }

                    Scanner answer8 = new Scanner(System.in);
                    System.out.println("Saisissez le numéro de dossard du cycliste 1 : ");
                    int numero2 = answer8.nextInt();
                    int n = 0;
                    while (numero2 != roger.classement.get(n)){
                        n++;
                    }
                    if(roger.timer.get(m).isBefore(roger.timer.get(n))){
                        System.out.println("différence de temps entre " + numero1 + "et" + numero2 + roger.timer.get(m).compareTo(roger.timer.get(n)) + "\n");
                    }
                    else{
                        int dif = -(roger.timer.get(m).compareTo(roger.timer.get(n)));
                        System.out.println("différence de temps entre " + numero2 + "et" + numero1 + dif + "\n");
                    }
                    break;
            }
        }
    }
}
