package application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class DTO {

	//private Integer ID;
	//private String name;
	//private String col;

	private SimpleIntegerProperty ID;
	private SimpleStringProperty name;
	private SimpleStringProperty col;

	public DTO(Integer ID, String name, String col) {
		//super();
		//this.ID = ID; 
		//this.name = name; 
		//this.col = col;
		this.ID = new SimpleIntegerProperty(ID);
		this.name = new SimpleStringProperty(name);
		this.col = new SimpleStringProperty(col);
	}

	public SimpleIntegerProperty IDProperty() { return ID; }
	public SimpleStringProperty nameProperty() { return name; }
	public SimpleStringProperty colProperty() { return col; }

	/*
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getcol() {
		return col;
	}
	public void setcol(String col) {
		this.col = col;
	}


	public Integer getID() {
		return ID.get();
	}
	public void setID(Integer ID) {
		this.ID.set(ID);
	}
	public String getname() {
		return name.get();
	}
	public void setname(String name) {
		this.name.set(name);
	}
	public String getcol() {
		return col.get();
	}
	public void setcol(String col) {
		this.col.set(col);
	}
	 */

}
