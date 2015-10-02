
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class Bird extends JPanel {

	private Image bird;
	private Image background;
	private int echelle;

	// constructeur
	public Bird(int echelle) {
		this.echelle = echelle;
	}
	
	private boolean cible1 = true;
	private boolean cible2 = true;
	private boolean cible3 = true;
	private int posX = -50;
	private int posY = 550;
	Map<Integer, Integer> passage = new HashMap<>();
	
	//liste contenant tous les obstacles
	List obstacles = new List();

	public void paintComponent(Graphics g) {
		// initialisation des images
		// initimg();

		g.setColor(Color.white);
		// String tmp = posX + "";
		// if(tmp.charAt(tmp.length()-1) == '0')
		passage.put(posX, posY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		

		// dessin de la trajectoire en pointillés

		g.setColor(Color.black);

		for (int i : passage.keySet())
			g.fillOval(i + 22, passage.get(i) + 12, 3, 3);

		
		// dessin de l'oiseau

		g.setColor(Color.blue);
		g.fillOval(posX, posY, 50, 30);
		// g.drawImage(bird,posX,posY,50,50,null);
		if (posX >= 550 && posX <= 650 && posY >= 350 && posY <= 450) {
			cible1 = false;
		}
		if (cible1) {
			g.setColor(Color.red);
			g.fillOval(600, 400, 100, 100);
		}
		if (posX >= 450 && posX <= 550 && posY >= 150 && posY <= 250) {
			cible2 = false;
		}
		if (cible2) {
			g.setColor(Color.red);
			g.fillOval(500, 200, 100, 100);
		}
		if (posX >= 350 && posX <= 450 && posY >= 350 && posY <= 450) {
			cible3 = false;
		}
		if (cible3) {
			g.setColor(Color.red);
			g.fillOval(400, 400, 100, 100);
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