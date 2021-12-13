package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InsertLeao extends JFrame{
    public InsertLeao(){
        JLabel descricaoJaula = new JLabel("Descrição da Jaula");
        JLabel nomeLeao = new JLabel("Nome do Leão");
        JLabel alimentacaoLeao = new JLabel("Alimentacao do Leão");
        JLabel quanVisLeao = new JLabel("Quantidade de visitante Leão");

        JTextField textDescricao = new JTextField(20);
        JTextField textNomeLeao = new JTextField(20);
        JTextField textAlimentacao = new JTextField(20);
        JTextField textQuantVis = new JTextField(20);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancel  = new JButton("Fechar");

        Container paneDois = this.getContentPane();
        paneDois.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneDois.add(descricaoJaula);
        paneDois.add(textDescricao);

        paneDois.add(nomeLeao);
        paneDois.add(textNomeLeao);

        paneDois.add(alimentacaoLeao);
        paneDois.add(textAlimentacao);

        paneDois.add(quanVisLeao);
        paneDois.add(textQuantVis);

        paneDois.add(cadastrar);
        paneDois.add(cancel);
        cadastrar.setBounds(10,30,50,22);
        cancel.setBounds(10,60,50,22);

        cadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonCadastrarActionPerformed(e);
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

    private void buttonCadastrarActionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(
            this, 
            "LEÃO CADASTRADO",
            "CADASTRAR",
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
