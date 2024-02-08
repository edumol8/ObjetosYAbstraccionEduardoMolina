package puce.tercerparcial.jpanels;

import java.awt.EventQueue;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import puce.tercerparcial.clases.Candidato;
import puce.tercerparcial.clases.Curso;
import puce.tercerparcial.clases.Estudiante;
import puce.tercerparcial.clases.Mesa;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SistemaDeVotacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List <Candidato> candidatos;
	private List <Curso> cursos;
	private List <Estudiante> estudiantes;
	private List<Estudiante> estudiantesMesa;
	private List <Mesa> mesas;
	//private List<Estudiante>  estudiantesDeMesa ;
	
    private Map<Estudiante, Mesa> asignacionesDeMesa;
    private Estudiante estudiante;
    
    private Map<String, Candidato> votosPorEstudiante;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaDeVotacion frame = new SistemaDeVotacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SistemaDeVotacion() {
		
		candidatos = new ArrayList<>(); //incializar antes la lista
		cursos = new ArrayList<>(); //incializar antes la lista
		estudiantes = new ArrayList<>(); //incializar antes la lista
		mesas = new ArrayList<>(); //incializar antes la lista
		estudiantesMesa = new ArrayList<>();
        asignacionesDeMesa = new HashMap<>();

        this.votosPorEstudiante = new HashMap<>();


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 697);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracion = new JMenu("ADMINISTRACIÓN");
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmMesas = new JMenuItem("Mesas");
		mntmMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//PanelEleccionMesas
				PanelEleccionMesas panelEleccionMesas = new PanelEleccionMesas(mesas, estudiantes);
		        contentPane.add(panelEleccionMesas);
		        panelEleccionMesas.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmMesas);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PanelCurso panelCurso = new PanelCurso(cursos);
			        contentPane.add(panelCurso);
			        panelCurso.setVisible(true);
			}
		});
		mnAdministracion.add(mntmCursos);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Estudiantes");
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  PanelEstudiantes panelEstudiantes = new PanelEstudiantes(cursos , estudiantes);
			        contentPane.add(panelEstudiantes);
			        panelEstudiantes.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmEstudiantes);
		
		JMenuItem mntmCandidatos = new JMenuItem("Candidatos");
		mntmCandidatos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PanelCandidatos panelCandidatos = new PanelCandidatos(candidatos);
		        contentPane.add(panelCandidatos);
		        panelCandidatos.setVisible(true);
		    }
		});
		

		mnAdministracion.add(mntmCandidatos);
		
		
		mnAdministracion.add(mntmCandidatos);
		
		JMenu mnProceso = new JMenu("PROCESO");
		menuBar.add(mnProceso);
		
		JMenuItem mntmSufragar = new JMenuItem("Sufragar");
		mntmSufragar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Sufragar1 sufragar1 = new Sufragar1(SistemaDeVotacion.this);
		        contentPane.add(sufragar1);
		        sufragar1.setVisible(true);
				
			}
		});
		mnProceso.add(mntmSufragar);
		
		
		
		JMenu mnReportes = new JMenu("REPORTES");
		menuBar.add(mnReportes);

		JMenuItem mntmPadron = new JMenuItem("Padrón Electoral");
		mntmPadron.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PanelPadronElectoral panelPadronElectoral = new PanelPadronElectoral(mesas, estudiantes, estudiantesMesa);
		        contentPane.add(panelPadronElectoral);
		        panelPadronElectoral.setVisible(true);
		    }
		});
		mnReportes.add(mntmPadron);

		JMenuItem mntmResultadosGenerales = new JMenuItem("Resultados Generales");
		mntmResultadosGenerales.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PanelResultadosGenerales resultadosGenerales = new PanelResultadosGenerales(candidatos);
		        contentPane.add(resultadosGenerales);
		        resultadosGenerales.setVisible(true);
		    }
		});
		
		JMenuItem mntmResultadosPorMesas = new JMenuItem("Resultados por Mesas");
		  mntmResultadosPorMesas.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//PanelResultadosPorMesa
	            	PanelResultadosPorMesa resultadosMesas = new PanelResultadosPorMesa(candidatos, mesas);
			        contentPane.add(resultadosMesas);
			        resultadosMesas.setVisible(true);
	            }
		});
		mnReportes.add(mntmResultadosPorMesas);
		mnReportes.add(mntmResultadosGenerales);
		
		JMenuItem mntmResultadosEnGrafico = new JMenuItem("Resultados en gráfico");
		mntmResultadosEnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panel graficos
				 PanelGraficos panelGraficos = new PanelGraficos(candidatos);
			        contentPane.add(panelGraficos);
			        panelGraficos.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosEnGrafico);

		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
	}

	
	void abrirSufragar2(String cedulaEstudiante) {
	    Sufragar2 sufragar2 = new Sufragar2(this, cedulaEstudiante);
	    sufragar2.setLocation(100, 100);
	    contentPane.add(sufragar2);
	    sufragar2.setVisible(true);
	}


void abrirSufragar3() {
    
    Sufragar3 sufragar3 = new Sufragar3();

    sufragar3.setLocation(100, 100);

    contentPane.add(sufragar3);
    sufragar3.setVisible(true);
}

public List<Estudiante> getEstudiantes() {
    return estudiantes;
}



public Mesa getMesaDeEstudiante(Estudiante estudiante) {
    return asignacionesDeMesa.get(estudiante);
}




public Mesa getMesaPorNombre(String nombreMesa) {
    for (Mesa mesa : mesas) {
        if (mesa.getnombreMesa().equals(nombreMesa)) {
            return mesa;
        }
    }
    return null; // Si no se encuentra la mesa con el nombre dado
}

public void asignarMesaAEstudiante(Estudiante estudiante, Mesa mesa) {
    asignacionesDeMesa.put(estudiante, mesa);
}


public List<Candidato> getCandidatos() {
    return candidatos;
}






//votos
public void registrarVoto(String cedulaEstudiante, Candidato candidato) {
    votosPorEstudiante.put(cedulaEstudiante, candidato);
}

public boolean estudianteYaVoto(String cedulaEstudiante) {
    return votosPorEstudiante.containsKey(cedulaEstudiante);
}

public Candidato getCandidatoVotadoPorEstudiante(String cedulaEstudiante) {
    return votosPorEstudiante.get(cedulaEstudiante);
}

}

