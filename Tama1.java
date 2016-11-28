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
public class Tama1 extends Tamagochie { 

 	Graphique G;
	Moteur Kudret;
	int it;
	Date ecouler;
	int decrementationEau,decrementationNour,decrementationSom;
	int incrementationEau,incrementationNour,incrementationSom;
	int tempC;
	int tempE;
	int carl,phoenix,bulle,bob,txt;
	int a,b,c,d,e;
	public boolean chargerParam(String nom){
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
        this.tempC = Integer.parseInt(strp [1]);
		this.tempE = Integer.parseInt(strp[3]);
		this.decrementationEau = Integer.parseInt(strp[5]);
		this.decrementationNour = Integer.parseInt(strp[7]);
        this.decrementationSom = Integer.parseInt(strp[9]);
        this.incrementationEau = Integer.parseInt(strp[11]);
		this.incrementationNour = Integer.parseInt(strp[13]);
        this.incrementationSom = Integer.parseInt(strp[15]);
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
	public Tama1(){
		
		this.setBorder( BorderFactory.createEmptyBorder())	;
		
	    	this.addMouseListener(this);
	    	
		G=new Graphique(800,600,100,100,100);
		G.addColor(0,150,0,255);
		Kudret=new Moteur("Ardian",true,3,false);
		if(Kudret.nouveau)
		{
			Kudret.SauvegardeDate();
			Kudret.add("Soif",500," ","Blue");
			Kudret.add("Faim",500," ","Blue");
			Kudret.add("Sommeil",500," ","Blue");
		}
		else
		{	
			Kudret.Charger("sauvegarde");
			Kudret.ChargerDate("DateDeCreation");
		}
		Kudret.Sauvegarde();
		ecouler = new Date();	
		this.add(G);
		G.addImgStable("image/fond.gif",0,0,800,600,true,false);		//0
		G.addImg("image/fond.gif",0,0,800,600,false,false);				//1	
		G.addImg("image/debut.gif",0,0,800,600,false,false);				//2	
		G.addImg("image/chameau_lvl_0.gif",0,-100,800,600,false,false);	//3	
		G.addImg("image/chameau_lvl_1.gif",0,-100,800,600,false,false);	//4
		G.addImg("image/chameau_lvl_2.gif",0,-100,800,600,false,false);	//5
		G.addImgStable("image/bouton_eau.gif",5,5,50,50,false,true);	//6
		G.addImgStable("image/bouton_nour.gif",5,60,50,50,false,true);	//7
		G.addImg("image/zzz.gif",5,115,50,50,false,true);	//8			
		G.addRectangle(689,9,102,22,false,false);//9
		G.addRectangle(690,10,100,20,false,false);//10
		G.addRectangle(59,19,102,22,false,false);//11
		G.addRectangle(60,20,100,20,false,false);//12
		G.addRectangle(59,74,102,22,false,false);//13
		G.addRectangle(60,75,100,20,false,false);//14
		G.addRectangle(59,129,102,22,false,false);//15
		G.addRectangle(60,130,100,20,false,false);//16
		G.addTexte("PV",660,27,0,0,false,false);//17
		G.addImg("image/chargement.gif",0,0,800,600,false,false);//18
		G.addTexte("Votre Oeuf eclot ,",300,100,0,0,false,false);//19
		G.addTexte("un dromadaire est entrain de naître ...(chargement)",100,150,0,0,false,false);//20
		G.addTexte("Votre dromadaire évolue !!!",250,100,0,0,false,false);//21
		G.addTexte("Votre dromadaire est mort !!!!!",250,100,0,0,false,false);//22
		G.addImgStable("image/eau_click.gif",5,5,50,50,false,false);	//23
		G.addImgStable("image/nour_click.gif",5,60,50,50,false,false);	//24
		G.addImg("image/zzz_click.gif",5,115,50,50,false,false);	//25
		G.setColor(10,1);
		G.setColor(12,1);
		G.setColor(14,1);
		G.setColor(16,1);
			
		//---------Test---------------//
		this.chargerParam("config");
		a = 3+this.tempC;
		b = 3+this.tempC + this.tempE ; 
		c = 3+(2*this.tempC) + this.tempE;
		d = 3+(2*this.tempC) + (2*this.tempE);
		e = 3+(3*this.tempC) + (2*this.tempE);
		//Apelle d'un Timer qui effectuera une action chaque seconde
		 ActionListener taskPerformer = new ActionListener() 
		 {
		 	public void clear()
		 	{
		 		for(int i = 0 ; i < 26 ; i++)
						G.affiche[i] = false;
		 	}
		 	public void debut()
		 	{	
		 		clear();
		 		G.affiche[0] = true;
		 		G.affiche[2] = true;
		 	}
		 	public void naissance()
		 	{
		 		clear();				
				G.affiche[11] = true;
				G.affiche[10] = true;
		 	}
		 	public void chargementN()
		 	{
		 		clear();
		 		G.affiche[18] = true;
		 		G.affiche[19] = true;
		 		G.affiche[20] = true;
		 	}
		 	public void chargement()
		 	{
		 		clear();
		 		G.affiche[18] = true;
		 		G.affiche[21] = true;
		 	}
		 	public void niveau0()
		 	{
		 		clear();
		 		G.affiche[0] = true ;
		 		G.affiche[3] = true;
		 		for(int i = 6 ; i < 18 ; i++ )
		 			G.affiche[i] = true;
		 	}
		 	public void niveau(int i)
			{
				clear();
				G.affiche[1] = true ;
				G.affiche[i+3] = true ;	
				for(int j = 6 ; j < 18 ; j++ )
		 			G.affiche[j] = true;	
			}
			public void fin()
			{
				clear();
				Kudret.vie = false;
				G.affiche[13] = true;
			}
			public void decrementation()
			{
				Kudret.setValeurDec(0, 500 -  decrementationEau*(int) getAge()) ;
				Kudret.setValeurDec(1, 500 -  decrementationNour*(int) getAge());
				Kudret.setValeurDec(2,500 -  decrementationSom*(int) getAge());
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
			public void actionPerformed(ActionEvent evt) 
			{
				Kudret.Afficher();
				decrementation();
				G.Width[12] = (int) (100*Kudret.getValeur(0)/500);
				G.Width[14] = (int) (100*Kudret.getValeur(1)/500);
				G.Width[16] = (int) (100*Kudret.getValeur(2)/500);
				it++;
				G.change(4,""+((new Date()).getTime()-ecouler.getTime()));
				float age = getAge();
				//---------Age du chameau-------------//
				System.out.println(G.max);
				//if(mort())
					//fin();
				//-------Definition du niveau----------------//
				if( age > 0 && age < 3 )//oeuf
					debut();
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
				G.repaint();		
				
			}
		};
		
		new Timer(1000, taskPerformer).start();

	}
  public void mouseClicked(MouseEvent event) {
  
	int r=G.getMenu(event.getX(),event.getY());
	System.out.println(r);
	if(r == 6)
	{
		Kudret.setValeurInc(0,this.incrementationEau);
		if(G.affiche[23])
			G.affiche[23] = false;
		else
			G.affiche[23] = true;
	}	
	else if(r==7)
	{	
		Kudret.setValeurInc(1,this.incrementationNour);
		if(G.affiche[24])
			G.affiche[24] = false;
		else
			G.affiche[24] = true;
	}	
	else if(r == 8 )
	{	
		Kudret.setValeurInc(2,this.incrementationSom);
		if(G.affiche[25])
			G.affiche[25] = false;
		else
			G.affiche[25] = true;
	}	
	Kudret.Sauvegarde();

	
  }
  

  public void mouseEntered(MouseEvent event) {    


  }


  public void mouseExited(MouseEvent event) {
   

  }


  public void mousePressed(MouseEvent event) {

  }


  public void mouseReleased(MouseEvent event) {
 

  }   
}
