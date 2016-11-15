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
public class Tama1 extends Tamagochie { 

 Graphique G;
	int it;
	
	
	
	int carl,phoenix,bulle,bob,txt;
	
	public Tama1(){
		this.setBorder( BorderFactory.createEmptyBorder())	;
		
	    	this.addMouseListener(this);
	    	
		G=new Graphique(800,600,100,100);
		
		
		
		G.addImg("Back.jpg",0,0,800,600,true,false);
		carl=G.addImg("giphy.gif",0,0,500,500,true,false);
		phoenix=G.addImg("Rising_phoenix.png",0,0,200,200,true,true);

		bob=G.addImg("giphy2.gif",0,0,500,500,false,false);
		bulle=G.addImg("large.png",300,400,500,200,true,false);	
		txt=G.addTexte("La verite c'est vrai",350,500,200,200,true,false);	
			
		this.add(G);
			//	this.add(this);
			
			  int delay = 1000; //milliseconds
			 ActionListener taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					
    					System.out.println("LOL");
    					G.change(txt,""+(new Date()));
    					
				}
			};
		new Timer(delay, taskPerformer).start();

	}
	  public void play(Graphics g){

	  }
	//  public void paintComponent(Graphics g){
	//play( g);


		//while(true){
		//	G.draw(g);
			

		//}		add(new JPanel());


		//G.clear(g);
		// 						System.out.println("LOL"); 
		//setVisible(false);
		
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
    
    
    	//while(true){
    		

    	
 // }  
               
  public void mouseClicked(MouseEvent event) {
  
 	// System.out.println("("+event.getX()+","+event.getY()+")");
//  	System.out.println("Clicker c'est trop bien " + G.getMenu(event.getX(),event.getY())); 
	int r=G.getMenu(event.getX(),event.getY());
	    		System.out.println("LOL");
	if(r ==2){
		if(it==0){
		
			G.affiche[carl]=false;
			G.affiche[bob]=true;
			it++;
		}
		else{
			G.affiche[bob]=false;
			G.affiche[carl]=true;
			it=0;
		
		}

	}
	
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
