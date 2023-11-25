package br.com.fiap.healthinking.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.healthinking.model.entity.SonoDiario;

public class SonoDiarioRepository extends Repository {
	public static ArrayList<SonoDiario> findAll() {
		ArrayList<SonoDiario> sonosDiarios = new ArrayList<SonoDiario>();
		String sql = "select * from t_ht_sono_diario_cliente";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					SonoDiario sonoDiario = new SonoDiario();
					sonoDiario.setIdSono(rs.getLong("id_sono"));
					sonoDiario.setIdCliente(rs.getLong("id_cliente"));
					sonoDiario.setDuracaoSono(rs.getFloat("duracao_sono"));
					sonoDiario.setDataSono(rs.getDate("data_sono").toLocalDate());
					sonoDiario.setQualidadeSono(rs.getString("qualidade_sono"));
					sonoDiario.setAtividadeFisica(rs.getInt("tempo_atividade_fisica"));
					sonoDiario.setNivelEstresse(rs.getString("nivel_estresse"));
					sonosDiarios.add(sonoDiario);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return sonosDiarios;
	}
	
	public static ArrayList<SonoDiario> findByIdCliente(Long idCliente) {
		ArrayList<SonoDiario> sonosDiarios = new ArrayList<SonoDiario>();
		String sql = "select * from t_ht_sono_diario_cliente where id_cliente = ? ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, idCliente);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					SonoDiario sonoDiario = new SonoDiario();
					sonoDiario.setIdSono(rs.getLong("id_sono"));
					sonoDiario.setIdCliente(rs.getLong("id_cliente"));
					sonoDiario.setDuracaoSono(rs.getFloat("duracao_sono"));
					sonoDiario.setDataSono(rs.getDate("data_sono").toLocalDate());
					sonoDiario.setQualidadeSono(rs.getString("qualidade_sono"));
					sonoDiario.setAtividadeFisica(rs.getInt("tempo_atividade_fisica"));
					sonoDiario.setNivelEstresse(rs.getString("nivel_estresse"));
					sonosDiarios.add(sonoDiario);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return sonosDiarios;
	}
	
	public static SonoDiario save(SonoDiario sonoDiario) {
		String sql = "insert into t_ht_sono_diario_cliente "
				+ "(id_sono, id_cliente, duracao_sono, data_sono, qualidade_sono, tempo_atividade_fisica, nivel_estresse) "
				+ "values(sq_id_sono_cliente.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, sonoDiario.getIdCliente());
			ps.setFloat(2, sonoDiario.getDuracaoSono());
			ps.setDate(3, Date.valueOf(sonoDiario.getDataSono()));
			ps.setString(4, sonoDiario.getQualidadeSono());
			ps.setFloat(5, sonoDiario.getAtividadeFisica());
			ps.setString(6, sonoDiario.getNivelEstresse());
			if(ps.executeUpdate() > 0) {
				return sonoDiario;
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
	
	public static SonoDiario update(SonoDiario sonoDiario) {
		String sql = "Update t_ht_sono_diario_cliente "
				+ "Set id_cliente=?, duracao_sono=?, data_sono=?, qualidade_sono=?, tempo_atividade_fisica=?, nivel_estresse=?"
				+ "WHERE id_sono=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, sonoDiario.getIdCliente());
			ps.setFloat(2, sonoDiario.getDuracaoSono());
			ps.setDate(3, Date.valueOf(sonoDiario.getDataSono()));
			ps.setString(4, sonoDiario.getQualidadeSono());
			ps.setFloat(5, sonoDiario.getAtividadeFisica());
			ps.setString(6, sonoDiario.getNivelEstresse());
			ps.setLong(7, sonoDiario.getIdSono());
			if(ps.executeUpdate() > 0) {
				return sonoDiario;
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
		String sql = "delete from t_ht_sono_diario_cliente where id_sono = ?";
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
