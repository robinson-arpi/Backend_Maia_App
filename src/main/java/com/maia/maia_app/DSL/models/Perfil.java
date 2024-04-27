package com.maia.maia_app.DSL.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {
    private int edad;
    private String genero;
    private String nivelEducativo;
    private String ocupacion;
}

