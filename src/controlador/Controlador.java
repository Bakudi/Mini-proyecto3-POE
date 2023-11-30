package controlador;

import javax.swing.text.View;

import modelo.Metodos;
import vista.Vista;

public class Controlador {
    private Metodos metodos;
    private Vista vista;

    public Controlador(Metodos metodos, Vista vista) {
        this.metodos = metodos;
        this.vista = vista;
    }

    public void manejarEvento() {
        // ... (lógica del controlador)
    }

    // ... (otras funciones del controlador)
}
