package application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class DTO {

	private SimpleIntegerProperty ID;
	private SimpleStringProperty name;
	private SimpleStringProperty col;

	public DTO(Integer ID, String name, String col) {

		this.ID = new SimpleIntegerProperty(ID);
		this.name = new SimpleStringProperty(name);
		this.col = new SimpleStringProperty(col);
	}

	public SimpleIntegerProperty IDProperty() { return ID; }
	public SimpleStringProperty nameProperty() { return name; }
	public SimpleStringProperty colProperty() { return col; }

}
