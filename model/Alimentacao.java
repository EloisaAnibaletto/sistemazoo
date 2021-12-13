package model;

import java.sql.Date;
import java.util.Objects;

 //////CRIANDO CLASSE//////
public class Alimentacao {

    private int id;
    private Date data;
    private String detalhes;
    private Leao leao;

 //////CRIANDO CONSTRUTOR//////
    public Alimentacao(
        int id, 
        Date data, 
        String detalhes, 
        Leao leao
        ) {
        this.id = id;
        this.data = data;
        this.detalhes = detalhes;
        this.leao = leao;
    }

    public Alimentacao(
        Date data, 
        String detalhes, 
        Leao leao
        ) {
        this.data = data;
        this.detalhes = detalhes;
        this.leao = leao;
    }

    public Alimentacao(String data2, String detalhes2, int leaoid) {
    }

////METODOS////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Leao getLeao() {
        return leao;
    }

    public void setLeao(Leao leao) {
        this.leao = leao;
    }

//////COMPARAÇÃO DE VALORES/////

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alimentacao)) {
            return false;
        }
        Alimentacao alimentacao = (Alimentacao) o;
        return Objects.equals(id, alimentacao.id);
    }

//////EXIBINDO DADOS DA ALIMENTACAO////////
    @Override
    public String toString() {
        return "\nID =" + getId()
            + "\nData =" + getData()
            + "\nDetalhes =" + getDetalhes();
    }
    
}
