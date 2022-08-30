package learn.sprng.sthr.c09e01scopes;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Service
@SessionScope
public class LoggedUserManagementService {

    private final UUID uuid = UUID.randomUUID();
    private String username;

    public String getUsername() {
        System.out.println("LoggedUserManagementService with UUID " + uuid);
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
