package puce.tercerparcial.jpanels;
import javax.swing.*;

import puce.tercerparcial.clases.Estudiante;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Sufragar1 extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldCedula;
    private SistemaDeVotacion sistemaDeVotacion;

    public Sufragar1(SistemaDeVotacion sistemaDeVotacion) {
    	setClosable(true);
        this.sistemaDeVotacion = sistemaDeVotacion;

        setTitle("INGRESE CEDULA");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JLabel lblIngreseCedula = new JLabel("Estudiante, ingrese su cédula");
        lblIngreseCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblIngreseCedula.setBounds(93, 41, 237, 22);
        getContentPane().add(lblIngreseCedula);

        textFieldCedula = new JTextField();
        textFieldCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldCedula.setBounds(93, 106, 258, 36);
        getContentPane().add(textFieldCedula);
        textFieldCedula.setColumns(10);

        JButton btnENTRAR = new JButton("ENTRAR");
        btnENTRAR.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    String cedulaIngresada = textFieldCedula.getText().trim();
        	    List<Estudiante> estudiantes = sistemaDeVotacion.getEstudiantes();
        	    Estudiante estudianteEncontrado = null;
        	    for (Estudiante estudiante : estudiantes) {
        	        if (estudiante.getCedulaEstudiante().equals(cedulaIngresada)) {
        	            estudianteEncontrado = estudiante;
        	            break;
        	        }
        	    }
        	    if (estudianteEncontrado != null) {
        	        dispose();
        	        sistemaDeVotacion.abrirSufragar2(cedulaIngresada);
        	    } else {
        	        JOptionPane.showMessageDialog(null, "ERROR, CEDULA NO ENCONTRADA", "Error", JOptionPane.ERROR_MESSAGE);
        	    }
        	}

        });
        btnENTRAR.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnENTRAR.setBounds(142, 182, 133, 23);
        getContentPane().add(btnENTRAR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
