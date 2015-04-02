package me.maxj.poemify.poem.linefilter;

import java.util.ArrayList;
import java.util.List;

import me.maxj.poemify.poem.ILine;
import me.maxj.poemify.poem.ILineFilter;
import me.maxj.poemify.poem.line.SentenceBasedSynsetLine;
import me.maxj.poemify.stanfordnlp.SNLPHook;

public class SentenceBasedLineFilter implements ILineFilter {
	
	private List<String> sentences;
	
	public static void main(String[] args) {
		List<String> test_strings = new ArrayList<String>();
		test_strings.add("I went to the store. I bought some milk! I love milk");
		test_strings.add("Then I went home. But I don't like being at home.");
		for (ILine line : new SentenceBasedLineFilter(test_strings).getLines()) {
			System.out.println(line.getLineString());
		}
	}
	
	public SentenceBasedLineFilter(List<String> strings) {
		this.sentences = SNLPHook.getSentences(strings);
	}

	@Override
	public List<ILine> getLines() {
		List<ILine> lines = new ArrayList<ILine>();
		for (String s : sentences) {
			lines.add(new SentenceBasedSynsetLine(s));
		}
		return lines;
	}
	
	
	
}
