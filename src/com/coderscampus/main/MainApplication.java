package com.coderscampus.main;

import java.io.IOException;
import java.util.Map;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();
		Map<String, Integer> pokerHands = fileService.readHands();
		
		System.out.println("Original hand: ");
		fileService.printToConsole(pokerHands);
		
		System.out.println("Changed Rita to Zordon: ");
		fileService.changeRitaToZordon(pokerHands);
		
		System.out.println("Increased He Man by 1: ");
		fileService.increaseHeMan(pokerHands);
		
		System.out.println("Removed He Man: ");
		fileService.removeHeMan(pokerHands);
	}

}
