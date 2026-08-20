# language: es

Característica: Movimientos y cierre de sesión

  @movimientos
  Escenario: Consultar movimientos y desplazar la lista
    Dado que el usuario "jaime" inició sesión para consultar movimientos
    Cuando ingresa a movimientos
    Entonces debería ver "15" movimientos
    Cuando desplaza la lista de movimientos
    Entonces debería ver "30" movimientos

  @perfil
  Escenario: Cerrar sesión desde el perfil
    Dado que el usuario "jaime" inició sesión para consultar su perfil
    Cuando ingresa a su perfil
    Entonces debería ver su nombre de perfil
    Cuando cierra sesión
    Entonces debería volver a la pantalla de login