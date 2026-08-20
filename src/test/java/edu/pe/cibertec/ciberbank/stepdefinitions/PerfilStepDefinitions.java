package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.userinterface.PerfilScreen;
import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PerfilStepDefinitions {

    private static final String CLAVE = "Cibertec123";

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que el usuario {string} inició sesión para consultar su perfil")
    public void que_el_usuario_inicio_sesion_para_consultar_su_perfil(
            String usuario) {

        theActorCalled(usuario).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre(),
                IniciarSesion.con(usuario, CLAVE)
        );
    }

    @Cuando("ingresa a su perfil")
    public void ingresa_a_su_perfil() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(DashboardScreen.BOTON_MENU),
                Click.on(PerfilScreen.BOTON_PERFIL)
        );
    }

    @Entonces("debería ver su nombre de perfil")
    public void deberia_ver_su_nombre_de_perfil() {
        Ensure.that(
                TextoDe.el(PerfilScreen.NOMBRE)
        ).isNotEmpty();
    }

    @Cuando("cierra sesión")
    public void cierra_sesion() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(PerfilScreen.BOTON_CERRAR_SESION)
        );
    }

    @Entonces("debería volver a la pantalla de login")
    public void deberia_volver_a_la_pantalla_de_login() {
        theActorInTheSpotlight().attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre()
        );
    }
}