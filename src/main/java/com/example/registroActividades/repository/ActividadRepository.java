package com.example.registroActividades.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.registroActividades.dto.ActividadesDTO;
import com.example.registroActividades.models.ActividadModel;


@Repository
public interface ActividadRepository extends CrudRepository<ActividadModel, Integer>
{

	ActividadesDTO save(ActividadesDTO act);
}
