package edu.ec.bocaurnatarea;

public class Ciudad {
    private String nombre;
    private String nombreProvincia; 

    public Ciudad(String nombre, String nombreProvincia) {
        this.nombre = nombre;
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }
}


