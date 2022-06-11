package yanghgri.pinksheep.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenericException extends Exception {
    private final String message;
    private final int statusCode;
}
