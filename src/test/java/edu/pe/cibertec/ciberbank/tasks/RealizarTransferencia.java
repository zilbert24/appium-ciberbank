package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarTransferencia implements Task {

    private final String monto;

    public RealizarTransferencia(String monto) {
        this.monto = monto;
    }

    public static RealizarTransferencia por(String monto) {
        return new RealizarTransferencia(monto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(
                        TransferenciaScreen.CAMPO_MONTO,
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Enter.theValue(monto)
                        .into(TransferenciaScreen.CAMPO_MONTO),

                OcultarTeclado.siEstaAbierto(),

                WaitUntil.the(
                        TransferenciaScreen.BOTON_TRANSFERIR,
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Click.on(TransferenciaScreen.BOTON_TRANSFERIR)
        );
    }
}