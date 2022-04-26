package com.example.registroActividades.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.registroActividades.models.ActividadModel;
import com.example.registroActividades.models.EmpleadoModel;


@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Integer>
{
}
