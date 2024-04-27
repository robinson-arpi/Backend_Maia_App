package com.maia.maia_app.DSL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Necesidad {
    private int id;
    private String tipoNecesidad;
    private String detalleNecesidad;

}