package net.sf.f3270;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestHostCharset {

	@Category(UnitTests.class)
	@Test
	public void resolveGermanCharset() {
		HostCharset charset = HostCharset.valueOf("GERMAN");
		assertThat(charset.getCharsetName(), equalTo("german"));
		assertThat(charset.getHostCodePage(), equalTo("273"));
	}
	
	@Category(UnitTests.class)
	@Test
	public void resolveGermanEuroCharset() {
		HostCharset charset = HostCharset.valueOf("GERMAN_EURO");
		assertThat(charset.getCharsetName(), equalTo("german-euro"));
		assertThat(charset.getHostCodePage(), equalTo("1141"));
	}

}
