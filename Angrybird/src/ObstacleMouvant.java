
public class ObstacleMouvant extends Obstacle{

	private int[] limites_x = {0,0};
	private int[] limites_y = {0,0};
	private boolean descente = true;
	
	public ObstacleMouvant(int x, int y) {
		super(x, y);
	}
	
	public ObstacleMouvant(int x, int y, boolean b){
		super(x, y, b);
	}
	
	public void moveX(){
		if(super.getX() != this.getLimites_x()[1]){
			super.setX(super.getX()+1);
		}
	}
	
	public void moveY(){
		
		if(super.getY() == this.getLimites_y()[0]){
			descente = true;
		}else if(super.getY() == this.getLimites_y()[1]){
			descente = false;
		}
		
		if(descente){
			super.setY(super.getY()+1);
		}else{
			super.setY(super.getY()-1);
		}
	}

	public int[] getLimites_x() {
		return limites_x;
	}

	public void setLimites_x(int[] limites_x) {
		this.limites_x = limites_x;
	}

	public int[] getLimites_y() {
		return limites_y;
	}

	public void setLimites_y(int[] limites_y) {
		this.limites_y = limites_y;
	}
	
	
	
	
	

}
