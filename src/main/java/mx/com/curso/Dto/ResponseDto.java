package mx.com.curso.Dto;

public class ResponseDto {

	private Object content;
	private Integer code;
	private String message;
	
	
	public ResponseDto() {
		
	}
	
	public ResponseDto(Object content, Integer code, String message) {
		this.content = content;
		this.code = code;
		this.message = message;
	}

	public ResponseDto(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
