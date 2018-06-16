/**
 *
 * @author Jesus Ivan
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ventana extends JFrame{
    private Circulo circulo;
    private Container contenedor;
    private JSlider slider;
    private JTextArea calculos;
    private Panel miPanel;
    
    public Ventana(){
        super("Viruz Blog: Calculo de Circulo con JSlider");
        setSize(470, 540);
        setBackground(Color.WHITE);
        contenedor = getContentPane();
        
        addComponentes();
        addEventos();
        setResizable(false);
        setVisible(true);
    }
    
    public void addComponentes(){
        slider = new JSlider(JSlider.VERTICAL, 100, 200, 150);
        miPanel = new Panel();
        circulo = new Circulo(0, 0, 150);
        calculos = new JTextArea(": : Cálculos : :");
        
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);//muestra las marcas.
      slider.setPaintLabels(true);//Muestra los valores de las marcas.
        slider.setBackground(Color.WHITE);
        
        calculos.setEditable(false);
        
        contenedor.add(slider, BorderLayout.EAST);
        contenedor.add(miPanel, BorderLayout.CENTER);
        contenedor.add(calculos, BorderLayout.SOUTH);
    }
    public void addEventos(){
            //adición del oyente del slider
        slider.addChangeListener(new ChangeListener(){
            int x;
            int y;
            
            public void stateChanged(ChangeEvent evento) {
                circulo.cambiarTamaño(slider.getValue());
                miPanel.dibujar(circulo);
                mostrarCalculos();
            }
        });
    }
    
        public void mostrarCalculos(){
        String radio;
        String diametro;
        String area;
        String circunferencia;
        //\t alineacion de linea
        radio = "Radio: \t" + (circulo.calcularDiametro() / 2);
        diametro = "Diámetro: \t" + circulo.calcularDiametro();
        area = "Área: \t" + circulo.calcularArea();
        circunferencia = "Circunferencia: \t" + circulo.calcularCircunferencia();
        
        //\n espacio
        calculos.setText(radio + "\n" + diametro + "\n" + area + "\n" + circunferencia);
    }
}