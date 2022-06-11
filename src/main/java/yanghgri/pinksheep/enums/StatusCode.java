package yanghgri.pinksheep.enums;

import lombok.Getter;

public enum StatusCode {
    OK(200), UNDEFINED(500);

    @Getter
    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public enum DATA_NOT_EXIST {

        NOT_EXIST_USER(401);
        @Getter
        private final int code;

        DATA_NOT_EXIST(int code) {
            this.code = code;
        }
    }

    public enum INVALID_PARAMETER {
        WRONG_USER_PASSWORD(402);

        @Getter
        private final int code;

        INVALID_PARAMETER(int code) {
            this.code = code;
        }
    }
}