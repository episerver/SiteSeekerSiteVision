package siteseeker.search;

import java.io.Serializable;


public class SortOrder implements Serializable {

    public static final long serialVersionUID = 1L;

    private String name;
    private int id;
    private boolean isSelected;
    private String clickUrl;

    public SortOrder(String name, int id, boolean isSelected, String clickUrl) {
	this.name = name;
	this.id = id;
	this.isSelected = isSelected;
	this.clickUrl = clickUrl;
    }
    
    public int getId() {
	return id;
    }
    public String getName() {
	return name;
    }
    public String getClickUrl() {
	return clickUrl; 
    }
    public boolean getIsSelected() {
	return isSelected; 
    }
}

