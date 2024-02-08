package puce.tercerparcial.jpanels;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import puce.tercerparcial.clases.Estudiante;
import puce.tercerparcial.clases.Mesa;
import javax.swing.JLabel;

public class PanelEleccionMesas extends JInternalFrame implements ActionListener {
	private List<Mesa> mesas;
	private PanelCrearMesas panelCrearMesas; 
	private List<Estudiante> estudiantes;
	private List <Estudiante> estudiantesDeMesa;

	private static final long serialVersionUID = 1L;

	

	/**
	 * Create the frame.
	 */
	public PanelEleccionMesas( List<Mesa> mesas, List<Estudiante> estudiantes) {
		setTitle("MESAS -ESCOGE UNA OPCIÓN-");
		this.mesas = mesas;
		this.estudiantes = estudiantes;
		
		setBounds(100, 100, 712, 491);
		getContentPane().setLayout(null);
		
		JPanel panelChiquito = new JPanel();
		panelChiquito.setBounds(10, 11, 676, 439);
		getContentPane().add(panelChiquito);
		panelChiquito.setLayout(null);
		
		JButton btnCrearMesas = new JButton("Crear Mesas");
		btnCrearMesas.setBounds(10, 11, 190, 29);
		panelChiquito.add(btnCrearMesas);
		btnCrearMesas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewButton_1 = new JButton("Añadir Estudiantes a Mesas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelAñadirEstMesa panelAñadirEstMesa = new PanelAñadirEstMesa(mesas, estudiantes, estudiantesDeMesa );
		        panelChiquito.add(panelAñadirEstMesa);
		        panelAñadirEstMesa.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(210, 11, 265, 29);
		panelChiquito.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSalir.setBounds(476, 11, 190, 29);
		panelChiquito.add(btnSalir);
		btnCrearMesas.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				 PanelCrearMesas panelCrearMesas = new PanelCrearMesas(mesas);
			        panelChiquito.add(panelCrearMesas);
			        panelCrearMesas.setVisible(true);
				 
				 
	            }
	        });
		
		

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
