/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	User.java
 *
 * Date:	10.10.2016
 * Time:	12:10:42
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import static javax.persistence.FetchType.EAGER;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@SequenceGenerator(name = "userID", sequenceName = "userID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "USERS")
public class User {

	/** The id. */
	private int id = 1;
	
	/** The name. */
	private String name;
	
	/** The pass. */
	private String pass;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		// leave empty for hibernate
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "userID")
	@Column(name = "ID", unique = true, insertable = true, updatable = true, nullable = false)
	public int getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(name = "Name", insertable = true, updatable = true, unique = true, nullable = false)
	@Basic(fetch = EAGER, optional = false)
	public String getName() {
		return name;
	}

	/**
	 * Gets the pass.
	 *
	 * @return the pass
	 */
	@Column(name = "Surname", insertable = true, updatable = true, unique = false)
	@Basic(fetch = EAGER, optional = false)
	public String getPass() {
		return pass;
	}

	/**
	 * Gets the player ID.
	 *
	 * @return the playerID
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PlayerID", nullable = false)
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the pass.
	 *
	 * @param pass
	 *            the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Sets the player ID.
	 *
	 * @param playerID
	 *            the playerID to set
	 */
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	/** The player ID. */
	private int playerID;

}
