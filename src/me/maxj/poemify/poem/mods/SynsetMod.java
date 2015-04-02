package me.maxj.poemify.poem.mods;

import java.util.List;

import edu.smu.tspell.wordnet.Synset;
import me.maxj.poemify.poem.ILine;
import me.maxj.poemify.wordnet.WordNetHook;

public abstract class SynsetMod extends Mod {

	public SynsetMod(List<ILine> lines) {
		super(lines);
	}
	
	protected Synset[] getSynsets(String word) {
		return WordNetHook.getWordSynsets(word);
	}
	
}
