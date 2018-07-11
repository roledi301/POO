## Programación orientada a objetos 

El trabajo práctico se enmarca en el análisis de datos de un ensayo o conjunto de experimentos realizados a lo largo de un periodo de tiempo sobre una serie de bacterias, dicho periodo de tiempo puede incluir varios días. Cada experimento consiste en medir la actividad de una colonia de bacterias cinco veces al día durante tres días consecutivos.

A continuación se describen las entidades participantes en el problema, cada una de estas entidades deberán ser modelada como un tipo dentro de la aplicación.

<b>Organismo Procariota</b>
+ Propiedades:
  - Nombre: de tipo cadena, consultable y modificable.
+ Constructores: la clase ProcariotaImpl tendrá dos constructores:
  - Un constructor que recibe un valor para la propiedad nombre.
  - Un constructor por defecto.
+ Representación como cadena: la representación como cadena de un organismo procariota tendrá el siguiente formato: 
  - Nombre_de_organismo_procariota
+ Criterio de igualdad: 
  - Dos organismos procariota serán iguales si sus nombres son iguales.
+ Restricciones: 
  - No presenta ningún tipo de restricción.
+ FormaBacteria:
  - Tipo enumerado que se define a partir de los siguientes valores: FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES.

<b>Bacteria</b>

Subtipo de Procariota
+ Propiedades adicionales:
  - Código: de tipo entero, consultable.
  - Tamaño: de tipo real, consultable y modificable. Representa el tamaño en micrómetros.
  - Formas de la bacteria: de tipo lista de FormaBacteria, consultable y modificable.
  - Número de formas que posee: propiedad derivada de tipo Integer, consultable.
+ Constructores: la clase BacteriaImpl tendrá los siguientes constructores:
  - Un constructor que recibe un valor inicial para el código de la bacteria.
  - Un constructor que recibe un valor para la propiedad nombre y código.
  - Un constructor que recibe una cadena con el siguiente formato: nombreBacteria código tamaño forma_1 forma_2 … forma_n
+ Otros métodos:
  - Añadir forma: añadir forma determinada a la lista de formas que posee dicha bacteria.
  - Restricciones: el tamaño de la bacteria debe estar comprendido entre 0.5 y 5 micrometros. Si no se cumple esta restricción se lanzará la excepción BacteriaNoValidaException.
  - Representación como cadena: la representación como cadena de una bacteria tendrá el siguiente formato: nombreBacteria código tamaño[ forma_1, forma_2, … forma_n]
  - Criterio de igualdad: dos bacterias serán iguales si son ambas procariotas, sus códigos, tamaño y formas son iguales.
  -  Orden natural: las bacterias se ordenarán según orden lexicográfico del nombre, en caso de igualdad de nombre a través del orden natural de sus códigos.

<b>Experimento</b>
+ Propiedades:
  - Bacteria: de tipo Bacteria, consultable y modificable.
  - Mediciones: lista de Integer para almacenar las mediciones realizadas sobre la bacteria en el experimento. Consultable.
  - Fecha: de tipo LocalDate, consultable.
+ Constructores: la clase BacteriaImpl tendrá los siguientes constructores:
  - Un constructor que recibe un valor para cada una de las propiedades.
  - Un constructor que recibe una cadena con el siguiente formato: códigoExp:fecha:m1 m2 m3 m4 m5 m6 … Cómo ejemplo: 123:2015-12-03:2 4 5 2 3 1 1 1 1 1 2 4 3 4 3
+ Representación como cadena: la representación como cadena de un experimento tendrá el mismo formato que la cadena que recibe el constructor a partir de cadena.
+ Criterio de igualdad: dos experimentos serán iguales si sus propiedades son iguales.

La interfaz Ensayo tendrá un conjunto de métodos para ofrecer la siguiente funcionalidad:
  1. Dado dos parámetros de tipo cadena con los nombres de dos ficheros que contengan datos de las bacterias utilizadas y los experimentos realizados sobre ella, ver Figura 1 y 2, cargar la información de dichos ficheros.
  2. Calcular el tamaño medio de las bacterias del ensayo realizado.
  3. Devolver la bacteria con mayor diversidad de formas.
  4. Dada una fecha, devolver si todos los experimentos se han realizado con fecha posterior a la dada.
  5. Dada una forma de bacteria f, devolver el nombre de la bacteria con mayor número de experimentos y que tenga entre sus formas f.
  6. Devolver un Map relacionando a cada bacteria con el número de experimentos realizados sobre dicha bacteria.
  7. Dada una fecha, devolver el conjunto de bacterias sobre las que se haya realizado un experimento en dicha fecha ordenado según el código de las bacterias.
  8. Utilizando el ejercicio 6 y el método de la clase utilidad invierteMap, devolver el máximo número de experimentos realizados sobre una bacteria.
  9. Devolver el conjunto de bacterias de todo el ensayo en un Map relacionando a cada bacteria con el mayor valor medio obtenido en su conjunto de experimentos. Nota: para este ejercicio implemente una función que dada una lista de valores reales, devuelva el valor medio de dichos valores.
  10. Dada una fecha y un código de bacteria, devolver si existe o no un experimento sobre esa bacteria y con la fecha dada.
