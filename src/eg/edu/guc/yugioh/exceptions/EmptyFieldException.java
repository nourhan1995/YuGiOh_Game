package eg.edu.guc.yugioh.exceptions;

public class EmptyFieldException extends UnexpectedFormatException{
	
	private int sourceField = 0;
	
	public EmptyFieldException (String sourceFile, int sourceLine, int sourceField){
		super(sourceFile, sourceLine);
		this.sourceField = sourceField;
	}
	public EmptyFieldException(String m){
		super(m);
	}
	
	public String getMessage(){
		return "This file has an empty field";
	}

	public int getSourceField() {
		return sourceField;
	}

	public void setSourceField(int sourceField) {
		this.sourceField = sourceField;
	}
	

}
