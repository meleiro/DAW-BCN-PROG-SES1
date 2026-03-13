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
        leerDatos();

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


         /* =====================================================
           PRUEBAS DE CASTING IMPLÍCITO
           -----------------------------------------------------
           A partir de aquí hacemos demostraciones prácticas
           siguiendo el orden del manual.
           -----------------------------------------------------
           Recordatorio de la jerarquía de conversión automática:

           byte -> short -> int -> long -> float -> double
                            ^
                           char

           Java puede convertir automáticamente "hacia la derecha",
           es decir, desde un tipo con menos capacidad a otro con
           más capacidad o compatible.
           ===================================================== */

        System.out.println("\n==============================================");
        System.out.println("PRUEBAS DE CASTING IMPLÍCITO");
        System.out.println("==============================================");

        /* -------------------------------------------------
           2.1.2 Ejemplo básico
           -------------------------------------------------
           int -> double

           numero es int
           resultadoBasico es double

           Java hace automáticamente:
           int -> double
           ------------------------------------------------- */
        int numero = 10;
        double resultadoBasico = numero;

        System.out.println("\n2.1.2 Ejemplo básico");
        System.out.println("int numero = 10;");
        System.out.println("double resultadoBasico = numero;");
        System.out.println("Salida: " + resultadoBasico); // 10.0

        /* -------------------------------------------------
           2.1.3 Ejemplo con varios tipos
           -------------------------------------------------
           byte -> int -> long -> double

           Todas estas conversiones son implícitas porque
           vamos hacia la derecha en la jerarquía.
           ------------------------------------------------- */
        byte a = 10;
        int b = a;      // byte -> int
        long c = b;     // int -> long
        double d = c;   // long -> double

        System.out.println("\n2.1.3 Ejemplo con varios tipos");
        System.out.println("byte a = " + a);
        System.out.println("int b = a;      -> " + b);
        System.out.println("long c = b;     -> " + c);
        System.out.println("double d = c;   -> " + d);

        /* -------------------------------------------------
           2.1.4 Conversión en operaciones matemáticas
           -------------------------------------------------
           Cuando mezclamos int y double en una operación,
           Java promociona automáticamente el int a double.

           int + double -> double
           ------------------------------------------------- */
        int enteroOperacion = 5;
        double decimalOperacion = 2.5;
        double resultadoOperacion = enteroOperacion + decimalOperacion;

        System.out.println("\n2.1.4 Conversión en operaciones matemáticas");
        System.out.println("int enteroOperacion = " + enteroOperacion);
        System.out.println("double decimalOperacion = " + decimalOperacion);
        System.out.println("double resultadoOperacion = enteroOperacion + decimalOperacion;");
        System.out.println("Salida: " + resultadoOperacion); // 7.5

        /* -------------------------------------------------
           2.1.5 Promoción automática en expresiones
           -------------------------------------------------
           Aunque los dos operandos sean byte, al hacer
           una operación aritmética Java los promociona a int.

           byte + byte -> int

           Esto se llama Numeric Promotion.
           ------------------------------------------------- */
        byte byte1 = 10;
        byte byte2 = 20;
        int resultadoPromocion = byte1 + byte2;

        System.out.println("\n2.1.5 Promoción automática en expresiones");
        System.out.println("byte byte1 = " + byte1);
        System.out.println("byte byte2 = " + byte2);
        System.out.println("int resultadoPromocion = byte1 + byte2;");
        System.out.println("Salida: " + resultadoPromocion); // 30

        /* -------------------------------------------------
           2.1.6 Ejemplo con char
           -------------------------------------------------
           char almacena códigos Unicode.
           Por eso se puede convertir implícitamente a int.
           ------------------------------------------------- */
        char letra = 'A';
        int codigo = letra;

        System.out.println("\n2.1.6 Ejemplo con char");
        System.out.println("char letra = 'A';");
        System.out.println("int codigo = letra;");
        System.out.println("Salida: " + codigo); // 65

        // También en operaciones:
        int resultadoChar = letra + 1;

        System.out.println("char letra = 'A';");
        System.out.println("int resultadoChar = letra + 1;");
        System.out.println("Salida: " + resultadoChar); // 66

        /* -------------------------------------------------
           2.1.7 Conversión implícita en métodos
           -------------------------------------------------
           Si un método espera un double y le pasamos un int,
           Java convierte automáticamente el int a double.
           ------------------------------------------------- */
        int valorMetodo = 10;

        System.out.println("\n2.1.7 Conversión implícita en métodos");
        System.out.println("int valorMetodo = 10;");
        System.out.println("Llamada: imprimirNumero(valorMetodo);");


        /* -------------------------------------------------
           2.1.8 Caso especial con float
           -------------------------------------------------
           float -> double es automático

           Pero double -> float NO es implícito, porque
           puede haber pérdida de precisión.
           ------------------------------------------------- */
        float numeroFloat = 3.5f;
        double resultadoFloatADouble = numeroFloat;

        System.out.println("\n2.1.8 Caso especial con float");
        System.out.println("float numeroFloat = 3.5f;");
        System.out.println("double resultadoFloatADouble = numeroFloat;");
        System.out.println("Salida: " + resultadoFloatADouble);

        // Este ejemplo se deja comentado porque daría error de compilación:
        // double numeroDouble = 3.5;
        // float resultadoError = numeroDouble; // ERROR: posible pérdida de información

        System.out.println("Ejemplo no válido (comentado en código):");
        System.out.println("double numeroDouble = 3.5;");
        System.out.println("float resultadoError = numeroDouble; // ERROR");

        /* -------------------------------------------------
           2.1.9 Cuándo puede haber pérdida de información
           -------------------------------------------------
           Aunque long -> float sea una conversión implícita
           permitida por Java, puede perder precisión si el
           número es muy grande.

           float tiene aproximadamente 7 dígitos de precisión.
           ------------------------------------------------- */
        long numeroGrandeLong = 123456789012345L;
        float floatDesdeLong = numeroGrandeLong;

        System.out.println("\n2.1.9 Pérdida de precisión con long -> float");
        System.out.println("long numeroGrandeLong = 123456789012345L;");
        System.out.println("float floatDesdeLong = numeroGrandeLong;");
        System.out.println("Salida original long: " + numeroGrandeLong);
        System.out.println("Salida convertida a float: " + floatDesdeLong);

        /* -------------------------------------------------
           Ejemplo claro de pérdida de precisión
           -------------------------------------------------
           int -> float también puede perder exactitud si el
           número tiene demasiados dígitos significativos.
           ------------------------------------------------- */
        int numeroPrecision = 123456789;
        float floatPrecision = numeroPrecision;

        System.out.println("\nEjemplo claro de pérdida de precisión");
        System.out.println("int numeroPrecision = 123456789;");
        System.out.println("float floatPrecision = numeroPrecision;");
        System.out.println("Salida original int: " + numeroPrecision);
        System.out.println("Salida convertida a float: " + floatPrecision);

        /* -------------------------------------------------
           2.1.10 Otro caso de pérdida de precisión
           -------------------------------------------------
           long -> double está permitido implícitamente, pero
           double también tiene un límite de precisión.
           ------------------------------------------------- */
        long numeroMuyGrande = 9999999999999999L;
        double doubleDesdeLong = numeroMuyGrande;

        System.out.println("\n2.1.10 Otro caso de pérdida de precisión");
        System.out.println("long numeroMuyGrande = 9999999999999999L;");
        System.out.println("double doubleDesdeLong = numeroMuyGrande;");
        System.out.println("Salida original long: " + numeroMuyGrande);
        System.out.println("Salida convertida a double: " + doubleDesdeLong);

        /* -------------------------------------------------
           2.1.11 Casos que provocan error (no implícitos)
           -------------------------------------------------
           Si Java detecta una posible pérdida clara, NO permite
           la conversión automática.

           Estos ejemplos se dejan comentados para que el
           programa compile.
           ------------------------------------------------- */
        System.out.println("\n2.1.11 Casos que provocan error (comentados)");
        System.out.println("double precio = 9.99;");
        System.out.println("int valor = precio; // ERROR: possible lossy conversion from double to int");

        // double precio = 9.99;
        // int valor = precio; // ERROR

        /* -------------------------------------------------
           2.1.12 Error común con byte y short
           -------------------------------------------------
           Aunque aSimple y bSimple sean byte, la operación
           aSimple + bSimple devuelve int por promoción numérica.

           Por eso esto NO compila:
           byte cSimple = aSimple + bSimple;

           Se deja comentado para que compile.
           ------------------------------------------------- */
        System.out.println("\n2.1.12 Error común con byte y short (comentado)");
        System.out.println("byte aSimple = 10;");
        System.out.println("byte bSimple = 20;");
        System.out.println("byte cSimple = aSimple + bSimple; // ERROR");

        // byte aSimple = 10;
        // byte bSimple = 20;
        // byte cSimple = aSimple + bSimple; // ERROR

        /* -------------------------------------------------
           2.1.13 Regla importante de casting implícito
           -------------------------------------------------
           Java permite conversión automática si el tipo origen
           cabe dentro del tipo destino.

           tipo origen ⊆ tipo destino

           Ejemplos:
           int ⊆ long
           long ⊆ float
           float ⊆ double
           ------------------------------------------------- */
        System.out.println("\n2.1.13 Regla importante");
        System.out.println("Java permite casting automático si:");
        System.out.println("tipo origen ⊆ tipo destino");

        System.out.println("\nResumen de ejemplos válidos mostrados:");
        System.out.println("byte -> int     ");
        System.out.println("int -> long     ");
        System.out.println("int -> double   ");
        System.out.println("float -> double ");
        System.out.println("char -> int     ");



        System.out.println("==============================================\n");
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
