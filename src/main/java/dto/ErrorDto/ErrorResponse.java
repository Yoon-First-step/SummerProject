package dto.ErrorDto;

import domain.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private String code;
    private String message;
    private List<CustomFieldError> errors;

    public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
        return new ErrorResponse(code.getErrorCode(), code.getErrorMessage(),
                CustomFieldError.from(bindingResult.getFieldErrors()));
    }

    public static ErrorResponse of(final ErrorCode code) {
        return new ErrorResponse(code.getErrorCode(), code.getErrorMessage(), new ArrayList<>());
    }
}

