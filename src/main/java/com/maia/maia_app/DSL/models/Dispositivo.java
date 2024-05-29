package com.maia.maia_app.DSL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dispositivo {
    private int id;
    private String tipoDispositivo;
    private String estado;
    private List<Interaccion> generaInteraccion;
}
