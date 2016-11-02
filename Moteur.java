import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import java.util.Date;
public class Moteur {
	
	String Nom;
	Date DateNaissance;
	boolean Sexe;
	
	int nb_variable;
	int max;
	String Sujet[];
	int Valeur[];
	Date DateDerniereIncrementation[];

	
	/*public static void main(String[] args){
		
		Moteur L = new Moteur("lol",true,5);
		L.add("Faim",0,"./750.jpg","Blue");
	    	L.add("Propreter ",2,"./751.jpg","Green");
	    	System.out.println(L.toString());
	}  */    
	 	
	public Moteur(String Nom,boolean Sexe,int max){
		
		this.Nom=Nom;
		this.DateNaissance=new Date();
		this.Sexe=Sexe;

		this.max=max;
		nb_variable=0;	
		
		Sujet=new String[max];
		Valeur=new int[max];
		DateDerniereIncrementation=new Date[max];
	
	}
	public boolean add(String Sujeta,int Valeura,String imga,String color){
		
		
		
		if(nb_variable<max){
			Sujet[nb_variable]=Sujeta;
			Valeur[nb_variable]=Valeura;
			DateDerniereIncrementation[nb_variable]=new Date();

			nb_variable++;
			
			return true;
		}
		
		return false;
		
	}
	public boolean setSujet(int colonne,String Sujeta){
	
		if(colonne<=nb_variable){
		
			Sujet[colonne]=Sujeta;
			return true;	
		}
		return false;
	
	}
	public boolean setValeur(int colonne,int Valeura){

		if(colonne<=nb_variable){
	
			Valeur[colonne]=Valeura;
			return true;	
		}
		return false;

	}
	public boolean setDate(int colonne,Date D){

		if(colonne<=nb_variable){
	
			DateDerniereIncrementation[colonne]=D;
			return true;	
		}
		return false;

	}	

	public String getSujet(int colonne){
	
		if(colonne<=nb_variable){
		
			return Sujet[colonne];	
		}
		return null;
	
	}
	public int getValeur(int colonne){
	
		if(colonne<=nb_variable){
		
			return Valeur[colonne];	
		}
		return -1;
	
	}
	public Date getDate(int colonne){
	
		if(colonne<=nb_variable){
		
			return DateDerniereIncrementation[colonne];	
		}
		return null;
	
	}
	
	public int getMax(){
	
		return max;	
	
	}
	public int getNbVariable(){
	
		return nb_variable;	
	
	}
	public String toString(){
	
		String A="";

		A+="Nom : "+Nom+"\n";
		A+="DateNaissance : "+DateNaissance+"\n";
		A+="Sexe : "+((Sexe)?"Femme":"Homme")+"\n";
		
		A+="Sujet | Valeur | Date \n";
			
		for(int i=0;i<nb_variable;i++)
			A+=Sujet[i]+" | "+Valeur[i]+" | "+DateDerniereIncrementation[i].getTime()+"\n";
		return A;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}









