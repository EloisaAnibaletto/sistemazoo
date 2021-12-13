package model;

import java.util.Objects;

//////CRIANDO CLASSE//////
public class Jaula {
    
    private int id;
    private String descricao;
    
//////CRIANDO CONSTRUTOR////// 
    public Jaula(
        int id, 
        String descricao
    ) {
        this.id = id;
        this.descricao = descricao;
    }

    public Jaula(
        String descricao
    ) {
        this.descricao = descricao;
    }

////METODOS////
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Jaula)) {
            return false;
        }
        Jaula jaula = (Jaula) o;
        return Objects.equals(id, jaula.id);
    }
//////EXIBINDO DADOS DA JAULA////////
    @Override
    public String toString() {
            return "\nID =" + getId() 
            + "\nDescrição =" + getDescricao();
    }
}
