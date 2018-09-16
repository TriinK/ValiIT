package ee.bcs.valiit.trikad;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class PasswordEncoder {
    String encodedPassword;

    public PasswordEncoder(String password) {
        encodedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

    public String print() {return encodedPassword;}
}
