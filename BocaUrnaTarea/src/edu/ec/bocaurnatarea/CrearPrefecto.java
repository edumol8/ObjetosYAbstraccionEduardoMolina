package edu.ec.bocaurnatarea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CrearPrefecto extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;

	private Prefecto prefecto;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnCancelar;

	private List<Prefecto> prefectos;
	private int idPrefecto;

	private List<Provincia> listaDeProvincias;
	private JComboBox<Provincia> comboBox;

	public CrearPrefecto(List<Prefecto> prefectos, List<Provincia> listaDeProvincias) {
		this.prefectos = prefectos;// ?????

		this.listaDeProvincias = listaDeProvincias;
		idPrefecto = 1;
		this.prefectos = prefectos;
		setTitle("CANDIDATOS A PREFECTO");
		setBounds(100, 100, 443, 385);
		getContentPane().setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
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
				agregarPrefecto();
			}
		});
		txtNombre.setBounds(100, 41, 231, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(30, 72, 117, 25);
		getContentPane().add(btnNuevo);

		btnGuardar = new JButton("Agregar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(157, 72, 117, 25);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(286, 72, 117, 25);
		getContentPane().add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 416, 224);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Provincia" }));
		scrollPane.setViewportView(table);

		JLabel lblNombres_1 = new JLabel("Provincia");
		lblNombres_1.setBounds(33, 14, 70, 15);
		getContentPane().add(lblNombres_1);

		// JComboBox<Provincia> comboBox = new JComboBox<>();
		comboBox = new JComboBox<>();

		DefaultComboBoxModel<Provincia> comboBoxModel = new DefaultComboBoxModel<>(
				listaDeProvincias.toArray(new Provincia[0]));
		comboBox.setModel(comboBoxModel);

		// Utilizamos un ListCellRenderer para mostrar correctamente el nombre de la
		// provincia en el JComboBox
		comboBox.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				if (value instanceof Provincia) {
					Provincia provincia = (Provincia) value;
					value = provincia.getNombreDeProvincia();
				}
				return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			}
		});

		comboBox.setBounds(100, 5, 231, 24);
		getContentPane().add(comboBox);

		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}

	private void nuevo() {
		prefecto = new Prefecto();
		txtNombre.setText(prefecto.getNombre());
	}

	private void agregarPrefecto() {
		prefecto = new Prefecto();
		prefecto.setId(idPrefecto);
		prefecto.setNombre(txtNombre.getText());

		// Asociar el prefecto con la provincia seleccionada en el JComboBox
		prefecto.setProvincia((Provincia) comboBox.getSelectedItem());

		prefectos.add(prefecto);
		agregarFila();
		txtNombre.setText("");
		idPrefecto++;
	}

	private void agregarFila() {
		model.setRowCount(0);
		for (Prefecto prefecto : prefectos) {
			Object[] fila = new Object[2];
			fila[0] = prefecto.getNombre();
			fila[1] = prefecto.getProvincia().getNombreDeProvincia();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			nuevo();
		} else if (e.getSource() == btnGuardar) {
			agregarPrefecto();
		} else if (e.getSource() == btnCancelar) {
			dispose();
		}
	}

	public List<Prefecto> getPrefectos() {
		return prefectos;
	}

	public void setPrefectos(List<Prefecto> prefectos) {
		this.prefectos = prefectos;
	}
}
