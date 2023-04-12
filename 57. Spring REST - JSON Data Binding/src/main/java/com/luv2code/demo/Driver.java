package com.luv2code.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO
            Student theStudent =
                    mapper.readValue(new File("data/sample-full.json"), Student.class);

            // print first name and last name
            System.out.println("First name = " + theStudent.getFirstName());
            System.out.println("Last name = " + theStudent.getLastName());
            System.out.println("Address = " + theStudent.getAddress());

            String tempArray[] = theStudent.getLanguages();

            for (int i = 0; i < tempArray.length; i++) {
                System.out.println(tempArray[i]);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
