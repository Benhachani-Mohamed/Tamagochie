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
 /**
 * Graphique est une classe de gestion est d'affichage d'element graphique , telle que des image, des texte, ou des regtangle.
 * Son premier but est de decharger le programeur de la contrainte qu'est la programation graphique, afin qu'il se concentre, et recentre ,sur
 * son objectif principal. 
 * @see Tamagochie
 * 
 * @author Benhachani Mohamed
 * @version 1.0
 */
public class Graphique extends JPanel { 

        /**

         * FWidth sert a conaitre la largeur de la fenetre, il est utiliser dans la fonction clear(Graphics) 
         * @see Graphique#Graphique(int, int, int, int, int) 	
	 * @see Graphique#clear(Graphics)	
         */
	int FWidth;
	/**

         * FHeight sert a conaitre la hauteur de la fenetre, il est utiliser dans la fonction clear(Graphics). 
	 * @see Graphique#Graphique(int, int, int, int, int) 	
	 * @see Graphique#clear(Graphics)	
         */
	int FHeight;

	/**
         * Img est un tableau qui contient toute les image de l'instance de l'objet Graphique.
         * @see Graphique#Graphique(int, int, int, int, int) 	        
	 * @see Graphique#addImg(String, int, int, int, int, boolean, boolean)
	 * @see Graphique#change(int, String)
	 * @see Graphique#getMenu(int, int) 
	 * @see Graphique#paintComponent(Graphics) 
	 	 	 	 
	 	 	 	 	
         */
	private Image Img[];
	/**
         * Texte est un tableau qui contient toute les String de l'instance de l'objet Graphique.
         * @see Graphique#Graphique(int, int, int, int, int) 	
	 * @see Graphique#addTexte(String, int, int, int, int, boolean, boolean) 
	 * @see Graphique#change(int, String)
	 * @see Graphique#getMenu(int, int) 
	 * @see Graphique#paintComponent(Graphics) 
	 * @see Graphique#setColor(int, int) 	 	 	 
	 * @see Graphique#setFont(int, int) 
	 	 	 	 	 	 	 	
         */
	private String Texte[];
	/**
         * Cx est un tableau qui contient toute les String de l'instance de l'objet Graphique.
         * @see Graphique#Graphique(int, int, int, int, int) 	
	 * @see Graphique#addTexte(String, int, int, int, int, boolean, boolean) 
	 * @see Graphique#change(int, String)
	 * @see Graphique#getMenu(int, int) 
	 * @see Graphique#paintComponent(Graphics) 
	 * @see Graphique#setColor(int, int) 	 	 	 
	 * @see Graphique#setFont(int, int) 
	 	 	 	 	 	 	 	
         */
	int Cx[];
	int Cy[];
	int Width[];
	int Height[];
	boolean affiche[];
	boolean clickable[];
	
	int type[];
	int reference[];
	
	int nb;
	int nb_texte;
	int nb_img;
	int nb_rec;
	
	int max_texte;
	int max_img;
	int max_rec;
	int max_couleur;
	int max;	
	
	int nb_font;
	int nb_couleur;
	
	Font TFont[];
	Color Couleur[];

	int Id_Font[];
	int Id_Couleur[];
	
	int Id_Couleur_Rectangle[];

 	/**
         * Constructeur de Graphique. 
	 *
         * A la construction d'un objet Graphique il n'y a aucon element graphique.

         * 
         * @param width
         *            Largeur de la fenetre.
         * @param height
         *            Hauteur de la fenetre.
         * @param max_img
         *            Nombre Maximum d'image que peut gerer l'objet.
         * @param max_texte
         *            Nombre Maximum de texte que peut gerer l'objet.
          * @param max_rec
         *            Nombre Maximum de Rectangle que peut gerer l'objet.
     
         * @see Graphique#FWidth
         * @see Graphique#FHeight
         * @see Graphique#max_img
         * @see Graphique#max_texte
         * @see Graphique#max_rec
         */
	public Graphique(int width,int height, int max_img,int max_texte,int max_rec) {//metre zone puis en commun avec Texte
	
		FWidth=width;
		FHeight=height;


		
		if(!(max_img<0 || max_texte<0 || max_rec<0)){		
		
			this.max_img=max_img;
			this.max_texte=max_texte;
			this.max_rec=max_rec;
			
		}
		
		Img=new Image[this.max_img];
		Texte= new String[this.max_texte];
	
		this.max_couleur=this.max_texte+this.max_rec;
		max=this.max_img+this.max_texte+this.max_rec;
		
		Cx=new int[max];
		Cy=new int[max];
		Width=new int[max];
		Height=new int[max];
		affiche=new boolean[max];
	 	clickable=new boolean[max];
	 	
	 	type=new int[max];
	 	reference=new int[max];
	 	
	 	TFont=new Font[max_texte];
	 	Couleur=new Color[max_couleur];
	 	
	 	TFont[0]= new Font("Courier", Font.BOLD, 20);
	 	Couleur[0] = Color.black;
	 	
	 	nb_font =1;
	 	nb_couleur=1;
	 	
	 	Id_Font=new int[max_texte];
		Id_Couleur=new int[max_texte];
		Id_Couleur_Rectangle=new int[max_rec];
	}
	/**

	 *
         * Fonction qui dessine les element de l'objet

         * 
         * @param g
         *            Composant Graphics
         * @see Graphique#Img
         * @see Graphique#Texte
         * @see Graphique#addImg
         * @see Graphique#addTexte
         * @see Graphique#addRectangle
         */
	 public void paintComponent(Graphics g){
		//clear(g);
	 	 for(int i=0;i<nb;i++){
	 	 	if(affiche[i]){
		 	 	if(type[i]==0)
		 	 		 g.drawImage(Img[reference[i]], Cx[i], Cy[i],Width[i],Height[i], this);
				else{
					if(type[i]==1){
					    	g.setFont(TFont[Id_Font[reference[i]]]);
					    	g.setColor(Couleur[Id_Couleur[reference[i]]]);          
					    	g.drawString(Texte[reference[i]],Cx[i], Cy[i]); 
					}
					else{
					
						g.setColor(Couleur[Id_Couleur_Rectangle[reference[i]]]);
    						g.fillRect(Cx[i], Cy[i],Width[i],Height[i]);
					
					}
				}
			}
	 	}


		 
	}
	/**

	 *
         * Fonction qui dessine un Rectangle blanc de la taille de la fenetre

         * 
         * @param g
         *            Composant Graphics
         */
	 public void clear(Graphics g){
	 
	    	g.setColor(Color.white);
    		g.fillRect(0, 0, FWidth, FHeight);
	 }
	 /**

	 *
         * Ajoute une Image a l'objet. 

         * 
         * @param path
         *            Chemin de l'image.
         * @param x
         *            Coordonné Horizontal .
         * @param y
         *            Coordonné Vertical .
         * @param W
         *           Largeur de l'image.
         * @param H
         *           Hauteur de l'image.
     	 * @param display
         *            Etat de l'image,est égale true pour l'afficher, false sinon
         * @param click
         *           Si l'image est clickable true pour oui, false sinon
     
         * @return  Retourne -1 en cas d'erreur ou, l'identifiant du membre. 
         * @see Graphique#max_img
         * @see Graphique#Cx
         * @see Graphique#Cy
         * @see Graphique#Width
         * @see Graphique#Height
         * @see Graphique#affiche
         * @see Graphique#clickable
         */
	public int addImg(String path,int x,int y,int W,int H,boolean display,boolean click){
	
		if(nb_img>=max_img)
			return -1;
			
			 Toolkit tk = Toolkit.getDefaultToolkit();

        		Img[nb_img] = tk.createImage(path);
        		tk.prepareImage(Img[nb_img] , -1, -1, null);


	 
		reference[nb]=nb_img;
		
		nb_img++;
		
		type[nb]=0;
	 	Cx[nb] = x;
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;
	 	
		return nb-1;
	 	
	 
	}
	public int addImgStable(String path,int x,int y,int W,int H,boolean display,boolean click){
	
		if(nb_img>=max_img)
			return -1;
			


        	try {
	 		Img[nb_img] = ImageIO.read(new File(path));
	 	} catch (IOException e) {

			 e.printStackTrace();

		} 



	 
		reference[nb]=nb_img;
		
		nb_img++;
		
		type[nb]=0;
	 	Cx[nb] = x;
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;
	 	
		return nb-1;
	 	
	 
	}
	 /**

	 *
         * Ajoute un Texte a l'objet .

         * 
         * @param S
         *            Chaine de caractère a afficher.
         * @param x
         *            Coordonné Horizontal .
         * @param y
         *            Coordonné Vertical .
         * @param W
         *           Largeur de la zone de clickabilité du texte.
         * @param H
         *           Hauteur de la zone de clickabilité du texte.
     	 * @param display
         *            Etat du Texte,est égale true pour l'afficher, false sinon
         * @param click
         *           Si le Texte est clickable true pour oui, false sinon
     
         * @return  Retourne -1 en cas d'erreur, ou l'identifiant du membre. 
         * @see Graphique#max_texte
         * @see Graphique#Cx
         * @see Graphique#Cy
         * @see Graphique#Width
         * @see Graphique#Height
         * @see Graphique#affiche
         * @see Graphique#clickable
         */
	public int addTexte(String S,int x,int y,int W,int H,boolean display,boolean click){
	
		if(nb_texte>=max_texte)
			return -1;
		

	 	Texte[nb_texte] = S;	//ajoute font etc;
	 	Id_Font[nb_texte] = 0;
		Id_Couleur[nb_texte] = 0;
		
		
		reference[nb]=nb_texte;
		nb_texte++;
		
		type[nb]=1;
	 	Cx[nb] = x;
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;
	 	
	 	return nb-1;
	 	
	 
	}
	 /**

	 *
         * Ajoute un Rectangle a l'objet .

         * 
         * @param x
         *            Coordonné Horizontal .
         * @param y
         *            Coordonné Vertical .
         * @param W
         *           Largeur du Rectangle.
         * @param H
         *           Hauteur du Rectangle.
     	 * @param display
         *            Etat du Rectangle,est égale true pour l'afficher, false sinon
         * @param click
         *           Si le Rectangle  est clickable true pour oui, false sinon
     
         * @return  Retourne -1 en cas d'erreur ou l'identifiant du membre. 
         * @see Graphique#max_rec
         * @see Graphique#Cx
         * @see Graphique#Cy
         * @see Graphique#Width
         * @see Graphique#Height
         * @see Graphique#affiche
         * @see Graphique#clickable
         */
	public int addRectangle(int x,int y,int W,int H,boolean display,boolean click){
	
		if(nb_rec>=max_rec)
			return -1;
		
		Id_Couleur_Rectangle[nb_rec] = 0;
		
		reference[nb]=nb_rec;
		nb_rec++;
		
		type[nb]=2;
	 	Cx[nb] = x;
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;
	 	
	 	return nb-1;
	 	
	 
	}
	    
	  /**

	 *
         * Renvoie l'identifient du membre dans les coordonee (x,y) <b>si il est clickable</b>, plus l'identifiant et grand, 
         * plus grande est la priorite de l'élement.

         * 
         * @param x
         *            Coordonné Horizontal .
         * @param y
         *            Coordonné Vertical .
  
     
         * @return  Retourne -1 si aucun élement clickable n'a était clické, ou l'identifiant du membre clické selon l'ordre de priorite relatif a l'identifiant de l'élement. 

         * @see Graphique#Cx
         * @see Graphique#Cy
         * @see Graphique#Width
         * @see Graphique#Height

         * @see Graphique#clickable
         */
	public int getMenu(int x,int y){
	
		for(int i=nb-1;i>=0;i--){
			if(clickable[i]){
	 	 		if(x>=Cx[i] && y>=Cy[i] && x<=Cx[i]+Width[i] && y<=Cy[i]+Height[i])
	 	 			return i;
	 	 	}
	 	 }

		return -1;
	}
		  /**

	 *
         * Renvoie des information sur l'objet dans un String

        
     
         * @return  Retourne une chaine de caractere contenant le nombre d'élement leur dimension et leur coordoné . 

         * @see Graphique#Cx
         * @see Graphique#Cy
         * @see Graphique#Width
         * @see Graphique#Height

         */
	public String tString(){
	
		String S=nb+"\n";
		for(int i=nb-1;i>=0;i--)
	 	 	S+=Cx[i] +"  " + Cy[i]+"  "+Width[i]+"  "+Height[i]+"\n"; 
	 	 	
	 	 return S;
	 	 	
	
	}
	 /**

	 *
         * Change le membre avec l'identifient du membre id , par le texte S si c'est un Texte, l'Image avec le chemin S si c'est une image

         * 
         * @param id
         *            Identifient du membre.
         * @param S
         *            Texte pour un texte ou chemin de l'image.

         * @see Graphique#addImage
         * @see Graphique#addTexte

         */
	public void change(int id,String S){
	
			if(id < max){
		 	 	if(type[id]==0){
		 	 	
					Toolkit tk = Toolkit.getDefaultToolkit();
					Img[nb_img] = tk.createImage(S);
					tk.prepareImage(Img[reference[id]] , -1, -1, null);
		 	 	}
				else
					if(type[id]==1)
				    		Texte[reference[id]]=S; 
			}
		
	}

	  /**

	 *
         * Ajoute une Font, il utilise le constructeur basic de la font voir : https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html 

         * 
         * @param name
         *            Nom de la font
         * @param style
         *            Style de la font .
   	 * @param size
         *            Taille de la Font .
  
     
     
         * @return l'identifiant de la Font.

         * @see Graphique#TFont
         */
	public int addFont(String name,int style,int size){

		if(nb_font > max_texte )
			return -1;	
			
		TFont[nb_font]=new Font(name,style,size);
		nb_font++;

		return nb_font-1;

	}
  	/**

	 *
         * Ajoute une Couleur.

         * 
         * @param r
         *           Niveau de rouge (entre 0 et 255).
         * @param g
         *           Niveau de vert (entre 0 et 255).
   	 * @param b
         *           Niveau de bleu (entre 0 et 255).
  	 * @param a
         *           Niveau de transparence (entre 0 et 255).
  
     
     
         * @return l'identifiant de la Couleur.

         * @see Graphique#Couleur
         */
	public int addColor(int r,int g,int b,int a){
	
		if(nb_couleur > max_couleur )
			return -1;
			
		Couleur[nb_couleur]=new Color(r,g,b,a);
	 	nb_couleur++;
		
		return nb_couleur-1;

	}
	
	/**

	 *
         * Lie une Font avec un Texte

         * 
         * @param id
         *           Identifiant du membre de type Texte.
         * @param id_font
         *           Identifiant de la Font.
   	
     
         * @return True si la Font a était changer,false sinon.

         * @see Graphique#addFont
         * @see Graphique#TFont
         */
	public boolean setFont(int id,int id_font){
	
		if(id >= nb || id_font >= nb_font || type[id]!=1)
			return false;
	
		Id_Font[reference[id]] = id_font;

		return true;
	}
	
	/**

	 *
         * Lie un Texte ou un Rectangle avec une Couleur.

         * 
         * @param id
         *           Identifiant du membre .
         * @param id_couleur
         *           Identifiant de la couleur.
   	
     
         * @return True si la couleur de l'élement a était changer,false sinon.

         * @see Graphique#addColor
         * @see Graphique#Couleur
         */
	public boolean setColor(int id,int id_couleur){
		
	
		if(id >= nb || id_couleur >= nb_couleur || type[id]==0)
			return false;
			
		if(type[id] == 1)
			Id_Couleur[reference[id]] = id_couleur;
		else
			Id_Couleur_Rectangle[reference[id]] = id_couleur;
			
		return true;
	
	}
	

	  /**

	 *
         * Change une Font par une autre.
         * @param id_font
         *  	     Identifiant de la Font a changer.
         * 
         * @param name
         *            Nom de la font
         * @param style
         *            Style de la font .
   	 * @param size
         *            Taille de la Font .
  
     
     
         * @return True si la Font a était remplacé,false sinon.

         * @see Graphique#TFont
         * @see Graphique#addFont
         */
	public boolean changeFont(int id_font,String name,int style,int size){
	
		if( id_font >= nb_font )
			return false;
	
		TFont[id_font]=new Font(name,style,size);

		return true;
	}
		/**

	 *
         * Change une Couleur par une autre.
         * @param id_couleur
         *  	     Identifiant de la couleur a changer		
         * @param r
         *           Niveau de rouge (entre 0 et 255).
         * @param g
         *           Niveau de vert (entre 0 et 255).
   	 * @param b
         *           Niveau de bleu (entre 0 et 255).
  	 * @param a
         *           Niveau de transparence (entre 0 et 255).
  
     
     
         * @return True si la couleur a était remplacé,false sinon.

         * @see Graphique#Couleur
         */
	public boolean changeColor(int id_couleur,int r,int g,int b,int a){
	
	
		if(id_couleur >= nb_couleur )
			return false;
	
		Couleur[id_couleur]=new Color(r,g,b,a);
		return true;
	
	}
	
	

}
