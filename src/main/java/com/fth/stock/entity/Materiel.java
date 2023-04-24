package com.fth.stock.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Materiel {

	@Id
	@Column(name = "materiel_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private String photo;
	private long quantite;
	private long minQuantite;

	private boolean deleted;
	private LocalDate createAt;
	private LocalDate modifiedDate;
	private LocalDate expireAt;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User createBy;

	public Materiel(String name, String description, String photo, long quantite, long minQuantite, LocalDate expireAt,
			User createBy) {
		super();
		this.name = name;
		this.description = description;
		this.photo = photo;
		this.quantite = quantite;
		this.expireAt = expireAt;
		this.createAt = LocalDate.now();
		this.deleted = false;
		this.createBy = createBy;
		this.minQuantite = minQuantite;
	}

	public long getMinQuantite() {
		return minQuantite;
	}

	public void setMinQuantite(long minQuantite) {
		this.minQuantite = minQuantite;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public Materiel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public LocalDate getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(LocalDate expireAt) {
		this.expireAt = expireAt;
	}

}