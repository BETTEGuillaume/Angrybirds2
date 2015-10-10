
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class Bird extends JPanel {

	private Image bird;
	private Image background;
	private Image slingshot;
	private Image obstacle;
	
	private int echelle;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private int z;
    private int w;
    /*private int a = Plateau.getA();
    private int b = Plateau.getB();
    private int c = Plateau.getC();*/

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	// constructeur
	public Bird(int echelle) {
		this.echelle = echelle;
		// initialisation des images
		initimg();
	}

	private int posX = -50;
	private int posY = 550;
	private Map<Integer, Integer> passage = new HashMap<>();


	public void paintComponent(Graphics g) {

		if(Constantes.graphique){
			
			//dessin du background

			passage.put(posX, posY);
			g.drawImage(background, 0, 0, Constantes.largeur_ecran, Constantes.hauteur_ecran, null);


			// dessin de la trajectoire en pointill�s

			g.setColor(Color.gray);
			for (int i : passage.keySet())
				g.fillOval(i + Constantes.taille_oiseau/2, passage.get(i) + Constantes.taille_oiseau/2, 3, 3);


			// dessin de l'oiseau

			g.drawImage(bird, posX, posY, Constantes.taille_oiseau, Constantes.taille_oiseau,null);


			//dessin des obstacles et d�tection des collisions

			g.setColor(Constantes.couleur_obstacle);
			for(Obstacle e : obstacles){
				if(e.isActif()){
					if(e instanceof ObstacleMouvant){
						((ObstacleMouvant) e).moveY();
						((ObstacleMouvant) e).moveX();
						}
					g.drawImage(obstacle, e.getX(), e.getY(), Constantes.taille_obstacle, Constantes.taille_obstacle, null);
				}else{
					g.drawRect(e.getX(), e.getY(), Constantes.taille_obstacle, Constantes.taille_obstacle);
				}
				if(posX > e.getX() - Constantes.taille_obstacle && posX < e.getX() + Constantes.taille_obstacle &&
						posY > e.getY() - Constantes.taille_obstacle && posY < e.getY() + Constantes.taille_obstacle){
					e.setActif(false);
				}	
			}
		
			

		}else{

			//dessin du background

			g.setColor(Color.white);
			passage.put(posX, posY);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());


			// dessin de la trajectoire en pointill�s

			g.setColor(Color.gray);
			for (int i : passage.keySet())
				g.fillOval(i + Constantes.taille_oiseau/2, passage.get(i) + Constantes.taille_oiseau/2, 3, 3);

			
			// dessin de la tengante
			
			/*for (int p=-50; p<Constantes.largeur_ecran; p++){
		    	z = (int) ((int) (2*a*p+(a-b+c))*(p-a)+ ((a * Math.pow(p, 2) + (a-b+c)* p +5)));
		    	w = (int) ((int) (2*a*(p+1)+(a-b+c))*((p+1)-a)+ ((a * Math.pow((p+1), 2) + (a-b+c)* (p+1) +5)));
		    	g.fillRect(p, z, p+1, w);
		    }*/

			// dessin de l'oiseau

			g.setColor(Color.blue);
			g.drawOval(posX, posY, Constantes.taille_oiseau, Constantes.taille_oiseau);


			//dessin des obstacles et d�tection des collisions

			for(Obstacle e : obstacles){
				if(e.isActif()){
					g.setColor(Constantes.couleur_obstacle);
					
					if(e instanceof ObstacleMouvant){
						((ObstacleMouvant) e).moveY();
						((ObstacleMouvant) e).moveX();
					}
					
					g.drawOval(e.getX(),e.getY(),Constantes.taille_obstacle,Constantes.taille_obstacle);
				}else{
					g.setColor(Constantes.couleur_obstacle_touche);
					g.drawOval(e.getX(), e.getY(), Constantes.taille_obstacle, Constantes.taille_obstacle);
				}
				if(posX > e.getX() - Constantes.taille_obstacle && posX < e.getX() + Constantes.taille_obstacle &&
						posY > e.getY() - Constantes.taille_obstacle && posY < e.getY() + Constantes.taille_obstacle){
					e.setActif(false);
				}	
			}
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	private void initimg() {
		try {
			bird = ImageIO.read(new File("img/birds/red/bird.png"));
			background = ImageIO.read(new File("img/background.jpg"));
			slingshot = ImageIO.read(new File("img/slingshot.png"));
			obstacle = ImageIO.read(new File("img/caisse.png"));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Image getBird() {
		return bird;
	}

	public int getEchelle() {
		return echelle;
	}

	public Map<Integer, Integer> getPassage() {
		return passage;
	}


}