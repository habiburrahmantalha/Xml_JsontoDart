package com.example.talhaaits.jsonparsing;

import android.support.annotation.Nullable;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.TextContent;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class Guid{
	@Nullable
	@TextContent
	 String text;
	@Nullable
	@Attribute
	 boolean isPermaLink;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setIsPermaLink(boolean isPermaLink){
		this.isPermaLink = isPermaLink;
	}

	public boolean getIsPermaLink(){
		return isPermaLink;
	}

	@Override
 	public String toString(){
		return 
			"Guid{" + 
			"#text = '" + text + '\'' + 
			",@isPermaLink = '" + isPermaLink + '\'' + 
			"}";
		}
}
