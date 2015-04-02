package me.maxj.poemify;

import me.maxj.poemify.wordnet.WordNetHook;
import edu.smu.tspell.wordnet.Synset;

public class ComplexWord {
	
	private String original;
	private Synset[] synsets;
	private String pos;
	private int index;
	
	public ComplexWord(String word, String pos, int index) {
		this.original = word;
		this.pos = pos;
		this.index = index;
		this.synsets = WordNetHook.getWordSynsets(word);
		
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public Synset[] getSynsets() {
		return synsets;
	}

	public void setSynsets(Synset[] synsets) {
		this.synsets = synsets;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
