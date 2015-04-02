package me.maxj.poemify.poem.line;

import java.util.List;
import java.util.Random;

import edu.smu.tspell.wordnet.Synset;
import me.maxj.poemify.ComplexSentence;
import me.maxj.poemify.poem.ILine;
import me.maxj.poemify.wordnet.WordNetHook;

public class SentenceBasedSynsetLine implements ILine {
	
	private String originaltext;
	private List<Synset[]> synsets;
	
	public static void main(String[] args) {
		SentenceBasedSynsetLine line = new SentenceBasedSynsetLine("Johnny went to pick a peck of peppers");
		System.out.println(line.getOriginalString());
		System.out.println(line.getLineString());
	}
	
	public SentenceBasedSynsetLine(String sentence) {
		this.originaltext = sentence;
		this.synsets = WordNetHook.getPhraseSynsets(sentence);
	}
	
	private String flatten() {
		String ret = "";
		for (Synset[] synarr : synsets) {
			ret += flatten(synarr) + " ";
		}
		return ret.trim();
	}
	
	private String flatten(Synset[] synarr) {
		Synset synset = synarr[new Random().nextInt(synarr.length)];
		return synset.getWordForms()[new Random().nextInt(synset.getWordForms().length)];
	}

	@Override
	public String getLineString() {
		return flatten();
	}

	@Override
	public String getOriginalString() {
		return originaltext;
	}

	@Override
	public void setText(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ComplexSentence getComplex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStringFromComplex() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
