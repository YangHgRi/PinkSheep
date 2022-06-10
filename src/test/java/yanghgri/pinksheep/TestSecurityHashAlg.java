package yanghgri.pinksheep;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

@Slf4j
class TestSecurityHashAlg {
    public static final String plainText = "YangHgRi";

    @Test
    void testDigestUtil() {
        log.info(DigestUtils.sha256Hex(plainText).toUpperCase());
    }
}