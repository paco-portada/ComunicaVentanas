package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Clase principal de donde arranca el programa.
 * En ella definimos dos cosntantes con los nombres de las vistas, la principal
 * y la del alta de personas.
 * @author JJBH basado en ejemplo de Carlos García.
 */
public class Main extends Application {
    
    private Stage stagePrincipal;
        
    // Nombre de la ventana de la vista
    private final String VENTANA_PRINCIPAL = "Principal.fxml" ;
    private final String VENTANA_ALTA = "AltaPersona.fxml" ;
    
    private static ArrayList <Persona> lista = new ArrayList() ;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();
    }

    
    /**
     * Cargar la ventana principal. Tenemos acceso al controlador de la vista.
     * Así podemos enviar parámetros a los métodos que definiremos en el
     * controlador. En este caso será el método setProgramaPrincipal(),
     * con este método creamos la comunicación entre el controlador y el
     * programa principal.
     */
    private void mostrarVentanaPrincipal() {
        AnchorPane panelRaiz ;
        try {
            // Recoger el grafo resultante.
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(VENTANA_PRINCIPAL));
            // Carga la jerarquía de objetos desde un documento FXML.
            panelRaiz = (AnchorPane) loader.load() ;
            
            // Añadir el panel a la escena
            Scene scene = new Scene(panelRaiz) ;
            // Establecer el título del escenario
            stagePrincipal.setTitle("Ventana Principal") ;
            // Añadir la escena al escenario
            stagePrincipal.setScene(scene) ;
            
            // Obtener el controlador asociado
            PrincipalController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            // Mostrar ventana
            stagePrincipal.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Muestra la ventana secundaria, la ventana para dar de alta.
     */
    protected void mostrarVentanaAltaPersona() {
        try {
            // Recoger el grafo resultante.
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(VENTANA_ALTA));
            // Crear un panel contenedor
            AnchorPane panel = (AnchorPane) loader.load();
            // Crear nueva ventana
            Stage ventana = new Stage() ;
            // Título de la ventana
            ventana.setTitle("Alta de una persona");
            // Especifica el propietario de esta ventana.
            ventana.initOwner(stagePrincipal);
            
            // Añadir panel a la escena
            Scene scene = new Scene(panel);
            ventana.setScene(scene);
            // Obtener el controlador asociado
            AltaPersonaController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            // Hacemos la ventana modal
            ventana.initModality(Modality.WINDOW_MODAL);
            // Mostrar la ventana
            ventana.show();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * Añadir persona a la lista.
     * @param persona
     */
    static void agregarPersona(Persona persona) {
        lista.add(persona);
    }

    /**
     * Listado por consola de las personas añadidas mediante la ventana de alta.
     */
    void listado() {
        
        Iterator<Persona> it=lista.iterator();

        while (it.hasNext()) {
            Persona t = it.next();
            System.out.println(t.toString()) ;
        }
    }

    static String obtenerPersonas() {

        Iterator<Persona> it=lista.iterator();
        StringBuilder text = new StringBuilder();

        while (it.hasNext()) {
            Persona t = it.next();
            // System.out.println(t.toString()) ;
            text.append(t + "\n");
        }
        return  text.toString();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}