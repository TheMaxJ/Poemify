package me.maxj.poemify.poem.mods;

import java.util.List;

import me.maxj.poemify.poem.ILine;

public abstract class LengthMod extends Mod {
	
	private int maxlength;
	
	public LengthMod(List<ILine> lines, int maxlength) {
		super(lines);
		this.maxlength = maxlength;
	}
	
	public int getMaxLength() {
		return maxlength;
	}
	
}
