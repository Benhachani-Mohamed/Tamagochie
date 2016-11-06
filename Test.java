import javax.swing.JFrame;

 

public class Test {

  public static void main(String[] args){

    JFrame fenetre = new JFrame();
    
  	fenetre.setTitle("Tamagochie");

	fenetre.setSize(800, 600);
	fenetre.setResizable(false);
	fenetre.setLocationRelativeTo(null);               

	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
	Tamagochie A = new Tama1();
	
	
	
	
    	fenetre.setContentPane(A);


    fenetre.setVisible(true);

  }       

}
