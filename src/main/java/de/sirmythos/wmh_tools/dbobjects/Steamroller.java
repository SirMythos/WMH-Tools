package de.sirmythos.wmh_tools.dbobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Steamroller.
 * 
 * @author Lutz Kramer
 * 
 */
@Entity
@SequenceGenerator(name = "steamrollerID", sequenceName = "steamrollerID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "STEAMROLLER")
public class Steamroller {

	// Variables

	/** The id. */
	private int id;

	/** The steamroller. */
	private String steamroller;

	// Constructors

	/**
	 * Instantiates a new steamroller.
	 */
	public Steamroller() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "steamrollerID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	/**
	 * Gets the steamroller.
	 *
	 * @return the steamroller
	 */
	@Column(name = "Steamroller")
	public String getSteamroller() {
		return steamroller;
	}

	// Setter

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
	 * Sets the steamroller.
	 *
	 * @param steamroller
	 *            the steamroller to set
	 */
	public void setSteamroller(String steamroller) {
		this.steamroller = steamroller;
	}

}
