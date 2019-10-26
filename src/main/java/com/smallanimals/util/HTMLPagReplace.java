package com.smallanimals.util;

public class HTMLPagReplace {

	public String HTMLPagReplaceAll(String content) {
		content.replaceAll("<p>", "").replaceAll("</p>", "");
		
		return content;
	}
}
