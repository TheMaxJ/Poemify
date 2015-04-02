package me.maxj.poemify.poem.mods;

import java.util.List;

import me.maxj.poemify.poem.ILine;

public abstract class WordLengthMod extends LengthMod {

	public WordLengthMod(List<ILine> lines, int maxlength) {
		super(lines, maxlength);
	}
	
	public int getLineLength(ILine line) {
		return line.getComplex().getWords().size();
	}

}
