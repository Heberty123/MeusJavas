package Principal;

import java.sql.Connection;
import java.sql.SQLException;

import Factory.Factory;

public class Home {

	public static void main(String[] args) throws SQLException {
		

        Factory factory = new Factory();
        Connection connection = factory.recuperarConexao();
        
        factory.InsertByCategory(connection, "Leandro", "FullStack", 3);
        factory.InsertByCategory(connection, "Karina", "DataScience", 2);
        factory.InsertByCategory(connection, "Karen", "Backend", 4);

        System.out.println(factory.Select(connection));
        
        System.out.println("\n\n\n");
        
        System.out.println(factory.SelectByCategory(connection));
        
        
        System.out.println("\n\nFechando conexão");

        connection.close();
	}

}
