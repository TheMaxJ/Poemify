package me.maxj.poemify;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Poemify {
	static String test_source = "/Users/maxjohnson/Documents/School/Sophomore/SoftwareEngineering/Poemify/tests/testdoc.txt";
	public static void main(String[] args) throws IOException {
		File source = null;
		while (source == null || !source.exists()) {
			String str = JOptionPane.showInputDialog("Please Enter Source Text Location.");
			source = new File(str);
		}
		List<String> loadedStrs = read(source);
		for (String s : loadedStrs) {
			System.out.println(s);
		}
	}
	
	public static List<String> read(File source) throws IOException {
		List<String> ret = new ArrayList<>();
		Files.lines(source.toPath()).forEach((s) -> ret.add(s));
		return ret;
	}
	
}
