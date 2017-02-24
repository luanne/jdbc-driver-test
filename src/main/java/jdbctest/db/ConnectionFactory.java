package jdbctest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Luanne Misquitta
 */
public class ConnectionFactory {
    private final static ConnectionFactory instance = new ConnectionFactory();


    private ConnectionFactory() {
        try {
            System.out.println("############## Loading Driver...");
            Class.forName("org.neo4j.jdbc.bolt.BoltDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Could not load JDBC Driver", cnfe);
        }
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }

    /**
     * Get a JDBC connection to a Neo4j Server
     *
     * @return Connection
     */
    public Connection getServerConnection() throws RuntimeException, SQLException {
        return DriverManager.getConnection("jdbc:neo4j:bolt://localhost","neo4j","neo" );
    }


}

