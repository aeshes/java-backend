package aoizora.controller;

import aoizora.model.error.ErrorResponse;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController {

    protected <T> ResponseEntity<T> toResponse(T body) {
        return ResponseEntity.ok(body);
    }

    protected <T extends ErrorResponse> ResponseEntity<T> toErrorResponse(T error) {
        return ResponseEntity.status(error.getCode())
                .body(error);
    }
}
