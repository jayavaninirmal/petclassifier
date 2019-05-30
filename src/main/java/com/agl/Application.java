package com.agl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.json.JSONException;

import com.agl.util.JsonUtils;

/**
 * This class classifies the given JSON file and prints the pet names in ascending order 
 * for each gender of the pet's owner.
 * @author jayavaniswaminathan
 *
 */
public class Application {
	
	public static void main(String[] args) throws IOException, JSONException {
	    String json = readJsonFromUrl("http://agl-developer-test.azurewebsites.net/people.json");
	    ResultMap resultMap = classifyPetNamesByGender(json, "cat");
	    printPetNamesByGender(resultMap);
	}
	
	/**
	 * This method reads the JSON data in the URL and returns the JSON string.
	 * @param url
	 * @return String
	 * @throws IOException
	 * @throws JSONException
	 */
	public static String readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
	    } finally {
	      is.close();
	    }
	}
	
	
	/**
	 * This method classifies the JSON by gender and pet type and returns the result in a map.
	 * @param json
	 * @param petType
	 * @return
	 */
	public static ResultMap classifyPetNamesByGender(String json, String petType) {
		ResultMap resultMap =  new ResultMap();
		if(json == null || petType == null) {
			System.err.println("Json or pet type is null\n");
			return resultMap;
		}
	    Person[]  persons = JsonUtils.fromJson(json, Person[].class);
	    
	    if (persons != null && persons.length > 0) {
	    	ArrayList<Person> personList = new ArrayList<Person>(Arrays.asList(persons));
	    	personList.stream().forEach(person -> {
	    				if(person.getPetsList() != null) {
	    					List<Pet> petList = person.getPetsList().stream().filter(
	    							pet -> petType.equalsIgnoreCase(pet.getType())).collect(Collectors.toList());
	    					if(petList != null &&  petList.size() > 0) {
	    						for(Pet pet : petList) {
	    						resultMap.put(person.getGender(), pet.getName());
	    						}
	    					}
	    				}
	    			});
	    }
	    return resultMap;
	    
	}
	
	/**
	 * This method prints the pet names in ascending order for each gender  
	 * @param resultMap
	 */
	public static void printPetNamesByGender(Map<String, List<String>> resultMap) {
		if(resultMap == null || resultMap.isEmpty()) {
			System.out.println("No results to print");
			return;
		 }
		 for(Entry<String, List<String>> entry : resultMap.entrySet()) {
	   		String gender = (String) entry.getKey();
	   		List<String> petNames = (List<String>) entry.getValue();
	   		Collections.sort(petNames);
	   		System.out.println(gender + "\n------");
    		petNames.stream().forEach(System.out::println);
	    	System.out.println();
	    }
	}
}
