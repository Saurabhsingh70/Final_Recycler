package com.example.recyclerfinal;

class AminoModel {
    String aminoAcidName;
    String aminoAcidAbbreviation;
    String aminoAcidAbbreviatinSmall;
    String description;
    int image;


    public AminoModel(String aminoAcidName, String aminoAcidAbbreviation, String aminoAcidAbbreviatinSmall, int image,String description) {
        this.aminoAcidName = aminoAcidName;
        this.aminoAcidAbbreviation = aminoAcidAbbreviation;
        this.aminoAcidAbbreviatinSmall = aminoAcidAbbreviatinSmall;
        this.image = image;
        this.description = description;
    }

    public String getAminoAcidName() {
        return aminoAcidName;
    }

    public String getAminoAcidAbbreviation() {
        return aminoAcidAbbreviation;
    }

    public String getAminoAcidAbbreviatinSmall() {
        return aminoAcidAbbreviatinSmall;
    }

    public int getImage() {
        return image;
    }
    public  String getDescription()
    {
        return description;
    }
}
