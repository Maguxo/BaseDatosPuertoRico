package es.basedatospuertorico.view;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import es.basedatospuertorico.controller.Controllerpuertorico;
import es.basedatospuertorico.mode.Modelpuertorico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

public class Viewpuertorico  implements Initializable{
	
	
	@FXML
	private TextField txtBuscar;
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
	private TableColumn<Modelpuertorico,Double> valor_unitario;
	@FXML
	private TableColumn<Modelpuertorico,Double> total;
	
	//private ObservableList <Modelpuertorico> observableList= FXCollections.observableArrayList();
		
	private Controllerpuertorico Cpuertorico;
	
	public Viewpuertorico() {
		this.Cpuertorico= new Controllerpuertorico();
	}	
	
	
	@FXML
	private void btnBusca() {
		 buscarDato(this.txtBuscar.getText());
		System.out.println("Buscando...");
	}
	@FXML
	private void botonNuevo(ActionEvent event) {
		//btnNuevo= new Button();
		/*btnNuevo.setOnAction(e ->{
			System.out.println("Si esta funcionando");			
	});*/
		System.out.println("Sí esta funcionando, Magucho");
	}	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	   llenarTabla();	
	   
	}

     private void buscarDato(String busca) {
		
		try {
		ObservableList <Modelpuertorico> lista= Cpuertorico.busquedaList(busca);
		this.id.setCellValueFactory(new PropertyValueFactory("id"));
		this.fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
		this.referencia.setCellValueFactory(new PropertyValueFactory("referencia"));
		this.categoria.setCellValueFactory(new PropertyValueFactory("categoria"));
		this.cantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
		this.valor_unitario.setCellValueFactory(new PropertyValueFactory<>("valor_unitario"));
		this.total.setCellValueFactory(new PropertyValueFactory("total"));
		
		this.tablaPuertorico.setItems(lista);
		}catch(Exception ex) {
			System.out.println("Error al buscar "+ex);
		}
	}
	
	
	private void llenarTabla() {
		
		try {
		ObservableList <Modelpuertorico> lista= Cpuertorico.getPuertorico();
		this.id.setCellValueFactory(new PropertyValueFactory("id"));
		this.fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
		this.referencia.setCellValueFactory(new PropertyValueFactory("referencia"));
		this.categoria.setCellValueFactory(new PropertyValueFactory("categoria"));
		this.cantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
		this.valor_unitario.setCellValueFactory(new PropertyValueFactory<>("valor_unitario"));
		this.total.setCellValueFactory(new PropertyValueFactory("total"));
		
		this.tablaPuertorico.setItems(lista);
		}catch(Exception ex) {
			System.out.println("Error no sé porque "+ex);
		}
	}
	
	
}
