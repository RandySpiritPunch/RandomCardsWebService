package org.card.random.exception;

public class ErrorResource {
    private String code;
    private String message;
    private String url;

    public ErrorResource() { }

    public ErrorResource(String code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}