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
		G.addImgStable("image/fond.gif",0,0,800,600,true,false);		//0
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
		G.addImgStable("image/eau_click.gif",5,5,50,50,false,false);	//14
		G.addImgStable("image/nour_click.gif",5,60,50,50,false,false);	//15
		G.addImg("image/som_click.gif",5,115,50,50,false,false);	//16	
			
		G.repaint();		
		//---------Test---------------//
		Kudret.setValeurInc(0,500);
		Kudret.setValeurInc(1,500);
		Kudret.setValeurInc(2,500);
		//---------Test---------------//
		
		//Apelle d'un Timer qui effectuera une action chaque seconde
		
		 ActionListener taskPerformer = new ActionListener() {
			public void niveau_0(int i){
				for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
				G.affiche[1] = true ;
				G.affiche[i+3] = true ;		
			}
			public void pluie(){
							
			}
		 
			public void actionPerformed(ActionEvent evt) {
			
				//Kudret.Afficher();
				boolean vie = true;
				boolean chargement = false;
				boolean chargementEvolution = false;
				boolean debut = false;
				int niveau;
				niveau = 5;
				it++;
				G.change(4,""+((new Date()).getTime()-ecouler.getTime()));
				ecouler = new Date();
				//---------Age du chameau-------------//
				float age = (ecouler.getTime() -  Kudret.getDateNaissance().getTime()) / 1000;
				System.out.println(age);
				//-------Definition du niveau----------------//
				if( age > -1 && age < 3 )//oeuf
					debut = true;
				else if( age > 3 && age < 8 )//chargement debut
				{
					debut = false;
					chargement = true;
				}				
				else if(age > 8 && age < 20)//chameau niveau 0
				{
					niveau = 0;
					chargement = false;
				}			
				else if(age > 20 && age < 24 )//chargement evolution
				{
					chargementEvolution = true;
				}	
				else if(age >24 && age <30)
				{
					niveau = 1;
					chargementEvolution = false;
				}				
				else if(age > 30 && age < 34 )//chargement evolution
				{
					chargementEvolution = true;
				}	
				else if(age >34)
				{
					niveau = 2;
					chargementEvolution = false;
				}				
				// La mort du chaeau //
				if(Kudret.getValeur(0)*Kudret.getValeur(1)*Kudret.getValeur(2) == 0 )
				{
					vie = false;
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[13] = true;
					
	
				}
				//---------------Decrementation des variable toutes les 2 secondes -------------//
				if(it % 2 == 0 && vie == true)
				{
					Kudret.setValeurDec(0, -1) ;
					Kudret.setValeurDec(1, -2);
					Kudret.setValeurDec(2,-3) ;
					Kudret.Sauvegarde();
				}
				//-----------debut------------//
				if(debut)
				{
					G.affiche[0] = true;
					G.affiche[2] = true;
				}				
				//chargement naissance 
				else if( chargement == true && vie == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;					
					G.affiche[9] = true;
					G.affiche[10] = true;
					G.affiche[11] = true;
				}
				
				//-----------chameau niveau 0 ------------//
				else if(niveau == 0 && vie == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[6] = true;	
					G.affiche[7]=true;
					G.affiche[8] = true;
					G.affiche[1] = true;
					G.affiche[3] = true;
				}
				//chargement evolution
				else if(chargementEvolution == true)
				{
					for(int i = 0 ; i < 14 ; i++)
						G.affiche[i] = false;
					G.affiche[12] = true;
					G.affiche[9] = true;						
				}
				else if (niveau == 1 && vie == true)
				{
					niveau(1);
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
	{
		Kudret.setValeurInc(0,10);
		if(G.affiche[14])
			G.affiche[14] = false;
		else
			G.affiche[14] = true;
	}	
	else if(r==7)
	{	
		Kudret.setValeurInc(1,5);
		if(G.affiche[15])
			G.affiche[15] = false;
		else
			G.affiche[15] = true;
	}	
	else if(r == 8 )
	{	
		Kudret.setValeurInc(2,1);
		if(G.affiche[16])
			G.affiche[16] = false;
		else
			G.affiche[16] = true;
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
