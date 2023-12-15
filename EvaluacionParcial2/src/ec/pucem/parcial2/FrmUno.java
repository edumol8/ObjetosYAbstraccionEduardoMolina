package ec.pucem.parcial2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


//CLIENTES

public class FrmUno extends JInternalFrame {

    private static FrmUno instancia;
	
	private JTable table_1;
	private DefaultTableModel model; 
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUno frame = new FrmUno();
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
	public FrmUno() {
		setBounds(100, 100, 613, 509);
		getContentPane().setLayout(null);
		
		JButton btnNuevoCliente = new JButton("Nuevo");
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCedula.setText(" ");
				txtNombre.setText(" ");
				txtApellidos.setText(" ");
				txtDireccion.setText(" ");
				txtTelefono.setText(" ");
				txtEmail.setText(" ");
			}
		});
		btnNuevoCliente.setBounds(48, 280, 124, 47);
		getContentPane().add(btnNuevoCliente);
		
		JButton btnGuardarCliente = new JButton("Guardar");
		btnGuardarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		btnGuardarCliente.setBounds(231, 280, 124, 47);
		getContentPane().add(btnGuardarCliente);
		
		JButton btnCancelarCliente = new JButton("Cancelar");
		btnCancelarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();
			}
		});
		btnCancelarCliente.setBounds(427, 280, 124, 47);
		getContentPane().add(btnCancelarCliente);
		
		
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(36, 80, 118, 19);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellidos.setBounds(36, 110, 118, 19);
		getContentPane().add(lblApellidos);
		
		JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCedula.setBounds(36, 140, 118, 19);
		getContentPane().add(lblCedula);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelfono.setBounds(36, 173, 118, 19);
		getContentPane().add(lblTelfono);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(36, 207, 118, 19);
		getContentPane().add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(36, 237, 118, 19);
		getContentPane().add(lblEmail);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(116, 81, 447, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(116, 111, 447, 20);
		getContentPane().add(txtApellidos);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(116, 140, 447, 20);
		getContentPane().add(txtCedula);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(116, 174, 447, 20);
		getContentPane().add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(116, 208, 447, 20);
		getContentPane().add(txtDireccion);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(116, 237, 447, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Nuevo Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(225, 33, 148, 19);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 337, 523, 131);
		getContentPane().add(scrollPane);
		
		//table_1 = new JTable();
		//scrollPane.setViewportView(table_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cédula", "Nombres", "Apellidos", "Direccion", "Telefono", "Email"
			}
		));
		scrollPane.setViewportView(table_1);
		model=(DefaultTableModel)table_1.getModel();
	
	
	}
	
	
	//metodo para controlar que no se abran dos
	
	
	public static FrmUno obtenerInstancia() {
        if (instancia == null) {
            instancia = new FrmUno();
        }
        return instancia;
    }	
	
	
	//metodo para crear el cliente

	private void crearCliente() {
		Cliente cliente = new Cliente(
				this.txtCedula.getText().toUpperCase(),
				this.txtNombre.getText().toUpperCase(),
				this.txtApellidos.getText().toUpperCase(),
				this.txtTelefono.getText().toUpperCase(),
				this.txtEmail.getText().toUpperCase(),
				this.txtDireccion.getText().toUpperCase()
				);
		clientes.add(cliente);
		agregarFila();
	}
	
	
	//metodo para agregarFila a la tabla
	private void agregarFila() {
		Object[] fila=new Object[6];
		fila[0]= clientes.get(clientes.size()-1).getCedula();
		fila[1]= clientes.get(clientes.size()-1).getNombre();
		fila[2]= clientes.get(clientes.size()-1).getApellido();
		fila[3]= clientes.get(clientes.size()-1).getTelefono();
		fila[4]= clientes.get(clientes.size()-1).getEmail();
		fila[5]= clientes.get(clientes.size()-1).getDireccion();
		this.model.addRow(fila);
	}
	
	//metodo getModelo
	public DefaultTableModel getModeloTabla() {
	    return model;
	}
	
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
}
