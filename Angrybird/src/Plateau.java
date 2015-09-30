import javax.swing.JFrame;

public class Plateau extends JFrame{
	
	private int taille ;
	private int origineX;
	private int origineY;
	int echelle;

	Bird pan = new Bird(echelle);
	public Plateau(){
		this.echelle = 3;
		this.setTitle("Modelisation");
		this.setSize(800,600); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(pan);
	    this.setVisible(true);
	    go();
	}private void go() {
	    int x = pan.getPosX(), y = pan.getPosY();

	    int t =-30;
	    while (true) {
	    	t++;
	        y = (int) (2 * Math.pow(t, 2) + 6* t +5);
	    	x= x+40;
	        pan.setPosX(x++/echelle);
	        System.out.println(x+"  "+y);
	        pan.setPosY(y/echelle);
	        
	      pan.repaint();

	      try {

	        Thread.sleep(100);

	      } catch (InterruptedException e) {

	        e.printStackTrace();

	      }

	    }

	  }


	  public static void main(String[] args) {
	    new Plateau();
	  }


}
