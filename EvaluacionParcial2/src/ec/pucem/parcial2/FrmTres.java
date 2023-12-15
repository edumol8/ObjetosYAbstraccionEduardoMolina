package ec.pucem.parcial2;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmTres extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    public static FrmTres instanciaTres;
    private JDesktopPane desktopPane;
    private FrmDos frmCliente;

    private JLabel lblCedulaFac;
    private JLabel lblNombreFac;
    private JLabel lblApellidosFac;
    private JLabel lblTelefonoFac;
    private JLabel lblEmailFac;
    private JLabel lblDireccionFac;

    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private JTable table_3;
    private JLabel lblTotalFac;
    private JLabel lblSubtotalFac;
    private JLabel lblIVAFac;
    private JMenuItem mntmCancelarFactura;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmTres frame = new FrmTres();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmTres() {
        setBounds(100, 100, 634, 582);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem nuevoFacturacionItem = new JMenuItem("Nuevo");
        nuevoFacturacionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	abrirDeNuevo();
            }
        });
        menuBar.add(nuevoFacturacionItem);
        
        mntmCancelarFactura = new JMenuItem("Cancelar");
        mntmCancelarFactura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				dispose();
        	}
        });
        menuBar.add(mntmCancelarFactura);
        getContentPane().setLayout(null);

        lblNombreFac = new JLabel("Nombres:");
        lblNombreFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombreFac.setBounds(10, 11, 316, 17);
        getContentPane().add(lblNombreFac);

        lblApellidosFac = new JLabel("Apellidos:");
        lblApellidosFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblApellidosFac.setBounds(10, 39, 316, 17);
        getContentPane().add(lblApellidosFac);

        lblCedulaFac = new JLabel("Cedula:");
        lblCedulaFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCedulaFac.setBounds(10, 70, 316, 17);
        getContentPane().add(lblCedulaFac);

        lblDireccionFac = new JLabel("Dirección:");
        lblDireccionFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDireccionFac.setBounds(10, 99, 316, 17);
        getContentPane().add(lblDireccionFac);

        lblTelefonoFac = new JLabel("Teléfono:");
        lblTelefonoFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTelefonoFac.setBounds(10, 127, 316, 17);
        getContentPane().add(lblTelefonoFac);

        lblEmailFac = new JLabel("Email:");
        lblEmailFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmailFac.setBounds(10, 155, 316, 17);
        getContentPane().add(lblEmailFac);

        JButton btnBuscarClientes = new JButton("Buscar Clientes");
        btnBuscarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pedirDatos();
            }
        });
        btnBuscarClientes.setBounds(411, 11, 132, 23);
        getContentPane().add(btnBuscarClientes);

        JButton btnAñadir = new JButton("Añadir producto");
        btnAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                añadirProducto();
            }
        });
        btnAñadir.setBounds(428, 109, 160, 23);
        getContentPane().add(btnAñadir);

        JButton btnQuitar = new JButton("Quitar producto");
        btnQuitar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		quitarProducto();
        	}
        });
        btnQuitar.setBounds(428, 154, 160, 23);
        getContentPane().add(btnQuitar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 207, 561, 185);
        getContentPane().add(scrollPane);

        table_3 = new JTable();
        table_3.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cod", "Detalle", "Precio", "Total" }));
        scrollPane.setViewportView(table_3);
        model = (DefaultTableModel) table_3.getModel();

        lblSubtotalFac = new JLabel("Subtotal:");
        lblSubtotalFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSubtotalFac.setBounds(456, 410, 132, 17);
        getContentPane().add(lblSubtotalFac);

        lblIVAFac = new JLabel("I.V.A:");
        lblIVAFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIVAFac.setBounds(456, 444, 132, 17);
        getContentPane().add(lblIVAFac);

        lblTotalFac = new JLabel("Total:");
        lblTotalFac.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTotalFac.setBounds(456, 482, 132, 17);
        getContentPane().add(lblTotalFac);
    }

    public static FrmTres obtenerInstancia() {
        if (instanciaTres == null) {
            instanciaTres = new FrmTres();
        }
        return instanciaTres;
    }

    public DefaultTableModel getModeloTabla() {
        return model;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    private void pedirDatos() {
        ListaClientes listaCliente = new ListaClientes(new JDialog(), true, this, lblCedulaFac, lblNombreFac,
                lblApellidosFac, lblTelefonoFac, lblEmailFac, lblDireccionFac);
        listaCliente.setVisible(true);
    }

    private void añadirProducto() {
        ListaProductos listaProductos = new ListaProductos(new JDialog(), true, this.model, this.productos,
                this.lblSubtotalFac, this.lblIVAFac, this.lblTotalFac);
        listaProductos.setVisible(true);
    }

    public void actualizarDatosCliente(Cliente cliente) {
        lblCedulaFac.setText("Cédula: " + cliente.getCedula());
        lblNombreFac.setText("Nombres: " + cliente.getNombre());
        lblApellidosFac.setText("Apellidos: " + cliente.getApellido());
        lblTelefonoFac.setText("Teléfono: " + cliente.getTelefono());
        lblEmailFac.setText("Email: " + cliente.getEmail());
        lblDireccionFac.setText("Dirección: " + cliente.getDireccion());
    }
    
    private void quitarProducto() {
		QuitarProducto eliminarProducto = new QuitarProducto(new JDialog(), true,
				this.model, this.productos,
				this.lblSubtotalFac, this.lblIVAFac,
				this.lblTotalFac);
		eliminarProducto.setVisible(true);
	}
	private void abrirDeNuevo() {
		Container menuPrincipal = this.getParent();
		this.dispose();
		FrmTres frmFacturar = new FrmTres();
		frmFacturar.setVisible(true);
		menuPrincipal.add(frmFacturar);
	}
    
}
