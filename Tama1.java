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
	int it;
	Date ecouler;
	
	
	int carl,phoenix,bulle,bob,txt;
	
	public Tama1(){
		this.setBorder( BorderFactory.createEmptyBorder())	;
		
	    	this.addMouseListener(this);
	    	
		G=new Graphique(800,600,100,100,100);
		
		ecouler = new Date();	
		this.add(G);

		G.addImgStable("fond.gif",0,0,800,600,true,false);
		G.addImg("fond.gif",0,0,800,600,false,false);
		G.addImg("debut.gif",0,0,800,600,true,false);	
		G.addImg("chameau_lvl_3.gif",0,-100,800,600,false,false);
		G.addTexte("qmsldkqmlsdkq",0,100,800,600,true,false);			
		G.repaint();		
		
		
		
		//Apelle d'un Timer qui effectuera une action chaque seconde
		
		 ActionListener taskPerformer = new ActionListener() {
		 
			public void actionPerformed(ActionEvent evt) {
			
				it++;
				G.change(4,""+((new Date()).getTime()-ecouler.getTime()));
				ecouler = new Date();
				if(it == 4){
						G.affiche[0]=false;
						G.affiche[1]=true;

						G.affiche[2]=false;
						G.affiche[3]=true;
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
