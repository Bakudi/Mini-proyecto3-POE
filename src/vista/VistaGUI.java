package vista;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import controlador.OperacionMetodo;
import controlador.Controlador;
import modelo.Candidato;
import modelo.Ciudad;
import modelo.Partido;

public class VistaGUI  extends JFrame implements Vista,ActionListener{
    static List<Candidato> listaCandidatos = new ArrayList<>();
    
    public static List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }
    public static void setListaCandidatos(List<Candidato> listaCandidatos) {
        VistaGUI.listaCandidatos = listaCandidatos;
    }
    private Controlador controlador;
    
    private VistaGUI gui;
    private JLabel jLabel1;
    private JButton JButton1;
    private JButton JButton2;
    private JButton JButton3;
    private JButton JButton4;
    private JButton JButton5;
    private JButton JButton6;
    public VistaGUI() {
        initcomponents();
    }
    public void initcomponents() {
    this.controlador = controlador;
        setTitle(" GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
        JPanel panel = new JPanel();
        jLabel1 = new JLabel();
        jLabel1.setText("Por favor seleccione la opción");
        JButton1 = new JButton("agregar candidato");
        JButton1.addActionListener(this);
        JButton2 = new JButton("actualizar candidato");
        JButton2.addActionListener(this);
        JButton3 = new JButton("eliminar candidato");
        JButton3.addActionListener(this);
        JButton4= new JButton("buscar por nombre");
        JButton4.addActionListener(this);
        JButton5= new JButton("lista de candidatos");
        JButton5.addActionListener(this);
        JButton6 = new JButton("gestión de votos");
        JButton6.addActionListener(this);
       GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(jLabel1)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(JButton1)
                    .addComponent(JButton2)
                    .addComponent(JButton3)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(JButton4)
                    .addComponent(JButton5)
                    .addComponent(JButton6)
                )
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED) // Espacio entre jLabel1 y botones
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JButton1)
                    .addComponent(JButton2)
                    .addComponent(JButton3)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED) // Espacio entre botones 1-3 y botones 4-6
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JButton4)
                    .addComponent(JButton5)
                    .addComponent(JButton6)
                )
        );
        getContentPane().add(panel);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JButton1) {
            /*Agregarventana newframe = new Agregarventana(this);
           newframe.setVisible(true);
            this.dispose(); */
        }
        
        if (e.getSource() == JButton2) {
            /*Actualizar newframe = new Actualizar();
           newframe.setVisible(true);
            this.dispose(); */
        }
        if (e.getSource() == JButton3) {
            /*BORRAR  borrarGUI = new BORRAR();
            borrarGUI.setVisible(true);
            this.dispose();*/
        } 
        if (e.getSource() == JButton4) {
            /*BUSCAR  buscarGUI = new BUSCAR();
            buscarGUI.setVisible(true);
            this.dispose(); */
        } 
        if (e.getSource() == JButton5) {
            /*LISTAR  listarGUI = new LISTAR();
            listarGUI.setVisible(true);
            this.dispose(); */
        }
        if (e.getSource() == JButton6) {
            /*AgregarVotos newframe = new AgregarVotos(this); // Pasa la referencia de GUI
            newframe.setVisible(true);
            this.dispose(); */
        }  
    }
public Candidato obtenerCandidatoGanador() {
        // Ordenar la lista de candidatos por cantidad de votos en orden descendente
        List<Candidato> candidatosOrdenados = listaCandidatos.stream()
                .sorted(Comparator.comparingInt(Candidato::getVotos).reversed())
                .collect(Collectors.toList());
        // Devolver el primer candidato de la lista (el que tiene más votos)
        return candidatosOrdenados.isEmpty() ? null : candidatosOrdenados.get(0);
    }
    public String obtenerPropuestaCandidatoGanador() {
        Candidato candidatoGanador = obtenerCandidatoGanador();
        return (candidatoGanador != null) ? candidatoGanador.getPromesas() : "No hay candidato ganador";
    }
    public Partido obtenerPartidoConMasCandidatos() {
        // Usar un mapa para contar la cantidad de candidatos por partido
        Map<Partido, Long> conteoPorPartido = listaCandidatos.stream()
                .collect(Collectors.groupingBy(Candidato::getPartidoc, Collectors.counting()));
        // Encontrar el partido con más candidatos
        return conteoPorPartido.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    public List<Ciudad> obtenerTop3CiudadesMenosCandidatos() {
        // Usar un mapa para contar la cantidad de candidatos por ciudad
        Map<Ciudad, Long> conteoPorCiudad = listaCandidatos.stream()
                .collect(Collectors.groupingBy(Candidato::getOrigen, Collectors.counting()));
        // Ordenar el mapa por cantidad de candidatos en orden ascendente
        List<Ciudad> ciudadesOrdenadas = conteoPorCiudad.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        // Tomar las primeras 3 ciudades
        return ciudadesOrdenadas.size() > 2 ? ciudadesOrdenadas.subList(0, 3) : ciudadesOrdenadas;
    }
    
    public List<Candidato> getCandidatos() {
        return listaCandidatos;
    }
    public void agregarCandidato(Candidato candidato) {
        listaCandidatos.add(candidato);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VistaGUI gui = new VistaGUI();
                gui.setVisible(true);
            }
        });
    }
    @Override
    public void mostrarMensaje(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarMensaje'");
    }
    @Override
    public void mostrarResultados(String resultados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarResultados'");
    }
    @Override
    public void iniciar(Controlador controlador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciar'");
    }
}