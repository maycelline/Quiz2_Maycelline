package Controller;

import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {
    static ConnectionManager conn = new ConnectionManager();

    public int getTotalUserAtDB(){
        ArrayList<Integer> listIdUser = new ArrayList<>();
        int totalUser = 0;
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
               listIdUser.add(rs.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int size = listIdUser.size();
        return listIdUser.get(size-1);
    }

    public User LogIn(String email, String password){
        conn.connect();
        User user = null;
        String query = "SELECT * FROM user WHERE email = '"+email+"' AND password = '"+password+"'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public ArrayList<String> getListOfCategory(){
        conn.connect();
        ArrayList<String> listCategory = new ArrayList<>();
        String query = "SELECT * FROM categoryuser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                listCategory.add(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listCategory;
    }

    public boolean Register(User user){
        conn.connect();
        String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getIdCategory());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean EditUser(int id, String name, String email, String passowrd){
        conn.connect();
        String query = "UPDATE user SET name='" +name + "', "
                + "email='" + email + "', "
                + "password='" + passowrd + "' "
                + "WHERE id=" + id + ";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public ArrayList<User> getDataUser(int userJenis){
        ArrayList<User> listUser = new ArrayList<>();
        conn.connect();
        String sql =  "SELECT * FROM user WHERE idCategory="+userJenis+";";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listUser);
    }

    public boolean DeleteUser(int idUser){
        conn.connect();
        String sql =  "DELETE FROM user WHERE id="+idUser+";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(sql);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
