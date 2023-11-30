package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Metodos {

    private ArrayList<Candidato> listaCandidatos;

    public Metodos() {
        listaCandidatos = new ArrayList<>();
    }

    public void agregarCandidato(ArrayList<Candidato> lista) {
        // Lógica para agregar un candidato
    }

    public void actualizarCandidato(ArrayList<Candidato> lista) {
        // Lógica para actualizar un candidato
    }

    public void borrarCandidato(ArrayList<Candidato> lista) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del candidato que deseas borrar: ");

        String borrar = scanner.nextLine();
        Iterator<Candidato> iterator = lista.iterator();
        while (iterator.hasNext()){
            Candidato objeto = iterator.next();
            if (objeto.getNombre().equals(borrar)) {
                iterator.remove();
                System.out.println("El candidato " + borrar + " ha sido eliminado de la lista.");
            }else{
                System.out.println("No existe ese candidato.");
            }
        }
    }

    public void buscarNombreCandidato(ArrayList<Candidato> lista) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del candidato que desea consultar: ");
        String nomCandidato = scanner.nextLine();
        for(int i=0 ; i< lista.size(); i++){
            if(lista.get(i).getNombre() == nomCandidato){
                System.out.println("Nombre : " + lista.get(i).getNombre() + "\n");
                System.out.println("Cédula : " + lista.get(i).getCedula() + "\n");
                System.out.println("Origen : " + lista.get(i).getOrigen() + "\n");
                System.out.println("Candidato de : " + lista.get(i).isDerecha() + "\n");
                System.out.println("Partido político : " + lista.get(i).getPartidoc() + "\n");
                System.out.println("Promesas : " + lista.get(i).getPromesas() + "\n");
            }
        }    
    }

    public void listarCandidato(ArrayList<Candidato> lista) {
        System.out.println("Lista de candidatos mostrada en pantalla:\n");
        for(int i=0; i< lista.size(); i++){
            System.out.println("-----------------------------------------------------");
            System.out.println("Nombre: " + lista.get(i).nombre);
            System.out.println("Cédula: " + lista.get(i).cedula);
            System.out.println("Origen: " + lista.get(i).origen);
            System.out.println("¿Es de derecha?: " + lista.get(i).isDerecha());
            System.out.println("Partido politico: " + lista.get(i).getPartidoc());
            System.out.println("Promesas: " + lista.get(i).getPromesas());
            System.out.println("-----------------------------------------------------");
        }
    }

    public void mostrarListaCandidatos(ArrayList<Candidato> lista) {
        // Lógica para mostrar la lista de candidatos
    }

    public void asignarVotos(ArrayList<Candidato> lista) {
        // Lógica para asignar votos a los candidatos
    }

    public void contarVotos(ArrayList<Candidato> lista) {
        // Lógica para contar los votos y mostrar al ganador
    }

    public void cadidatoPartido(ArrayList<Candidato> lista) {
        // Lógica para mostrar el partido con más candidatos
    }

    public void top3Candidatos(ArrayList<Candidato> lista) {
        // Lógica para mostrar el top 3 de ciudades con menos candidatos
    }

    // Otros métodos del modelo
}