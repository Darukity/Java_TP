package fr.uvsq.iut_velizy.planning;

import fr.uvsq.iut_velizy.reservation.*;
import fr.uvsq.iut_velizy.date.*;

public class Planing{
    private final int SIZE;
    private Reservation[]chTabReserv;
    public Planing(int parSize){
        SIZE=parSize;
        //on le dois le déclarer en tant que static car on ne peut de toutes façon pas modifier la taille d'un tableau
        chTabReserv=new Reservation[SIZE]; 
    }
    public Boolean ajout(Reservation parReserv){
        for (int i=0; i<SIZE; i++){
            if(chTabReserv[i]==null){
                chTabReserv[i]=parReserv;
                return true;
            }
        }
        return false;
    }
    public String toString(){
        String str = "";
        for (int i=0; i<SIZE; i++){
            if(chTabReserv[i]!=null){
                str += chTabReserv[i].toString() + "\n";
            }
        }
        return str;
    }
    public Reservation getReservation(Date parDate) {
        for(int i=0; i<SIZE; i++){
            if(chTabReserv[i]!=null || chTabReserv[i].getDate().compareTo(parDate) == 0){
                return chTabReserv[i];
            }
        }
        return null;
    }
    public Reservation[]getReservations(Date parDate){
        Reservation[]tab=new Reservation[SIZE];
        int i_tab=0;
        for(int i=0; i<SIZE; i++){
            if(chTabReserv[i]!=null){
                if(chTabReserv[i].getDate().compareTo(parDate)==0){
                    tab[i_tab++]=chTabReserv[i];
                }
            }    
        }
        return tab;
    }
    public int plusAncienneReserv(int parDeb, int parFin){
        int i_min=parDeb;
        for(int i=parDeb; i<=parFin; i++){
            if(chTabReserv[i]==null){
                return i_min;
            }
            if(chTabReserv[i].compareTo(chTabReserv[i_min])<0){
                i_min=i;
            }
        }
        return i_min;
    }
}