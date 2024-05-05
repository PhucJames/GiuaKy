package DAO;

import org.jdbi.v3.core.Jdbi;

import java.util.List;

import static vn.fit.nlu.gk.db.JDBIConnector.get;

public class UserDAO implements IUser{
    Jdbi jdbi;

    public UserDAO() {
        String url = "jdbc:mysql://localhost:3306/ltwtest";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        jdbi = Jdbi.create(url,"root","");
    }
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbi.withHandle(handle -> handle
                .createQuery(sql)
                .mapToBean(User.class)
                .list());
    }

    @Override
    public int add(User user) {
        String sql = "INSERT INTO users(fullName,email,password) VALUES(?,?,?)";
        return jdbi.withHandle(handle -> handle
                .createUpdate(sql)
                .bind(0, user.getfullName())
                .bind(1, user.getEmail())
                .bind(2, user.getPassword()).execute());
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        String sql = "SELECT * FROM users WHERE email=?";
        user = jdbi.withHandle(handle -> handle
                .select(sql, email)
                .mapToBean(User.class)
                .list()
                .stream()
                .findFirst()
                .orElse(new User()));
        return user;
    }
    public boolean checkLogin(String email, String password){
        String sql = "SELECT * FROM users WHERE email = ? AND password=?";
        return !jdbi.withHandle(handle -> handle
                .select(sql, email, password)
                .bind(0, email)
                .bind(1, password)
                .mapToBean(User.class)
                .list().isEmpty());
    }

    public static void main(String[] args) {
        IUser userDao = new UserDAO();
        User user = new User();
        user.setEmail("james@gmail.com");
        user.setfullName("James");
        user.setPassword("123456");
        System.out.println(userDao.add(user));
        userDao.findAll().forEach(System.out::println);
    }
}
