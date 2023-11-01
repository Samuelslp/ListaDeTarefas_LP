package com.listadetarefa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeTarefasGUI {
    private static DefaultListModel<Tarefa> model = new DefaultListModel<>();
    private static JList<Tarefa> tarefasList = new JList<>(model);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Lista de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextField inputField = new JTextField(20);
        JButton adicionarButton = new JButton("Adicionar");
        JButton removerButton = new JButton("Remover");
        JButton listarButton = new JButton("Listar");

        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeTarefa = inputField.getText();
                if (!nomeTarefa.isEmpty()) {
                    Tarefa tarefa = new Tarefa(nomeTarefa);
                    model.addElement(tarefa);
                    inputField.setText("");
                }
            }
        });

        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tarefasList.getSelectedIndex();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                }
            }
        });

        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Listar tarefas no formato desejado
                StringBuilder tarefas = new StringBuilder("Tarefas:\n");
                for (int i = 0; i < model.size(); i++) {
                    tarefas.append(model.getElementAt(i)).append("\n");
                }
                JOptionPane.showMessageDialog(null, tarefas.toString());
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(inputField);
        panel.add(adicionarButton);
        panel.add(removerButton);
        panel.add(listarButton);

        frame.add(new JScrollPane(tarefasList), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
