package Ejercicios.Colecciones.CajaMisteriosa;

public class Main {

    public static void main(String[] args) {

        CajaMisteriosa<String> cajaString = new CajaMisteriosa<>("Caja con un String");
        CajaMisteriosa<Integer> cajaInteger = new CajaMisteriosa<>(1);
        CajaMisteriosa<Producto> cajaProducto = new CajaMisteriosa<>(new Producto("Balón", 20.00));

        System.out.println("--- CAJA 1 ---");
        cajaString.mostrarTipo();
        cajaString.abrirCaja();

        System.out.println("\n--- CAJA 2 ---");
        cajaInteger.mostrarTipo();
        cajaInteger.abrirCaja();

        System.out.println("\n--- CAJA 3 ---");
        cajaProducto.mostrarTipo();
        cajaProducto.abrirCaja();

        System.out.println("\n--- Revelar Objeto ---");
        CajaMisteriosa.revelarObjeto(1);
        CajaMisteriosa.revelarObjeto(10.50);
        CajaMisteriosa.revelarObjeto('A');
        CajaMisteriosa.revelarObjeto("Cadena");
        CajaMisteriosa.revelarObjeto(false);


        /*
         * PARTE 3
         * - ¿Qué pasaría si la clase no fuera genérica y usáramos Object?
         * --> Lo que sucedería es que si usamos Object, podríamos guardar cualquier cosa, pero
         * perderíamos la información del tipo original. Tendríamos que forzar un Casting, ahí puede
         * aparecer el error de equivocarnos a la hora de hacer el Casting. El programa compilaría bien,
         * pero nos daría un error cuando se ejecute.
         * ---
         * - ¿Dónde está la seguridad de tipos?
         * --> Los genéricos trasladan los errores de tipos del tiempo de ejecución al tiempo de compilación,
         * de esta manera, si el tipo no coincide, el IDE nos subrayaría el error y no nos dejaría ejecutar el programa.
         * ---
         * - ¿Podría la caja aceptar int directamente?
         * --> No, ya que los genéricos en Java solo trabajan con Tipos de Referencia, y no con tipos primitivos.
         * ---
         * - ¿Por qué CajaMisteriosa<String> no puede guardar un Integer?
         * --> Porque al declarar <String> estamos estableciendo que para ese objeto específico la T es
         * reemplazada por String en toda la clase, por tanto, como String e Integer son diferentes no se
         * pueden mezclar.
         * ---
         * - ¿Qué error aparece si intentas hacer esto?
         *   - CajaMisteriosa<Integer> caja = new CajaMisteriosa<>(10);
         *   - caja.setContenido("Hola");
         * --> Tendríamos un error de compilación: java.lang.String cannot be converted to java.lang.Integer.
         */

    }
}
