/* Padrão de projeto Singleton.
 * DAO - Objeto de acesso a dados.
 * 
 * 
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Contato;

/**
 *
 * @author Anderson
 */
public class ContatoDAO {
    private static ContatoDAO instance = new ContatoDAO();
    public static ContatoDAO getInstance(){
        return instance;
    }

    public static Object getIntance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void save(Contato contato) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try {
                conn = DatabaseLocator.getInstance().getConection();
                st = conn.createStatement();
                st.execute("insert into contato (nome, email)" +
                        " values ('" + contato.getNome() + "', '" + contato.getEmail() + "')");
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
