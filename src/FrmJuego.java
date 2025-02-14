import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//Extends es una extension de de java 
public class FrmJuego extends JFrame{

    //VENTANA DE LA APLICACION
    public FrmJuego() {
        //titulo de la ventana
        setTitle("Juguemos a los dados");
        //tamaño de ventana
        setSize(500,300);
        //termina la ejecucion cuando damos x a la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //ignora la distribucion o coordenadas por defecto
        setLayout(null);


        //Jlabel sirve para hacer grafico el dado (extension de java) "etiqueta"
        JLabel Dado1 = new JLabel();
        //Ubicacion de la imagen del dado
        String NombreImagen = "/Imagenes/1.jpg";
        //aqui carga la imagen del dado
        ImageIcon imagen = new ImageIcon(getClass().getResource(NombreImagen));
        //asignamos la imagen (dado) a la etiqueta
        Dado1.setIcon(imagen);
        //coordenadas y tamaño de la imagen
        Dado1.setBounds(10,10,imagen.getIconWidth(), imagen.getIconHeight());
        //getContentPane es la ventana q abre
        //mostramos la imagen en la ventana
        getContentPane().add(Dado1);

        //segundo dado
        JLabel Dado2 = new JLabel();
        Dado2.setIcon(imagen);
        Dado2.setBounds(10 + imagen.getIconWidth(), 10, imagen.getIconWidth(), imagen.getIconHeight());
        getContentPane().add(Dado2);
        

        //Titulos 1 y 2
        JLabel Titulo1 = new JLabel("Lanzamientos");
        Titulo1.setBounds(50 + 2 * imagen.getIconWidth(), 10,100,25);
        //para centrar el texto
        Titulo1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(Titulo1);

        JLabel Titulo2 = new JLabel("Cenas");
        Titulo2.setBounds(160 + 2 * imagen.getIconWidth(), 10,100,25);
        //para centrar el texto
        Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(Titulo2);


        //Contadores
        JLabel Lanzamientos = new JLabel();
        Lanzamientos.setBounds(50 + 2 * imagen.getIconWidth(), 40,100,100);
        //color de fondo
        Lanzamientos.setBackground(new Color(0, 0, 0));
        //color de la letra (setforeground)
        Lanzamientos.setForeground(new Color(51, 255, 0));
        //Tipo de letra y tamaño (setfont)
        Lanzamientos.setFont(new Font("Tahoma", 1, 72));
        //se puede colocar en que numero quiere que empiece despues asi, o tambien antes en (new JLabel("0"))
        Lanzamientos.setText("0");
        //Para centrar o alinear texto
        Lanzamientos.setHorizontalAlignment(SwingConstants.RIGHT);
        //cuando quiera q el color de fondo sea negro porque colocando (0,0,0) no da porque las etiquetas no son opacas
        Lanzamientos.setOpaque(true);
        getContentPane().add(Lanzamientos);


        JLabel Cenas = new JLabel();
        Cenas.setBounds(160 + 2 * imagen.getIconWidth(), 40,100,100);
        Cenas.setBackground(new Color(0, 0, 0));
        Cenas.setForeground(new Color(51, 255, 0));
        Cenas.setFont(new Font("Tahoma", 1, 72));
        Cenas.setText("0");
        Cenas.setHorizontalAlignment(SwingConstants.RIGHT);
        Cenas.setOpaque(true);
        getContentPane().add(Cenas);


        //Botones
        JButton Iniciar = new JButton("Iniciar");
        Iniciar.setBounds(10, 15+imagen.getIconHeight(),100,25);
        getContentPane().add(Iniciar);

        JButton Lanzar = new JButton("Lanzar");
        Lanzar.setBounds(10, 45+imagen.getIconHeight(),100,25);
        getContentPane().add(Lanzar);
    }

}