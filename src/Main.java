import java.util.Scanner;

/**
 * ============================================================
 * Sobrecarga de métodos + constantes + tipos
 * ============================================================
 *
 * Este programa sirve para practicar varios conceptos básicos
 * e importantes de Java dentro de una sola clase:
 *
 * 1) Estructura básica de una clase en Java
 * 2) Constantes usando static final
 * 3) Variables primitivas y variables de referencia
 * 4) Métodos y sobrecarga de métodos
 * 5) Operadores relacionales
 * 6) Condicionales if / else if / else
 * 7) Uso de return para devolver valores
 * 8) Entrada de datos por teclado con Scanner
 * 9) Diferencia entre atributos de clase y variables locales
 *
 * ------------------------------------------------------------
 * IDEA GENERAL DEL PROGRAMA
 * ------------------------------------------------------------
 * - Se declaran varias constantes relacionadas con notas,
 *   IVA, precios y descuentos.
 * - Se declaran también atributos estáticos para guardar
 *   datos de una persona.
 * - En el método main() se llama al método leerDatos(),
 *   que pide datos al usuario por teclado.
 * - Además, existen tres métodos llamados "saludar", lo que
 *   permite practicar la SOBRECARGA DE MÉTODOS.
 *
 * ------------------------------------------------------------
 * IMPORTANTE SOBRE LA SOBRECARGA
 * ------------------------------------------------------------
 * En Java, varios métodos pueden tener el mismo nombre
 * siempre que cambie su lista de parámetros:
 *
 *   saludar()
 *   saludar(String nombre)
 *   saludar(String nombre, int edad)
 *
 * Eso NO da error porque Java distingue cada método por:
 * - cantidad de parámetros
 * - tipo de parámetros
 * - orden de los parámetros
 *
 * El tipo de retorno por sí solo NO sirve para sobrecargar.
 */

public class Main {

    /* =========================================================
       1) CONSTANTES (static final)
       ---------------------------------------------------------
       ¿Qué significa cada palabra?

       - static:
         La variable pertenece a la clase, no a un objeto.
         Como todos los métodos de este ejemplo son static,
         pueden acceder directamente a estas constantes.

       - final:
         Una vez asignado el valor, NO puede cambiar.
         Es decir, funciona como una constante.

       - Convención de nombres:
         En Java, las constantes se escriben normalmente en
         MAYÚSCULAS y separando palabras con guion bajo.

       - Ventaja:
         Evitan usar "números mágicos", es decir, valores
         escritos directamente por el código sin explicar
         su significado.

       Ejemplo:
         if (nota >= 5.0)   // menos claro
         if (nota >= NOTA_APROBADO) // más claro
       ========================================================= */

    static final double NOTA_APROBADO = 5.0;          // Nota mínima para aprobar una asignatura
    static final double IVA = 0.10;                   // IVA del 10% expresado en formato decimal
    static final double PRECIO_BASE = 500.0;          // Precio base de una matrícula
    static final double DESC_FAMILIA_NUMEROSA = 0.10; // Descuento del 10% para familia numerosa


    /* =========================================================
       2) ATRIBUTOS O VARIABLES DE CLASE
       ---------------------------------------------------------
       Estas variables están declaradas dentro de la clase
       pero fuera de cualquier método.

       Por eso se llaman:
       - atributos de clase
       - variables globales de la clase (de forma informal)

       Como además son static:
       - pertenecen a la clase Main
       - pueden ser usadas directamente desde main() y desde
         otros métodos static sin crear un objeto

       DIFERENCIA CON VARIABLES LOCALES
       ---------------------------------------------------------
       - Un atributo de clase "vive" mientras el programa lo
         necesite y puede ser usado por distintos métodos.
       - Una variable local se declara dentro de un método y
         solo existe dentro de ese método.

       En este programa se usan para guardar datos leídos
       desde teclado.
       ========================================================= */

    // ---------------------------------------------------------
    // Tipo de referencia:
    // String NO es un tipo primitivo; es una clase.
    // Por eso se considera una variable de referencia.
    // Guardará el nombre introducido por el usuario.
    // ---------------------------------------------------------
    static String nombre;

    // ---------------------------------------------------------
    // Tipos primitivos:
    //
    // int     -> números enteros
    // double  -> números con decimales
    // boolean -> valores lógicos: true o false
    //
    // Se declaran aquí para poder ser utilizados desde
    // distintos métodos.
    // ---------------------------------------------------------
    static int edad;
    static double nota1;
    static double nota2;
    static boolean familiaNumerosa;

    // ---------------------------------------------------------
    // Objeto Scanner para leer datos por teclado.
    //
    // System.in representa la entrada estándar del sistema,
    // normalmente el teclado.
    //
    // Se declara static para poder usarlo desde métodos static
    // como main() o leerDatos().
    // ---------------------------------------------------------
    static Scanner sc = new Scanner(System.in);


    /* =========================================================
       3) MÉTODO MAIN
       ---------------------------------------------------------
       El método main es el punto de entrada del programa.
       Cuando se ejecuta una aplicación Java, la JVM busca
       exactamente este método:

           public static void main(String[] args)

       SIGNIFICADO:
       - public: accesible desde fuera de la clase
       - static: se ejecuta sin necesidad de crear objetos
       - void: no devuelve ningún valor
       - String[] args: array de cadenas con argumentos
         recibidos al ejecutar el programa
       ========================================================= */

    public static void main(String[] args) {

        /*
        // -----------------------------------------------------
        // EJEMPLOS DE LLAMADAS A LOS MÉTODOS SOBRECARGADOS
        // -----------------------------------------------------

        // 1) Llamada al método sin parámetros
        // Se ejecutará: saludar()
        saludar();

        // 2) Llamada al método con un parámetro String
        // Se ejecutará: saludar(String nombre)
        saludar("Pepe");

        // 3) Llamada al método con dos parámetros
        // Se ejecutará: saludar(String nombre, int edad)
        //
        // IMPORTANTE:
        // Este método NO imprime nada directamente.
        // Lo que hace es DEVOLVER un String con return.
        // Por eso, si queremos verlo por pantalla,
        // tenemos que imprimir el valor devuelto:
        System.out.println(saludar("María", 21));
        */

        // Llamamos al método encargado de pedir datos al usuario
        leerDatos();
    }

    /* =========================================================
       4) MÉTODO leerDatos()
       ---------------------------------------------------------
       Este método:
       - no recibe parámetros
       - no devuelve nada (void)
       - se encarga de pedir datos al usuario
       - realiza algunas comprobaciones con if / else

       Aquí se practican:
       - lectura por teclado
       - validación de cadenas
       - comparación de enteros
       - condicionales encadenados
       ========================================================= */
    static void leerDatos() {

        // Pedimos el nombre sin salto de línea usando print()
        // para que el usuario escriba justo a continuación.
        System.out.print("Nombre: ");

        // nextLine() lee toda la línea escrita por el usuario
        // hasta pulsar Enter.
        nombre = sc.nextLine();

        // -----------------------------------------------------
        // VALIDACIÓN DEL NOMBRE
        // -----------------------------------------------------
        // nombre.equals("")
        //   Comprueba si la cadena está vacía exactamente.
        //
        // nombre.trim().equals("")
        //   trim() elimina espacios al principio y al final.
        //   Así detectamos también casos como:
        //   "   "
        //
        // Si cualquiera de las dos condiciones es verdadera,
        // significa que el nombre no se ha introducido
        // correctamente.
        //
        // Operador ||  -> OR lógico
        // Devuelve true si al menos una condición es verdadera.
        // -----------------------------------------------------
        if (nombre.equals("") || nombre.trim().equals("")) {
            System.out.println("El nombre no puede quedar vacío");
        }

        // Mostramos mensaje para pedir la edad.
        // Aquí usas println(), así que el cursor baja a la
        // siguiente línea antes de que el usuario escriba.
        // También podrías usar print("Edad: ");
        System.out.println("Edad: ");

        // nextInt() lee un número entero.
        edad = sc.nextInt();

        // -----------------------------------------------------
        // COMPARACIÓN CON !=
        // -----------------------------------------------------
        // != significa "distinto de"
        //
        // Si la edad NO es exactamente 20, mostramos el mensaje.
        // -----------------------------------------------------
        if (edad != 20) {
            System.out.println("No Tienes 20 años");
        }

        // -----------------------------------------------------
        // CLASIFICACIÓN POR EDAD
        // -----------------------------------------------------
        // if / else if / else permite evaluar varias
        // posibilidades mutuamente excluyentes.
        //
        // CASOS:
        // - Si edad < 18       -> menor de edad
        // - Si no, y edad <=55 -> mediana edad
        // - Si no              -> mayor de 55
        //
        // IMPORTANTE:
        // El segundo bloque solo se comprueba si el primero
        // ha sido falso.
        // -----------------------------------------------------
        if (edad < 18) {
            System.out.println("es menor de edad");
        } else if (edad <= 55) {
            System.out.println("es de mediana edad");
        } else {
            System.out.println("es maduric@");
        }
    }


    /* =========================================================
       5) MÉTODO 1: saludar()
       ---------------------------------------------------------
       CARACTERÍSTICAS:
       - No recibe parámetros
       - No devuelve valor
       - Tipo de retorno: void
       - Imprime directamente un mensaje en pantalla

       Este es el primer método de la familia "saludar".
       ========================================================= */
    static void saludar() {

        // Este método simplemente muestra un texto fijo.
        // Como es void, termina sin devolver nada.
        System.out.println("Hola ke ase");
    }


    /* =========================================================
       6) MÉTODO 2: saludar(String nombre)
       ---------------------------------------------------------
       CARACTERÍSTICAS:
       - Recibe un parámetro de tipo String
       - No devuelve valor
       - Imprime directamente el saludo

       SOBRECARGA:
       Tiene el mismo nombre que el método anterior, pero
       se diferencia porque ahora recibe un parámetro.
       ========================================================= */
    static void saludar(String nombre) {

        // Concatenación de cadenas con el operador +
        // Se une el texto "Hola " con el contenido de la
        // variable nombre.
        System.out.println("Hola " + nombre);
    }


    /* =========================================================
       7) MÉTODO 3: saludar(String nombre, int edad)
       ---------------------------------------------------------
       CARACTERÍSTICAS:
       - Recibe dos parámetros:
            * nombre -> String
            * edad   -> int
       - Devuelve un String
       - NO imprime directamente

       AQUÍ SE PRACTICA:
       - Sobrecarga de métodos
       - Variables locales
       - Operador relacional <
       - Condicional if / else
       - Construcción de cadenas
       - Uso de return
       ========================================================= */
    static String saludar(String nombre, int edad) {

        // -----------------------------------------------------
        // VARIABLE LOCAL
        // -----------------------------------------------------
        // Esta variable solo existe dentro de este método.
        // No se puede usar fuera de él.
        //
        // Guardará una parte del mensaje final según la edad.
        // -----------------------------------------------------
        String mensajeEsMenor;

        // -----------------------------------------------------
        // OPERADOR RELACIONAL <
        // -----------------------------------------------------
        // La expresión (edad < 18) produce un boolean:
        // - true  -> si edad es menor que 18
        // - false -> si edad es 18 o más
        // -----------------------------------------------------
        if (edad < 18) {

            // Si la condición es verdadera, asignamos este texto
            mensajeEsMenor = "eres menor de edad";

        } else {

            // Si la condición es falsa, asignamos este otro texto
            mensajeEsMenor = "eres mayor de edad";
        }

        // -----------------------------------------------------
        // RETURN
        // -----------------------------------------------------
        // En vez de imprimir, este método devuelve un String.
        // El código que lo llame decidirá qué hacer con ese
        // valor: imprimirlo, guardarlo en una variable, etc.
        //
        // Ejemplo:
        // String saludo = saludar("Ana", 17);
        // System.out.println(saludo);
        // -----------------------------------------------------
        return "Hola " + nombre + " " + mensajeEsMenor;
    }

}