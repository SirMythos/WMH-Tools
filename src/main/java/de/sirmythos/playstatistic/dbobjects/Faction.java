package de.sirmythos.playstatistic.dbobjects;

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
@SequenceGenerator(name = "factionID", initialValue = 1, allocationSize = 1)
@Table(name = "FACTIONS", catalog = "PUBLIC")
public class Faction {

	// Variables

	/** The id. */
	private int ID;

	/** The Faction name. */
	private String FactionName;

	/** The Faction short name. */
	private String FactionShortName;

	// Constructors

	/**
	 * Default-Constructor for database
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
		return ID;
	}

	/**
	 * Gets the faction name.
	 *
	 * @return Name of the Faction
	 */
	@Column(name = "Faction")
	public String getFactionName() {
		return FactionName;
	}

	/**
	 * Gets the faction short name.
	 *
	 * @return Short-Form of the Faction
	 */
	@Column(name = "FactionShort")
	public String getFactionShortName() {
		return FactionShortName;
	}

	// Setter

	/**
	 * @param Set
	 *            A new id. Should never be used.
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Sets the faction name.
	 *
	 * @param factionName
	 *            the new faction name
	 */
	public void setFactionName(String factionName) {
		FactionName = factionName;
	}

	/**
	 * Sets the faction short name.
	 *
	 * @param factionShortName
	 *            the new faction short name
	 */
	public void setFactionShortName(String factionShortName) {
		FactionShortName = factionShortName;
	}

}
