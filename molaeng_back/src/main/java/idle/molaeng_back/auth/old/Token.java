package idle.molaeng_back.auth.old;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Token {
    private String accessToken;
    public String refreshToken;
}
