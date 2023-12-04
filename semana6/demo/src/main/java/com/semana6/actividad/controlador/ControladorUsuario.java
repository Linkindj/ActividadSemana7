package com.semana6.actividad.controlador;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semana6.actividad.models.UsuarioModel;
import com.semana6.actividad.servicio.ServicioUsuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
    @Autowired
    ServicioUsuario servicioUsuario;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuario(){
        return servicioUsuario.obtenerUsuario();
    }

    @PostMapping()
    public UsuarioModel guardarUsuarioModel(@RequestBody UsuarioModel usuario){
        return this.servicioUsuario.guardarUsuarioModel(usuario);
    }

    @GetMapping( path = "/{id}")
        public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id")Long id){
            return this.servicioUsuario.obtenerPorId(id);
        }

    @GetMapping("/consulta")
    public ArrayList<UsuarioModel> obtenerPorCedula(@RequestParam("cedula")Integer cedula){
        return servicioUsuario.obtenerPorCedula(cedula);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok= this.servicioUsuario.eliminarUsuario(id);
            if(ok)
                {
                return "Se eliminó el usuario " + id;
            }
            else
                {
               return "No se eliminó el usuario " + id;
            }
        }
}