# Conversor de Moneda en Java

<image src="https://aprende.goodneighbors.cl/wp-content/uploads/2022/02/ONE_logo_rgb-768x408.png" alt="Logo Alura Latam + Oracle"/>

# 

###  Este proyecto es un **Conversor de Divisas** desarrollado en Java que permite a los usuarios convertir entre diferentes monedas utilizandola API de **[ExchangeRate-API](https://www.exchangerate-api.com/)**. El programa cuenta con un menú interactivo que permite realizar conversiones de manera fácil y rápida.

# 

## Tabla de Contenidos
[//]: # (Este comentario no se verá en el archivo cuando se visualice en GitHub)

- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contacto](#contacto)

# 

## Características

- **Conversión entre múltiples monedas:**
    - Dólar a Peso Argentino
    - Peso Argentino a Dólar
    - Dólar a Real Brasileño
    - Real Brasileño a Dólar
    - Dólar a Peso Colombiano
    - Peso Colombiano a Dólar
- **Registro de usuario para poder relaizar conversiones:** El sistema solicita un nombre de usuario para poder  iniciar .
- **Manejo de entradas no válidas:** El programa solicita nuevamente la entrada si el usuario ingresa un valor incorrecto.
- **Opción para realizar múltiples conversiones:** Permite continuar convirtiendo sin reiniciar el programa.
- **Visualización de tasas de cambio actuales:** Proporciona tasas actualizadas desde la API.
- **Visualización del historial de conversiones realizadas:** Proporciona un deatalle de las conversciones ralizadas por en usuario.
- **Almacena los datos en un archvio;** Consolida toda al actividad en el sistema en un archivo llamado ****history.json****.

# 

## Requisitos

- **Java Development Kit (JDK)**: versión 17 o superior.
- **Conexión a Internet**: Necesaria para acceder a la API de tasas de cambio.
- **Maven**: Para gestionar las dependencias del proyecto.

# 

## Instalación

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/jissbossg/alura-challenge-conversor-moneda.git
   ```
# 

## Uso

### El sistema inicia con un saludo solicitando que se ingrese un nombre de usuario
```bash
Bienvenido al sistema conversor de moneda
Por favor ingrese su nombre de usuario:
luri
```
### Una vez valiadado que se ingreso un nombre de usuario se inician las opciones de conversion disponibles y solicita seleccionar una para poder continuar
```bash
Nombre de usuario válido: luri
Iniciando sistema......
Seleccione una tasa de cambio:
1) Dólar ==> Peso Argentino
2) Peso Argentino ==> Dólar
3) Dólar ==> Real Brasileño
4) Real Brasileño ==> Dólar
5) Dólar ==> Peso Colombiano
6) Peso Colombiano ==> Dólar
7) Ver histroial de esta sesion
0) Salir
```
### Seleccion de opcion 1.
```bash
1
```
### Solicita ingresar el valor a convertir
```bash
Ingresa la cantidad de USD a convertir en ARS: 100
```
### Retorna el valor ingresado en la moneda de origen y en la moneda de cambio
```bash
100,00 USD es igual a 97625,00 ARS
```
### Muestra el menu secundario y consulta que paso se desea seguir
```bash
Que desea hacer
2) Realizar otra conversión en la misma tasa de cambio
3) Escojer otra tasa de cambio
4) Ver histroial de esta sesion
5) Salir
```
### Se escoje la opcion 1. volver a realizar otra conversion con los mismos parametras de tasa de cambio
```bash
1
```
### Solicita ingresar el valor a convertir
```bash
Ingresa la cantidad de USD a convertir en ARS: 500
```
### Retorna el valor ingresado en la moneda de origen y en la moneda de cambio
```bash
500,00 USD es igual a 488125,00 ARS
```
### Muestra el menu secundario y consulta que paso se desea seguir
```bash
Que desea hacer
1) Realizar otra conversión en la misma tasa de cambio
2) Escojer otra tasa de cambio
3) Ver histroial de esta sesion
4) Salir
```
### Se escoje la opcion 2. escojer otros parametros de tasa de cambio mostrando el menu principal nuevamente
```bash
Seleccione una tasa de cambio:
1) Dólar ==> Peso Argentino
2) Peso Argentino ==> Dólar
3) Dólar ==> Real Brasileño
4) Real Brasileño ==> Dólar
5) Dólar ==> Peso Colombiano
6) Peso Colombiano ==> Dólar
7) Ver histroial de esta sesion
0) Salir
```
### Seleccion de opcion 2.
```bash
2
```
### Solicita ingresar el valor a convertir
```bash
Ingresa la cantidad de ARS a convertir en USD: 600
```
### Retorna el valor ingresado en la moneda de origen y en la moneda de cambio
```bash
600,00 ARS es igual a 0,61 USD
```
### Muestra el menu secundario y consulta que paso se desea seguir
```bash
Que desea hacer
2) Realizar otra conversión en la misma tasa de cambio
3) Escojer otra tasa de cambio
4) Ver histroial de esta sesion
5) Salir
```
### Seleccion de opcion 2. mostrando el menu principal nuevamente
```bash
2
```
```bash
Seleccione una tasa de cambio:
1) Dólar ==> Peso Argentino
2) Peso Argentino ==> Dólar
3) Dólar ==> Real Brasileño
4) Real Brasileño ==> Dólar
5) Dólar ==> Peso Colombiano
6) Peso Colombiano ==> Dólar
7) Ver histroial de esta sesion
0) Salir
```
### Seleccion de opcion 7.
```bash
7
```
### Muestra en detalle el historico de conversiones realizadas
```bash
Historial generado 09/10/24 - 21:50:35
1. Usuario=luri, Tasa de origen=USD, Valor a cambiar=100,00, Tasa de cambio=ARS, Valor cambiado=97625,00, Fecha y hora de la transaccion=09/10/24 - 21:50:00
2. Usuario=luri, Tasa de origen=USD, Valor a cambiar=500,00, Tasa de cambio=ARS, Valor cambiado=488125,00, Fecha y hora de la transaccion=09/10/24 - 21:50:15
3. Usuario=luri, Tasa de origen=ARS, Valor a cambiar=600,00, Tasa de cambio=USD, Valor cambiado=0,61, Fecha y hora de la transaccion=09/10/24 - 21:50:35
```
### Muestra el menu principar para poder seguir interactuando con el sistema
```bash
Seleccione una tasa de cambio:
1) Dólar ==> Peso Argentino
2) Peso Argentino ==> Dólar
3) Dólar ==> Real Brasileño
4) Real Brasileño ==> Dólar
5) Dólar ==> Peso Colombiano
6) Peso Colombiano ==> Dólar
7) Ver histroial de esta sesion
0) Salir
```
### Seleccion de opcion 3.
```bash
3
```
### Solicita ingresar el valor a convertir
```bash
Ingresa la cantidad de USD a convertir en BRL: 900
```
### Retorna el valor ingresado en la moneda de origen y en la moneda de cambio
```bash
900,00 USD es igual a 4988,52 BRL
```
### Muestra el menu secundario y consulta que paso se desea seguir
```bash
Que desea hacer
2) Realizar otra conversión en la misma tasa de cambio
3) Escojer otra tasa de cambio
4) Ver histroial de esta sesion
5) Salir
```
### Seleccion de opcion 3. del menu secundario
```bash
3
```
### Muestra en detalle el historico de conversiones realizadas
```bash
Historial generado 09/10/24 - 21:51:06
1. Usuario=luri, Tasa de origen=USD, Valor a cambiar=100,00, Tasa de cambio=ARS, Valor cambiado=97625,00, Fecha y hora de la transaccion=09/10/24 - 21:50:00
2. Usuario=luri, Tasa de origen=USD, Valor a cambiar=500,00, Tasa de cambio=ARS, Valor cambiado=488125,00, Fecha y hora de la transaccion=09/10/24 - 21:50:15
3. Usuario=luri, Tasa de origen=ARS, Valor a cambiar=600,00, Tasa de cambio=USD, Valor cambiado=0,61, Fecha y hora de la transaccion=09/10/24 - 21:50:35
4. Usuario=luri, Tasa de origen=USD, Valor a cambiar=900,00, Tasa de cambio=BRL, Valor cambiado=4988,52, Fecha y hora de la transaccion=09/10/24 - 21:51:06
```
### Muestra el menu secundario y consulta que paso se desea seguir
```bash
Que desea hacer
1) Escojer otra tasa de cambio
0) Salir
```
### Seleccion de opcion 0.
```bash
0
```
### Con la seleccion de esta opcion el sistema se finaliza mostrando un mensaje de agradecimiento y se finaliza el sistema
```bash
Gracias por utilizar el conversor de moneda...
Saliendo...
```

# 

## Contacto
[LinkedIn](https://www.linkedin.com/in/jissbossg)
[Links](https://linktr.ee/jissbossg)
