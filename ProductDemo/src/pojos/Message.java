package pojos;

/**
 * Created by Anonymous on 2018/1/21.
 */
public class Message {

    private String status = "";
    private String code = "";
    private String success = "";
    private String error = "";

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

}
