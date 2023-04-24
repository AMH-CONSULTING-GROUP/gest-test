package com.fth.stock.dto;

public class MaterielDto {
	private Integer materielId;

	private String name;
	private String description;
	private long quantite;
	private long minQuantite;
	private String expireAt;

	public Integer getMaterielId() {
		return materielId;
	}

	public void setMaterielId(Integer materielId) {
		this.materielId = materielId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public long getMinQuantite() {
		return minQuantite;
	}

	public void setMinQuantite(long minQuantite) {
		this.minQuantite = minQuantite;
	}

	public String getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}

}
