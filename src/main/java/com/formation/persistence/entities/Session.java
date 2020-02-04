package com.formation.persistence.entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="sessions")
@Entity
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date date;
	@Column
	private Long places;
	@Column(name="lieu")
	private String where;
	@Column(name="debut")
	private Time begin;
	@Column(name="fin")
	private Time end;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_activite")
	private Activity activity;
	
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
	public Long getPlaces() {
		return places;
	}
	public void setPlaces(Long places) {
		this.places = places;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public Time getBegin() {
		return begin;
	}
	public void setBegin(Time begin) {
		this.begin = begin;
	}
	public Time getEnd() {
		return end;
	}
	public void setEnd(Time end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", date=" + date + ", places=" + places + ", where=" + where + ", begin=" + begin
				+ ", end=" + end + "]";
	}
	
	
	

}
