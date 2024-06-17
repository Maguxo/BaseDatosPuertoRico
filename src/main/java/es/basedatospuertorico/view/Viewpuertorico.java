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
	@FXML
	LocalDate fecham;
	
	public Viewpuertorico() {
		this.Cpuertorico= new Controllerpuertorico();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	   llenarTabla();	
	}
	@SuppressWarnings("unused")
	@FXML
    private void botonEditar() {
	  
		if((this.myDate==null) || (txtCantidad.getText().isBlank()) || (txtValor.getText().isBlank()) 
				|| (txtId.getText().isBlank())) {	
			JOptionPane.showMessageDialog(null, "Campo vacíos, por favor ingrese el Id, Cantidad y Valor que desea modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			
			 this.fecham= myDate.getValue();
				//String capturaFecha=fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			    Date fechamm= Date.valueOf(this.fecham.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				Integer cantidadm= Integer.parseInt(txtCantidad.getText().trim());
				Double valorm= Double.parseDouble(txtValor.getText().trim());
				Integer idm= Integer.parseInt(txtId.getText().trim());
				//Double totalm= Double.parseDouble(txtTotal.getText().trim());
				String categotiam= txtCategoria.getText().trim();
				
			System.out.println("provando valores "+fecham+" "+cantidadm+" "+valorm);
			try {
				this.Cpuertorico.modificaBaseLista(fechamm, cantidadm, valorm, idm);
				this.tablaPuertorico.getItems().clear();
				 llenarTabla();
			}catch(Exception ex) {
				System.out.println("Hay un problema "+ ex);
			}  
			System.out.println("Funciona botón  <<EDITAR>>");		
	}txtId.clear();
	 myDate.getEditor().clear();
	 txtCategoria.clear();
	 txtCantidad.clear();
	 txtValor.clear();
	 txtTotal.clear();}
	@FXML
	private void btnBusca(ActionEvent event) {
		this.tablaPuertorico.getItems().clear();
		String dato= this.txtBuscar.getText().trim();
		if(txtBuscar.getText().isBlank()) {	
			JOptionPane.showMessageDialog(null, "Campo vacío, por favor ingrese REFERENCIA ó CATEGORÍA del arículo que está buscando.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		buscarDato(dato);
		txtBuscar.clear();
	}	
	@FXML
	private void botonNuevo(ActionEvent event) {

		System.out.println("Sí esta funcionando, Magucho");
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
