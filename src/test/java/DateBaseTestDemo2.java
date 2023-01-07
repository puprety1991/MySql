import java.sql.*;

public class DateBaseTestDemo2 {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connectionBuilt = DriverManager.getConnection(url, username, password);
            Statement builtStatement = connectionBuilt.createStatement();
            ResultSet resultSetQuery = builtStatement.executeQuery("select emp_firstname,emp_lastname,lang_id,name" +
                    " from hs_hr_employees as emp join hs_hr_emp_language as lang" +
                    " on emp.emp_number = lang.emp_number " +
                    " join ohrm_language as ol on lang.lang_id = ol.id" +
                    " where name ='english';");
            ResultSetMetaData metaData = resultSetQuery.getMetaData();

            for(int i=1; i<=metaData.getColumnCount();i++){
                String headerName = metaData.getColumnName(i);
                System.out.print(headerName+" ");
            }
            System.out.println();
            while (resultSetQuery.next()){
                for(int i=1; i<=metaData.getColumnCount();i++){
                    String data = resultSetQuery.getString(metaData.getColumnName(i));
                    System.out.print(data+" ");
                }
                System.out.println();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
