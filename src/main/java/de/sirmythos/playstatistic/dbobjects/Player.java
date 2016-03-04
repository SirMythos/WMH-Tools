package de.sirmythos.playstatistic.dbobjects;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 * 
 * @author Lutz Kramer
 */
@Entity
@SequenceGenerator(name = "playerID", initialValue = 1, allocationSize = 1)
@Table(name = "PLAYERS")
public class Player {

	// Variables

	/** The id. */
	private int ID;

	/** The name. */
	private String name;

	/** The surname. */
	private String surname;

	/** The nickname. */
	private String nickname;

	/** The photo. */
	private File photo;

	// Constructors

	/**
	 * Instantiates a new player.
	 */
	// Default-Constructor for database
	public Player() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "playerID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getID() {
		return ID;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(name = "Name")
	public String getName() {
		return name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	@Column(name = "Surname")
	public String getSurname() {
		return surname;
	}

	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	@Column(name = "Nickname")
	public String getNickname() {
		return nickname;
	}

	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	@Column(name = "Photo", nullable = true)
	public File getPhoto() {
		return photo;
	}

	// Setter

	/**
	 * Sets the id.
	 *
	 * @param iD
	 *            the new id
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname
	 *            the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Sets the nickname.
	 *
	 * @param nickname
	 *            the new nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Sets the photo.
	 *
	 * @param photo
	 *            the new photo
	 */
	public void setPhoto(File photo) {
		this.photo = photo;
	}

}
