package me.maxj.poemify.wordnet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class WordNetHook {
	
	private static WordNetDatabase wndb;
	
	private static final Pattern puncPat = Pattern.compile("[^\\w\\s]");
	
	public static void main(String[] args) {
		// Test stuff goes here
	}
	
	static {
		System.setProperty("wordnet.database.dir", "/usr/local/WordNet-3.0/dict");
		wndb = WordNetDatabase.getFileInstance();
	}
	
	public static Synset[] getWordSynsets(String word) {
		word = word.trim();
		return wndb.getSynsets(word);
	}
	
	public static List<Synset[]> getPhraseSynsets(String phrase) {
		List<Synset[]> ret = new ArrayList<>();
		phrase = puncPat.matcher(phrase).replaceAll("");
		String[] words = phrase.split(" ");
		for (String word : words) {
			ret.add(getWordSynsets(word));
		}
		return ret;
	}
}
