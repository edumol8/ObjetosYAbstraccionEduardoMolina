package ec.pucem.parcial2;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;



public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//MENUBAR BOTONES PRINCIPALES
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 818, 97);
		contentPane.add(menuBar);
		
		
		
		
		//ARCHIVO-> SALIR
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/parcial/dos/file_icon_dos.png")));
		mnNewMenu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit( getDefaultCloseOperation() );;
			}
		});
		mnNewMenu.add(mntmSalir);
		// FIN ARCHIVO-> SALIR

		
		
		//CLIENTES -> NUEVOS CLIENTES
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/parcial/dos/people_icon.png")));
		mnClientes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		menuBar.add(mnClientes);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nuevos Clientes");
		
		//action listener nuevos clientes
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        FrmUno frmUno = FrmUno.obtenerInstancia();
		        if (!frmUno.isVisible()) {
		            frmUno.setVisible(true);
		            contentPane.add(frmUno);
		            try {
		                frmUno.setSelected(true);
		            } catch (java.beans.PropertyVetoException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});
		//fin action listener nuevos clientes
		
		//metodo add para añadir boton
		mnClientes.add(mntmNewMenuItem_1);
		//FIN CLIENTES -> NUEVOS CLIENTES

		
		//PRODUCTOS -> NUEVO PRODUCTO
		JMenu mnProductos = new JMenu("Producutos");
		mnProductos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/parcial/dos/producto_icon.png")));
		mnProductos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		menuBar.add(mnProductos);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Nuevo Producuto");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			        FrmDos frmDos = FrmDos.obtenerInstancia();
			        if (!frmDos.isVisible()) {
			        	frmDos.setVisible(true);
			            contentPane.add(frmDos);
			            try {
			            	frmDos.setSelected(true);
			            } catch (java.beans.PropertyVetoException ex) {
			                ex.printStackTrace();
			            }
			        }
			    }
			});	
			
		//metodo para agregar boton de nuevo producto
		mnProductos.add(mntmNewMenuItem_2);
		//FIN PRODUCTOS -> NUEVO PRODUCTO

		
		
		
		//FACTURAS -> NUEVA FACTURA
		JMenu mnFacturas = new JMenu("Facturas");
		mnFacturas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/parcial/dos/facturas_icon.png")));
		mnFacturas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		menuBar.add(mnFacturas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Facturar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
			        FrmTres frmTres = FrmTres.obtenerInstancia();
			        if (!frmTres.isVisible()) {
			        	frmTres.setVisible(true);
			            contentPane.add(frmTres);
			            try {
			            	frmTres.setSelected(true);
			            } catch (java.beans.PropertyVetoException ex) {
			                ex.printStackTrace();
			            }
			        }
			    }
			});
			
		
		mnFacturas.add(mntmNewMenuItem);
		//FIN FACTURAS -> NUEVA FACTURA

		
		
	}//FIN MENU PRINCIPAL
	
	
		
	
}//FIN CLASE



