package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO {

    public void insert(Cliente cliente){

        String sql = "INSERT INTO Cliente (cpf, nome, email, senha, genero, telefone, dataNascimento)";
        sql += " VALUES(?, ?, ?, ?, ?, ?, ?)";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getCPF());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getGenero());
            statement.setString(6, cliente.getTelefone());
            statement.setDate(7, java.sql.Date.valueOf(cliente.getDataNascimento()));
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getAll() {

        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * from Cliente";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            // Convertendo resultados para a classe interna Cliente
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String genero = resultSet.getString("genero");
                String telefone = resultSet.getString("telefone");
                LocalDate dataNascimento = LocalDate.parse(resultSet.getDate("dataNascimento").toString());
                Cliente cliente = new Cliente(cpf, nome, email, senha, genero, telefone, dataNascimento);
                listaClientes.add(cliente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }

    public void delete(Cliente cliente){
        String sql = "Delete FROM Cliente where cpf = ?";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getCPF());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente cliente){
        String sql = "UPDATE Livro SET cpf = ?, nome = ?, email = ?, senha = ?";
        sql += ", genero = ?, telefone = ?, dataNascimento = ?, WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getCPF());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getGenero());
            statement.setString(6, cliente.getTelefone());
            statement.setDate(7, java.sql.Date.valueOf(cliente.getDataNascimento()));
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente get(String cpf) {
        Cliente cliente = null;
        
        String sql = "SELECT * from Cliente where cpf = ?";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            // Convertendo resultados para a classe interna Cliente
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String genero = resultSet.getString("genero");
                String telefone = resultSet.getString("telefone");
                LocalDate dataNascimento = LocalDate.parse(resultSet.getDate("dataNascimento").toString());
                cliente = new Cliente(cpf, nome, email, senha, genero, telefone, dataNascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
