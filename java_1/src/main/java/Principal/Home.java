package Principal;

import java.sql.Connection;
import java.sql.SQLException;

import Factory.Factory;

public class Home {

	public static void main(String[] args) throws SQLException {
		

        Factory factory = new Factory();
        Connection connection = factory.recuperarConexao();

        System.out.println(factory.Select(connection));
        
        System.out.println("\n\nFechando conexão");

        connection.close();
	}

}
