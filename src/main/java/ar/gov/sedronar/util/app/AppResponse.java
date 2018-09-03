package ar.gov.sedronar.util.app;

public class AppResponse {
	public static Integer SUCCESS = 200;
	public static Integer ERROR = -1;

	protected int code;
	protected String message;
	protected Object data;

	public AppResponse() {
		super();
		this.code = AppResponse.SUCCESS;
	}

	public AppResponse(Object data) {
		super();
		this.data = data;
		this.code = AppResponse.SUCCESS;
	}

	public AppResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public AppResponse(int code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}

	public AppResponse(int code, String message, Object data) {
		super();
		this.data = data;
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
