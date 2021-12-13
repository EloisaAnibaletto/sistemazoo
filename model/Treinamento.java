package model;

import java.sql.Date;
import java.util.Objects;

 //////CRIANDO CLASSE//////
public class Treinamento {

    private int id;
    private Date data;
    private String detalhes;
    private Golfinho golfinho;

//////CRIANDO CONSTRUTOR//////
    public Treinamento(
        int id, 
        Date data, 
        String detalhes, 
        Golfinho golfinho
        ) {
        this.id = id;
        this.data = data;
        this.detalhes = detalhes;
        this.golfinho = golfinho;
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

    public Golfinho getGolfinho() {
        return golfinho;
    }

    public void setGolfinho(Golfinho golfinho) {
        this.golfinho = golfinho;
    }

//////COMPARAÇÃO DE VALORES/////
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Treinamento)) {
            return false;
        }
        Treinamento treinamento = (Treinamento) o;
        return Objects.equals(id, treinamento.id);
    }

//////EXIBINDO DADOS DO TREINAMENTO////////
    @Override
    public String toString() {
        return "\nID =" + getId()
            + "\nData =" + getData()
            + "\nDetalhes =" + getDetalhes();
    }
    
}
