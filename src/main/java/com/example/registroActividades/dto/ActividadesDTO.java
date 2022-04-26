package com.example.registroActividades.dto;

public class ActividadesDTO {
	
	private String id;
	private String titulo_actividad;
	private String descripcion;
	private String fecha_ejecucion;
	private String empleado;
	private int dias_retraso;
	private String estado;


	public String getTitulo_actividad() {
		return titulo_actividad;
	}

	public void setTitulo_actividad(String titulo_actividad) {
		this.titulo_actividad = titulo_actividad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_ejecucion() {
		return fecha_ejecucion;
	}

	public void setFecha_ejecucion(String fecha_ejecucion) {
		this.fecha_ejecucion = fecha_ejecucion;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public int getDias_retraso() {
		return dias_retraso;
	}

	public void setDias_retraso(int dias_retraso) {
		this.dias_retraso = dias_retraso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
