import java.util.Random;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Plateau extends JFrame{
	
	private int echelle;

	Bird pan = new Bird(echelle);
	Random r = new Random();
	
	//constructeur
	public Plateau(){
		this.echelle = Constantes.echelle;
		this.setTitle(Constantes.titre);
		this.setSize(Constantes.largeur_ecran, Constantes.hauteur_ecran);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(pan);
	    this.setVisible(true);
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
	    
	    int a = (r.nextInt(10))+1;  
	    int b = r.nextInt(10);
	    int c = r.nextInt(10);
	    
	    
	    //condition d'arr�t � revoir
	    while (x < 1990) {
	    	t++;
	        //y = (int) (2 * Math.pow(t, 2) + 6* t +5);
	    	y = (int) (a* Math.pow(t, 2) + b* t +c);
	    	x= x+35;
	        pan.setPosX(x++/echelle);
	        System.out.println(x+"  "+y);
	        pan.setPosY(y/echelle);
	        
	      pan.repaint();

	      try {

	        Thread.sleep(50);

	      } catch (InterruptedException e) {

	        e.printStackTrace();

	      }

	    }

	  }


	  public static void main(String[] args) {
	    new Plateau();
	  }


}
