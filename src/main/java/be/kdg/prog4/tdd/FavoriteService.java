package be.kdg.prog4.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class FavoriteService {



    @Autowired
    private Users users;

    public boolean checkLogin(String username, String password) {
        return users.login(username, password);
    }

    public void addUser(String root, String rootpasswd, String username, String password) {
        if(root.equals("root")&&rootpasswd.equals("rootpasswd")) {
            users.addUser(username, password);
        }
    }

    public List<String> getFavorites(String username, String password) {
        if(checkLogin(username,password)){
            User user = users.getUser(username);
            return user.getFavorites();

        }else{
            return new ArrayList<>();
        }

    }


    public void addFavorite(String username, String password, String favorite1) {
        if(checkLogin(username,password)){
            User user = users.getUser(username);
            user.addFavorite(favorite1);

        }
    }

    public void removeFavorite(String username, String password, String favorite1) {

        if(checkLogin(username,password)){
            User user = users.getUser(username);
            user.removeFavorite(favorite1);

        }
    }
}
