package org.h3270.junit.rules;

import org.apache.log4j.Logger;
import org.junit.rules.ExternalResource;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class UserCredentialsResource extends ExternalResource {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger.getLogger(UserCredentialsResource.class);

	private String username;
	
	private String password;
	
	public UserCredentialsResource() {
		this.username = null;
		this.password = null;
	}
	
	public UserCredentialsResource setUser(String aUsername) {
		this.username = aUsername;
		return this;
	}
	
	public UserCredentialsResource setPassword(String aPassword) {
		this.password = aPassword;
		return this;
	}
	
	/**
	 * Read User / PW from arguments before executing testcase.
	 */
	@Override
	protected void before() throws Throwable {
		String aUser = System.getProperty("host.app.user");
		if ((aUser != null) && (!aUser.contentEquals(""))) {
			this.username = aUser;
			logger.debug("username read from system environment.");
		} 
		if (this.username == null){
			throw new RuntimeException("UserCredentialsResource needs a given username.");
		}
		
		String aPass = System.getProperty("host.app.password");
		if ((aPass != null) && (!aPass.contentEquals(""))) {
			this.password = aPass;
			logger.debug("password read from system environment.");
		} else {
			if (aPass != null) {
				this.password = "";
				logger.warn("UserCredentialsResource is configured with empty password. Maybe you want to define one.");
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public Statement apply(Statement base, Description description) {
		// TODO Auto-generated method stub
		return super.apply(base, description);
	}
	
}
