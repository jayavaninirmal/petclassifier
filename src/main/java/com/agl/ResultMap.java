package com.agl;

import java.util.*;

public class ResultMap extends HashMap<String, List<String>> {

    public String put(String key, String petName) {
        if (!this.containsKey(key)) {
        	List<String> petNames = new ArrayList<String>();
        	petNames.add(petName);
            super.put(key, petNames);
        }
        else {
            List<String> petNames = this.get(key);
            petNames.add(petName);
            super.put(key, petNames);
        }

        return petName;
    }
}