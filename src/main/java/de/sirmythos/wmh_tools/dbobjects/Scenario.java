/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Scenario.java
 *
 * Date:	02.08.2016
 * Time:	15:52:12
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Scenario.
 */
@Entity
@SequenceGenerator(name = "scenarioID", sequenceName = "scenarioID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "SCENARIO")
public class Scenario {

	// Variables

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/** The type. */
	private ScenarioType type;

	/** The kill box. */
	private boolean killBox;

	// Constructors

	/**
	 * Instantiates a new scenario.
	 */
	public Scenario() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "scenarioID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
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
	 * Gets the scenario type.
	 *
	 * @return the steamroller
	 */
	@JoinColumn(name = "ScenarioType", nullable = false)
	public ScenarioType getType() {
		return type;
	}

	/**
	 * Checks if is kill box.
	 *
	 * @return true, if is kill box
	 */
	@JoinColumn(name = "KillBox", nullable = false)
	public boolean isKillBox() {
		return killBox;
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
	 * Sets the name.
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the steamroller.
	 *
	 * @param scenarioType
	 *            the scenarioType to set
	 */
	public void setType(ScenarioType scenarioType) {
		this.type = scenarioType;
	}

	/**
	 * Sets the kill box.
	 *
	 * @param killBox
	 *            the new kill box
	 */
	public void setKillBox(boolean killBox) {
		this.killBox = killBox;
	}

}
