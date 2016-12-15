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
/**
 * Moteur est une classe de gestion des attribut du tamagoschie ,elles contient nom,age,variables vitales... 
 * @see Tamagochie
 * @author Kustul Kudret
 * @version 1.0
 */
public class Moteur {
	 /**
         * Nom représente le nom du tama
     */
	private String Nom;
	 /**
         * DateNaissance représente la date de naissance du tama
     */
 	private Date DateNaissance;
	/**
         * vie représente l'état vitale  du tama
     */
	private boolean vie;
	/**
         * Sexe représente le sexe  du tama
     */
	private boolean Sexe;
	/**
         * nouveau sert a savoir si le tama est nouveau ou s'il a été chargé
     */
	private boolean nouveau;
	/**
         * nb_variable sert a savoir le nombre de variable vitale du tama
     */
	private int nb_variable;
	/**
         * max sert a savoir le nombre maximale de variable vitale du tama
     */
	private int max;
	/**
         * Sujet sert a stocké le nom des variable vitale du tama(soif par exemple)
     */
	private String Sujet[];
	/**
         * Valeur sert a stocké les valeur des sujets vitaux du tama(soif par exemple)
     */
	private int Valeur[];
	/**
         * DateDerniereIncrementation sert a stocké les dates de dernière modifications des valeurs des sujets vitaux du tama(soif par exemple)
     */
	private Date DateDerniereIncrementation[];
	
	/**
 		* Cette fonction renvoie le nom du tamagotschie
 		* @return le Nom du tamagotschie
 	*/
	public String getNom()
	{
		return Nom;
	}
	/**
 		* Cette fonction sauvegarde la date de naissance du tama
 		* @return Rien	
 	*/
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
	
	/**
 		* Cette fonction sauvegarde les paramétre du tama (Nom,sexe,sujet(eau,nour,someil),valeur("","",""),date de dernière  modification des variables précédentes
 		* @return Rien	
 	*/
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
	
	/**
 		* Cette fonction charge la date de naissance
 		* @return True si le chargement a reussi False sinon	
 	*/
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
	
	/**
 		*  Cette fonction charge les paramétre du tama (Nom,sexe,sujet(eau,nour,someil),valeur("","",""),date de dernière  modification des variables précédentes
 		* @return Rien	
 	*/
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
	/**
 		* Cette fonction est le constructeur de Moteur
 		*@param Nom nom du tama
 		*@param Sexe  sexe du tama
 		*@param max nombres de variable(eau,nour,sommeil) 
 		*@param nouveau True si on créé un nouveau tama False sinon
 		* @return Rien	
 	*/
	public Moteur(String Nom,boolean Sexe,int max,boolean nouveau){
		
		this.Nom=Nom;
		this.DateNaissance=new Date();
		this.Sexe=Sexe;
		this.nouveau = nouveau;
		this.max=max;
		nb_variable=0;	
		this.vie = true;
		Sujet=new String[max];
		Valeur=new int[max];
		DateDerniereIncrementation=new Date[max];
	
	}
	/**
 		* Cette fonction ajoute une variable dans les tableaux des variables
 		*@param Nom nom du tama
 		*@param Sexe  sexe du tama
 		* @return True si l'ajout a été fair False sinon
 	*/
	public boolean add(String Sujeta,int Valeura)
	{
		if(nb_variable<max){
			Sujet[nb_variable]=Sujeta;
			Valeur[nb_variable]=Valeura;
			DateDerniereIncrementation[nb_variable]=new Date();

			nb_variable++;
			
			return true;
		}
		
		return false;
		
	}
	/**
 		*Cette fonction sert a modifié un sujet
 		*@param colonne index du sujet
 		*@param Sujeta nouveau nom du sujet
 		* @return True si le changement a été fait False sinon	
 	*/
	public boolean setSujet(int colonne,String Sujeta){
	
		if(colonne<=nb_variable){
		
			Sujet[colonne]=Sujeta;
			return true;	
		}
		return false;
	
	}
	/**
 		*Cette fonction sert a decrementé une valeur
 		*@param colonne index de la valeur
 		*@param Valeura valeur a decrementé
 		* @return True si le changement a été fait False sinon	
 	*/
	public boolean setValeurDec(int colonne,int Valeura){

		if(colonne<=nb_variable){
			if(Valeur[colonne] - Valeura <= 0)
				Valeur[colonne] = 0 ;
			else
				Valeur[colonne]-=Valeura;
			return true;	
		}
		return false;

	}
	/**
 		*Cette fonction sert a incrementé une valeur
 		*@param colonne index de la valeur
 		*@param Valeura valeur a incrementé
 		* @return True si le changement a été fait False sinon	
 	*/
	public boolean setValeurInc(int colonne,int Valeura){

		if(colonne<=nb_variable ){
				if(Valeur[colonne] + Valeura <=500)
					Valeur[colonne]+=Valeura;
				else
					Valeur[colonne]=500;
			return true;	
		}
		return false;

	}
	/**
 		*Cette fonction sert à enregistrer la dernière date de modification d'une des trois variables(eau,nourriture,sommeil)
 		*@param colonne index de la valeur
 		*@param D Date de dernière modification
 		* @return True si le changement a été fait False sinon	
 	*/
	public boolean setDate(int colonne,Date D){

		if(colonne<=nb_variable){
	
			DateDerniereIncrementation[colonne]=D;
			return true;	
		}
		return false;

	}	
	/**
 		*Cette fonction sert à récupérer le sujet d'une colonne
 		*@param colonne index du sujet
 		* @return Le sujet si la colonne existe  False sinon	
 	*/
	public String getSujet(int colonne){
	
		if(colonne<=nb_variable){
		
			return Sujet[colonne];	
		}
		return null;
	
	}
	/**
 		*Cette fonction sert à récupérer le valeur d'une colonne associé à un sujet
 		*@param colonne index de la valeur
 		* @return La valeur si la colonne existe  False sinon	
 	*/
	public int getValeur(int colonne){
	
		if(colonne<=nb_variable){
		
			return Valeur[colonne];	
		}
		return -1;
	
	}
	/**
 		*Cette fonction sert à récupérer la date de dernière modification d'une variable
 		*@param colonne index de la valeur
 		* @return La date si la colonne existe  False sinon	
 	*/
	public Date getDate(int colonne){
	
		if(colonne<=nb_variable){
		
			return DateDerniereIncrementation[colonne];	
		}
		return null;
	
	}
	/**
 		*Cette fonction sert à récupérer la date de naissance
 		* @return La date de naissance 	
 	*/
	public Date getDateNaissance(){
			return DateNaissance;	
	}
	
	public int getMax(){
	
		return max;	
	
	}
	/**
 		*Cette fonction sert à récupérer le nombre de variable(eau,sommeil,nouriture)
 		* @return Le nombre de variable(ici il y en a 3 par defaut)	
 	*/
	public int getNbVariable(){
	
		return nb_variable;	
	
	}
	/**
 		*Cette fonction sert à afficher sert a affficher toutes les informations relatives au tama
 		* @return rien	
 	*/
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









