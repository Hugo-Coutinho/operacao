package control;

import org.jcommon.encryption.SimpleMD5;

import entity.Usuario;

public class Criptografia {
	
	public void criptografia(Usuario u){
		SimpleMD5 md5 = new SimpleMD5(""+u.getSenha(),"cotiinfromatica@123$#@..567abc_");
		u.setSenha(new Integer(md5.hashCode()));
	}
}
