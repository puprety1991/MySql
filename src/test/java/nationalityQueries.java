import java.sql.*;

public class nationalityQueries {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ohrm_nationality;");
            while ((resultSet.next())){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println(id+" "+name);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
