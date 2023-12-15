package ec.pucem.parcial2;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaClientes extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel model;
    private int indiceCliente = -1;
    private FrmTres frmTres; // Agrega la referencia a FrmTres

    public ListaClientes(Dialog owner, boolean modal, FrmTres frmTres, JLabel lblCedula, JLabel lblNombre,
            JLabel lblApellido, JLabel lblTelefono, JLabel lblEmail, JLabel lblDireccion) {

        super(owner, modal);
        this.frmTres = frmTres; // Asigna la referencia a FrmTres
        setBounds(100, 100, 572, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 416, 208);
        contentPanel.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cédula", "Nombres", "Apellidos",
                "Teléfono", "Email", "Dirección" }));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();

        if (!FrmUno.getClientes().isEmpty()) {
            agregarClientes();
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarCliente(lblCedula, lblNombre, lblApellido, lblTelefono, lblEmail, lblDireccion);
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancelar");
        buttonPane.add(cancelButton);
    }

    private void agregarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>(FrmUno.getClientes());

        for (Cliente cliente : clientes) {
            Object[] fila = new Object[6];
            fila[0] = cliente.getCedula();
            fila[1] = cliente.getNombre();
            fila[2] = cliente.getApellido();
            fila[3] = cliente.getTelefono();
            fila[4] = cliente.getEmail();
            fila[5] = cliente.getDireccion();
            this.model.addRow(fila);

            JButton btnCliente = new JButton("Escoger");
            btnCliente.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    seleccionarCliente(clientes.indexOf(cliente));
                }
            });
            btnCliente.setBounds(440, 30 + (clientes.indexOf(cliente) * 18), 89, 17);
            this.contentPanel.add(btnCliente);
        }
    }

    private void seleccionarCliente(int i) {
        this.indiceCliente = i;
    }

    private void enviarCliente(JLabel lblCedula, JLabel lblNombre, JLabel lblApellido, JLabel lblTelefono,
            JLabel lblEmail, JLabel lblDireccion) {
        if (this.indiceCliente == -1) {
            JOptionPane.showMessageDialog(null, "Escoja un cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        lblCedula.setText("Cédula: " + FrmUno.getClientes().get(indiceCliente).getCedula());
        lblNombre.setText("Nombres: " + FrmUno.getClientes().get(indiceCliente).getNombre());
        lblApellido.setText("Apellidos: " + FrmUno.getClientes().get(indiceCliente).getApellido());
        lblTelefono.setText("Teléfono: " + FrmUno.getClientes().get(indiceCliente).getTelefono());
        lblEmail.setText("Email: " + FrmUno.getClientes().get(indiceCliente).getEmail());
        lblDireccion.setText("Dirección: " + FrmUno.getClientes().get(indiceCliente).getDireccion());

        // Actualiza los datos en FrmTres usando la referencia
        frmTres.actualizarDatosCliente(FrmUno.getClientes().get(indiceCliente));
        dispose();
    }
}
