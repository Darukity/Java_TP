package fr.uvsq.iut_velizy.planning;

import fr.uvsq.iut_velizy.reservation.*;
import fr.uvsq.iut_velizy.date.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class PlanningCollection {
    private ArrayList<Reservation> chList = new ArrayList<Reservation> ();
    private TreeSet<Reservation> chSet = new TreeSet<Reservation> ();

    public String toString(){
        return chList.toString() + ": " + chList.size() + "\n" + chSet.toString() + ": " + chSet.size();
    }

    public void ajout(Reservation parReserv){
        chList.add(parReserv);
        chSet.add(parReserv);
    }

    public TreeSet<Reservation> getReserv(DateCalendrier parDate) {
        TreeSet<Reservation> uSet = new TreeSet<Reservation>();
        Iterator<Reservation> it = chSet.iterator();
        while(it.hasNext()) {
            Reservation r = it.next();
            if(r.getDate().compareTo(parDate)==0){
                uSet.add(r);
            }
            if(uSet.size()==0){
                return null;
            }
            return uSet;
        }
    }
}
