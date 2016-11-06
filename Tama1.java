import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import javax.swing.BorderFactory;

import java.awt.Graphics2D; 
public class Tama1 extends Tamagochie { 

 Graphique G;
	int it;
	public Tama1(){
		this.setBorder( BorderFactory.createEmptyBorder())	;
		
	    	this.addMouseListener(this);
	    	
		G=new Graphique(800,600,100,100);
		
		G.addImg("Back.jpg",0,0,800,600,true,false);
		G.addImg("giphy.gif",0,0,500,500,true,false);
		G.addImg("Rising_phoenix.png",0,0,200,200,true,true);
		G.addImg("large.gif",0,0,500,500,false,false);	
		G.addImg("giphy2.gif",0,0,500,500,false,false);

			G.addTexte("La verite c'est vrai",200,300,200,200,true,false);	
			
				this.add(G);

	}
	  public void play(Graphics g){

	  }
	  public void paintComponent(Graphics g){
	//play( g);


		//while(true){
		//	G.draw(g);
			

		//}		add(new JPanel());


		//G.clear(g);
		//System.out.println(G.tString()); 
		//setVisible(false);
		
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée

  
  }  
               
  public void mouseClicked(MouseEvent event) {
  
 	// System.out.println("("+event.getX()+","+event.getY()+")");
//  	System.out.println("Clicker c'est trop bien " + G.getMenu(event.getX(),event.getY())); 
	int r=G.getMenu(event.getX(),event.getY());
	
	if(r ==2){
		if(it==0){
		
			G.affiche[1]=false;
			G.affiche[4]=true;
			it++;
		}
		else{
			G.affiche[4]=false;
			G.affiche[1]=true;
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
