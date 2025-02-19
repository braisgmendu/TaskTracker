# Task Tracker CLI

Task Tracker CLI es una herramienta de línea de comandos sencilla para gestionar tareas. Puedes agregar, actualizar, listar, marcar como completadas y eliminar tareas desde terminal.

## **Características**

- Añadir tareas con prioridad y descripción.
- Actualizar atributos de una tarea existente.
- Listar todas las tareas registradas.
- Marcar tareas con un estado específico.
- Eliminar tareas por su identificador.

---

## **Requisitos Previos**

Antes de ejecutar la aplicación, asegúrate de tener lo siguiente:

1. **Java Development Kit (JDK)** instalado (versión 8 o superior).
2. Configurada la variable de entorno `JAVA_HOME`.
3. Herramienta `Maven` para compilar el proyecto (opcional, si usas Maven).

---

## **Cómo Usar**

### **Compilación**
1. Clona el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd task-tracker-cli
2. Compila el proyecto
   ```bash
   javac -d out src/org/tasktracker/*.java
3. Ejecuta el programa
   ```bash
   java -cp out org.tasktracker.TaskCLI <command>
### **Ejemplo de Uso**
1. Agregar una Tarea
   ```bash
   java -cp out org.tasktracker.TaskCLI add
2. Actualizar una Tarea
   ```bash
   java -cp out org.tasktracker.TaskCLI update
3. Listar una Tareas
   ```bash
   java -cp out org.tasktracker.TaskCLI list
4. Borrar una Tareas
   ```bash
   java -cp out org.tasktracker.TaskCLI delete
5. Marcar una Tarea
    ```bash
    java -cp out org.tasktracker.TaskCLI mark

### **Formato de Tareas**
Cuando se utiliza el programa Task Tracker CLI, las tareas tienen los siguientes atributos:

| Atributo     | Tipo                | Descripción                                   | Ejemplo                     |
|--------------|---------------------|-----------------------------------------------|-----------------------------|
| `id`         | Número entero       | Identificador único de la tarea.             | `1`                         |
| `name`       | Cadena de texto     | Nombre o título de la tarea.                 | `Implementar login`         |
| `description`| Cadena de texto     | Descripción detallada de la tarea.           | `Crear una pantalla de login con validaciones` |
| `priority`   | Cadena de texto     | Prioridad de la tarea (`low`, `medium`, `high`). | `high`                     |
| `status`     | Cadena de texto     | Estado actual de la tarea (`todo`, `in-progress`, `done`). | `todo`              |
| `created`    | Fecha y hora (ISO)  | Fecha y hora en que se creó la tarea.         | `2025-02-18T14:30:00`       |
| `updated`    | Fecha y hora (ISO)  | Fecha y hora de la última actualización.      | `2025-02-19T10:15:00`       |
---

### **Notas Importantes**
- **Formato de Fecha y Hora**:
  - El programa utiliza el formato ISO 8601 (`YYYY-MM-DDTHH:mm:ss`) para manejar fechas y horas. Ejemplo: `2025-02-18T14:30:00`.
  - Este formato se utiliza para los campos `created` y `updated`.

- **Prioridad de Tareas**:
  - Valores válidos para el atributo `priority`:
    - `low`: Baja prioridad.
    - `medium`: Prioridad media.
    - `high`: Alta prioridad.

- **Estado de Tareas**:
  - Valores válidos para el atributo `status`:
    - `todo`: La tarea aún no ha comenzado.
    - `in-progress`: La tarea está en progreso.
    - `done`: La tarea se ha completado.

- **ID de las Tareas**:
  - El `id` de una tarea se genera automáticamente y es único. No es necesario que el usuario lo introduzca manualmente.

---

### **Ejemplo de una Tarea en Formato JSON**
```json
{
  "id": 1,
  "name": "Implementar login",
  "description": "Crear una pantalla de login con validaciones",
  "priority": "high",
  "status": "todo",
  "created": "2025-02-18T14:30:00",
  "updated": "2025-02-18T14:30:00"
}
