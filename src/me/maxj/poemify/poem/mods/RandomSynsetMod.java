package me.maxj.poemify.poem.mods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.smu.tspell.wordnet.Synset;
import me.maxj.poemify.poem.ILine;
import me.maxj.poemify.poem.line.Line;

public class RandomSynsetMod extends SynsetMod {
	
	private int freq;
	
	public static void main(String[] args) {
		ILine line = new Line("This is a test line so I can test the thing");
		List<ILine> test = new ArrayList<>();
		test.add(line);
		test = new RandomSynsetMod(test, 10).filter();
		test.forEach((ln)->System.out.println(ln.getLineString()));
	}
	
	public RandomSynsetMod(List<ILine> lines, int freq) {
		super(lines);
		this.freq = freq-1;
	}

	@Override
	public List<ILine> filter() {
		for (ILine line : this.getLines()) {
			String[] words = line.getLineString().split(" ");
			String ln = "";
			for (int i = 0; i < words.length; i++) {
				if (new Random().nextInt(100) < freq) {
					words[i] = getRandomWordForm(this.getSynsets(words[i]));
				}
				ln += words[i] + " ";
			}
			line.setText(ln);
		}
		return this.getLines();
	}
	
	public String getRandomWordForm(Synset[] synsets) {
		Synset synset = synsets[new Random().nextInt(synsets.length)];
		return synset.getWordForms()[new Random().nextInt(synset.getWordForms().length)];
	}
}
