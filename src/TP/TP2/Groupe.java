package TP.TP2;

import java.util.ArrayList;
import java.util.List;

public class Groupe{
	private String nom;
	private int effectif;
	private List<Groupe> subGroupes; // les sous groupes du groupe courant
	
	// Constructeur suchargée pour les subGroupes
	public Groupe(String n, int e, List<Groupe> subGroupes){
		nom = new String(n);
		effectif = e;
		this.subGroupes = subGroupes;
	}

	public Groupe(String n, int e){
		nom = new String(n);
		effectif = e;
		this.subGroupes = new ArrayList<Groupe>();
	}

	public List<Groupe> getSubGroupes(){
		return subGroupes;
	}
	
	public void addSubGroupe(Groupe groupe){
		this.subGroupes.add(groupe);
	}
	
	public int getEffectif(){
		return effectif;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String toString(){
		return nom + " (" + effectif + " étudiants)";
	}
}
