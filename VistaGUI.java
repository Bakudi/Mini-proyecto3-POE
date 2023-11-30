package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Controlador;

public class VistaGUI  extends JFrame implements Vista{
    private Controlador controlador;
    private JButton boton;
    private JTextField campoTexto;

    public VistaGUI() {
        // ... (configuración de la interfaz gráfica)
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void mostrarResultados(String resultados) {
        JOptionPane.showMessageDialog(this, resultados);
    }

    @Override
    public void iniciar(Controlador controlador) {
        this.controlador = controlador;

        // ... (configuración de la interfaz gráfica)
    }
}
