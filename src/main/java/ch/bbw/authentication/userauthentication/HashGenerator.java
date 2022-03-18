package ch.bbw.authentication.userauthentication;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class HashGenerator {
    public String generateSHA256Hash(String pw) {
        return Hashing.sha256()
                .hashString(pw, StandardCharsets.UTF_8)
                .toString();
    }
    public String generateSHA512Hash(String pw) {
        return Hashing.sha512()
                .hashString(pw, StandardCharsets.UTF_8)
                .toString();
    }
}
