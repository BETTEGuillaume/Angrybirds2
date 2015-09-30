
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Bird extends JPanel {

	private int posX = -50;
	private int posY = 550;
	Map<Integer, Integer> passage = new HashMap<>();

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		String tmp = posX + "";
		if(tmp.charAt(tmp.length()-1) == '0')
			passage.put(posX, posY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for (int i : passage.keySet()) {
			g.setColor(Color.black);
			g.fillOval(i+22, passage.get(i)+12, 3, 3);
		}
		g.setColor(Color.red);
		g.fillOval(posX, posY, 50, 30);

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
}