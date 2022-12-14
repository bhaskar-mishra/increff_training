

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee_Test {
    @Test
    public void sayHello() throws SQLException, IOException, ClassNotFoundException {
        EmployeeApi obj = new EmployeeApi();
        obj.delete();
        obj.insert();
        ResultSet rs = obj.select();
        int cnt = 0;
        while(rs.next())
        {
            cnt++;
        }
       assertEquals(3,cnt);
    }
}
