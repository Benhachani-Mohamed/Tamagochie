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
public class Tama1 extends Tamagochie { 

 	Graphique G;
	Moteur Kudret;
	int it;
	Date ecouler;
	
	
	int carl,phoenix,bulle,bob,txt;
	
	public Tama1(){
		this.setBorder( BorderFactory.createEmptyBorder())	;
		
	    	this.addMouseListener(this);
	    	
		G=new Graphique(800,600,100,100,100);
		Kudret=new Moteur("Ardian",true,3,false);
		if(Kudret.nouveau)
		{
			Kudret.SauvegardeDate();
			Kudret.add("Soif",0," ","Blue");
			Kudret.add("Faim",0," ","Blue");
			Kudret.add("Sommeil",0," ","Blue");
		}
		else
		{	
			Kudret.Charger("sauvegarde");
			Kudret.ChargerDate("DateDeCreation");
		}
		Kudret.Afficher();
		Kudret.Sauvegarde();
		ecouler = new Date();	
		this.add(G);
		G.addImgStable("image/fond.gif",0,0,800,600,false,false);		//0
		G.addImg("image/fond.gif",0,0,800,600,false,false);				//1	
		G.addImg("image/debut.gif",0,0,800,600,false,false);				//2	
		G.addImg("image/chameau_lvl_0.gif",0,-100,800,600,false,false);	//3	
		G.addImg("image/chameau_lvl_1.gif",0,-100,800,600,false,false);	//4
		G.addImg("image/chameau_lvl_2.gif",0,-100,800,600,false,false);	//5
		G.addImgStable("image/bouton_eau.gif",5,5,50,50,false,true);	//6
		G.addImgStable("image/bouton_nour.gif",5,60,50,50,false,true);	//7
		G.addImg("image/zzz.gif",5,115,50,50,false,true);	//8		
		G.addImg("image/chargement.gif",0,0,800,600,false,false);//9
		G.addTexte("Votre Oeuf eclot ,",300,100,0,0,false,false);//10
		G.addTexte("un dromadaire est entrain de naître ...(chargement)",100,150,0,0,false,false);//11
		G.addTexte("Votre dromadaire évolue !!!",250,100,0,0,false,false);//12
		G.addTexte("Votre dromadaire est mort !!!!!",250,100,0,0,false,false);//13
			
		G.repaint();		
		
		
		
		//Apelle d'un Timer qui effectuera une action chaque seconde
		
		 ActionListener taskPerformer = new ActionListener() {
		 
			public void actionPerformed(ActionEvent evt) {
				System.out.println();
				boolean vie = true;
				boolean chargement = false;
				int niveau;
				niveau = 5;
				it++;
				G.change(4,""+((new Date()).getTime()-ecouler.getTime()));
				ecouler = new Date();
				float age = (ecouler.getTime() -  Kudret.getDateNaissance().getTime()) / 1000;
				System.out.println(age);
				if(age > 0 && age <4)
					niveau = 0;
				else if( age >4 && age <16)
					niveau = 1;
				else if(age >16)
					niveau = 2;
				/*if(it % 5 == 0 && vie == true)
				{
					Kudret.setValeur(0, 1) ;
					Kudret.setValeur(1,3 );
					Kudret.setValeur(2,2) ;
					Kudret.Sauvegarde();
				}*/
				if(Kudret.getValeur(0) == 10 && vie == true)
				{
					vie = false;
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[13]= true;
				}
				//chargement naissance 
				/*else if(age == 4 && vie == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;					
					G.affiche[9] = true;
					G.affiche[10] = true;
					G.affiche[11] = true;
				}*/
				//chameau niveau 0
				if(niveau == 0 && vie == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[6] = true;	
					G.affiche[7]=true;
					G.affiche[8] = true;
					G.affiche[0] = true;
					G.affiche[3] = true; 
				}
				/*else if( age == 10)
					chargement = true;
				else if (age == 12)
					chargement = false;
				//chargement evolution
				else if(chargement == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[12] = true;
					G.affiche[9] = true;						
				}*/
				else if (niveau == 1 && vie == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[6] = true;	
					G.affiche[7]=true;
					G.affiche[8] = true;
					G.affiche[1]=true;
					G.affiche[4] = true;
				}
				else if(niveau == 2 && vie == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[1]=true;
					G.affiche[5] = true;
					G.affiche[6] = true;	
					G.affiche[7]=true;
					G.affiche[8] = true;		
				}	
					

				G.repaint();		
				
			}
		};
		
		new Timer(1000, taskPerformer).start();

	}
     
  public void mouseClicked(MouseEvent event) {
  
	int r=G.getMenu(event.getX(),event.getY());
	System.out.println(r);
	if(r == 6)
		Kudret.setValeur(0,10);
	else if(r==7)
		Kudret.setValeur(1,5);
	else if(r == 8 )
		Kudret.setValeur(2,1);
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
