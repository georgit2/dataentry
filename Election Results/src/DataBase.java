/**
 * Created by aangjnr on 23/11/2016.
 */
import java.sql.*;

public class DataBase
{
    public static void main( String args[] ) throws SQLException {

        createTable();
        insertValue("Camara");


    }

    public static void createTable(){

        // Creates a table called IMAGES with an incremental primary key and a column called IMAGE_NAME

        Connection c = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            DatabaseMetaData dbm = c.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "IMAGE ID", null);

            if (!tables.next()) {
                // Table doesn't exist, create it.
                System.out.println("Table doesnt exist, creating it.");

                statement = c.createStatement();

                String sql = "CREATE TABLE IMAGE ID (" +
                        "id_no INT  PRIMARY KEY  NOT NULL  AUTO_INCREMENT, " +
                        "Image_names   TEXT   NOT NULL)";

                statement.executeUpdate(sql);
                statement.close();
                c.close();
            }
            else {
                // Table  exist, do nothing but just close connection.

                System.out.println("Table exists. Skipping");
                c.close();
            }

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        System.out.println("IMAGE ID table has been created successfully!");
    }


    public static void insertValue(String image_name){


        Connection c = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            statement = c.createStatement();
            String sql = "INSERT INTO IMAGE ID (Image_names) " +
                    "VALUES ( " + image_name + " );";
            System.out.println(sql);
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Image name inserted successfully");
    }



    public static Boolean checkIfImageNameExists(String image_name){
        Boolean exists = null;


        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * IMAGE_ID;" );
            while ( rs.next() ) {

                String  name = rs.getString("Image_names");

                // This checks to see if Image name exists in db.
                //If it exists, meaning its been already been viewed. Move to the next one
                if(name.equalsIgnoreCase(image_name)){

                    System.out.println("Image name exists! Skip to next image");
                    exists = true;


                }else{
                    //This is a new image, display it and add its name into the db
                    //Do this in the main code

                    exists = false;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

       return exists;
    }

    }






