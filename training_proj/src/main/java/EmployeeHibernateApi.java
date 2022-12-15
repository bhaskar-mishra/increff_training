import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeHibernateApi {
    private static final Logger logger = Logger.getLogger(EmployeeHibernateApi.class);

//    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//
//        delete(con);
//        insert(con);
//        select(con);
//        delete(con);
//        select(con);
//        con.close();
//    }

    public EmployeeHibernateApi() throws IOException, ClassNotFoundException, SQLException {
    }

    public void insert() throws SQLException {
        logger.info("inserting rows");
    }

    public void select() throws SQLException {
        logger.info("selecting rows");
    }

    public void delete() throws SQLException {
        logger.info("deleting rows");
    }

}
