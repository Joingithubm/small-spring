package com.zeng.demo;

/**
 * @Author fanchao
 * @Date 2024/09/13/10:50
 * @Description
 */
public class HelloWorld {

    private String username;
    private String password;

    public static void main(String[] args) {
        System.out.println("printf ....");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
