/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	ArmyList.java
 *
 * Date:	02.09.2016
 * Time:	11:03:57
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ArmyList.
 */
@Entity
@SequenceGenerator(name = "armyListID", sequenceName = "armyListID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "ARMYLISTS")
public class ArmyList {

	// Variables

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/** The caster. */
	private Caster caster;

	/** The list. */
	private String list;

	/** The objective. */
	private Objective objective;

	// Constructor

	/**
	 * Instantiates a new army list.
	 */
	public ArmyList() {
		// leave empty for hibernate
	}

	// Getter

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "armyListID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(name = "Name", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Gets the caster.
	 *
	 * @return the caster
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Caster", nullable = false)
	public Caster getCaster() {
		return caster;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	@Column(name = "List")
	public String getList() {
		return list;
	}

	/**
	 * Gets the objective.
	 *
	 * @return the objective
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Objective")
	public Objective getObjective() {
		return objective;
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
	 * Sets the caster.
	 *
	 * @param caster
	 *            the caster to set
	 */
	public void setCaster(Caster caster) {
		this.caster = caster;
	}

	/**
	 * Sets the list.
	 *
	 * @param list
	 *            the list to set
	 */
	public void setList(String list) {
		this.list = list;
	}

	/**
	 * Sets the objective.
	 *
	 * @param objective
	 *            the objective to set
	 */
	public void setObjective(Objective objective) {
		this.objective = objective;
	}

}
