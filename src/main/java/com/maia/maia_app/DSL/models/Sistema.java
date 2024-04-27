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
public class Sistema {
    private String estado;
    private String rendimiento;
    private List<Dispositivo> dispositivos;
}
