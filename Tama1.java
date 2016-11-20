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
	
	
	
	int carl,phoenix,bulle,bob,txt;
	
	public Tama1(){
		this.setBorder( BorderFactory.createEmptyBorder())	;
		
	    	this.addMouseListener(this);
	    	
		G=new Graphique(800,600,100,100,100);
		
			
		this.add(G);
			//	this.add(this);
			
				G.repaint();		


		G.addColor(158,55,208,255);
		G.addColor(56,156,70,255);
		G.setColor(G.addRectangle(20,20,300,300,true,false),2);
		//Apelle d'un Timer qui effectuera une action chaque seconde
		
		 ActionListener taskPerformer = new ActionListener() {
		 
			public void actionPerformed(ActionEvent evt) {
				
				//System.out.println("LOL");
				if(it == 17){
					
					carl += 400;
					it=0;
					
				}
				int ok=G.addFont("Courier", Font.BOLD, 20);
					
				
				//System.out.println(ok);
				G.setColor(G.addTexte(""+(new Date())+" "+ok,carl,30*++it,0,0,true,false),1);
				
				
				
				
				
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
