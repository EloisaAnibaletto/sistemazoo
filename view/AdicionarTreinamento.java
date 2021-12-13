package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarTreinamento extends JFrame{
    public AdicionarTreinamento(){
        JLabel data = new JLabel("Informe a data da alimentação");
        JLabel detalhe = new JLabel("Detalhe da alimentação");
        JLabel id = new JLabel("id do Golfinho");

        JTextField textData = new JTextField(20);
        JTextField textDetalhe = new JTextField(20);
        JTextField textId = new JTextField(20);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancel  = new JButton("Fechar");

        Container paneDois = this.getContentPane();
        paneDois.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneDois.add(data);
        paneDois.add(textData);

        paneDois.add(detalhe);
        paneDois.add(textDetalhe);

        paneDois.add(id);
        paneDois.add(textId);

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
