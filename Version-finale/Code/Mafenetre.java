
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Mafenetre extends JFrame implements ActionListener{
 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 //private Panneau pan = new Panneau();
  private JButton bouton1 = new JButton("Nouveau");
  private JButton bouton2 = new JButton("Charger");
  private JPanel container = new JPanel();
  private JLabel label = new JLabel("etes-Vous pret a jouer O/N");
  //private int compteur = 0;
 private Tamagochie A;
           
        JTextField txt_center = new JTextField();
        JLabel lb_top = new JLabel();
        JLabel lb_down = new JLabel();
        JButton bt_submit = new JButton();


  public Mafenetre(){
    this.setTitle("Menu Principal");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    container.setBackground(Color.CYAN);
    container.setLayout(new BorderLayout());
   // container.add(pan, BorderLayout.CENTER);

    bouton1.addActionListener(this);
    bouton2.addActionListener(this);

    JPanel North = new JPanel();
    North.add(bouton1);
    North.add(bouton2);
    container.add(North, BorderLayout.NORTH);

    Font police = new Font("Tahoma", Font.BOLD, 16);
    label.setFont(police);
    label.setForeground(Color.blue);
    label.setHorizontalAlignment(JLabel.CENTER);
    container.add(label, BorderLayout.SOUTH);
    this.setContentPane(container);
    this.setVisible(true);

	A= new Tama1();

  }
  
  public static void main(String[] args){
  new Mafenetre();
  
  } 
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == bouton1)
	{ 
		
			nouveau();
		} 

	else if(e.getSource() == bouton2){
		A.charger(); 
		A.start();
		this.setContentPane(A);
               this.setVisible(true);
	}    
	
} 

public void nouveau(){

		Graphique G= new Graphique(800,600,100,100,100);
		G.addImg("image/fond.gif",0,0,800,600,true,false);
		int id_texte= G.addTexte("Nom",0,100,800,600,true,false);
		int id_couleur=G.addColor(200,152,100,255);
		G.setColor(id_texte,id_couleur);
		G.addRectangle(59,19,102,22,true,false)		;		//1					//1	
		this.add(G);
		//this.setVisible(true); 
		 G.repaint();
		
		A.nouveau("Ardian",true);
		this.setContentPane(A);
			
		A.start();
		this.setVisible(true); 

}
}
