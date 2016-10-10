/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Objective.java
 *
 * Date:	10.10.2016
 * Time:	10:09:56
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import java.io.File;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.sirmythos.language.LanguageHandler;
import de.sirmythos.wmh_tools.enums.RuleEnviroment;

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

	private Locale locale = null;

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
	@Column(name = "ObjectiveName", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Gets the rules.
	 *
	 * @return the rules
	 */
	@Column(name = "Rules", nullable = false)
	public RuleEnviroment getRules() {
		return rules;
	}

	/**
	 * Gets the card.
	 *
	 * @return the card
	 */
	@Column(name = "Card", nullable = true)
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

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String toString() {
		if (locale == null) {
			return name;
		} else {
			return LanguageHandler.translate(locale, Objective.class, name);
		}

	}

}
