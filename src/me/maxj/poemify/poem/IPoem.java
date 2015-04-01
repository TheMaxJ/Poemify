package me.maxj.poemify.poem;

import java.util.List;

public interface IPoem {
	public ILineFilter getLineFilter();
	public List<ILine> getLines();	
	public void read(List<String> strings);
}
