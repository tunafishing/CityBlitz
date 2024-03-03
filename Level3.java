import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The Level3 class operates the entirety of level three of the game.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class Level3 extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
    private boolean walked, go1, go2 = true, go3 = true, mapPick = true, mapOpen, pushGate, task2, talk1, tasked,
            elevButtIsOpen;
    private int screen = 0, guess, ans, stationChoose = -1, floorChoose = -1;
    private boolean hover1, hover2, hover3, hover4, hover5, hover6, hover7, hover8, hover9, hover10, hover11, hover12,
            hover13, hover14, hover15, hover16, hover17, hover18, hover19, hover20, hover21, hover22, hover23, hover24,
            hover25, hover26, hover27, hover28, hover29, hover30, hover31, hover32, hover33, hover34, hover35;
    private boolean bpOpen, coinPick, moneyGuyPick, talk2, guessingGame, guessed, moneyGuyWin, coinsUse, ticketUse,
            posterOpen, cardIsOpen, tut19Open, tut20Open, leavesIsOpen, trophyIsOpen, leaf1Pick, leaf2Pick;
    private boolean[] directions = new boolean[4];
    private int avX = 350, avY = 250;
    Image avt0, avt1, avt2, avt3, avatar, lvl3Bg1, mAvt0, mAvt1, mAvt2, mAvt3, fAvt0, fAvt1, fAvt2, fAvt3, bpOpeny,
            bpButt, bpButtHov, lvl3Fg1, boothGuy, inv3, obj2, obj3,
            boothGuyHov, moneyGuy, moneyGuyHov, coins, coinsHov;
    Image mapInv, mapInvHov, subwayTicketInv, subwayTicketInvHov, goButt, goButtHov, lvl3Bg3, lvl3Bg4, lvl3Fg3, lvl3Fg4,
            mapView, lvl3Bg5, lvl3Bg6, lvl3Bg7, lvl3Bg8, lvl3Bg9, lvl3Bg10, lvl3Bg11;
    Image lvl3Fg5, lvl3Fg6, lvl3Fg7, lvl3Fg8, lvl3Fg9, lvl3Fg10, tut9, tut10, tut11, tut12, tut13, tut14, tut15, tut16,
            tut17, tut18, tut19;
    Image lvl3Bg2, key1, key1Hov, key2, key2Hov, key3, key3Hov, keyGreen, keyGreenHov, lvl3Fg2, posters, postersHov,
            postersOpen, cardInv, cardInvHov, cardOpen, coinsInv, coinsInvHov, lvl3Bg12, lvl3Bg13, lvl3Bg14, lvl3Fg11,
            lvl3Fg12;
    Image elevButt1, elevButt2, elevButt3, elevButt4, elevButt5, elevButt6, elevButt7, elevButt8, elevButt1Hov, invLeaf, elevButt2Hov, elevButt3Hov,elevButt4Hov, elevButt5Hov, elevButt6Hov, elevButt7Hov, elevButt8Hov, elevButtOpen, elevButtHov, elevButt, 
            leaf, leafHov, leafInv, leafInvHov, leavesOpen0, leavesOpen1, leavesOpen2, leavesOpen3, leavesOpen4, leavesOpen5, leavesOpen6, trophy, trophyInv, trophyInvHov, trophyOpen;

    /**
     * Constructs a Level3 object and initializes the images.
     */
    public Level3() {
        img();
    }

    /**
     * Loads the images from files.
     */
    public void img() {
        try {
            lvl3Bg1 = ImageIO.read(new File("./mnParExt.png"));
            mAvt0 = ImageIO.read(new File("./mnAvtM0.png"));
            mAvt1 = ImageIO.read(new File("./mnAvtM1.png"));
            mAvt2 = ImageIO.read(new File("./mnAvtM2.png"));
            mAvt3 = ImageIO.read(new File("./mnAvtM3.png"));
            fAvt0 = ImageIO.read(new File("./mnAvtF0.png"));
            fAvt1 = ImageIO.read(new File("./mnAvtF1.png"));
            fAvt2 = ImageIO.read(new File("./mnAvtF2.png"));
            fAvt3 = ImageIO.read(new File("./mnAvtF3.png"));
            bpOpeny = ImageIO.read(new File("./mnBpOpen.png"));
            bpButt = ImageIO.read(new File("./mnBp.png"));
            bpButtHov = ImageIO.read(new File("./mnBpPress.png"));
            lvl3Fg1 = ImageIO.read(new File("./mnParExtFg.png"));
            boothGuy = ImageIO.read(new File("./mnBoothGuy.png"));
            boothGuyHov = ImageIO.read(new File("./mnBoothGuyPress.png"));
            moneyGuy = ImageIO.read(new File("./mnMoneyGuy.png"));
            moneyGuyHov = ImageIO.read(new File("./mnMoneyGuyPress.png"));
            coins = ImageIO.read(new File("./mnCoins.png"));
            coinsHov = ImageIO.read(new File("./mnCoinsPress.png"));
            cardInv = ImageIO.read(new File("./mnCardInv.png"));
            cardInvHov = ImageIO.read(new File("./mnCardInvPress.png"));
            cardOpen = ImageIO.read(new File("./mnCardOpen.png"));
            coinsInv = ImageIO.read(new File("./mnCoinsInv.png"));
            coinsInvHov = ImageIO.read(new File("./mnCoinsInvPress.png"));
            mapInv = ImageIO.read(new File("./mnMapInv.png"));
            mapInvHov = ImageIO.read(new File("./mnMapInvPress.png"));
            subwayTicketInv = ImageIO.read(new File("./mnSubwayTicket.png"));
            subwayTicketInvHov = ImageIO.read(new File("./mnSubwayTicketPress.png"));
            goButt = ImageIO.read(new File("./mnGo.png"));
            goButtHov = ImageIO.read(new File("./mnGoPress.png"));
            lvl3Bg3 = ImageIO.read(new File("./mnOttExt2.png"));
            lvl3Bg4 = ImageIO.read(new File("./mnOttExt3.png"));
            lvl3Fg3 = ImageIO.read(new File("./mnOttExt2Fg.png"));
            lvl3Fg4 = ImageIO.read(new File("./mnOttExt3Fg.png"));
            mapView = ImageIO.read(new File("./mnMapOpen.png"));
            lvl3Bg6 = ImageIO.read(new File("./mnOttExt5.png"));
            lvl3Bg7 = ImageIO.read(new File("./mnOttInt1.png"));
            lvl3Bg8 = ImageIO.read(new File("./mnOttInt2.png"));
            lvl3Bg9 = ImageIO.read(new File("./mnOttInt3.png"));
            lvl3Bg10 = ImageIO.read(new File("./mnOttExt6.png"));
            lvl3Bg11 = ImageIO.read(new File("./mnOutro.png"));
            lvl3Fg6 = ImageIO.read(new File("./mnOttExt5Fg.png"));
            lvl3Fg7 = ImageIO.read(new File("./mnOttInt1Fg.png"));
            lvl3Fg8 = ImageIO.read(new File("./mnOttInt2Fg.png"));
            lvl3Fg9 = ImageIO.read(new File("./mnOttInt3Fg.png"));
            lvl3Fg10 = ImageIO.read(new File("./mnOttExt6Fg.png"));
            tut9 = ImageIO.read(new File("./mnTut9.png"));
            tut10 = ImageIO.read(new File("./mnTut10.png"));
            tut11 = ImageIO.read(new File("./mnTut11.png"));
            tut12 = ImageIO.read(new File("./mnTut12.png"));
            tut13 = ImageIO.read(new File("./mnTut13.png"));
            tut14 = ImageIO.read(new File("./mnTut14.png"));
            tut15 = ImageIO.read(new File("./mnTut15.png"));
            tut16 = ImageIO.read(new File("./mnTut16.png"));
            tut17 = ImageIO.read(new File("./mnTut17.png"));
            tut18 = ImageIO.read(new File("./mnTut18.png"));
            tut19 = ImageIO.read(new File("./mnTut19.png"));
            lvl3Bg2 = ImageIO.read(new File("./mnOttExt1.png"));
            key1 = ImageIO.read(new File("./mnKey1.png"));
            key1Hov = ImageIO.read(new File("./mnKey1Press.png"));
            key2 = ImageIO.read(new File("./mnKey2.png"));
            key2Hov = ImageIO.read(new File("./mnKey2Press.png"));
            key3 = ImageIO.read(new File("./mnKey3.png"));
            key3Hov = ImageIO.read(new File("./mnKey3Press.png"));
            keyGreen = ImageIO.read(new File("./mnKeyGreen.png"));
            keyGreenHov = ImageIO.read(new File("./mnKeyGreenPress.png"));
            lvl3Fg2 = ImageIO.read(new File("./mnOttExt1Fg.png"));
            posters = ImageIO.read(new File("./mnPosters.png"));
            postersHov = ImageIO.read(new File("./mnPostersPress.png"));
            postersOpen = ImageIO.read(new File("./mnPosterOpen.png"));
            lvl3Fg11 = ImageIO.read(new File("./mnHotelInt1Fg.png"));
            lvl3Fg12 = ImageIO.read(new File("./mnHotelInt2Fg.png"));
            lvl3Bg12 = ImageIO.read(new File("./mnHotelInt1.png"));
            lvl3Bg13 = ImageIO.read(new File("./mnHotelInt2.png"));
            lvl3Bg14 = ImageIO.read(new File("./mnHotelInt3.png"));
            elevButt1 = ImageIO.read(new File("./mnElevatorButtons1.png"));
            elevButt2 = ImageIO.read(new File("./mnElevatorButtons2.png"));
            elevButt3 = ImageIO.read(new File("./mnElevatorButtons3.png"));
            elevButt4 = ImageIO.read(new File("./mnElevatorButtons4.png"));
            elevButt5 = ImageIO.read(new File("./mnElevatorButtons5.png"));
            elevButt6 = ImageIO.read(new File("./mnElevatorButtons6.png"));
            elevButt7 = ImageIO.read(new File("./mnElevatorButtons7.png"));
            elevButt8 = ImageIO.read(new File("./mnElevatorButtons8.png"));
            elevButt1Hov = ImageIO.read(new File("./mnElevatorButtons1Press.png"));
            elevButt2Hov = ImageIO.read(new File("./mnElevatorButtons2Press.png"));
            elevButt3Hov = ImageIO.read(new File("./mnElevatorButtons3Press.png"));
            elevButt4Hov = ImageIO.read(new File("./mnElevatorButtons4Press.png"));
            elevButt5Hov = ImageIO.read(new File("./mnElevatorButtons5Press.png"));
            elevButt6Hov = ImageIO.read(new File("./mnElevatorButtons6Press.png"));
            elevButt7Hov = ImageIO.read(new File("./mnElevatorButtons7Press.png"));
            elevButt8Hov = ImageIO.read(new File("./mnElevatorButtons8Press.png"));
            elevButtHov = ImageIO.read(new File("./mnElevatorButtonsPress.png"));
            elevButt = ImageIO.read(new File("./mnElevatorButtons.png"));
            elevButtOpen = ImageIO.read(new File("./mnElevatorButtonsOpen.png"));
            leaf = ImageIO.read(new File("./mnLeaf.png"));
            leafHov=ImageIO.read(new File("./mnLeafPress.png"));
            leafInv=ImageIO.read(new File("./mnLeafInv.png"));
            leafInvHov=ImageIO.read(new File("./mnLeafInvPress.png"));
            leavesOpen0=ImageIO.read(new File("./mnLeavesOpen0.png"));
            leavesOpen1=ImageIO.read(new File("./mnLeavesOpen1.png"));
            leavesOpen2=ImageIO.read(new File("./mnLeavesOpen2.png"));
            leavesOpen3=ImageIO.read(new File("./mnLeavesOpen3.png"));
            leavesOpen4=ImageIO.read(new File("./mnLeavesOpen4.png"));
            leavesOpen5=ImageIO.read(new File("./mnLeavesOpen5.png"));
            leavesOpen6=ImageIO.read(new File("./mnLeavesOpen6.png"));
            trophyInv=ImageIO.read(new File("./mnTrophy.png"));
            trophyInvHov=ImageIO.read(new File("./mnTrophyPress.png"));
            trophyOpen=ImageIO.read(new File("./mnTrophyOpen.png"));
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
            Image bg = lvl3Bg1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
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
            Image bg = lvl3Bg2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 2) {
            Image bg = lvl3Bg3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 3) {
            Image bg = lvl3Bg4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            if (!leaf1Pick) {
                obj2 = leaf.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
                if (hover34)
                    obj2 = leafHov.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
                g.drawImage(obj2, 711, 168, null);
            }
        }
        if (screen == 5) {
            Image bg = lvl3Bg6.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 6) {
            Image bg = lvl3Bg7.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            Image guy1 = boothGuy.getScaledInstance(51, 30, Image.SCALE_DEFAULT);
            if (hover5)
                guy1 = boothGuyHov.getScaledInstance(51, 30, Image.SCALE_DEFAULT);
            g.drawImage(guy1, 363, 100, null);

            if (tasked && !coinPick) {
                Image obj1 = coins.getScaledInstance(45, 42, Image.SCALE_DEFAULT);
                if (hover7)
                    obj1 = coinsHov.getScaledInstance(45, 42, Image.SCALE_DEFAULT);
                g.drawImage(obj1, 500, 423, null);
            }
            Image obj2 = moneyGuy.getScaledInstance(57, 120, Image.SCALE_DEFAULT);
            if (tasked && hover9 && !moneyGuyPick)
                obj2 = moneyGuyHov.getScaledInstance(57, 120, Image.SCALE_DEFAULT);
            g.drawImage(obj2, 522, 105, null);
        }
        if (screen == 7) {
            Image bg = lvl3Bg8.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            if (!leaf2Pick) {
                obj3 = leaf.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
                if (hover35)
                    obj3 = leafHov.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
                g.drawImage(obj3, 90, 200, null);
            }
        }
        if (screen == 8) {
            Image bg = lvl3Bg9.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            Image obj1 = posters.getScaledInstance(768, 576, Image.SCALE_DEFAULT);
            if (hover16)
                obj1 = postersHov.getScaledInstance(768, 567, Image.SCALE_DEFAULT);
            g.drawImage(obj1, 0, 0, null);
        }
        if (screen == 9) {
            Image bg = lvl3Bg10.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 10) {
            Image bg = lvl3Bg12.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 11) {
            Image bg = lvl3Bg13.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);

            Image obj1 = elevButt.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if (hover23)
                obj1 = elevButtHov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(obj1, 0, 0, null);
        }
        if (screen == 12) {
            Image bg = lvl3Bg14.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }
        if (screen == 13) {
            avY = -10000;
            Image bg = lvl3Bg11.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(bg, 0, 0, null);
        }

        if (!walked)
            avatar = avt0;
        if (go3 && go2 && go1 && !bpOpen
                && (directions[0] || directions[1] || directions[2] || directions[3])) {
            if (directions[0] && isInBounds(avX, avY - 5)) {
                if (screen == 2 && avY < 1) {
                    screen = 1;
                    avY = 565 - 120;
                    avX = 515;
                }
                if (screen == 3 && avY < 1) {
                    screen = 2;
                    avY = 565 - 120;
                    avX = 515;
                }
                if (screen == 6 && avY < 47 && !ticketUse) {
                    pushGate = true;
                }
                if (screen == 6 && avY < -60 && ticketUse) {
                    screen = 7;
                    avY = 565 - 120;
                }
                if (screen == 7 && avY < 15) {
                    screen = 8;
                    avY = 280;
                    go3 = false;
                }
                if (screen == 9 && avY < 44 && avX > 297 && avX < 431) {
                    screen = 10;
                    avY = 465;
                    avX = 342;
                }
                if (screen == 10 && avY < 93 && avX > 289 && avX < 414) {
                    screen = 11;
                    avY = 315;
                    avX = 342;
                }
                if (screen == 12 && avY < 85 && avX > 297 && avX < 431) {
                    screen = 13;
                }
                avY -= 5;
                avatar = avt1;
            }
            if (directions[1] && isInBounds(avX + 5, avY)) {
                if (screen == 0 && avX > 685) {
                    screen = 1;
                    avX = 0;
                    avY = 30;
                }
                if (screen == 1 && avX > 712 && avY < 104) {
                    screen = 0;
                    avX = 0;
                    avY = 236;
                }
                if (screen == 5 && avX > 712) {
                    screen = 3;
                    avX = 0;
                    avY = 200;
                }

                avX += 5;
                avatar = avt2;
            }

            if (directions[2] && isInBounds(avX, avY + 5)) {
                if (screen == 1 && avY > 565 - 120) {
                    screen = 2;
                    avY = 0;
                    avX = 165;
                }
                if (screen == 2 && avY > 565 - 120) {
                    screen = 3;
                    avY = 0;
                    avX = 165;
                }
                if (screen == 6 && avY > 565 - 120) {
                    screen = 5;
                    avY = 37;
                    avX = 213;
                }
                if (screen == 6 && avY > 47 && pushGate) {
                    pushGate = false;
                }
                if (screen == 7 && avY > 565 - 120) {
                    screen = 6;
                    avY = -50;
                    avX = 592;
                }

                avY += 5;
                avatar = avt0;
            }
            if (directions[3] && isInBounds(avX - 5, avY)) {
                if (screen == 0 && avX < 15) {
                    screen = 1;
                    avX = 712;
                    avY = 30;
                }
                if (screen == 1 && avX < 0 && avY < 147) {
                    screen = 0;
                    avX = 695;
                    avY = 335;
                }
                if (screen == 3 && avX < 0) {
                    screen = 5;
                    avX = 712;
                    avY = 60;
                }
                if (screen == 5 && avX < 140 && avY < 60) {
                    screen = 6;
                    avX = 417;
                    avY = 565 - 120;
                }

                avX -= 5;
                avatar = avt3;
            }

        }
        g.drawImage(avatar, avX, avY, null);

        if (screen == 0) {
            Image fg = lvl3Fg1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            if (!go1) {
                Image tb = tut9.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 10, null);

                Image butt2 = goButt.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                if (hover2)
                    butt2 = goButtHov.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                g.drawImage(butt2, 180, 325, null);
            }
        }
        if (screen == 1) {
            Image fg = lvl3Fg2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 2) {
            Image fg = lvl3Fg3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 3) {
            Image fg = lvl3Fg4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 5) {
            Image fg = lvl3Fg6.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 6) {
            Image fg = lvl3Fg7.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            if (pushGate && !ticketUse) {
                Image tb = tut11.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 0, null);
            }
            if (talk1) {
                if (!(coinPick && moneyGuyWin)) {
                    Image tb2 = tut12.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                    g.drawImage(tb2, 0, 0, null);
                } else {
                    coinsUse = true;
                    Image tb2 = tut17.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                    g.drawImage(tb2, 0, 0, null);
                }
            }
            if (task2 && !go2 && !talk1) {
                Image tb = tut10.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 0, null);

                Image butt2 = goButt.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                if (hover6)
                    butt2 = goButtHov.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                g.drawImage(butt2, 195, 345, null);
            }
            if (talk2) {
                Image tb3 = tut13.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb3, 0, 0, null);
            }
        }
        if (screen == 7) {
            Image fg = lvl3Fg8.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 8) {
            Image fg = lvl3Fg9.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
            if (!go3) {
                Image tb = tut18.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 10, null);

                Image butt1 = goButt.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                if (hover15)
                    butt1 = goButtHov.getScaledInstance(87, 63, Image.SCALE_DEFAULT);
                g.drawImage(butt1, 630, 325, null);
            }
            if (posterOpen) {
                Color transpBlack = new Color(0, 0, 0, 85);
                g.setColor(transpBlack);
                g.fillRect(0, 0, 768, 576);

                Image obj1 = postersOpen.getScaledInstance(768, 576, Image.SCALE_DEFAULT);
                g.drawImage(obj1, 0, 0, null);

                Image butt1 = keyGreen.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                if (hover17)
                    butt1 = keyGreenHov.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                g.drawImage(butt1, 403, 137, null);
                Image butt2 = keyGreen.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                if (hover18)
                    butt2 = keyGreenHov.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                g.drawImage(butt2, 403, 212, null);
                Image butt3 = keyGreen.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                if (hover19)
                    butt3 = keyGreenHov.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                g.drawImage(butt3, 403, 212 + 75, null);
                Image butt4 = keyGreen.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                if (hover20)
                    butt4 = keyGreenHov.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                g.drawImage(butt4, 403, 212 + 75 * 2, null);
                Image butt5 = keyGreen.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                if (hover21)
                    butt5 = keyGreenHov.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                g.drawImage(butt5, 403, 212 + 75 * 3, null);
                Image butt6 = keyGreen.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                if (hover22)
                    butt6 = keyGreenHov.getScaledInstance(48, 54, Image.SCALE_DEFAULT);
                g.drawImage(butt6, 403, 212 + 75 * 4, null);
            }
            if (stationChoose != -1) {
                if (stationChoose != 3) {
                    stationChoose = -1;
                    tut19Open = true;

                } else {
                    screen = 9;
                    avX = 566;
                    avY = 404;

                }
            }
            if (tut19Open) {
                Image tb = tut19.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 0, null);
            }
        }
        if (screen == 9) {
            Image fg = lvl3Fg10.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 10) {
            Image fg = lvl3Fg12.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (screen == 11) {
            Image fg = lvl3Fg11.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);

            if (elevButtIsOpen) {
                Color transpBlack = new Color(0, 0, 0, 85);
                g.setColor(transpBlack);
                g.fillRect(0, 0, 768, 576);

                Image obj1 = elevButtOpen.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(obj1, 0, 0, null);
                Image buttOne = elevButt1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover24)
                    buttOne = elevButt1Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttOne, 0, 0, null);
                Image buttTwo = elevButt2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover25)
                    buttTwo = elevButt2Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttTwo, 0, 0, null);
                Image buttThr = elevButt3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover26)
                    buttThr = elevButt3Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttThr, 0, 0, null);
                Image buttFou = elevButt4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover27)
                    buttFou = elevButt4Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttFou, 0, 0, null);
                Image buttFiv = elevButt5.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover28)
                    buttFiv = elevButt5Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttFiv, 0, 0, null);
                Image buttSix = elevButt6.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover29)
                    buttSix = elevButt6Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttSix, 0, 0, null);
                Image buttSev = elevButt7.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover30)
                    buttSev = elevButt7Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttSev, 0, 0, null);
                Image buttEig = elevButt8.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if (hover31)
                    buttEig = elevButt8Hov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(buttEig, 0, 0, null);
            }
            if (floorChoose != -1) {
                if (floorChoose != 6) {
                    floorChoose = -1;
                    tut20Open = true;

                } else {
                    screen = 12;
                    avX = 353;
                    avY = 315;
                }
            }
            if (tut20Open) {
                Image tb = tut19.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb, 0, 0, null);
            }

        }
        if (screen == 12) {
            Image fg = lvl3Fg11.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(fg, 0, 0, null);
        }
        if (bpOpen) {
            Color transpBlack = new Color(0, 0, 0, 85);
            g.setColor(transpBlack);
            g.fillRect(0, 0, 768, 576);

            Image inv = bpOpeny.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(inv, 0, 0, null);

            Image inv1 = cardInv.getScaledInstance(66, 96, Image.SCALE_DEFAULT);
            if (hover3)
                inv1 = cardInvHov.getScaledInstance(66, 96, Image.SCALE_DEFAULT);
            g.drawImage(inv1, 164, 160, null);

            invLeaf=leafInv.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(hover32)
            invLeaf=leafInvHov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(invLeaf, 0, 0, null);

            if (mapPick) {
                Image inv2 = mapInv.getScaledInstance(63, 141, Image.SCALE_DEFAULT);
                if (hover4)
                    inv2 = mapInvHov.getScaledInstance(63, 141, Image.SCALE_DEFAULT);
                g.drawImage(inv2, 295, 126, null);
            }
            if (mapOpen) {
                Image mapViewy = mapView.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(mapViewy, 0, 0, null);
            }
            if (coinPick && !coinsUse) {
                Image inv3 = coinsInv.getScaledInstance(111, 84, Image.SCALE_DEFAULT);
                if (hover8)
                    inv3 = coinsInvHov.getScaledInstance(111, 84, Image.SCALE_DEFAULT);
                g.drawImage(inv3, 400, 171, null);
            }
            if (moneyGuyWin && !coinsUse) {
                Image inv4 = coinsInv.getScaledInstance(111, 84, Image.SCALE_DEFAULT);
                if (hover13)
                    inv4 = coinsInvHov.getScaledInstance(111, 84, Image.SCALE_DEFAULT);
                g.drawImage(inv4, 533, 171, null);
            }
            if (coinsUse && !ticketUse) {
                Image inv5 = subwayTicketInv.getScaledInstance(111, 84, Image.SCALE_DEFAULT);
                if (hover14)
                    inv5 = subwayTicketInvHov.getScaledInstance(111, 84, Image.SCALE_DEFAULT);
                g.drawImage(inv5, 135, 315, null);
            }
            if(Organizer.leaves>=6){
                inv3=trophyInv.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                if(hover33){
                    inv3=trophyInvHov.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                }
                g.drawImage(inv3, 0, 0, null);
            }
        }
        if (screen != 13) {
            Image butt0 = bpButt.getScaledInstance(64, 70, Image.SCALE_DEFAULT);
            if (hover1)
                butt0 = bpButtHov.getScaledInstance(64, 70, Image.SCALE_DEFAULT);
            g.drawImage(butt0, 695, 477, null);
        }

        if (cardIsOpen) {
            Color transpBlack = new Color(0, 0, 0, 85);
            g.setColor(transpBlack);
            g.fillRect(0, 0, 768, 576);

            Image obj1 = cardOpen.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(obj1, 0, 0, null);
        }
        if (leavesIsOpen) {
            Color transpBlack = new Color(0, 0, 0, 85);
            g.setColor(transpBlack);
            g.fillRect(0, 0, 768, 576);

            Image obj3=leavesOpen0.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(Organizer.leaves==0) obj3=leavesOpen0.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(Organizer.leaves==1) obj3=leavesOpen1.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(Organizer.leaves==2) obj3=leavesOpen2.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(Organizer.leaves==3) obj3=leavesOpen3.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(Organizer.leaves==4) obj3=leavesOpen4.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(Organizer.leaves==5) obj3=leavesOpen5.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            if(Organizer.leaves==6) obj3=leavesOpen6.getScaledInstance(768, 554, Image.SCALE_DEFAULT);

            g.drawImage(obj3, 0, 0, null);
        }
        if (trophyIsOpen) {
            Color transpBlack = new Color(0, 0, 0, 85);
            g.setColor(transpBlack);
            g.fillRect(0, 0, 768, 576);

            Image obj1 = trophyOpen.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
            g.drawImage(obj1, 0, 0, null);
        }

        if (screen == 6) {
            if (guessingGame) {
                Color transpBlack = new Color(0, 0, 0, 85);
                g.setColor(transpBlack);
                g.fillRect(0, 0, 768, 576);

                Image tb3 = tut14.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                g.drawImage(tb3, 0, 0, null);

                Image butt1 = key1.getScaledInstance(76, 84, Image.SCALE_DEFAULT);
                if (hover10)
                    butt1 = key1Hov.getScaledInstance(76, 84, Image.SCALE_DEFAULT);
                g.drawImage(butt1, 225, 230, null);
                Image butt2 = key2.getScaledInstance(76, 84, Image.SCALE_DEFAULT);
                if (hover11)
                    butt2 = key2Hov.getScaledInstance(76, 84, Image.SCALE_DEFAULT);
                g.drawImage(butt2, 345, 230, null);
                Image butt3 = key3.getScaledInstance(76, 84, Image.SCALE_DEFAULT);
                if (hover12)
                    butt3 = key3Hov.getScaledInstance(76, 84, Image.SCALE_DEFAULT);
                g.drawImage(butt3, 465, 230, null);

                if (guessed) {
                    if (ans == guess) {
                        Image tb4 = tut15.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                        g.drawImage(tb4, 0, 0, null);
                        moneyGuyWin = true;
                    } else {
                        Image tb4 = tut16.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
                        g.drawImage(tb4, 0, 0, null);
                        moneyGuyWin = false;
                    }
                }
            }
        }

    }

    /**
     * Invoked when the mouse is clicked.
     *
     * @param e the MouseEvent containing information about the mouse activity.
     */
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX()+", "+e.getY());
        if (screen == 3 && hover34){
            leaf1Pick=true;
            Organizer.leaves++;
        }
        if (screen == 7 && hover35){
            leaf2Pick=true;
            Organizer.leaves++;
        }
        if(bpOpen&&hover33&&!trophyIsOpen&&Organizer.leaves>=6){
            trophyIsOpen=true;
            bpOpen = false;
        } else if (trophyIsOpen){
            trophyIsOpen=false;
            bpOpen = true;
        }
        if(bpOpen&&hover32&&!leavesIsOpen){
            leavesIsOpen=true;
            bpOpen = false;
        } else if (leavesIsOpen){
            leavesIsOpen=false;
            bpOpen = true;
        }
        if (hover1 && !bpOpen && !guessingGame && !posterOpen) {
            bpOpen = true;
        } else if (hover1 && bpOpen) {
            bpOpen = false;
        }
        if (screen == 0 && hover2 && !go1) {
            go1 = true;
        }
        if (bpOpen && hover3 && !cardIsOpen) {
            cardIsOpen = true;
            bpOpen = false;
        } else if (cardIsOpen) {
            cardIsOpen = false;
            bpOpen = true;
        }
        if (mapPick && hover4 && bpOpen && !mapOpen) {
            mapOpen = true;
        } else if (mapPick && bpOpen && mapOpen) {
            mapOpen = false;
        }
        if (talk1 && !task2) {
            talk1 = false;
            if (!tasked) {
                go2 = false;
                tasked = true;
                task2 = true;
            }
        } else if (screen == 6 && hover5 && !talk1) {
            task2 = false;
            talk1 = true;
        }

        if (screen == 6 && hover6 && !go2) {
            go2 = true;
            task2 = false;
        }
        if (screen == 6 && hover7 && !coinPick) {
            coinPick = true;
        }
        if (guessed) {
            guessed = false;
            guessingGame = false;
            moneyGuyPick = false;
        }
        if (guessingGame) {
            if (hover10)
                guess = 0;
            else if (hover11)
                guess = 1;
            else if (hover12)
                guess = 2;
            guessed = true;
        }
        if (screen == 6 && hover9 && !moneyGuyPick && tasked) {
            moneyGuyPick = true;
            talk2 = true;
        } else if (talk2) {
            talk2 = false;
            ans = (int) (Math.random() * 3);
            guessingGame = true;
        }
        if (tut19Open) {
            posterOpen = false;
            tut19Open = false;
        }
        if (tut20Open) {
            elevButtIsOpen = false;
            tut20Open = false;
        }
        if (screen == 6 && coinsUse && hover14 && avY < 110) {
            ticketUse = true;
            bpOpen = false;
        }
        if (screen == 8 && !go3 && hover15) {
            go3 = true;
        }
        if (go3 && screen == 8 && !posterOpen && hover16 && !bpOpen) {
            posterOpen = true;
        } else if (screen == 8 && posterOpen) {
            if (hover17)
                stationChoose = 0;
            else if (hover18)
                stationChoose = 1;
            else if (hover19)
                stationChoose = 2;
            else if (hover20)
                stationChoose = 3;
            else if (hover21)
                stationChoose = 4;
            else if (hover22)
                stationChoose = 5;
            posterOpen = false;
        }
        if (hover23 && screen == 11 && !elevButtIsOpen) {
            elevButtIsOpen = true;
        } else if (screen == 11 && elevButtIsOpen) {
            if (hover24)
                floorChoose = 0;
            else if (hover25)
                floorChoose = 1;
            else if (hover26)
                floorChoose = 2;
            else if (hover27)
                floorChoose = 3;
            else if (hover28)
                floorChoose = 4;
            else if (hover29)
                floorChoose = 5;
            else if (hover30)
                floorChoose = 6;
            else if (hover31)
                floorChoose = 7;
            elevButtIsOpen = false;
        }

        if (screen == 13) {
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
        if (e.getKeyChar() == '-') {
            System.out.println(avX+", "+avY);
        }
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
        if (x > 180 && x < 180 + 87 && y > 325 && y < 325 + 63) {
            hover2 = true;
        } else {
            hover2 = false;
        }
        if (x > 164 && x < 164 + 66 && y > 160 && y < 160 + 96) {
            hover3 = true;
        } else {
            hover3 = false;
        }
        if (x > 295 && x < 295 + 63 && y > 126 && y < 126 + 141) {
            hover4 = true;
        } else {
            hover4 = false;
        }
        if (!task2 && avX > 273 && avX < 408 && avY < 163 && avY > 80 && x > 385 && x < 385 + 71 && y > 84
                && y < 104 + 50) {
            hover5 = true;
        } else {
            hover5 = false;
        }
        if (x > 195 && x < 195 + 87 && y > 345 && y < 345 + 63) {
            hover6 = true;
        } else {
            hover6 = false;
        }
        if (avX > 412 && avX < 549 && avY < 369 && avY > 295 && x > 500 && x < 500 + 45 && y > 423 && y < 423 + 42) {
            hover7 = true;
        } else {
            hover7 = false;
        }
        if (x > 400 && x < 400 + 111 && y > 171 && y < 171 + 84) {
            hover8 = true;
        } else {
            hover8 = false;
        }
        if (!moneyGuyWin && avX > 389 && avX < 630 && avY < 202 && avY > 96 && x > 522 && x < 522 + 54 && y > 105
                && y < 105 + 120) {
            hover9 = true;
        } else {
            hover9 = false;
        }
        if (x > 225 && x < 225 + 76 && y > 230 && y < 230 + 84 && !guessed) {
            hover10 = true;
        } else {
            hover10 = false;
        }
        if (x > 345 && x < 345 + 76 && y > 230 && y < 230 + 84 && !guessed) {
            hover11 = true;
        } else {
            hover11 = false;
        }
        if (x > 465 && x < 465 + 76 && y > 230 && y < 230 + 84 && !guessed) {
            hover12 = true;
        } else {
            hover12 = false;
        }
        if (x > 533 && x < 533 + 111 && y > 171 && y < 171 + 84) {
            hover13 = true;
        } else {
            hover13 = false;
        }
        if (x > 135 && x < 135 + 111 && y > 315 && y < 315 + 84) {
            hover14 = true;
        } else {
            hover14 = false;
        }
        if (x > 630 && x < 630 + 87 && y > 325 && y < 325 + 63) {
            hover15 = true;
        } else {
            hover15 = false;
        }
        if (x > 381 && x < 450 && y > 147 && y < 269) {
            hover16 = true;
        } else {
            hover16 = false;
        }
        if (x > 403 && x < 403 + 48 && y > 137 && y < 137 + 54) {
            hover17 = true;
        } else {
            hover17 = false;
        }
        if (x > 403 && x < 403 + 48 && y > 212 && y < 212 + 54) {
            hover18 = true;
        } else {
            hover18 = false;
        }
        if (x > 403 && x < 403 + 48 && y > 212 + 75 && y < 212 + 75 + 54) {
            hover19 = true;
        } else {
            hover19 = false;
        }
        if (x > 403 && x < 403 + 48 && y > 212 + 75 * 2 && y < 212 + 75 * 2 + 54) {
            hover20 = true;
        } else {
            hover20 = false;
        }
        if (x > 403 && x < 403 + 48 && y > 212 + 75 * 3 && y < 212 + 75 * 3 + 54) {
            hover21 = true;
        } else {
            hover21 = false;
        }
        if (x > 403 && x < 403 + 48 && y > 212 + 75 * 4 && y < 212 + 75 * 4 + 54) {
            hover22 = true;
        } else {
            hover22 = false;
        }
        if (x >= 458 && x <= 488 && y <= 155 - 30 && y >= 107 - 30) {
            hover23 = true;
        } else {
            hover23 = false;
        }
        if (x >= 310 && x <= 365 && y <= 235 - 30 && y >= 175 - 30) {
            hover24 = true;
        } else {
            hover24 = false;
        }
        if (x >= 310 && x <= 365 && y <= 315 - 30 && y >= 255 - 30) {
            hover25 = true;
        } else {
            hover25 = false;
        }
        if (x >= 310 && x <= 365 && y <= 395 - 30 && y >= 335 - 30) {
            hover26 = true;
        } else {
            hover26 = false;
        }
        if (x >= 310 && x <= 365 && y <= 475 - 30 && y >= 415 - 30) {
            hover27 = true;
        } else {
            hover27 = false;
        }
        if (x >= 400 && x <= 455 && y <= 235 - 30 && y >= 175 - 30) {
            hover28 = true;
        } else {
            hover28 = false;
        }
        if (x >= 400 && x <= 455 && y <= 315 - 30 && y >= 255 - 30) {
            hover29 = true;
        } else {
            hover29 = false;
        }
        if (x >= 400 && x <= 455 && y <= 395 - 30 && y >= 335 - 30) {
            hover30 = true;
        } else {
            hover30 = false;
        }
        if (x >= 400 && x <= 455 && y <= 475 - 30 && y >= 415 - 30) {
            hover31 = true;
        } else {
            hover31 = false;
        }
        if (x > 513 && x < 643 && y+30 > 298 && y+30 < 434){
            hover32 = true;
        } else {
            hover32 = false;
        }
        if (x > 410 && x < 505 && y + 30 > 331 && y + 30 < 430) {
            hover33 = true;
        } else {
            hover33 = false;
        }
        if (x > 705 && x < 705+45 && y > 165 && y < 165+45) {
            hover34 = true;
        } else {
            hover34 = false;
        }
        if (x > 85 && x < 85+45 && y + 30 > 215 && y + 30 < 215+45) {
            hover35 = true;
        } else {
            hover35 = false;
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
            if (x <= -23 || x >= 798 - 72 || y <= -10 || y > 586 - 120 ||
                    x > 0 - 72 && x < 85 && y < 339 - 100 && y > 273 - 120 ||
                    x > 115 - 72 && x < 135 && y < 336 - 100 && y > 262 - 120 ||
                    x > 303 - 65 && x < 377 - 7 && y < 255 - 100 && y > 115 - 120 ||
                    x > 391 - 65 && x < 464 - 7 && y < 581 - 100 && y > 492 - 120 ||
                    x > 586 - 57 && x < 637 - 15 && y < 300 - 100 && y > 225 - 120 ||
                    x > 605 - 57 && x < 653 - 15 && y < 336 - 100 && y > 268 - 120 ||
                    x > 255 && x < 435 && y < 350 && y > 195 ||
                    x > 650 && y > 100)
                isInBounds = false;
        }
        if (screen == 2) {
            if (x <= -23 || x >= 798 - 72 || y <= -10 || y > 586 - 120 ||
                    x > 0 - 57 && x < 112 - 15 && y < 71 - 100 && y > 0 - 120 ||
                    x > 383 - 57 && x < 557 - 15 && y < 164 - 100 && y > 76 - 120 ||
                    x > 653 - 57 && x < 762 - 15 && y < 219 - 100 && y > 137 - 120 ||
                    x > 391 - 65 && x < 461 - 7 && y < 373 - 100 && y > 235 - 120 ||
                    x > 304 - 65 && x < 377 - 7 && y < 549 - 100 && y > 431 - 120 ||
                    x > 700 - 65 && x < 763 - 7 && y < 274 - 100 && y > 197 - 120 ||
                    x > 710 - 65 && x < 763 - 7 && y < 437 - 100 && y > 362 - 120 ||
                    x > 302 - 65 && x < 378 - 7 && y < 550 - 100 && y > 431 - 120 ||
                    x > 127 - 72 && x < 152 && y < 438 && y > 418 - 120 || 
                    x > 70 && x < 135 && y < 60 )
                isInBounds = false;
        }
        if (screen == 3) {
            if (x <= -23 || x >= 798 - 72 || y <= -10 || y > 586 - 120 ||
                    x > 303 - 57 && x < 373 - 15 && y < 269 - 100 && y > 131 - 120 ||
                    x > 390 - 57 && x < 465 - 15 && y < 163 - 100 && y > 24 - 120 ||
                    x > 764 - 57 && x < 591 - 15 && y < 276 - 100 && y > 211 - 120 ||
                    x > 594 - 57 && x < 646 - 15 && y < 465 - 100 && y > 395 - 120 ||
                    x > 0 - 57 && x < 171 - 15 && y < 421 - 100 && y > 325 - 120 ||
                    x > 593 - 57 && x < 646 - 15 && y < 551 - 100 && y > 497 - 120 ||
                    x > 0 - 57 && x < 63 - 15 && y < 248 - 100 && y > 106 - 120 ||
                    x > 244 - 72 && x < 275 && y < 462 && y > 436 - 120 ||
                    x > 545 && x < 725 && y < 170 && y > 95)
                isInBounds = false;
        }
        if (screen == 5) {
            if (x <= -23 || x >= 798 - 72 || y <= -20 || y > 586 - 120 ||
                    x > 666 - 65 && x < 737 - 7 && y < 73 - 100 && y > 0 - 120 ||
                    x > 545 - 72 && x < 567 && y < 389 && y > 369 - 120 ||
                    x > 0 - 57 && x < 138 - 15 && y < 271 - 100 && y > 173 - 120 ||
                    x > 44 - 57 && x < 234 - 15 && y < 523 - 100 && y > 456 - 120 ||
                    x > 249 - 57 && x < 300 - 15 && y < 524 - 100 && y > 453 - 120 ||
                    x > 574 - 57 && x < 627 - 15 && y < 549 - 100 && y > 512 - 120 ||
                    x > 274 - 72 && x < 448 && y < 328 && y > 261 - 120 ||
                    x > 33 - 72 && x < 269 && y < 173 && y > 170 - 120 ||
                    x > 0 - 57 && x < 269 - 15 && y < 120 - 100 && y > 0 - 120)
                isInBounds = false;
        }
        if (screen == 6) {
            if (x <= -23 || x >= 798 - 72 || y <= -80 || y > 586 - 120 ||
                    x > 0 - 72 && x < 287 && y < 550 && y > 469 - 120 ||
                    x > 500 - 72 && x < 770 && y < 546 && y > 470 - 120 ||
                    x > 287 - 57 && x < 292 - 15 && y < 556 - 100 && y > 491 - 120 ||
                    x > 389 - 57 && x < 404 - 15 && y < 556 - 100 && y > 491 - 120 ||
                    x > 494 - 57 && x < 500 - 15 && y < 556 - 100 && y > 491 - 120 ||
                    x > 579 - 57 && x < 764 - 15 && y < 463 - 100 && y > 400 - 120 ||
                    x > 9 - 57 && x < 118 - 15 && y < 468 - 100 && y > 419 - 120 ||
                    x > 445 - 57 && x < 495 - 15 && y < 229 - 100 && y > 160 - 120 ||
                    x > 264 - 72 && x < 509 && y < 191 - 100 && y > 0 - 120 ||
                    x > 533 - 57 && x < 575 - 15 && y < 223 - 100 && y > 117 - 120 ||
                    x > 0 - 57 && x < 23 - 15 && y < 158 - 100 && y > 17 - 120 ||
                    x > 82 - 57 && x < 113 - 15 && y < 158 - 100 && y > 17 - 120 ||
                    x > 182 - 57 && x < 212 - 15 && y < 158 - 100 && y > 17 - 120 ||
                    x > 563 - 57 && x < 593 - 15 && y < 158 - 100 && y > 17 - 120 ||
                    x > 652 - 57 && x < 682 - 15 && y < 158 - 100 && y > 17 - 120 ||
                    x > 751 - 57 && x < 788 - 15 && y < 158 - 100 && y > 17 - 120 ||
                    (!ticketUse && y <= 36))
                isInBounds = false;
        }
        if (screen == 7) {
            if (x <= -23 || x >= 798 - 72 || y <= -80 || y > 586 - 120 ||
                    x > 83 - 72 && x < 163 && y < 404 && y > 319 - 120 ||
                    x > 352 - 72 && x < 434 && y < 404 && y > 319 - 120 ||
                    x > 622 - 72 && x < 704 && y < 404 && y > 319 - 120 ||
                    x > 34 - 72 && x < 176 && y < 126 && y > 110 - 140 ||
                    x > 299 - 72 && x < 460 && y < 126 && y > 110 - 140 ||
                    x > 556 - 72 && x < 794 && y < 126 && y > 110 - 140)
                isInBounds = false;
        }
        if (screen == 8) {
            if (x <= -23 || x >= 798 - 72 || y <= 157 || y > 285 ||
                    x > 40 - 72 && x < 168 && y < 383 && y > 334 - 120 ||
                    x > 562 - 72 && x < 691 && y < 383 && y > 334 - 120 ||
                    x > 321 - 72 && x < 449 && y < 383 && y > 334 - 120 ||
                    x > 172 - 67 && x < 185 - 5 && y < 343 && y > 328 - 120 ||
                    x > 304 - 67 && x < 317 - 5 && y < 343 && y > 328 - 120 ||
                    x > 21 - 67 && x < 35 - 5 && y < 343 && y > 328 - 120 ||
                    x > 451 - 67 && x < 464 - 5 && y < 343 && y > 328 - 120 ||
                    x > 546 - 67 && x < 559 - 5 && y < 343 && y > 328 - 120 ||
                    x > 695 - 67 && x < 708 - 5 && y < 343 && y > 328 - 120)
                isInBounds = false;
        }
        if (screen == 9) {
            if (x <= -23 || x >= 798 - 72 || y <= 25 || y > 410 ||
                    x > 508 - 72 && x < 752 && y < 473 - 100 && y > 334 - 120 ||
                    x > 0 - 57 && x < 173 - 15 && y < 381 - 100 && y > 280 - 120 ||
                    x > 0 - 57 && x < 178 - 15 && y < 164 - 100 && y > 101 - 120 ||
                    x > 205 - 57 && x < 279 - 15 && y < 158 - 100 && y > 100 - 120 ||
                    x > 523 - 57 && x < 575 - 15 && y < 142 - 100 && y > 99 - 120 ||
                    x > 667 - 57 && x < 723 - 15 && y < 236 - 100 && y > 162 - 120 ||
                    x > 722 - 57 && x < 763 - 15 && y < 226 - 100 && y > 150 - 120 ||
                    x > 727 - 72 && x < 767 && y < 546 - 100 && y > 422 - 120)
                isInBounds = false;
        }
        if (screen == 10) {
            if (x <= 218 || x >= 484 || y <= 80 || y > 460 ||
                    x > 229 - 57 && x < 283 - 15 && y < 566 - 100 && y > 383 - 145)
                isInBounds = false;
        }
        if (screen == 11) {
            if (x <= 218 || x >= 484 || y <= 80 || y > 325)
                isInBounds = false;
        }
        if (screen == 12) {
            if (x <= 218 || x >= 484 || y <= 70 || y > 325)
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
        go2 = true;
        go3 = true;
        mapPick = true;
        mapOpen = false;
        pushGate = false;
        task2 = false;
        talk1 = false;
        tasked = false;
        screen = 0;
        guess = 0;
        stationChoose = -1;
        coinPick = false;
        moneyGuyPick = false;
        talk2 = false;
        guessingGame = false;
        guessed = false;
        moneyGuyWin = false;
        coinsUse = false;
        ticketUse = false;
        posterOpen = false;
        cardIsOpen = false;
        tut19Open = false;
        tut20Open = false;
        elevButtIsOpen = false;
        floorChoose = -1;
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