import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The SplashScreen class represents the initial screen of the application.
 * It displays a logo and a launch button.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class SplashScreen extends JFrame implements MouseListener, MouseMotionListener {
    private int counter = 0;
    private int flashX = 738, flashY = 160;
    private int lightX = 738, lightY = 160;
    private int launchScaleX = 1, launchScaleY = 1;
    private double launchX = 390, launchY = 406;
    boolean hover1, hover2, splashed;
    Image logo, logoHov, splashLogo, launchButt, launchButtHov, butt1, flight, light, splashLight, splashFLight;

    /**
     * Constructs a SplashScreen object.
     */
    public SplashScreen() {
        img();
    }

    /**
     * Loads the required images.
     */
    public void img() {
        try {
            logo = ImageIO.read(new File("./mnLogo.png"));
            logoHov = ImageIO.read(new File("./mnLogoPress.png"));
            launchButt = ImageIO.read(new File("./mnLaunch.png"));
            launchButtHov = ImageIO.read(new File("./mnLaunchPress.png"));
            flight = ImageIO.read(new File("./mnFlashlit.png"));
            light = ImageIO.read(new File("./mnLight.png"));
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to load image");
        }
    }

    /**
     * Renders the SplashScreen component.
     * 
     * @param g the Graphics object used for rendering
     */
    public void paint(Graphics g) {
        // Background
        Color navy = new Color(36, 49, 79);
        g.setColor(navy);
        g.fillRect(0, 0, 768, 576);
        // SOHO Logo
        splashLogo = logo.getScaledInstance(444, 174, Image.SCALE_DEFAULT);
        if (hover1)
            splashLogo = logoHov.getScaledInstance(444, 174, Image.SCALE_DEFAULT);
        g.drawImage(splashLogo, 145, 180, null);
        // Launch button
        butt1 = launchButt.getScaledInstance(launchScaleX, launchScaleY, Image.SCALE_DEFAULT);
        if (hover2)
            butt1 = launchButtHov.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
        g.drawImage(butt1, (int) launchX, (int) launchY, null);
        splashLight = light.getScaledInstance(1044, 754, Image.SCALE_DEFAULT);
        splashFLight = flight.getScaledInstance(1044, 754, Image.SCALE_DEFAULT);
        g.drawImage(splashFLight, flashX, flashY, null);
        g.drawImage(splashLight, lightX, lightY, null);

        if (counter < 30) {
            flashX -= 5; // Adjusts the X position of the flash image
            flashY -= 16; // Adjusts the Y position of the flash image
            lightX -= 5; // Adjusts the X position of the light image
            lightY -= 16; // Adjusts the Y position of the light image
            counter++;
            repaint();
        }
        if (counter < 50 && counter >= 30) {
            flashX -= 5; // Adjusts the X position of the flash image
            flashY += 16; // Adjusts the Y position of the flash image
            lightX -= 5; // Adjusts the X position of the light image
            lightY += 16; // Adjusts the Y position of the light image
            counter++;
        }
        if (counter < 80 && counter >= 50) {
            flashX -= 5; // Adjusts the X position of the flash image
            flashY -= 16; // Adjusts the Y position of the flash image
            lightX -= 5; // Adjusts the X position of the light image
            lightY -= 16; // Adjusts the Y position of the light image
            counter++;
        }
        if (counter < 120 && counter >= 80) {
            flashX -= 5; // Adjusts the X position of the flash image
            flashY += 16; // Adjusts the Y position of the flash image
            lightX -= 5; // Adjusts the X position of the light image
            lightY += 16; // Adjusts the Y position of the light image
            counter++;
        }
        if (counter < 140 && counter >= 120) {
            flashX -= 6; // Adjusts the X position of the flash image
            flashY -= 13; // Adjusts the Y position of the flash image
            lightX -= 6; // Adjusts the X position of the light image
            lightY -= 13; // Adjusts the Y position of the light image
            counter++;
        }
        if (counter < 150 && counter >= 140) {
            launchScaleX += 24; // Adjusts the scale of the launch button on the X-axis
            launchScaleY += 5.3; // Adjusts the scale of the launch button on the Y-axis
            launchX -= 12; // Adjusts the X position of the launch button
            launchY -= 2.6; // Adjusts the Y position of the launch button
            if (counter % 3 == 0)
                lightX = 1000; // Adjusts the X position of the light image
            else
                lightX = 18; // Adjusts the X position of the light image
            counter++;
            if(counter>149)splashed=true;
        }

    }

    /**
     * Handles the mouse click event.
     * 
     * @param e the MouseEvent object representing the click event
     */
    public void mouseClicked(MouseEvent e) {
        if (counter == 150 && hover2 == true) {
            Organizer.changeScreen(1);
        }
    }

    /**
     * Handles the mouse movement event.
     * 
     * @param e the MouseEvent object representing the movement event
     */
    public void mouseMoved(MouseEvent e) {
        mouseMovedCheck(e.getX(), e.getY());
    }

    /**
     * Checks the mouse movement and updates the hover status.
     * 
     * @param x the X coordinate of the mouse position
     * @param y the Y coordinate of the mouse position
     */
    public void mouseMovedCheck(int x, int y) {
        if (counter >= 140) {
            if (x > 155 && x < 155 + 144 && y > 180 && y < 180 + 179 + 25) {
                hover1 = true; // Indicates whether the mouse is hovering over the logo
            } else {
                hover1 = false;
            }
            if (splashed&&x > 270 && x < 270 + 240 && y > 385 && y < 390 + 53 + 25) {
                hover2 = true; // Indicates whether the mouse is hovering over the launch button
            } else {
                hover2 = false;
            }
        }
    }

    // Implement required methods
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

    // Other MouseListener and MouseMotion
}
