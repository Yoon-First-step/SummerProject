package dto.ErrorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;


import java.util.List;

@Getter
@AllArgsConstructor
public class CustomFieldError {
    private String field;
    private String rejectedValue;
    private String reason;

    public static CustomFieldError from(FieldError error) {
        return new CustomFieldError(
                error.getField(),
                error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                error.getDefaultMessage()
        );
    }

    public static List<CustomFieldError> from(List<FieldError> errors) {
        return errors.stream().map(CustomFieldError::from).toList();
    }
}
