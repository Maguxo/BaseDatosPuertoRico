package es.basedatospuertorico.controller;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import es.basedatospuertorico.dao.Daopuertorico;
import es.basedatospuertorico.mode.Modelpuertorico;
import es.basedatospuertorico.factory.Factory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class Controllerpuertorico {
	
	private Daopuertorico puertoricoDao;
	
	public Controllerpuertorico() {
		this.puertoricoDao= new Daopuertorico(new Factory().recuperaConexion());
	}
	/*
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		id.setStyle("-fx-alignment: CENTER-LEFT");
		fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		fecha.setStyle("-fx-alignment: CENTER-LEFT");
		referencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
		referencia.setStyle("-fx-alignment: CENTER-LEFT");
		categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		categoria.setStyle("-fx-alignment: CENTER-LEFT");
		cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		cantidad.setStyle("-fx-alignment: CENTER-LEFT");
		valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		valor.setStyle("-fx-alignment: CENTER-LEFT");
		total.setCellValueFactory(new PropertyValueFactory<>("total"));
		valor.setStyle("-fx-alignment: CENTER-LEFT");
	}*/
	
	public int modificaBaseLista(Date fecha, int cantidad, Double valor, int id) {
		
		return puertoricoDao.modificarLista(fecha, cantidad, valor, id);
	}

	public ObservableList<Modelpuertorico> busquedaList(String busca){
		
		return puertoricoDao.busquedaLista(busca);
	}
	
	public ObservableList<Modelpuertorico> getPuertorico(){
		
		return puertoricoDao.listaPuertorico();
	}
/*	@FXML
	private void botonNuevo(ActionEvent event) {
		//btnNuevo= new Button();
		/*btnNuevo.setOnAction(e ->{
			System.out.println("Si esta funcionando");
	});
		System.out.println("Si esta funcionando, Magucho");	}*/
}