package com.fth.stock.dto;

public class ProduitDto {

	private Integer userId;

	private String name;
	private String description;
	private long quantite;
	private long minQuantite;
	private boolean inflammable;
	private String type;
	private String unite;
	private String expireAt;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public boolean isInflammable() {
		return inflammable;
	}

	public void setInflammable(boolean inflammable) {
		this.inflammable = inflammable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getMinQuantite() {
		return minQuantite;
	}

	public void setMinQuantite(long minQuantite) {
		this.minQuantite = minQuantite;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public String getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}

}