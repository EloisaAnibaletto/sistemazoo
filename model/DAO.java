package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
    final static String url = "jdbc:mysql://localhost:3306/sistemazoo?useTimezone=true&serverTimezone=UTC";
    final static String user = "root";
    final static String password = "";

    public static ArrayList<Leao> selectLeao() throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rsJoin = stm.executeQuery("SELECT leao.id, leao.nome, leao.alimentacao, leao.visitantes, jaula.id as jaula_id, jaula.descricao FROM leao INNER JOIN jaula ON jaula.id = leao.jaula_id");
            ArrayList<Leao> leoes = new ArrayList<>();
            while (rsJoin.next()) {
                System.out.println(new Leao(
                    rsJoin.getInt("id"),
                    rsJoin.getString("nome"),
                    rsJoin.getInt("alimentacao"),
                    rsJoin.getInt("visitantes"),
                    new Jaula(
                        rsJoin.getInt("jaula_id"),
                        rsJoin.getString("descricao")
                    )
                ));
                
            }
            con.close();
            return leoes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static void insertLeaoPS(Jaula jaula, Leao leao) throws SQLException {

        try{
            Connection conexao = DriverManager.getConnection(url, user, password); 

            String sqlInserirPreparedStatementJaula = "INSERT INTO jaula (descricao) VALUES (?)";
            PreparedStatement preparedStatementJaula = conexao.prepareStatement(sqlInserirPreparedStatementJaula, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatementJaula.setString(1, jaula.getDescricao());
            if(preparedStatementJaula.executeUpdate() > 0){
                ResultSet rs = preparedStatementJaula.getGeneratedKeys();
                rs.next();

                String sqlInserirPreparedStatement = "INSERT INTO leao (nome,alimentacao, visitantes, jaula_id) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = conexao.prepareStatement(sqlInserirPreparedStatement, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, leao.getNome());
                preparedStatement.setInt(2, leao.getAlimentacao());
                preparedStatement.setInt(3, leao.getVisitantes());
                preparedStatement.setInt(4, rs.getInt(1));

                if(preparedStatement.executeUpdate() > 0){
                    ResultSet resultado = preparedStatement.getGeneratedKeys();

                    if(resultado.next()){
                        resultado.getInt(1);
                    }
                }
            }
                
            conexao.close(); 
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateLeaoPS( Leao leao) throws SQLException {

        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("UPDATE leao SET "
                            + " nome = ?"
                            + ", alimentacao = ?"
                            + ", visitantes = ?"
                            + " WHERE id = ?");
            pStm.setString(1, leao.getNome());
            pStm.setInt(2, leao.getAlimentacao());
            pStm.setInt(3, leao.getVisitantes());
            pStm.setInt(4, leao.getId());
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteLeaoPS(Leao leao) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("DELETE FROM leao WHERE id = ?");
            pStm.setInt(1, leao.getId());
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Golfinho> selectGolfinho() throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rsJoin = stm.executeQuery("SELECT golfinho.id, golfinho.nome, golfinho.treinamento, jaula.id as jaula_id, jaula.descricao FROM golfinho INNER JOIN jaula ON jaula.id = golfinho.jaula_id");
            ArrayList<Golfinho> golfinho = new ArrayList<>();
            while (rsJoin.next()) {
                System.out.println(new Golfinho(
                    rsJoin.getInt("id"),
                    rsJoin.getString("nome"),
                    rsJoin.getInt("treinamento"),
                    new Jaula(
                        rsJoin.getInt("jaula_id"),
                        rsJoin.getString("descricao")
                    )
                ));
                
            }
            con.close();
            return golfinho;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static void insertGolfinhoPS(Jaula jaula, Golfinho golfinho) throws SQLException {

        try{
            Connection conexao = DriverManager.getConnection(url, user, password); 
            String sqlInserirPreparedStatementJaula = "INSERT INTO jaula (descricao) VALUES (?)";
            PreparedStatement preparedStatementJaula = conexao.prepareStatement(sqlInserirPreparedStatementJaula, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatementJaula.setString(1, jaula.getDescricao());
            if(preparedStatementJaula.executeUpdate() > 0){
                ResultSet rs = preparedStatementJaula.getGeneratedKeys();
                rs.next();

                String sqlInserirPreparedStatement = "INSERT INTO golfinho (nome, treinamento, jaula_id) VALUES (?,?,?)";
                PreparedStatement preparedStatement = conexao.prepareStatement(sqlInserirPreparedStatement, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, golfinho.getNome());
                preparedStatement.setInt(2, golfinho.getTreinamento());
                preparedStatement.setInt(3, rs.getInt(1));

                if(preparedStatement.executeUpdate() > 0){
                    ResultSet resultado = preparedStatement.getGeneratedKeys();

                    if(resultado.next()){
                        resultado.getInt(1);
                    }
                }
            }
                
            conexao.close(); 
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateGolfinhoPS(Golfinho golfinho) throws SQLException {

        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("UPDATE golfinho SET "
                            + " nome = ?"
                            + ", treinamento = ?"
                            + " WHERE id = ?");
            pStm.setString(1, golfinho.getNome());
            pStm.setInt(2, golfinho.getTreinamento());
            pStm.setInt(3, golfinho.getId());
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteGolfinhoPS(Golfinho golfinho) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("DELETE FROM golfinho WHERE id = ?");
            pStm.setInt(1, golfinho.getId());
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
