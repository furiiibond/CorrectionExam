package TP.TP2;

public class TP extends Activite{
	
	Discipline discipline;
	
	public TP(String nom, Discipline discipline){
		super(nom);
		this.discipline = discipline;
	}
	
	public void addSalle(SalleTP s){
		if (discipline == s.getType())
			super.addSalle(s);
		else System.out.println("Salle " + s + " non ajoutee");
	}
}
