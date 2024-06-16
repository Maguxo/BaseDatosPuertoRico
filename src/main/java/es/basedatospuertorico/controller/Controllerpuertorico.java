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

	public int modificaBaseLista(Date fecha, int cantidad, Double valor, int id) {
		
		return puertoricoDao.modificarLista(fecha, cantidad, valor, id);
	}

	public ObservableList<Modelpuertorico> busquedaList(String busca){
		
		return puertoricoDao.busquedaLista(busca);
	}
	
	public ObservableList<Modelpuertorico> getPuertorico(){
		
		return puertoricoDao.listaPuertorico();
	}
}