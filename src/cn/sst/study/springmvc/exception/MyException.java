package cn.sst.study.springmvc.exception;

public class MyException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionMsg;
    
    
	/**
	 * 
	 */
	public MyException() {
		super();
	}


	/**
	 * @param exceptionMsg
	 */
	public MyException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}


	public String getExceptionMsg() {
		return exceptionMsg;
	}

    public String getMessage(){
    	return exceptionMsg;
    }
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	
    
}
