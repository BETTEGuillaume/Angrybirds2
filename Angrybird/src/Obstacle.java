import java.awt.Color;

/**
 * La classe Obstacle repr�sente tous les objets "obstacle" utilis�s dans le projet.
 * @author R�my
 *
 */

public class Obstacle {
	
	/**
	 * Constructeur Obstacle(int,int)
	 * La couleur de l'obstacle est initialis�e � NOIR, et celui-ci est activ� par d�faut.
	 * 
	 * @param x Coordonn�e en x de l'obstacle
	 * @param y Coordonn�e en y de l'obstacle
	 */
	public Obstacle(int x, int y){
		this.x=x;
		this.y=y;
		this.c = Color.BLACK;
		this.actif = true;
	}

	/**
	 * Constructeur Obstacle(int,int,Color,boolean)
	 * 
	 * @param x Coordonn�e en x de l'obstacle
	 * @param y Coordonn�e en y de l'obstacle
	 * @param c Couleur de l'obstacle
	 * @param b Activation de l'obstacle
	 */
	public Obstacle(int x, int y, Color c, boolean b){
		this.x=x;
		this.y=y;
		this.c=c;
		actif=b;
	}
		
	private int x;
	private int y;
	private Color c;
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

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "Obstacle [x=" + x + ", y=" + y + ", c=" + c + ", actif="
				+ actif + "]";
	}
		
}
