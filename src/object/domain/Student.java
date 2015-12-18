package object.domain;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
@SuppressWarnings("serial")
public class Student implements IDObject, Serializable{
	
	/** The matricol. */
	private int matricol;
	
	/** The nume. */
	private String nume;
	
	/** The medie. */
	private double medie;
	/**
	 * Instantiates a new student.
	 */
	Student() {
		matricol = 1;
		nume = "";
		medie = 0;
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param matricol the matricol
	 * @param nume the nume
	 * @param medie the medie
	 */
	public Student(Integer matricol, String nume, Double medie) {
		this.matricol = matricol;
		this.nume = nume;
		this.medie = medie;
	}

	/**
	 * Sets the matricol.
	 *
	 * @param matricol the new matricol
	 */
	public void setMatricol(int matricol) {
		this.matricol = matricol;
	}
	
	/**
	 * Sets the nume.
	 *
	 * @param nume the new nume
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	/**
	 * Sets the medie.
	 *
	 * @param medie the new medie
	 */
	public void setMedie(Double medie) {
		this.medie = medie;
	}
	
	/**
	 * Gets the matricol.
	 *
	 * @return the matricol
	 */
	public int getMatricol() {
		return matricol;
	}
	
	/**
	 * Gets the medie.
	 *
	 * @return the medie
	 */
	public double getMedie() {
		return medie;
	}
	
	/**
	 * Gets the nume.
	 *
	 * @return the nume
	 */
	public String getNume() {
		return nume;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return matricol + ";" + nume + ";" + medie;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return getMatricol();
	}
}
