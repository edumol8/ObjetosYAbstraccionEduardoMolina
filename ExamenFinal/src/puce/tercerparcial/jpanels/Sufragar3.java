package puce.tercerparcial.jpanels;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Sufragar3 extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private JTextField txtSufragar;


	public Sufragar3() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		
		JButton btnSALIR = new JButton("SALIR");
		btnSALIR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSALIR.setBounds(0, 241, 434, 29);
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnSALIR);
		
		JLabel lblGracias = new JLabel("¡Gracias por su voto!");
		lblGracias.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGracias.setBounds(115, 76, 249, 70);
		getContentPane().add(lblGracias);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
