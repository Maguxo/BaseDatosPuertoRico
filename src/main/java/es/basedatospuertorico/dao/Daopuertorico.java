package es.basedatospuertorico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.basedatospuertorico.mode.Modelpuertorico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Daopuertorico {

	private Connection con;
	
	public Daopuertorico(Connection con) {
		this.con= con;
	}
	
	
	public ObservableList<Modelpuertorico> busquedaLista(String buscar){
		
		ObservableList<Modelpuertorico> busqueda= FXCollections.observableArrayList();
		try {
			
			final PreparedStatement sta= con.prepareStatement(""
					+ "SELECT id, fecha, referencia, categoria, cantidad, valor_unitario, total FROM puertorico"
					+ "WHERE categoria ="+buscar);
			try(sta){
				
				sta.execute();
				final ResultSet rs= sta.getResultSet();
				try(rs){
					while(rs.next()){
						busqueda.add(new Modelpuertorico(
								rs.getInt("id"),
								rs.getDate("fecha"),
								rs.getString("referencia"),
								rs.getString("categoria"),
								rs.getInt("cantidad"),
								rs.getDouble("valor_unitario"),
								rs.getDouble("total")));
					}}}}catch(SQLException e) {
			             throw new RuntimeException (e);
		}
		return busqueda;
	}
	public ObservableList<Modelpuertorico> listaPuertorico(){
		
		ObservableList<Modelpuertorico> basedato= FXCollections.observableArrayList();
		try {
			final PreparedStatement sta= con.prepareStatement(""
					+ "SELECT id, fecha, referencia, categoria, cantidad, valor_unitario, total FROM puertorico");
			try(sta){
				sta.execute();
				final ResultSet rs= sta.getResultSet();
				
				try(rs){
					while(rs.next()) {
						basedato.add(new Modelpuertorico(
								rs.getInt("id"),
								rs.getDate("fecha"),
								rs.getString("referencia"),
								rs.getString("categoria"),
								rs.getInt("cantidad"),
								rs.getDouble("valor_unitario"),
								rs.getDouble("total")));
		 }}}}catch(SQLException e) {

				System.out.println("Dao con problemas "+e);
			throw new RuntimeException (e);
		}
	     return basedato;	
	}
}
