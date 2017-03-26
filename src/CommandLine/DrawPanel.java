package CommandLine;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    public DrawPanel(){}

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.drawRect(2, 2, this.getWidth()-2, this.getHeight()-2);
    }
}
