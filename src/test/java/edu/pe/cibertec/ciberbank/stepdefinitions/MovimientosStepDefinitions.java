package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.DesplazarLista;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MovimientosStepDefinitions {

    private static final String CLAVE = "Cibertec123";

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que el usuario {string} inició sesión para consultar movimientos")
    public void que_el_usuario_inicio_sesion_para_consultar_movimientos(
            String usuario) {

        theActorCalled(usuario).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre(),
                IniciarSesion.con(usuario, CLAVE)
        );
    }

    @Cuando("ingresa a movimientos")
    public void ingresa_a_movimientos() {
        theActorInTheSpotlight().attemptsTo(
                net.serenitybdd.screenplay.actions.Click.on(
                        MovimientosScreen.BOTON_MOVIMIENTOS
                )
        );
    }

    @Entonces("debería ver {string} movimientos")
    public void deberia_ver_movimientos(String texto) {
        Ensure.that(
                TextoDe.el(MovimientosScreen.TOTAL_MOVIMIENTOS)
        ).contains(texto);
    }

    @Cuando("desplaza la lista de movimientos")
    public void desplaza_la_lista_de_movimientos() {
        theActorInTheSpotlight().attemptsTo(
                DesplazarLista.haciaAbajo()
        );
    }
}