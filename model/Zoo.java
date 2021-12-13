package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) throws Exception {

        final String url = "jdbc:mysql://localhost:3306/sistemazoo?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";

        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Escolha a opção");
            System.out.println("1- SELECT LEÃO");
            System.out.println("2- INSERIR LEÃO");
            System.out.println("3- UPDATE LEÃO");
            System.out.println("4- DELETE LEÃO");
            System.out.println("5- BUSCAR POR ID LEÃO");
            System.out.println("6- SELECT GOLFINHO");
            System.out.println("7- INSERT GOLFINHO");
            System.out.println("8- UPDATE GOLFINHO");
            System.out.println("9- DELETE GOLFINHO");
            System.out.println("10- BUSCAR POR ID GOLFINHO");
            System.out.println("11- ADCIONAR ALIMENTAÇÃO");
            System.out.println("12- ADCIONAR TREINAMENTO");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    System.out.println("Sair! Obrigado!");
                    break;
                case 1:
                    try {
                        DAO.selectLeao();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Informe a descrição da jaula do leao");
                        String descricao = scanner.next();
                        System.out.println("Informe o nome do leao");
                        String nome = scanner.next();
                        System.out.println("Informe a alimentacao do leao");
                        int alimentacao = scanner.nextInt();
                        System.out.println("Informe aquantidade de visitante leao");
                        int visitantes = scanner.nextInt();

                        Jaula jaulaUm = new Jaula(descricao);

                        Leao leaoUm = new Leao(nome, alimentacao, visitantes, jaulaUm);
                        DAO.insertLeaoPS(jaulaUm, leaoUm);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        System.out.println("Informe o ID de alteração: ");
                        int id = scanner.nextInt();
                        ResultSet rs = stm.executeQuery("SELECT * FROM leao WHERE id = " + id);
                        if (!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Leao leao = new Leao(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("alimentacao"),
                                rs.getInt("visitantes"));
                        con.close();
                        System.out.println("nome");
                        String nome = scanner.next();
                        if (nome.length() > 0) {
                            leao.setNome(nome);
                        }
                        System.out.println("alimentacao");
                        int alimentacao = scanner.nextInt();
                        if (alimentacao != 0) {
                            leao.setAlimentacao(alimentacao);
                        }
                        System.out.println("visitante");
                        int visitantes = scanner.nextInt();
                        if (visitantes != 0) {
                            leao.setVisitantes(visitantes);
                        }
                        DAO.updateLeaoPS(leao);

                    } catch (SQLException e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Informe o ID de exclusão: ");
                        int id = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM leao WHERE id = " + id);

                        if (!rs.next()) {
                            throw new Exception("Id inválido");
                        }

                        Leao leao = new Leao(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("alimentacao"),
                                rs.getInt("visitantes"));

                        DAO.deleteLeaoPS(leao);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Digite o ID do Leao: ");
                    int id = scanner.nextInt();
                    Leao leao = new Leao().getPorId(id);
                    System.out.println(leao);
                    break;
                case 6:
                    try {
                        DAO.selectGolfinho();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Informe a descricao da jaula do golfinho");
                        String descricao = scanner.next();
                        System.out.println("Informe o nome do golfinho");
                        String nome = scanner.next();
                        System.out.println("Informe o treinamento do golfinho");
                        int treinamento = scanner.nextInt();

                        Jaula jaula = new Jaula(descricao);
                        Golfinho golfinhoUm = new Golfinho(nome, treinamento, jaula);
                        DAO.insertGolfinhoPS(jaula, golfinhoUm);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        System.out.println("Informe o ID de alteração: ");
                        int idGolfinho = scanner.nextInt();
                        ResultSet rs = stm.executeQuery("SELECT * FROM golfinho WHERE id = " + idGolfinho);
                        if (!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Golfinho golfinho = new Golfinho(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("treinamento"));
                        con.close();
                        System.out.println("nome");
                        String nome = scanner.next();
                        if (nome.length() > 0) {
                            golfinho.setNome(nome);
                        }
                        System.out.println("treinamento");
                        int treinamento = scanner.nextInt();
                        if (treinamento != 0) {
                            golfinho.setTreinamento(treinamento);
                        }
                        DAO.updateGolfinhoPS(golfinho);

                    } catch (SQLException e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        System.out.println("Informe o ID de exclusão: ");
                        int idGolfinho = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM golfinho WHERE id = " + idGolfinho);

                        if (!rs.next()) {
                            throw new Exception("Id inválido");
                        }

                        Golfinho golfinho = new Golfinho(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("treinamento"));

                        DAO.deleteGolfinhoPS(golfinho);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 10:
                    System.out.println("Digite o ID do Golfinho: ");
                    int idGolfinho = scanner.nextInt();
                    Golfinho golfinho = new Golfinho().getPorId(idGolfinho);
                    System.out.println(golfinho);
                    break;

                case 11:
                    try {
                        System.out.println("Informe o id do Leao");
                        int leaoId = scanner.nextInt();
                        System.out.println("Informe a data da alimentacao");
                        String datas = scanner.next();
                        System.out.println("Informe o detalhe da alimentacao");
                        String detalhes = scanner.next();

                        Connection conexao = DriverManager.getConnection(url, user, password);
                        Statement statement = conexao.createStatement();
                        boolean sql = statement.execute("INSERT INTO alimentacao (leao_id, data, detalhes) VALUES ('"
                                + leaoId + "', '" + datas + "', '" + detalhes + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        conexao.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                case 12:
                    try {
                        System.out.println("Informe o id do Golfinho");
                        int golfinhoId = scanner.nextInt();
                        System.out.println("Informe a data do treinamento");
                        String datas = scanner.next();
                        System.out.println("Informe o detalhe do treinamento");
                        String detalhes = scanner.next();

                        Connection conexao = DriverManager.getConnection(url, user, password);
                        Statement statement = conexao.createStatement();
                        boolean sql = statement.execute("INSERT INTO treinamento (golfinho_id, data, detalhes) VALUES ('"
                                + golfinhoId + "', '" + datas + "', '" + detalhes + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        conexao.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}
