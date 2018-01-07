package net.sf.f3270;

import org.junit.Test;

public class MusicTest extends IntegrationTestBase {

	@Override
	protected Mode getMode() {
		return Mode.DIRECT;
	}

	@Override
	protected String getHostname() {
		return "localhost";
	}
	
	@Override
	protected int getPort() {
		return 623;
	}
	
	@Test
	public void logInAndOutToMusic() {
		connect();
		terminal.enter();
		terminal.write(new FieldIdentifier("MUSIC Userid:"), "$000");
		terminal.write(new FieldIdentifier("Password:"), "music");
		terminal.enter();
		terminal.enter();
		terminal.pf(3);
		
		disconnect();
	}

}
