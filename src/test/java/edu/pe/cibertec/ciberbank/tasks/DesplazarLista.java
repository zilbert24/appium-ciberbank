package edu.pe.cibertec.ciberbank.tasks;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.HashMap;
import java.util.Map;

public class DesplazarLista implements Task {

    public static DesplazarLista haciaAbajo() {
        return new DesplazarLista();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriverFacade facade =
                (WebDriverFacade) BrowseTheWeb.as(actor).getDriver();

        AppiumDriver driver =
                (AppiumDriver) facade.getProxiedDriver();

        Map<String, Object> params = new HashMap<>();

        params.put("left", 100);
        params.put("top", 500);
        params.put("width", 880);
        params.put("height", 1500);
        params.put("direction", "down");
        params.put("percent", 0.8);

        driver.executeScript("mobile: swipeGesture", params);
    }
}