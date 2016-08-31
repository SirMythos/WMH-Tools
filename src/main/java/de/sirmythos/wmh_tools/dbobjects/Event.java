/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Event.java
 *
 * Date:	31.08.2016
 * Time:	10:54:01
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Event.
 */
@Entity
@SequenceGenerator(name = "eventID", sequenceName = "eventID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "EVENT")
public class Event {

	// Variables

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	// Constructors

	/**
	 * Instantiates a new event.
	 */
	public Event() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "eventID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(name = "EventName")
	public String getName() {
		return name;
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

}
