package net.sf.f3270;

public enum TerminalModel {
	
	MODE_80_24(2), 
	MODE_80_32(3), 
	MODE_80_43(4), 
	MODE_132_27(5);
	
	private int model;

	private TerminalModel(int mode) {
		this.model = mode;
	}

	public int getMode() {
		return this.model;
	}
}
