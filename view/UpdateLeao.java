package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateLeao extends JFrame{
    public UpdateLeao(){
        JLabel id = new JLabel("Informe o id do leão a ser alteração");
        JLabel nome = new JLabel("Informe o nome novo");
        JLabel alimentacao = new JLabel("Informe a alimentação nova");
        JLabel visitante = new JLabel("Informe o numero de visitante novo");

        JTextField textId = new JTextField(20);
        JTextField textNome = new JTextField(20);
        JTextField textAlimen = new JTextField(20);
        JTextField textVisit = new JTextField(20);

        JButton atualizar = new JButton("Atualizar");
        JButton cancel  = new JButton("Fechar");

        Container paneDois = this.getContentPane();
        paneDois.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneDois.add(id);
        paneDois.add(textId);

        paneDois.add(nome);
        paneDois.add(textNome);

        paneDois.add(alimentacao);
        paneDois.add(textAlimen);

        paneDois.add(visitante);
        paneDois.add(textVisit);

        paneDois.add(atualizar);
        paneDois.add(cancel);
        atualizar.setBounds(10,30,50,22);
        cancel.setBounds(10,60,50,22);

        atualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonAtualizarActionPerformed(e);
            }
        });

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonCancelActionPerformed(e);
            }
        });

        this.setSize(250,350);
        this.setContentPane(paneDois);
        this.setVisible(true);
        
    }

    private void buttonAtualizarActionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(
            this, 
            "LEÃO ALTERADO",
            "UPDATE",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void buttonCancelActionPerformed(ActionEvent e){
        int ret = JOptionPane.showConfirmDialog(
            this, 
            "Deseja Fechar?",
            "Fechar",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if(ret == JOptionPane.OK_OPTION){
            System.exit(0);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,300);
        this.setVisible(true);

    }
}
