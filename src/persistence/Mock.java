package persistence;

public class Mock extends Dao {

	public void gerarMock() throws Exception {
		open();
		stmt = con.prepareCall("{call gerarClienteEndereco()}");
		stmt.execute();
		close();
	}
}
