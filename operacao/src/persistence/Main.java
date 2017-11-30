package persistence;

import entity.Endereco;
import entity.Usuario;

public class Main {

	public static void main(String[] args) {

		Usuario u1 = new Usuario(null,"joazin","jo@gmail.com",13,"m",null,"admin");
		Usuario u5 = new Usuario(null,"hugo","hugocoutinho2011@gmail.com",1997,"M",null,"usuario");
//		Usuario u2 = new Usuario(null,"joaquim","joaquim@gmail.com",789,"m","usu");
		Endereco e1 = new Endereco(null, "rua do japa", "bairro japones", "cidade do japao", "estado jp", "cep jap");
		Endereco e2 = new Endereco(null, "rua do china", "bairro china", "cidade do china", "estado ch", "cep china");
		u1.setEndereco(e1);
		u5.setEndereco(e2);
		UsuarioDao ud = new UsuarioDao();
		EnderecoDao ed = new EnderecoDao();
		jdbcDao jd = new jdbcDao();
		

		try {

			ed.create(e2);
			ed.create(e1);
			ud.create(u5);
			ud.create(u1);	
			System.out.println("gravou");
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("não gravou" + e.getMessage());

		}

	}

}
