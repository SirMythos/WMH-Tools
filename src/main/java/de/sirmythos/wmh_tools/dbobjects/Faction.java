package de.sirmythos.wmh_tools.dbobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Faction.
 * 
 * @author Lutz Kramer
 */
@Entity
@SequenceGenerator(name = "factionID", sequenceName = "factionID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "FACTIONS")
public class Faction {

	// Variables

	/** The id. */
	private int id;

	/** The Faction name. */
	private String factionName;

	/** The Faction short name. */
	private String factionShortName;

	// Constructors

	/**
	 * Default-Constructor for database.
	 */
	public Faction() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * @return The id in the Database
	 */
	@Id
	@GeneratedValue(generator = "factionID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getID() {
		return id;
	}

	/**
	 * Gets the faction name.
	 *
	 * @return Name of the Faction
	 */
	@Column(name = "Faction")
	public String getFactionName() {
		return factionName;
	}

	/**
	 * Gets the faction short name.
	 *
	 * @return Short-Form of the Faction
	 */
	@Column(name = "FactionShort")
	public String getFactionShortName() {
		return factionShortName;
	}

	// Setter

	/**
	 * @param Set
	 *            A new id. Should never be used.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Sets the faction name.
	 *
	 * @param factionName
	 *            the new faction name
	 */
	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	/**
	 * Sets the faction short name.
	 *
	 * @param factionShortName
	 *            the new faction short name
	 */
	public void setFactionShortName(String factionShortName) {
		this.factionShortName = factionShortName;
	}

}
