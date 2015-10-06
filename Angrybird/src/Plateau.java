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
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(pan);
	    this.setVisible(true);
	    
	    initObstacles();
	    
	    
	    //tant qu'il reste des obstacles encore actifs
	    while(ilResteDesObstacles()){
	    	go();
	    }
	}
	
	/**
	 * La fonction go() est la boucle principale du programme, dans laquelle se font
	 * les incrémentations de x et y, le calcul des points de la trajectoire, et
	 * l'appel de la fonction 'repaint' de l'oiseau.
	 */
	private void go() {
	
		//position de départ de l'oiseau
		
		pan.setPosY(550);
		pan.setPosX(-50);
		
	    int x = pan.getPosX(), y = pan.getPosY();
	    int t =-30;
	    
	    Random r = new Random();
	    int a = (r.nextInt(6)+1);  
	    int b = r.nextInt(6);
	    int c = r.nextInt(6);
	    
	    do{	    
	    	t++;

	        y = (int) (a * Math.pow(t, 2) + b* t +c+1);	        
	        //y = (int) (a * Math.pow(t, 2) + (a-b+c)* t +5); //test Rémy	        
	    	//y = (int) (a* Math.pow(t, 3) + b*t +c);
	    	//y = (int) (0.5*a* Math.pow(t, 3) + b* Math.pow(t, 2) +c*t);
	    	//y= (int) ((a* Math.pow(t, 2)*b*Math.sin(t*Math.PI)/(3-Math.exp(t))));
	    	//y= (int) (a*20*Math.cos(t)+500);
	    	//y = (int) ((500*Math.cos(8*t))*(Math.cos(t))+800);    //rosace
	    	//y = (int) ((3*Math.pow(t, 2))-(2*Math.pow(t, 3))+800); //bÃ©zier
	    	//x = (int) ((-3*Math.pow(t, 2))+(3*t)+500);             //bÃ©zier 
	    	x= x+35;
	    	//x=(int) ((500*Math.cos(8*t))*(Math.sin(t))+500);     //rosace
	    	//x= (int) (b*80*Math.sin(t)+500);

	        pan.setPosX(x++/echelle);
	        pan.setPosY(y/echelle);
	        System.out.println(pan.getPosX() +" "+pan.getPosY());
	        
	      pan.repaint();

	      try {
	    	  Thread.sleep(40);
	      } catch (InterruptedException e) {
	    	  e.printStackTrace();
	      }

	    }while((pan.getPosX()<Constantes.largeur_ecran) && (pan.getPosY()<Constantes.hauteur_ecran - 80));
	    
	    pan.getPassage().clear();

	  }

	
	  public static void main(String[] args) {
	    new Plateau();
	  }
	  
	  
	  /**
	   * Cette fonction parcourt la liste des obstacles pour déterminer si il en reste 
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
	   * utilisée dans le déroulement du programme.
	   */
	  public void initObstacles(){
		  
		  Obstacle cible = new Obstacle(600,400);
		  Obstacle cible2 = new Obstacle(500,250);
		  Obstacle cible3 = new Obstacle(800,400);
		  Obstacle cible4 = new Obstacle(700,100);

		  pan.getObstacles().add(cible);
		  pan.getObstacles().add(cible2);
		  pan.getObstacles().add(cible3);
		  pan.getObstacles().add(cible4);
	  }


}
