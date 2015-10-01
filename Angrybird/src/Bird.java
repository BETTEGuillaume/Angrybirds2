
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bird extends JPanel {

	private Image bird;
	private Image background;
	private int echelle ;
	boolean lol = true;
	
	//constructeur
	public Bird(int echelle){
		this.echelle = echelle;
	}
	
	private int posX = -50;
	private int posY = 550*3;
	
	Map<Integer, Integer> passage = new HashMap<>();

	public void paintComponent(Graphics g) {
		//initialisation des images
		//initimg();
		
		g.setColor(Color.white);
		String tmp = posX + "";
		//if(tmp.charAt(tmp.length()-1) == '0')
			passage.put(posX, posY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		
		//dessin de la trajectoire en pointillés
		
		g.setColor(Color.black);
		
		for (int i : passage.keySet())
			g.fillOval(i+22, passage.get(i)+12, 3, 3);
		
		
		//dessin de l'oiseau
		
		g.setColor(Color.blue);
		g.fillOval(posX, posY, 50, 30);
		//g.drawImage(bird,posX,posY,50,50,null);

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
	
	
	protected void initimg(){
		try{
			bird = ImageIO.read(new File("img/birds/red/bird.png"));
			background = ImageIO.read(new File("img/background.jpg"));
		}catch(Exception e){
			e.getMessage();
		}
	}
}