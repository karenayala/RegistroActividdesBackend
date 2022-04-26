package com.example.registroActividades.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registroActividades.dto.ActividadesDTO;
import com.example.registroActividades.models.ActividadModel;
import com.example.registroActividades.models.EmpleadoModel;
import com.example.registroActividades.services.ActividadService;


@RestController
@RequestMapping({ "/api/users" })
public class ActividadesController {
	

	
	    @Autowired
	    ActividadService actividadService;
	    
	    
	    @CrossOrigin(origins = { "http://localhost:4200" })
	    @GetMapping
	    public ArrayList<ActividadesDTO> getUsers() {
	    	ArrayList<ActividadesDTO> listaAct= new ArrayList<>();
	    	for (ActividadModel actividades : this.actividadService.getUser()) {
	    		String nombre=actividades.getEmpleado().getNombre()+" "+actividades.getEmpleado().getApellido();
				ActividadesDTO act= new ActividadesDTO();
				act.setId(String.valueOf(actividades.getId()));
				act.setTitulo_actividad(actividades.getTitulo_actividad());
				act.setDescripcion(actividades.getDescripcion());
				if(actividades.getEstado()==1) {
					act.setDias_retraso(this.actividadService.diferenciaFechas(actividades.getFecha_ejecucion()));
				}else {
				act.setDias_retraso(0);
					
				}
				if(actividades.getEstado()==1) {
					act.setEstado("PENDIENTE");
				}else {
					act.setEstado("FINALIZADA");
				}

				act.setFecha_ejecucion(actividades.getFecha_ejecucion());
				act.setEmpleado(nombre);
				
				listaAct.add(act);
			}
	    	
	        return (listaAct);
	    }
	    
	    @CrossOrigin(origins = { "http://localhost:4200" })
	    @PostMapping
	    public ActividadModel saveUser(@RequestBody final ActividadesDTO user) {
	        return this.actividadService.saveUser(user);
	    }
	    
	    @CrossOrigin(origins = { "http://localhost:4200" })
	    @GetMapping(path = { "/{document}" })
	    public Optional<ActividadModel> getUser(@PathVariable("document") final int document) {
	        return (Optional<ActividadModel>)this.actividadService.getUserByDocument(document);
	    }
	    
	    @CrossOrigin(origins = { "http://localhost:4200" })
	    @DeleteMapping(path = { "/{document}" })
	    public boolean deleteUser(@PathVariable("document") final int document) {
	        return this.actividadService.deleteUser(document);
	    }

	    @CrossOrigin(origins = { "http://localhost:4200" })
	    @GetMapping(path = { "/empleados" })
	    public ArrayList<EmpleadoModel> getEmpleado() {
	        return this.actividadService.getEmpleados();
	    }
	    
}
