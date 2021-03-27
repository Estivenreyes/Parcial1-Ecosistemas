package view;

import java.util.ArrayList;

import communicaton.TCP_Singleton;
import model.Remember;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());

	}
	
	TCP_Singleton tcp;
	private String[] ArrayRemember;
	private ArrayList<Remember> remember;
	
	public void settings() {
		size(1000,700);
	}
	
	public void setup() {
		remember = new ArrayList<Remember>();
		tcp = new TCP_Singleton(this);
		tcp.waitingConexion();

	}
	
	public void draw() {
		background(255);

		for (int i = 0; i < remember.size(); i++) {
			fill(255);
			rectMode(CENTER);
			rect(remember.get(i).getPosX(), remember.get(i).getPosY(), 300, 100);

			fill(0);
			textAlign(CENTER, CENTER);
			textSize(20);
			text(remember.get(i).getRemember(), remember.get(i).getPosX(), remember.get(i).getPosY());

			if (remember.get(i).getRelevance().equals("1")) {
				fill(0, 255, 0);

			} else if (remember.get(i).getRelevance().equals("2")) {
				fill(255, 255, 0);

			} else if (remember.get(i).getRelevance().equals("3")) {
				fill(255, 0, 0);
				
			} else {
				fill(155);

			}

			ellipse(remember.get(i).getPosX(), remember.get(i).getPosY() - 50, 50, 50);
		}
		
		fill(0);
		textAlign(CENTER,CENTER);
		textSize(25);
		text("reminders created" + remember.size(), 200, 30);
	}
	
	public String[] getArrayRemember() {
		return ArrayRemember;
		
	}
	
	public void setArrayRemember(String[] arrayRem) {
		this.ArrayRemember = arrayRem;
	}
	
	public ArrayList<Remember> getList(){
		return remember;
		
	}
	
	public void setList(ArrayList<Remember> rem) {
		this.remember = rem;
	}

}
