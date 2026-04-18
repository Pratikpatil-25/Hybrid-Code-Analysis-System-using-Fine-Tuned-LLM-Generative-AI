package gov.nist.javax.sip.header;
import gov.nist.core.*;


public class Credentials extends SIPObject {

	private static String DOMAIN = ParameterNames.DOMAIN;
	private static String REALM = ParameterNames.REALM;
	private static String OPAQUE = ParameterNames.OPAQUE;
	private static String RESPONSE = ParameterNames.RESPONSE;
	private static String URI = ParameterNames.URI;
	private static String NONCE = ParameterNames.NONCE;
	private static String CNONCE = ParameterNames.CNONCE;
	private static String USERNAME = ParameterNames.USERNAME;

	private static final long serialVersionUID = 1L;
	
	protected String scheme;

	
	protected NameValueList parameters;

	
	public Credentials() {
		parameters = new NameValueList();
		parameters.setSeparator(COMMA);
	}

	
	public NameValueList getCredentials() {
		return parameters;
	}

	
	public String getScheme() {
		return scheme;
	}

	
	public void setScheme(String s) {
		scheme = s;
	}

	
	public void setCredentials(NameValueList c) {
		parameters = c;
	}

	public String encode() {
		String retval = scheme;
		if (!parameters.isEmpty()) {
			retval += SP + parameters.encode();
		}
		return retval;
	}

	public void setCredential(NameValue nameValue) {
		if (nameValue.getName().compareToIgnoreCase(URI) == 0)
			nameValue.setQuotedValue();
		else if (nameValue.getName().compareToIgnoreCase(NONCE) == 0)
			nameValue.setQuotedValue();
		else if (nameValue.getName().compareToIgnoreCase(REALM) == 0)
			nameValue.setQuotedValue();
		else if (nameValue.getName().compareToIgnoreCase(CNONCE) == 0)
			nameValue.setQuotedValue();
		else if (nameValue.getName().compareToIgnoreCase(RESPONSE) == 0)
			nameValue.setQuotedValue();
		else if (nameValue.getName().compareToIgnoreCase(OPAQUE) == 0)
			nameValue.setQuotedValue();
		else if (nameValue.getName().compareToIgnoreCase(USERNAME) == 0)
			nameValue.setQuotedValue();
		else if (nameValue.getName().compareToIgnoreCase(DOMAIN) == 0)
			nameValue.setQuotedValue();
		parameters.set(nameValue);
	}

	public Object clone() {
		Credentials retval = (Credentials) super.clone();
		if (this.parameters != null)
			retval.parameters = (NameValueList) this.parameters.clone();
		return retval;
	}
}