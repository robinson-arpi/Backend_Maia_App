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
public class Contexto{
    private String ubicacion;
    private String tiempo;
    private List<CondicionFisica> condicion;

}
