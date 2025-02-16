import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//Extends es una extension de de java 
public class FrmJuego extends JFrame{
    //declaramos dado1,dado2 y random e instanciamos
    private Dado Dado1 = new Dado();
    private Dado Dado2 = new Dado();
    private Random r = new Random();
    //ponemos global el JLabel para todos los metodos y asi mostrar las imagenes correspondientes
    private JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;
    private int Lanzamientos, Cenas;

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
        lblDado1 = new JLabel();
        //Ubicacion de la imagen del dado
        String NombreImagen = "/Imagenes/1.jpg";
        //aqui carga la imagen del dado
        ImageIcon imagen = new ImageIcon(getClass().getResource(NombreImagen));
        //asignamos la imagen (dado) a la etiqueta
        lblDado1.setIcon(imagen);
        //coordenadas y tamaño de la imagen
        lblDado1.setBounds(10,10,imagen.getIconWidth(), imagen.getIconHeight());
        //getContentPane es la ventana q abre
        //mostramos la imagen en la ventana
        getContentPane().add(lblDado1);

        //segundo dado
        lblDado2 = new JLabel();
        lblDado2.setIcon(imagen);
        lblDado2.setBounds(10 + imagen.getIconWidth(), 10, imagen.getIconWidth(), imagen.getIconHeight());
        getContentPane().add(lblDado2);
        

        //Titulos 1 y 2
        JLabel lblTitulo1 = new JLabel("Lanzamientos");
        lblTitulo1.setBounds(50 + 2 * imagen.getIconWidth(), 10,100,25);
        //para centrar el texto
        lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo1);

        JLabel lblTitulo2 = new JLabel("Cenas");
        lblTitulo2.setBounds(160 + 2 * imagen.getIconWidth(), 10,100,25);
        //para centrar el texto
        lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo2);


        //Contadores
        lblLanzamientos = new JLabel();
        lblLanzamientos.setBounds(50 + 2 * imagen.getIconWidth(), 40,100,100);
        //color de fondo
        lblLanzamientos.setBackground(new Color(0, 0, 0));
        //color de la letra (setforeground)
        lblLanzamientos.setForeground(new Color(51, 255, 0));
        //Tipo de letra y tamaño (setfont)
        lblLanzamientos.setFont(new Font("Tahoma", 1, 72));
        //se puede colocar en que numero quiere que empiece despues asi, o tambien antes en (new JLabel("0"))
        lblLanzamientos.setText("0");
        //Para centrar o alinear texto
        lblLanzamientos.setHorizontalAlignment(SwingConstants.RIGHT);
        //cuando quiera q el color de fondo sea negro porque colocando (0,0,0) no da porque las etiquetas no son opacas
        lblLanzamientos.setOpaque(true);
        getContentPane().add(lblLanzamientos);


        lblCenas = new JLabel();
        lblCenas.setBounds(160 + 2 * imagen.getIconWidth(), 40,100,100);
        lblCenas.setBackground(new Color(0, 0, 0));
        lblCenas.setForeground(new Color(51, 255, 0));
        lblCenas.setFont(new Font("Tahoma", 1, 72));
        lblCenas.setText("0");
        lblCenas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCenas.setOpaque(true);
        getContentPane().add(lblCenas);


        //Botones
        JButton Iniciar = new JButton("Iniciar");
        Iniciar.setBounds(10, 15+imagen.getIconHeight(),100,25);
        getContentPane().add(Iniciar);

        JButton Lanzar = new JButton("Lanzar");
        Lanzar.setBounds(10, 45+imagen.getIconHeight(),100,25);
        getContentPane().add(Lanzar);


        //LOGICA de programar botones
        Iniciar.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Iniciar(); //es private void Iniciar(){
            }

        } );

        Lanzar.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Lanzar(); //es private void Iniciar(){
            }

        } );

    }

    //creamos la rutina iniciar y lanzar para q se conozca q hace en actionlistener (FrmJuego)
    private void Iniciar(){
        JOptionPane.showMessageDialog(null,"Reiniciaste el numero de lanzamientos");
        //lanzamientos y cenas se inicializan en 0
        Lanzamientos = 0;
        Cenas = 0;
        //las etiquetas (contadores) que inician en 0
        lblLanzamientos.setText("0");
        lblCenas.setText("0");
    }

    private void Lanzar(){
        //asignamos los valores a cada dado pero sin mostrar la imagen
        Dado1.Lanzar(r);
        Dado2.Lanzar(r);
        //aqui mostramos las imagenes correspondientes a los valores que lanzamos
        Dado1.Mostrar(lblDado1);
        Dado2.Mostrar(lblDado2);

        //cada vez que lanze incrementa los contadores/etiqueta
        Lanzamientos++;
        //se muestra en texto el numero de lanzamientos
        lblLanzamientos.setText(String.valueOf(Lanzamientos));

        //condicional para hacer las cenas(dados que sale con numero mayor a 10)
        if(Dado1.getNumero() + Dado2.getNumero() >= 11){
            Cenas++;
            lblCenas.setText(String.valueOf(Cenas));
        }
    }

}