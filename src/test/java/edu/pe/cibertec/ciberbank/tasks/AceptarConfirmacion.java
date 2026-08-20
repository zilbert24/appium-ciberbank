package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AceptarConfirmacion implements Task {

    public static AceptarConfirmacion delDialogo() {
        return new AceptarConfirmacion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(
                        ConfirmacionScreen.CONFIRMAR,
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Click.on(ConfirmacionScreen.CONFIRMAR),

                WaitUntil.the(
                        ConfirmacionScreen.ACEPTAR,
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Click.on(ConfirmacionScreen.ACEPTAR)
        );
    }
}