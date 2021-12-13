package model;

import java.util.Objects;

 //////CRIANDO CLASSE//////
public abstract class Animal {

    private int id;
    private String nome;

//////CRIANDO CONSTRUTOR//////
    protected Animal() {

    }
    protected Animal(
        int id,
        String nome
    ) {
        this.id = id;
        this.nome = nome;
    }

    protected Animal(
        String nome
    ) {
        this.nome = nome;
    }

    protected Animal(
        int id
    ) {
        this.id = id;
    }

////METODOS////
    protected void setId(int id) {
        this.id = id;
    }

    protected int getId() {
        return this.id;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getNome() {
        return this.nome;
    }

//////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

//////EXIBINDO DADOS DO ANIMAL////////
    @Override
    public String toString() {
        return "\nID =" + getId() 
            + "\nNome =" + getNome();
    }

}
