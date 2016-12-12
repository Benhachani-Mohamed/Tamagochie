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
 * Graphique est une classe de gestion est d'affichage d'élément graphique , telle que des image, des texte, ou des rectangle.
 * Son premier but est de décharger le programmeur de la contrainte qu'est la programmation graphique, afin qu'il se concentre, et recentre ,sur
 * son objectif principal. 
 * @see Tamagochie
 * 
 * @author Benhachani Mohamed
 * @version 1.0
 */
public class Graphique extends JPanel { 

        /**

         * FWidth sert a connaître la largeur de la fenêtre, il est utiliser dans la fonction clear(Graphics) 
         * @see Graphique#Graphique(int, int, int, int, int) 	
	 * @see Graphique#clear(Graphics)	
         */
	private int FWidth;
	/**

         * FHeight sert a connaître la hauteur de la fenêtre, il est utiliser dans la fonction clear(Graphics). 
	 * @see Graphique#Graphique(int, int, int, int, int) 	
	 * @see Graphique#clear(Graphics)	
         */
	private int FHeight;

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
	private int Cx[];
	private int Cy[];
	private int Width[];
	private int Height[];
	private boolean affiche[];
	private boolean clickable[];
	
	private int type[];
	private int reference[];
	
	private int nb;
	private int nb_texte;
	private int nb_img;
	private int nb_rec;
	
	private int max_texte;
	private int max_img;
	private int max_rec;
	private int max_couleur;
	private int max;	
	
	private int nb_font;
	private int nb_couleur;
	
	private Font TFont[];
	private Color Couleur[];

	private int Id_Font[];
	private int Id_Couleur[];
	
	private int Id_Couleur_Rectangle[];

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
         *            Nombre Maximum d'image que peut gérer l'objet.
         * @param max_texte
         *            Nombre Maximum de texte que peut gérer l'objet.
          * @param max_rec
         *            Nombre Maximum de Rectangle que peut gérer l'objet.
     
         * @see Graphique#FWidth
         * @see Graphique#FHeight
         * @see Graphique#max_img
         * @see Graphique#max_texte
         * @see Graphique#max_rec
         */
	public Graphique(int width,int height, int max_img,int max_texte,int max_rec) {
	
		FWidth=width;			//je met taille supposer de l'écrans
		FHeight=height;


		
		if(!(max_img<0 || max_texte<0 || max_rec<0)){	//Si aucun max n'est négatif	
		
			this.max_img=max_img;			//alors je les met max de la classe égale 
			this.max_texte=max_texte;		//au max mis par l'utilisateur
			this.max_rec=max_rec;
			
		}
		
		Img=new Image[this.max_img];			//je crée le tableau d'Image
		Texte= new String[this.max_texte];		// Je crée un tableau de Texte
	
		this.max_couleur=this.max_texte+this.max_rec;	//je met max_couleur égale a la somme des texte est rectangle
		max=this.max_img+this.max_texte+this.max_rec;
		
		Cx=new int[max];				//Je crée un tableau entier pour stocker la position horizontal
		Cy=new int[max];				//Je crée un tableau entier pour stocker la position vertical
		Width=new int[max];				//Je crée un tableau entier pour stocker la largeur
		Height=new int[max];				//Je crée un tableau entier pour stocker la hauteur
		affiche=new boolean[max];			//Je crée un tableau boolean pour stocker le mode d'affichage
	 	clickable=new boolean[max];			//Je crée un tableau boolean pour stocker le mode de clickabilité	
	 	
	 	type=new int[max];				//Je cree un tableau entier pour stocker le type de l'element
	 	reference=new int[max];				//Je cree un tableau entier pour stocker la refernece de l'element
	 	
	 	if(max_texte>0){				//Si il y'a de quoi cree un Tableau de Font
	 		 	
		 	TFont=new Font[max_texte];			//Je crée un tableau Font pour stocker les Font
		 	TFont[0]= new Font("Courier", Font.BOLD, 20);	//Je crée un premier Font par default
		 	nb_font =1;					//J'implémente pour dire qu'il ya une Font
	 	}
	 							
	 	if(max_couleur>0){				//Si il y'a de quoi crée un Tableau de couleur
	 							
	 		Couleur=new Color[max_couleur];			//Je crée un tableau Couleur pour stocker les Couleur
		 	Couleur[0] = Color.black;			//Je crée un premier Couleur par default
		 	nb_couleur=1;					//J'implémente pour dire qu'il ya une Couleur
	 	}	
	 	
	 	Id_Font=new int[max_texte];			//Je crée un tableau pour avoir l'id de la font de chaque texte
		Id_Couleur=new int[max_texte];			//Je crée un tableau pour avoir l'id de la couleur de chaque texte
		Id_Couleur_Rectangle=new int[max_rec];		//Je crée un tableau pour avoir l'id de la couleur de chaque rectangle
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

	 	 for(int i=0;i<nb;i++){		//Pour chaque élément Graphique ( image , texte, rectangle) je parcoure
	 	 	if(affiche[i]){			//Si il faut l"afficher
		 	 	if(type[i]==0)		//Si c'est une image je la dessine
		 	 		 g.drawImage(Img[reference[i]], Cx[i], Cy[i],Width[i],Height[i], this);
				else{		//Sinon  
					if(type[i]==1){//si c'est un Texte je le dessine avec sa font et sa couleur
					    	g.setFont(TFont[Id_Font[reference[i]]]);
					    	g.setColor(Couleur[Id_Couleur[reference[i]]]);          
					    	g.drawString(Texte[reference[i]],Cx[i], Cy[i]); 
					}
					else{//si c'est un Rectangle je le dessine avec sa couleur
					
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
	 
	    	g.setColor(Color.white);		//met la couleur Blanche
    		g.fillRect(0, 0, FWidth, FHeight);	//le dessine
    				
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
	
		if(nb_img>=max_img)		//Si le nombre d'image max est dépasse je retourne -1
			return -1;
		
		//Sinon je charge l'image	
		Toolkit tk = Toolkit.getDefaultToolkit();
		Img[nb_img] = tk.createImage(path);
		tk.prepareImage(Img[nb_img] , -1, -1, null);


	 	//Je met sa référence dans le tableau
		reference[nb]=nb_img;
		
		nb_img++;//J'incrémente nb_img 
		
		type[nb]=0;	//je met comme type 0 car c'est une image
	 	Cx[nb] = x;	//j'implémente les variable avec ce que l'utilisateur a inscrit
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;	//J'incrémente nb pour dire qu'il ya une image en plus
	 	
		return nb-1;//je return l'identifiant de l'element
	 	
	 
	}
	 /**

	 *
         * Ajoute une Image a l'objet.<b style='color:red'> Cette fonction n'anime pas les Gif</b>

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
	public int addImgStable(String path,int x,int y,int W,int H,boolean display,boolean click){
	
		if(nb_img>=max_img)	//Si le nombre d'image max est depassé je retourne -1
			return -1;
			

		//Sinon je charge l'image	
        	try {
	 		Img[nb_img] = ImageIO.read(new File(path));
	 	} catch (IOException e) {

			 e.printStackTrace();

		} 

		reference[nb]=nb_img;//je met la refenrce de l'image
		
		nb_img++;	//j'incrémente  le nombre d'image
		
		type[nb]=0;		//je met type a 0 pour dire que c'est une image
	 	Cx[nb] = x;		//j'implémente les variable avec ce que l'utilisateur a inscrit	
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;			//j'incrémente le nombre d'element graphique
	 	
		return nb-1;		//je retourne l'identifiant de l'element
	 	
	 
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
	
		if(nb_texte>=max_texte)	//Si le tableau de Texte est remplis alors je renvoie -1
			return -1;
		
		//Sinon
	 	Texte[nb_texte] = S;		//je met le Texte
	 	Id_Font[nb_texte] = 0;		//j'indique la font par default
		Id_Couleur[nb_texte] = 0;	//j'indique la couleur par default
		
		
		reference[nb]=nb_texte;		//je me la référence de l'element
		nb_texte++;			//j'incrémente le nombre de Texte
		
		type[nb]=1;			//Je met comme type 1 car c'est texte
	 	Cx[nb] = x;		//j'implémente les variable avec ce que l'utilisateur a inscrit	
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;			//j'incrémente le nombre d'element graphique
	 	
		return nb-1;		//je retourne l'identifiant de l'element	 
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
	
		if(nb_rec>=max_rec)	//Si le tableau de rectangle remplis
			return -1;
		
		Id_Couleur_Rectangle[nb_rec] = 0; //je met la couleur pas default
		
		reference[nb]=nb_rec;		//je met la refenrence de l'objet graphique
		nb_rec++;
		
		type[nb]=2;		//Je met 2 car c'est Rectangle
		Cx[nb] = x;		//j'implémente les variable avec ce que l'utilisateur a inscrit	
	 	Cy[nb] = y;
	 	Width[nb] = W;
	 	Height[nb] = H;
	 	affiche[nb]=display;
	 	clickable[nb]=click;
	 	
	 	nb++;			//j'incrémente le nombre d'element graphique
	 	
		return nb-1;		//je retourne l'identifiant de l'element
 
	}
	    
	  /**

	 *
         * Renvoie l'identifient du membre dans les coordonne (x,y) <b>si il est clickable</b>, plus l'identifiant et grand, 
         * plus grande est la priorité de l'élément.

         * 
         * @param x
         *            Coordonné Horizontal .
         * @param y
         *            Coordonné Vertical .
  
     
         * @return  Retourne -1 si aucun élément clickable n'a était clické, ou l'identifiant du membre clické selon l'ordre de priorité relatif a l'identifiant de l'élément. 

         * @see Graphique#Cx
         * @see Graphique#Cy
         * @see Graphique#Width
         * @see Graphique#Height

         * @see Graphique#clickable
         */
	public int getMenu(int x,int y){
	
		for(int i=nb-1;i>=0;i--){//Pacrour les element graphique
			if(clickable[i]){//Si il est clickable il vérifie leur position 
						//Il vérifie si la position est celle de l'element
	 	 		if(x>=Cx[i] && y>=Cy[i] && x<=Cx[i]+Width[i] && y<=Cy[i]+Height[i])
	 	 			return i;//Si oui il retourne son identifiant
	 	 	}
	 	 }

		return -1;//si aucun élément clickable n'a cette position je retourne -1
	}
		  /**

	 *
         * Renvoie des information sur l'objet dans un String

        
     
         * @return  Retourne une chaine de caractère contenant le nombre d'élément leur dimension et leur coordonné . 

         * @see Graphique#Cx
         * @see Graphique#Cy
         * @see Graphique#Width
         * @see Graphique#Height

         */
	public String tString(){
	
		String S=nb+"\n";
		for(int i=nb-1;i>=0;i--)//Je parcours est je concatène
	 	 	S+=Cx[i] +"  " + Cy[i]+"  "+Width[i]+"  "+Height[i]+"\n"; 
	 	 	
	 	 return S;//retourne la chaîne de caractère
	 	 	
	
	}
	 /**

	 *
         * Change le membre avec l'identifient du membre id , par le texte S si c'est un Texte, l'Image avec le chemin S si c'est une image

         * 
         * @param id
         *            Identifient du membre.
         * @param S
         *            Texte pour un texte ou chemin de l'image.

         * @see Graphique#addImg
         * @see Graphique#addTexte

         */
	public void change(int id,String S){
	
			if(id < nb){//Si l'identifiant correspond a un element
		 	 	if(type[id]==0){//Si c'est une image alors
		 	 				//je change l'image
					Toolkit tk = Toolkit.getDefaultToolkit();
					Img[nb_img] = tk.createImage(S);
					tk.prepareImage(Img[reference[id]] , -1, -1, null);
		 	 	}
				else	//Sinon
					if(type[id]==1)//Si c'est un Texte je change le Texte
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

		if(nb_font >= max_texte )	//Si y'a déjà le nombre max d'image
			return -1;		//je renvoie -1
			
		TFont[nb_font]=new Font(name,style,size);//Si je crée une font avec les parmetre 
		nb_font++;		//j'incrément le nombre de font

		return nb_font-1;		//je retourne l'identifiant de la font

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
	
		if(nb_couleur >= max_couleur )	//je regarde si il y'a la place pour une nouvelle couleur
			return -1;		//si y'a pas je retourne -1
						//Sinon
		Couleur[nb_couleur]=new Color(r,g,b,a);//je met la nouvelle couleur
	 	nb_couleur++;			//j'incrément le nombre d'image
		
		return nb_couleur-1;		//je retourne l'identifiant de la couleur

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
	
		if(id >= nb || id_font >= nb_font || type[id]!=1)//Si l'id de la font ou l'id de l'element ne corresponde a aucune font
			return false;			//ou si ce n'est pas  Texte alors je retourne false
	
		Id_Font[reference[id]] = id_font; //Sinon je id de la font pour le texte et

		return true;			//je retourne true
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
		
	
		if(id >= nb || id_couleur >= nb_couleur || type[id]==0)//Si l'id ou la couleur n'existe pas je retourne false
			return false;					//si c'est une image je return false
			
		if(type[id] == 1)				//Si c'est un Texte ou un Rectangle je change la couleur
			Id_Couleur[reference[id]] = id_couleur;
		else
			Id_Couleur_Rectangle[reference[id]] = id_couleur;
			
		return true;					//je return true
	
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
	
		if( id_font >= nb_font )		//Si l'id de la font n'existe pas je return false
			return false;
	
		TFont[id_font]=new Font(name,style,size);//Sinon je met la nouvelle font		

		return true;					//et je return true
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
	
	
		if(id_couleur >= nb_couleur )	//Si la couleur n'existe pas je retourne false
			return false;
	
		Couleur[id_couleur]=new Color(r,g,b,a);//Sinon je change la couleur 
		return true;				//et je retourne true
	
	}
	/**

	 *
         * Met la position horizonal X, a l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
         * @param X
         *           Coordonnée horizontal a mettre
        
     
     
         * @return True si la Position a était remplacé,false sinon.


         */
	public boolean setPositionX(int id,int X){
	
		if( id < nb ){		//Si l'id existe je met la nouvelle position et je retourne true
			Cx[id]=X;
			return true;
		}
		return false;		//Sinon je retourn false
	
	}
	/**

	 *
         * Met la position vertical Y, a l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
         * @param Y
         *           Coordonnée vertical a mettre
        
     
     
         * @return True si la Position a était remplacé,false sinon.


         */
	public boolean setPositionY(int id,int Y){
	
		if( id < nb ){		//Si l'id existe je met la nouvelle position et je retourne true
			Cy[id]=Y;
			return true;
		}
		return false;		//Sinon je retourne false
	
	}
	/**

	 *
         * Met la largeur W, a l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
         * @param W
         *           Largeur a mettre a l'élément
        
     
     
         * @return True si sa dimension a était mise,false sinon.


         */
	public boolean setWidth(int id,int W){
	
		if( id < nb ){		//Si l'id existe je met la nouvelle largeur et je retourne true
			Width[id]=W;
			return true;
		}
		return false;		//Sinon je retourne false
	
	}
	/**

	 *
         * Met la hauteur H , a l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
         * @param H
         *           Hauteur a mettre a l'élément
        
     
     
         * @return True si sa dimension a était mise,false sinon.


         */
	public boolean setHeight(int id,int H){
	
		if( id < nb ){		//Si l'id existe je met la nouvelle hauteur et je retourne true
			Height[id]=H;
			return true;
		}
		return false;		//Sinon je retourne false
	
	}
	/**
	 *
         * Change le mode d'affichage de l'element possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
         * @param A
         *           Mode d'affichage de l'element a mettre, true pour afficher false sinon.
        
     
     
         * @return True si le mode a était remplacé,false sinon.

         * @see Graphique#paintComponent
         */
	public boolean setAffiche(int id,boolean A){
	
		if( id < nb ){		//Si l'id existe je met la nouveau mode d'affichage et je retourne true
			affiche[id]=A;
			return true;
		}
		return false;		//Sinon je retourne false
	
	}
	/**
	 *
         * Change le mode de clickabilité de l'element possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
         * @param C
         *           Mode de clickabilité de l'element mettre true pour retourner l'identifiant de l'element clické, false sinon.
        
     
     
         * @return True si le mode a était remplacé,false sinon.

         * @see Graphique#getMenu
         */
	public boolean setClickable(int id,boolean C){
	
		if( id < nb ){		//Si l'id existe je met la nouveau mode e clickabilité et je retourne true
			clickable[id]=C;
			return true;
		}
		return false;		//Sinon je retourne false
	
	}
	
	/**

	 *
         * Renvoie position horizontal de l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
        
         * @return  La Position horizontal ou -1.


         */
	public int getPositionX(int id){
	
		if( id < nb ){		//Si l'id existe je renvoie la position horizontal 
			return Cx[id];
		}
		return -1;		//Sinon je retourne -1
			
	}
	/**

	 *
         * Renvoie position vertical de l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
        
         * @return  La Position vertical ou -1.


         */
	public int getPositionY(int id){
	
		if( id < nb ){		//Si l'id existe je renvoie la position vertical 
			return Cy[id];
		}
		return -1;		//Sinon je retourne -1
	
	}
	/**

	 *
         * Renvoie la largeur de l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
        
     
     
         * @return La largeur de l'élément ou -1.


         */
	public int getWidth(int id){
	
		if( id < nb ){		//Si l'id existe je renvoie la largeur 
			return Width[id];
		}
		return -1;		//Sinon je retourne -1
	
	}
	/**

	 *
         * Renvoie la hauteur de l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
        
     
     
         * @return La hauteur de l'élément ou -1.


         */
	public int getHeight(int id){
	
		if( id < nb ){		//Si l'id existe je renvoie la hauteur 
			return Height[id];
		}
		return -1;		//Sinon je retourne -1
	
	}
	/**

	 *
         * Renvoie le mode de l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
        
     
     
         * @return 1 si l'élément s'affiche,0 si il ne s'affiche pas , -1 en cas d'erreur


         */
	public int getAffiche(int id){
	
		if( id < nb ){		//Si l'id existe je renvoie 1 s'il s'affiche 0 sinon
			return affiche[id]?1:0;
		}
		return -1;		//et -1 si l'id n'existe pas
	
	}
	/**

	 *
         * Renvoie le mode de l'élément possédant l'identifiant id
         * @param id
         *  	     Identifiant de l'élément		
        
     
     
         * @return 1 si l'élément est clickable ,0 si il ne l'est pas , -1 en cas d'erreur.


         */
	public int getClickable(int id){
	
		if( id < nb ){		//Si l'id existe je renvoie 1 s'il s'affiche 0 sinon
			return clickable[id]?1:0;
		}
		return -1;		//et -1 si l'id n'existe pas
	
	}
	

}
