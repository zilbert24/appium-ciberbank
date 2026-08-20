package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.AbrirTransferencias;
import edu.pe.cibertec.ciberbank.tasks.AceptarConfirmacion;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.tasks.RealizarTransferencia;
import edu.pe.cibertec.ciberbank.tasks.SeleccionarBeneficiario;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaStepDefinitions {

    private static final String CLAVE = "Cibertec123";

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que el usuario {string} inició sesión")
    public void que_el_usuario_inicio_sesion(String usuario) {
        theActorCalled(usuario).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre(),
                IniciarSesion.con(usuario, CLAVE)
        );
    }

    @Cuando("transfiere {double} al beneficiario {string}")
    public void transfiere_al_beneficiario(double monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                AbrirTransferencias.desdeElDashboard(),
                SeleccionarBeneficiario.llamado(beneficiario),
                RealizarTransferencia.por(String.valueOf(monto))
        );
    }

    @Cuando("intenta transferir {double} al beneficiario {string}")
    public void intenta_transferir_al_beneficiario(
            double monto,
            String beneficiario) {

        theActorInTheSpotlight().attemptsTo(
                AbrirTransferencias.desdeElDashboard(),
                SeleccionarBeneficiario.llamado(beneficiario),
                RealizarTransferencia.por(String.valueOf(monto))
        );
    }

    @Y("acepta el diálogo de confirmación")
    public void acepta_el_dialogo_de_confirmacion() {
        theActorInTheSpotlight().attemptsTo(
                AceptarConfirmacion.delDialogo()
        );
    }

    @Entonces("debería ver un número de operación generado")
    public void deberia_ver_un_numero_de_operacion_generado() {
        Ensure.that(
                TextoDe.el(TransferenciaScreen.NUMERO_OPERACION)
        ).isNotEmpty();
    }

    @Y("el saldo debería quedar en {string}")
    public void el_saldo_deberia_quedar_en(String saldo) {
        Ensure.that(
                TextoDe.el(TransferenciaScreen.SALDO_ACTUALIZADO)
        ).isEqualTo(saldo);
    }

    @Entonces("debería ver el error de límite {string}")
    public void deberia_ver_el_error_de_limite(String mensaje) {
        Ensure.that(
                TextoDe.el(TransferenciaScreen.ERROR_LIMITE)
        ).isEqualTo(mensaje);
    }

    @Entonces("debería ver el error de saldo {string}")
    public void deberia_ver_el_error_de_saldo(String mensaje) {
        Ensure.that(
                TextoDe.el(TransferenciaScreen.ERROR_SALDO_INSUFICIENTE)
        ).isEqualTo(mensaje);
    }
}