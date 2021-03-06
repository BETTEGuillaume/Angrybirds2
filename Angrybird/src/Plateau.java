import java.util.Random;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Plateau extends JFrame{
	
	private int echelle;

	Bird pan = new Bird(echelle);
	
	//constructeur
	public Plateau(){
		this.echelle = Constantes.echelle;
		this.setTitle(Constantes.titre);
		this.setSize(Constantes.largeur_ecran, Constantes.hauteur_ecran);
	    initObstacles();

	    this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(pan);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    
	    //tant qu'il reste des obstacles encore actifs
	    while(ilResteDesObstacles()){
	    	go();
	    }
	}

	private void go() {
		
		//position de d�part de l'oiseau
		pan.setPosY(Constantes.origineY);
		pan.setPosX(Constantes.origineX);
		
	    int x = pan.getPosX(), y = pan.getPosY();
	    //t valeur 0 qui permet de partir du point 0
	    int t =0;
	    
	    Random r = new Random();
	    int a = (r.nextInt(5)+1);  
	    int b = r.nextInt(5);
	    int c = r.nextInt(5);
	    int d = r.nextInt(20)+30;
	    //ajout de la variable G qui permet la courbe 
	    //(je ne sais pas trop a quoi elle sert mais grace a �a on part toujours du m�me point
	    int g=-40;
	    do{	    
	    	t++;
	    	g++;
	        //y = (int) (a * Math.pow(t, 2) + b* t +c+1);	    
	    	
	    	//test R�my
	    	// y = (int) (a * Math.pow(t, 2) + (a-b+c)*t);	   
	    	//test Omar ax�+bx+c
	    	
	    	
	    	y = ((int) (a * Math.pow(g, 2) - b*t - c));	  
	    	System.out.println(y);
	    	x+=d;
	    	
	    	//y = (int) (a* Math.pow(t, 3) + b*t +c);
	    	//y = (int) (0.5*a* Math.pow(t, 3) + b* Math.pow(t, 2) +c*t);
	    	//y= (int) ((a* Math.pow(t, 2)*b*Math.sin(t*Math.PI)/(3-Math.exp(t))));
	    	//y= (int) (a*20*Math.cos(t)+500);
	    	//y = (int) ((500*Math.cos(8*t))*(Math.cos(t))+800);    //rosace
	    	//y = (int) ((3*Math.pow(t, 2))-(2*Math.pow(t, 3))+800); //bézier
	    	//x = (int) ((-3*Math.pow(t, 2))+(3*t)+500);             //bézier 
	    	//x= x+35;
	    	//x=(int) ((500*Math.cos(8*t))*(Math.sin(t))+500);     //rosace
	    	//x= (int) (b*80*Math.sin(t)+500);

	        pan.setPosX(x++/echelle);
	        pan.setPosY(y/echelle);
	        //System.out.println(pan.getPosX() +" "+pan.getPosY());
	        
	      pan.repaint();

	      try {
	    	  Thread.sleep(1000);
	      } catch (InterruptedException e) {
	    	  e.printStackTrace();
	      }

	    }while((pan.getPosX()<Constantes.largeur_ecran) && (pan.getPosY()<Constantes.hauteur_ecran - 2*Constantes.taille_oiseau));
	    
	    //r�initialisation de la trajectoire
	    if(!Constantes.traces_trajectoire)
	    	pan.getPassage().clear();

	  }

	
	  public static void main(String[] args) {
	    new Plateau();
	  }
	  
	  /**
	   * Cette fonction parcourt la liste des obstacles pour d�terminer si il en reste 
	   * au moins un d'actif.
	   * @return Si plus aucun obstacle n'est actif, retourne faux ; sinon, vrai.
	   */
	  public boolean ilResteDesObstacles(){
		  for(Obstacle o : pan.getObstacles()){
			  if(o.isActif())
				  return true;
		  }
		  return false;
	  }
	  
	  /**
	   * Cette fonction initialise les obstacles et les range dans la liste d'obstacles,
	   * utilis�e dans le d�roulement du programme.
	   */
	  public void initObstacles(){
		  
		  
		  Obstacle cible = new Obstacle(740,68);
		  Obstacle cible2 = new Obstacle(670,168);
		  Obstacle cible3 = new Obstacle(720,268);
		  Obstacle cible4 = new Obstacle(690,368);
		  Obstacle cible5 = new Obstacle(700,468);
		  
		  ObstacleMouvant ciblem1 = new ObstacleMouvant(900,20);
		  ciblem1.setLimites_x(new int[]{900,900});
		  ciblem1.setLimites_y(new int[]{20,468});		  
		  
		  ObstacleMouvant ciblem2 = new ObstacleMouvant(200,468);
		  ciblem2.setLimites_x(new int[]{200,500});  
		  ciblem2.setLimites_y(new int[]{468,468});

		  
		  pan.getObstacles().add(cible);
		  pan.getObstacles().add(cible2);
		  pan.getObstacles().add(cible3);
		  pan.getObstacles().add(cible4);
		  pan.getObstacles().add(cible5);
		  
	  }


}
