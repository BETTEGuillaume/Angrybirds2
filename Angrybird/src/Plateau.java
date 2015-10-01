import javax.swing.JFrame;

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
	    go();
	}
	
	private void go() {
	    int x = pan.getPosX(), y = pan.getPosY();

	    int t =-30;
	    
	    //condition d'arrêt à revoir
	    while (x<2250) {
	    	t++;
	        y = (int) (2 * Math.pow(t, 2) + 6* t +5);
	    	x= x+40;
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
