package model;

public interface Pesquisar <T extends Animal>{

    public T getPorId(int id) throws Exception;
    
}
