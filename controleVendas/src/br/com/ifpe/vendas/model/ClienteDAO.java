package br.com.ifpe.vendas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.vendas.util.ConnectionFactory;



public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void inserir(Cliente cliente) {

		String sql = "INSERT INTO cliente (codigo, nome, cpf, endereco_cobranca, email, senha) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, cliente.getCodigo());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEnderecoCobranca());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getSenha());

			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> listar() {
		try {
			List<Cliente> listaCliente = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM cliente ORDER BY nome");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));

				listaCliente.add(cliente);
			}
			stmt.execute();
			connection.close();
			return listaCliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}