package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InsertGolfinho extends JFrame{
    public InsertGolfinho(){
        JLabel descricaoJaula = new JLabel("Descrição da Jaula");
        JLabel nomeGolfinho = new JLabel("Nome do Golfinho");
        JLabel treinamentoGolfinho = new JLabel("Treinamento do Golfinho");

        JTextField textDescricao = new JTextField(20);
        JTextField textNomeGolfinho = new JTextField(20);
        JTextField textTreinamento = new JTextField(20);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancel  = new JButton("Fechar");

        Container paneDois = this.getContentPane();
        paneDois.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneDois.add(descricaoJaula);
        paneDois.add(textDescricao);

        paneDois.add(nomeGolfinho);
        paneDois.add(textNomeGolfinho);

        paneDois.add(treinamentoGolfinho);
        paneDois.add(textTreinamento);

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
            "GOLFINHO CADASTRADO",
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
