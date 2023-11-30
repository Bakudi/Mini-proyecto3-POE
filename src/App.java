import modelo.Metodos;
import controlador.Controlador;
import vista.VistaConsola;
import vista.VistaGUI;

public class App {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        VistaConsola consola = new VistaConsola ();
        VistaGUI gui = new VistaGUI();

        Controlador controladorConsole = new Controlador(metodos, consola);
        Controlador controladorGUI = new Controlador(metodos, gui);

        consola.iniciar(controladorConsole);
        gui.iniciar(controladorGUI);

        // ... (lógica para manejar la ejecución)
    }
}
