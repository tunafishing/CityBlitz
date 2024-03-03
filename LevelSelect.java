import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The LevelSelect screen navigates the user to the various levels of the game.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class LevelSelect extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private boolean hover1, hover2, hover3, hover4;
    private Image levelsBg, bg, levelsTitle, title, backButt, backButtHov, butt4, Level1Butt, Level1ButtHov, butt1;
    private Image Level2Butt, Level2ButtHov, butt2, Level3Butt, Level3ButtHov, butt3, Level3ButtLock, Level2ButtLock;

    /**
     * Constructs a LevelSelect object and initializes the images.
     */
    public LevelSelect() {
        img();
    }

    /**
     * Loads the images from files.
     */
    public void img() {
        try {
            levelsBg = ImageIO.read(new File("./mnTitleBlank.png"));
            bg = levelsBg.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            backButt = ImageIO.read(new File("./mnBack.png"));
            backButtHov = ImageIO.read(new File("./mnBackPress.png"));
            levelsTitle = ImageIO.read(new File("./mnLevelSelect.png"));
            Level1Butt = ImageIO.read(new File("./mnLevel1Butt.png"));
            Level1ButtHov = ImageIO.read(new File("./mnLevel1ButtPress.png"));
            Level2Butt = ImageIO.read(new File("./mnLevel2Butt.png"));
            Level2ButtHov = ImageIO.read(new File("./mnLevel2ButtPress.png"));
            Level2ButtLock = ImageIO.read(new File("./mnLevel2ButtLock.png"));
            Level3Butt = ImageIO.read(new File("./mnLevel3Butt.png"));
            Level3ButtHov = ImageIO.read(new File("./mnLevel3ButtPress.png"));
            Level3ButtLock = ImageIO.read(new File("./mnLevel3ButtLock.png"));
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
        title = levelsTitle.getScaledInstance(448, 125, Image.SCALE_DEFAULT);
        g.drawImage(title, 160, 80, null);

        butt4 = backButt.getScaledInstance(117, 63, Image.SCALE_DEFAULT);
        if (hover4)
            butt4 = backButtHov.getScaledInstance(117, 63, Image.SCALE_DEFAULT);
        g.drawImage(butt4, 10, 10, null);

        butt1 = Level1Butt.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        if (hover1)
            butt1 = Level1ButtHov.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        g.drawImage(butt1, 50, 230, null);

        if (!Organizer.unlock2)
            butt2 = Level2ButtLock.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        else if (hover2)
            butt2 = Level2ButtHov.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        else
            butt2 = Level2Butt.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        g.drawImage(butt2, 50, 330, null);

        if (!Organizer.unlock3)
            butt3 = Level3ButtLock.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        else if (hover3)
            butt3 = Level3ButtHov.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        else
            butt3 = Level3Butt.getScaledInstance(640, 90, Image.SCALE_DEFAULT);
        g.drawImage(butt3, 50, 430, null);
    }

    /**
     * Handles the mouse click event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (hover1)
            Organizer.changeScreen(4);
        if (hover2)
            Organizer.changeScreen(6);
        if (hover3)
            Organizer.changeScreen(7);
        if (hover4)
            Organizer.changeScreen(1);
    }

    /**
     * Handles the mouse movement event.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMovedCheck(e.getX(), e.getY());
    }

    /**
     * Checks if the mouse is hovering over a specific area.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    public void mouseMovedCheck(int x, int y) {
        boolean isInside1 = x > 50 && x < 50 + 640 && y > 230 + 25 && y < 230 + 90 + 25;
        boolean isInside2 = x > 50 && x < 50 + 640 && y > 330 + 25 && y < 330 + 90 + 25;
        boolean isInside3 = x > 50 && x < 50 + 640 && y > 430 + 25 && y < 430 + 90 + 25;

        if (isInside1) {
            hover1 = true;
        } else if (!isInside1) {
            hover1 = false;
        }

        if (isInside2) {
            hover2 = true;
        } else if (!isInside2) {
            hover2 = false;
        }

        if (isInside3) {
            hover3 = true;
        } else if (!isInside3) {
            hover3 = false;
        }

        if (x > 10 && x < 10 + 117 && y > 10 + 25 && y < 10 + 63 + 25) {
            hover4 = true;
        } else if (!isInside3) {
            hover4 = false;
        }
    }

    // Unused methods from the KeyListener, MouseListener, and MouseMotionListener
    // interfaces
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

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
