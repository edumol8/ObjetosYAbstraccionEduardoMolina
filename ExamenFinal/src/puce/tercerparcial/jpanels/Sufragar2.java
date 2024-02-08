package puce.tercerparcial.jpanels;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import puce.tercerparcial.clases.Candidato;
import puce.tercerparcial.clases.Estudiante;
import java.awt.Font;
import javax.swing.JButton;
/*
public class Sufragar2 extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private Estudiante estudiante;

    public Sufragar2(SistemaDeVotacion sistemaDeVotacion) {
    	
        this.sistemaDeVotacion = sistemaDeVotacion;

        setTitle("BIENVENIDO");
        setBounds(100, 100, 626, 389);
        getContentPane().setLayout(null);

        JLabel lblHolaEstudiante = new JLabel("HOLA, "); 
        lblHolaEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHolaEstudiante.setBounds(214, 24, 219, 30);
        getContentPane().add(lblHolaEstudiante);

        JLabel lblEscoga = new JLabel("Escoga su candidato");
        lblEscoga.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEscoga.setBounds(201, 91, 219, 30);
        getContentPane().add(lblEscoga);

        JButton btnNewButton = new JButton("ir a sufragar 3");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                sistemaDeVotacion.abrirSufragar3();
            }
        });
        btnNewButton.setBounds(235, 274, 185, 23);
        getContentPane().add(btnNewButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
*/

/*
//este es el que ya vale
public class Sufragar2 extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private Estudiante estudiante;

    public Sufragar2(SistemaDeVotacion sistemaDeVotacion, String cedulaEstudiante) {
        this.sistemaDeVotacion = sistemaDeVotacion;
        this.estudiante = buscarEstudiantePorCedula(cedulaEstudiante);

        setTitle("BIENVENIDO");
        setBounds(100, 100, 626, 389);
        getContentPane().setLayout(null);

        JLabel lblHolaEstudiante = new JLabel("HOLA, " + estudiante.getNombreEstudiante());
        lblHolaEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHolaEstudiante.setBounds(25, 11, 219, 30);
        getContentPane().add(lblHolaEstudiante);
        
        JLabel lblMesa = new JLabel("Su mesa es " + estudiante.getMesaDelEstudiante().getnombreMesa());
        lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMesa.setBounds(381, 11, 219, 30);
        getContentPane().add(lblMesa);

        JLabel lblEscoga = new JLabel("Escoga su candidato");
        lblEscoga.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEscoga.setBounds(25, 39, 219, 30);
        getContentPane().add(lblEscoga);

        JButton btnNewButton = new JButton("ir a sufragar 3");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                sistemaDeVotacion.abrirSufragar3();
            }
        });
        btnNewButton.setBounds(220, 325, 185, 23);
        getContentPane().add(btnNewButton);

    }

    private Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
        for (Estudiante estudiante : sistemaDeVotacion.getEstudiantes()) {
            if (estudiante.getCedulaEstudiante().equals(cedulaEstudiante)) {
                return estudiante;
            }
        }
        return null; // Si no se encuentra el estudiante
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }

}*/


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
/*
public class Sufragar2 extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private Estudiante estudiante;

    public Sufragar2(SistemaDeVotacion sistemaDeVotacion, String cedulaEstudiante) {
        this.sistemaDeVotacion = sistemaDeVotacion;
        this.estudiante = buscarEstudiantePorCedula(cedulaEstudiante);

        setTitle("BIENVENIDO");
        setBounds(100, 100, 626, 389);
        getContentPane().setLayout(null);

        JLabel lblHolaEstudiante = new JLabel("HOLA, " + estudiante.getNombreEstudiante());
        lblHolaEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHolaEstudiante.setBounds(25, 11, 219, 30);
        getContentPane().add(lblHolaEstudiante);

        JLabel lblMesa = new JLabel("Su mesa es " + estudiante.getMesaDelEstudiante().getnombreMesa());
        lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMesa.setBounds(381, 11, 219, 30);
        getContentPane().add(lblMesa);

        JLabel lblEscoga = new JLabel("Escoga su candidato");
        lblEscoga.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEscoga.setBounds(25, 39, 219, 30);
        getContentPane().add(lblEscoga);

        // Mostrar un botón por cada candidato
        int y = 80;
        List<JButton> botonesCandidatos = new ArrayList<>();
        for (Candidato candidato : sistemaDeVotacion.getCandidatos()) {
            JButton btnCandidato = new JButton(candidato.getNombreCandidato());
            btnCandidato.setBounds(25, y, 200, 30);
            getContentPane().add(btnCandidato);
            y += 40;

            // Agregar acción al botón para aumentar los votos del candidato
            btnCandidato.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Aumentar los votos del candidato
                    candidato.aumentarVotos();
                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(null, "¡Voto registrado para " + candidato.getNombreCandidato() + "!");
                    // Deshabilitar todos los demás botones de candidatos
                    for (JButton boton : botonesCandidatos) {
                        boton.setEnabled(false);
                    }
                }
            });

            // Agregar el botón actual a la lista de botones de candidatos
            botonesCandidatos.add(btnCandidato);
        }

        JButton btnNewButton = new JButton("ir a sufragar 3");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                sistemaDeVotacion.abrirSufragar3();
            }
        });
        btnNewButton.setBounds(220, 325, 185, 23);
        getContentPane().add(btnNewButton);
    }

    private Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
        for (Estudiante estudiante : sistemaDeVotacion.getEstudiantes()) {
            if (estudiante.getCedulaEstudiante().equals(cedulaEstudiante)) {
                return estudiante;
            }
        }
        return null; // Si no se encuentra el estudiante
    }
}*///este vale 1000%%% pero no se guardan los votos como debe ser




public class Sufragar2 extends JInternalFrame {
    
    private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private Estudiante estudiante;
    
    public Sufragar2(SistemaDeVotacion sistemaDeVotacion, String cedulaEstudiante) {
    	setClosable(true);
        this.sistemaDeVotacion = sistemaDeVotacion;
        this.estudiante = buscarEstudiantePorCedula(cedulaEstudiante);
        
        setTitle("BIENVENIDO");
        setBounds(100, 100, 626, 389);
        getContentPane().setLayout(null);
        
        JLabel lblHolaEstudiante = new JLabel("HOLA, " + estudiante.getNombreEstudiante());
        lblHolaEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHolaEstudiante.setBounds(25, 11, 219, 30);
        getContentPane().add(lblHolaEstudiante);
        
        JLabel lblMesa = new JLabel("Su mesa es " + estudiante.getMesaDelEstudiante().getnombreMesa());
        lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMesa.setBounds(381, 11, 219, 30);
        getContentPane().add(lblMesa);
        
        JLabel lblEscoga = new JLabel("Escoga su candidato");
        lblEscoga.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEscoga.setBounds(25, 39, 219, 30);
        getContentPane().add(lblEscoga);
        
        // Mostrar un botón por cada candidato
        int y = 80;
        for (Candidato candidato : sistemaDeVotacion.getCandidatos()) {
            if (!sistemaDeVotacion.estudianteYaVoto(cedulaEstudiante)) { // Verificar si el estudiante ya votó
                JButton btnCandidato = new JButton(candidato.getNombreCandidato());
                btnCandidato.setBounds(25, y, 200, 30);
                getContentPane().add(btnCandidato);
                y += 40;
                
                btnCandidato.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sistemaDeVotacion.registrarVoto(cedulaEstudiante, candidato);
                       
                        estudiante.setCandidatoVotado(candidato);//revisar

                        candidato.aumentarVotos();

                        JOptionPane.showMessageDialog(null, "¡Voto registrado para " + candidato.getNombreCandidato() + "!");
                        dispose();
                        sistemaDeVotacion.abrirSufragar3();
                    }
                });
                
               

            } else {
                JLabel lblYaVoto = new JLabel("Usted ya ha votado");
                lblYaVoto.setBounds(25, y, 200, 30);
                getContentPane().add(lblYaVoto);
            }
        }
    }
    
    private Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
        for (Estudiante estudiante : sistemaDeVotacion.getEstudiantes()) {
            if (estudiante.getCedulaEstudiante().equals(cedulaEstudiante)) {
                return estudiante;
            }
        }
        return null; // Si no se encuentra el estudiante
    }
}




