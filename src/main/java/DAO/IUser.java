package DAO;

import java.util.List;

public interface IUser {
    public List<User> findAll();
    public int add(User user);

    public User findByEmail(String email);
    boolean checkLogin(String email, String password);
}
