package jdbctest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbctest.db.ConnectionFactory;

/**
 * @author Luanne Misquitta
 */

@Path("/all")
public class SomeApi {

    @Path("/count")
    @GET
    @Produces("application/json")
    public long count() {
        long count = 0;
        try(Connection conn = ConnectionFactory.getInstance().getServerConnection()) {
            String query = "MATCH (n) return count(n) as count";


            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    count = rs.getLong("count");
                }
                rs.close();
            } catch (SQLException sqle) {
                throw new RuntimeException("Failed to get count" + sqle);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Could not get connection", e);
        }
        return count;
    }
}
