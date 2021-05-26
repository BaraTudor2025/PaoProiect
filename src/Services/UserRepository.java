package Services;

import java.sql.*;
import java.util.ArrayList;

import Models.*;

public class UserRepository {

    private Connection conn;
    private ArrayList<User> users;
    private static UserRepository repo = null;

    public static UserRepository getRepo(){
        if(repo == null)
            repo = new UserRepository();
        return repo;
    }

    private UserRepository(){
        conn = Database.getConnection();
        users = readUsers();
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }

    public ArrayList<User> readUsers(){
        var users = new ArrayList<User>();
        try {
            var st = conn.createStatement();
            var res = st.executeQuery("select * from users");
            while(res.next()){
                users.add(new User(res.getInt(1), res.getString(2)));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public void insertUser(User user){
        try {
            CallableStatement st = conn.prepareCall("{call insertUser(?, ?)}");
            st.registerOutParameter(1, Types.INTEGER);
            st.setString(2, user.getName());
            st.execute();
            user.setId(st.getInt(1));
            System.out.println("user-id: " + st.getInt(1));
            users.add(user);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User getUserById(int id){
        try{
            PreparedStatement st = conn.prepareStatement("select * from users where id=?;");
            st.setInt(1, id);
            var res = st.executeQuery();
            if(res.next()){
                return new User(id, res.getString(2));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(int id, String name){
        try {
            PreparedStatement st = conn.prepareStatement("update users set name=? where id=?;");
            st.setString(1, name);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUser(int id){
        try {
            var st = conn.prepareStatement("delete from users where id=?;");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
