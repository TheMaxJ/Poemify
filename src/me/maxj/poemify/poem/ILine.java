package me.maxj.poemify.poem;

import me.maxj.poemify.ComplexSentence;

public interface ILine {
	public String getLineString();
	public String getOriginalString();
	public void setText(String s);
	public ComplexSentence getComplex();
	public void updateStringFromComplex();
}
