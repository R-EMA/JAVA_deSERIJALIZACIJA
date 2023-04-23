package serije;

import java.io.Serializable;

public class Pratilac implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int a;
	public String b;
	public transient String c; //transient ako ne treba da se prati vrednost
	
	public Pratilac(int a, String b) {
		this.a = a;
		this.b = b;
		this.c = b + "." + a;
	}	

}
