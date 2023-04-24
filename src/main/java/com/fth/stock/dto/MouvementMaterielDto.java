package com.fth.stock.dto;

public class MouvementMaterielDto {

	private long materielId;
	private String type;
	private long quantite;

	public long getMaterielId() {
		return materielId;
	}

	public void setMaterielId(long materielId) {
		this.materielId = materielId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

}
