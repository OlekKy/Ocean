package pl.ak.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GameObject {

	private Texture tekstura;
	private Vector2 polozenie;
	
	
	
	public GameObject (Texture tekst){
		tekstura=tekst;
		setPolozenie(new Vector2(200,200));
		
	}
	
	public void ZmienPolozenie(int dx, int dy){
		polozenie.x+=dx;
		polozenie.y+=dy;
	}
	 public boolean czyWSrodku(float h, float w){
		 if ((polozenie.x<0) || (polozenie.y<0) || polozenie.x>(w-tekstura.getWidth()) || polozenie.y>(h-tekstura.getHeight())){
			return false; 
		 }
		return true;
	 }
	

	 
	 
	public Texture getTekstura() {
		return tekstura;
	}

	public Vector2 getPolozenie() {
		return polozenie;
	}

	public void setPolozenie(Vector2 polozenie) {
		this.polozenie = polozenie;
	}


}
