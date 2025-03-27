# 🐾 Simulador de Centro de Adopción de Mascotas – Proyecto Java POO

Este proyecto simula la operación de un centro de adopción de mascotas, permitiendo gestionar clientes, animales en adopción y mascotas en guardería. Desarrollado aplicando principios de **Programación Orientada a Objetos (POO)** en Java, este sistema integra herencia, polimorfismo, encapsulamiento, manejo de excepciones y persistencia de datos.

---

## 🎯 Funcionalidades principales

- Rescate y registro de mascotas (Perros y Gatos).
- Adopción de mascotas por parte de personas.
- Cambio de nombre de mascotas adoptadas.
- Guardería para mascotas adoptadas.
- Interacción con mascotas (jugar, bañar, cortar uñas).
- Visualización de clientes y sus mascotas.
- Persistencia de datos al cerrar el programa.
- Registro de errores en archivo de texto.

---

## 🧱 Estructura del proyecto


---

## 🧠 Conceptos POO aplicados

| Concepto         | Aplicación                                                       |
|------------------|------------------------------------------------------------------|
| **Herencia**     | `Perro` y `Gato` heredan de `Mascota`                            |
| **Polimorfismo** | Método `jugar()` redefinido según el tipo de mascota             |
| **Encapsulamiento** | Uso de getters y setters en todas las clases                    |
| **Relaciones**   | Una `Persona` puede tener muchas `Mascotas`                      |
| **Excepciones**  | Validación de cédulas, fechas inválidas, edad máxima, etc.       |
| **Persistencia** | Guardado de mascotas y errores en archivos `.bin` y `.txt`       |

---

## 🖥️ Cómo ejecutar el proyecto

### 🔧 Requisitos
- Java JDK 8+
- Eclipse IDE (opcional pero recomendado)

### ▶️ Instrucciones

1. **Importar proyecto en Eclipse:**
   - Selecciona _File > Import > Existing Projects into Workspace_
   - Elige la carpeta `Proyecto2/`

2. **Ejecutar el programa:**
   - Corre la clase `Principal.java` ubicada en `src/Interfaz/`

3. **Uso del menú interactivo:**
   - Rescatar mascotas
   - Adoptar mascotas
   - Cambiar nombre
   - Guardería (dejar o recoger)
   - Interacciones
   - Guardar y salir

---

## 💾 Persistencia

- `adopcion.bin`: guarda automáticamente las mascotas rescatadas.
- `excepciones.txt`: registra fecha, hora y descripción de cada excepción.

---

## 🧪 Excepciones personalizadas

- Mascota con edad mayor a 30 años → `"Este perro es demasiado viejo para estar vivo"`
- Cédula inválida (≠10 dígitos) → `"Cédula no válida"`
- Entrada incorrecta de datos numéricos o fechas → manejo con bucles y validaciones.

---

## 📚 Créditos

Proyecto desarrollado como parte del curso de **Programación Avanzada**  
Pontificia Universidad Javeriana – Facultad de Ingeniería

---

## 👨‍💻 Autor

**Francisco Guzmán**  
📧 franciscoguzmanv11@gmail.com  
🐙 [GitHub](https://github.com/Pacho73G)

---

