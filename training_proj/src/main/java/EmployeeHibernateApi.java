import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeHibernateApi {
    private static final Logger logger = Logger.getLogger(EmployeeHibernateApi.class);

    private HibernateUtil hbu;

    public EmployeeHibernateApi() throws IOException, ClassNotFoundException, SQLException {
        hbu = new HibernateUtil();
    }

    public void insert(EmployeePojo p) throws SQLException {
        logger.info("inserting rows");
        hbu.createSession();
        hbu.beginTransaction();
        Session s = hbu.getSession();
        s.save(p);
        hbu.commitTransaction();
        hbu.closeSession();
    }

    public EmployeePojo select(int id) throws SQLException {
        logger.info("selecting an employee");
        hbu.createSession();
        hbu.beginTransaction();
        Session s = hbu.getSession();
        EmployeePojo p = s.find(EmployeePojo.class,id);
        hbu.commitTransaction();
        hbu.closeSession();
        return p;
    }

    public List<EmployeePojo> selectAll() throws SQLException {
        logger.info("selecting all employees");
        hbu.createSession();
        hbu.beginTransaction();
        Session s = hbu.getSession();
        Query q = s.createQuery("select o from EmployeePojo o");
        List<EmployeePojo> list = q.getResultList();
        hbu.commitTransaction();
        hbu.closeSession();
        return list;
    }

    public void delete(int id) throws SQLException {
        logger.info("deleting rows");
        hbu.createSession();
        hbu.beginTransaction();
        Session s = hbu.getSession();
        EmployeePojo p = s.find(EmployeePojo.class,id);
        s.delete(p);
        hbu.commitTransaction();
        hbu.closeSession();
    }

    public void deleteAll() throws SQLException {
        logger.info("deleting rows");
        hbu.createSession();
        hbu.beginTransaction();
        Session s = hbu.getSession();
        Query q = s.createQuery("select o from EmployeePojo o");
        List<EmployeePojo> list = q.getResultList();
        for(EmployeePojo p : list)
        {
            s.delete(p);
        }
        hbu.commitTransaction();
        hbu.closeSession();
    }

    public void printAll() throws SQLException {
        try {
            List<EmployeePojo> list = selectAll();
            for(EmployeePojo p : list)
            {
                logger.warn("Employee id: "+p.getId()+" Employee Name: "+p.getName()+" Employee age: "+p.getAge());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
