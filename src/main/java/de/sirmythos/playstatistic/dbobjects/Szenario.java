package de.sirmythos.playstatistic.dbobjects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "szenarioID", sequenceName = "szenarioID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "SZENARIO")
public class Szenario {

	// Variables

	private int id;
	private String name;
	private Steamroller steamroller;

	// Constructors

	public Szenario() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "szenarioID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	@Column(name = "Name")
	public String getName() {
		return name;
	}

	/**
	 * @return the steamroller
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Steamroller", nullable = false)
	public Steamroller getSteamroller() {
		return steamroller;
	}

	// Setter

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param steamroller
	 *            the steamroller to set
	 */
	public void setSteamroller(Steamroller steamroller) {
		this.steamroller = steamroller;
	}

}
