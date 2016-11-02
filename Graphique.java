import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
public class Graphique extends JPanel { 

	int FWidth,FHeight;
	Image Back;
	Image first;
	
	Image Menu[];
	int Cx[];
	int Cy[];
	int Width[];
	int Height[];
	
	int nb;



	public Graphique(String Background,String First,int width,int height){
	
		FWidth=width;
		FHeight=height;
		
		try {

			Back = ImageIO.read(new File(Background));

		} catch (IOException e) {

			 e.printStackTrace();

		} 	
		
		try {

			first = ImageIO.read(new File(First));

		} catch (IOException e) {

			 e.printStackTrace();

		} 	
		
		nb=0;
		Menu=new Image[100];
		Cx=new int[100];
		Cy=new int[100];
		Width=new int[100];
		Height=new int[100];
		
	}
	 public void draw(Graphics g){
	 
	    	 g.drawImage(Back, 0, 0,FWidth,FHeight, this);
	 	 g.drawImage(first, 0, 0,FWidth,FHeight, this);
	 	 
	 	 for(int i=0;i<nb;i++){
	 	 	 g.drawImage(Menu[i], Cx[i], Cy[i],Width[i],Height[i], this);
	 	 	 	 	System.out.println(i+",\n"); 
	 	}
	 }
	  public void clear(Graphics g){
	 
	    	g.setColor(Color.white);

    			//On le dessine de sorte qu'il occupe toute la surface

    			g.fillRect(0, 0, FWidth, FHeight);
	 }
	 
	public void addMenu(String path,int x,int y,int W,int H){
	 	try {
	 		Menu[nb] = ImageIO.read(new File(path));
	 	} catch (IOException e) {

			 e.printStackTrace();

		} 
	 	Cx[nb] = x;
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	
	 	nb++;
	 	System.out.println("NNN -> "+path+"  "+nb); 
	 
	}
	 
	 
	public int getMenu(int x,int y){
	
		for(int i=nb;i>=0;i--){
	 	 	if(x>=Cx[i] && y>=Cy[i] && x<=Width[i] && y<=Height[i])
	 	 		return i;
	 	 }
		
		return -1;
	}
	public String tString(){
	
		String S="";
		for(int i=nb;i>=0;i--)
	 	 	S=Cx[i] +"  " + Cy[i]+"  "+Width[i]+"  "+Height[i]+"\n"; 
	 	 	
	 	 return S;
	 	 	
	
	}
	public void Text(Graphics g,String S,int size,int x,int y){

		Font font = new Font("Courier", Font.BOLD, size);
	    	g.setFont(font);
	    	g.setColor(Color.black);          
	    	g.drawString(S, x, y);   




	}













}
