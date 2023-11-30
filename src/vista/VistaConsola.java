package vista;

import controlador.Controlador;

import java.util.Scanner;

public class VistaConsola implements Vista {
    private Controlador controlador;

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarResultados(String resultados) {
        System.out.println(resultados);
    }

    @Override
    public void iniciar(Controlador controlador) {
        this.controlador = controlador;

        // ... (código para la vista de consola)
    }
}