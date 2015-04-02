package me.maxj.poemify;

import java.util.List;

import me.maxj.poemify.stanfordnlp.SNLPHook;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class ComplexSentence {
	
	private String original;
	private SemanticGraph structure;
	private List<ComplexWord> words;
	
	public ComplexSentence(String sentence) {
		this.original = sentence;
		this.structure = SNLPHook.getSemanticGraph(sentence);
		for (CoreLabel label : SNLPHook.getWords(sentence)) {
			IndexedWord word = structure.getNodeByIndex(label.index());
			SemanticGraphEdge edge = structure.getEdge(structure.getParent(word), word);
			ComplexWord complex = new ComplexWord(word.word(), edge.getRelation().toString(), word.index());
			words.add(complex);
		}
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public SemanticGraph getStructure() {
		return structure;
	}

	public void setStructure(SemanticGraph structure) {
		this.structure = structure;
	}

	public List<ComplexWord> getWords() {
		return words;
	}

	public void setWords(List<ComplexWord> words) {
		this.words = words;
	}
		
}
