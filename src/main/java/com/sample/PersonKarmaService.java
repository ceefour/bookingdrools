package com.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author ceefour
 *
 */
public class PersonKarmaService {
	
	private static Map<String, Long> karmaData = new HashMap<String, Long>();
	
	static {
		karmaData.put("rudi", 0L);
		karmaData.put("atang", 0L);
	}

	public void report() {
		for (Entry<String, Long> row : karmaData.entrySet()) {
			System.out.println(String.format("%4d %-20s", row.getValue(), row.getKey()));
		}
	}

	public Long getKarma(String personId) {
		//System.out.println("Stock " + personId + " = " + karmaData.get(personId));
		return karmaData.get(personId);
	}
	
	public void decrease(String personId, Long amount) {
		if (!karmaData.containsKey(personId))
			karmaData.put(personId, 0L); // reset

		Long lastKarma = karmaData.get(personId);
		Long currentKarma = lastKarma - amount;
		karmaData.put(personId, currentKarma);
		System.out.println("Karma " + personId + " - last: " + lastKarma + ", down: " + amount + ", now: " + currentKarma);
	}
	
	public void increase(String personId, Long amount) {
		if (!karmaData.containsKey(personId))
			karmaData.put(personId, 0L); // reset

		Long lastKarma = karmaData.get(personId);
		Long currentKarma = lastKarma + amount;
		karmaData.put(personId, currentKarma);
		System.out.println("Karma " + personId + " - last: " + lastKarma + ", up: " + amount + ", now: " + currentKarma);
	}
	
}
