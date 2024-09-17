package com.automation.autoformfiller.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String gender;
    private String ageRange;
    private String currentSituation;
    private String district;
    private String smoker;
    private String usesAshtray;
    private String reasonForSmoking;
    private String smokingFrequency;
    private String income;
    private String ashtrayLED;
    private String ceniceroInvestment;
    private String ceniceroDesign;
    private String buyCenicero;
    private String other;
    private String ceniceroFeatures;
    private String importancePurification;
    private String ledLights;

    public Person(String gender,
                  String ageRange, String currentSituation,
                  String district, String smoker,
                  String usesAshtray, String reasonForSmoking,
                  String smokingFrequency, String income,
                  String ashtrayLED, String ceniceroInvestment,
                  String ceniceroDesign,
                  String buyCenicero, String ceniceroFeatures,
                  String importancePurification, String ledLights) {
        this.gender = gender;
        this.ageRange = ageRange;
        this.currentSituation = currentSituation;
        this.district = district;
        this.smoker = smoker;
        this.usesAshtray = usesAshtray;
        this.reasonForSmoking = reasonForSmoking;
        this.smokingFrequency = smokingFrequency;
        this.income = income;
        this.ashtrayLED = ashtrayLED;
        this.ceniceroInvestment = ceniceroInvestment;
        this.ceniceroDesign = ceniceroDesign;
        this.buyCenicero = buyCenicero;
        this.ceniceroFeatures = ceniceroFeatures;
        this.importancePurification = importancePurification;
        this.ledLights = ledLights;
    }
}