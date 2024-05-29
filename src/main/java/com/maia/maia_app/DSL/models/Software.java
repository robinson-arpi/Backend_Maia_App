package com.maia.maia_app.DSL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Software {
    private String version;
    private String configuracion;
}
