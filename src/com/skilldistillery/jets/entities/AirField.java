package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet;
	//populate fleet from the file
	
	public List<Jet> readFromFile(String fileName) {
		List<Jet> jets = new ArrayList<>();
		//read in the Various Jet Types from the file
		try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
			  String aWholeJet;
			  while ((aWholeJet = bufIn.readLine()) != null) {
				  //as you read in a Jet, create a Jet!
				 String[] jetDetails = aWholeJet.split(",");
				  //create the appropriate jet based on all the details.
				 /*if the jetDetails[0] happens to be DCV then create a fighter Jet
				  * if the jetDetails[0] happens to be DCV then create a dilithiumPowered Jet
				  * if the jetDetails[0] happens to be DCV then create a cargo Jet
				  */
				  
				  
				  //and add that specific jet type to your jets list
				  
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
		
		return jets;
	}
	
	
	
}
