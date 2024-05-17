package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.SaturnFlora;
import repository.floriculturaRepository;

public class floriculturaController {
//Cntrl + espaço importar!
	@FXML 
	private TableView<SaturnFlora> tableView;
	
	@FXML
	private TableColumn<SaturnFlora, String> cPersonalizado;
	
	@FXML
	private TableColumn<SaturnFlora, String> cMsgPersonalizada;
	
	@FXML
	private TableColumn<SaturnFlora, String> cDataEntrega;
	
	@FXML
	private TextField personalizado;

	@FXML
	private TextField dataEntrega;

	@FXML
	private TextField MsgPersonalizada;

	private floriculturaRepository repoFlor;

	@FXML
	public void initialize() {
		repoFlor = new floriculturaRepository();
	}

	public void cadastrar() {
		SaturnFlora saturnflora = new SaturnFlora();
		saturnflora.setPersonalizado(personalizado.getText());
		saturnflora.setDataEntrega(dataEntrega.getText());
		saturnflora.setMsgPersonalizada(MsgPersonalizada.getText());
		repoFlor.addSaturnFlora(saturnflora);
	}

	public void clearFields() {
		personalizado.clear();
		dataEntrega.clear();
		MsgPersonalizada.clear();
	}

	public void limpar() {
		clearFields();
	}
}
