package org.sirmythos.examples;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@SequenceGenerator(name = "testid", initialValue = 1, allocationSize = 1)
@Table(name = "test")
public class VO_User {

	private int intTestID;
	private String feld;

	// Default-Konstruktor:
	public VO_User() {
		// this form used by Hibernate
	}

	/* Getter */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "testid")
	public int getIntTestID() {
		return intTestID;
	}

	@Column(name = "feld")
	public String getFeld() {
		return feld;
	}

	/* Setter */
	public void setIntTestID(int intTestID) {
		this.intTestID = intTestID;
	}

	public void setFeld(String feld) {
		this.feld = feld;
	}

}
