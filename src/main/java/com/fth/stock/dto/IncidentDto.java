package com.fth.stock.dto;

public class IncidentDto {

	private long materielId;
	private long userId;
	private String cause;
	private String description;
	private long quantite;

	public long getMaterielId() {
		return materielId;
	}

	public void setMaterielId(long materielId) {
		this.materielId = materielId;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

}
