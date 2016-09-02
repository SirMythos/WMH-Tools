/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.dbobjects
 * File:	Tournament.java
 *
 * Date:	02.09.2016
 * Time:	12:02:05
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.dbobjects;

import de.sirmythos.wmh_tools.dbobjects.Event;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

public class Tournament implements Serializable {

	private int ID;
	private Event event;
	private List<Player> players;
	private int divideAndConquer;
	private List<ArmyList> armyList1;
	private List<ArmyList> armyList2;

}
