package com.semana6.actividad.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semana6.actividad.models.UsuarioModel;
import com.semana6.actividad.repositorio.RepositorioUsuario;

@Service
public class ServicioUsuario {
    @Autowired
    RepositorioUsuario repositorioUsuario;

    public ArrayList<UsuarioModel> obtenerUsuario(){
        return (ArrayList<UsuarioModel>)  repositorioUsuario.findAll();
    }

    public UsuarioModel guardarUsuarioModel(UsuarioModel usuario){
        return repositorioUsuario.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return repositorioUsuario.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorCedula(Integer cedula){
        return repositorioUsuario.findByCedula(cedula);
    }

    public boolean eliminarUsuario(Long id){
        try
        {
            repositorioUsuario.deleteById(id);
            return true;
        }
        catch(Exception err)
        {
            return false;
        }
    }
}   
