package fr.uvsq.iut_velizy.date;

import java.util.Calendar;

public class DateCalendrier extends Date 
    implements Comparable<Date>, ConstantesCalendrier{

    private int chJourSem;//1 pour lundi, 2 pour mardi, 3 pou...

    public DateCalendrier(){
        Calendar today=Calendar.getInstance();
        chAnnee=today.get(Calendar.YEAR);
        chMois=today.get(Calendar.MONTH)+1;
        chJour=today.get(Calendar.DAY_OF_MONTH);
        chJourSem=today.get(Calendar.DAY_OF_WEEK);

        if(chJourSem==Calendar.SUNDAY){
            chJourSem=7;
        } else{
            chJourSem--;
        }
    }

    public DateCalendrier(int parJour, int parMois, int parAnnee){
        super(parJour, parMois, parAnnee);

        Calendar date=Calendar.getInstance();
        date.set(parAnnee,parMois-1,parJour);
        chJourSem=date.get(Calendar.DAY_OF_WEEK);

        if(chJourSem==Calendar.SUNDAY){
            chJourSem=7;
        } else{
            chJourSem--;
        }
    }

    public String toString(){
        return super.toString()+","+JOURS_SEMAINE[chJourSem-1];
    }

    public DateCalendrier dateDuLendemain(){
        Date date = super.dateDuLenDemain();
        return new DateCalendrier(date.chJour,date.chMois,date.chAnnee);
    }

    public DateCalendrier dateDeLaVeille(){
        Date date =  super.dateDeLaVeille();
        return new DateCalendrier(date.chJour,date.chMois,date.chAnnee);
    }
}