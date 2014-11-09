package com.teinproductions.tein.molu;


import java.util.ArrayList;

public class Molecule {

    private ArrayList<Element> elements;
    private String name;
    private Double mass = 0.0;

    public Molecule() {

        elements = new ArrayList<Element>();

    }

    public Molecule(ArrayList<Element> elements) {

        this.elements = elements;
        this.mass = 0.0;

        for (Element element : elements) {
            mass += element.getMass();
        }

    }

    public void addElement(Element element) {
        this.elements.add(element);

        this.mass += element.getMass();
    }

    public static Molecule parseMolecule(String string) {

        // Make an ArrayList<Character> with all the characters in the string
        char[] charArray = string.toCharArray();
        ArrayList<Character> charList = new ArrayList<Character>();
        for(char currentChar : charArray){
            charList.add(currentChar);
        }

        // Make the molecule to return
        Molecule parsedMolecule = new Molecule();

        // look if the first character in the string is a letter, otherwise return null
        if (!Character.isLetter(charList.get(0))) return null;

        while (1 + 1 == 2) {

            if(Character.isLowerCase(charList.get(1))){

            } else {
                Element parsedElement = Element.findElementByAbbreviation(Character.toString(charList.get(0)));
                if(parsedElement == null){
                    return null;
                }

                // how many of these elements?
                String numberOfElementsString = "";
                for(int i = 1; i < charList.size(); i++){
                    try {
                        Integer someNumber = Integer.parseInt(Character.toString(charList.get(i)));
                        numberOfElementsString = numberOfElementsString + someNumber.toString();
                    } catch (NumberFormatException e) {

                        break;

                    }
                }

                // Add the elements to the molecule to return
                try {
                    Integer numberOfElements = Integer.parseInt(numberOfElementsString);
                    for(int i = 0; i < numberOfElements; i++) {
                        parsedMolecule.addElement(parsedElement);
                    }
                } catch (NumberFormatException e) {
                    parsedMolecule.addElement(parsedElement);
                }



            }
        }
    }

    public static Molecule parseMolecule2(String string) {

        // Make an ArrayList<Character> with all the characters in the string
        char[] charArray = string.toCharArray();
        ArrayList<Character> charList = new ArrayList<Character>();
        for(char currentChar : charArray){
            charList.add(currentChar);
        }

        // Make the molecule to return
        Molecule parsedMolecule = new Molecule();

        // look if the first character in the string is a letter, otherwise return null
        if (!Character.isLetter(charList.get(0))) return null;

        while (1 + 1 == 2){

            if ()

            if (Character.isUpperCase(charList.get(1))){
                String abbreviation = Character.toString(charList.get(0));

                Element parsedElement = Element.findElementByAbbreviation(abbreviation);
                if(parsedElement == null){
                    return null;
                }

                parsedMolecule.addElement(parsedElement);

                charList = shorten(charList, 1);

            } else if (Character.isLowerCase(charList.get(1))){

                if(Character.isUpperCase(charList.get(2))){
                    String abbreviation = Character.toString(charList.get(0)) + Character.toString(charList.get(1));

                    Element parsedElement = Element.findElementByAbbreviation(abbreviation);
                    if(parsedElement == null){
                        return null;
                    }

                    parsedMolecule.addElement(parsedElement);

                    charList = shorten(charList, 2);
                }

            }


        }
    }

    public static ArrayList<Character> shorten(ArrayList<Character> charList, int index){

        ArrayList<Character> shortenedList = new ArrayList<Character>();

        for(int i = index; i < charList.size(); i++){
            shortenedList.add(charList.get(i));
        }

        return shortenedList;
    }

}
