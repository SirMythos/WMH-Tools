package org.sirmythos.examples;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "testid", initialValue = 1, allocationSize = 1)
@Table(name = "test")
public class VO_User {

	int intTestID;
	String feld;

    // Default-Konstruktor:
    public VO_User() {

	}

    
	/* Getter */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="testid", nullable=false)
	public int getIntTestID() {
		return intTestID;
	}
    
    @Column(name="feld", nullable=true)
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
