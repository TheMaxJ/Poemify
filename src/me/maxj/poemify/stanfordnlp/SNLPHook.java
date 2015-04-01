package me.maxj.poemify.stanfordnlp;

import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.BasicDependenciesAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class SNLPHook {
	public static StanfordCoreNLP pipeline;
	
	static {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref, sentiment");
		pipeline = new StanfordCoreNLP(props);	
	}
	
	public static void main(String[] args) {
		// Test Stuff Goes here
	}
	
	public static SemanticGraph getSemanticGraph(String sentence) {
		Annotation document = new Annotation(sentence);
		pipeline.annotate(document);
		for (CoreMap map : document.get(SentencesAnnotation.class)) {
			return map.get(BasicDependenciesAnnotation.class);
		}
		return null;
	}

}
