package controlador;

import javax.swing.text.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Candidato;
import modelo.Metodos;
import vista.Vista;

public class Controlador {

    ArrayList <Candidato> listaCandidatos = new ArrayList<Candidato>();

    Metodos metodos;
    Vista vista;
    OperacionMetodo operacion;

    public Controlador(Metodos metodos, Vista vista) {
        this.metodos = metodos;
        this.vista = vista;
    }

    public OperacionMetodo getOperacion() {
        return operacion;
    }

    public void setOperacion(OperacionMetodo operacion) {
        this.operacion = operacion;
        switch (operacion) {
            case AGREGAR_C:
                metodos.agregarCandidato(listaCandidatos);
                break;
            case ACTUALIZA_C:
                metodos.actualizarCandidato(listaCandidatos);
                break;
            case BORRAR_C:
                metodos.borrarCandidato(listaCandidatos);
                break;
            case BUSCAR_NOMBRE:
                metodos.buscarNombreCandidato(listaCandidatos);
                break;
            case LISTAR:
                metodos.mostrarListaCandidatos(listaCandidatos);
                break;
            case ASIGNAR_V:
                metodos.asignarVotos(listaCandidatos);
                break;
            case CONTAR_V:
                metodos.contarVotos(listaCandidatos);
                break;
            case MAS_PARTIDO:
                metodos.cadidatoPartido(listaCandidatos);
                break;
            case TOP3:
                metodos.top3Candidatos(listaCandidatos);
                break;
            }
    }

    public void manejarEvento() {
        // ... (lógica del controlador)
    }

    // ... (otras funciones del controlador)
}
