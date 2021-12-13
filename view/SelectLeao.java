package view;
import javax.swing.*;
import model.DAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SelectLeao extends JFrame{
    public SelectLeao() throws Exception{
        JLabel leoes = new JLabel("Leões" + DAO.selectLeao());

        JButton cancel  = new JButton("Fechar");

        Container paneDois = this.getContentPane();
        paneDois.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneDois.add(leoes);
        paneDois.add(cancel);

        cancel.setBounds(10,60,50,22);

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonCancelActionPerformed(e);
            }
        });

        this.setSize(250,350);
        this.setContentPane(paneDois);
        this.setVisible(true);
        
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
