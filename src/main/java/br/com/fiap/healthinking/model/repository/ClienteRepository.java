package br.com.fiap.healthinking.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.healthinking.model.entity.Cliente;

public class ClienteRepository extends Repository{
	
	public static ArrayList<Cliente> findAll() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from t_ht_cliente";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getLong("id_cliente"));
					cliente.setUserCliente(rs.getString("usuario_cliente"));
					cliente.setSenhaCliente(rs.getString("senha_cliente"));
					cliente.setNomeCLiente(rs.getString("nome_cliente"));
					cliente.setDataNascimento(rs.getDate("data_nasc_cliente").toLocalDate());
					cliente.setAlturaCLiente(rs.getFloat("altura_cliente"));
					cliente.setPesoCliente(rs.getFloat("peso_cliente"));
					cliente.setClassificacaoBmi(rs.getString("classificacao_bmi"));
					clientes.add(cliente);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return clientes;
	}
	
	public static Cliente findClienteByUser(String userCLiente) {
		String sql = "select * from t_ht_cliente where usuario_cliente=?";
		Cliente cliente = new Cliente();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userCLiente);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					cliente.setIdCliente(rs.getLong("id_cliente"));
					cliente.setUserCliente(rs.getString("usuario_cliente"));
					cliente.setSenhaCliente(rs.getString("senha_cliente"));
					cliente.setNomeCLiente(rs.getString("nome_cliente"));
					cliente.setDataNascimento(rs.getDate("data_nasc_cliente").toLocalDate());
					cliente.setAlturaCLiente(rs.getFloat("altura_cliente"));
					cliente.setPesoCliente(rs.getFloat("peso_cliente"));
					cliente.setClassificacaoBmi(rs.getString("classificacao_bmi"));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return cliente;
	}
	
	public static Cliente save(Cliente cliente) {
		String sql = "insert into t_ht_cliente "
				+ "(id_cliente, usuario_cliente, senha_cliente, nome_cliente, data_nasc_cliente, altura_cliente, peso_cliente, classificacao_bmi) "
				+ "values(sq_id_cliente.nextval, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getUserCliente());
			ps.setString(2, cliente.getSenhaCliente());
			ps.setString(3, cliente.getNomeCLiente());
			ps.setDate(4, Date.valueOf(cliente.getDataNascimento()));
			ps.setFloat(5, cliente.getAlturaCLiente());
			ps.setFloat(6, cliente.getPesoCliente());
			ps.setString(7, cliente.getClassificacaoBmi());
			if(ps.executeUpdate() > 0) {
				return cliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static Cliente update(Cliente cliente) {
		String sql = "Update t_ht_cliente "
				+ "Set usuario_cliente=?, senha_cliente=?, nome_cliente=?, data_nasc_cliente=?, altura_cliente=?, peso_cliente=?, classificacao_bmi=? "
				+ "WHERE id_cliente=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getUserCliente());
			ps.setString(2, cliente.getSenhaCliente());
			ps.setString(3, cliente.getNomeCLiente());
			ps.setDate(4, Date.valueOf(cliente.getDataNascimento()));
			ps.setFloat(5, cliente.getAlturaCLiente());
			ps.setFloat(6, cliente.getPesoCliente());
			ps.setString(7, cliente.getClassificacaoBmi());
			ps.setLong(8, cliente.getIdCliente());
			if(ps.executeUpdate() > 0) {
				return cliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static boolean delete(Long id) {
		String sql = "delete from t_ht_cliente where id_cliente = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if(ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
		
}
