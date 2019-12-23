package domain;

import java.util.Date;

/*
用户名实体类
 */
public class User {
    private String username;    //用户名
    private String email;       //电子邮件
    private String password;    //密码
    private Date time;          //注册时间

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", time=" + time +
                '}';
    }

    public User(String username, String email, String password, Date time) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.time = time;
    }

    public User() {
    }
}
