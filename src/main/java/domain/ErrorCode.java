package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500,"G001", "서버오류"),
    INPUT_INVALID_VALUE(400, "G002", "잘못된 입력");

    private final int status;
    private final String code;
    private final String message;

    public String getErrorCode(){
        return code;
    }
    public String getErrorMessage(){
        return message;
    }

}
