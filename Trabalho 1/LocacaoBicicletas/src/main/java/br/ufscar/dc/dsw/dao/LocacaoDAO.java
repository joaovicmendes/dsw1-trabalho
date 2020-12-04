package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Locacao;

public class LocacaoDAO extends GenericDAO {

    public List<Locacao> getAll() {

        List<Locacao> listaLocacao = new ArrayList<>();

        String sql = "SELECT * from Locacao";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Convertendo resultados para a classe interna Locacao
            while (resultSet.next()) {
                String cnpj = resultSet.getString("cnpjLocadora");
                String cpf = resultSet.getString("cpfCliente");
                Timestamp t = resultSet.getTimestamp("dataReserva");
                System.out.println(t);
                Date data = new Date(t.getTime());

                // Recuperando cliente e locadora a partir da chave estrangeira
                ClienteDAO clienteDAO = new ClienteDAO();
                LocadoraDAO locadoraDAO = new LocadoraDAO();

                Cliente c = clienteDAO.get(cpf);
                Locadora l = locadoraDAO.get(cnpj);

                Locacao locacao = new Locacao(c, l, data);
                listaLocacao.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    }

    public Locacao get(String cpf, String cnpj, Date dataReserva) {
        Locacao locacao = null;
        
        String sql = "SELECT * from Locacao where cnpj = ?, cpf = ?, dataReserva = ?";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);
            statement.setString(2, cpf);
            statement.setTimestamp(3, new Timestamp(dataReserva.getTime()));

            ResultSet resultSet = statement.executeQuery();

            // Convertendo resultados para a classe interna Locacao
            if (resultSet.next()) {
                // Recuperando cliente e locadora a partir da chave estrangeira
                ClienteDAO clienteDAO = new ClienteDAO();
                LocadoraDAO locadoraDAO = new LocadoraDAO();

                Cliente c = clienteDAO.get(cpf);
                Locadora l = locadoraDAO.get(cnpj);

                locacao = new Locacao(c, l, dataReserva);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }

    public List<Locacao> getByCpf(String cpf) {
        List<Locacao> listaLocacao = new ArrayList<>();
        
        String sql = "SELECT * from Locacao where cpfCliente = ?";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();

            // Convertendo resultados para a classe interna Locacao
            while (resultSet.next()) {
                String cnpj = resultSet.getString("cnpjLocadora");
                Date data = new Date(resultSet.getTimestamp("dataReserva").getTime());

                // Recuperando cliente e locadora a partir da chave estrangeira
                ClienteDAO clienteDAO = new ClienteDAO();
                LocadoraDAO locadoraDAO = new LocadoraDAO();

                Cliente c = clienteDAO.get(cpf);
                Locadora l = locadoraDAO.get(cnpj);

                Locacao locacao = new Locacao(c, l, data);
                listaLocacao.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    }

    public List<Locacao> getByCnpj(String cnpj) {
        List<Locacao> listaLocacao = new ArrayList<>();
        
        String sql = "SELECT * from Locacao where cnpjLocadora = ?";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);

            ResultSet resultSet = statement.executeQuery();

            // Convertendo resultados para a classe interna Locacao
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpfCliente");
                Date data = new Date(resultSet.getTimestamp("dataReserva").getTime());

                // Recuperando cliente e locadora a partir da chave estrangeira
                ClienteDAO clienteDAO = new ClienteDAO();
                LocadoraDAO locadoraDAO = new LocadoraDAO();

                Cliente c = clienteDAO.get(cpf);
                Locadora l = locadoraDAO.get(cnpj);

                Locacao locacao = new Locacao(c, l, data);
                listaLocacao.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    }
}
