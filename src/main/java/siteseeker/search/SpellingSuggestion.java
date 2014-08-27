package siteseeker.search;

import java.io.Serializable;

public class SpellingSuggestion implements Serializable {

    public static final long serialVersionUID = 1L;

    private String terms;
    private String termsNoFormatting;
    private String clickUrl;

    public SpellingSuggestion(String terms, String termsNoFormatting, String clickUrl) {
	this.terms = terms;
	this.termsNoFormatting = termsNoFormatting;
	this.clickUrl = clickUrl;
    }

    public String getTerms() { return terms; }
    public String getTermsNoFormatting() { return termsNoFormatting; }
    public String getRequestUrl() { return clickUrl; }

}
