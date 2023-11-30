package vista;

import controlador.Controlador;

public interface Vista {
    void mostrarMensaje(String mensaje);
    void mostrarResultados(String resultados);
    void iniciar(Controlador controlador);
}