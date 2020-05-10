package sample;

/**
 * Clase Persona, por simplicidad sólo hemos puesto un atributo, el nombre
 * y su constructor, get, set y toString.
 * 
 * @author JJBH
 */
public class Persona {
    private String nombre ;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    // public String toString() { return "Nombre de la persona: " + this.nombre ;
    public String toString() { return this.nombre; }
       
}