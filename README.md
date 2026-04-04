# Taller-Spring
## Integrantes del grupo
- Omar Daniel Calvache Madroñero



# Taller 1 Ejercicio 2

## Implementación de Conversores

En esta parte del proyecto se desarrolló un sistema de conversión de unidades utilizando Spring, aplicando inyección de dependencias y el principio de bajo acoplamiento.

Se definió una interfaz `Conversor` y múltiples implementaciones para diferentes tipos de conversión (temperatura y distancia), permitiendo extender el sistema fácilmente agregando nuevas clases.

---

## ¿Cómo se utiliza?

Todas las implementaciones están registradas como beans con `@Component`.  
Para seleccionar qué conversión utilizar, se usa la anotación `@Qualifier` en la clase `ConversorApp`.

Ejemplo:

```java
public ConversorApp(@Qualifier("conversorMillasAKm") Conversor conversor) {
    this.conversor = conversor;
}
```

Solo es necesario cambiar el valor del `@Qualifier` para usar una conversión diferente.
