package net.sf.f3270.musicsp;

import org.h3270.TerminalResource;
import org.h3270.host.S3270.TerminalMode;
import org.h3270.host.S3270.TerminalType;
import org.junit.Rule;
import org.junit.Test;

import net.sf.f3270.FieldIdentifier;

public class MusicTest {

	@Rule
	public final TerminalResource terminal = new TerminalResource().withHost("127.0.0.1").withPort(623)
			.withMode(TerminalMode.MODE_80_24).withType(TerminalType.TYPE_3279).showTerminalWindow(true);

	@Test
	public void logInAndOutToMusic() {
		
		terminal.getDriver().enter();
		terminal.getDriver().write(new FieldIdentifier("MUSIC Userid:"), "$000");
		terminal.getDriver().write(new FieldIdentifier("Password:"), "music");
		terminal.getDriver().enter();
		terminal.getDriver().enter();
		terminal.getDriver().pf(3);
	}

}
