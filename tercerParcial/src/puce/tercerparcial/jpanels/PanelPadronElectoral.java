package puce.tercerparcial.jpanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import puce.tercerparcial.clases.Estudiante;
import puce.tercerparcial.clases.Mesa;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelPadronElectoral extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;
    private List<Mesa> mesas;
    private List<Estudiante> estudiantes;
    private List<Estudiante> estudiantesDeMesa;

    public PanelPadronElectoral(List<Mesa> mesas, List<Estudiante> estudiantes, List<Estudiante> estudiantesDeMesa) {
        this.mesas = mesas;
        this.estudiantes = estudiantes;
        this.estudiantesDeMesa = estudiantesDeMesa;

        setTitle("PADRÓN ELECTORAL");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        // Configurar la tabla
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 560, 300);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Estudiante", "Mesa", "Cédula", "Curso" }));
        scrollPane.setViewportView(table);
        
        JLabel lblPadronGeneral = new JLabel("PADRÓN GENERAL");
        lblPadronGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPadronGeneral.setBounds(10, 11, 176, 22);
        getContentPane().add(lblPadronGeneral);
        
        JButton btnNewButton = new JButton("salir");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(481, 11, 89, 23);
        getContentPane().add(btnNewButton);
        model = (DefaultTableModel) table.getModel();

        // Cierra el PanelPadronElectoral cuando se cierra el PanelAñadirEstMesa
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                // Puedes realizar acciones de limpieza o cierre aquí
                System.out.println("PanelPadronElectoral cerrado");
            }
        });

        // Cargar datos en la tabla
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        model.setRowCount(0);

        Set<String> combinacionesUnicas = new HashSet<>();

        for (Mesa mesa : mesas) {
            for (Estudiante estudiante : mesa.getEstudiantesDeMesa()) {
                String combinacion = estudiante.getNombreEstudiante() + mesa.getnombreMesa();
                if (combinacionesUnicas.add(combinacion)) {
                    agregarFila(estudiante.getNombreEstudiante(), mesa.getnombreMesa(), estudiante.getCedulaEstudiante(), estudiante.getCurso().getNombreCurso());
                }
            }
        }
    }


    private void agregarFila(String nombreEstudiante, String nombreMesa, String cedulaEstudiante, String curso) {
        model.addRow(new Object[]{nombreEstudiante, nombreMesa, cedulaEstudiante, curso});
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementa el manejo de eventos de acción si es necesario
    }
}
