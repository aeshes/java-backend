package aoizora.encoder;

import aoizora.usecase.port.PasswordEncoder;
import org.apache.commons.codec.digest.DigestUtils;

public class SHA256PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(final String str) {
        return DigestUtils.sha256Hex(str);
    }
}
