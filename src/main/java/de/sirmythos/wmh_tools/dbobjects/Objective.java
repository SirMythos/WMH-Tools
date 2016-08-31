/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Objective.java
 *
 * Date:	31.08.2016
 * Time:	10:48:16
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import java.io.File;

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
 * The Class Objective.
 */
@Entity
@SequenceGenerator(name = "objectiveID", sequenceName = "objectiveID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "OBJECTIVE")
public class Objective {

	// Variables
	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/** The rules. */
	private RuleEnviroment rules;

	/** The card. */
	private File card;

	// Constructor

	/**
	 * Instantiates a new objective.
	 */
	public Objective() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "objectiveID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(name = "ObjectiveName")
	public String getName() {
		return name;
	}

	/**
	 * Gets the rules.
	 *
	 * @return the rules
	 */
	@JoinColumn(name = "RuleEnviroment", nullable = false)
	public RuleEnviroment getRules() {
		return rules;
	}

	/**
	 * Gets the card.
	 *
	 * @return the card
	 */
	@JoinColumn(name = "CardImage")
	public File getCard() {
		return card;
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
	 * Sets the rules.
	 *
	 * @param rules
	 *            the rules to set
	 */
	public void setRules(RuleEnviroment rules) {
		this.rules = rules;
	}

	/**
	 * Sets the card.
	 *
	 * @param card
	 *            the card to set
	 */
	public void setCard(File card) {
		this.card = card;
	}

}
