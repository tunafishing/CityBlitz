import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The Level2 class operates the entirety of level two of the game.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class Level2 extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
    private boolean walked, go1, go2, mapPick, mapOpen, pass, cardIsOpen;
    private int screen;
    private boolean hover1, hover2, hover3, hover4, hover5, hover6;
    private boolean bpOpen;
    private boolean[] directions = new boolean[4];
    private int avX = 350, avY = 250;
    Image avt0, avt1, avt2, avt3, avatar, lvl2Bg14, mAvt0, mAvt1, mAvt2, mAvt3, fAvt0, fAvt1, fAvt2, fAvt3, lvl2Bg13,
            lvl2Bg12, bpOpeny, bpButt, bpButtHov,
            lvl2Fg14, tut6, lvl2Fg13, map, tut7;
    Image tut8, mapHov, lvl2Fg12, cardInv, cardInvHov, mapInv, mapInvHov, lvl2Bg1, lvl2Fg1, returnButt, returnButtHov,
            goButt, goButtHov, lvl2Bg2, lvl2Bg3, lvl2Bg4;
    Image lvl2Fg2, lvl2Fg3, lvl2Fg4, mapView, lvl2Bg5, lvl2Bg6, lvl2Bg7, lvl2Bg8, lvl2Bg9, lvl2Bg10, lvl2Bg11, lvl2Fg5,
            lvl2Fg6, lvl2Fg7, lvl2Fg8, lvl2Fg9, lvl2Fg10, lvl2Fg11, cardOpen;

    /**
     * Constructs a Level2 object and initializes the images.
     */
    public Level2() {
        img();
    }

    /**
     * Loads the images from files.
     */
    public void img() {
        try {
            lvl2Bg14 = ImageIO.read(new File("./mnParExt.png"));
            mAvt0 = ImageIO.read(new File("./mnAvtM0.png"));
            mAvt1 = ImageIO.read(new File("./mnAvtM1.png"));
            mAvt2 = ImageIO.read(new File("./mnAvtM2.png"));
            mAvt3 = ImageIO.read(new File("./mnAvtM3.png"));
            fAvt0 = ImageIO.read(new File("./mnAvtF0.png"));
            fAvt1 = ImageIO.read(new File("./mnAvtF1.png"));
            fAvt2 = ImageIO.read(new File("./mnAvtF2.png"));
            fAvt3 = ImageIO.read(new File("./mnAvtF3.png"));
            lvl2Bg13 = ImageIO.read(new File("./mnParInt1.png"));
            lvl2Bg12 = ImageIO.read(new File("./mnParInt2.png"));
            bpOpeny = ImageIO.read(new File("./mnBpOpen.png"));
            bpButt = ImageIO.read(new File("./mnBp.png"));
            bpButtHov = ImageIO.read(new File("./mnBpPress.png"));
            lvl2Fg14 = ImageIO.read(new File("./mnParExtFg.png"));
            tut6 = ImageIO.read(new File("./mnTut6.png"));
            lvl2Fg13 = ImageIO.read(new File("./mnParInt1Fg.png"));
            map = ImageIO.read(new File("./mnMap.png"));
            tut7 = ImageIO.read(new File("./mnTut7.png"));
            tut8 = ImageIO.read(new File("./mnTut8.png"));
            mapHov = ImageIO.read(new File("./mnMapPress.png"));
            lvl2Fg12 = ImageIO.read(new File("./mnParInt2Fg.png"));
            cardInv = ImageIO.read(new File("./mnCardInv.png"));
            cardInvHov = ImageIO.read(new File("./mnCardInvPress.png"));
            cardOpen = ImageIO.read(new File("./mnCardOpen.png"));
            mapInv = ImageIO.read(new File("./mnMapInv.png"));
            mapInvHov = ImageIO.read(new File("./mnMapInvPress.png"));
            lvl2Bg1 = ImageIO.read(new File("./mnParInt3.png"));
            lvl2Fg1 = ImageIO.read(new File("./mnParInt3Fg.png"));
            returnButt = ImageIO.read(new File("./mnReturn.png"));
            returnButtHov = ImageIO.read(new File("./mnReturnPress.png"));
            goButt = ImageIO.read(new File("./mnGo.png"));
            goButtHov = ImageIO.read(new File("./mnGoPress.png"));
            lvl2Bg2 = ImageIO.read(new File("./mnParInt4.png"));
            lvl2Bg3 = ImageIO.read(new File("./mnParInt5.png"));
            lvl2Bg4 = ImageIO.read(new File("./mnParInt6.png"));
            lvl2Fg2 = ImageIO.read(new File("./mnParInt4Fg.png"));
            lvl2Fg3 = ImageIO.read(new File("./mnParInt5Fg.png"));
            lvl2Fg4 = ImageIO.read(new File("./mnParInt6Fg.png"));
            mapView = ImageIO.read(new File("./mnMapOpen.png"));
            lvl2Bg5 = ImageIO.read(new File("./mnParInt7.png"));
            lvl2Bg6 = ImageIO.read(new File("./mnParInt8.png"));
            lvl2Bg7 = ImageIO.read(new File("./mnParInt9.png"));
            lvl2Bg8 = ImageIO.read(new File("./mnParInt10.png"));
            lvl2Bg9 = ImageIO.read(new File("./mnParInt11.png"));
            lvl2Bg10 = ImageIO.read(new File("./mnParInt12.png"));
            lvl2Bg11 = ImageIO.read(new File("./mnParInt13.png"));
            lvl2Fg5 = ImageIO.read(new File("./mnParInt4Fg.png"));
            lvl2Fg6 = ImageIO.read(new File("./mnParInt8Fg.png"));
            lvl2Fg7 = ImageIO.read(new File("./mnParInt9Fg.png"));
            lvl2Fg8 = ImageIO.read(new File("./mnParInt10Fg.png"));
            lvl2Fg9 = ImageIO.read(new File("./mnParInt3Fg.png"));
            lvl2Fg10 = ImageIO.read(new File("./mnParInt4Fg.png"));
            lvl2Fg11 = ImageIO.read(new File("./mnParInt13Fg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Paints the graphics on the screen.
     *
     * @param g the Graphics object
     */
    public void paint(Graphics g) {
        if (screen == 0) {
            Image bg = lvl2Bg1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            if (Organizer.gen == 0) {
                avt0 = mAvt0.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
                avt1 = mAvt1.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
                avt2 = mAvt2.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
                avt3 = mAvt3.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
            } else {
                avt0 = fAvt0.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
                avt1 = fAvt1.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
                avt2 = fAvt2.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
                avt3 = fAvt3.getScaledInstance(72, 120, Image.SCALE_DEFAULT);
            }
        }
        if (screen == 1) {
            Image bg = lvl2Bg2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 2) {
            Image bg = lvl2Bg3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 3) {
            Image bg = lvl2Bg4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            if (!mapPick) {
                Image obj1 = map.getScaledInstance(42, 63, Image.SCALE_DEFAULT);
                if (hover4)
                    obj1 = mapHov.getScaledInstance(42, 63, Image.SCALE_DEFAULT);
                g.drawImage(obj1, 386, 95, null);
            }
        }
        if (screen == 4) {
            Image bg = lvl2Bg5.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 5) {
            Image bg = lvl2Bg6.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 6) {
            Image bg = lvl2Bg7.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 7) {
            Image bg = lvl2Bg8.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 8) {
            Image bg = lvl2Bg9.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 9) {
            Image bg = lvl2Bg10.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 10) {
            Image bg = lvl2Bg11.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 11) {
            Image bg = lvl2Bg12.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 12) {
            Image bg = lvl2Bg13.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 13) {
            Image bg = lvl2Bg14.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (!walked)
            avatar = avt0;
        if (go1 && !bpOpen && (directions[0] || directions[1] || directions[2] || directions[3])) {
            if (directions[0] && isInBounds(avX, avY - 5)) {

                if (screen == 3 && avY < 1) {
                    screen = 0;
                    avY = 565 - 120;
                }
                if (screen == 6 && avY < 1) {
                    screen = 5;
                    avY = 565 - 120;
                }
                if (screen == 7 && avY < 1) {
                    screen = 6;
                    avY = 565 - 120;
                }
                if (screen == 10 && avY < 1) {
                    screen = 8;
                    avX = 346;
                    avY = 565 - 120;
                }
                avY -= 5;
                avatar = avt1;
            }
            if (directions[1] && isInBounds(avX + 5, avY)) {

                if (screen == 0 && avX > 712) {
                    screen = 2;
                    avX = 0;
                }
                if (screen == 1 && avX > 712) {
                    screen = 0;
                    avX = 0;
                }
                if (screen == 3 && avX > 712) {
                    screen = 5;
                    avX = 0;
                }
                if (screen == 4 && avX > 712) {
                    screen = 3;
                    avX = 0;
                }
                if (screen == 8 && avX > 712 && avY > 158) {
                    screen = 6;
                    avX = 0;
                }
                if (screen == 9 && avX > 712) {
                    screen = 8;
                    avX = 0;
                }
                if (screen == 12 && avX > 712) {
                    screen = 11;
                    avX = 0;
                }
                avX += 5;
                avatar = avt2;
            }

            if (directions[2] && isInBounds(avX, avY + 5)) {

                if (screen == 0 && avY > 570 - 120) {
                    screen = 3;
                    avY = 0;
                }
                if (screen == 5 && avY > 570 - 120) {
                    screen = 6;
                    avY = 0;
                }
                if (screen == 6 && avY > 570 - 120) {
                    screen = 7;
                    avY = 0;
                }
                if (screen == 8 && avY > 570 - 120) {
                    screen = 10;
                    avX = 500;
                    avY = 0;
                }
                if (screen == 13 && avY > 30) {
                    pass = true;
                }
                avY += 5;
                avatar = avt0;
            }
            if (directions[3] && isInBounds(avX - 5, avY)) {

                if (screen == 0 && avX < 0) {
                    screen++;
                    avX = 712;
                }
                if (screen == 2 && avX < 0) {
                    screen = 0;
                    avX = 712;
                }
                if (screen == 3 && avX < 0) {
                    screen = 4;
                    avX = 712;
                }
                if (screen == 5 && avX < 0) {
                    screen = 3;
                    avX = 712;
                }
                if (screen == 6 && avX < 0) {
                    screen = 8;
                    avX = 712;
                }
                if (screen == 8 && avX < 0) {
                    screen = 9;
                    avX = 712;
                }
                if (screen == 10 && avX < 0) {
                    screen = 11;
                    avX = 712;
                }
                if (screen == 11 && avX < 0 && avY < 275) {
                    screen = 12;
                    avX = 712;
                }
                if (screen == 12 && avX < 0 && avY > 353) {
                    screen = 13;
                    avX = 350;
                    avY = 205;
                }

                avX -= 5;
                avatar = avt3;
            }

        }
        g.drawImage(avatar, avX, avY, null);

        if (screen == 0) {
            Image fg = lvl2Fg1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            if (!go1) {
                Image tb = tut6.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, -60, null);

                Image butt2 = goButt.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                if (hover3)
                    butt2 = goButtHov.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                g.drawImage(butt2, 640, 255, null);
            }
        }
        if (screen == 1) {
            Image fg = lvl2Fg2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 2) {
            Image fg = lvl2Fg3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 3) {
            Image fg = lvl2Fg4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 4) {
            Image fg = lvl2Fg5.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 5) {
            Image fg = lvl2Fg6.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 6) {
            Image fg = lvl2Fg7.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 7) {
            Image fg = lvl2Fg8.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 8) {
            Image fg = lvl2Fg9.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 9) {
            Image fg = lvl2Fg10.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 10) {
            Image fg = lvl2Fg11.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 11) {
            Image fg = lvl2Fg12.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            if (!go2) {
                Image tb = tut7.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 0, null);

                Image butt2 = goButt.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                if (hover3)
                    butt2 = goButtHov.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                g.drawImage(butt2, 640, 255, null);
            }
        }
        if (screen == 12) {
            Image fg = lvl2Fg13.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 13) {
            Image fg = lvl2Fg14.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            if (pass) {
                Image tb = tut8.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 0, null);

                Image butt2 = returnButt.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
                if (hover6)
                    butt2 = returnButtHov.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
                g.drawImage(butt2, 30, 300, null);
            }
        }
        if (bpOpen) {
            Color transpBlack = new Color(0, 0, 0, 85);
            g.setColor(transpBlack);
            g.fillRect(0, 0, 768, 576);

            Image inv = bpOpeny.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(inv, 0, 0, null);

            Image inv1 = cardInv.getScaledInstance(66, 96, Image.SCALE_DEFAULT);
            if (hover2)
                inv1 = cardInvHov.getScaledInstance(66, 96, Image.SCALE_DEFAULT);
            g.drawImage(inv1, 164, 160, null);

            if (mapPick) {
                Image inv2 = mapInv.getScaledInstance(63, 141, Image.SCALE_DEFAULT);
                if (hover5)
                    inv2 = mapInvHov.getScaledInstance(63, 141, Image.SCALE_DEFAULT);
                g.drawImage(inv2, 295, 126, null);
            }
            if (mapOpen) {
                Image mapViewy = mapView.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(mapViewy, 0, 0, null);
            }
        }
        Image butt1 = bpButt.getScaledInstance(64, 70, Image.SCALE_DEFAULT);
        if (hover1)
            butt1 = bpButtHov.getScaledInstance(64, 70, Image.SCALE_DEFAULT);
        g.drawImage(butt1, 695, 477, null);

        if (cardIsOpen) {
            Color transpBlack = new Color(0, 0, 0, 85);
            g.setColor(transpBlack);
            g.fillRect(0, 0, 768, 576);

            Image obj1 = cardOpen.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(obj1, 0, 0, null);
        }
    }

    /**
     * Invoked when the mouse is clicked.
     *
     * @param e the MouseEvent containing information about the mouse activity.
     */
    public void mouseClicked(MouseEvent e) {
        if (hover1 && !bpOpen) {
            bpOpen = true;

        } else if (hover1 && bpOpen) {
            bpOpen = false;
        }
        if (bpOpen && hover2 && !cardIsOpen) {
            cardIsOpen = true;
            bpOpen = false;
        } else if (cardIsOpen) {
            cardIsOpen = false;
            bpOpen = true;
        }
        if (screen == 0 && hover3 && !go1) {
            go1 = true;
        }
        if (screen == 11 && hover3 && !go2) {
            go2 = true;
        }
        if (screen == 3 && hover4 && !mapPick) {
            mapPick = true;
        }
        if (mapPick && hover5 && bpOpen && !mapOpen && !cardIsOpen) {
            mapOpen = true;
        } else if (mapPick && bpOpen && mapOpen) {
            mapOpen = false;
        }
        if (pass && hover6) {
            Organizer.unlock3 = true;
            Organizer.changeScreen(3);
            reset();
        }

    }

    /**
     * Invoked when the mouse is moved.
     *
     * @param e the MouseEvent containing information about the mouse movement
     */
    public void mouseMoved(MouseEvent e) {
        mouseMovedCheck(e.getX(), e.getY() - 30);
    }

    /**
     * Invoked when a key is pressed.
     *
     * @param e the KeyEvent containing information about the key press
     */
    @Override
    public void keyPressed(KeyEvent e) {
        walked = true;
        
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            directions[0] = true;
        }
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
            directions[3] = true;
        }
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            directions[2] = true;
        }
        if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
            directions[1] = true;
        }
    }

    // excess methods
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Invoked when a key is released.
     *
     * @param e the KeyEvent containing information about the key release
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            directions[0] = false;
        }
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
            directions[3] = false;
        }
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            directions[2] = false;
        }
        if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
            directions[1] = false;
        }

    }

    /**
     * Invoked when the mouse moved to check coordinates.
     *
     * @param x the x coordinate of the mouse
     * @param y the y coordinate of the mouse
     */
    public void mouseMovedCheck(int x, int y) {
        if (x > 695 && x < 695 + 64 && y > 477 && y < 477 + 70) {
            hover1 = true;
        } else {
            hover1 = false;
        }
        if (x > 164 && x < 164 + 66 && y > 160 && y < 160 + 96) {
            hover2 = true;
        } else {
            hover2 = false;
        }
        if (x > 640 && x < 640 + 87 && y > 255 && y < 255 + 63) {
            hover3 = true;
        } else {
            hover3 = false;
        }
        if (x > 386 && x < 386 + 42 && y > 95 && y < 95 + 63) {
            hover4 = true;
        } else {
            hover4 = false;
        }
        if (x > 386 && x < 386 + 42 && y > 95 && y < 95 + 63) {
            hover4 = true;
        } else {
            hover4 = false;
        }
        if (x > 295 && x < 295 + 63 && y > 126 && y < 126 + 141) {
            hover5 = true;
        } else {
            hover5 = false;
        }
        if (x > 30 && x < 30 + 240 && y > 300 && y < 300 + 53) {
            hover6 = true;

        } else {
            hover6 = false;

        }
    }

    /**
     * Checks if a certain point is within bounds
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public boolean isInBounds(int x, int y) {
        boolean isInBounds = true;
        if (screen == 0 || screen == 8) {
            if (x <= -23 || x >= 795 - 72 || y <= 140 || y > 586 - 120 ||
                    x > 0 - 72 && x < 325 && y < 549 && y > 312 ||
                    x > 442 - 72 && x < 768 && y < 549 && y > 312 ||
                    x > 620 - 72 && x < 700 && y < 257 - 100 && y > 185 - 120)
                isInBounds = false;
        } else if (screen == 1 || screen == 4 || screen == 9) {
            if (x <= 223 || x >= 795 - 72 || y <= 140 || y > 312 ||
                    x > 277 - 72 && x < 510 && y < 262 - 100 && y > 187 - 120)
                isInBounds = false;
        } else if (screen == 2) {
            if (x <= -23 || x >= 545 - 72 || y <= 140 || y > 312 ||
                    x > 256 - 72 && x < 487 && y < 262 - 100 && y > 187 - 120)
                isInBounds = false;
        } else if (screen == 3) {
            if (x <= -23 || x >= 795 - 72 || y <= -10 || y > 312 ||
                    x > 0 - 72 && x < 325 && y < 227 - 100 && y > 4 - 120 ||
                    x > 443 - 72 && x < 765 && y < 227 - 100 && y > 4 - 120 ||
                    x > 40 - 72 && x < 205 && y < 255 - 100 && y > 194 - 120)
                isInBounds = false;
        } else if (screen == 5) {
            if (x <= -23 || x >= 545 - 72 || y <= 140 || y > 586 - 120 ||
                    x > 256 - 72 && x < 487 && y < 262 - 100 && y > 187 - 120 ||
                    x > 0 - 72 && x < 270 && y > 312 ||
                    x > 388 - 72 && x < 765 && y > 312)
                isInBounds = false;
        } else if (screen == 6) {
            if (x <= -23 || x >= 545 - 72 || y <= -10 || y > 586 - 120 ||
                    x > 0 - 72 && x < 270 && y > 312 ||
                    x > 388 - 72 && x < 765 && y > 312 ||
                    x > 0 - 72 && x < 270 && y <= 140 ||
                    x > 388 - 72 && x < 765 && y <= 140 ||
                    x > 486 - 72 && x < 537 && y <= 262 - 100 && y > 186 - 120 ||
                    x > 53 - 72 && x < 249 && y <= 258 - 100 && y > 196 - 120)
                isInBounds = false;
        } else if (screen == 7) {
            if (x < 138 || x >= 545 - 72 || y <= -10 || y > 300 ||
                    x > 0 - 72 && x < 270 && y <= 140 ||
                    x > 388 - 72 && x < 765 && y <= 140)
                isInBounds = false;
        } else if (screen == 10) {
            if (x < -23 || x > 647 || y <= -10 || y > 312 ||
                    x > 0 - 72 && x < 471 && y <= 140 ||
                    x > 517 && x < 765 && y <= 140 ||
                    x > 605 - 72 && x < 714 && y <= 260 - 100 && y > 181 - 120)
                isInBounds = false;
        }
        if (screen == 11) {
            if (x <= -13 || x >= 795 - 72 || y <= 150 || y > 556 - 120 ||
                    x > 45 - 72 && x < 210 && y < 469 - 70 && y > 421 - 120 ||
                    x > 230 - 72 && x < 250 && y < 500 - 100 && y > 435 - 120 ||
                    x > 485 - 72 && x < 520 && y < 530 && y > 507 - 120 ||
                    x > 710 - 72 && x < 735 && y < 536 - 100 && y > 484 - 120)
                isInBounds = false;
        }
        if (screen == 12) {
            if (x < -23 || x >= 795 - 72 || y <= 10 || y > 566 - 120 ||
                    x > 0 - 72 && x < 495 && y < 445 - 70 && y > 440 - 120 ||
                    x > 210 - 72 && x < 630 && y < 370 - 70 && y > 367 - 120 ||
                    x > 630 - 72 && x < 620 && y < 557 - 100 && y > 367 - 120 ||
                    x > 145 - 85 && x < 620 && y < 323 - 100 && y > 231 - 120 ||
                    x > 542 - 85 && x < 560 && y < 340 - 100 && y > 220 - 120 ||
                    x > 0 - 72 && x < 70 && y < 290 - 70 && y > 215 - 120 ||
                    x > 80 - 72 && x < 130 && y < 263 - 70 && y > 148 - 120 ||
                    x > 610 - 72 && x < 764 && y < 252 - 100 && y > 177 - 120 ||
                    x > 735 - 72 && x < 764 && y < 524 - 100 && y > 397 - 120)
                isInBounds = false;
        }
        if (screen == 13) {
            if (x <= 0 || x >= 768 - 72 || y <= 10 || y > 576 - 120 ||
                    x > 0 && x < 768 && y < 576 - 100 && y > 463 - 120 ||
                    x > 59 - 72 && x < 108 && y < 447 - 100 && y > 374 - 120 ||
                    x > 480 - 72 && x < 515 && y < 124 - 100 && y > 94 - 120 ||
                    x > 256 - 72 && x < 290 && y < 124 - 100 && y > 94 - 120 ||
                    x > 5 - 72 && x < 66 && y < 234 - 100 && y > 130 - 120 ||
                    x > 699 - 72 && x < 763 && y < 208 - 100 && y > 133 - 120 ||
                    x > 220 && x < 470 && y < 200 && y > 15 ||
                    x > 285 && x < 320 && y < 225 ||
                    x > 375 && x < 415 && y < 225 ) 
                isInBounds = false;
        }
        return isInBounds;
    }

    /**
     * Resets all necessary variables for replaying when the level concludes
     */
    public void reset() {
        walked = false;
        go1 = false;
        go2 = false;
        mapPick = false;
        pass = false;
        cardIsOpen = false;
        screen = 0;
        avX = 350;
        avY = 250;
    }

    // excess methods
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