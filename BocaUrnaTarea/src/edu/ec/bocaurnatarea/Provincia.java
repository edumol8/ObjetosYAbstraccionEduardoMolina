package edu.ec.bocaurnatarea;

import java.util.List;


public class Provincia {
    private String nombreDeProvincia;
    private List<Ciudad> ciudades;

    public Provincia(String nombreDeProvincia, List<Ciudad> ciudades) {
        this.nombreDeProvincia = nombreDeProvincia;
        this.ciudades = ciudades;
    }

    public String getNombreDeProvincia() {
        return nombreDeProvincia;
    }

    public void setNombreDeProvincia(String nombreDeProvincia) {
        this.nombreDeProvincia = nombreDeProvincia;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}



