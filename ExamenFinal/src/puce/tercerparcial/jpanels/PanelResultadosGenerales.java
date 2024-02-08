package puce.tercerparcial.jpanels;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import puce.tercerparcial.clases.Candidato;

import java.awt.*;
import java.util.List;

public class PanelResultadosGenerales extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;

    public PanelResultadosGenerales(List<Candidato> candidatos) {
    	setClosable(true);
        setTitle("RESULTADOS GENERALES");
        setBounds(100, 100, 547, 465);
        getContentPane().setLayout(null);

        // Crear la tabla
        JTable table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"CANDIDATO", "VOTOS TOTALES"});
        table.setModel(model);

        // Llenar la tabla con los datos de los candidatos y sus votos
        for (Candidato candidato : candidatos) {
            model.addRow(new Object[]{candidato.getNombreCandidato(), candidato.getVotos()});
        }

        // Agregar la tabla a un JScrollPane y añadirlo al panel
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 511, 405);
        getContentPane().add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implementar el manejo de eventos de acción si es necesario
    }
}



