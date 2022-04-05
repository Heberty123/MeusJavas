package Factory;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class Factory {

    public DataSource dataSource;

    public Factory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/Object?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");

        this.dataSource = comboPooledDataSource;
    }
    
    
    

    public Connection recuperarConexao() throws SQLException {
        return this.dataSource.getConnection();
    }
    
    
    

    public void Insert(Connection conn, String name, String descricao) throws SQLException{

        PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee (nome, descricao) VALUES (?, ?)");
        ps.setString(1, name);
        ps.setString(2, descricao);
        ps.execute();
    }
    
    
    public void InsertByCategory(Connection conn, String name, String descricao, int number) throws SQLException{

        StringBuilder sb = new StringBuilder();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee (nome, descricao, Experiencia_id) VALUES (?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, descricao);
        ps.setInt(3, number);
        ps.execute();
        
    }
    
    

    public String Select(Connection conn) throws SQLException{

        StringBuilder sb = new StringBuilder();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
        ps.execute();
        ResultSet rst = ps.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt(1);
            String name = rst.getString(2);
            String descricao = rst.getString(3);
            sb.append(String.format("Id - %d  nome: %s, descrição: %s\n", id, name, descricao));
        }

        return "" + sb;
    }
    
    
    
    public String SelectByCategory(Connection conn) throws SQLException{

        StringBuilder sb = new StringBuilder();
        PreparedStatement ps = conn.prepareStatement("SELECT Employee.id, Employee.nome, Employee.descricao, Experiencia.nome FROM Employee INNER JOIN Experiencia ON Employee.Experiencia_id = Experiencia.id;");
        ps.execute();
        ResultSet rst = ps.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt(1);
            String name = rst.getString(2);
            String descricao = rst.getString(3);
            String categoria = rst.getString(4);
            sb.append(String.format("Id - %d  nome: %s, descrição: %s, Categoria: %s \n", id, name, descricao, categoria));
        }

        return "" + sb;
    }
}
