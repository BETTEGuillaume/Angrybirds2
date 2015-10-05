
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
	private int echelle;
	static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	// constructeur
	public Bird(int echelle) {
		this.echelle = echelle;
	}
	
	private int posX = -50;
	private int posY = 550;
	Map<Integer, Integer> passage = new HashMap<>();
	
	
	public void paintComponent(Graphics g) {
		
		// initialisation des images
		// initimg();

		g.setColor(Color.white);
		passage.put(posX, posY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		

		// dessin de la trajectoire en pointillés

		g.setColor(Color.black);
		for (int i : passage.keySet())
			g.fillOval(i + 40, passage.get(i) + 40, 3, 3);
		

		// dessin de l'oiseau

		g.setColor(Color.blue);
		g.fillOval(posX, posY, 80, 80);

		
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
		} catch (Exception e) {
			e.getMessage();
		}
	}
}