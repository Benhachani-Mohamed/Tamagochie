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
		Kudret=new Moteur("Ardian",true,3);
		ecouler = new Date();	
		this.add(G);
		G.addImgStable("image/fond.gif",0,0,800,600,true,false);		//0
		G.addImg("image/fond.gif",0,0,800,600,false,false);				//1	
		G.addImg("image/debut.gif",0,0,800,600,true,false);				//2	
		G.addImg("image/chameau_lvl_0.gif",0,-100,800,600,false,false);	//3	
		G.addImg("image/chameau_lvl_1.gif",0,-100,800,600,false,false);	//4
		G.addImg("image/chameau_lvl_2.gif",0,-100,800,600,false,false);	//5
		G.addImgStable("image/bouton_eau.gif",-70,-60,200,200,true,true);	//6
		G.addImgStable("image/bouton_nour.gif",-70,0,200,200,true,true);	//7
		G.addImg("image/zzz.gif",-70,60,200,200,true,true);	//8		
		G.addImg("image/chargement.gif",0,0,800,600,false,false);//9
		G.addTexte("Votre Oeuf eclot ,",300,100,0,0,false,false);//10
		G.addTexte("un dromadaire est entrain de naître ...(chargement)",100,150,0,0,false,false);//11
		G.addTexte("Votre dromadaire évolue !!!",250,100,0,0,false,false);//12
			
		G.repaint();		
		
		
		
		//Apelle d'un Timer qui effectuera une action chaque seconde
		
		 ActionListener taskPerformer = new ActionListener() {
		 
			public void actionPerformed(ActionEvent evt) {
			
				it++;
				Kudret.
				G.change(4,""+((new Date()).getTime()-ecouler.getTime()));
				ecouler = new Date();
				if(it == 4)
				{
					G.affiche[6] = false;	
					G.affiche[7]=false;
					G.affiche[8] = false;
					G.affiche[0]=false;
					G.affiche[2]=false;							
					G.affiche[9] = true;
					G.affiche[10] = true;
					G.affiche[11] = true;
				}
				else if(it == 8)
				{
					G.affiche[9] = false;
					G.affiche[10] = false;
					G.affiche[11] = false;
					G.affiche[6] = true;	
					G.affiche[7]=true;
					G.affiche[8] = true;
					G.affiche[0] = true;
					G.affiche[3] = true; 
				}
				else if(it == 16)
				{
					G.affiche[12] = true;
					G.affiche[9] = true;	
					G.affiche[0]=false;
					G.affiche[3] = false;
					G.affiche[6] = false;	
					G.affiche[7]=false;
					G.affiche[8] = false;							
				}
				else if (it == 20)
				{
					G.affiche[12] = false;
					G.affiche[9] = false;
					G.affiche[6] = true;	
					G.affiche[7]=true;
					G.affiche[8] = true;
					G.affiche[1]=true;
					G.affiche[4] = true;
				}
				else if (it == 24)
				{
					G.affiche[12] = true;
					G.affiche[9] = true;	
					G.affiche[1]=false;
					G.affiche[4] = false;
					G.affiche[6] = false;	
					G.affiche[7]=false;
					G.affiche[8] = false;		
				}
				else if(it == 30)
				{
					G.affiche[12] = false;
					G.affiche[9] = false;	
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
