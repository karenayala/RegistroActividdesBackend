package com.example.registroActividades.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actividad")
public class ActividadModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String titulo_actividad;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private String fecha_ejecucion;
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private EmpleadoModel empleado;
	
	@Column(nullable = false)
	private int estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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



	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public EmpleadoModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}

}
