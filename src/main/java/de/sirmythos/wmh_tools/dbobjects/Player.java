/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Player.java
 *
 * Date:	02.09.2016
 * Time:	11:23:08
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import static javax.persistence.FetchType.EAGER;

import java.io.File;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class Player is the JPA-Entity-Class for Player-Objects in the dynamic
 * database of this project. Player can be added and edited by every user of
 * this tool.
 * 
 */
@Entity
@SequenceGenerator(name = "playerID", sequenceName = "playerID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "PLAYERS")
public class Player {

	// Variables

	/** The id of the object, starting with 1. */
	private int id = 1;

	/** The name of the player. */
	private String name;

	/** The surname of the player. */
	private String surname;

	/** The nickname of the player. */
	private String nickname;

	/** The photo of the player. */
	private File photo;

	// Constructors

	/**
	 * Default-Constructor for database.
	 */
	public Player() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return The id of the object
	 */
	@Id
	@GeneratedValue(generator = "playerID")
	@Column(name = "ID", unique = true, insertable = true, updatable = true, nullable = false)
	public int getID() {
		return id;
	}

	/**
	 * Gets the name of the player.
	 *
	 * @return The name of the player.
	 */
	@Column(name = "Name", insertable = true, updatable = true, unique = false, nullable = false)
	@Basic(fetch = EAGER, optional = false)
	public String getName() {
		return name;
	}

	/**
	 * Gets the surname of the player.
	 *
	 * @return The surname of the player.
	 */
	@Column(name = "Surname", insertable = true, updatable = true, unique = false)
	@Basic(fetch = EAGER, optional = false)
	public String getSurname() {
		return surname;
	}

	/**
	 * Gets the nickname of the player.
	 *
	 * @return The nickname of the player.
	 */
	@Column(name = "Nickname", unique = false, updatable = true, insertable = true)
	@Basic(fetch = EAGER, optional = false)
	public String getNickname() {
		return nickname;
	}

	/**
	 * Gets the photo of the player.
	 *
	 * @return The photo of the player.
	 */
	@Column(name = "Photo", nullable = true, insertable = true, updatable = true, unique = false)
	@Basic(optional = true, fetch = EAGER)
	public File getPhoto() {
		return photo;
	}

	// Setter

	/**
	 * Sets the I of the player. DO NOT USE, SINCE IT IS CREATED BY THE
	 * DATABASE.
	 *
	 * @param iD
	 *            The new ID of the player.
	 */
	public void setID(int iD) {
		id = iD;
	}

	/**
	 * Sets the name of the player.
	 *
	 * @param name
	 *            The new name of the player.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the surname of the player.
	 *
	 * @param surname
	 *            The new surname of the player.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Sets the nickname of the player.
	 *
	 * @param nickname
	 *            The new nickname of the player.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Sets the photo of the player.
	 *
	 * @param photo
	 *            The new photo of the player.
	 */
	public void setPhoto(File photo) {
		this.photo = photo;
	}

	/**
	 * Overrides the toString() Method of a normal Java-Object. This Method
	 * returns the full name of the player.
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return full_name The full name of the player, showing as on string (name
	 *         "nickname" surname).
	 */
	@Override
	public String toString() {

		return getName() + " \"" + getNickname() + "\" " + getSurname();

	}

}
