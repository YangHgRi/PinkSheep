package yanghgri.pinksheep;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
class TestMessageDigest {
    private static final String plainText = "YangHgRi";

    @Test
    void testJDK() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(plainText.getBytes(StandardCharsets.UTF_8));
        String ciphertext = MD5Encoder.encode(messageDigest.digest()).toUpperCase();
        log.info(ciphertext);
    }

    @Test
    void testApacheCommons() {
        String ciphertext = DigestUtils.md5Hex(plainText).toUpperCase();
        log.info(ciphertext);
    }
}