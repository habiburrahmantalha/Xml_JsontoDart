package com.example.talhaaits.jsonparsing;

import android.support.annotation.Nullable;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.TextContent;
import com.tickaroo.tikxml.annotation.Xml;

@Xml (name="rss")
public class Rss{
	@Nullable
	@Attribute(name="xmlns:dc")
	 String xmlnsDc;
	@Nullable
	@Attribute(name="xmlns:content")
	 String xmlnsContent;
	@Nullable
	@Attribute(name="xmlns:atom")
	 String xmlnsAtom;
	@Nullable
	@Attribute
	 String version;
	@Nullable
	@Element
	 Channel channel;

	public void setXmlnsDc(String xmlnsDc){
		this.xmlnsDc = xmlnsDc;
	}

	public String getXmlnsDc(){
		return xmlnsDc;
	}

	public void setXmlnsContent(String xmlnsContent){
		this.xmlnsContent = xmlnsContent;
	}

	public String getXmlnsContent(){
		return xmlnsContent;
	}

	public void setXmlnsAtom(String xmlnsAtom){
		this.xmlnsAtom = xmlnsAtom;
	}

	public String getXmlnsAtom(){
		return xmlnsAtom;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	public void setChannel(Channel channel){
		this.channel = channel;
	}

	public Channel getChannel(){
		return channel;
	}

	@Override
 	public String toString(){
		return 
			"Rss{" + 
			"-xmlns:dc = '" + xmlnsDc + '\'' + 
			",-xmlns:content = '" + xmlnsContent + '\'' + 
			",-xmlns:atom = '" + xmlnsAtom + '\'' + 
			",-version = '" + version + '\'' + 
			",channel = '" + channel + '\'' + 
			"}";
		}
}
