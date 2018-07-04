package strategyContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctrlPattern.IUsuarioModel;
import entity.Usuario;
import strategyInterface.IDeletar;

public class DeletarContext {

	private IDeletar del;

	public void setDel(IDeletar del) {
		this.del = del;
	}

	public void CondicaoDeletar(HttpServletRequest request, HttpServletResponse response, IUsuarioModel usuario)
			throws Exception {

		del.executar(request, response, usuario);

	}

}
