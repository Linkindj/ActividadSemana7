package com.semana6.actividad.repositorio;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.semana6.actividad.models.UsuarioModel;

@Repository
public interface RepositorioUsuario extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByCedula(Integer cedula);
    
}
