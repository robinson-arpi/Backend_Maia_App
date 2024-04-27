package com.maia.maia_app.DSL.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.File;

@Controller
public class ControllerDSL {
        @XmlRootElement
        public static class Usuario {
            private String nombre;
            private int edad;
            private String genero;

            @XmlElement
            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            @XmlElement
            public int getEdad() {
                return edad;
            }

            public void setEdad(int edad) {
                this.edad = edad;
            }

            @XmlElement
            public String getGenero() {
                return genero;
            }

            public void setGenero(String genero) {
                this.genero = genero;
            }
        }

        @PostMapping("/guardar")
        public String guardarInformacion(@RequestParam String nombre, @RequestParam int edad, @RequestParam String genero) {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setEdad(edad);
            usuario.setGenero(genero);

            // Convertir el objeto Usuario a XML
            String xml = convertirObjetoAXML(usuario);

            // Guardar el XML en un archivo
            guardarXML(xml);

            return "Datos guardados correctamente como XML.";
        }

        private String convertirObjetoAXML(Usuario usuario) {
            try {
                JAXBContext context = JAXBContext.newInstance(Usuario.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                StringWriter sw = new StringWriter();
                marshaller.marshal(usuario, sw);
                return sw.toString();
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void guardarXML(String xml) {
            try {
                File file = new File("usuario.xml");
                javax.xml.bind.JAXB.marshal(xml, file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
