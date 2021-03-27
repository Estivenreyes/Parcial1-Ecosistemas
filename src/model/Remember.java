package model;

public class Remember {
	
	private float posX;
	private float posY;
	private String remember;
	private String relevance;
	
	public Remember(float posX, float posY, String remember, String relevance) {
		this.posX = posX;
		this.posY = posY;
		this.remember = remember;
		this.relevance = relevance;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

	public String getRelevance() {
		return relevance;
	}

	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	
	

}
