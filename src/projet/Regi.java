package projet;

import java.time.LocalTime;
import java.util.ArrayList;

public class Regi {
    ArrayList<Integer> classement;
    ArrayList<LocalTime> timer;
    ArrayList<Integer> abandon;
    ArrayList<Integer> disqualification;

    public Regi(){
        classement = new ArrayList<>();
        timer = new ArrayList<>();
        abandon = new ArrayList<>();
        disqualification = new ArrayList<>();
    }

    public ArrayList<Integer> getClassement() {
        return classement;
    }

    public ArrayList<Integer> getAbandon() {
        return abandon;
    }

    public ArrayList<Integer> getDisqualification() {
        return disqualification;
    }
}
