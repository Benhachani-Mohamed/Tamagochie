import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.*;
public class Moteur {
	
	String Nom;
	Date DateNaissance;
	boolean Sexe;
	boolean nouveau;
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
	    L.Sauvegarde();
	}   */
	public  void SauvegardeDate()
	{
		FileWriter fos = null;
		try
		{
			fos = new FileWriter("DateDeCreation.txt",false);
			Date DateNaissance = new Date();
			fos.write(""+DateNaissance.getTime()+"");
		}
		catch (FileNotFoundException e) 
		{
				e.printStackTrace();

	    } 
		catch (IOException e) 
	    {
	         e.printStackTrace();
	    }
		finally 
		{
	    	  try
	    	  {
	    		  if (fos != null)
	    			  fos.close();

	    	  } 
	    	  catch (IOException e) 
	    	  {
	    		  e.printStackTrace();

	         }
		}
	}
	public  void Sauvegarde()
	{
		FileWriter fos = null;
		try
		{
			fos = new FileWriter("sauvegarde.txt",false);
			fos.write(Nom+"-o-"+Sexe+"-o-"+nb_variable+"-o-"+max);
			for(int i = 0;i<DateDerniereIncrementation.length;i++)
			{
				fos.write("-o-"+Sujet[i]+"-o-"+Valeur[i]+"-o-"+DateDerniereIncrementation[i].getTime());
			}
		}
		catch (FileNotFoundException e) 
		{
				e.printStackTrace();

	    } 
		catch (IOException e) 
	    {
	         e.printStackTrace();
	    }
		finally 
		{
	    	  try
	    	  {
	    		  if (fos != null)
	    			  fos.close();

	    	  } 
	    	  catch (IOException e) 
	    	  {
	    		  e.printStackTrace();

	         }
		}
	}
	public boolean ChargerDate(String nom){
		int compteur = 0;
		String str;
        BufferedReader fis;
		 try {
		 fis = new BufferedReader(new FileReader(new File(nom+".txt")));
		if(fis.ready() == false ){
          	return false;
        }
        str = fis.readLine();
		this.DateNaissance = new Date(Long.parseLong(str));
		fis.close(); 
        return true;
      } catch (FileNotFoundException e) {

         // Cette exception est levée si l'objet FileInputStream ne trouve

         // aucun fichier

       return false;

      } catch (IOException e) {

         // Celle-ci se produit lors d'une erreur d'écriture ou de lecture

         return false;

      } 
	}
	public boolean Charger(String nom){
		int compteur = 0;
		String str;
        BufferedReader fis;
		 try {
		 fis = new BufferedReader(new FileReader(new File(nom+".txt")));
		if(fis.ready() == false ){
          	return false;
        }
        str = fis.readLine();
         fis.close();
        String[] strp ;
        strp = str.split("-o-");
        this.Nom = strp [0];
		//this.DateNaissance = new Date(Long.parseLong(strp[1]));
		this.Sexe=(strp[1]=="true");
		this.nb_variable=Integer.parseInt(strp[2]);
		this.max=Integer.parseInt(strp[3]);
		Sujet=new String[max];
		Valeur=new int[max];
		DateDerniereIncrementation=new Date[max];
		int index = 0;
		int taille = strp.length ;
		for(int i = 4 ; i < taille; i+=3 )
		{
			this.Sujet[index]=strp[i];
			this.Valeur[index]=Integer.parseInt(strp[i+1]);
			this.DateDerniereIncrementation[index]=new Date(Long.parseLong(strp[i+2]));
			index++;
		}
        fis.close(); 
        return true;
      } catch (FileNotFoundException e) {

         // Cette exception est levée si l'objet FileInputStream ne trouve

         // aucun fichier

       return false;

      } catch (IOException e) {

         // Celle-ci se produit lors d'une erreur d'écriture ou de lecture

         return false;

      } 
	}
	public Moteur(String Nom,boolean Sexe,int max,boolean nouveau){
		
		this.Nom=Nom;
		this.DateNaissance=new Date();
		this.Sexe=Sexe;
		this.nouveau = nouveau;
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
	
			Valeur[colonne]+=Valeura;
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
	public Date getDateNaissance(){
			return DateNaissance;	
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
	public void Afficher()
	{
		System.out.println("Nom : "+Nom);
		System.out.println("DateNaissance : "+DateNaissance);
		System.out.println("Sexe : "+((Sexe)?"Femme":"Homme"));
		System.out.println("Sujet | Valeur | Date ");
		for(int i=0;i<nb_variable;i++)
			System.out.println(Sujet[i]+" | "+Valeur[i]+" | "+DateDerniereIncrementation[i].getTime());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}









