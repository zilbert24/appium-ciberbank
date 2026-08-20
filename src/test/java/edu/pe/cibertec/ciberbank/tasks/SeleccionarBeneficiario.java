package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class SeleccionarBeneficiario implements Task {

    private final String beneficiario;

    public SeleccionarBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public static SeleccionarBeneficiario llamado(String beneficiario) {
        return new SeleccionarBeneficiario(beneficiario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // La aplicación muestra solamente el nombre del beneficiario.
        // El feature puede incluir también el banco.
        String nombre = beneficiario.contains(" - ")
                ? beneficiario.split(" - ")[0]
                : beneficiario;

        Target opcion = Target.the("beneficiario " + nombre)
                .located(xpath(
                        "//android.widget.TextView" +
                                "[@resource-id='edu.pe.cibertec.ciberbank:id/lbl_spinner_opcion'" +
                                " and contains(@text,'" + nombre + "')]"
                ));

        actor.attemptsTo(
                Click.on(TransferenciaScreen.BENEFICIARIO),
                Click.on(opcion)
        );
    }
}