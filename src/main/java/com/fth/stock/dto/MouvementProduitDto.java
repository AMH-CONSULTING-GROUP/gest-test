package com.fth.stock.dto;

public class MouvementProduitDto {

	private long produitId;
	private String type;
	private long quantite;

	public long getProduitId() {
		return produitId;
	}

	public void setProduitId(long produitId) {
		this.produitId = produitId;
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
