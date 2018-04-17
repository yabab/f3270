package com.github.vebqa;

/**
 * Defines the host code page, used by the terminal emulator.
 * 
 * @author kdoerges
 *
 */
public enum HostCharset {
	
	BELGIAN("belgian", "500"),
	BELGIAN_EURO("belgian-euro", "1148"),
	BRACKET("bracket", "037"),
	BRAZILIAN("brazilian", "275"),
	CHINESE_GB18030("chinese-gb18030", "1388"),
	CP1047("cp1047", "1047"),
	CP870("cp870", "870"),
	FINNISH("finnish", "278"),
	FINNISH_EURO("finnish-euro", "1143"),
	FRENCH("french", "297"),
	FRENCH_EURO("french-euro", "1147"),
	GERMAN("german", "273"),
	GERMAN_EURO("german-euro", "1141"),
	GREEK("greek", "423"),
	HEBREW("hebrew", "424"),
	ICELANDIC("icelandic", "871"),
	ICELANDIC_EURO("icelandic-euro", "1149"),
	ITALIAN("italian", "280"),
	ITALIEN_EURO("italian-euro", "1144"),
	JAPANESE_KANA("japanese-kana", "930"),
	JAPANESE_LATIN("japanese-latin", "938"),
	NORWEGIAN("norwegian", "277"),
	NORWEGIAN_EURO("norwegian-euro", "1142"),
	RUSSIAN("russian", "880"),
	SIMPLIFIED_CHINESE("simplified-chinese", "935"),
	SLOVENIAN("slovenian", "870"),
	SPANISH("spanish", "284"),
	SPANISH_EURO("spanish-euro", "1145"),
	SWEDISH("swedish", "278"),
	SWEDISH_EURO("swedish-euro", "1143"),
	THAI("thai", "1160"),
	TRADITIONAL_CHINESE("traditional-chinese", "937"),
	TURKISH("turkish", "1026"),
	UK("uk", "285"),
	UK_EURO("uk-euro", "1146"),
	US_EURO("us-euro", "1140"),
	US_INTL("us-intl", "037");

	private String charsetName;
	private String hostCodePage;
	
	private HostCharset(String aCharsetName, String aHostCodePage) {
		this.charsetName = aCharsetName;
		this.hostCodePage = aHostCodePage;
	}
	
	public String getCharsetName() {
		return this.charsetName;
	}
	
	public String getHostCodePage() {
		return this.hostCodePage;
	}
}
