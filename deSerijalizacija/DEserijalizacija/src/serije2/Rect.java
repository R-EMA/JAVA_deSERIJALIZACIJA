package serije2;

import java.io.Serializable;

public class Rect implements Serializable {
	
	private static final long serialVersionUID = 120001222312224L; //custom ID
	
	private int a;
	private int b;
	
	public Rect(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int povrsina() {
		return a*b;
	}
	
	public int obim() {
		return 2*(a+b);
	}
	
	public void setAB(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Rect [" + a + "," + b + "]: p=" + povrsina() + " o=" + obim();
	}	

}
