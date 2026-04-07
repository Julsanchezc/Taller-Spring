# Taller-Spring

## Integrantes del grupo
- Omar Daniel Calvache Madroñero
- Julia Santiago Sanchez Castro

---


# Taller 1 – Ejercicio 1
## Sistema de Generación de Alertas (Beans manuales)
En este proyecto se desarrolló un sistema para generar alertas internas utilizando Spring.
Se aplicó inyección de dependencias mediante beans definidos manualmente, 
siguiendo el principio de bajo acoplamiento.

Se definieron las interfaces GeneradorAlerta y SistemaMonitoreo, junto con múltiples 
implementaciones (alertas críticas e informativas). Esto permite que el sistema 
sea fácilmente extensible agregando nuevas estrategias de alerta.

### ¿Cómo se utiliza?
Todas las implementaciones están registradas como beans de forma manual en la clase
de configuración 'AppConfig'.
El sistema de monitoreo obtiene el generador de alertas a través de inyección de dependencias:

ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
SistemaMonitoreo sistema = context.getBean(SistemaMonitoreo.class);
sistema.ejecutarAlerta();
Para cambiar el tipo de alerta, solo se debe modificar la inyección de dependencias en AppConfig:

@Bean
public SistemaMonitoreo sistemaMonitoreo(GeneradorAlerta alerta) {
    return new SistemaMonitoreoImpl(alerta); //Aquí se puede pasar alertaCritica() o alertaInformativa()
}

---
# Taller 1 – Ejercicio 2

## Implementación de Conversores

En esta parte del proyecto se desarrolló un sistema de conversión de unidades
utilizando Spring, aplicando inyección de dependencias y el principio de bajo
acoplamiento.

Se definió una interfaz `Conversor` y múltiples implementaciones para diferentes
tipos de conversión (temperatura y distancia), permitiendo extender el sistema
fácilmente agregando nuevas clases.

### ¿Cómo se utiliza?

Todas las implementaciones están registradas como beans con `@Component`.  
Para seleccionar qué conversión utilizar, se usa la anotación `@Qualifier`
en la clase `ConversorApp`:
```java
public ConversorApp(@Qualifier("conversorMillasAKm") Conversor conversor) {
    this.conversor = conversor;
}
```

Solo es necesario cambiar el valor del `@Qualifier` para usar una conversión
diferente.

---

# Taller 2 – Ejercicio 1

## Consumo de API externa con Spring (PokeAPI)

Se desarrolló una aplicación que consulta información de Pokémon desde la
[PokeAPI](https://pokeapi.co/api/v2) usando `RestTemplate` de Spring Web.

La aplicación obtiene una lista de 5 Pokémon y por cada uno consulta su
endpoint de detalle para mostrar nombre, tipos, habilidades, peso y altura.

### Preguntas de análisis

**1. ¿Cómo se obtiene la URL de detalle de cada Pokémon?**  
El endpoint `/pokemon` retorna un array `results` donde cada objeto tiene
un campo `url` con la dirección exacta del detalle de ese Pokémon.
Esa URL se usa directamente para la segunda llamada sin construirla manualmente.

**2. ¿Qué estructura tiene la respuesta del endpoint principal?**  
La respuesta es un objeto JSON con cuatro campos: `count` (total de Pokémon
en la API), `next` y `previous` (paginación), y `results` (lista de objetos
con `name` y `url`). Todo está mapeado en el DTO `PokemonListResponse`.

**3. ¿Cuántas llamadas HTTP realiza el sistema en total?**  
6 llamadas: 1 al endpoint de lista `/pokemon?limit=5` y 5 adicionales,
una por cada Pokémon para obtener su detalle.

**4. ¿Qué ventajas tiene separar la lógica en servicios?**  
Permite probar cada componente de forma independiente, reutilizar la lógica
en distintos contextos, y mantener el principio de responsabilidad única.
`PokemonApplication` solo orquesta; `PokemonService` contiene toda la lógica
de negocio.

### Herramientas utilizadas
- Spring Boot 3.2
- RestTemplate (Spring Web)
- Jackson (mapeo JSON → DTOs)
- Java 17

