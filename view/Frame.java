package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    
    public Frame(){
        JButton cadastrarLeao = new JButton("Cadastrar Leao");
        JButton selectLeao = new JButton("Select Leao");
        JButton updateLeao = new JButton("Atualizar Leao");
        JButton deleteLeao = new JButton("Deletar Leao");
        JButton pesquisarLeao = new JButton("Pesquisar por Id Leao");

        JButton cadastrarGolfinho = new JButton("Cadastrar Golfinho");
        JButton selectGolfinho = new JButton("Select Golfinho");
        JButton updateGolfinho = new JButton("Atualizar Golfinho");
        JButton deleteGolfinho = new JButton("Deletar Golfinho");
        JButton pesquisarGolfinho = new JButton("Pesquisar por Id Golfinho");

        JButton adicionarAlimentacao = new JButton("Adicionar alimentação");
        JButton adicionarTreinamento = new JButton("Adicionar treinamento");

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(cadastrarLeao);
        pane.add(selectLeao);
        pane.add(updateLeao);
        pane.add(deleteLeao);
        pane.add(pesquisarLeao);

        pane.add(cadastrarGolfinho);
        pane.add(selectGolfinho);
        pane.add(updateGolfinho);
        pane.add(deleteGolfinho);
        pane.add(pesquisarGolfinho);

        pane.add(adicionarAlimentacao);
        pane.add(adicionarTreinamento);

        cadastrarLeao.setBounds(120,200,50,20);
        selectLeao.setBounds(120,200,100,22);
        updateLeao.setBounds(120,200,150,20);
        deleteLeao.setBounds(120,200,200,20);
        pesquisarLeao.setBounds(120,200,250,20);

        cadastrarGolfinho.setBounds(120,200,50,20);
        selectGolfinho.setBounds(120,200,100,22);
        updateGolfinho.setBounds(120,200,150,20);
        deleteGolfinho.setBounds(120,200,200,20);
        pesquisarGolfinho.setBounds(120,200,250,20);

        adicionarAlimentacao.setBounds(120,200,250,20);
        adicionarTreinamento.setBounds(120,200,250,20);

        this.setSize(220,420);
        this.setContentPane(pane);
        this.setVisible(true);
        
        cadastrarLeao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InsertLeao().setVisible(true);dispose();
            }
        });

        selectLeao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new SelectLeao().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }dispose();
            }
        });

        updateLeao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new UpdateLeao().setVisible(true);dispose();
            }
        });

        deleteLeao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DeleteLeao().setVisible(true);dispose();
            }
        });

        pesquisarLeao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new PesquisarLeao().setVisible(true);dispose();
            }
        });

        cadastrarGolfinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InsertGolfinho().setVisible(true);dispose();
            }
        });

        selectGolfinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new SelectGolfinho().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }dispose();
            }
        });

        updateGolfinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new UpdateGolfinho().setVisible(true);dispose();
            }
        });

        deleteGolfinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DeleteGolfinho().setVisible(true);dispose();
            }
        });

        pesquisarGolfinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new PesquisarGolfinho().setVisible(true);dispose();
            }
        });

        adicionarAlimentacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AdicionarAlimentacao().setVisible(true);dispose();
            }
        });

        adicionarTreinamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AdicionarTreinamento().setVisible(true);dispose();
            }
        });

    }

    public static void main(String[] args) {
        Frame exemplo = new Frame();
    }
}
