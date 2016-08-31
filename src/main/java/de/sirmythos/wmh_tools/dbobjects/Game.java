/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Game.java
 *
 * Date:	31.08.2016
 * Time:	12:05:44
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import java.util.Date;

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

import de.sirmythos.wmh_tools.enums.VictoryCondition;
// TODO: Auto-generated Javadoc

/**
 * The Class Game.
 */
@Entity
@SequenceGenerator(name = "gameID", sequenceName = "gameID_sequence", initialValue = 1, allocationSize = 1)
@Table(name = "GAMES")
public class Game {

	// Variables

	/** The id. */
	private int id;

	// Player A - Setup
	/** The player A. */
	private Player playerA;

	/** The list player A. */
	private ArmyList listPlayerA;

	// Player B - Setup
	/** The player B. */
	private Player playerB;

	/** The list player B. */
	private ArmyList listPlayerB;

	// Game - Setup
	/** The date. */
	private Date date;

	/** The scenario. */
	private Scenario scenario;

	/** The army size. */
	private int armySize;

	/** The event. */
	private Event event;

	// Starting Conditions
	/** The victory start roll player A. */
	private boolean victoryStartRollPlayerA;

	/** The start first player A. */
	private boolean startFirstPlayerA;

	// Result of the Game
	/** The victory player A. */
	private boolean victoryPlayerA;

	/** The win type. */
	private VictoryCondition winType;

	/** The cp player A. */
	private int cpPlayerA;

	/** The cp plyer B. */
	private int cpPlyerB;

	/** The kp player A. */
	private int kpPlayerA;

	/** The kp player B. */
	private int kpPlayerB;

	// Comment
	/** The comment. */
	private String comment;

	// Constructor

	/**
	 * Instantiates a new game.
	 */
	public Game() {
		// leave empty for hibernate
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "gameID")
	@Column(name = "ID", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	/**
	 * Gets the player A.
	 *
	 * @return the playerA
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Player_A", nullable = false)
	public Player getPlayerA() {
		return playerA;
	}

	/**
	 * Gets the list player A.
	 *
	 * @return the listPlayerA
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ArmyList_Player_A", nullable = false)
	public ArmyList getListPlayerA() {
		return listPlayerA;
	}

	/**
	 * Gets the player B.
	 *
	 * @return the playerB
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Player_B", nullable = false)
	public Player getPlayerB() {
		return playerB;
	}

	/**
	 * Gets the list player B.
	 *
	 * @return the listPlayerB
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ArmyList_Player_B", nullable = false)
	public ArmyList getListPlayerB() {
		return listPlayerB;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	@Column(name = "Date", nullable = false)
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the scenario.
	 *
	 * @return the scenario
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Scenario", nullable = false)
	public Scenario getScenario() {
		return scenario;
	}

	/**
	 * Gets the army size.
	 *
	 * @return the armySize
	 */
	@Column(name = "Army_Size", nullable = false)
	public int getArmySize() {
		return armySize;
	}

	/**
	 * Gets the event.
	 *
	 * @return the event
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Event", nullable = false)
	public Event getEvent() {
		return event;
	}

	/**
	 * Checks if is victory start roll player A.
	 *
	 * @return the victoryStartRollPlayerA
	 */
	@Column(name = "Startroll")
	public boolean isVictoryStartRollPlayerA() {
		return victoryStartRollPlayerA;
	}

	/**
	 * Checks if is victory start roll player B.
	 *
	 * @return the victoryStartRollPlayerB
	 */
	public boolean isVictoryStartRollPlayerB() {
		return !victoryStartRollPlayerA;
	}

	/**
	 * Checks if is start first player A.
	 *
	 * @return the startFirstPlayerA
	 */
	@Column(name = "Starting")
	public boolean isStartFirstPlayerA() {
		return startFirstPlayerA;
	}

	/**
	 * Checks if is start first player B.
	 *
	 * @return the startFirstPlayerB
	 */
	public boolean isStartFirstPlayerB() {
		return !startFirstPlayerA;
	}

	/**
	 * Checks if is victory player A.
	 *
	 * @return the victoryPlayerA
	 */
	@Column(name = "Victory", nullable = false)
	public boolean isVictoryPlayerA() {
		return victoryPlayerA;
	}

	/**
	 * Checks if is victory player B.
	 *
	 * @return the victoryPlayerB
	 */
	public boolean isVictoryPlayerB() {
		return !victoryPlayerA;
	}

	/**
	 * Gets the cp player A.
	 *
	 * @return the cpPlayerA
	 */
	@Column(name = "CP_Player_A")
	public int getCpPlayerA() {
		return cpPlayerA;
	}

	/**
	 * Gets the cp plyer B.
	 *
	 * @return the cpPlyerB
	 */
	@Column(name = "CP_Player_B")
	public int getCpPlyerB() {
		return cpPlyerB;
	}

	/**
	 * Gets the kp player A.
	 *
	 * @return the kpPlayerA
	 */
	@Column(name = "KP_Player_A")
	public int getKpPlayerA() {
		return kpPlayerA;
	}

	/**
	 * Gets the kp player B.
	 *
	 * @return the kpPlayerB
	 */
	@Column(name = "KP_Player_B")
	public int getKpPlayerB() {
		return kpPlayerB;
	}

	/**
	 * Gets the win type.
	 *
	 * @return the winType
	 */
	@Column(name = "VictoryCondition", nullable = false)
	public VictoryCondition getWinType() {
		return winType;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	@Column(name = "Comment")
	public String getComment() {
		return comment;
	}

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
	 * Sets the player A.
	 *
	 * @param playerA
	 *            the playerA to set
	 */
	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	/**
	 * Sets the list player A.
	 *
	 * @param listPlayerA
	 *            the listPlayerA to set
	 */
	public void setListPlayerA(ArmyList listPlayerA) {
		this.listPlayerA = listPlayerA;
	}

	/**
	 * Sets the player B.
	 *
	 * @param playerB
	 *            the playerB to set
	 */
	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

	/**
	 * Sets the list player B.
	 *
	 * @param listPlayerB
	 *            the listPlayerB to set
	 */
	public void setListPlayerB(ArmyList listPlayerB) {
		this.listPlayerB = listPlayerB;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenario
	 *            the scenario to set
	 */
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	/**
	 * Sets the army size.
	 *
	 * @param armySize
	 *            the armySize to set
	 */
	public void setArmySize(int armySize) {
		this.armySize = armySize;
	}

	/**
	 * Sets the event.
	 *
	 * @param event
	 *            the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Sets the victory start roll player A.
	 *
	 * @param victoryStartRollPlayerA
	 *            the victoryStartRollPlayerA to set
	 */
	public void setVictoryStartRollPlayerA(boolean victoryStartRollPlayerA) {
		this.victoryStartRollPlayerA = victoryStartRollPlayerA;
	}

	/**
	 * Sets the start first player A.
	 *
	 * @param startFirstPlayerA
	 *            the startFirstPlayerA to set
	 */
	public void setStartFirstPlayerA(boolean startFirstPlayerA) {
		this.startFirstPlayerA = startFirstPlayerA;
	}

	/**
	 * Sets the victory player A.
	 *
	 * @param victoryPlayerA
	 *            the victoryPlayerA to set
	 */
	public void setVictoryPlayerA(boolean victoryPlayerA) {
		this.victoryPlayerA = victoryPlayerA;
	}

	/**
	 * Sets the cp player A.
	 *
	 * @param cpPlayerA
	 *            the cpPlayerA to set
	 */
	public void setCpPlayerA(int cpPlayerA) {
		this.cpPlayerA = cpPlayerA;
	}

	/**
	 * Sets the cp plyer B.
	 *
	 * @param cpPlyerB
	 *            the cpPlyerB to set
	 */
	public void setCpPlyerB(int cpPlyerB) {
		this.cpPlyerB = cpPlyerB;
	}

	/**
	 * Sets the kp player A.
	 *
	 * @param kpPlayerA
	 *            the kpPlayerA to set
	 */
	public void setKpPlayerA(int kpPlayerA) {
		this.kpPlayerA = kpPlayerA;
	}

	/**
	 * Sets the kp player B.
	 *
	 * @param kpPlayerB
	 *            the kpPlayerB to set
	 */
	public void setKpPlayerB(int kpPlayerB) {
		this.kpPlayerB = kpPlayerB;
	}

	/**
	 * Sets the win type.
	 *
	 * @param winType
	 *            the winType to set
	 */
	public void setWinType(VictoryCondition winType) {
		this.winType = winType;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
