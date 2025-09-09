package notas;

public class NotasPlus {
    private Estudiante[] estudiantes;
    private Curso[] cursos;
    private double[][] calificaciones; // [estudiante][curso]

    public NotasPlus() {
        // Crear 5 estudiantes
        estudiantes = new Estudiante[] {
            new Estudiante("Giovanni Orozco", "2021001", "Ingeniería en ciencia de datos"),
            new Estudiante("Luis Méndez", "2021002", "Ingeniería de Marketing"),
            new Estudiante("María López", "2021003", "Ingeniería Civil"),
            new Estudiante("Carlos Díaz", "2021004", "Ingeniería Electrónica"),
            new Estudiante("Nathalie Valle", "2021005", "Ingeniería en Datos")
        };

        cursos = new Curso[] {
            new Curso("Matemática", "MAT101"),
            new Curso("Física", "FIS102"),
            new Curso("DATAS SCIENCE", "DATA103")
        };

        calificaciones = new double[estudiantes.length][cursos.length];
        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < cursos.length; j++) {
                calificaciones[i][j] = 60 + Math.random() * 40; // Entre 60 y 100
            }
        }
    }

    public void iniciar() {
        System.out.println("Sistema de Notas Plus:");
        System.out.println("-----------------------");

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante: " + estudiantes[i].getNombre());
            for (int j = 0; j < cursos.length; j++) {
                System.out.printf("  %s (%s): %.2f\n", cursos[j].getNombre(), cursos[j].getCodigo(), calificaciones[i][j]);
            }
            System.out.printf("  Promedio del estudiante: %.2f\n", calcularPromedioEstudiante(i));
            System.out.println();
        }

        for (int j = 0; j < cursos.length; j++) {
            System.out.printf("Promedio del curso %s: %.2f\n", cursos[j].getNombre(), calcularPromedioCurso(j));
        }

        System.out.printf("\nPromedio general del sistema: %.2f\n", calcularPromedioGeneral());
    }

    public double calcularPromedioGeneral() {
        double suma = 0;
        int totalNotas = estudiantes.length * cursos.length;

        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < cursos.length; j++) {
                suma += calificaciones[i][j];
            }
        }

        return suma / totalNotas;
    }

    public double calcularPromedioEstudiante(int indiceEstudiante) {
        double suma = 0;
        for (int j = 0; j < cursos.length; j++) {
            suma += calificaciones[indiceEstudiante][j];
        }
        return suma / cursos.length;
    }

    public double calcularPromedioCurso(int indiceCurso) {
        double suma = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            suma += calificaciones[i][indiceCurso];
        }
        return suma / estudiantes.length;
    }
}
