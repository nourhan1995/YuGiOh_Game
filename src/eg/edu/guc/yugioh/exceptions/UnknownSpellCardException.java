package eg.edu.guc.yugioh.exceptions;

public class UnknownSpellCardException extends UnexpectedFormatException {
	
	private String unknownSpell = "";
	
	public UnknownSpellCardException(String sourceFile, int sourceLine, String unknownSpell){
		super(sourceFile, sourceLine);
		this.unknownSpell = unknownSpell;
	}
	
	public UnknownSpellCardException(String m){
		super(m);
	}
	
	public String getMessage(){
		return "This spell card is unknown";
	}

	public String getUnknownSpell() {
		return unknownSpell;
	}

	public void setUnknownSpell(String unknownSpell) {
		this.unknownSpell = unknownSpell;
	}
		
}
