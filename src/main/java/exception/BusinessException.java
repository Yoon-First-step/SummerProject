package exception;

import domain.ErrorCode;
import lombok.Getter;


@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public String getErrorMessage(){
        return super.getMessage();
    }
}
