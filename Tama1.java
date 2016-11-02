import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import javax.swing.BorderFactory;
public class Tama1 extends Tamagochie { 

 Graphique G;

	public Tama1(){
		this.setBorder( BorderFactory.createEmptyBorder())	;
	    this.addMouseListener(this);
		G=new Graphique("Back.jpg","C.png",2000,500);
		G.addMenu("Rising_phoenix.png",0,0,200,200);

	
	}
  public void play(Graphics g){
    System.out.println("Je suis exécutée !"); 

    g.fillOval(20, 20, 75, 75);
        g.setColor(Color.red);          
    g.fillOval(0, 20, 75, 75);
  }
  public void paintComponent(Graphics g){
	//play( g);




		G.draw(g);
		//G.clear(g);
		System.out.println(G.tString()); 
		
		
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée

  
  }  
               
  public void mouseClicked(MouseEvent event) {
  
 	 System.out.println("("+event.getX()+","+event.getY()+")");
  	System.out.println("Clicker c'est trop bien " + G.getMenu(event.getX(),event.getY())); 

	if( G.getMenu(event.getX(),event.getY())==0)
	G.addMenu("tux.png",200,0,200,200);

	System.out.println("Apres clic "+G.tString()); 
	
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
