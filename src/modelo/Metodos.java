package modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.stream.Collectors;

public class Metodos {
    private ArrayList<Candidato> listaCandidatos;
    public Metodos() {
        listaCandidatos = new ArrayList<>();
    }
    public void agregarCandidato(ArrayList<Candidato> lista) {
            Candidato p = null;
            System.out.println("A continuacion agregue la informacion del candidato en el orden indicado");
            Scanner teclado = new Scanner(System.in);
    
            System.out.println("inserte el nombre del candidato: ");
            var nombre = teclado.next();
            System.out.println("inserte la cedula del candidato");
            var cedula = teclado.nextInt();
            Ciudad origen = null;
            while(origen == null){
                System.out.println("inserte el origen del candidato (solo ciudades del valle del cauca)");
                var nombreCiudad = teclado.next();
                origen = Ciudad.obtenerCiudad(nombreCiudad);
                if(origen == null){
                    System.out.println("ciudad invalida, intentelo de nuevo");
                }
            }
            System.out.println("¿ es el candidato de derecha? inserte true en caso de que si, y false en caso de que no");
            var derecha = teclado.nextBoolean();
    
            Partido partido = null;
            while(partido == null){
            System.out.println("inserte el partido del candidato(solo partidos validos en colombia)");
            var nombrepartido = teclado.next();
            partido = Partido.obtenerpartido(nombrepartido);
            
            if(partido == null){
                System.out.println("partido invalido, intentelo de nuevo"); }}
    
            System.out.println("inserte las ment... promesas del candidato");
            teclado.nextLine();
            var promesas = teclado.nextLine();
            var votos = 0;
            p = new Candidato(nombre,cedula,origen,derecha,partido, promesas, votos);
            lista.add(p);
        }
    public void actualizarCandidato(ArrayList<Candidato> lista) {
        Scanner teclado = new Scanner(System.in);
        if(lista.isEmpty()){
            System.out.println("no hay candidatos para editar");
            return;
        }
        
        System.out.println("seleccione el numero del candidato que desea editar");
        mostrarListaCandidatos(lista);
        var indice = teclado.nextInt();
        if(indice < 1 || indice > lista.size()){
           System.out.println("numero de candidato no valido");
           return; 
        }
        Candidato candidato = lista.get(indice-1);
        System.out.println("¿que atributo desea actualizar? (escriba la palabra)");
        String atributo = teclado.next();
        switch (atributo) {
            case "nombre":
                System.out.println("inserte el nuevo nombre");
                String nuevonombre = teclado.next();
                candidato.setNombre(nuevonombre);
                break;
            case "cedula":
                System.out.println("inserte la nuevo cedula");
                int nuevacedula = teclado.nextInt();
                candidato.setCedula(nuevacedula);
                break;
            case "ciudad":
              System.out.println("inserte la nueva ciudad de origen");
              String nuevaciudad = teclado.next();
              Ciudad ciudadenum = Ciudad.obtenerCiudad(nuevaciudad);
              if(ciudadenum != null){
                candidato.setOrigen(ciudadenum);
              }else{
                System.out.println("ciudad no valida, intentelo de nuevo");
              }
                break;
            case "derecha":
                System.out.println("inserte si el candidato es de derecha (true = si, false = no)");
                boolean nuevoderecha = teclado.nextBoolean();
                candidato.setDerecha(nuevoderecha);
                break;
            case "partido":
                System.out.println("inserte el nuevo partido");
                String nuevopartido = teclado.next();
                Partido partidoenum = Partido.obtenerpartido(nuevopartido);
                if(partidoenum != null){
                    candidato.setPartidoc(partidoenum);
                }else{
                    System.out.println("partido invalido, intentelo de nuevo");}
                break;
            case "promesas":
                System.out.println("inserte las nuevas ment... promesas del candidato");
                String nuevaspromesas = teclado.next();
                candidato.setPromesas(nuevaspromesas);
                break; 
        
            default:
            System.out.println("opcion invalida, intentelo de nuevo");
                break;
        }

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
   

        if (lista.isEmpty()) {
            System.out.println("No hay candidatos para asignar votos.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        for (Candidato candidato : lista) {
            System.out.println("Ingrese la cantidad de votos a asignar al candidato " + candidato.getNombre() + ":");
            int cantidadVotos = scanner.nextInt();

            if (cantidadVotos < 0) {
                System.out.println("La cantidad de votos no puede ser negativa. Intentelo de nuevo.");
                return;
            }

            candidato.agregarVotos(cantidadVotos);
            System.out.println("Votos asignados al candidato " + candidato.getNombre() + ".");
        }

        System.out.println("Votos asignados a todos los candidatos.");

    }
    public void contarVotos(ArrayList<Candidato> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay candidatos para contar votos.");
            return;
        }

        Candidato ganador = Collections.max(lista, Comparator.comparing(Candidato::getVotos));

        System.out.println("\nEl candidato ganador es:");
        System.out.println("Nombre: " + ganador.getNombre());
        System.out.println("Cédula: " + ganador.getCedula());
        System.out.println("Número de votos: " + ganador.getVotos());
    }
    public void cadidatoPartido(ArrayList<Candidato> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay candidatos para mostrar el partido con más candidatos.");
            return;
        }

        Map<Partido, Integer> conteoPartidos = new HashMap<>();

        for (Candidato candidato : lista) {
            conteoPartidos.merge(candidato.getPartidoc(), 1, Integer::sum);
        }

        Partido partidoConMasCandidatos = Collections.max(conteoPartidos.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("\nEl partido con más candidatos inscritos es:");
        System.out.println(partidoConMasCandidatos);
    }
    public void top3Candidatos(ArrayList<Candidato> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay candidatos para mostrar el top 3 de ciudades.");
            return;
        }

        // Contar la cantidad de candidatos por ciudad
        Map<Ciudad, Integer> conteoCiudades = new HashMap<>();
        for (Candidato candidato : lista) {
            Ciudad ciudad = candidato.getOrigen();
            conteoCiudades.put(ciudad, conteoCiudades.getOrDefault(ciudad, 0) + 1);
        }

        // Obtener el top 3 de ciudades con menos candidatos
        List<Map.Entry<Ciudad, Integer>> top3Ciudades = conteoCiudades.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .collect(Collectors.toList());

        // Mostrar el resultado
        if (top3Ciudades.isEmpty()) {
            System.out.println("No hay ciudades con candidatos.");
        } else {
            System.out.println("\nTop 3 de ciudades con menos candidatos:");
            for (Map.Entry<Ciudad, Integer> entry : top3Ciudades) {
                System.out.println(entry.getKey().name() + ": " + entry.getValue() + " candidato(s)");
            }
        }
    }

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