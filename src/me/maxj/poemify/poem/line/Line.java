package me.maxj.poemify.poem.line;

import me.maxj.poemify.poem.ILine;

public class Line implements ILine{

	private String originaltext;
	private String text;
	
	public Line(String string) {
		originaltext = string;
		text = string;
	}
	
	@Override
	public String getLineString() {
		return text;
	}

	@Override
	public String getOriginalString() {
		return originaltext;
	}
	
	@Override
	public void setText(String s) {
		text = s;
	}

}
