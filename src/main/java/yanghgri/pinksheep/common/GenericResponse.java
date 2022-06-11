package yanghgri.pinksheep.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenericResponse {
    private final String message;
    private final int statusCode;
    private final Object data;
}