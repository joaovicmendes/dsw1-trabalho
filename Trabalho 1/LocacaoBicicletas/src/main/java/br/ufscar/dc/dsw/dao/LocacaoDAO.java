package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

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
                String cnpj = resultSet.getString("cnpj");
                String cpf = resultSet.getString("nome");
                LocalDateTime data = resultSet.getTimestamp("dataReserva").toLocalDateTime();

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

    public Locacao get(String cpf, String cnpj, LocalDateTime dataReserva) {
        Locacao locacao = null;
        
        String sql = "SELECT * from Locacao where cnpj = ?, cpf = ?, dataReserva = ?";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);
            statement.setString(2, cpf);
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(dataReserva));

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
}
