package eg.edu.guc.yugioh.exceptions;

public class MissingFieldException extends UnexpectedFormatException {

	public MissingFieldException(String sourceFile, int sourceLine) {
		super(sourceFile, sourceLine);
		// TODO Auto-generated constructor stub
	}
	
	public MissingFieldException(String m){
		super(m);
	}
	
	public String getMessage(){
		return "This file has a missing field in the path " + getSourceFile() + " in the line number " + getSourceLine();
	}

}
