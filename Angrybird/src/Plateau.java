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
	    while(pan.isCible1() || pan.isCible2() || pan.isCible3()){
	    go();
	    }
	}
	
	private void go() {
	
		pan.setPosY(550);
		pan.setPosX(-50);
		
	    int x = pan.getPosX(), y = pan.getPosY();

	    int t =-30;
	    
	    int a = (r.nextInt(13))+1;  
	    int b = r.nextInt(13);
	    int c = r.nextInt(13);
	    
	    
	    //condition d'arr�t � revoir
	    while (x < 1990) {
	    	t++;
	        //y = (int) (2 * Math.pow(t, 2) + 6* t +5);
	    	// y = (int) (a* Math.pow(t, 3) + b*t +c);
	    	//y = (int) (0.5*a* Math.pow(t, 3) + b* Math.pow(t, 2) +c*t);
	    	//y= (int) ((a* Math.pow(t, 2)*b*Math.sin(t*Math.PI)/(3-Math.exp(t))));
	    	//y= (int) (a*20*Math.cos(t)+500);
	    	//y = (int) ((500*Math.cos(8*t))*(Math.cos(t))+800);    //rosace
	    	y = (int) ((3*Math.pow(t, 2))-(2*Math.pow(t, 3))+800); //bézier
	    	x = (int) ((-3*Math.pow(t, 2))+(3*t)+500);             //bézier 
	    	//x= x+35;
	    	//x=(int) ((500*Math.cos(8*t))*(Math.sin(t))+500);     //rosace
	    	//x= (int) (b*80*Math.sin(t)+500);
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
