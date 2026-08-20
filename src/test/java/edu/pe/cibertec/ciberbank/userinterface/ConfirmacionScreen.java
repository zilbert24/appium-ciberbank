package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionScreen {

    private ConfirmacionScreen() {
    }

    public static final Target CONFIRMAR =
            Target.the("botón Confirmar")
                    .located(By.id(
                            "edu.pe.cibertec.ciberbank:id/btn_confirmar"
                    ));

    public static final Target ACEPTAR =
            Target.the("botón Aceptar del diálogo")
                    .located(By.id("android:id/button1"));

    public static final Target CANCELAR =
            Target.the("botón Cancelar")
                    .located(By.id("edu.pe.cibertec.ciberbank:id/btn_volver"));
}