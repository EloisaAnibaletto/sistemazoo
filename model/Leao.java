package model;

import java.util.Objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 //////CRIANDO CLASSE//////
public class Leao extends Animal implements Pesquisar<Leao>{

    private int alimentacao;
    private int visitantes;
    private Jaula jaula;

    private final static String url = "jdbc:mysql://localhost:3306/sistemazoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

//////CRIANDO CONSTRUTOR//////
    public Leao() {
        
    }

    public Leao(
        int id, 
        String nome, 
        int alimentacao, 
        int visitantes, 
        Jaula jaula
        ) {
        super(id, nome);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
        this.jaula = jaula;
    }

    public Leao( 
        String nome, 
        int alimentacao, 
        int visitantes, 
        Jaula jaula
        ) {
        super(nome);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
        this.jaula = jaula;
    }

    public Leao( 
        int id,
        String nome, 
        int alimentacao, 
        int visitantes
        ) {
        super(id, nome);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
    }
    
    public Leao(
        String nome, 
        int alimentacao, 
        int visitantes
        ) {
        super( nome);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
    }

    public Leao(
        int id
        ) {
        super(id);
    }

////METODOS////
    public int getAlimentacao() {
        return alimentacao;
    }
    public void setAlimentacao(int alimentacao) {
        this.alimentacao = alimentacao;
    }
    public int getVisitantes() {
        return visitantes;
    }
    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }
    public Jaula getJaula() {
        return jaula;
    }
    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

//////PROCURANDO LEAO POR ID //////////
    public Leao getPorId(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rsJoin = stm.executeQuery("SELECT leao.id, leao.nome, leao.alimentacao, leao.visitantes, jaula.id as jaula_id, jaula.descricao FROM leao INNER JOIN jaula ON jaula.id = leao.jaula_id WHERE leao.id = " + id);
            if (rsJoin.next()) {
                return new Leao(
                    rsJoin.getInt("id"),
                    rsJoin.getString("nome"),
                    rsJoin.getInt("alimentacao"),
                    rsJoin.getInt("visitantes"),
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
        if (!(o instanceof Leao)) {
            return false;
        }
        Leao leao = (Leao) o;
        return Objects.equals(this.getId(), leao.getId());
    }

//////EXIBINDO DADOS DO LEAO////////
    @Override
    public String toString() {
        return super.toString() 
            +"\nAlimentação =" + getAlimentacao() 
            + "\nNome =" + getVisitantes()
            + "\nJaula =" + getJaula();
    }

    public int entrarVisitante(int visitante) {
       return visitante ++;
    }

    
}
