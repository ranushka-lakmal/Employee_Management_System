package model;

public class Assistant extends User{

    public Assistant(String username, String password) {
        super(username, password);
    }



    @Override
    public boolean authenticate(String username, String password) {
        System.out.println("HRAssistant authentication in progress...");
        return super.authenticate(username, password);
    }

}
