package com.example.registroActividades.services;

//
//Decompiled by Procyon v0.5.36
//


import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registroActividades.dto.ActividadesDTO;
import com.example.registroActividades.models.ActividadModel;
import com.example.registroActividades.models.EmpleadoModel;
import com.example.registroActividades.repository.ActividadRepository;
import com.example.registroActividades.repository.EmpleadoRepository;


@Service
public class ActividadService
{
 @Autowired
 ActividadRepository actividadRepository;
 
 @Autowired
 EmpleadoRepository empleadoRepository;
 
 public ArrayList<ActividadModel> getUser() {
     return (ArrayList<ActividadModel>)this.actividadRepository.findAll();
 }
 
	public ActividadModel saveUser(ActividadesDTO act) {
		ActividadModel actividadModel = new ActividadModel();
		try {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
					Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			LocalDate date = LocalDate.parse(act.getFecha_ejecucion(), inputFormatter);
			String formattedDate = outputFormatter.format(date);
			actividadModel.setDescripcion(act.getDescripcion());
			Optional<EmpleadoModel> em = this.getEmpleadoById(Integer.parseInt(act.getEmpleado()));
			actividadModel.setEmpleado(em.get());
			if (act.getEstado().equals("PENDIENTE")) {
				actividadModel.setEstado(1);
			} else {
				actividadModel.setEstado(0);
			}
    	 actividadModel.setFecha_ejecucion(formattedDate);
    	 actividadModel.setId(0);
    	 actividadModel.setTitulo_actividad(act.getTitulo_actividad());
         return (ActividadModel)this.actividadRepository.save(actividadModel);
     }
     catch (Exception e) {
         System.out.println(e.getMessage());
         return actividadModel;
     }
 }
 
 public Optional<ActividadModel> getUserByDocument(final int document) {
     return (Optional<ActividadModel>)this.actividadRepository.findById(document);
 }
 
 public boolean deleteUser(final int document) {
     try {
         this.actividadRepository.deleteById(document);
         return true;
     }
     catch (Exception e) {
         return false;
     }
 }
 
 public int diasRetraso(final String fechaEjecucion) {
     final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
     final LocalDate fechaNac = LocalDate.parse(fechaEjecucion, fmt);
     final LocalDate ahora = LocalDate.now();
     final Period periodo = Period.between(fechaNac, ahora);
     System.out.printf("dias de retraso:", periodo.getDays());
     return periodo.getDays();
 }
 
 
 public int diferenciaFechas(String fechaEjecucion){
	 String fechaActual= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	    
     String[] fechaI = fechaEjecucion.split("-");
     String[] fechaF = fechaActual.split("-");
     
     Calendar cal = Calendar.getInstance();

       cal.set(Calendar.YEAR, Integer.parseInt(fechaI[0]));
       cal.set(Calendar.MONTH, Integer.parseInt(fechaI[1]));
       cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechaI[2]));
       Date firstDate = cal.getTime();

       cal.set(Calendar.YEAR, Integer.parseInt(fechaF[0]));
       cal.set(Calendar.MONTH, Integer.parseInt(fechaF[1]));
       cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechaF[2]));
       Date secondDate = cal.getTime();

       long diferencia = secondDate.getTime() - firstDate.getTime();
       int diasRetraso=(int) (diferencia/1000/60/60/24);
       System.out.println ("Diferencia en dias: " + diferencia/1000/60/60/24);
       return diasRetraso;
}
 
 public ArrayList<EmpleadoModel> getEmpleados() {
     return (ArrayList<EmpleadoModel>)this.empleadoRepository.findAll();
 }
 
 public Optional<EmpleadoModel> getEmpleadoById( int id) {
     return this.empleadoRepository.findById(id);
 }
}

