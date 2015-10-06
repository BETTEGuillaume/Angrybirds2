
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


			// dessin de la trajectoire en pointillés

			g.setColor(Color.gray);
			for (int i : passage.keySet())
				g.fillOval(i + Constantes.taille_oiseau/2, passage.get(i) + Constantes.taille_oiseau/2, 3, 3);


			// dessin de l'oiseau

			g.drawImage(bird, posX, posY, Constantes.taille_oiseau, Constantes.taille_oiseau,null);


			//dessin des obstacles et détection des collisions

			g.setColor(Constantes.couleur_obstacle);
			for(Obstacle e : obstacles){
				if(e.isActif()){
					//g.fillRect(e.getX(),e.getY(),Constantes.taille_obstacle,Constantes.taille_obstacle);
					g.drawImage(obstacle, e.getX(), e.getY(), Constantes.taille_obstacle, Constantes.taille_obstacle, null);
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


			// dessin de la trajectoire en pointillés

			g.setColor(Color.gray);
			for (int i : passage.keySet())
				g.fillOval(i + Constantes.taille_oiseau/2, passage.get(i) + Constantes.taille_oiseau/2, 3, 3);


			// dessin de l'oiseau

			g.setColor(Color.blue);
			g.fillOval(posX, posY, Constantes.taille_oiseau, Constantes.taille_oiseau);


			//dessin des obstacles et détection des collisions

			g.setColor(Constantes.couleur_obstacle);
			for(Obstacle e : obstacles){
				if(e.isActif()){
					g.fillRect(e.getX(),e.getY(),Constantes.taille_obstacle,Constantes.taille_obstacle);
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