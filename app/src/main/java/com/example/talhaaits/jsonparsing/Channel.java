package com.example.talhaaits.jsonparsing;

import android.support.annotation.Nullable;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;
@Xml(name = "channel")
public class Channel{
	@Nullable
	@PropertyElement
	 String copyright;
	@Nullable
	@Element
	 List<Item> item;
	@Nullable
	@PropertyElement
	 String lastBuildDate;
	@Nullable
	@PropertyElement
	 String link;
	@Nullable
	@PropertyElement
	 String description;
	@Nullable
	@PropertyElement
	 String generator;
	@Nullable
	@PropertyElement
	 String language;
	@Nullable
	@PropertyElement
	 String title;
	@Nullable
	@PropertyElement
	 String managingEditor;
	@Nullable
	@Element
	 List<CategoryItem> category;
	@Nullable
	@PropertyElement
	 String pubDate;
	@Nullable
	@PropertyElement
	 String webMaster;

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setItem(List<Item> item){
		this.item = item;
	}

	public List<Item> getItem(){
		return item;
	}

	public void setLastBuildDate(String lastBuildDate){
		this.lastBuildDate = lastBuildDate;
	}

	public String getLastBuildDate(){
		return lastBuildDate;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setGenerator(String generator){
		this.generator = generator;
	}

	public String getGenerator(){
		return generator;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setManagingEditor(String managingEditor){
		this.managingEditor = managingEditor;
	}

	public String getManagingEditor(){
		return managingEditor;
	}

	public void setCategory(List<CategoryItem> category){
		this.category = category;
	}

	public List<CategoryItem> getCategory(){
		return category;
	}

	public void setPubDate(String pubDate){
		this.pubDate = pubDate;
	}

	public String getPubDate(){
		return pubDate;
	}

	public void setWebMaster(String webMaster){
		this.webMaster = webMaster;
	}

	public String getWebMaster(){
		return webMaster;
	}

	@Override
 	public String toString(){
		return 
			"Channel{" + 
			"copyright = '" + copyright + '\'' + 
			",item = '" + item + '\'' + 
			",lastBuildDate = '" + lastBuildDate + '\'' + 
			",link = '" + link + '\'' + 
			",description = '" + description + '\'' + 
			",generator = '" + generator + '\'' + 
			",language = '" + language + '\'' + 
			",title = '" + title + '\'' + 
			",managingEditor = '" + managingEditor + '\'' + 
			",category = '" + category + '\'' +
			",pubDate = '" + pubDate + '\'' + 
			",webMaster = '" + webMaster + '\'' + 
			"}";
		}
}