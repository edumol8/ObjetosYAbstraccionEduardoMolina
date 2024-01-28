package edu.ec.bocaurnatarea;

/*
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class ReporteGeneral extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel model;

	private List<Prefecto> prefectos;
	private JButton btnCancelar;
	private JLabel lblNombres;
	private JComboBox comboBox;

	public ReporteGeneral(List<Prefecto> prefectos) {
		this.prefectos = prefectos;
		setTitle("REPORTE GENERAL POR PROVINCIA");
		setBounds(100, 100, 600, 309);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 48, 566, 167);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Votos" }));
		scrollPane.setViewportView(table);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(234, 227, 117, 25);
		getContentPane().add(btnCancelar);
		
		lblNombres = new JLabel("Provincia");
		lblNombres.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
		lblNombres.setBounds(12, 21, 70, 15);
		getContentPane().add(lblNombres);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Azuay", "Cañar", "Pichincha", "Manabí", "Guayas"}));
		comboBox.setBounds(79, 12, 231, 24);
		getContentPane().add(comboBox);

		model = (DefaultTableModel) table.getModel();
		llenarTabla();
	}

	
	private void llenarTabla() {
		model.setRowCount(0);
		for (Prefecto prefecto : prefectos) {
			Object[] fila = new Object[2];
			fila[0] = prefecto.getNombre();
			fila[1] = prefecto.getVotos();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			dispose();
		}
		for (Prefecto prefecto : prefectos) {
			if (prefecto.getNombre() == e.getActionCommand()) {
				prefecto.setVotos(prefecto.getVotos() + 1);
				llenarTabla();
			}
		}
	}

	public List<Prefecto> getPrefectos() {
		return prefectos;
	}

	public void setPrefectos(List<Prefecto> prefectos) {
		this.prefectos = prefectos;
	}
}*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

public class ReporteGeneral extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;

    private List<Prefecto> prefectos;
    private Map<Prefecto, Map<String, Integer>> votosPorCiudadYPrefecto;
    private JButton btnCancelar;
    private JLabel lblProvincia;
    private JComboBox<Provincia> comboBoxProvincia;
    private BocaDeUrna bocaDeUrna;

    public ReporteGeneral(List<Prefecto> prefectos, List<Provincia> listaDeProvincias, BocaDeUrna bocaDeUrna) {
        this.prefectos = prefectos;
        this.bocaDeUrna = bocaDeUrna;
        this.votosPorCiudadYPrefecto = bocaDeUrna.getVotosPorCiudadYPrefecto();
        setTitle("REPORTE GENERAL POR PROVINCIA");
        setBounds(100, 100, 600, 309);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 78, 566, 137);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(model.getValueAt(table.getSelectedRow(), 0));
            }
        });
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Nombre", "Votos"}));
        scrollPane.setViewportView(table);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(234, 227, 117, 25);
        getContentPane().add(btnCancelar);

        lblProvincia = new JLabel("Provincia:");
        lblProvincia.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        lblProvincia.setBounds(12, 21, 70, 15);
        getContentPane().add(lblProvincia);

        comboBoxProvincia = new JComboBox<>(listaDeProvincias.toArray(new Provincia[0]));
        comboBoxProvincia.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        comboBoxProvincia.setBounds(79, 12, 231, 24);
        comboBoxProvincia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCiudades();
                llenarTabla();
            }
        });
        getContentPane().add(comboBoxProvincia);

        comboBoxProvincia.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Provincia) {
                    Provincia provincia = (Provincia) value;
                    value = provincia.getNombreDeProvincia();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        model = (DefaultTableModel) table.getModel();
        llenarTabla();
    }

    private void llenarTabla() {
        model.setRowCount(0);

        Provincia provinciaSeleccionada = (Provincia) comboBoxProvincia.getSelectedItem();

        // Encabezado para la tabla
        Object[] header = new Object[2 + provinciaSeleccionada.getCiudades().size()];
        header[0] = "Nombre";
        header[1] = "Votos";

        List<Ciudad> ciudades = provinciaSeleccionada.getCiudades();
        for (int i = 0; i < ciudades.size(); i++) {
            header[i + 2] = "Votos en " + ciudades.get(i).getNombre();
        }

        model.setColumnIdentifiers(header);

        for (Prefecto prefecto : prefectos) {
            if (prefecto.getProvincia().equals(provinciaSeleccionada)) {
               // if (ciudadSeleccionada == null || ciudadSeleccionada.getNombreProvincia().equals(provinciaSeleccionada.getNombreDeProvincia())) {
                    Object[] fila = new Object[2 + ciudades.size()];
                    fila[0] = prefecto.getNombre();
                    fila[1] = prefecto.getVotos();

                    for (int i = 0; i < ciudades.size(); i++) {
                        String keyCiudad = ciudades.get(i).getNombre();
                        int votosEnCiudad = votosPorCiudadYPrefecto.get(prefecto).getOrDefault(keyCiudad, 0);
                        fila[i + 2] = votosEnCiudad;
                    }

                    model.addRow(fila);
                }
            }
        }
   // }

    private void actualizarCiudades() {
        Provincia provinciaSeleccionada = (Provincia) comboBoxProvincia.getSelectedItem();
        List<Ciudad> ciudades = provinciaSeleccionada.getCiudades();

        DefaultComboBoxModel<Ciudad> comboBoxModel = new DefaultComboBoxModel<>(ciudades.toArray(new Ciudad[0]));
      //  comboBoxCiudad.setModel(comboBoxModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            dispose();
        }
    }
}

