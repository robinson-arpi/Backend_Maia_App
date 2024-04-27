package com.maia.maia_app.DSL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Preferencia {
    int id;
    private String tipoPreferencia;
    private String valorPreferencia;
}
