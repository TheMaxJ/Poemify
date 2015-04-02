package me.maxj.poemify.wordnet;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetException;
import edu.smu.tspell.wordnet.WordSense;

public class SingleSynset implements Synset {

	private String word;
	
	public SingleSynset(String s) {
		this.word = s;
	}
	
	public static Synset[] toSynset(String word) {
		return new Synset[]{new SingleSynset(word)};
	}
	
	@Override
	public String[] getWordForms() {
		return new String[]{word};
	}

	@Override
	public WordSense[] getAntonyms(String arg0) throws WordNetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WordSense[] getDerivationallyRelatedForms(String arg0) throws WordNetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTagCount(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SynsetType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getUsageExamples() {
		// TODO Auto-generated method stub
		return null;
	}

}
