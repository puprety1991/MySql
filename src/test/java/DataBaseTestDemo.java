import java.sql.*;

public class DataBaseTestDemo {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select firstname, lastname, age, city from person where city is not null;");

            // ResultSetMethodData -  object that contains info about the result table info such as column name, result data
            ResultSetMetaData metaData = resultSet.getMetaData();
            for(int i =1; i<=metaData.getColumnCount();i++){
                // looping through each column and getting column name
                String columnName = metaData.getColumnName(i);
                System.out.print(columnName+" ");
            }
            System.out.println();
            // we want to loop through every row and every column
            // loops throw row data in the resultSet object
            while (resultSet.next()){
                // for loop iterates over each column
                for(int i =1; i<=metaData.getColumnCount();i++){
                    // using metadata grabbing column name dynamically
                    String values = resultSet.getString(metaData.getColumnName(i));
                    // printing values of each column

                    System.out.print(values+" ");
                }
                System.out.println();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
       
    }
}
