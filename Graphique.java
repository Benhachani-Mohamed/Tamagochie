import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;



import java.awt.Toolkit ;

 import javax.swing.JLabel;
 
public class Graphique extends JPanel { 

	int FWidth,FHeight;
				//metre en private
	
	Image Img[];
	String Texte[];
	
	int Cx[];
	int Cy[];
	int Width[];
	int Height[];
	boolean affiche[];
	boolean clickable[];
	
	boolean type[];
	int reference[];
	
	int nb;
	int nb_texte;
	int nb_img;
	
	int max_texte;
	int max_img;

	//ajoute affiche une meme image plusiur fois
	public Graphique(int width,int height, int max_img,int max_texte) {//metre zone puis en commun avec Texte
	
		FWidth=width;
		FHeight=height;

		int max;
		
		if(!(max_img<0 || max_texte<0)){		
		
			this.max_img=max_img;
			this.max_texte=max_texte;

		}
		
		Img=new Image[this.max_img];
		Texte= new String[this.max_texte];
	
		max=this.max_img+this.max_texte;
		
		Cx=new int[max];
		Cy=new int[max];
		Width=new int[max];
		Height=new int[max];
		affiche=new boolean[max];
	 	clickable=new boolean[max];
	 	
	 	type=new boolean[max];
	 	reference=new int[max];
	
	}
	
	 public void paintComponent(Graphics g){
		//clear(g);
	 	 for(int i=0;i<nb;i++){
	 	 	if(affiche[i]){
		 	 	if(type[i]){
		 	 		 g.drawImage(Img[reference[i]], Cx[i], Cy[i],Width[i],Height[i], this);



		 	 	}
				else{
		
		
					Font font = new Font("Courier", Font.BOLD, 20);
				    	g.setFont(font);
				    	g.setColor(Color.black);          
				    	g.drawString(Texte[reference[i]],Cx[i], Cy[i]); 
				}
			}
	 	}


		 
	}
	 public void clear(Graphics g){
	 
	    	g.setColor(Color.white);
    		g.fillRect(0, 0, FWidth, FHeight);
	 }
	 
	public int addImg(String path,int x,int y,int W,int H,boolean display,boolean click){
	
		if(nb_img>=max_img)
			return -1;
			
			 Toolkit tk = Toolkit.getDefaultToolkit();

        		Img[nb_img] = tk.createImage(path);
        		tk.prepareImage(Img[nb_img] , -1, -1, null);


	 
		reference[nb]=nb_img;
		
		nb_img++;
		
		type[nb]=true;
	 	Cx[nb] = x;
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;
	 	
		return nb-1;
	 	
	 
	}
	public int addTexte(String S,int x,int y,int W,int H,boolean display,boolean click){
	
		if(nb_texte>=max_texte)
			return -1;
		

	 	Texte[nb_texte] = S;	//ajoute font etc;
	 	
		
		reference[nb]=nb_texte;
		nb_texte++;
		
		type[nb]=false;
	 	Cx[nb] = x;
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;
	 	
	 	return nb-1;
	 	
	 
	}
	  
	 
	public int getMenu(int x,int y){
	
		for(int i=nb-1;i>=0;i--){
			if(clickable[i]){
	 	 		if(x>=Cx[i] && y>=Cy[i] && x<=Cx[i]+Width[i] && y<=Cy[i]+Height[i])
	 	 			return i;
	 	 	}
	 	 }

		return -1;
	}
	public String tString(){
	
		String S=nb+"\n";
		for(int i=nb-1;i>=0;i--)
	 	 	S+=Cx[i] +"  " + Cy[i]+"  "+Width[i]+"  "+Height[i]+"\n"; 
	 	 	
	 	 return S;
	 	 	
	
	}
	
	public void change(int num,String S){
	

	 	 	if(type[num]){
	 	 	
				Toolkit tk = Toolkit.getDefaultToolkit();
				Img[nb_img] = tk.createImage(S);
				tk.prepareImage(Img[reference[num]] , -1, -1, null);
	 	 	}
			else
			    	Texte[reference[num]]=S; 
			
		
	}












}
