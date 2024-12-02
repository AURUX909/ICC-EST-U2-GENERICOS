import models.Persona;
import models.genericos.Caja;
import models.genericos.Par;

public class App {
    public static void main(String[] args) throws Exception {
        // Arreglo inicial de 10 personas
        Persona[] personas = new Persona[10];
        personas[0] = crearPersona("Ana", 17);
        personas[1] = crearPersona("Luis", 21);
        personas[2] = crearPersona("María", 16);
        personas[3] = crearPersona("Carlos", 25);
        personas[4] = crearPersona("Julia", 14);
        personas[5] = crearPersona("Pedro", 19);
        personas[6] = crearPersona("Sofía", 13);
        personas[7] = crearPersona("Andrés", 20);
        personas[8] = crearPersona("Clara", 12);
        personas[9] = crearPersona("Roberto", 18);

        // Uso de cajas genéricas
        Caja<String> cajaString = new Caja<>();
        Caja<Integer> cajaInteger = new Caja<>();
        Caja<Persona> cajaPersona = new Caja<>();

        // Creación de pares
        Par<Integer, String> par1 = new Par<>(1, "Uno");
        Par<String, Integer> par2 = new Par<>("Dos", 2);

        // Guardar valores en cajas
        cajaString.guardar("Guardo un String");
        cajaInteger.guardar(10);
        cajaPersona.guardar(personas[0]);

        // Mostrar contenido de las cajas
        System.out.println("Contenido de las cajas:");
        System.out.println(cajaString.obtener());
        System.out.println(cajaInteger.obtener());
        System.out.println(cajaPersona.obtener().getNombre());
        System.out.println(cajaPersona.obtener().getEdad());

        // Mostrar contenido de los pares
        System.out.println("\nContenido de los pares:");
        System.out.println(par1.obtenerClave() + " - " + par1.obtenerValor());
        System.out.println(par2.obtenerClave() + " - " + par2.obtenerValor());

        // Contadores para determinar el tamaño de los arreglos
        int personasMayores = 0;
        int personasMenores = 0;

        // Primer bucle para contar mayores y menores de edad
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getEdad() >= 18) {
                personasMayores++;
            } else {
                personasMenores++;
            }
        }

        // Crear arreglos de tamaño exacto para mayores y menores
        @SuppressWarnings("unchecked")
        Par<String, Integer>[] mayores = (Par<String, Integer>[]) new Par[personasMayores];
        @SuppressWarnings("unchecked")
        Par<Integer, String>[] menores = (Par<Integer, String>[]) new Par[personasMenores];

        // Contadores para iterar sobre los arreglos de mayores y menores
        int contadorMayores = 0;
        int contadorMenores = 0;

        // Segundo bucle para distribuir a las personas en mayores o menores
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getEdad() >= 18) {
                mayores[contadorMayores] = new Par<>(personas[i].getNombre(), personas[i].getEdad());
                contadorMayores++;
            } else {
                menores[contadorMenores] = new Par<>(personas[i].getEdad(), personas[i].getNombre());
                contadorMenores++;
            }
        }

        // Imprimir menores de edad
        System.out.println("\nMenores de edad:");
        for (Par<Integer, String> par : menores) {
            System.out.println(par.obtenerClave() + " - " + par.obtenerValor());
        }

        // Imprimir mayores de edad
        System.out.println("\nMayores de edad:");
        for (Par<String, Integer> par : mayores) {
            System.out.println(par.obtenerClave() + " - " + par.obtenerValor());
        }
    }

    // Método para crear una persona
    private static Persona crearPersona(String nombre, int edad) {
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setEdad(edad);
        return persona;
    }
}
