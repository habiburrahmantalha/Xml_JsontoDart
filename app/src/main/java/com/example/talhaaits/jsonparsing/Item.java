package com.example.talhaaits.jsonparsing;

import android.support.annotation.Nullable;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.TextContent;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "item")
public class Item {
	@Nullable
	@PropertyElement(name = "dc:creator")
	 String creator;
	@Nullable
	@PropertyElement
	 String thumbnail;
	@Nullable
	@Element(name = "embeddedCode")
	EmbeddedCode embeddedCode;
	@Nullable
	@PropertyElement
	 String link;
	@Nullable
	@PropertyElement
	 String description;
	@Nullable
	@Element
	 Guid guid;
    @Nullable
	@PropertyElement
	 String title;
    @Nullable
	@PropertyElement
	 String category;
    @Nullable
	@PropertyElement
	 String pubDate;

	public void setCreator(String creator){
		this.creator = creator;
	}

	public String getCreator(){
		return creator;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setEmbeddedCode(EmbeddedCode embeddedCode){
		this.embeddedCode = embeddedCode;
	}

	public EmbeddedCode getEmbeddedCode(){
		return embeddedCode;
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

	public void setGuid(Guid guid){
		this.guid = guid;
	}

	public Guid getGuid(){
		return guid;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setPubDate(String pubDate){
		this.pubDate = pubDate;
	}

	public String getPubDate(){
		return pubDate;
	}

	@Override
 	public String toString(){
		return 
			"Item{" +
			"creator = '" + creator + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",embeddedCode = '" + embeddedCode + '\'' + 
			",link = '" + link + '\'' + 
			",description = '" + description + '\'' + 
			",guid = '" + guid + '\'' + 
			",title = '" + title + '\'' + 
			",category = '" + category + '\'' + 
			",pubDate = '" + pubDate + '\'' + 
			"}";
		}
}
