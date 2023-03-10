package SSM.bean;

public class BaseResult {

    private Boolean status;
    private String message;

    public BaseResult() {
    }

    public BaseResult(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
