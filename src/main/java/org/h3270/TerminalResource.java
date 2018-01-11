package org.h3270;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.h3270.host.S3270.TerminalMode;
import org.h3270.host.S3270.TerminalType;
import org.junit.rules.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.f3270.Terminal;

/**
 * Create a TerminalResource for JUnit Access.
 *  
 * @author doerges
 *
 */
public class TerminalResource extends ExternalResource {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TerminalResource.class);
	
	/**
	 * Terminal
	 */
	private Terminal driver;
	
	/**
	 * Host-Terminal
	 */
	String host;
	
	/**
	 * Port-Terminal
	 */
	int port;

	TerminalMode mode;
	
	TerminalType type;
	
	boolean showTerminal;
	
	/**
	 * Standard constructor
	 */
	public TerminalResource() {
		host = "";
		port = 0;
	}
	
	/**
	 * FluentInterface: Define host
	 * 
	 * @param aHost
	 * @return
	 */
	public TerminalResource withHost(String aHost) {
		this.host = aHost;
		return this;
	}
	
	/**
	 * FluentInterface: Define port
	 * @param aPort
	 * @return
	 */
	public TerminalResource withPort(int aPort) {
		this.port = aPort;
		return this;
	}
	
	/**
	 * FluentInterface: Define TerminalMode
	 * @param aCodePage
	 * @return
	 */
	public TerminalResource withMode(TerminalMode aMode) {
		this.mode = aMode;
		return this;
	}
	
	/**
	 * FluentInterface: Define Type
	 * @param aType
	 * @return
	 */
	public TerminalResource withType(TerminalType aType) {
		this.type = aType;
		return this;
	}
	
	/**
	 * FluentInterface: Hold connection after TestCase. 
	 * @param aDecision
	 * @return
	 */
	public TerminalResource showTerminalWindow(boolean isVisible) {
		this.showTerminal = isVisible;
		return this;
	}
	
	/**
	 * initialize resource before testcase.
	 */
	@Override
	protected void before() throws Throwable {
		connect();
	}
	
	public void connect() throws Throwable {
        String os = System.getProperty("os.name");
        String s3270Path = "s3270";
        if (os.toLowerCase().contains("windows")) {
            // s3270Path = "s3270/cygwin/s3270";
        	s3270Path = "s3270/client/ws3270";
        }
        this.driver = new Terminal(s3270Path, this.host, this.port, this.type, this.mode, this.showTerminal);
        this.driver.connect();
	}
	
	/**
	 * Clean up resource after testcase.
	 */
	@Override
	protected void after() {
		disconnect();
	}
	
	public void disconnect() {
			this.driver.disconnect();
	}
	
	/**
	 * Get driver instance.
	 * 
	 * @return
	 */
	public Terminal getDriver() {
		return this.driver;
	}
}
