import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The Organizer class manages the main functionality of the application.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class Organizer {
    // Drawing component used for rendering screens
    public static Drawing drawing;
    // Main application window
    public static JFrame frame = new JFrame("CityBlitz");
    // Current screen index
    public static int screen1 = 1;
    // Flag to indicate if it's the initial screen
    public static boolean initScreen = true;
    // Flags for unlocking levels
    public static boolean unlock2, unlock3;
    // Generation number
    public static int gen;
    // Player name
    public String name;
    // Timer for screen updates
    public static Timer timer;

    // Screens
    SplashScreen splash = new SplashScreen();
    MainMenu menu = new MainMenu();
    LevelSelect levelSelect = new LevelSelect();
    Intro1 intro = new Intro1();
    Goodbye goodbye = new Goodbye();
    Level1 level1 = new Level1();
    Level2 level2 = new Level2();
    Level3 level3 = new Level3();

    /**
     * Constructs an Organizer object and initializes the application.
     */
    public Organizer() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(784, 591);
        frame.setResizable(false);
        drawing = new Drawing();
        frame.add(drawing);
        frame.setVisible(true);
        // timer to repaint frame
        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                drawing.repaint();
            }
        });
        timer.start();
    }

    /**
     * Changes the current screen to the specified screen.
     * 
     * @param newScreen the new screen to be displayed
     */
    public static void changeScreen(int newScreen) {
        screen1 = newScreen;
        initScreen = true;
    }

    /**
     * Removes all registered listeners from the frame.
     */
    private void removeListeners() {
        for (KeyListener a : frame.getListeners(KeyListener.class))
            frame.removeKeyListener(a);
        for (MouseListener b : frame.getListeners(MouseListener.class))
            frame.removeMouseListener(b);
        for (MouseMotionListener c : frame.getListeners(MouseMotionListener.class))
            frame.removeMouseMotionListener(c);
    }

    /**
     * The Drawing class represents the component used for rendering the screens.
     */
    class Drawing extends JComponent {
        /**
         * Paints the current screen based on the screen1 variable.
         * 
         * @param g the Graphics object used for painting
         */
        public void paint(Graphics g) {
            switch (screen1) {
                case 0: // splash screen
                    if (initScreen) {
                        frame.addMouseListener(splash);
                        frame.addMouseMotionListener(splash);
                        initScreen = false;
                    }
                    splash.paint(g);
                    break;
                case 1: // main menu
                    if (initScreen) {
                        removeListeners();
                        frame.addMouseListener(menu);
                        frame.addMouseMotionListener(menu);
                        initScreen = false;
                    }
                    menu.paint(g);
                    break;
                case 2: // goodbye
                    if (initScreen) {
                        removeListeners();
                        frame.addMouseListener(goodbye);
                        frame.addMouseMotionListener(goodbye);
                        initScreen = false;
                    }
                    goodbye.paint(g);
                    break;
                case 3: // level selection
                    if (initScreen) {
                        removeListeners();
                        frame.addMouseListener(levelSelect);
                        frame.addMouseMotionListener(levelSelect);
                        initScreen = false;
                    }
                    levelSelect.paint(g);
                    break;
                case 4: // introduction
                    if (initScreen) {
                        removeListeners();
                        frame.addMouseListener(intro);
                        frame.addMouseMotionListener(intro);
                        initScreen = false;
                    }
                    intro.paint(g);
                    break;
                case 5: // level one
                    if (initScreen) {
                        removeListeners();
                        frame.addMouseListener(level1);
                        frame.addMouseMotionListener(level1);
                        frame.addKeyListener(level1);
                        initScreen = false;
                    }
                    level1.paint(g);
                    break;
                case 6: // level two
                    if (initScreen) {
                        removeListeners();
                        frame.addMouseListener(level2);
                        frame.addMouseMotionListener(level2);
                        frame.addKeyListener(level2);
                        initScreen = false;
                    }
                    level2.paint(g);
                    break;
                case 7: // level three
                    if (initScreen) {
                        removeListeners();
                        frame.addMouseListener(level3);
                        frame.addMouseMotionListener(level3);
                        frame.addKeyListener(level3);
                        initScreen = false;
                    }
                    level3.paint(g);
                    break;
            }
        }
    }
}
