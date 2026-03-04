# 📘 Manual de Arquitectura y Buenas Prácticas en POO (Java)

---

## Arquitectura de Software (Separation of Concerns (SoC))

El principio de **Separación de Responsabilidades** (SoC) dicta que un programa debe dividirse en secciones distintas, donde cada sección aborda una preocupación específica. Huimos de la "arquitectura plana" (todos los archivos en la misma carpeta) para estructurar el proyecto en capas lógicas.

### 📂 Estructura de Capas (Directorios)

* **`/models`:** Clases pasivas que representan el dominio del problema. Su única responsabilidad es guardar estado y garantizar que sus propios datos sean válidos . No saben nada del funcionamiento global del programa.
* **`/services`:** Clases activas que coordinan el sistema. Contienen la **lógica de negocio**.
* **`/exceptions`:** Excepciones personalizadas.
* **`/enums`:** Constantes fuertemente tipadas.

#### Principio 'Single Source of Truth'
Uno de los errores más comunes es duplicar datos. Si `GestorParque` ya tiene un `ArrayList<Dinosaurio>`, `Main` **no debe** tener otra lista paralela con los mismos dinosaurios.

* Si eliminas un dinosaurio del gestor, la lista del `Main` quedará desactualizada (inconsistencia de datos).
* **Buenas prácticas:** Delega siempre en el propietario de los datos. Si `Main` necesita mostrar los dinosaurios, se los pide al gestor mediante `gestor.getAll()`.

## Buenas Prácticas Fundamentales en POO y Encapsulación

### 🔒 Encapsulación Blindada

* **Propiedades SIEMPRE `private`:** Todo atributo debe ser `private` por defecto.
* **Setters Privados (Inmutabilidad parcial):** Si los atributos no van a cambiar nunca una vez que el objeto nace, su método `set` debe ser `private`. Solo el constructor podrá usarlo. Esto evita que otro programador cambie el nombre del dinosaurio a mitad de la ejecución del programa.

### Validación Centralizada 

No asignamos los valores directamente en el constructor (`this.nombre = p_nombre;`).

* **La Mejor Práctica:** El constructor **siempre** debe delegar la asignación a los métodos `setters`.
* **¿Por qué?** Porque los `setters` son los guardianes de la clase. En ellos colocamos las **validaciones**. Si validamos en `set` y el constructor llama al `set`, nos aseguramos de que es imposible instanciar un objeto con datos inválidos.

**Ejemplo de Arquitectura Robusta:**
```java
public class Actividad {
    
    private String m_strNombre;
    
    private void setNombre(String value) throws DatosInvalidosException {
        if (value == null || value.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre no puede estar vacío.");
        }
        this.m_strNombre = value;
    }

    public Actividad(String p_strNombre) throws DatosInvalidosException {
        setNombre(p_strNombre);
    }  
}
```
### Uso de Constantes

Usamos constantes en la cabecera de la clase con **`private static final int MAX_ACTIVIDADES_DIA = 10;`**. Así, el código se documenta a sí mismo y si el límite cambia mañana, solo lo modificamos en un sitio.