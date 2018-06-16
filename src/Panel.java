/**
 *
 * @author Jesus Ivan
 */
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private Circulo circulo = new Circulo(0, 0, 150);
    
    @Override
    public void paintComponent(Graphics g){
        //Se redefine y vuelve a pintar esto en swing.
        super.paintComponent(g);
        circulo.dibujar(g);
    }
    
    public void dibujar(Circulo circulo){
        this.circulo = circulo;
        repaint();
    }
 }