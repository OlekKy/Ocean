package pl.ak.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	private Sprite sprajt;
	private Texture tekstura;
	private Vector2 polozenie;
	private Vector2 predkosc;
	private boolean trwaZmianaKierunku;
	private float stalazmiany=0.5f;

	public GameObject (Texture tekst){
		tekstura=tekst;
		setSprajt(new Sprite(tekstura));
		predkosc=new Vector2(0,0);
		setPolozenie(new Vector2(200,200));
		trwaZmianaKierunku=false;
	}

	public void ZmienPolozenie(int dx, int dy){
		polozenie.x+=dx;
		polozenie.y+=dy;
		sprajt.setPosition(polozenie.x,polozenie.y);

	}
	public void ZmienPolozenie(float dx, float dy){
		polozenie.x+=dx;
		polozenie.y+=dy;
		sprajt.setPosition(polozenie.x,polozenie.y);

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

	public Sprite getSprajt() {
		return sprajt;
	}

	public void setSprajt(Sprite sprajt) {
		this.sprajt = sprajt;
	}

	public void ZmienKierunek() {
		trwaZmianaKierunku=true;
			if (sprajt.getScaleX()>0)
			{
				stalazmiany=-0.5f;
			}else{
				stalazmiany=0.5f;
			}
	}

	public void ogranijRybke() {
		if (trwaZmianaKierunku){
			if (Math.abs(sprajt.getScaleX())<=1){
				sprajt.scale(stalazmiany*Gdx.graphics.getDeltaTime());
				sprajt.setScale(sprajt.getScaleX(), 1.0f);
			}
			else
			{				
				sprajt.setScale(Math.round(sprajt.getScaleX()),1.0f);
				trwaZmianaKierunku=false;
			}
		}
		aktualizujPolozenie();
		
	}

	private void aktualizujPolozenie() {
		
		polozenie.add(predkosc);
		sprajt.setPosition(polozenie.x, polozenie.y);
		if (!czyWSrodku(799, 604)){
			predkosc.x=-predkosc.x;
			predkosc.y=-predkosc.y;
		}
	}

	public void ZmienPredkosc(float x, float y) {
		predkosc.x+=x;
		predkosc.y+=y;
		
	}
}