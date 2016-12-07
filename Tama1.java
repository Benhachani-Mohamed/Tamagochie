import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Graphics2D; 
import javax.swing.Timer ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Font;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.*; 
public class Tama1 extends Tamagochie { 

 	Graphique G;
	Moteur Kudret;
	int it;
	Date ecouler;
	int decrementationEau,decrementationNour,decrementationSom;
	int incrementationEau,incrementationNour,incrementationSom;
	int tempC;
	int tempE;
	int a,b,c,d,e;
	int pluieCompteur;
	boolean chargement = true;
	int fondFixe,fond,chargementNaissance,debut,chameauLvl0,chameauLvl2,chameauLvl3;
	public Tama1()
	{
		this.setBorder( BorderFactory.createEmptyBorder())	;
	   	this.addMouseListener(this);
		G=new Graphique(800,600,100,100,100);
		ecouler = new Date();
		this.addColor();
		this.chargerParam("config");
		this.add(G);
	}
	public void nouveau(String nom,boolean sexe)
	{
		Kudret=new Moteur(nom,sexe,3,true);
		Kudret.add("Soif",500);
		Kudret.add("Faim",500);
		Kudret.add("Sommeil",500);
		Kudret.SauvegardeDate();	
	}
	public boolean charger()
	{
		Kudret=new Moteur("",true,3,false);
		if(Kudret.Charger("sauvegarde") == true)
		{
			Kudret.ChargerDate("DateDeCreation");
			float dec = ( ecouler.getTime() - Kudret.getDate(0).getTime() ) / 1000 ;
			dec = dec * this.decrementationEau;
			for(int i = 0 ; i < 3 ; i ++ )
				Kudret.setValeurDec(i,(int)dec);
			return true;		
		}
		return false;
	}
	public void addColor()
	{
		G.addColor(0,150,0,255);
		G.addColor(255,0,0,255);
		G.addColor(255,69,0,255);
	}
	public void start()
	{
		imageLoad();
		setCouleur();
		setTime();
		new Timer(500, taskPerformer).start();
	}
	public void setCouleur()
	{
		G.setColor(11,1);
		G.setColor(13,1);
		G.setColor(15,1);
		G.setColor(21,2);
	}
	public void setTime()
	{
		a = 3+this.tempC;
		b = 3+this.tempC + this.tempE ; 
		c = 3+(2*this.tempC) + this.tempE;
		d = 3+(2*this.tempC) + (2*this.tempE);
		e = 3+(3*this.tempC) + (2*this.tempE);
	}	
	public void imageLoad()
	{
		G.addImgStable("image/fond.gif",0,0,800,600,false,false);		//0
		G.addImg("image/fond.gif",0,0,800,600,false,false);				//1	
		G.addImg("image/debut.gif",0,0,800,600,false,false);				//2	
		G.addImg("image/chameau_lvl_0.gif",0,-100,800,600,false,false);	//3	
		G.addImg("image/chameau_lvl_1.gif",0,-100,800,600,false,false);	//4
		G.addImg("image/chameau_lvl_2.gif",0,-100,800,600,false,false);	//5
		G.addImg("image/pluie.gif",0,0,800,600,false,false);//6
		G.addImgStable("image/bouton_eau.gif",5,5,50,50,false,true);	//7
		G.addImgStable("image/bouton_nour.gif",5,60,50,50,false,true);	//8
		G.addImg("image/zzz.gif",5,115,50,50,false,true);	//9
		G.addRectangle(59,19,102,22,false,false);//10
		G.addRectangle(60,20,100,20,false,false);//11
		G.addRectangle(59,74,102,22,false,false);//12
		G.addRectangle(60,75,100,20,false,false);//13
		G.addRectangle(59,129,102,22,false,false);//14
		G.addRectangle(60,130,100,20,false,false);//15
		G.addTexte("Nom : "+Kudret.Nom,600,27,0,0,false,false);//16
		G.addImg("image/chargement.gif",0,0,800,600,false,false);//17
		G.addTexte("Votre Oeuf eclot ,",300,100,0,0,false,false);//18
		G.addTexte(Kudret.Nom+" est entrain de naître ...(chargement)",100,150,0,0,false,false);//19
		G.addTexte(Kudret.Nom+" évolue !!!",300,100,0,0,false,false);//20
		G.addRectangle(0,0,800,600,false,false);//21
		G.addTexte(Kudret.Nom+" est mort !!!!!",280,295,0,0,false,false);//22
		G.addImgStable("image/eau_click.gif",5,5,50,50,false,false);	//23
		G.addImgStable("image/nour_click.gif",5,60,50,50,false,false);	//24
		G.addImg("image/zzz_click.gif",5,115,50,50,false,false);	//25
		G.addTexte(Kudret.Nom+" est malade !!!",300,100,0,0,false,false);//26
		G.addTexte("Ces point de vie diminuent deux fois plus vite",170,150,0,0,false,false);//27
	}
	public void clear()
	{
		for(int i = 0 ; i < 6 ; i++)
			G.setAffiche(i, false);
		for(int i = 7 ; i < 26 ; i++)
			G.setAffiche(i, false);
				
	}
	public void naissance()
	{
		chargement = true;
		G.setAffiche(0, true );
		G.setAffiche(2, true);
	}
	public void chargementN()
	{
		chargement = true;
		clear();
		for( int i = 17 ; i < 20 ; i++ )
		 	G.setAffiche(i, true) ; 
		G.setAffiche(6, false); 
		G.setAffiche(26, false);
		G.setAffiche(27, false);
	}
	public void chargement()
	{
		chargement = true;
		clear();
		G.setAffiche(17, true);
		G.setAffiche(20, true);
		G.setAffiche(6, false);		
		G.setAffiche(26, false);
		G.setAffiche(27, false);
	}
	public void niveau0()
	{
		chargement = false;
		clear();
		G.setAffiche(0, true );
		G.setAffiche(3, true);
		for(int i = 7; i < 17 ; i++ )
			G.setAffiche(i, true);
	}
	public void niveau(int i)
	{
		chargement = false;
		clear();
		G.setAffiche(1, true );
		G.setAffiche(i+3, true );	
		for(int j = 7 ; j < 17 ; j++ )
			G.setAffiche(j, true);	
	}
	public void fin()
	{
		clear();
		G.setAffiche(21, true);
		G.setAffiche(22, true);
		G.setAffiche(6 ,false);		
		G.setAffiche(26, false);
		G.setAffiche(27, false);
	}
	public void decrementation()
	{
		for(int i = 0 ; i < 3 ; i++ )
			Kudret.setDate(i,new Date());
		Kudret.setValeurDec(0, decrementationEau);
		Kudret.setValeurDec(1, decrementationNour);
		Kudret.setValeurDec(2, decrementationSom);
		Kudret.Sauvegarde();
	}
	public float getAge()
	{
		ecouler = new Date();
		float  age = (ecouler.getTime() -  Kudret.getDateNaissance().getTime()) / 1000;
			return age ;
	}
	public boolean mort()
 	{
		if(Kudret.getValeur(0)*Kudret.getValeur(1)*Kudret.getValeur(2) == 0 )
			return true;
		return false;
	}
	public void pluie()
	{
		System.out.println("azeaea");
		if(G.getAffiche(6) == 1)
		{		
			G.setAffiche(6, false);
			G.setAffiche(26, false);
			G.setAffiche(27, false);		
		}		
		else
		{		
			G.setAffiche(6, true);
			G.setAffiche(26, true);
			G.setAffiche(27, true);		
		}	
	}
  	public void mouseClicked(MouseEvent event)
	{  
		int r=G.getMenu(event.getX(),event.getY());
		System.out.println(r);
		if(r == 7)
		{
			Kudret.setValeurInc(0,this.incrementationEau);
			if(G.getAffiche(23) == 1)
				G.setAffiche(23, false);
			else
				G.setAffiche(23, true);
		}	
		else if(r==8)
		{	
			Kudret.setValeurInc(1,this.incrementationNour);
			if(G.getAffiche(24) == 1)
				G.setAffiche(24, false);
			else
				G.setAffiche(24, true);
		}	
		else if(r == 9)
		{	
			Kudret.setValeurInc(2,this.incrementationSom);
			if(G.getAffiche(25) == 1)
				G.setAffiche(25, false);
			else
				G.setAffiche(25, true);
		}	
		Kudret.Sauvegarde();
	}
	public void mouseEntered(MouseEvent event) 
	{    

	}
  	public void mouseExited(MouseEvent event) 
	{
   
	}
	public void mousePressed(MouseEvent event) 
	{

 	}
	public void mouseReleased(MouseEvent event) 
	{
 
  	}   
	public boolean chargerParam(String nom)
	{
		int compteur = 0;
		String str;
        BufferedReader fis;
		try 
		{
			int  donné[] = new int [9];
			/*String[] strp;
			fis = new BufferedReader(new FileReader(new File(nom+".txt")));
			if(fis.ready() == false )
			{
		      	return false;
		    }
			while(fis.hasNextLine())
			{
		    	str = fis.readLine();
		    	fis.close();
		    	strp = str.split(":");
			}*/
			Scanner scanner = new Scanner(new FileReader(nom+".txt"));
 			str = null;
			String[] strp;
			int i = 1;
 			while (i<9) 
			{
    			str = scanner.nextLine();
				strp = str.split(":");
				//System.out.println(strp[1]);
				donné[i] = Integer.parseInt(strp[1]);     
				i++;		
				// suite du traitement
 			}
		    this.tempC = donné [1];
			this.tempE = donné[2];
			this.decrementationEau = donné[3];
			this.decrementationNour = donné[4];
		    this.decrementationSom = donné[5];
		    this.incrementationEau = donné[6];
			this.incrementationNour = donné[7];
		    this.incrementationSom = donné[8];
		    scanner.close(); 
		    return true;
      	}	 
		catch (FileNotFoundException e) 
		{

         // Cette exception est levée si l'objet FileInputStream ne trouve

         // aucun fichier

       		return false;

      	} 
	}
	public void couleurRectangle()
	{
		int eau = Kudret.getValeur(0);
		int nour = Kudret.getValeur(1);
		int som  = Kudret.getValeur(2);
		if(eau < 100)
			G.setColor(11,2);
		else if(eau < 400 )
			G.setColor(11,3);
		else
			G.setColor(11,1);
		if (nour < 100)
			G.setColor(13,2);		
		else if(nour < 400 )
			G.setColor(13,3);
		else
			G.setColor(13,1);
		if(som < 100)
			G.setColor(15,2);		
		else if(som < 400 )
			G.setColor(15,3);
		else
			G.setColor(15,1);
	}
	ActionListener taskPerformer = new ActionListener() 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			Kudret.Afficher();
			G.setWidth(11, (int) (100*Kudret.getValeur(0)/500));
			G.setWidth(13, (int) (100*Kudret.getValeur(1)/500));
			G.setWidth(15, (int) (100*Kudret.getValeur(2)/500));
			it++;
			G.change(4,""+((new Date()).getTime()-ecouler.getTime()));
			float age = getAge();
			Random rnd = new Random();
			int nombre = rnd.nextInt(100);
			System.out.println("rnd :  " +nombre);
			System.out.println("Compteur pluie :  " +pluieCompteur); 
			couleurRectangle();
			// --------- PLUIE ----------//
			if(it%2 == 0 && chargement == false)
			{
				if(nombre%1 == 0 && pluieCompteur == 0 )
				{
					pluie();
		 			pluieCompteur ++ ;
		 		}
		 		if(pluieCompteur >0 && pluieCompteur < 10)
		 		{
					pluieCompteur ++ ;
		 			decrementation();
		 		}
		 		else if(pluieCompteur == 10 )
				{
		 			pluie();
					pluieCompteur = 0;
				}
			}
			//----------------------------//
			//---------Age du chameau-------------//
			//System.out.println(G.max);
			if(mort())
				fin();
			else if( age < 3 )//chargement debut
				naissance();
			//-------Definition du niveau----------------//
			else if( age > 3 && age < a )//chargement debut
				chargementN();				
			else if(age > a && age < b)//chameau niveau 0
				niveau0();			
			else if(age > b && age < c )//chargement evolution
				chargement();
			else if(age >c && age  <d)
				niveau(1);
			else if(age > d && age < e )//chargement evolution
				chargement();
			else if(age > e)
				niveau(2);	
			if(it%2 == 0)
				decrementation();
			G.repaint();				
		}
	};
}
