package me.maxj.poemify.poem.line;

import me.maxj.poemify.ComplexSentence;
import me.maxj.poemify.ComplexWord;
import me.maxj.poemify.poem.ILine;

public class Line implements ILine{

	private String originaltext;
	private String text;
	private ComplexSentence complex;
	
	public Line(String string) {
		originaltext = string;
		text = string;
		complex = new ComplexSentence(string);
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
	
	@Override
	public ComplexSentence getComplex() {
		return complex;
	}

	@Override
	public void updateStringFromComplex() {
		String s = "";
		for (ComplexWord word : this.complex.getWords()) {
			s += word.getOriginal() + " ";
		}
		text = s.trim();
	}

}
