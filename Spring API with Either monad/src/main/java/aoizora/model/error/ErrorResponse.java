package aoizora.model.error;

public class ErrorResponse {
    private int code;

    public ErrorResponse() {
    }

    public ErrorResponse(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
