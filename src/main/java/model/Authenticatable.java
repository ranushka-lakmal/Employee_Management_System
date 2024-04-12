package model;

public interface Authenticatable {

    boolean authenticate(String username, String password);
    void updateCredentials(String username, String password);

}
