package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DeleteGolfinho extends JFrame{
    public DeleteGolfinho(){
        JLabel idExclusao = new JLabel("Informe o id de exclusão");

        JTextField textExclusao = new JTextField(20);

        JButton excluir = new JButton("Excluir");
        JButton cancel  = new JButton("Fechar");

        Container paneDois = this.getContentPane();
        paneDois.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneDois.add(idExclusao);
        paneDois.add(textExclusao);

        paneDois.add(excluir);
        paneDois.add(cancel);

        excluir.setBounds(10,30,50,22);
        cancel.setBounds(10,60,50,22);

        excluir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonExcluirActionPerformed(e);
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

    private void buttonExcluirActionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(
            this, 
            "GOLFINHO EXCLUIDO",
            "EXCLUIR",
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
