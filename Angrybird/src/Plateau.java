
import java.awt.Color;


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

	    int x=1;
	    while(x==1){

	    go();
	    
	    }
	}
	
	private void go() {
	
		pan.setPosY(550);
		pan.setPosX(-50);
		
	    int x = pan.getPosX(), y = pan.getPosY();
	    int t =-30;
	    

	    //condition d'arrêt à revoir
	    
	    do{	    	
	    	t++;
	    	
	        pan.setPosY((int) (2 * Math.pow(t,2) + 6*t + 5));
	        pan.setPosX(pan.getPosX() + 35);
	        
	        y = (int) (2 * Math.pow(t, 2) + 6*t + 5);	        
	    	x = x + 35;

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

	  }

	  public static void main(String[] args) {
	    new Plateau();
	  }
	  
	  
	  public void initObstacles(){
		  
		  Obstacle cible = new Obstacle(600,400, Color.GREEN, true);
		  Obstacle cible2 = new Obstacle(500,250, Color.green, true);
			
		  Bird.obstacles.add(cible);
		  Bird.obstacles.add(cible2);
	  }


}
