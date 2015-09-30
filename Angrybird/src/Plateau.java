import javax.swing.JFrame;

public class Plateau extends JFrame{
	
	private int taille ;
	private int origineX;
	private int origineY;
	int echelle;
	Bird pan = new Bird();
	public Plateau(){/*
		this.taille=taille;
		this.origineX = origineX;
		this.origineY = origineY;
		this.echelle = echelle;*/
		this.setTitle("Modelisation");
		this.setSize(800,600); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(pan);
	    this.setVisible(true);
	    go();
	}private void go() {
	    int x = pan.getPosX(), y = pan.getPosY();


	    while (true) {
	        pan.setPosX(++x);
	        pan.setPosY(--y);
	        
	      pan.repaint();

	      try {

	        Thread.sleep(5);

	      } catch (InterruptedException e) {

	        e.printStackTrace();

	      }

	    }

	  }


	  public static void main(String[] args) {
	    new Plateau();
	  }


}
