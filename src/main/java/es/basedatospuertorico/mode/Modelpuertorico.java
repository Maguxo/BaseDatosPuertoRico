package es.basedatospuertorico.mode;

import java.sql.Blob;
import java.sql.Date;

public class Modelpuertorico {
	private int id;
	private Date fecha;
	private String referencia;
	private String categoria;
	private int cantidad;
	private Double valor_unitario;
	private Double total;
	private Blob image;
	
	public Modelpuertorico(int id, Date fecha, String referencia,
			String categoria, int cantidad, Double valor_unitario, Double total) {	
		
		this.id=id;
		this.fecha=fecha;
		this.referencia=referencia;
		this.categoria= categoria;
		this.cantidad= cantidad;
		this.valor_unitario= valor_unitario;
		this.total= total;
	}
	public Modelpuertorico( Date fecha, String referencia,
			String categoria, int cantidad, Double valor_unitario, Double total) {	
		
		this.fecha=fecha;
		this.referencia=referencia;
		this.categoria= categoria;
		this.cantidad= cantidad;
		this.valor_unitario= valor_unitario;
		this.total= total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
}
