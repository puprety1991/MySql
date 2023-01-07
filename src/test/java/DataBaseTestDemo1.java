import java.sql.*;

public class DataBaseTestDemo1 {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id,firstname,lastname,gender,age, city from person where gender is not null and age is not null and city is not null order by firstname;");
            ResultSetMetaData metaData = resultSet.getMetaData();
            for(int i=1;i<=metaData.getColumnCount();i++){
                String columnName = metaData.getColumnName(i);
                System.out.print(columnName+" ");
            }
            System.out.println();
            while (resultSet.next()){
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String values = resultSet.getString(metaData.getColumnName(i));
                    System.out.print(values+" "+"|");
                }
                System.out.println();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
