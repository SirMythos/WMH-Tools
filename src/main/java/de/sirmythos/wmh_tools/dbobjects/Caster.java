package de.sirmythos.wmh_tools.dbobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.sirmythos.wmh_tools.enums.Faction;

// TODO: Auto-generated Javadoc
/**
 * The Class Caster.
 * 
 * @author Lutz Kramer
 */
@Entity
@SequenceGenerator(name = "casterID", sequenceName = "casterID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "CASTER")
public class Caster {

	// Variables

	/** The id. */
	private int id;

	/** The caster name. */
	private String casterName;

	/** The caster short name. */
	private String casterShortName;

	/** The faction. */
	private Faction faction;

	// Constructors

	/**
	 * Default-Constructor for database.
	 */
	public Caster() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "casterID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	/**
	 * Gets the caster name.
	 *
	 * @return the caster name
	 */
	@Column(name = "CasterName")
	public String getCasterName() {
		return casterName;
	}

	/**
	 * Gets the caster short name.
	 *
	 * @return the caster short name
	 */
	@Column(name = "CasterShortName")
	public String getCasterShortName() {
		return casterShortName;
	}

	/**
	 * Gets the faction.
	 *
	 * @return the faction
	 */
	@Column(name = "Faction", nullable = false)
	public Faction getFaction() {
		return faction;
	}

	// Setter

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the caster name.
	 *
	 * @param casterName
	 *            the new caster name
	 */
	public void setCasterName(String casterName) {
		this.casterName = casterName;
	}

	/**
	 * Sets the caster short name.
	 *
	 * @param casterShortName
	 *            the new caster short name
	 */
	public void setCasterShortName(String casterShortName) {
		this.casterShortName = casterShortName;
	}

	/**
	 * Sets the faction.
	 *
	 * @param faction
	 *            the new faction
	 */
	public void setFaction(Faction faction) {
		this.faction = faction;
	}

}
