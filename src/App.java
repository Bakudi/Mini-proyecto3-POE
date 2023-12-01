
import modelo.Metodos;
import controlador.Controlador;
import vista.Vista;
import vista.VistaConsola;
import vista.VistaGUI;
public class App {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        VistaConsola consola = new VistaConsola ();
        //VistaGUI GUI = new VistaGUI();
        Controlador controladorConsole = new Controlador(metodos, consola);
        //Controlador controladorGUI = new Controlador(metodos, GUI);
        consola.iniciar(controladorConsole);
       // GUI.iniciar(controladorGUI);
    }
}