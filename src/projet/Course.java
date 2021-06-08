package projet;

import java.util.ArrayList;

public class Course {
    ArrayList<Coureur> cyclistes;

    public Course(ArrayList<Coureur> coureur, int length){
        cyclistes = new ArrayList<>();
        for(int i=0; i<length; i++) {
            cyclistes.add(coureur.get(i));
        }
    }
}
