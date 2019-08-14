/* Padrão de projeto Singleton.
 * DAO - Objeto de acesso a dados.
 * 
 * 
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anderson
 */
public class ContatoDAO {
    private static ContatoDAO instance = new ContatoDAO();
    public static ContatoDAO getInstance(){
        return instance;
    }
    
    public void save(String nome, String email) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try {
                conn = DatabaseLocator.getInstance().getConection();
                st = conn.createStatement();
                st.execute("insert into contato (nome, email)" +
                        " values ('" + nome + "', '" + email + "')");
            } catch(SQLException e) {
                throw e;
            } finally {
                closeResources(conn, st);
            }
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } catch(SQLException e) {

        }
    }

}
