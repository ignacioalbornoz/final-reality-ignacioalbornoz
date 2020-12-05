Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---
Proyecto para el curso de Metodologías de Diseño y Programación CC3002, cursado en el semestre de primavera del 2020, FCFM, Universidad de Chile. <br>
#### Autor: <br>
Ignacio Albornoz Alfaro <br>
Estudiante Ingeniería Civil en Computación <br>
Facultad de Ciencias Físicas y Matemáticas <br>
Universidad de Chile <br>
ignacio.albornoz@ug.uchile.cl<br>

El contexto del proyecto es el siguiente: <br>
El objetivo de este proyecto es crear un clon (simplificado) del combate de _Final Fantasy_, un juego desarrollado por [_Square Enix_] (https://www.square-enix.com). En términos generales, para el combate, el jugador tiene un grupo de personajes para control y un grupo de enemigos controlados por la computadora.

Dado lo anterior, a continuación se procede a describir la implementación del juego realizada por el autor, se debe tener en cuenta que lo mostrado corresponde a la primera entrega parcial del resultado final.

## Juego
### Personajes
Hasta la última versión, el juego cuenta con 6 tipos de unidades, las cuales comparten las siguientes características, que se implementan como variables de clase en código:
- **turnsQueue**: Corresponde al turno que tendrá el personaje dentro de la lista de personajes.
- **name**: Corresponde al nombre del personaje.
- **equippedWeapon**: Corresponde al arma equipada en el personaje. Todos los personajes se crean con un arma nula.

Los personajes pueden agruparse en los siguientes tipos:

- **Magos**

- **No Magos**

- **Enemigos** 

Dentro de los magos se encuentran:

- **BlackMage**
- **WhiteMage**

Dentro de los no magos se encuentran:

- **Knight**
- **Engineer**
- **Thief**

Dentro de los enemigos se encuentran:

- **Enemy**


Todas las unidades mencionadas, a excepción de *Enemigos*, pueden llevar armas. No pueden equiparse armas y tienen una característica adicional llamada 'weight' que corresponde al peso del personaje.
Cada personaje se inicializa con **equippedWeapon = new WeaponNull()**, es decir con el arma nula.
El contrato de comportamiento y funcionalidad de todos los personajes se implementó a través de la interfaz **ICharacter**, la cual establece los métodos públicos que debe tener cada instancia de algún personaje, es decir, **getters, waitTurn(), equip()**
El contrato de comportamiento y funcionalidad de todos los enemigos se implementó a través de la interfaz **IEnemy**, la cual establece un método para obtener el peso.
Se implementan las interfaces vacías *IPlayerCharacter* *IMage* *INonMage* para una mayor extensibilidad.


El comportamiento común a todos los personajes se ha definido en la clase abstracta **AbstractCharacter**, la cual cuenta con los siguientes métodos:
- **AbstractCharacter**: Corresponde al constructor que se utiliza para las subclases, el cual toma como parámetros *turnsQueue, name*, asegurándose que sean válidos, es decir que no sean nulos.
- **getters**: se tienen métodos para obtener la información de una instancia de alguna de las subclases, recuperando *name, equippedWeapon*.
- **addToQueue**: Método añade el turno del personaje a la lista de turnos de todos los personajes.
- **equip**: Método que equipa un arma al personaje.
- **waitTurn**: Método que establece un ejecutor programado para hacer que el personaje espere unos segundos antes de agregarlo a la cola.
- **waitTurnPlayer**: Método **waitTurn** específico para los personajes del jugador.
- **waitTurnEnemy**: Método **waitTurn** específico para los enemigos.
- **respondWaitTurn**: Método que devuelve como debe responder cada clase al método waitTurn.

El comportamiento común a todos los personajes del jugador se ha definido en la clase abstracta **AbstractPlayerCharacter**, la cual cuenta con los siguientes métodos:
- **equals**: Define si dos items comparados son iguales, para ello se debe cumplir que todos los campos de as variables de clase sean iguales.
- **hashCode**: Método para asignarle un **hashcode** a la secuencia de clase y nombre del personaje.
- **respondWaitTurn**: Método que devuelve como debe responder esta clase al método **waitTurn**.

El comportamiento común a todos los personajes enemigos se ha definido en la clase abstracta **AbstractEnemy**, la cual cuenta con los siguientes métodos:
- **equals**: Define si dos items comparados son iguales, para ello se debe cumplir que todos los campos de as variables de clase sean iguales.
- **hashCode**: Método para asignarle un **hashcode** a la secuencia de nombre, peso y clase del personaje.
- **respondWaitTurn**: Método que devuelve como debe responder esta clase al método **waitTurn**.

### Armas
Son objetos que los personajes pueden portar, equiparse y utilizar. Cada *weapon* tiene los siguientes campos o variables de clase:
- **name**: Nombre que se le asigna al arma. Corresponde a un *String*.
- **weight**: Corresponde al peso del arma.Se implementa a través de un ***int***.
- **damage**: Corresponde al daño del arma. Se implementa a través de un ***int***.

Los tipos de armas son:

El comportamiento común a todas las armas se ha definido en la clase abstracta **AbstractWeapon**, la cual cuenta con los siguientes métodos:
- **AbstractWeapon**: Corresponde al constructor que se utiliza para las subclases, el cual toma como parámetros *name, weight, damage*, asegurándose que el nombre de un arma sea válido, es decir que no sea nulo.
- **equals**: Define si dos items comparados son iguales, para ello se debe cumplir que todos los campos de as variables de clase sean iguales.
- **getters**: se tienen métodos para obtener la información de una instancia de alguna de las subclases, recuperando *name, weight, damage*.
- **hashCode**: Método para asignarle un **hashcode** a la secuencia *name, weight, damage* del arma.
- **isNull**: Método que retorna true si el arma es del tipo **WeaponNull** y false en caso contrario.

El contrato de comportamiento y funcionalidad que debe cumplir cada objeto se implementó mediante la interfaz **IWeapon**, la cual contiene la firma de los métodos públicos comunes a todos las armas. Los cuales son los getters e isNull descritos en el párrafo anterior, además de un nuevo getter **getType** que retorna el tipo de arma.
## Tests

Para la correcta ejecución de los tests se debe en primer lugar clonar el repositorio:

`$ git clone https://github.com/CC3002-Metodologias/final-reality-ignacioalbornoz`

Luego, las versiones utilizadas corresponen a:
- Versión de java: `$ java -version` = 14.0.2
- Versión de JUnit: 5.1
- Entorno de ejecución: IntelliJ IDEA Ultimate versión 2020.2 

Luego, una vez se cumpla con estas especificaciones, se tiene que se debe abrir el proyecto con IntelliJ, una vez realizado esto, se debieran observar las carpetas `main` y`test` dentro de `src`. Se debe asegurar que JUnit fue agregado como librería al proyecto, esto en general lo sugiere IntelliJ al notar que hay comandos que requieren de ella.

Una vez realizado lo anterior, y chequeando que no existe ningún error señalado por el IDE, en caso contrario contactar al autor, se debe proceder a ejecutar los tests. Para ello, basta con visualizar el menu desplegable (click derecho) sobre la carpeta `test`, dentro de las opciones hay dos que son de interés:
- **Run 'All Tests'**: Ejecuta todos los tests señalando la cantidad de estos, el tiempo que tomó y en caso de existir un error de implementación o compilación señalarlo.
- **Run 'All Tests´ with Coverage**: Ejecuta todo los tests señalando la cantidad de estos, el tiempo que tomó y en caso de existir un error de implementación o compilación señalarlo, además agrega el porcentaje de *Coverage* de métodos y líneas del código, señalando en cada clase que métodos y líneas fueron testeados y cuales no.

