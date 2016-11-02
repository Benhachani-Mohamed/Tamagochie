import javax.swing.JFrame;

 

public class Test {

  public static void main(String[] args){

    JFrame fenetre = new JFrame();
    fenetre.setTitle("Ma première fenêtre Java");

    fenetre.setSize(2000, 500);

    fenetre.setLocationRelativeTo(null);               

    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	Tama1 A = new Tama1();
    fenetre.setContentPane(A);


    fenetre.setVisible(true);

  }       

}
