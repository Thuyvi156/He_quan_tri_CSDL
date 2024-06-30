package DTO;

import java.sql.*;

public class SQL{
    private SQL(){}
    private static final String 
            URL = "jdbc:oracle:thin:@localhost:1521/orcldb1", 
            USERNAME = "QL", 
            PASSWORD = "password";
    private static Connection CON = null;
    private static PreparedStatement getPreparedStatement(String Query, Object... args) throws SQLException{
        if(CON == null) try {
            Class.forName("oracle.jdbc.OracleDriver");
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error try to get auto connect SQL\n\tError code: " + ex.toString());
            System.exit(1);
        }
        
        PreparedStatement ps = null;
        if(Query.trim().startsWith("{"))    ps = CON.prepareCall(Query);
        else                                ps = CON.prepareStatement(Query);
        for(int i=0; i < args.length; i++)  ps.setObject(i + 1, args[i]);
        return ps;
    }
    
    public final boolean isConnectNull(){     return CON == null;     }
    public final Connection getConnect(){     return CON;             }
    
    public static final int Update(String Query, Object... args){
        try{    
            return getPreparedStatement(Query, args).executeUpdate(); 
        }catch (SQLException e) {
            System.out.println("!!! Error try to execute update query: " + Query + "!!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }

    public static final ResultSet Query(String Query, Object... args) {
        try {
            return getPreparedStatement(Query, args).executeQuery(); 
        }catch (SQLException e) {
            System.out.println("!!! Error try to execute query: " + Query + "!!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
}