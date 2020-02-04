package com.formation.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="inscriptions")
@Entity
public class Inscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;
	
	@OneToOne
	@JoinColumn(name="id_session")
	private Session session;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "Inscription [id=" + id + ", date=" + date + ", adherent=" + adherent + ", session=" + session + "]";
	}
	
	
	

}
