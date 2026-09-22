Indice de bonos tresury
Kata — Treasury 30Y Average
Contexto
Un Treasury bond es un título de deuda emitido por el gobierno de Estados Unidos para
financiar sus obligaciones. En términos simples, cuando un inversor compra un Treasury,
está prestando dinero al gobierno estadounidense a cambio de recibir intereses.
Los Treasury se clasifican por diferentes plazos. Para esta kata trabajaremos con el
Treasury de 30 años, cuyo rendimiento (yield) representa la tasa de interés de mercado
asociada a títulos del Tesoro estadounidense con un vencimiento constante de 30 años.
Para obtener los datos se utilizará una API pública que proporciona los rendimientos
diarios del Treasury de 30 años.
�� Objetivo
Construir un pequeño microservicio utilizando:
Java 25 Spring Boot 4 Spring WebFlux Programación reactiva Gradle JUnit 5 Mockito o
herramientas equivalentes para testing
El microservicio debe consultar los valores diarios del Treasury 30Y, y exponer un
endpoint que permita calcular el promedio del rendimiento entre dos fechas.
1. Fuente de datos
Utilizar la API de Alpha Vantage – Treasury Yield. El endpoint permite
consultar el Treasury de 30 años utilizando:
function=TREASURY_YIELD interval=daily maturity=30year
Ejemplo:
GET https://www.alphavantage.co/query?
function=TREASURY_YIELD&interval=daily&maturity=30year&apikey={API_KEY}
La respuesta contiene observaciones como:
{ "observations": [ { "date": "2026-08-12", "value": "5.24" }, { "date": "2026-08-13",
"value": "5.21" }, { "date": "2026-08-14", "value": "5.18" } ] }


Para la kata, la API externa debe considerarse un servicio de terceros. La API Key debe
configurarse mediante application.yml, variable de entorno o mecanismo equivalente. No
debe estar hardcodeada.
2. Requerimiento funcional
Implementar un endpoint:
GET /api/v1/treasury/30y/average
que reciba:
from to
como parámetros.
Ejemplo:
GET /api/v1/treasury/30y/average?from=2026-08-12&to=2026-08-18
Respuesta esperada:
{ "from": "2026-08-12", "to": "2026-08-18", "average": 5.21 }
El promedio debe calcularse utilizando únicamente las observaciones disponibles dentro
del rango de fechas solicitado.
API Cliente
Secret: 48c82a5d38725dad0f9299022c72a32f
https://api.stlouisfed.org/fred/series/observations?
series_id=DGS30&observation_start=2026-08-12&observation_end=2026-08-
12&file_type=json&api_key=48c82a5d38725dad0f9299022c72a32f
https://www.alphavantage.co/query?
function=TREASURY_YIELD&interval=daily&maturity=30year&observation_end=2026-
09-01&apikey=48c82a5d38725dad0f9299022c72a32f


FASE 2:
elegir Patron de arquitectura : centrado en el dominio. Eg: Hexagonal, 
 