package programme;

public class Case {
	//ATTRIBUTS
	private int x;
	private int y;
	private String pion; 
	
	//CONSTRUCTEURS 
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
		this.pion = " ";
	}
	
	//METHODE
	public String toString () {
		return "(" + this.x + "; " + this.y + ")";
	}
	
	//GETTERS AND SETTERS
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	public String getPion() {return pion;}
	public void setPion(String p) {this.pion = p;}
}
