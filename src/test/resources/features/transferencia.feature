# language: es

@transferencia
Característica: Transferencia a beneficiarios

  Escenario: Transferencia exitosa a un beneficiario
    Dado que el usuario "jaime" inició sesión
    Cuando transfiere 250 al beneficiario "Luis Ramos - Interbank"
    Y acepta el diálogo de confirmación
    Entonces debería ver un número de operación generado
    Y el saldo debería quedar en "S/ 4,599.50"

  Escenario: El monto excede el límite por operación
    Dado que el usuario "jaime" inició sesión
    Cuando intenta transferir 3500 al beneficiario "Maria Torres - BCP"
    Entonces debería ver el error de límite "Excede el límite de S/ 3,000.00 por operación"

  Escenario: Transferencia con saldo insuficiente
    Dado que el usuario "sinsaldo" inició sesión
    Cuando intenta transferir 100.00 al beneficiario "Pedro - BCP"
    Entonces debería ver el error de saldo "Saldo insuficiente"