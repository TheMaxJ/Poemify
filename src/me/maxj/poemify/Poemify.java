package me.maxj.poemify;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import me.maxj.poemify.poem.ILine;
import me.maxj.poemify.poem.ILineFilter;
import me.maxj.poemify.poem.linefilter.SentenceBasedLineFilter;
import me.maxj.poemify.poem.mods.RandomSynsetMod;
import me.maxj.poemify.poem.mods.SynsetMod;

public class Poemify {
	static String test_source = "/Users/maxjohnson/Documents/School/Sophomore/SoftwareEngineering/Poemify_Files/tests/testdoc.txt";
	
	public static void main(String[] args) throws IOException {
		File source = null;
		while (source == null || !source.exists()) {
			String str = JOptionPane.showInputDialog("Please Enter Source Text Location.");
			str = test_source; //REMOVE;
			source = new File(str);
		}
		List<String> loadedStrs = read(source);
		ILineFilter filter = new SentenceBasedLineFilter(loadedStrs);
		List<ILine> result = filter.getLines();
		SynsetMod synMod = new RandomSynsetMod(result, 20);
		synMod.filter().forEach((ln) -> System.out.println(ln.getLineString()));
	}
	
	public static List<String> read(File source) throws IOException {
		List<String> ret = new ArrayList<>();
		Files.lines(source.toPath()).forEach((s) -> ret.add(s));
		return ret;
	}
	
}
