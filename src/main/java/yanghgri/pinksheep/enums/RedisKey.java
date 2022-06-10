package yanghgri.pinksheep.enums;

import lombok.Getter;

public enum RedisKey {
    UNAVAILABLE_USER("unavailable_user");
    @Getter
    private final String key;

    RedisKey(String key) {
        this.key = key;
    }
}
