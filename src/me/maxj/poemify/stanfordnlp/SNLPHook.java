package me.maxj.poemify.stanfordnlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
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
	}
	
	public static List<CoreLabel> getWords(String sentence) {
		Annotation document = new Annotation(sentence);
		pipeline.annotate(document);
		return document.get(TokensAnnotation.class);
	}
	
	public static SemanticGraph getSemanticGraph(String sentence) {
		Annotation document = new Annotation(sentence);
		pipeline.annotate(document);
		for (CoreMap map : document.get(SentencesAnnotation.class)) {
			return map.get(BasicDependenciesAnnotation.class);
		}
		return null;
	}
	
	public static List<String> getSentences(List<String> strings) {
		String text = "";
		for (String s : strings) {
			text += s + " ";
		}
		return getSentences(text.trim());
	}
	
	public static List<String> getSentences(String text) {
		Annotation document = new Annotation(text);
		pipeline.annotate(document);
		List<String> sentences = new ArrayList<String>();
		for (CoreMap map : document.get(SentencesAnnotation.class)) {
			sentences.add(map.get(TextAnnotation.class));
		}
		return sentences;
	}

}
