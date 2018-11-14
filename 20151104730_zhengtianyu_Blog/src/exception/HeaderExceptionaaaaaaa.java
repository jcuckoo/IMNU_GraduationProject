package exception;



/**
 * 异常基类
 *
 * @author luohaidian
 * @date 2018年7月13日
 * @time 下午1:52:33
 */
public abstract class HeaderExceptionaaaaaaa extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public abstract EnumValue<?> getEnumValue();

    protected HeaderExceptionaaaaaaa(String message){
        super(message);
    }

    protected HeaderExceptionaaaaaaa(String message,Throwable cause){
        super(message,cause);
    }

}
