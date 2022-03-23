package TP.TP2;

import java.util.*;

public class Creneau {
    private int annee;
    private int mois; // 1 à 12
    private int jour; // 1 à 31
    private int heure; // 0 à 23
    private int minute; // 0 à 59
    private int duree; // en minutes, maximum 210
    private static final int FINCOURS = 1140;
    private static final int DUREEJOURNEECOURS = 660;
    
    private Salle salle;
    private Activite activite;
	
    public Creneau(int a, int m, int j, int h, int min, int d, Salle s, Activite ac) {
		
	annee = a; mois = m; jour = j;
	heure = h; minute = min; duree = d;
	salle = s;
	activite = ac;
	
	if(!verifCapacite()){
	    System.exit(1); // On pourrait utiliser un mécanisme d'exception, aussi. 
	}
	if(!verifDuree()){
	    System.exit(1);
	}
	if(!verifSalle()){
	    System.exit(1);
	}
    }
    
    // Verifie l'adéquation de la salle : la salle affectée doit être une des salles appropriées de l'activité. Indication: utiliser une methode de liste.
    private boolean verifSalle(){
    	return activite.getSalles().contains(salle);
    }
    
    // Verifie que la taille de la salle convient à la promo
    private boolean verifCapacite(){
    	int count = 0;
        for (Salle value : activite.getSalles()) {
            count += value.getCapacite();
        }
		
		return (salle.getCapacite() <= count);
    }
    
    // Verifie que le début et la fin du créneau sont dans la même journée, entre 8h et 19h
    private boolean verifDuree(){
        int startTime = heure*60 + minute;
        int endTime = startTime + duree;
        boolean startWorking = (heure >= 8 && startTime < FINCOURS);
        boolean timeWorking = (duree <= DUREEJOURNEECOURS);
        boolean endWorking = (endTime <= FINCOURS);
    	return (endWorking && timeWorking && startWorking);
    }
    
    public Salle getSalle(){
    	return salle;
    }
    
    public Activite  getActivite(){
    	return activite;
    }
    
    public int  getDuree(){
    	return duree;
    }
    
    public String toString(){
    	return jour + "/" + mois + "/" + annee + " " + heure + ":" + minute +" (" + duree +") : " + 
	    activite + " " + salle;
    }

    private boolean notTheSameDay(Creneau c){
    	return c.jour != this.jour || c.mois != this.mois || c.annee != this.annee;
    }
    /**
    * retourne vrai si un ou plusieurs groupes est/sont commune au deux listes de groupes passés en paramètre
    */
	private boolean hasCommonGroups(ArrayList<Groupe> groupes, ArrayList<Groupe> groupes2) {
		for (Groupe groupe : groupes) {
            for (Groupe groupe2 : groupes2) {
                if (groupe.equals(groupe2))
                	return true;
            }
        }
        return false;
	} 
    /**
    * On observe les dépendence des groupes.
    */
	private boolean isDepending(ArrayList<Groupe> groupes, ArrayList<Groupe> groupes2) {
		for(Groupe groupe : groupes){
            for (Groupe gSub : groupe.getSubGroupes()){
                for (Groupe g : groupes2){
                    if (g.equals(gSub)){
                        return true;
                    }
                }
            }
        }
        for(Groupe groupe : groupes2){
            for (Groupe gSub : groupe.getSubGroupes()){
                for(Groupe g : groupes){
                    if (g.equals(gSub)){
                        return true;
                    }
                }
            }
        }
		return false;
	}
	
    // Intersection
    public boolean intersection(Creneau c){
    	if (notTheSameDay(c))
    		return false;
    	
    	boolean scheduleColapsed = false;
        int startTimeCur = heure*60 + minute;
        int endTimeCur = startTimeCur + duree;
        int startTimeCompared = c.heure*60 + c.minute;
        int endTimeCompared = startTimeCompared + c.duree;
        
        if (startTimeCur < startTimeCompared){
        	scheduleColapsed = (endTimeCur >= startTimeCompared);
        } else if (startTimeCur > startTimeCompared){
        	scheduleColapsed = (endTimeCompared >= startTimeCur);
        }
		// 2 créneaux qui débutent au meme moment
        
        boolean sameRoom = salle.getNom().equals(c.salle.getNom());
        boolean sameGroups = hasCommonGroups(c.getActivite().getGroupes(), activite.getGroupes());
        boolean dependGroup = isDepending(c.getActivite().getGroupes(), activite.getGroupes());
        
        return (scheduleColapsed && (sameRoom || sameGroups || dependGroup));
    }
}
