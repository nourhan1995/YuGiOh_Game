package eg.edu.guc.yugioh.exceptions;

public class UnknownCardTypeException extends UnexpectedFormatException{

	private String unknownType;
	
	public UnknownCardTypeException(String sourceFile, int sourceLine, String unknownType) {
		super(sourceFile, sourceLine);
		this.unknownType = unknownType;
		// TODO Auto-generated constructor stub
	}
	
	public UnknownCardTypeException(String m){
		super(m);
	}
	
	public String getMessage(){
		return "This card type is unknown";
	}

	public String getUnknownType() {
		return unknownType;
	}

	public void setUnknownType(String unknownType) {
		this.unknownType = unknownType;
	}
	
}
