package edu.ec.bocaurnatarea;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class MenuPrincipal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contenedor;
    private JDesktopPane desktopPane;
    private JMenuItem mntmSalir;
    private JMenuItem mntmCrearPrefectos;
    private JMenuItem mntmBocaDeUrna;

    public List<Prefecto> prefectos = new ArrayList<>();

    private JMenuItem mntmResultadosPorProvincia;

    private List<Provincia> listaDeProvincias;
    private JComboBox<Provincia> comboBoxProvincias;

    private List<Ciudad> listaDeCiudades;
    private JLabel lblNewLabel;
    private JLabel lblEleccionesProvinciales;
    private JLabel lblEduardoAntonioMolina;

    private BocaDeUrna bocaDeUrna;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuPrincipal() {
        setTitle("BOCA DE URNA ELECCIONES PROVINCIALES 2024 - PUCEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 801, 522);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(196, 255, 255));
        setJMenuBar(menuBar);

        JMenu mnSistema = new JMenu("Acciones");
        mnSistema.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        menuBar.add(mnSistema);

        mntmSalir = new JMenuItem("Salir");
        mntmSalir.addActionListener(this);
        mntmSalir.setFont(new Font("Dialog", Font.BOLD, 16));
        mnSistema.add(mntmSalir);

        JMenu mnAdministracin = new JMenu("Añadir");
        mnAdministracin.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        menuBar.add(mnAdministracin);

        mntmCrearPrefectos = new JMenuItem("Crear Prefectos");
        mntmCrearPrefectos.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        mntmCrearPrefectos.addActionListener(this);
        mnAdministracin.add(mntmCrearPrefectos);

        JMenu mnProceso = new JMenu("Votaciones");
        mnProceso.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        menuBar.add(mnProceso);

        mntmBocaDeUrna = new JMenuItem("Boca de Urna");
        mntmBocaDeUrna.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        mntmBocaDeUrna.addActionListener(this);
        mnProceso.add(mntmBocaDeUrna);

        JMenu mnReportes = new JMenu("Reportes");
        mnReportes.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        menuBar.add(mnReportes);

        mntmResultadosPorProvincia = new JMenuItem("Reporte General");
        mntmResultadosPorProvincia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReporteGeneral rg = new ReporteGeneral(prefectos, listaDeProvincias, encontrarInstanciaBocaDeUrna());
                desktopPane.add(rg);
                rg.setVisible(true);
            }
        });
        mntmResultadosPorProvincia.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        mnReportes.add(mntmResultadosPorProvincia);

        

        contenedor = new JPanel();
        contenedor.setBackground(new Color(255, 255, 255));
        contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contenedor);
        contenedor.setLayout(new CardLayout(0, 0));

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(255, 255, 255));
        contenedor.add(desktopPane, "name_35522358088801");
        desktopPane.setLayout(null);

        lblNewLabel = new JLabel("¡Bienvenido!, escoge una opción para empeza el proceso de Boca de Urna.");
        lblNewLabel.setBounds(43, 99, 702, 53);
        lblNewLabel.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 22));
        desktopPane.add(lblNewLabel);

        lblEleccionesProvinciales = new JLabel("ELECCIONES PROVINCIALES 2024");
        lblEleccionesProvinciales.setBounds(43, 35, 362, 53);
        lblEleccionesProvinciales.setForeground(new Color(0, 0, 255));
        lblEleccionesProvinciales.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 22));
        desktopPane.add(lblEleccionesProvinciales);

        lblEduardoAntonioMolina = new JLabel("EDUARDO ANTONIO MOLINA ZAMBRANO");
        lblEduardoAntonioMolina.setBounds(43, 165, 702, 53);
        lblEduardoAntonioMolina.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 22));
        desktopPane.add(lblEduardoAntonioMolina);

        listaDeProvincias = new ArrayList<>();
        listaDeProvincias.add(new Provincia("Azuay", crearCiudadesAzuay()));
        listaDeProvincias.add(new Provincia("Cañar", crearCiudadesCanar()));
        listaDeProvincias.add(new Provincia("Pichincha", crearCiudadesPichincha()));
        listaDeProvincias.add(new Provincia("Manabí", crearCiudadesManabi()));
        listaDeProvincias.add(new Provincia("Guayas", crearCiudadesGuayas()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mntmSalir) {
            dispose();
        } else if (e.getSource() == mntmCrearPrefectos) {
            CrearPrefecto crearPrefecto = new CrearPrefecto(prefectos, listaDeProvincias);
            desktopPane.add(crearPrefecto);
            crearPrefecto.setVisible(true);

            crearPrefecto.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    prefectos = crearPrefecto.getPrefectos();
                }
            });
        } else if (e.getSource() == mntmBocaDeUrna) {
            BocaDeUrna bocaUrna = encontrarInstanciaBocaDeUrna();

            if (bocaUrna == null) {
                bocaUrna = new BocaDeUrna(prefectos, listaDeProvincias);
                desktopPane.add(bocaUrna);
            }

            bocaUrna.setVisible(true);
        }
    }

    private BocaDeUrna encontrarInstanciaBocaDeUrna() {
        if (bocaDeUrna == null) {
            bocaDeUrna = new BocaDeUrna(prefectos, listaDeProvincias);
            desktopPane.add(bocaDeUrna);
        }
        return bocaDeUrna;
    }



    private List<Ciudad> crearCiudadesAzuay() {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Cuenca", "Azuay"));
        ciudades.add(new Ciudad("Azogues", "Azuay"));
        return ciudades;
    }

    private List<Ciudad> crearCiudadesCanar() {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Ciudad de Cañar", "Cañar"));
        ciudades.add(new Ciudad("Biblian", "Cañar"));
        return ciudades;
    }

    private List<Ciudad> crearCiudadesManabi() {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Portoviejo", "Manabí"));
        ciudades.add(new Ciudad("Manta", "Manabí"));
        return ciudades;
    }

    private List<Ciudad> crearCiudadesGuayas() {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Guayaquil", "Guayas"));
        ciudades.add(new Ciudad("Daule", "Guayas"));
        return ciudades;
    }

    private List<Ciudad> crearCiudadesPichincha() {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Quito", "Pichincha"));
        ciudades.add(new Ciudad("Cayambe", "Pichincha"));
        return ciudades;
    }

    public List<Provincia> getListaDeProvincias() {
        return listaDeProvincias;
    }

    public List<String> getNombresDeProvincias() {
        List<String> nombres = new ArrayList<>();
        for (Provincia provincia : listaDeProvincias) {
            nombres.add(provincia.getNombreDeProvincia());
        }
        return nombres;
    }

    public List<String> getNombresDeCiudades() {
        List<String> nombres = new ArrayList<>();
        for (Ciudad ciudades : listaDeCiudades) {
            nombres.add(ciudades.getNombre());
        }
        return nombres;
    }
}

