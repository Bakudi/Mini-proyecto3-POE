package vista;

import controlador.Controlador;
import controlador.Controlador;
import controlador.OperacionMetodo;
import modelo.Metodos;
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
        boolean condi = true;
        while(condi == true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido/a al menú de registro de candidatos\n");

            System.out.println("1. Insertar candidatos\n2. Actualizar candidato\n3. EliminarCandidato\n4. Buscar candidato por nombre\n5. Listar todos los candidatos.\n6. pasar a el menu de registro de votos.\n" + //
                    "");

            System.out.println("Digite el número de la opción a realizar: ");
            int opc = scanner.nextInt();
            switch(opc){
                case 1:
                    controlador.setOperacion(OperacionMetodo.AGREGAR_C);
                    break;
                case 2:
                    controlador.setOperacion(OperacionMetodo.ACTUALIZA_C);
                    break;
                case 3:
                    controlador.setOperacion(OperacionMetodo.BORRAR_C);
                    break;
                case 4:
                    controlador.setOperacion(OperacionMetodo.BUSCAR_NOMBRE);
                    break;
                case 5:
                    controlador.setOperacion(OperacionMetodo.LISTAR);

                    break;
                case 6:
                    condi= false;  
                    break;     
                default:
                    break;
            }
        

        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Bienvenido/a al menú de registro de votos por candidato\n");
        System.out.println("1. Insertar votos de candidatos\n");

        System.out.println("Digite la el número de la opción a realizar: ");
        int opc2 = scanner2.nextInt();
        switch(opc2){
            case 1:
                controlador.setOperacion(OperacionMetodo.ASIGNAR_V);
                System.out.println("\n\n----------Resultados de votacion-----------\n");
                controlador.setOperacion(OperacionMetodo.CONTAR_V);
                controlador.setOperacion(OperacionMetodo.MAS_PARTIDO);
                controlador.setOperacion(OperacionMetodo.TOP3); 
                break;
            default:
                break;
        }
    }
}