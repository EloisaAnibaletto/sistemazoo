package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisarGolfinho extends JFrame{
    public PesquisarGolfinho(){
        JLabel idPesquisa = new JLabel("Digite o id do golfinho a ser mostrado");

        JTextField textId = new JTextField(20);

        JButton pesquisar = new JButton("Pesquisar");
        JButton cancel  = new JButton("Fechar");

        Container paneDois = this.getContentPane();
        paneDois.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneDois.add(idPesquisa);
        paneDois.add(textId);

        paneDois.add(pesquisar);
        paneDois.add(cancel);

        pesquisar.setBounds(10,30,50,22);
        cancel.setBounds(10,60,50,22);

        pesquisar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonPesquisarActionPerformed(e);
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

    private void buttonPesquisarActionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(
            this, 
            "GOLFINHO",
            "PESQUISAR",
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
