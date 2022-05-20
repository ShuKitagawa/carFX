package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tblView {
	/** ID */
	private StringProperty id;
	/** 車種名 */
	private StringProperty name;
	/** 燃料 */
	private StringProperty fuel;

	/**
	 * @return no
	 */
	public StringProperty idProperty(){
		return id;
	}

	/**
	 * @param no
	 *            セットする no
	 */
	public void setId(String no){
		this.id = new SimpleStringProperty(no);
	}

	/**
	 * @return name
	 */
	public StringProperty nameProperty(){
		return name;
	}

	/**
	 * @param name
	 *            セットする name
	 */
	public void setName (String name){
		this.name = new SimpleStringProperty(name);
	}

	/**
	 * @return sex
	 */
	public StringProperty fuelProperty(){
		return fuel;
	}

	/**
	 * @param sex
	 *            セットする sex
	 */
	public void setFuel(String sex){
		this.fuel = new SimpleStringProperty(sex);
	}

}
