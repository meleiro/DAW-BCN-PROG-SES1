/**
 * ============================================================
 *  Sobrecarga de métodos + constantes + tipos
 * ============================================================
 *
 * Este programa sirve para trabajar:
 *
 * 1) Estructura básica de una clase en Java
 * 2) Constantes (static final)
 * 3) Variables primitivas y de referencia
 * 4) Métodos y sobrecarga (mismo nombre, distintos parámetros)
 * 5) Operadores relacionales (<)
 * 6) Estructuras condicionales (if / else)
 * 7) Retorno de valores (return)
 *
 *
 */

public class Main {

    /* =========================================================
       1) CONSTANTES (static final)
       ---------------------------------------------------------
       - "static": pertenece a la clase (no a un objeto).
       - "final": su valor NO puede cambiar.
       - Convención: MAYÚSCULAS con guiones bajos.
       - Evitan "números mágicos".
       ========================================================= */

    static final double NOTA_APROBADO = 5.0;         // Nota mínima para aprobar
    static final double IVA = 0.10;                  // 10% de IVA
    static final double PRECIO_BASE = 500.0;         // Precio base matrícula
    static final double DESC_FAMILIA_NUMEROSA = 0.10;// 10% descuento


    /* =========================================================
       2) ATRIBUTOS (variables de clase)
       ---------------------------------------------------------
       - Declaradas fuera de main()
       - Son compartidas por todos los métodos static
       - Aquí no se usan aún, pero sirven para practicar tipos
       ========================================================= */

    // Tipo de referencia (objeto)
    static String nombre;

    // Tipos primitivos
    static int edad;
    static double nota1;
    static double nota2;
    static boolean familiaNumerosa;


    /* =========================================================
       3) MÉTODO MAIN
       ---------------------------------------------------------
       - Punto de entrada del programa
       - Es static porque la JVM lo ejecuta sin crear objetos
       ========================================================= */

    public static void main(String[] args) {

        // Llamada al método sin parámetros
        saludar();

        // Llamada al método con un parámetro String
        saludar("Pepe");

        // Llamada al método que devuelve un String
        // IMPORTANTE:
        // Este método NO imprime nada.
        // Devuelve un texto.
        // Por eso lo envolvemos en System.out.println()
        System.out.println(saludar("María", 21));

    }


    /* =========================================================
       4) MÉTODO 1: sin parámetros, sin retorno
       ---------------------------------------------------------
       - Tipo: void (no devuelve nada)
       - Solo imprime directamente
       ========================================================= */
    static void saludar(){
        System.out.println("Hola ke ase");
    }


    /* =========================================================
       5) MÉTODO 2: recibe un parámetro, no devuelve nada
       ---------------------------------------------------------
       - Sobrecarga: mismo nombre "saludar"
       - Diferencia: ahora recibe un String
       - Java decide cuál ejecutar según parámetros
       ========================================================= */
    static void saludar(String nombre) {
        System.out.println("Hola " + nombre);
    }


    /* =========================================================
       6) MÉTODO 3: recibe dos parámetros y devuelve un String
       ---------------------------------------------------------
       - Sobrecarga de método
       - Parámetros:
           * nombre (String)
           * edad (int)
       - Retorna un String
       - Practica:
           * Operador relacional <
           * If / else
           * Construcción de cadenas
           * Return
       ========================================================= */
    static String saludar(String nombre, int edad) {

        // Variable local:
        // Solo existe dentro de este método (concepto de alcance / scope)
        String mensajeEsMenor;

        // Operador relacional:
        // < devuelve true o false
        if ( edad < 18 ) {

            // Si la condición es verdadera
            mensajeEsMenor = "eres menor de edad";

        } else {

            // Si la condición es falsa
            mensajeEsMenor = "eres mayor de edad";
        }

        // Concatenación de Strings con operador +
        // Aquí se construye el mensaje final
        return "Hola " + nombre + " " + mensajeEsMenor;

    }

}