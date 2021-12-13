package model;

import java.util.Objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 //////CRIANDO CLASSE//////
public class Golfinho extends Animal{
    
    private int treinamento;
    private Jaula jaula;
    private final static String url = "jdbc:mysql://localhost:3306/sistemazoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
 //////CRIANDO CONSTRUTOR//////
    public Golfinho(
        int id, 
        String nome,
        int treinamento,
        Jaula jaula
    ) {
        super(id, nome);
        this.treinamento = treinamento;
        this.jaula= jaula;
    }

    public Golfinho(){

    }
    
    public Golfinho( 
        String nome,
        int treinamento,
        Jaula jaula
    ) {
        super( nome);
        this.treinamento = treinamento;
        this.jaula= jaula;
    }

    public Golfinho(
        int id, 
        String nome,
        int treinamento
    ) {
        super(id, nome);
        this.treinamento = treinamento;
    }

    public Golfinho(
        String nome,
        int treinamento
    ) {
        super( nome);
        this.treinamento = treinamento;
    }

////METODOS////
    public int getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(int treinamento) {
        this.treinamento = treinamento;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }
//////PROCURANDO GOLFINHO POR ID //////////
    public Golfinho getPorId(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM golfinho WHERE id = " + id);
            ResultSet rsJoin = stm.executeQuery("SELECT golfinho.id, golfinho.nome, golfinho.treinamento, jaula.id as jaula_id, jaula.descricao FROM golfingo INNER JOIN jaula ON jaula.id = golfinho.jaula_id WHERE golfinho.id = " + id);
            
            if (rs.next()) {
                return new Golfinho(
                    rsJoin.getInt("id"),
                    rsJoin.getString("nome"),
                    rsJoin.getInt("treinamento"),
                    new Jaula(
                        rsJoin.getInt("jaula_id"),
                        rsJoin.getString("descricao")
                    )
                );
            }
            con.close();
            throw new Exception("ID não encontrado");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }
//////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Golfinho)) {
            return false;
        }
        Golfinho golfinho = (Golfinho) o;
        return Objects.equals(this.getId(), golfinho.getId());
    }
//////EXIBINDO DADOS DO GOLFINHO////////
    @Override
    public String toString() {
        return super.toString() 
            +"\nTreinamento =" + getTreinamento()
            + "\nJaula =" + getJaula();
    }
}
