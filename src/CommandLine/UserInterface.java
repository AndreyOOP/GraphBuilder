package CommandLine;

import Constants.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//todo change default size to bigger
//todo add 2 classes command check & intellisense window & algorithm to check in which condition what could be
//todo rewrite draw method
public class UserInterface {

    private static Dimension    consoleSize;
    private static JTextField   consoleInput;
    private static DrawPanel    drawPanel;
    private static JPanel       panel;
    private static JFrame       window;

    public static void main(String[] args) {

        consoleSize = new Dimension(UI.WINDOW_WIDTH, UI.CONSOLE_HEIGTH);

        consoleInput = new JTextField();
        consoleInput.setMaximumSize(consoleSize);
        consoleInput.setMinimumSize(consoleSize);

        drawPanel = new DrawPanel();

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(consoleInput);
        panel.add(drawPanel);

        window = new JFrame(UI.WINDOW_NAME);
        window.setSize(UI.WINDOW_WIDTH, UI.WINDOW_HEIGTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(panel);
        window.setVisible(true);

        window.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                super.componentResized(e);

                resizeConsole(window.getWidth());
            }
        });

        window.addWindowStateListener(new WindowStateListener() {

            @Override
            public void windowStateChanged(WindowEvent e) {

                if(e.getNewState() == Frame.MAXIMIZED_BOTH){
                    resizeConsole(window.getWidth());
                }
            }
        });

        //here should be check of tab key & enter key events & any key
        //tab & any key - intelligsence window appear & update
        //enter - execue command
        consoleInput.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_ENTER){

                    if(consoleInput.getText().equalsIgnoreCase("quit")){
                        JOptionPane.showMessageDialog(null, "Quit is entered");
                    }

                    if(consoleInput.getText().equalsIgnoreCase("draw")){

                        Graphics g = drawPanel.getGraphics(); //note better to do it inside drawPanel -> so in case of resize etc it will bw automatically updated
                        g.drawOval(30, 40, 10, 10);
                    }
                }
            }
        });
    }

    private static void resizeConsole(int newWidth){

        Dimension d = new Dimension(newWidth, UI.CONSOLE_HEIGTH);

        consoleInput.setMaximumSize(d);
        consoleInput.setMinimumSize(d);
    }
}
