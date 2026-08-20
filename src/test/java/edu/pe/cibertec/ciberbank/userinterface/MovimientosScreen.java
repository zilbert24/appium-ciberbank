package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MovimientosScreen {

    private static final String PAQUETE =
            "edu.pe.cibertec.ciberbank:id/";

    private MovimientosScreen() {
    }

    public static final Target BOTON_MOVIMIENTOS =
            Target.the("botón Movimientos")
                    .located(By.id(PAQUETE + "btn_movimientos"));

    public static final Target LISTA_MOVIMIENTOS =
            Target.the("lista de movimientos")
                    .located(By.id(PAQUETE + "lst_movimientos"));

    public static final Target TOTAL_MOVIMIENTOS =
            Target.the("total de movimientos")
                    .located(By.id(PAQUETE + "lbl_total_movimientos"));

    public static final Target ITEM_MOVIMIENTO =
            Target.the("movimiento")
                    .located(By.id(PAQUETE + "item_movimiento"));
}