
/**
 * La classe Obstacle repr�sente tous les objets "obstacle" utilis�s dans le projet.
 * @author R�my
 *
 */

public class Obstacle {
	
	/**
	 * Constructeur Obstacle(int,int)
	 * L'obstacle est activ� par d�faut, et sa couleur se trouve dans la classe Constantes.
	 * 
	 * @param x Coordonn�e en x de l'obstacle
	 * @param y Coordonn�e en y de l'obstacle
	 */
	public Obstacle(int x, int y){
		this.x=x;
		this.y=y;
		this.actif = true;
	}

	/**
	 * Constructeur Obstacle(int,int,boolean)
	 * 
	 * @param x Coordonn�e en x de l'obstacle
	 * @param y Coordonn�e en y de l'obstacle
	 * @param b Activation de l'obstacle
	 */
	public Obstacle(int x, int y, boolean b){
		this.x=x;
		this.y=y;
		actif=b;
	}
		
	private int x;
	private int y;
	private boolean actif;
	
	//Getters et setters
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "Obstacle [x=" + x + ", y=" + y + ", actif=" + actif + "]";
	}
}
