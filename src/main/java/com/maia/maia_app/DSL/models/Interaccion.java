package com.maia.maia_app.DSL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Interaccion {
    private int id;
    private String tipo;
    private Date timeStamp;
    private String valor;
    private String origen;
}
