import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The Goodbye class manages the exit / goodbye screen.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class Goodbye extends JFrame implements MouseListener, MouseMotionListener {
    private boolean hover1;
    private Image levelsBg, bg, goodbye, fg, goodbyeButt, goodbyeButtHov, butt1;

    /**
     * Constructs a Goodbye object and initializes the images.
     */
    public Goodbye() {
        img();
    }

    /**
     * Loads the images from files.
     */
    public void img() {
        try {
            levelsBg = ImageIO.read(new File("./mnTitleBlank.png"));
            bg = levelsBg.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            goodbye = ImageIO.read(new File("./mnGoodbye.png"));
            fg = goodbye.getScaledInstance(608, 318, Image.SCALE_DEFAULT);
            goodbyeButt = ImageIO.read(new File("./mnGoodbyeButt.png"));
            goodbyeButtHov = ImageIO.read(new File("./mnGoodbyeButtPress.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Overrides the paint method to draw the images.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(bg, 0, 0, null);
        g.drawImage(fg, 80, 170, null);

        butt1 = goodbyeButt.getScaledInstance(147, 174, Image.SCALE_DEFAULT);
        if (hover1)
            butt1 = goodbyeButtHov.getScaledInstance(147, 174, Image.SCALE_DEFAULT);
        g.drawImage(butt1, 625, 260, null);
    }

    /**
     * Handles the mouse movement event.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMovedCheck(e.getX(), e.getY() - 30);
    }

    /**
     * Handles the mouse click event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (hover1) {
            System.exit(0);
        }
    }

    /**
     * Checks if the mouse is hovering over a specific area.
     * 
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    public void mouseMovedCheck(int x, int y) {
        if (x > 625 && x < 625 + 147 && y > 260 && y < 260 + 174) {
            hover1 = true;
        } else {
            hover1 = false;
        }
    }

    // Unused methods from the MouseMotionListener and MouseListener interfaces
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
