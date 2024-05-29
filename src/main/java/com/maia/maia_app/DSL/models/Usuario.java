package com.maia.maia_app.DSL.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id;
    private String nombre;
    private String fechaRegistro;
    private Perfil perfil;
    private List<Necesidad> necesidades;
    private List<Preferencia> preferencias;
    private List<Dispositivo> usaDispositivos;
    private Habilidad habilidad;

    public void agregarNecesidad(Necesidad necesidad) {
        this.necesidades.add(necesidad);
    }
}
