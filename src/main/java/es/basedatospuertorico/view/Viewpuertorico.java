package es.basedatospuertorico.view;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mchange.v2.cfg.PropertiesConfigSource.Parse;

import es.basedatospuertorico.controller.Controllerpuertorico;
import es.basedatospuertorico.mode.Modelpuertorico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

public class Viewpuertorico  implements Initializable{
	
	@FXML
	private DatePicker myDate;
	@FXML
	private TextField txtBuscar,txtId,txtCategoria,txtCantidad,txtValor,txtTotal;
	@FXML
	private Button btnNuevo, btnBuscar, btnEditar;
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
	
	private Alert alerta= new Alert(AlertType.INFORMATION);
	
	private ObservableList <Modelpuertorico> lista;
		
	private Controllerpuertorico Cpuertorico;
	
	public Viewpuertorico() {
		this.Cpuertorico= new Controllerpuertorico();
	}
	@SuppressWarnings("unused")
	@FXML
    private void botonEditar() {
		
		LocalDate fecha= myDate.getValue();
		String capturaFecha=fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
	    Date fechaP= Date.valueOf(capturaFecha);
		String categotia= txtCategoria.getText();
		Integer cantidad= Integer.parseInt(txtCantidad.getText());
		Double valor= Double.parseDouble(txtValor.getText());
		Double total= Double.parseDouble(txtTotal.getText());
		Integer id= Integer.parseInt(txtId.getText());
		
		  this.Cpuertorico.modificaBaseLista(fechaP, cantidad, valor, id);
		if(valor) {
			System.out.println("Este campo no existe en la base de datos puerto rico para modificar.");
			
		}else {
			System.out.println("Modificado.");
			
				
		}
		
		System.out.println("Funciona botón  <<EDITAR>>");
    }
	@FXML
	private void btnBusca(ActionEvent event) {
		this.tablaPuertorico.getItems().clear();
		String dato= this.txtBuscar.getText().trim();
		if(txtBuscar.getText().isBlank()) {	
			JOptionPane.showMessageDialog(null, "Campo vacío, por favor ingrese REFERENCIA ó CATEGORÍA del arículo que está buscando.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		buscarDato(dato);
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
		
		 lista= Cpuertorico.busquedaList(busca);
		this.id.setCellValueFactory(new PropertyValueFactory("id"));
		this.id.setStyle("-fx-alignment:CENTER");
		this.fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
		this.referencia.setCellValueFactory(new PropertyValueFactory("referencia"));
		this.categoria.setCellValueFactory(new PropertyValueFactory("categoria"));
		this.cantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
		this.valor_unitario.setCellValueFactory(new PropertyValueFactory<>("valor_unitario"));
		this.total.setCellValueFactory(new PropertyValueFactory("total"));
		
		this.tablaPuertorico.setItems(lista);
		}catch(Exception ex) {
			System.out.println("Error al buscar "+ex);
	}}
	
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
	}}
	
	@FXML
	private void getDate(ActionEvent event) {
		
		LocalDate fecha= myDate.getValue();
		String capturaFecha=fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(capturaFecha);
	}
}
