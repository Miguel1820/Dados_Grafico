import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado {
    private int Numero;

    public void Lanzar(Random r){
        //generar numero aleatorios del 1 al 6
        //el + 1 indica desde que numero desea iniciar en este caso el 1
        //la suma de estos indica el valor a terminar en este caso el 7 pero se resta 1 entonces terminaria en 6 
        Numero = r.nextInt(6) + 1;
    }

    //recibe el numero q se genero en lanzar
    // y como "Numero" es privado tenemos q consultar el valor tiene con un get
    public int getNumero() {
        return Numero;
    }

    //colocamos como parametro de entrada un JLabel "public void Mostrar(JLabel lbl)"
    public void Mostrar(JLabel lbl) {
        //Ubicacion de la imagen del dado
        //"String.valueOf(Numero)" volvemos la variable numero en texto
        String NombreImagen = "/Imagenes/" + String.valueOf(Numero) + ".jpg";
        //aqui carga la imagen del dado
        ImageIcon imagen = new ImageIcon(getClass().getResource(NombreImagen));
        //asignamos la imagen (dado) a la etiqueta
        lbl.setIcon(imagen);
    }

}
