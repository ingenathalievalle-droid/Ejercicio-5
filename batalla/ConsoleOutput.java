package batalla;

public class ConsoleOutput implements Output {
    @Override
    public void show(String mensaje) {
        System.out.println(mensaje);
    }
}
