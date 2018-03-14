package net.sf.f3270.junit.rules;

import org.h3270.host.S3270.TerminalMode;
import org.h3270.host.S3270.TerminalType;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import net.sf.f3270.UnitTests;

public class TerminalResourceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public final TerminalResource terminal = new TerminalResource().withHost("127.0.0.1").withPort(23)
			.withMode(TerminalMode.MODE_80_24).withType(TerminalType.TYPE_3279).showTerminalWindow(true).setDebug(true);

	@Ignore
	@Category(UnitTests.class)
	@Test(expected = RuntimeException.class)
	public void testTerminalResourceSettings() {
	}
}
