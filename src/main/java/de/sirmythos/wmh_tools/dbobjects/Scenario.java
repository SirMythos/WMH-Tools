/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Scenario.java
 *
 * Date:	02.09.2016
 * Time:	11:33:18
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

import de.sirmythos.wmh_tools.enums.RuleEnviroment;

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
	private RuleEnviroment rules;

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
	 * Gets the type.
	 *
	 * @return the rules
	 */
	public RuleEnviroment getRules() {
		return rules;
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
	 * Sets the type.
	 *
	 * @param rules
	 *            the rules to set
	 */
	public void setRules(RuleEnviroment rules) {
		this.rules = rules;
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
