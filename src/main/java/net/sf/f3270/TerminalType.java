package net.sf.f3270;

public enum TerminalType {
	
	TYPE_3278("3278"), 
	TYPE_3279("3279");
	
	private String type;

	private TerminalType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
