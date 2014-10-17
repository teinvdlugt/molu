package com.teinproductions.tein.molu;


public enum Element {

    HYDROGEN(MainActivity.context.getResources().getString(R.string.hydrogen),"H",1.0079,1),
    HELIUM(MainActivity.context.getResources().getString(R.string.helium),"He",4.0026,2),
    LITHIUM(MainActivity.context.getResources().getString(R.string.lithium),"Li",6.941,3),
    BERYLLIUM(MainActivity.context.getResources().getString(R.string.beryllium),"Be",9.0122,4),
    BORON(MainActivity.context.getResources().getString(R.string.boron),"B",10.811,5),
    CARBON(MainActivity.context.getResources().getString(R.string.carbon),"C",12.0107,6),
    NITROGEN(MainActivity.context.getResources().getString(R.string.nitrogen),"N",14.0067,7),
    OXYGEN(MainActivity.context.getResources().getString(R.string.oxygen),"O",15.9994,8),
    FLUORINE(MainActivity.context.getResources().getString(R.string.fluorine),"F",18.9984,9),
    NEON(MainActivity.context.getResources().getString(R.string.neon),"Ne",20.1797,10),
    SODIUM(MainActivity.context.getResources().getString(R.string.sodium),"Na",22.9897,11),
    MAGNESIUM(MainActivity.context.getResources().getString(R.string.magnesium),"Mg",24.305,12),
    ALUMINUM(MainActivity.context.getResources().getString(R.string.aluminum),"Al",26.9815,13),
    SILICON(MainActivity.context.getResources().getString(R.string.silicon),"Si",28.0855,14),
    PHOSPHORUS(MainActivity.context.getResources().getString(R.string.phosphorus),"P",30.9738,15),
    SULFUR(MainActivity.context.getResources().getString(R.string.sulfur),"S",32.065,16),
    CHLORINE(MainActivity.context.getResources().getString(R.string.chlorine),"Cl",35.453,17),
    ARGON(MainActivity.context.getResources().getString(R.string.argon),"Ar",39.948,18),
    POTASSIUM(MainActivity.context.getResources().getString(R.string.potassium),"K",39.0983,19),
    CALCIUM(MainActivity.context.getResources().getString(R.string.calcium),"Ca",40.078,20),
    SCANDIUM(MainActivity.context.getResources().getString(R.string.scandium),"Sc",44.9559,21),
    TITANIUM(MainActivity.context.getResources().getString(R.string.titanium),"Ti",47.867,22),
    VANADIUM(MainActivity.context.getResources().getString(R.string.vanadium),"V",50.9415,23),
    CHROMIUM(MainActivity.context.getResources().getString(R.string.chromium),"Cr",51.9961,24),
    MANGANESE(MainActivity.context.getResources().getString(R.string.manganese),"Mn",54.938,24),
    IRON(MainActivity.context.getResources().getString(R.string.iron),"Fe",55.845,26),
    COBALT(MainActivity.context.getResources().getString(R.string.cobalt),"Co",58.6934,27),
    NICKEL(MainActivity.context.getResources().getString(R.string.nickel),"Ni",58.6934,28),
    COPPER(MainActivity.context.getResources().getString(R.string.copper),"Cu",63.546,29),
    ZINC(MainActivity.context.getResources().getString(R.string.zinc),"Zn",65.39,30),
    GALLIUM(MainActivity.context.getResources().getString(R.string.gallium),"Ga",69.723,31),
    GERMANIUM(MainActivity.context.getResources().getString(R.string.germanium),"Ge",72.64,32),
    ARSENIC(MainActivity.context.getResources().getString(R.string.arsenic),"As",74.9216,33),
    SELENIUM(MainActivity.context.getResources().getString(R.string.selenium),"Se",78.96,34),
    BROMINE(MainActivity.context.getResources().getString(R.string.bromine),"Br",79.904,35),
    KRYPTON(MainActivity.context.getResources().getString(R.string.krypton),"Kr",83.8,36),
    RUBIDIUM(MainActivity.context.getResources().getString(R.string.rubidium),"Rb",85.4678,37),
    STRONTIUM(MainActivity.context.getResources().getString(R.string.strontium),"Sr",87.62,38),
    YTTRIUM(MainActivity.context.getResources().getString(R.string.yttrium),"Y",88.9095,39),
    ZIRCONIUM(MainActivity.context.getResources().getString(R.string.zirconium),"Zr",91.224,40),
    NIOBIUM(MainActivity.context.getResources().getString(R.string.niobium),"Nb",92.9064,41),
    MOLYBDENUM(MainActivity.context.getResources().getString(R.string.molybdenum),"Mo",95.94,42),
    TECHNETIUM(MainActivity.context.getResources().getString(R.string.technetium),"Tc",98.0,43),
    RUTHENIUM(MainActivity.context.getResources().getString(R.string.ruthenium),"Ru",101.07,44),
    RHODIUM(MainActivity.context.getResources().getString(R.string.rhodium),"Rh",102.9055,45),
    PALLADIUM(MainActivity.context.getResources().getString(R.string.palladium),"Pd",106.42,46),
    SILVER(MainActivity.context.getResources().getString(R.string.silver),"Ag",107.8682,47),
    CADMIUM(MainActivity.context.getResources().getString(R.string.cadmium),"Cd",112.411,48),

    ;

    private String name,abbreviation;
    private Double mass;
    private int atomicNumber;

    public static final Double nA = 6.02214 * (10 ^ 23);

    Element(String name, String abbreviation, Double mass, Integer atomicNumber) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.mass = mass;
        this.atomicNumber = atomicNumber;
    }


    public Double calculateWhenMolGiven(Double givenMol){
        return givenMol * this.mass;
    }

    public Double calculateWhenGramGiven(Double givenGram){
        return givenGram / this.mass;
    }

    public static Element findElementByAbbreviation(String abbreviation){

        for(Element currentElement : Element.values()){

            if(abbreviation.equals(currentElement.getAbbreviation())){
                return currentElement;
            }

        }

        return null;

    }



    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Double getMass() {
        return mass;
    }

    public Integer getAtomicNumber() {
        return atomicNumber;
    }

}

