package edu.ec.bocaurnatarea;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BocaDeUrna extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;

    private List<Prefecto> prefectos;
    private JPanel panel;
    private JButton btnCancelar;
    private JLabel lblNombres;
    private JComboBox<Provincia> comboBox;
    private JComboBox<Ciudad> comboBoxCiudad;
    private JLabel lblCiudad;
    
    private Provincia provinciaSeleccionada;
    private Ciudad ciudadSeleccionada;
    
    
    
    //chat gpt para las ciudades
    private Map<String, Integer> votosPorCiudad = new HashMap<>();
    private Map<String, Integer> votosPorProvincia = new HashMap<>();
    private Map<Prefecto, Integer> votosPorPrefecto = new HashMap<>();
    private Map<Prefecto, Map<String, Integer>> votosPorCiudadYPrefecto = new HashMap<>();//???
    private JLabel lblInicialmenteDebesEscoger;
    private JLabel lblInicialmenteDebesEscoger_2;



    
    

    public BocaDeUrna(List<Prefecto> prefectos, List<Provincia> listaDeProvincias) {
        this.prefectos = prefectos;
        
        //???
        for (Prefecto prefecto : prefectos) {
            votosPorCiudadYPrefecto.put(prefecto, new HashMap<>());
        }//??
       
        setTitle("BOCA DE URNA - REGISTRO");
        setBounds(100, 100, 600, 427);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 172, 566, 167);
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

        panel = new JPanel();
        panel.setBounds(12, 76, 566, 84);
        getContentPane().add(panel);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(226, 350, 117, 25);
        getContentPane().add(btnCancelar);

        lblNombres = new JLabel("Provincia:");
        lblNombres.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        lblNombres.setBounds(12, 21, 70, 15);
        getContentPane().add(lblNombres);

        comboBox = new JComboBox<>(listaDeProvincias.toArray(new Provincia[0]));
        comboBox.setBounds(79, 12, 231, 24);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCiudades();
                provinciaSeleccionada = (Provincia) comboBox.getSelectedItem();
                cargarCandidatos(); // Añadir esta línea para actualizar los candidatos al cambiar la provincia
            }
        });

        getContentPane().add(comboBox);

        lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        lblCiudad.setBounds(12, 48, 70, 15);
        getContentPane().add(lblCiudad);

        comboBoxCiudad = new JComboBox<>();
        comboBoxCiudad.setBounds(79, 43, 231, 24);
        getContentPane().add(comboBoxCiudad);
        
     // Utilizamos un ListCellRenderer para mostrar correctamente el nombre de la ciudad en el JComboBox
        comboBoxCiudad.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Ciudad) {
                    Ciudad ciudad = (Ciudad) value;
                    value = ciudad.getNombre();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });


        model = (DefaultTableModel) table.getModel();
        cargarCandidatos();
        llenarTabla();
        
        
     // Utilizamos un ListCellRenderer para mostrar correctamente el nombre de la provincia en el JComboBox
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Provincia) {
                    Provincia provincia = (Provincia) value;
                    value = provincia.getNombreDeProvincia();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        
        lblInicialmenteDebesEscoger = new JLabel("provincia para votar.");
        lblInicialmenteDebesEscoger.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        lblInicialmenteDebesEscoger.setBounds(334, 38, 221, 25);
        getContentPane().add(lblInicialmenteDebesEscoger);
        
        lblInicialmenteDebesEscoger_2 = new JLabel("Inicialmente, debes escoger de nuevo la ");
        lblInicialmenteDebesEscoger_2.setFont(new Font("Dubai Medium", Font.PLAIN, 11));
        lblInicialmenteDebesEscoger_2.setBounds(334, 12, 221, 33);
        getContentPane().add(lblInicialmenteDebesEscoger_2);
    }
    


  

    private void cargarCandidatos() {
        int x = 0;
        Provincia provinciaSeleccionada = (Provincia) comboBox.getSelectedItem();

        panel.removeAll(); // Limpiar el panel antes de agregar nuevos botones

        // Crear botones para cada prefecto
        for (Prefecto prefecto : prefectos) {
            if (prefecto.getProvincia().equals(provinciaSeleccionada)) {
                JButton btnPrefecto = new JButton(prefecto.getNombre());
                btnPrefecto.setBounds(x * 155, 0, 150, 80);
                btnPrefecto.addActionListener(this);
                panel.setLayout(null);
                panel.add(btnPrefecto);
                x++;
            }
        }
    }

 

    private void llenarTabla() {
        model.setRowCount(0);

        // Obtener la lista de ciudades de la provincia seleccionada
        Provincia provinciaSeleccionada = (Provincia) comboBox.getSelectedItem();
        List<Ciudad> ciudades = provinciaSeleccionada.getCiudades();

        // Encabezado para la tabla
        Object[] header = new Object[2 + ciudades.size()]; // Nombre, Votos Totales Provincia y Votos por Ciudad
        header[0] = "Nombre";
        header[1] = "Votos Totales Provincia";

        // Añadir columnas para cada ciudad
        for (int i = 0; i < ciudades.size(); i++) {
            header[i + 2] = "Votos en " + ciudades.get(i).getNombre();
        }

        model.setColumnIdentifiers(header);

        // Llenar la tabla con datos
        for (Prefecto prefecto : prefectos) {
            if (prefecto.getProvincia().equals(provinciaSeleccionada)) {
                Object[] fila = new Object[2 + ciudades.size()];
                fila[0] = prefecto.getNombre();

                // Obtener votos totales por provincia de ese prefecto
                int votosTotalesPrefecto = 0;

                // Obtener votos por cada ciudad
                for (int i = 0; i < ciudades.size(); i++) {
                    String keyCiudad = ciudades.get(i).getNombre();
                    int votosEnCiudad = votosPorCiudadYPrefecto.get(prefecto).getOrDefault(keyCiudad, 0);
                    votosTotalesPrefecto += votosEnCiudad;
                    fila[i + 2] = votosEnCiudad;
                }

                fila[1] = votosTotalesPrefecto;  // Actualizar la columna "Votos Totales Provincia"

                model.addRow(fila);
            }
        }
    }



    private void actualizarCiudades() {
        Provincia provinciaSeleccionada = (Provincia) comboBox.getSelectedItem();
        List<Ciudad> ciudades = provinciaSeleccionada.getCiudades();

        DefaultComboBoxModel<Ciudad> comboBoxModel = new DefaultComboBoxModel<>(ciudades.toArray(new Ciudad[0]));
        comboBoxCiudad.setModel(comboBoxModel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            // En lugar de cerrar, solo ocultamos el JInternalFrame
            setVisible(false);
        } else {
            String nombrePrefecto = e.getActionCommand();
            for (Prefecto prefecto : prefectos) {
                if (prefecto.getNombre().equals(nombrePrefecto)) {
                    // Incrementar votos en general
                    prefecto.setVotos(prefecto.getVotos() + 1);

                    // Incrementar votos por ciudad
                    Ciudad ciudadSeleccionada = (Ciudad) comboBoxCiudad.getSelectedItem();
                    String keyCiudad = ciudadSeleccionada.getNombre();
                    votosPorCiudadYPrefecto.computeIfAbsent(prefecto, k -> new HashMap<>())
                            .put(keyCiudad, votosPorCiudadYPrefecto.get(prefecto).getOrDefault(keyCiudad, 0) + 1);

                    // Incrementar votos por provincia
                    String keyProvincia = provinciaSeleccionada.getNombreDeProvincia();
                    votosPorProvincia.put(keyProvincia, votosPorProvincia.getOrDefault(keyProvincia, 0) + 1);

                    // Incrementar votos totales por prefecto
                    votosPorPrefecto.put(prefecto, votosPorPrefecto.getOrDefault(prefecto, 0) + 1);

                    llenarTabla();
                    break;  // Salir del bucle después de encontrar al prefecto
                }
            }
        }
    }


    public List<Prefecto> getPrefectos() {
        return prefectos;
    }

    public void setPrefectos(List<Prefecto> prefectos) {
        this.prefectos = prefectos;
    }
    
    
    
    //???
    public Map<Prefecto, Map<String, Integer>> getVotosPorCiudadYPrefecto() {
        return votosPorCiudadYPrefecto;
    }

}

