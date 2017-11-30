package persistence;

import java.sql.Statement;

import entity.Endereco;
import entity.Usuario;

public class jdbcDao extends Dao {

	private void delete(Usuario u, Endereco e) throws Exception {
		open();
		stmt = con.prepareStatement("delete from usuario where idUsuario=?");
		stmt.setInt(1, u.getIdUsuario());
		stmt.execute();
		stmt = con.prepareStatement("delete from Endereco where idEndereco=?");
		stmt.setInt(1, e.getIdEndereco());
		stmt.execute();
		close();
	}

	private void update(Usuario u, Endereco e) throws Exception {
		open();
		stmt = con
				.prepareStatement("update usuario set nome=?, email=?, senha=?, sexo=?, permissao=? where idUsuario=?");
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getEmail());
		stmt.setInt(3, u.getSenha());
		stmt.setString(4, u.getSexo());
		stmt.setString(5, u.getPermissao());
		stmt.setInt(6, u.getIdUsuario());
		stmt.execute();

		stmt = con.prepareStatement(
				"update endereco set logradouro=?, bairro=?, cidade=?, estado=?, cep=? where idEndereco=?");
		stmt.setString(1, e.getLogradouro());
		stmt.setString(2, e.getBairro());
		stmt.setString(3, e.getCidade());
		stmt.setString(4, e.getEstado());
		stmt.setString(5, e.getCep());
		stmt.setInt(6, e.getIdEndereco());
		stmt.execute();

		close();
	}

	// this.idUsuario = idUsuario;
	// this.nome = nome;
	// this.email = email;
	// this.senha = senha;
	// this.sexo = sexo;
	// this.permissao = permissao;
	// }

//	public Usuario loginUsuario(Integer senha,String login) throws Exception {
//		open();
//		stmt = con.prepareStatement("select * from usuario where senha=? and email=?");
//		stmt.setInt(1, senha);
//		stmt.setString(2, login);
//		rs = stmt.execute();
//		Usuario u=null;
//		if (rs.next()) {
//			u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
//		}
//		close();
//		return u;
//	}
//
	public void newPassword(Integer id, Integer senhanova) throws Exception {
		open();
		stmt = con.prepareStatement("update usuario set senha=? where idUsuario=?");
		stmt.setInt(1, senhanova);
		stmt.setInt(2, id);
		stmt.execute();
		close();

	}

	public static void main(String[] args) {
		jdbcDao d = new jdbcDao();
		// UsuarioDao ud = new UsuarioDao();
//		Usuario usu = new Usuario();
		// Integer novaSenha = (int) (10000 * Math.random());
		try {

			// d.newPassword(1, novaSenha);
//		boolean	us= d.logar("jorge@gmaill.com", 45);
//			Usuario u = d.loginUsuario(45,"jorge@gmaill.com");
//			System.out.println(u);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
