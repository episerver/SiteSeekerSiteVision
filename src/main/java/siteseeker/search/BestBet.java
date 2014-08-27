package siteseeker.search;

import java.io.Serializable;
import java.util.List;

public class BestBet implements Serializable {
    public static final long serialVersionUID = 1L;
    private siteseeker.ws.Bet wsBet;
    private SearchFilter language;
    public BestBet(siteseeker.ws.Bet wsBet) {
	this.wsBet = wsBet;
    }
    public int getNumber() {
	return wsBet.getBetNr() + 1;
    }
    public String getTitle() {
	if (wsBet.getTitle() != null)
	    return wsBet.getTitle();
	return "";
    }
    public String getTitleNoFormatting() {
	return getTitle().replaceAll("\\<.*?\\>", "");
    }
    public String getDescription() {
        return wsBet.getDescription();
    }
    public String getUrl() {
	return wsBet.getUrl();
    }
    public List<String> getKeywords() {
        return wsBet.getKeywords();
    }
    public SearchFilter getLanguage() {
        return language;
    }
    public void setLanguage(SearchFilter language) {
        this.language = language;
    }
    public int getLanguageId() {
        return wsBet.getLangId();
    }
    public boolean getIsExternal() {
        return wsBet.isIsExternal();
    }
}

    
 