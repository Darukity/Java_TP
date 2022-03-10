package fr.uvsq.iut_velizy.horaires;

public class PlageHoraire implements Comparable<PlageHoraire>{
    public final static int DUREE_MIN=60;
    //final => champ non modifiable constante
    //static => la même val pour tout les objets instanciés ded cette classe
    private Horaire chDeb, chFin;
    public PlageHoraire(Horaire parDeb, Horaire parFin){
        chDeb = parDeb;
        chFin = parFin;
    }
    public String toString(){
        return "de " + chDeb.toString() + " à " + chFin.toString();
    }
    public Boolean estValide(){
        int heureDeb = chDeb.toMinutes();
        int heureFin = chFin.toMinutes();
        if((heureFin - heureDeb) >= DUREE_MIN){
            return true;
        }
        return false;
    }
    public String dure(){
        int heureDure = chFin.getHeure() - chDeb.getHeure();
        int minutesDure = chFin.getQuartHeure() - chDeb.getQuartHeure();
        String dure = " " + heureDure + "h" + minutesDure + "mn";
        return chDeb.toString() + " => " + chFin.toString() + dure;
    }
    public int compareTo(PlageHoraire parHoraire){
        int heureDeb = chDeb.toMinutes();
        //int heureFin = chFin.toMinutes();
        int parHoraireDeb = parHoraire.chDeb.toMinutes();
        int parHoraireFin = parHoraire.chFin.toMinutes();
        /*if((parHoraireDeb < heureDeb && parHoraireDeb < heureDeb)){
            return 1;
        } else if(parHoraireDeb > heureDeb && parHoraireFin > heureFin){
            return -1;
        }
        return 0;*/
        if(heureDeb < parHoraireDeb){
            return -1;
        }
        if(parHoraireFin < heureDeb){
            return +1;
        }
        return 0;
    }
}