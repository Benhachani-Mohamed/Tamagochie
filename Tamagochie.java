import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
 abstract class Tamagochie extends JButton implements MouseListener{
 Graphique G;
  abstract void play(Graphics g); //Des fonction partager par tout les Tamagochie

}

