package learn.sprng.sthr.c09e01scopes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@RequestScope
public class LoginProcessor {

    private final UUID uuid = UUID.randomUUID();

    private String username;
    private String password;

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

    public boolean login() {
        System.out.println("LoginProcessor with UUID " + uuid);
        return "james".equals(getUsername()) && "123".equals(getPassword());
    }
}
