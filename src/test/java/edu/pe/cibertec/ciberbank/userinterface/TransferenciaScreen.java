package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferenciaScreen {

    private static final String PAQUETE =
            "edu.pe.cibertec.ciberbank:id/";

    private TransferenciaScreen() {
    }

    public static final Target BOTON_TRANSFERENCIAS =
            Target.the("botón Transferir del dashboard")
                    .located(By.xpath(
                            "//android.widget.TextView[@text='Transferir']"
                    ));

    public static final Target BENEFICIARIO =
            Target.the("selector de beneficiario")
                    .located(By.id(PAQUETE + "spn_beneficiario"));

    public static final Target CAMPO_MONTO =
            Target.the("campo monto")
                    .located(By.id(PAQUETE + "inp_monto"));

    public static final Target BOTON_TRANSFERIR =
            Target.the("botón Transferir")
                    .located(By.id(PAQUETE + "btn_continuar"));

    public static final Target ERROR_TRANSFERENCIA =
            Target.the("mensaje de error de transferencia")
                    .located(By.id(PAQUETE + "err_transferencia"));

    public static final Target ERROR_LIMITE =
            Target.the("error por límite de operación")
                    .located(By.id(PAQUETE + "error_limite_operacion"));

    public static final Target ERROR_SALDO_INSUFICIENTE =
            Target.the("error por saldo insuficiente")
                    .located(By.id(PAQUETE + "error_saldo_insuficiente"));

    public static final Target NUMERO_OPERACION =
            Target.the("número de operación")
                    .located(By.id(PAQUETE + "lbl_numero_operacion"));

    public static final Target SALDO_ACTUALIZADO =
            Target.the("saldo actualizado")
                    .located(By.id(PAQUETE + "lbl_saldo_actualizado"));

    public static final Target OPERACION_EXITOSA =
            Target.the("mensaje de operación exitosa")
                    .located(By.id(PAQUETE + "operacion_exitosa"));
}