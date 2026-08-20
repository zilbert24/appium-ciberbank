package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PerfilScreen {

    private static final String PAQUETE =
            "edu.pe.cibertec.ciberbank:id/";

    private PerfilScreen() {
    }

    public static final Target BOTON_PERFIL =
            Target.the("botón Perfil")
                    .located(By.id(PAQUETE + "btn_nav_perfil"));

    public static final Target NOMBRE =
            Target.the("nombre del perfil")
                    .located(By.id(PAQUETE + "lbl_perfil_nombre"));

    public static final Target USUARIO =
            Target.the("usuario del perfil")
                    .located(By.id(PAQUETE + "lbl_perfil_usuario"));

    public static final Target CORREO =
            Target.the("correo del perfil")
                    .located(By.id(PAQUETE + "lbl_perfil_correo"));

    public static final Target TELEFONO =
            Target.the("teléfono del perfil")
                    .located(By.id(PAQUETE + "lbl_perfil_telefono"));

    public static final Target BOTON_CERRAR_SESION =
            Target.the("botón cerrar sesión")
                    .located(By.id(PAQUETE + "btn_cerrar_sesion"));
}