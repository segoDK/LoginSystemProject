public class UserAdmin extends UserBasic {

    String welcomeMessage;

    public UserAdmin(String userName, String pWHAsh, String msg) {
        super(userName, pWHAsh);
        welcomeMessage = msg;
    }


}
