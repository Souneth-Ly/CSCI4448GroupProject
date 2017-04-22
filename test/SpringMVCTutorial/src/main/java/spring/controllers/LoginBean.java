package spring.controllers;
public class LoginBean {
 
    private String inputUserName;
    private String inputPassword;
 
    public String getUserName() {
        return inputUserName;
    }
 
    public void setUserName(String userName) {
        this.inputUserName = userName;
    }
 
    public String getPassword() {
        return inputPassword;
    }
 
    public void setPassword(String password) {
        this.inputPassword = password;
    }
 
}
