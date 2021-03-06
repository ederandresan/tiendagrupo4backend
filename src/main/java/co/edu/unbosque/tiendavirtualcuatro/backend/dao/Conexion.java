/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestiona una conexión con la base de datos.
 * 
 * @author
 *
 */
public class Conexion {
  // static String bd = "tiendavirtualgrupo4";

  /**
   * Nombre de usuario para iniciar la conexión con la base de datos.
   */
  public static String login;

  /**
   * Contraseña de usuario para iniciar la conexión con la base datos.
   */
  public static String password;

  /**
   * Dirección URL para conectarse la base de datos.
   */
  public static String url;

  /**
   * Objeto que mantiene la conexión con la base de datos.
   */
  private Connection connection = null;

  /**
   * Crea un nuevo objeto para manejar la conexión con la base de datos.
   */
  public Conexion() {
    try {
      // obtenemos el driver de para mysql
      Class.forName("com.mysql.cj.jdbc.Driver");
      // Class.forName("org.mariadb.jdbc.Driver");
      // obtenemos la conexión
      connection = DriverManager.getConnection(url, login, password);

      if (connection != null) {
        System.out.println("Conexión a base de datos " + url + " OK\n");
      }
    } catch (SQLException e) {
      System.out.println(e);
    } catch (ClassNotFoundException e) {
      System.out.println(e);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Obtiene la conexión con la base de datos. *
   * 
   * @return La conexión con la base de datos.
   */
  public Connection getConnection() {
    return connection;
  }

  /**
   * Cierra la conexión con la base de datos.
   */
  public void desconectar() {
    connection = null;
  }

}
