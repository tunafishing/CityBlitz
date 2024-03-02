import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The MainMenu class represents the main menu screen of the application.
 * It displays the background image and buttons for play and quit options.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class MainMenu extends JFrame implements MouseListener, MouseMotionListener {
    private boolean hover1, hover2;
    private Image menuBg, bg, playButt, playButtHov, butt1, quitButt, quitButtHov, butt2;

    /**
     * Constructs a MainMenu object and initializes the images.
     */
    public MainMenu() {
        loadImages();
    }

    /**
     * Loads the images from files.
     */
    public void loadImages() {
        try {
            menuBg = ImageIO.read(new File("./mnTitle.png"));
            playButt = ImageIO.read(new File("./mnPlay.png"));
            playButtHov = ImageIO.read(new File("./mnPlayPress.png"));
            quitButt = ImageIO.read(new File("./mnQuit.png"));
            quitButtHov = ImageIO.read(new File("./mnQuitPress.png"));
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to load image");
        }
    }

    /**
     * Paints the components of the main menu screen.
     * 
     * @param g the Graphics object
     */
    @Override
    public void paint(Graphics g) {
        bg = menuBg.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
        g.drawImage(bg, 0, 0, null);
        butt1 = playButt.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
        if (hover1)
            butt1 = playButtHov.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
        g.drawImage(butt1, 500, 410, null);
        butt2 = quitButt.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
        if (hover2)
            butt2 = quitButtHov.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
        g.drawImage(butt2, 500, 470, null);
    }

    /**
     * Handles the mouse click event.
     * Determines if the play or quit button was clicked and performs the
     * corresponding action.
     * 
     * @param e the MouseEvent object
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (hover1) {
            Organizer.changeScreen(3);
        } else if (hover2) {
            Organizer.changeScreen(2);
        }
    }

    /**
     * Handles the mouse movement event.
     * Checks if the mouse is hovering over the play or quit button.
     * 
     * @param e the MouseEvent object
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMovedCheck(e.getX(), e.getY());
    }

    /**
     * Checks if the mouse is hovering over the play or quit button based on the
     * coordinates.
     * 
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    public void mouseMovedCheck(int x, int y) {
        if (x > 500 && x < 500 + 240 && y > 410 + 25 && y < 410 + 53 + 25) {
            hover1 = true;
        } else {
            hover1 = false;
        }
        if (x > 500 && x < 500 + 240 && y > 410 + 60 + 25 && y < 410 + 53 + 60 + 25) {
            hover2 = true;
        } else {
            hover2 = false;
        }
    }

    // Other mouse event methods
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
