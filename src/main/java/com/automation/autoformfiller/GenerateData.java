package com.automation.autoformfiller;

import com.automation.autoformfiller.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateData {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Random random = new Random();

        int totalRecords = 3;

        for (int i = 0; i < totalRecords; i++) {
            String gender = random.nextDouble() < 0.87 ? "Hombre" : "Mujer";
            String ageRange = getRandomAgeRange(0.05, 0.89, 0.04, 0.01, 0);
            String currentSituation = getRandomCurrentSituation(0.08, 0.79, 0.05, 0.02, 0.04, 0.01, 0.01);
            String district = getRandomDistrict();
            String smoker = random.nextDouble() < 0.96 ? "Sí" : "No";
            String usesAshtray = random.nextDouble() < 0.96 ? "Sí" : "No";
            String reasonForSmoking = getRandomReasonForSmoking();
            String income = getRandomIncome();

            String smokingFrequency = getRandomSmokingFrequency();

            String ceniceroInvestment = getRandomCeniceroInvestment();
            String ceniceroDesign = getRandomCeniceroDesign();
            String buyCenicero = random.nextDouble() < 0.96 ? "Si" : "No";
            String ceniceroFeatures = getRandomCeniceroFeatures();
            String importancePurification = "Sí";
            String ledLights = random.nextDouble() < 0.98 ? "Me parece una buena idea" : "No me parece relevante";

            // Verificar valores nulos o vacíos antes de crear el objeto Person
            if (ageRange == null || currentSituation == null || district == null || reasonForSmoking == null || smokingFrequency == null || income == null || ceniceroInvestment == null || ceniceroDesign == null) {
                throw new IllegalStateException("Se generó un valor nulo en los datos.");
            }

            // Crear el objeto Person y añadirlo a la lista
            people.add(new Person(gender, ageRange, currentSituation, district, smoker, usesAshtray, reasonForSmoking, smokingFrequency,
                    income, "No", ceniceroInvestment, ceniceroDesign, buyCenicero, ceniceroFeatures, importancePurification, ledLights));
        }

        // Imprimir datos generados
        for (Person person : people) {
            System.out.println("people.add(new Person(\"" +
                    person.getGender() + "\", \"" +
                    person.getAgeRange() + "\", \"" +
                    person.getCurrentSituation() + "\", \"" +
                    person.getDistrict() + "\", \"" +
                    person.getSmoker() + "\", \"" +
                    person.getUsesAshtray() + "\", \"" +
                    person.getReasonForSmoking() + "\", \"" +
                    person.getSmokingFrequency() + "\", \"" +
                    person.getIncome() + "\", \"" +
                    person.getAshtrayLED() + "\", \"" +
                    person.getCeniceroInvestment() + "\", \"" +
                    person.getCeniceroDesign() + "\", \"" +
                    person.getBuyCenicero() + "\", \"" +
                    person.getCeniceroFeatures() + "\", \"" +
                    person.getImportancePurification() + "\", \"" +
                    person.getLedLights() + "\"));");
        }
    }

    private static String getRandomCeniceroFeatures() {
        List<String> features = new ArrayList<>();
        Random random = new Random();

        if (random.nextDouble() < 0.49) {
            features.add("Funcionalidad (Ejm. capacidad de colillas, limpieza.)");
        }
        if (random.nextDouble() < 0.15) {
            features.add("Diseño Minimalista");
        }
        if (random.nextDouble() < 0.61) {
            features.add("Innovación Tecnológica");
        }
        if (random.nextDouble() < 0.58) {
            features.add("Eco amigable");
        }
        if (random.nextDouble() < 0.17) {
            features.add("Precio accesible");
        }

        return String.join("; ", features);
    }

    private static String getRandomAgeRange(double... probabilities) {
        String[] ageRanges = {"18 a 24",
                "25 a 44",
                "45 a 64",
                "65 a 84",
                "Mayor de 85"};
        return getRandomCategory(ageRanges, probabilities);
    }

    private static String getRandomSmokingFrequency() {
        String[] frequencies = {"Uno o dos cigarro a la semana",
                "Una cajetilla a la semana",
                "Más de una cajetilla a la semana"};
        return getRandomCategory(frequencies, new double[]{0.1, 0.8, 0.1});
    }

    private static String getRandomIncome() {
        String[] incomes = {"Menos de S/ 1,000",
                "S/ 1,000 - S/ 1,999",
                "S/ 2,000 - S/ 2,999",
                "S/ 3,000 - S/ 3,999",
                "S/ 4,000 - S/ 4,999",
                "S/ 5,000 - S/ 5,999",
                "S/ 6,000 - S/ 7,999",
                "S/ 8,000 o más"};
        return getRandomCategory(incomes, new double[]{0.05, 0.07, 0.1, 0.1, 0.6, 0.03, 0.03, 0.02});
    }

    private static String getRandomCeniceroInvestment() {
        String[] investments = {"35 a 50 soles", "55 a 70 soles", "75 a 90 soles", "95 a 110 soles"};
        return getRandomCategory(investments, new double[]{0.05, 0.86, 0.06, 0.03});
    }

    private static String getRandomCeniceroDesign() {
        String[] designs = {"Opción 1", "Opción 2", "Opción 3"};
        return getRandomCategory(designs, new double[]{0.1, 0.84, 0.06});
    }

    private static String getRandomCurrentSituation(double... probabilities) {
        String[] situations = {"Estudiante",
                "Profesional",
                "Emprendedor (a)",
                "Empresario (a)",
                "Empleado",
                "Comerciante",
                "Amo (a) de casa"};
        return getRandomCategory(situations, probabilities);
    }

    private static String getRandomDistrict() {
        String[] districts = {"Lima Norte (Ancón, Carabayllo, Comas, Independencia, Los Olivos, Puente Piedra, San Martín de Porres y Santa Rosa)",
                "Lima Sur (Chorrillos, Lurín, Pachacamac, San Juan de Miraflores, Santiago de Surco, Villa El Salvador, Villa María del Triunfo, Santa María del Mar, San Bartolo, Punta Negra , Punta Hermosa y Pucusana.)",
                "Lima Centro (Lima Cercado, Breña, Jesús María, Lince, Pueblo Libre, San Borja, La Victoria y Rímac.)",
                "Lima Oeste (Chorrillos, Barranco, Miraflores, San Isidro, Magdalena del Mar, Pueblo Libre y San Miguel)",
                "Lima Este (Ate, Santa Anita, Chaclacayo, Lurigancho, La Molina, Cieneguilla, San Luis y San Juan de Lurigancho.)"};
        return getRandomCategory(districts, new double[]{0.18, 0.12, 0.49, 0.1, 0.11});
    }

    private static String getRandomReasonForSmoking() {
        String[] reasons = {"Reducir el estrés",
                "Para entrar en calor",
                "Costumbre",
                "Adicción",
                "Rutina",
                "Controlar mi peso",
                "Placer",
                "Para conversar con amistades"};
        return getRandomCategory(reasons, new double[]{0.28, 0.03, 0.1, 0.2, 0.12, 0, 0.15, 0.12});
    }

    private static String getRandomCategory(String[] categories, double[] probabilities) {
        Random random = new Random();
        double r = random.nextDouble();
        double cumulativeProbability = 0.0;

        for (int i = 0; i < categories.length; i++) {
            cumulativeProbability += probabilities[i];
            if (r <= cumulativeProbability) {
                return categories[i];
            }
        }

        return categories[categories.length - 1]; // Default case
    }
}