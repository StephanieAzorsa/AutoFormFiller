package com.automation.autoformfiller;

import com.automation.autoformfiller.models.Person;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AutoFormFilterTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testFillMultipleForms() {
        List<Person> people = createTestPeople(); // Crear lista de personas para rellenar el formulario
        String formLink = "https://docs.google.com/forms/d/e/1FAIpQLSdoroyuvsXKKGRK9VW_x23-Yj58IXZ51p-5K1kXNWICGchGOQ/viewform";

        for (Person person : people) {
            driver.get(formLink); // Cargar el formulario vacío antes de cada envío
            fillForm(person);
            submitForm();
        }
    }

    private void fillForm(Person person) {
        selectOption(By.xpath(getGenderXPath(person.getGender())));
        selectOption(By.xpath(getAgeRangeXPath(person.getAgeRange())));
        selectOption(By.xpath(getCurrentSituationXPath(person.getCurrentSituation())));
        selectOption(By.xpath(geDistrictXPath(person.getDistrict())));
        selectOption(By.xpath(getSmokerXPath(person.getSmoker())));
        selectOption(By.xpath(getUsesAshtray(person.getUsesAshtray())));
        selectOption(By.xpath(getReasonForSmokingXPath(person.getReasonForSmoking())));
        selectOption(By.xpath(getSmokingFrequencyXPath(person.getSmokingFrequency())));
        selectOption(By.xpath(getIncomeXPath(person.getIncome())));
        selectOption(By.xpath(getAshtrayLEDXPath(person.getAshtrayLED())));
        selectOption(By.xpath(getCeniceroInvestmentXPath(person.getCeniceroInvestment())));
        selectOption(By.xpath(getCeniceroDesignXPath(person.getCeniceroDesign())));
        selectOption(By.xpath(getBuyCeniceroXPath(person.getBuyCenicero())));
        selectMultipleOptions(person.getCeniceroFeatures());
        selectOption(By.xpath(getImportancePurificationXPath(person.getImportancePurification())));
        selectOption(By.xpath(getLedLightsXPath(person.getLedLights())));
    }

    private void submitForm() {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div/span"));
        submitButton.click();
    }

    private void selectOption(By locator) {
        WebElement option = driver.findElement(locator);
        System.out.println("Seleccionando elemento: " + option.getText()); // Añadir depuración
        option.click();
    }

    private List<Person> createTestPeople() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Hombre", "18 a 24", "Profesional",
                "Lima Centro (Lima Cercado, Breña, Jesús María, Lince, Pueblo Libre, San Borja, La Victoria y Rímac.)",
                "Sí", "Sí", "Placer",
                "Más de una cajetilla a la semana",
                "S/ 1,000 - S/ 1,999", "Sí",
                "55 a 70 soles", "Opción 2",
                "Sí",
                "Funcionalidad (Ejm. capacidad de colillas, limpieza.)",
                "Sí", "Me parece una buena idea"));

        people.add(new Person("Hombre", "18 a 24", "Profesional",
                "Lima Centro (Lima Cercado, Breña, Jesús María, Lince, Pueblo Libre, San Borja, La Victoria y Rímac.)",
                "Sí", "Sí", "Placer",
                "Más de una cajetilla a la semana",
                "S/ 1,000 - S/ 1,999", "Sí",
                "55 a 70 soles", "Opción 2",
                "Sí",
                "Funcionalidad (Ejm. capacidad de colillas, limpieza.)",
                "Sí", "Me parece una buena idea"));

        people.add(new Person("Hombre", "18 a 24", "Profesional",
                "Lima Centro (Lima Cercado, Breña, Jesús María, Lince, Pueblo Libre, San Borja, La Victoria y Rímac.)",
                "Sí", "Sí", "Placer",
                "Más de una cajetilla a la semana",
                "S/ 1,000 - S/ 1,999", "Sí",
                "55 a 70 soles", "Opción 2",
                "Sí",
                "Funcionalidad (Ejm. capacidad de colillas, limpieza.)",
                "Sí", "Me parece una buena idea"));


        return people;
    }

    private String getGenderXPath(String gender) {
        if ("Hombre".equalsIgnoreCase(gender))
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
        else
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
    }

    private String getAgeRangeXPath(String ageRange) {
        return switch (ageRange) {
            case "18 a 24" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "25 a 44" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "45 a 64" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[2]/div/span";
            case "65 a 84" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/span/div/div[4]/label/div/div[2]/div/span";
            case "Mayor de 85" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/span/div/div[5]/label/div/div[2]/div/span";
            default -> throw new IllegalArgumentException("Rango de edad no soportado: " + ageRange);
        };
    }

    private String getCurrentSituationXPath(String currentSituation) {
        return switch (currentSituation) {
            case "Estudiante" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "Profesional" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "Emprendedor (a)" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[2]/div/span";
            case "Empresario (a)" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[4]/label/div/div[2]/div/span";
            case "Empleado" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[5]/label/div/div[2]/div/span";
            case "Comerciante" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[6]/label/div/div[2]/div/span";
            case "Amo (a) de casa" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[7]/label/div/div[2]/div/span";
            default -> throw new IllegalArgumentException("Situación actual no soportado: " + currentSituation);
        };
    }

    private String geDistrictXPath(String district) {
        return switch (district) {
            case "Lima Norte (Ancón, Carabayllo, Comas, Independencia, Los Olivos, Puente Piedra, San Martín de Porres y Santa Rosa)" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "Lima Sur (Chorrillos, Lurín, Pachacamac, San Juan de Miraflores, Santiago de Surco, Villa El Salvador, Villa María del Triunfo, Santa María del Mar, San Bartolo, Punta Negra , Punta Hermosa y Pucusana.)" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "Lima Centro (Lima Cercado, Breña, Jesús María, Lince, Pueblo Libre, San Borja, La Victoria y Rímac.)" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[2]/div/span";
            case "Lima Oeste (Chorrillos, Barranco, Miraflores, San Isidro, Magdalena del Mar, Pueblo Libre y San Miguel)" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div/span/div/div[4]/label/div/div[2]/div/span";
            case "Lima Este (Ate, Santa Anita, Chaclacayo, Lurigancho, La Molina, Cieneguilla, San Luis y San Juan de Lurigancho.)" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div/span/div/div[5]/label/div/div[2]/div/span";
            default -> throw new IllegalArgumentException("Distrito no soportado: " + district);
        };
    }

    private String getSmokerXPath(String smoker) {
        if ("Sí".equalsIgnoreCase(smoker))
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
        else
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
    }

    private String getUsesAshtray(String usesAshtray) {
        if ("Sí".equalsIgnoreCase(usesAshtray))
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
        else
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
    }

    private String getReasonForSmokingXPath(String reason) {
        return switch (reason) {
            case "Reducir el estrés" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "Para entrar en calor" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "Costumbre" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[2]/div/span";
            case "Adicción" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[4]/label/div/div[2]/div/span";
            case "Rutina" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[5]/label/div/div[2]/div/span";
            case "Controlar mi peso" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[6]/label/div/div[2]/div/span";
            case "Placer" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[7]/label/div/div[2]/div/span";
            case "Para conversar con amistades" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div/span/div/div[8]/label/div/div[2]/div/span";
            default -> throw new IllegalArgumentException("Razón para fumar no soportada: " + reason);
        };
    }

    private String getSmokingFrequencyXPath(String frequency) {
        return switch (frequency) {
            case "Uno o dos cigarro a la semana" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[9]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "Una cajetilla a la semana" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[9]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "Más de una cajetilla a la semana" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[9]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[2]/div/span";
            default -> throw new IllegalArgumentException("Frecuencia de fumar no soportada: " + frequency);
        };
    }

    private String getIncomeXPath(String income) {
        return switch (income) {
            case "Menos de S/ 1,000" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "S/ 1,000 - S/ 1,999" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "S/ 2,000 - S/ 2,999" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[2]/div/span";
            case "S/ 3,000 - S/ 3,999" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[4]/label/div/div[2]/div/span";
            case "S/ 4,000 - S/ 4,999" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[5]/label/div/div[2]/div/span";
            case "S/ 5,000 - S/ 5,999" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[6]/label/div/div[2]/div/span";
            case "S/ 6,000 - S/ 7,999" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[7]/label/div/div[2]/div/span";
            case "S/ 8,000 o más" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[10]/div/div/div[2]/div/div/span/div/div[8]/label/div/div[2]/div/span";
            default -> throw new IllegalArgumentException("Ingreso económico no soportado: " + income);
        };
    }

    private String getAshtrayLEDXPath(String ashtrayLED) {
        if ("Sí".equalsIgnoreCase(ashtrayLED))
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[11]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
        else
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[11]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
    }

    private String getCeniceroInvestmentXPath(String investment) {
        return switch (investment) {
            case "35 a 50 soles" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[12]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "55 a 70 soles" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[12]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "75 a 90 soles" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[12]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[2]/div/span";
            case "95 a 110 soles" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[12]/div/div/div[2]/div/div/span/div/div[4]/label/div/div[2]/div/span";
            default -> throw new IllegalArgumentException("Inversión en cenicero no soportada: " + investment);
        };
    }

    private String getCeniceroDesignXPath(String design) {
        // Devuelve el xpath correspondiente al diseño del cenicero
        return switch (design) {
            case "Opción 1" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[13]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
            case "Opción 2" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[13]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
            case "Opción 3" ->
                    "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[13]/div/div/div[2]/div/div/span/div/div[3]/label/div[2]/div[2]/div/span";
            default -> throw new IllegalArgumentException("Diseño del cenicero no soportado: " + design);
        };
    }

    private String getBuyCeniceroXPath(String buyCenicero) {
        if ("Sí".equalsIgnoreCase(buyCenicero))
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[14]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
        else
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[14]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
        // WebElement otherField = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[11]/div/div/div[2]/div/div/span/div/div[3]/div/span/div/div/div[1]/input"));
        // otherField.sendKeys(person.getOther());
    }

    public void selectMultipleOptions(String options) {
        if (options == null || options.trim().isEmpty())
            throw new IllegalArgumentException("Las opciones proporcionadas no pueden ser nulas o vacías.");

        String[] selectedOptions = options.split(";");

        for (String option : selectedOptions) {
            if (option == null || option.trim().isEmpty())
                throw new IllegalArgumentException("Opción no válida: " + option);

            option = option.trim(); // Eliminar espacios en blanco
            System.out.println("Seleccionando opción: " + option); // Depuración

            switch (option) {
                case "Funcionalidad (Ejm. capacidad de colillas, limpieza.)" ->
                        selectOption(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[15]/div/div/div[2]/div[1]/div[1]/label/div/div[2]/div/span"));
                case "Diseño Minimalista" ->
                        selectOption(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[15]/div/div/div[2]/div[1]/div[2]/label/div/div[2]/div/span"));
                case "Innovación Tecnológica" ->
                        selectOption(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[15]/div/div/div[2]/div[1]/div[3]/label/div/div[2]/div/span"));
                case "Eco amigable" ->
                        selectOption(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[15]/div/div/div[2]/div[1]/div[4]/label/div/div[2]/div/span"));
                case "Precio accesible" ->
                        selectOption(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[15]/div/div/div[2]/div[1]/div[5]/label/div/div[2]/div/span"));
                default -> throw new IllegalArgumentException("Opción no soportada: " + option);
            }
        }
    }

    private String getImportancePurificationXPath(String importancePurification) {
        if ("Sí".equalsIgnoreCase(importancePurification))
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[16]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
        else
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[16]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
    }

    private String getLedLightsXPath(String ledLights) {
        if ("Me parece una buena idea".equalsIgnoreCase(ledLights))
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[17]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[2]/div/span";
        else
            return "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[17]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
