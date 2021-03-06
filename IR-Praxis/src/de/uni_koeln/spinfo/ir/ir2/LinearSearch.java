package de.uni_koeln.spinfo.ir.ir2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.uni_koeln.spinfo.ir.ir1.Corpus;

public class LinearSearch implements InformationRetrieval {

	private List<String> works;

	public LinearSearch(Corpus corpus) {
		// Corpus wird übergeben, wir benötigen für die Suche die Werke
		works = corpus.getWorks();
	}

	@Override
	public Set<Integer> search(String query) {

		long start = System.currentTimeMillis();
		Set<Integer> result = new HashSet<Integer>();
		List<String> queries = Arrays.asList(query.split("\\s+"));

		for (String q : queries) {
			for (String work : works) {
				List<String> tokens = Arrays.asList(work.split("\\s+"));
				for (String token : tokens) {
					if (token.compareTo(q) == 0) {
						result.add(works.indexOf(work));
						break;
					}
				}
			}
		}
		System.out.println("Suchdauer: " + (System.currentTimeMillis() - start)
				+ " ms.");
		return result;
	}

}
