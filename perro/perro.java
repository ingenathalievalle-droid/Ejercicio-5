package perro;
public class perro {
    private String nombre, raza;
    private int edad;

    ///public perro(String nombre, String raza, int edad)
    //{
        
   /// }
   /// setters
   public void setNombre(String nombre)
   {
    this.nombre = nombre;
   }
   public void setRaza(String raza)
   { 
    this.raza=raza;

   }
   public void setEdad(int edad)
   {
    this.edad=edad;
   }
   //constructor 
   public perro(String nombre, String raza)
   {
    this.nombre = nombre;
    this.raza =raza;
   }
   //getters
   public String getnombre()
   {
    return this.nombre;
   }
   

}
