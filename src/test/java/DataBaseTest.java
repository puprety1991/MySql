import java.sql.*;

public class DataBaseTest {
    public static void main(String[] args) {
       /* To build connection to the database we need 3 things
            URL,username,password
            Connection Name: HRM
            Connection Method: Standard (TCP/IP)
            Host Name: 3.239.253.255
            Port: 3306
            Username: syntax_hrm
            Password: syntaxhrm123*/

        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            //1. connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            //2. crate statement object to send sql queries
            Statement st = conn.createStatement();
            //3.using statement object we are send query and database return an object of resultSet(table with rows and column)
            ResultSet resultSet = st.executeQuery("select FirstName,LastName from person;");
            //System.out.println("Connection is created");
            String firstName;
            String lastName;
            resultSet.next();
             firstName = resultSet.getString("FirstName");
             lastName = resultSet.getString("LastName");
            System.out.println(firstName+" "+lastName);

            while(resultSet.next()){
                firstName = resultSet.getString("FirstName");
               lastName = resultSet.getString("LastName");
                System.out.println(firstName+" "+lastName);
            }



        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}