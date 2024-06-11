package es.basedatospuertorico.view;

import java.sql.Date;

import es.basedatospuertorico.controller.Controllerpuertorico;
import es.basedatospuertorico.mode.Modelpuertorico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Viewpuertorico {
	
	@FXML
	private Button btnNuevo;
	@FXML
	private TableView<Modelpuertorico> tablaPuertorico;
	@FXML
	private TableColumn<Modelpuertorico,Integer> id;
	@FXML
	private TableColumn<Modelpuertorico,Date> fecha;
	@FXML
	private TableColumn<Modelpuertorico,String> referencia;
	@FXML
	private TableColumn<Modelpuertorico,String> categoria;
	@FXML
	private TableColumn<Modelpuertorico,Integer> cantidad;
	@FXML
	private TableColumn<Modelpuertorico,Double> valor;
	@FXML
	private TableColumn<Modelpuertorico,Double> total;
	
	private ObservableList <Modelpuertorico> puertorico= FXCollections.observableArrayList();
		
	private Controllerpuertorico Cpuertorico;
	
	public Viewpuertorico() {
		this.Cpuertorico= new Controllerpuertorico();
	}
	@FXML
	private void botonNuevo(ActionEvent event) {
		//btnNuevo= new Button();
		/*btnNuevo.setOnAction(e ->{
			System.out.println("Si esta funcionando");			
	});*/
		System.out.println("Si esta funcionando, Magucho");
	}
}
