package be.kdg.prog4.tdd;


import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final String password;
    private final List<String> favorites;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.favorites=new ArrayList<>();
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void addFavorite(String favorite){
        favorites.add(favorite);
    }
    public void removeFavorite(String favorite){
        favorites.remove(favorite);
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
