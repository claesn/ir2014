package de.uni_koeln.spinfo.ir.ir1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Corpus {

	private String text;
	private List<String> works; // Liste statt Array

	public Corpus(String filename, String delimiter) {

		StringBuilder sb = new StringBuilder();

		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				sb.append(line);
				sb.append("\n"); // Newline für Werkeinteilung (s. delimiter)
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		text = sb.toString();
		works = Arrays.asList(text.split(delimiter)); // Liste statt Array
	}

	public List<String> getWorks() {
		return works;
	}

	public String getText() {
		return text;
	}

}
