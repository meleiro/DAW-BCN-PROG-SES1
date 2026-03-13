import java.util.Locale;
import java.util.Scanner;

/**
 * ============================================================
 * Sobrecarga de métodos + constantes + tipos
 * ============================================================
 *
 * Este programa reúne en una sola clase varios conceptos
 * fundamentales de Java para poder practicarlos juntos.
 *
 * ------------------------------------------------------------
 * CONTENIDOS QUE SE TRABAJAN
 * ------------------------------------------------------------
 * 1) Estructura básica de una clase en Java
 * 2) Uso de constantes con static final
 * 3) Diferencia entre tipos primitivos y tipos de referencia
 * 4) Atributos de clase frente a variables locales
 * 5) Lectura de datos por teclado con Scanner
 * 6) Operadores aritméticos, relacionales y lógicos
 * 7) Condicionales if / else if / else
 * 8) Casting implícito y casting explícito
 * 9) Métodos y sobrecarga de métodos
 * 10) Uso de return para devolver valores
 *
 * ------------------------------------------------------------
 * IDEA GENERAL DEL PROGRAMA
 * ------------------------------------------------------------
 * - Se definen constantes que representan reglas fijas del sistema.
 * - Se declaran atributos estáticos para almacenar datos del usuario.
 * - Existen métodos para leer datos, saludar y practicar decisiones.
 * - En main() se muestran ejemplos de conversión de tipos.
 * - También hay varios métodos llamados "saludar" para practicar
 *   la sobrecarga de métodos.
 *
 * ------------------------------------------------------------
 * IMPORTANTE SOBRE LA SOBRECARGA DE MÉTODOS
 * ------------------------------------------------------------
 * En Java, dos o más métodos pueden tener el mismo nombre
 * SIEMPRE que cambien sus parámetros.
 *
 * Ejemplos válidos de sobrecarga:
 *
 *   saludar()
 *   saludar(String nombre)
 *   saludar(String nombre, int edad)
 *
 * Java distingue estos métodos por:
 * - número de parámetros
 * - tipo de los parámetros
 * - orden de los parámetros
 *
 * OJO:
 * El tipo de retorno por sí solo NO sirve para sobrecargar.
 * Es decir, esto NO sería válido:
 *
 *   int ejemplo()
 *   double ejemplo()
 *
 * si ambos tienen exactamente los mismos parámetros.
 */

public class Main {

    /* =========================================================
       1) CONSTANTES (static final)
       ---------------------------------------------------------
       ¿Qué significa cada palabra?

       - static:
         La variable pertenece a la clase, no a un objeto.
         Eso permite usarla desde métodos static como main()
         sin tener que crear antes un objeto de tipo Main.

       - final:
         Su valor se asigna una vez y ya no puede cambiar.
         Por tanto, funciona como constante.

       ---------------------------------------------------------
       ¿Por qué usar constantes?
       ---------------------------------------------------------
       - Hacen el código más claro.
       - Evitan repetir valores "mágicos" por el programa.
       - Si una regla cambia, modificas solo un sitio.
       - Ayudan a leer mejor el código.

       Ejemplo:
         if (nota >= 5.0)            // menos claro
         if (nota >= NOTA_APROBADO)  // más claro

       ---------------------------------------------------------
       Convención de estilo
       ---------------------------------------------------------
       Las constantes suelen escribirse en MAYÚSCULAS y con
       guion bajo entre palabras.
       ========================================================= */

    static final double NOTA_APROBADO = 5.0;          // Nota mínima para aprobar una asignatura
    static final double IVA = 0.10;                   // IVA del 10% expresado en decimal
    static final double PRECIO_BASE = 500.0;          // Precio base de una matrícula
    static final double DESC_FAMILIA_NUMEROSA = 0.10; // Descuento del 10% por familia numerosa

    /* =========================================================
       2) ATRIBUTOS O VARIABLES DE CLASE
       ---------------------------------------------------------
       Estas variables están declaradas dentro de la clase,
       pero fuera de cualquier método.

       Por eso se llaman:
       - atributos de clase
       - variables de clase
       - de forma informal, a veces "globales"

       ---------------------------------------------------------
       ¿Por qué son static?
       ---------------------------------------------------------
       Porque así pertenecen a la clase Main y pueden ser usadas
       directamente desde métodos static como main(), leerDatos(),
       saludar(), etc.

       ---------------------------------------------------------
       DIFERENCIA CON VARIABLES LOCALES
       ---------------------------------------------------------
       - Un atributo de clase puede ser usado por varios métodos.
       - Una variable local solo existe dentro del método donde
         se declara.
       - Cuando el método termina, la variable local desaparece.

       En este programa, los atributos almacenan datos del usuario
       para que puedan ser usados desde distintos métodos.
       ========================================================= */

    // ---------------------------------------------------------
    // TIPO DE REFERENCIA
    // ---------------------------------------------------------
    // String no es un tipo primitivo.
    // Es una clase de Java, por lo que la variable "nombre"
    // guarda una referencia a un objeto String.
    // ---------------------------------------------------------
    static String nombre;

    // ---------------------------------------------------------
    // TIPOS PRIMITIVOS
    // ---------------------------------------------------------
    // int     -> enteros
    // double  -> decimales
    // boolean -> verdadero / falso
    //
    // Los tipos primitivos almacenan directamente el valor.
    // ---------------------------------------------------------
    static int edad;
    static double nota1;
    static double nota2;
    static boolean familiaNumerosa;
    static boolean pagoFraccionado;

    // ---------------------------------------------------------
    // SCANNER
    // ---------------------------------------------------------
    // Scanner es una clase que permite leer datos.
    // Aquí se conecta con System.in, que representa la entrada
    // estándar del programa, normalmente el teclado.
    //
    // Se declara static para poder usarlo desde métodos static.
    // ---------------------------------------------------------
    static Scanner sc = new Scanner(System.in);

    /* =========================================================
       3) MÉTODO MAIN
       ---------------------------------------------------------
       El método main es el punto de entrada del programa.
       Cuando la JVM ejecuta una aplicación Java, busca
       exactamente este método:

           public static void main(String[] args)

       ---------------------------------------------------------
       Significado de cada parte
       ---------------------------------------------------------
       - public:
         El método puede ser accedido desde fuera de la clase.

       - static:
         La JVM puede ejecutarlo sin crear un objeto Main.

       - void:
         No devuelve ningún valor.

       - String[] args:
         Es un array de cadenas para recibir argumentos desde
         la línea de comandos.
       ========================================================= */

    public static void main(String[] args) {

        /*
        // -----------------------------------------------------
        // EJEMPLOS DE SOBRECARGA DE MÉTODOS
        // -----------------------------------------------------

        // Llamada al método sin parámetros
        saludar();

        // Llamada al método con un parámetro String
        saludar("Pepe");

        // Llamada al método con dos parámetros
        // Este método devuelve un String y por eso lo imprimimos
        System.out.println(saludar("María", 21));
        */

        /* -----------------------------------------------------
           EJEMPLOS DE CASTING Y CONVERSIÓN DE TIPOS
           -----------------------------------------------------
           En esta parte no estamos usando leerDatos().
           Aquí el objetivo es practicar manualmente cómo se
           comportan distintas conversiones entre tipos.
           ----------------------------------------------------- */

        // -----------------------------------------------------
        // EJEMPLO 1: int -> double (casting implícito)
        // -----------------------------------------------------
        // "numero" es un entero.
        // "numeroDecimal" es un double.
        //
        // Java permite esta conversión automáticamente porque
        // un double puede representar sin problema el valor
        // de un int en este caso.
        // -----------------------------------------------------
        int numero = 10;
        System.out.println("Numero entero = " + numero);

        double numeroDecimal = numero; // conversión implícita int -> double
        System.out.println("numeroDecimal = " + numeroDecimal);

        // -----------------------------------------------------
        // Ahora asignamos 12.0 a un double
        // -----------------------------------------------------
        numeroDecimal = 12.0;

        // -----------------------------------------------------
        // EJEMPLO 2: double -> int (casting explícito)
        // -----------------------------------------------------
        // Aquí Java NO convierte automáticamente porque podría
        // haber pérdida de información.
        //
        // Por eso el programador debe indicarlo con:
        // (int)
        //
        // Si numeroDecimal fuera 12.9, el resultado sería 12,
        // no 13. El casting elimina la parte decimal, no redondea.
        // -----------------------------------------------------
        numero = (int) numeroDecimal;
        System.out.println("Numero entero = " + numero);

        // -----------------------------------------------------
        // EJEMPLO 3: byte -> int -> byte
        // -----------------------------------------------------
        // Un byte ocupa menos que un int.
        //
        // byte -> int:
        // conversión implícita, segura
        //
        // int -> byte:
        // necesita casting explícito, porque byte tiene menos
        // rango y podría producirse overflow.
        // -----------------------------------------------------
        byte b = 125;
        int e = b; // conversión implícita byte -> int

        // -----------------------------------------------------
        // Ahora cambiamos el valor de e a 130.
        // 130 ya no cabe correctamente en byte,
        // porque byte va de -128 a 127.
        // -----------------------------------------------------
        e = 130;

        // -----------------------------------------------------
        // Al hacer el casting, el valor se desborda (overflow)
        // y el resultado ya no es 130, sino otro valor ajustado
        // al rango de byte.
        // -----------------------------------------------------
        b = (byte) e;
        System.out.println("Byte b: " + b);

        // -----------------------------------------------------
        // EJEMPLO 4: char -> int
        // -----------------------------------------------------
        // Un char almacena un carácter, pero internamente ese
        // carácter se guarda como un número Unicode.
        //
        // 'A' tiene como código Unicode el valor 65.
        //
        // Esta conversión es implícita:
        // char -> int
        // -----------------------------------------------------
        char letra = 'A';
        int codigo = letra;

        System.out.printf("Código: " + codigo);
    }

    /* =========================================================
       4) MÉTODO leerDatos()
       ---------------------------------------------------------
       Este método:
       - no recibe parámetros
       - no devuelve valor (void)
       - se encarga de pedir datos al usuario
       - hace validaciones y clasificaciones sencillas

       ---------------------------------------------------------
       CONCEPTOS QUE SE PRACTICAN AQUÍ
       ---------------------------------------------------------
       - Scanner
       - lectura de String, int y double
       - comparación de cadenas
       - operadores relacionales
       - operadores lógicos
       - condicionales
       - casting
       ========================================================= */
    static void leerDatos() {

        // -----------------------------------------------------
        // PEDIR NOMBRE
        // -----------------------------------------------------
        // print() no hace salto de línea.
        // El cursor queda al lado del texto para que el usuario
        // escriba justo después.
        // -----------------------------------------------------
        System.out.print("Nombre: ");

        // -----------------------------------------------------
        // nextLine() lee toda la línea escrita hasta pulsar Enter.
        // Sirve bien para nombres con espacios.
        // -----------------------------------------------------
        nombre = sc.nextLine();

        // -----------------------------------------------------
        // VALIDACIÓN DEL NOMBRE
        // -----------------------------------------------------
        // nombre.equals("")
        // Comprueba si la cadena está vacía.
        //
        // nombre.trim().equals("")
        // trim() elimina espacios al principio y al final.
        // Esto permite detectar entradas como "   ".
        //
        // Operador ||:
        // OR lógico -> basta con que una condición sea true.
        // -----------------------------------------------------
        if (nombre.equals("") || nombre.trim().equals("")) {
            System.out.println("El nombre no puede quedar vacío");
        }

        // -----------------------------------------------------
        // PEDIR EDAD
        // -----------------------------------------------------
        // println() sí hace salto de línea.
        // -----------------------------------------------------
        System.out.println("Edad: ");

        // -----------------------------------------------------
        // nextInt() lee un entero.
        // OJO:
        // después de nextInt() suele quedar pendiente el Enter,
        // por eso más adelante se limpia con nextLine().
        // -----------------------------------------------------
        edad = sc.nextInt();

        // -----------------------------------------------------
        // COMPARACIÓN CON !=
        // -----------------------------------------------------
        // != significa "distinto de".
        //
        // Si edad no es exactamente 20, se entra al if.
        // -----------------------------------------------------
        if (edad != 20) {
            System.out.println("No Tienes 20 años");
        }

        // -----------------------------------------------------
        // CLASIFICACIÓN POR EDAD
        // -----------------------------------------------------
        // if / else if / else permite evaluar varios casos.
        //
        // Caso 1: menor de 18
        // Caso 2: entre 18 y 55
        // Caso 3: mayor de 55
        //
        // IMPORTANTE:
        // Las condiciones se evalúan en orden.
        // Cuando una se cumple, las siguientes ya no se comprueban.
        // -----------------------------------------------------
        if (edad < 18) {
            System.out.println("es menor de edad");
        } else if (edad <= 55) {
            System.out.println("es de mediana edad");
        } else {
            System.out.println("es maduric@");
        }

        // -----------------------------------------------------
        // PEDIR NOTAS
        // -----------------------------------------------------
        // nextDouble() lee un número decimal.
        // -----------------------------------------------------
        System.out.print("Nota 1: ");
        nota1 = sc.nextDouble();

        System.out.print("Nota 2: ");
        nota2 = sc.nextDouble();

        // -----------------------------------------------------
        // LIMPIAR BUFFER
        // -----------------------------------------------------
        // Después de nextInt() o nextDouble(), el salto de línea
        // suele quedar pendiente en el buffer.
        //
        // Si ahora llamáramos directamente a nextLine(),
        // leería esa línea vacía.
        //
        // Por eso hacemos esta llamada para "consumir" ese Enter.
        // -----------------------------------------------------
        sc.nextLine();

        // -----------------------------------------------------
        // PREGUNTAR SI EL PAGO ES FRACCIONADO
        // -----------------------------------------------------
        System.out.print("¿Pago fraccionado (sí/no)?");
        String respuesta = sc.nextLine();

        // -----------------------------------------------------
        // COMPARACIÓN DE STRINGS
        // -----------------------------------------------------
        // En Java NO se debe usar == para comparar contenido
        // de cadenas.
        //
        // Debe usarse equals() o equalsIgnoreCase().
        //
        // equalsIgnoreCase():
        // compara ignorando mayúsculas y minúsculas.
        // -----------------------------------------------------
        if (respuesta.equalsIgnoreCase("si") ||
                respuesta.equalsIgnoreCase("sí")) {

            pagoFraccionado = true;

        } else {
            pagoFraccionado = false;
        }

        // -----------------------------------------------------
        // PEQUEÑO EJEMPLO DE CASTING DENTRO DEL MÉTODO
        // -----------------------------------------------------
        int numero = 10;

        // int -> double: implícito
        double numeroDecimal = numero;

        // double -> int: explícito
        numero = (int) numeroDecimal;

        // Estas variables son locales:
        // solo existen dentro de leerDatos().
    }

    /* =========================================================
       5) MÉTODO 1: saludar()
       ---------------------------------------------------------
       CARACTERÍSTICAS:
       - No recibe parámetros
       - No devuelve valor
       - Tipo de retorno: void
       - Imprime directamente por pantalla

       Este es el primer método llamado "saludar".
       ========================================================= */
    static void saludar() {

        // -----------------------------------------------------
        // Como el método es void, no devuelve nada.
        // Su única tarea es mostrar un mensaje.
        // -----------------------------------------------------
        System.out.println("Hola ke ase");
    }

    /* =========================================================
       6) MÉTODO 2: saludar(String nombre)
       ---------------------------------------------------------
       CARACTERÍSTICAS:
       - Recibe un parámetro de tipo String
       - No devuelve valor
       - Imprime directamente

       ---------------------------------------------------------
       SOBRECARGA
       ---------------------------------------------------------
       Tiene el mismo nombre que el método anterior, pero
       cambia la lista de parámetros.
       ========================================================= */
    static void saludar(String nombre) {

        // -----------------------------------------------------
        // El operador + concatena cadenas.
        // Si nombre vale "Pepe", se imprimirá:
        // Hola Pepe
        // -----------------------------------------------------
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
       - No imprime directamente

       ---------------------------------------------------------
       CONCEPTOS QUE SE PRACTICAN
       ---------------------------------------------------------
       - Sobrecarga
       - Variables locales
       - Operadores relacionales
       - Condicionales
       - Construcción de cadenas
       - return
       ========================================================= */
    static String saludar(String nombre, int edad) {

        // -----------------------------------------------------
        // VARIABLE LOCAL
        // -----------------------------------------------------
        // Esta variable solo existe dentro de este método.
        // No tiene nada que ver con el atributo "nombre" de clase,
        // aunque se llame igual el parámetro.
        //
        // Aquí se almacenará el texto que depende de la edad.
        // -----------------------------------------------------
        String mensajeEsMenor;

        // -----------------------------------------------------
        // COMPARACIÓN CON <
        // -----------------------------------------------------
        // edad < 18 produce un boolean:
        // - true  si edad es menor que 18
        // - false si edad es 18 o mayor
        // -----------------------------------------------------
        if (edad < 18) {

            // -------------------------------------------------
            // Si se cumple la condición, asignamos este texto
            // a la variable local.
            // -------------------------------------------------
            mensajeEsMenor = "eres menor de edad";

        } else {

            // -------------------------------------------------
            // Si no se cumple la condición, entra aquí.
            // -------------------------------------------------
            mensajeEsMenor = "eres mayor de edad";
        }

        // -----------------------------------------------------
        // RETURN
        // -----------------------------------------------------
        // Este método NO imprime.
        // Devuelve un String ya construido.
        //
        // Quien llama al método decide qué hacer con el resultado:
        // - imprimirlo
        // - guardarlo
        // - concatenarlo
        //
        // Ejemplo:
        // String saludo = saludar("Ana", 17);
        // System.out.println(saludo);
        // -----------------------------------------------------
        return "Hola " + nombre + " " + mensajeEsMenor;
    }
}
