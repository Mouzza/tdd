package be.kdg.prog4.tdd;

import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    public void create(User user);

    public User getUser(String username);
}
