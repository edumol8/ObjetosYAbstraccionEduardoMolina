package puce.tercerparcial.jpanels;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import puce.tercerparcial.clases.Curso;
import puce.tercerparcial.clases.Estudiante;
import puce.tercerparcial.clases.Mesa;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;



public class PanelEstudiantes extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;

	//private Prefecto prefecto;
		private Curso curso;
		private Estudiante estudiante;
		
	private JTable table;
	private DefaultTableModel model;
	
	//botones
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnCancelar;
	//botones

	
	private List<Estudiante> estudiantes;
	
	private List<Curso> cursos;
	//private int idPrefecto;

	//private List<Provincia> listaDeProvincias;
	private JComboBox<Curso> comboBox;
	private JLabel lblCedula;
	private JTextField txtCedula;

	public PanelEstudiantes(List<Curso> cursos, List<Estudiante> estudiantes) {
		this.cursos = cursos;
		this.estudiantes = estudiantes;

		//this.listaDeProvincias = listaDeProvincias;
		
	/*idPrefecto = 1;*/
		
		this.cursos = cursos;
		setTitle("ESTUDIANTES");
		setBounds(100, 100, 460, 454);
		getContentPane().setLayout(null);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(33, 43, 70, 15);
		getContentPane().add(lblNombres);

		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarEstudiante();
			}
		});
		txtNombre.setBounds(100, 41, 231, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(33, 115, 117, 25);
		getContentPane().add(btnNuevo);

		btnGuardar = new JButton("Agregar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(160, 115, 117, 25);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(289, 115, 117, 25);
		getContentPane().add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 162, 416, 224);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][][] {}, new String[] { "Nombre Estudiante", "Cédula", "Curso" }));
		scrollPane.setViewportView(table);

		JLabel lblNombres_1 = new JLabel("Curso");
		lblNombres_1.setBounds(33, 14, 70, 15);
		getContentPane().add(lblNombres_1);

		// JComboBox<Provincia> comboBox = new JComboBox<>();
		comboBox = new JComboBox<>();

		DefaultComboBoxModel<Curso> comboBoxModel = new DefaultComboBoxModel<>(
				cursos.toArray(new Curso[0]));
		comboBox.setModel(comboBoxModel);

		// Utilizamos un ListCellRenderer para mostrar correctamente el nombre de la
		// del curso en el JComboBox
		comboBox.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				if (value instanceof Curso) {
					Curso curso = (Curso) value;
					value = curso.getNombreCurso();
				}
				return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			}
		});

		comboBox.setBounds(100, 5, 231, 24);
		getContentPane().add(comboBox);
		
		lblCedula = new JLabel("Cédula:");
		lblCedula.setBounds(33, 75, 70, 15);
		getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(100, 73, 231, 19);
		getContentPane().add(txtCedula);

		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}

	private void nuevo() {
		estudiante = new Estudiante();
		txtNombre.setText("");
		txtCedula.setText("");
	}

	
	private void agregarEstudiante() {
		estudiante = new Estudiante();
		estudiante.setNombreEstudiante(txtNombre.getText());//guardar nombre
		estudiante.setCedulaEstudiante(txtCedula.getText());//guardar cedula
		estudiante.setCurso((Curso) comboBox.getSelectedItem());//guardar curso

		//asociar el curso al estudiante
	//	estudiante.setCurso ((Curso) comboBox.getSelectedItem());//estara bien??

	
		estudiantes.add(estudiante);//añadir el nuevo estudiante al array estudiantes
		agregarFila();
		txtNombre.setText("");//limpiar
		txtCedula.setText("");//limpiar
	
		
		
		
	}

	private void agregarFila() {
		model.setRowCount(0);
		for (Estudiante estudiante : estudiantes) {
			Object[] fila = new Object[3];
			fila[0] = estudiante.getNombreEstudiante();
			fila[1] = estudiante.getCedulaEstudiante();
			fila[2] = estudiante.getCurso().getNombreCurso();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			nuevo();
		} else if (e.getSource() == btnGuardar) {
			agregarEstudiante();
		} else if (e.getSource() == btnCancelar) {
			dispose();
		}
	}

	public List<Estudiante> getEstudiante() {
		return estudiantes;
	}

	
}