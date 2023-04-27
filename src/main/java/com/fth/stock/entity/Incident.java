package com.fth.stock.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Incident {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate createAt;
	private String cause;
	private String description;
	private long quantite;
	private boolean deleted;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "materiel_id")
	private Materiel materiel;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public Incident(String cause, String description, long quantite, Materiel materiel, User user) {
		super();
		this.cause = cause;
		this.description = description;
		this.quantite = quantite;
		this.materiel = materiel;
		this.user = user;
		this.createAt = LocalDate.now();
		this.deleted = false;
	}

	public Incident() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
