import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The Level1 class operates the rest of level one of the game.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class Level1 extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
    private boolean walked, cardPick, pass, cardIsOpen;
    private boolean ticket = true;
    private boolean hover1, hover2, hover3, hover4, hover5;
    private boolean bpOpen;
    private int screen;
    private boolean[] directions = new boolean[4];
    private int avX = 600, avY = 340;
    Image tb, fg, bg, avt0, avt1, avt2, avt3, avatar, lvl1Bg1, mAvt0, mAvt1, mAvt2, mAvt3, fAvt1, fAvt0, fAvt2, fAvt3,
            lvl1Bg2, lvl1Bg3, bpOpeny, tickety,
            ticketyHov, check, bpButt, bpButtHov, lvl1Fg1, tut1, lvl1Fg2;
    Image inv1, butt2, inv, chk, butt1, tut2, tut3, tut4, card, cardHov, lvl1Fg3, cardInv, cardInvHov, lvl1Bg4, lvl1Fg4,
            tut5, returnButt, returnButtHov, cardOpen;

    /**
     * Constructs a Level1 object and initializes the images.
     */
    public Level1() {
        img();
    }

    /**
     * Loads the images from files.
     */
    public void img() {
        try {
            lvl1Bg1 = ImageIO.read(new File("./mnParExt.png"));
            mAvt0 = ImageIO.read(new File("./mnAvtM0.png"));
            mAvt1 = ImageIO.read(new File("./mnAvtM1.png"));
            mAvt2 = ImageIO.read(new File("./mnAvtM2.png"));
            mAvt3 = ImageIO.read(new File("./mnAvtM3.png"));
            fAvt0 = ImageIO.read(new File("./mnAvtF0.png"));
            fAvt1 = ImageIO.read(new File("./mnAvtF1.png"));
            fAvt2 = ImageIO.read(new File("./mnAvtF2.png"));
            fAvt3 = ImageIO.read(new File("./mnAvtF3.png"));
            lvl1Bg2 = ImageIO.read(new File("./mnParInt1.png"));
            lvl1Bg3 = ImageIO.read(new File("./mnParInt2.png"));
            bpOpeny = ImageIO.read(new File("./mnBpOpen.png"));
            tickety = ImageIO.read(new File("./mnTicket.png"));
            ticketyHov = ImageIO.read(new File("./mnTicketPress.png"));
            check = ImageIO.read(new File("./mnCheck.png"));
            bpButt = ImageIO.read(new File("./mnBp.png"));
            bpButtHov = ImageIO.read(new File("./mnBpPress.png"));
            lvl1Fg1 = ImageIO.read(new File("./mnParExtFg.png"));
            tut1 = ImageIO.read(new File("./mnTut1.png"));
            lvl1Fg2 = ImageIO.read(new File("./mnParInt1Fg.png"));
            tut2 = ImageIO.read(new File("./mnTut2.png"));
            tut3 = ImageIO.read(new File("./mnTut3.png"));
            tut4 = ImageIO.read(new File("./mnTut4.png"));
            card = ImageIO.read(new File("./mnCard.png"));
            cardHov = ImageIO.read(new File("./mnCardPress.png"));
            lvl1Fg3 = ImageIO.read(new File("./mnParInt2Fg.png"));
            cardInv = ImageIO.read(new File("./mnCardInv.png"));
            cardInvHov = ImageIO.read(new File("./mnCardInvPress.png"));
            cardOpen = ImageIO.read(new File("./mnCardOpen.png"));
            lvl1Bg4 = ImageIO.read(new File("./mnParInt3.png"));
            lvl1Fg4 = ImageIO.read(new File("./mnParInt3Fg.png"));
            tut5 = ImageIO.read(new File("./mnTut5.png"));
            returnButt = ImageIO.read(new File("./mnReturn.png"));
            returnButtHov = ImageIO.read(new File("./mnReturnPress.png"));
        }

        catch (IOException e) {
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
            bg = lvl1Bg1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
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
        } else if (screen == 1) {
            bg = lvl1Bg2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        } else if (screen == 2) {
            bg = lvl1Bg3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            if (!cardPick) {
                Image obj1 = card.getScaledInstance(18, 22, Image.SCALE_DEFAULT);
                if (hover3)
                    obj1 = cardHov.getScaledInstance(18, 22, Image.SCALE_DEFAULT);
                g.drawImage(obj1, 521, 333, null);
            }
        }

        else if (screen == 3) {
            bg = lvl1Bg4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

        }
        if (!walked)
            avatar = avt0;
        if (!bpOpen && (directions[0] || directions[1] || directions[2] || directions[3])) {
            if (directions[0] && isInBounds(avX, avY - 5)) {
                if (avX > 320 && avX < 375&& avY < 210 && screen == 0) {
                    screen++;
                    avX = 10;
                    avY = 400;
                }
                avY -= 5;
                avatar = avt1;
            }
            if (directions[1] && isInBounds(avX + 5, avY)) {
                if (screen == 1 && !ticket && avX > 712) {
                    screen++;
                    avX = 0;
                } else if (screen == 2 && cardPick && avX > 712 && avY < 311) {
                    screen++;
                    avX = 0;
                } else if (screen == 3 && avX > 200)
                    pass = true;
                avX += 5;
                avatar = avt2;
            }

            if (directions[2] && isInBounds(avX, avY + 5)) {
                avY += 5;
                avatar = avt0;
            }
            if (directions[3] && isInBounds(avX - 5, avY)) {
                if (screen == 2 && avX < 0 && avY < 278 && avY > 160) {
                    screen--;
                    avX = 712;
                }
                avX -= 5;
                avatar = avt3;
            }

        }
        g.drawImage(avatar, avX, avY, null);

        if (screen == 0) {
            fg = lvl1Fg1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            tb = tut1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(tb, 0, 0, null);
        } else if (screen == 1) {
            fg = lvl1Fg2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            tb = tut2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(tb, 0, 0, null);

            if (!ticket && !bpOpen) {
                chk = check.getScaledInstance(26, 20, Image.SCALE_DEFAULT);
                g.drawImage(chk, 329, 123, null);
            }
            butt1 = bpButt.getScaledInstance(64, 70, Image.SCALE_DEFAULT);
            if (hover1)
                butt1 = bpButtHov.getScaledInstance(64, 70, Image.SCALE_DEFAULT);
            g.drawImage(butt1, 695, 477, null);
        } else if (screen == 2) {
            fg = lvl1Fg3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            tb = tut3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if (cardPick)
                tb = tut4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(tb, 0, 0, null);
        }

        if (bpOpen) {
            Color transpBlack = new Color(0, 0, 0, 85);
            g.setColor(transpBlack);
            g.fillRect(0, 0, 768, 576);

            inv = bpOpeny.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(inv, 0, 0, null);

            if (ticket && screen == 1) {
                inv1 = tickety.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover2)
                    inv1 = ticketyHov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(inv1, 0, 0, null);
            } else if (cardPick) {
                inv1 = cardInv.getScaledInstance(66, 96, Image.SCALE_DEFAULT);
                if (hover4)
                    inv1 = cardInvHov.getScaledInstance(66, 96, Image.SCALE_DEFAULT);
                g.drawImage(inv1, 164, 160, null);
            }

        }

        if (screen == 3) {
            fg = lvl1Fg4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }

        butt1 = bpButt.getScaledInstance(64, 70, Image.SCALE_DEFAULT);
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

        if (pass) {
            tb = tut5.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(tb, 0, 0, null);

            butt2 = returnButt.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
            if (hover5)
                butt2 = returnButtHov.getScaledInstance(240, 53, Image.SCALE_DEFAULT);
            g.drawImage(butt2, 500, 280, null);
        }
    }

    /**
     * Invoked when the mouse is clicked.
     *
     * @param e the MouseEvent containing information about the mouse activity.
     */
    public void mouseClicked(MouseEvent e) {
        if (hover1 && !bpOpen && screen != 0) {
            bpOpen = true;

        } else if (hover1 && bpOpen) {
            bpOpen = false;
        }
        if (bpOpen && hover4 && !cardIsOpen) {
            cardIsOpen = true;
            bpOpen = false;
        } else if (cardIsOpen) {
            cardIsOpen = false;
            bpOpen = true;
        }
        if (hover2 && ticket && avX > 279 && avX < 454 && avY < 240 && screen == 1) {
            ticket = false;
            bpOpen = false;
        }
        if (hover3 && !cardPick && screen == 2) {
            cardPick = true;
        }
        if (hover5 && screen == 3) {
            Organizer.unlock2 = true;
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

    // excess methods
    @Override
    public void keyTyped(KeyEvent e) {
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
        if (x > 169 && x < 215 && y > 169 && y < 248) {
            hover2 = true;

        } else {
            hover2 = false;

        }
        if (x > 521 && x < 521 + 18 && y > 333 && y < 333 + 22) {
            hover3 = true;

        } else {
            hover3 = false;

        }
        if (cardPick && x > 164 && x < 164 + 66 && y > 160 && y < 160 + 96) {
            hover4 = true;

        } else {
            hover4 = false;

        }
        if (x > 500 && x < 500 + 240 && y > 280 && y < 280 + 53 && pass) {
            hover5 = true;

        } else {
            hover5 = false;

        }
    }

    /**
     * Checks if a certain point is within bounds code1
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public boolean isInBounds(int x, int y) {
        boolean isInBounds = true;
        if (screen == 0) {
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
        if (screen == 1) {
            if (x <= 0 || x >= 795 - 72 || y <= 10 || y > 566 - 120 ||
                    x > 0 - 72 && x < 495 && y < 445 - 70 && y > 440 - 120 ||
                    x > 210 - 72 && x < 630 && y < 370 - 70 && y > 367 - 120 ||
                    x > 630 - 72 && x < 620 && y < 557 - 100 && y > 367 - 120 ||
                    x > 145 - 85 && x < 620 && y < 323 - 100 && y > 231 - 120 ||
                    x > 542 - 85 && x < 560 && y < 340 - 100 && y > 220 - 120 ||
                    x > 0 - 72 && x < 70 && y < 290 - 70 && y > 215 - 120 ||
                    x > 80 - 72 && x < 130 && y < 263 - 70 && y > 148 - 120 ||
                    x > 610 - 72 && x < 764 && y < 252 - 100 && y > 177 - 120 ||
                    x > 735 - 72 && x < 764 && y < 524 - 100 && y > 397 - 120 )
                isInBounds = false;
        }
        if (screen == 2) {
            if (x <= -13 || x >= 795 - 72 || y <= 150 || y > 556 - 120 ||
                    x > 45 - 72 && x < 210 && y < 469 - 70 && y > 421 - 120 ||
                    x > 230 - 72 && x < 250 && y < 500 - 100 && y > 435 - 120 ||
                    x > 485 - 72 && x < 520 && y < 530 && y > 507 - 120 ||
                    x > 710 - 72 && x < 735 && y < 536 - 100 && y > 484 - 120)
                isInBounds = false;
        }
        if (screen == 3) {
            if (x <= -23 || x >= 795 - 72 || y <= 140 || y > 586 - 120 ||
                    x > 0 - 72 && x < 326 && y < 549 && y > 312 ||
                    x > 441 - 72 && x < 768 && y < 549 && y > 312 ||
                    x > 620 - 72 && x < 700 && y < 257 - 100 && y > 185 - 120)
                isInBounds = false;
        }
        return isInBounds;
    }

    /**
     * Resets all necessary variables for replaying when the level concludes
     */
    public void reset() {
        walked = false;
        cardPick = false;
        pass = false;
        ticket = true;
        cardIsOpen = false;
        screen = 0;
        avX = 600;
        avY = 340;
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
