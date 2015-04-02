package me.maxj.poemify.poem.mods;

import java.util.List;

import me.maxj.poemify.poem.ILine;
import me.maxj.poemify.poem.IMod;

public abstract class Mod implements IMod {
	
	private List<ILine> lines;
	
	public Mod(List<ILine> lines) {
		this.lines = lines;
	}
	
	protected List<ILine> getLines() {
		return this.lines;
	}
	
	protected void setLines(List<ILine> lines) {
		this.lines = lines;
	}
	
	@Override
	public abstract List<ILine> filter();

}
