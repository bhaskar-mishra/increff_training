import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeJdbcApi {
    private static final Logger logger = Logger.getLogger(EmployeeHibernateApi.class);
    private Connection con;

//    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//
//        delete(con);
//        insert(con);
//        select(con);
//        delete(con);
//        select(con);
//        con.close();
//    }

    public EmployeeJdbcApi() throws IOException, ClassNotFoundException, SQLException {
        BasicConfigurator.configure();
        Properties props = new Properties();
        InputStream inputStream = new FileInputStream("employee.properties");
        props.load(inputStream);
        Class.forName(props.getProperty("jdbc.driver"));

         con = DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
    }

    public void insert() throws SQLException {
        logger.info("inserting rows");
        Statement stmt = con.createStatement();

        for(int i = 0;i<3;++i)
        {
            int id = i;
            String name = "name"+i;
            int age = 25+i;
            String query = "insert into employee values(" + id+", '"+name+"', "+age+")";
            stmt.executeUpdate(query);
        }

    }

    public ResultSet select() throws SQLException {
        logger.info("selecting rows");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
        return rs;
//        while (rs.next()) {
//            logger.info(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
//        }
    }

    public void delete() throws SQLException {
        logger.info("deleting rows");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
        List<Integer> list = new ArrayList();
        while (rs.next())
        {
            list.add(rs.getInt(1));
        }

        for(int i = 0;i<list.size();++i)
        {
            stmt.executeUpdate("delete from employee where id="+list.get(i));
        }
    }

}