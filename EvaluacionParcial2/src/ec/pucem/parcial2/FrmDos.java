package ec.pucem.parcial2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import javax.swing.SwingConstants;

public class FrmDos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	public static FrmDos instanciaDos;
	private DefaultTableModel model; 
	private static ArrayList<Producto> productos = new ArrayList<Producto>();

	private JTable table_2;
	private JTextField txtCodigo;
	private JTextField txtDetalle;
	private JTextField txtPrecio;
	private JTextField txtCantidad;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDos frame = new FrmDos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDos() {
			setBounds(100, 100, 613, 509);
			getContentPane().setLayout(null);
			
			JButton btnNuevoCliente = new JButton("Nuevo");
			btnNuevoCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtCodigo.setText(" ");
					txtDetalle.setText(" ");
					txtPrecio.setText(" ");
					txtCantidad.setText(" ");
				}
			});
			btnNuevoCliente.setBounds(56, 220, 124, 47);
			getContentPane().add(btnNuevoCliente);
			
			JButton btnGuardarCliente = new JButton("Guardar");
			btnGuardarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearProducto();
				}
			});
			btnGuardarCliente.setBounds(239, 220, 124, 47);
			getContentPane().add(btnGuardarCliente);
			
			JButton btnCancelarCliente = new JButton("Cancelar");
			btnCancelarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	                dispose();
				}
			});
			btnCancelarCliente.setBounds(435, 220, 124, 47);
			getContentPane().add(btnCancelarCliente);
			
			
			
			JLabel lblCodigo = new JLabel("Código:");
			lblCodigo.setVerticalAlignment(SwingConstants.BOTTOM);
			lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCodigo.setBounds(36, 80, 118, 19);
			getContentPane().add(lblCodigo);
			
			JLabel lblDetalle = new JLabel("Detalle:");
			lblDetalle.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDetalle.setBounds(36, 110, 118, 19);
			getContentPane().add(lblDetalle);
			
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPrecio.setBounds(36, 140, 118, 19);
			getContentPane().add(lblPrecio);
			
			JLabel lblIVA = new JLabel("Cantidad:");
			lblIVA.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIVA.setBounds(36, 170, 118, 19);
			getContentPane().add(lblIVA);
			
			//aqui ibas los textField
			
			JLabel lblNuevoProducto = new JLabel("Nuevo Producto");
			lblNuevoProducto.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNuevoProducto.setBounds(225, 33, 168, 19);
			getContentPane().add(lblNuevoProducto);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(36, 295, 523, 131);
			getContentPane().add(scrollPane);
			
			//table_1 = new JTable();
			//scrollPane.setViewportView(table_1);
			
			table_2 = new JTable();
			table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Cod", "Detalle", "Precio", "Cantidad"
				}
			));
			scrollPane.setViewportView(table_2);
			
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(104, 80, 443, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtDetalle = new JTextField();
			txtDetalle.setColumns(10);
			txtDetalle.setBounds(104, 109, 443, 20);
			getContentPane().add(txtDetalle);
			
			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(104, 139, 443, 20);
			getContentPane().add(txtPrecio);
			
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(104, 169, 443, 20);
			getContentPane().add(txtCantidad);
			model=(DefaultTableModel)table_2.getModel();
		
		
		}
		
		
		//metodo para controlar que no se abran dos
		
		
		public static FrmDos obtenerInstancia() {
	        if (instanciaDos == null) {
	            instanciaDos = new FrmDos();
	        }
	        return instanciaDos;
	    }	
		
		
		private void crearProducto() {
			Producto producto = new Producto(
					this.txtCodigo.getText().toUpperCase(),
					this.txtDetalle.getText().toUpperCase(),
					Double.parseDouble(this.txtPrecio.getText()) ,
					Integer.parseInt(this.txtCantidad.getText()) 
					);
			productos.add(producto);
			agregarFila();
		}
		
		
		//metodo para agregarFila a la tabla
		private void agregarFila() {
			Object[] fila=new Object[5];
			fila[0]= productos.get(productos.size()-1).getCodigo();
			fila[1]= productos.get(productos.size()-1).getDetalle();
			fila[2]= productos.get(productos.size()-1).getPrecio();
			fila[3]= productos.get(productos.size()-1).getCantidad();
			fila[4]= productos.get(productos.size()-1).getTotal();
			this.model.addRow(fila);
		}
		
		public static ArrayList<Producto> getProductos(){
			return productos;
		}
		//metodo getModelo
		public DefaultTableModel getModeloTabla() {
		    return model;
		}
	}
