package com.coderscampus.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileService {

	public Map<String, Integer> readHands() throws IOException {
		Map<String, Integer> pokerHands = new HashMap<>();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("PokerHands.csv"));
			String line = reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] cardDetails = line.split(",");
				String name = cardDetails[0];
				String hand = cardDetails[1];

				int count = 1;
				String flush = "FLUSH";
				if (hand.equals(flush)) {
					if (pokerHands.containsKey(name)) {
						count = pokerHands.get(name) + 1;
						pokerHands.put(name, count);
					} else {
						pokerHands.put(name, 1);
					}

				}

			}

		} finally {
			if (reader != null)
				reader.close();
		}

		return pokerHands;
	}

	public void printToConsole(Map<String, Integer> pokerHands) {
		for (Map.Entry<String, Integer> hands : pokerHands.entrySet()) {
			System.out.println(hands);
		}
		System.out.println("");
	}

	public void changeRitaToZordon(Map<String, Integer> pokerHands) {
		String rita = "Rita Repulsa";
		String zordon = "Zordon";

		if (pokerHands.containsKey(rita)) {
			pokerHands.put(zordon, pokerHands.get(rita));
		}
		pokerHands.remove(rita);
		printToConsole(pokerHands);
	}
	
	public void increaseHeMan(Map<String, Integer> pokerHands) {
		String heMan = "He Man";
		int count = 1;
		
		if (pokerHands.containsKey(heMan)) {
			count = pokerHands.get(heMan) + 1;
			pokerHands.put(heMan, count);
		}
		printToConsole(pokerHands);
	}
	
	public void removeHeMan(Map<String, Integer> pokerHands) {
		String heMan = "He Man";
		
		if (pokerHands.containsKey(heMan)) {
		pokerHands.remove(heMan);
		}
		printToConsole(pokerHands);
	}

}
