import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * The Intro1 class is the first part of the game.
 *
 * UOttaHack 6
 *
 * @version 1.0
 * @author Avery Lee
 *         Created on 2024/03/03
 */
public class Intro1 extends JFrame implements MouseListener, MouseMotionListener {
   private boolean hover1, hover2, hover3, hover4, hover5, hover6, hover7, hover8, hover9, hover10, hover11, hover12,
         hover13, hover14,
         hover15, hover16, hover17, hover18, hover19, hover20, hover21, hover22, hover23, hover24, hover25, hover26,
         hover27, hover28, hover29, hover30, hover31, hover32, hover33;
   private int screen = 0;
   private double counter = 0.01;
   public String name = "";
   private int keyAdj = 0;
   // load images
   Image bg, title, butt1, butt2, fButt, mButt, intro1Bg, levelsTitle1, mButtHov, fButtHov, levelsTitle2, keyA, keyAHov,
         keyB, keyBHov, keyD, keyDHov, keyC, keyCHov, keyDhov, keyE, keyEHov;
   Image keyF, keyFHov, keyG, keyGHov, keyH, keyHHov, keyI, keyIHov, keyJ, keyJHov, keyK, keyKHov, keyL, keyLHov, keyM,
         keyMHov, keyN, keyNHov, keyO, keyOHov, keyP, keyPHov, keyQ, keyQHov;
   Image keyR, keyRHov, keyS, keySHov, keyT, keyTHov, keyU, keyUHov, keyV, keyVHov, keyW, keyWHov, keyX, keyXHov, keyY,
         keyYHov, keyZ, keyZHov, keySpace, keySpaceHov, keyEx, keyExHov;
   Image keyBack, keyBackHov, nameBox, enterButt, enterButtHov, levelsTitle3, nextButt, nextButtHov, butt3, butt4,
         butt5, butt6, butt7, butt8, butt9, butt10, butt11, butt12, butt13, butt14, butt15, butt16, butt17, butt18;
   Image butt19, butt20, butt21, butt22, butt23, butt24, butt25, butt26, butt27, butt28, butt29, butt30, butt31, butt32,
         box, butt33;

   /**
    * Class constructor.
    */
   public Intro1() {
      img();
   }

   /**
    * Loads the necessary images.
    */
   public void img() {
      try {
         intro1Bg = ImageIO.read(new File("./mnIntro1.png"));
         levelsTitle1 = ImageIO.read(new File("./mnIntro1Title.png"));
         mButt = ImageIO.read(new File("./mnMButt.png"));
         mButtHov = ImageIO.read(new File("./mnMButtPress.png"));
         fButt = ImageIO.read(new File("./mnFButt.png"));
         fButtHov = ImageIO.read(new File("./mnFButtPress.png"));
         levelsTitle2 = ImageIO.read(new File("./mnIntro2Title.png"));
         keyA = ImageIO.read(new File("./mnKeyA.png"));
         keyAHov = ImageIO.read(new File("./mnKeyAPress.png"));
         keyB = ImageIO.read(new File("./mnKeyB.png"));
         keyBHov = ImageIO.read(new File("./mnKeyBPress.png"));
         keyD = ImageIO.read(new File("./mnKeyD.png"));
         keyDHov = ImageIO.read(new File("./mnKeyDPress.png"));
         keyC = ImageIO.read(new File("./mnKeyC.png"));
         keyCHov = ImageIO.read(new File("./mnKeyCPress.png"));
         keyEHov = ImageIO.read(new File("./mnKeyEPress.png"));
         keyE = ImageIO.read(new File("./mnKeyE.png"));
         keyF = ImageIO.read(new File("./mnKeyF.png"));
         keyFHov = ImageIO.read(new File("./mnKeyFPress.png"));
         keyG = ImageIO.read(new File("./mnKeyG.png"));
         keyGHov = ImageIO.read(new File("./mnKeyGPress.png"));
         keyH = ImageIO.read(new File("./mnKeyH.png"));
         keyHHov = ImageIO.read(new File("./mnKeyHPress.png"));
         keyI = ImageIO.read(new File("./mnKeyI.png"));
         keyIHov = ImageIO.read(new File("./mnKeyIPress.png"));
         keyJ = ImageIO.read(new File("./mnKeyJ.png"));
         keyJHov = ImageIO.read(new File("./mnKeyJPress.png"));
         keyK = ImageIO.read(new File("./mnKeyK.png"));
         keyKHov = ImageIO.read(new File("./mnKeyKPress.png"));
         keyL = ImageIO.read(new File("./mnKeyL.png"));
         keyLHov = ImageIO.read(new File("./mnKeyLPress.png"));
         keyM = ImageIO.read(new File("./mnKeyM.png"));
         keyMHov = ImageIO.read(new File("./mnKeyMPress.png"));
         keyN = ImageIO.read(new File("./mnKeyN.png"));
         keyNHov = ImageIO.read(new File("./mnKeyNPress.png"));
         keyO = ImageIO.read(new File("./mnKeyO.png"));
         keyOHov = ImageIO.read(new File("./mnKeyOPress.png"));
         keyP = ImageIO.read(new File("./mnKeyP.png"));
         keyPHov = ImageIO.read(new File("./mnKeyPPress.png"));
         keyQ = ImageIO.read(new File("./mnKeyQ.png"));
         keyQHov = ImageIO.read(new File("./mnKeyQPress.png"));
         keyR = ImageIO.read(new File("./mnKeyR.png"));
         keyRHov = ImageIO.read(new File("./mnKeyRPress.png"));
         keyS = ImageIO.read(new File("./mnKeyS.png"));
         keySHov = ImageIO.read(new File("./mnKeySPress.png"));
         keyT = ImageIO.read(new File("./mnKeyT.png"));
         keyTHov = ImageIO.read(new File("./mnKeyTPress.png"));
         keyU = ImageIO.read(new File("./mnKeyU.png"));
         keyUHov = ImageIO.read(new File("./mnKeyUPress.png"));
         keyV = ImageIO.read(new File("./mnKeyV.png"));
         keyVHov = ImageIO.read(new File("./mnKeyVPress.png"));
         keyW = ImageIO.read(new File("./mnKeyW.png"));
         keyWHov = ImageIO.read(new File("./mnKeyWPress.png"));
         keyX = ImageIO.read(new File("./mnKeyX.png"));
         keyXHov = ImageIO.read(new File("./mnKeyXPress.png"));
         keyY = ImageIO.read(new File("./mnKeyY.png"));
         keyYHov = ImageIO.read(new File("./mnKeyYPress.png"));
         keyZ = ImageIO.read(new File("./mnKeyZ.png"));
         keyZHov = ImageIO.read(new File("./mnKeyZPress.png"));
         keySpace = ImageIO.read(new File("./mnKeySpace.png"));
         keySpaceHov = ImageIO.read(new File("./mnKeySpacePress.png"));
         keyEx = ImageIO.read(new File("./mnKey!.png"));
         keyExHov = ImageIO.read(new File("./mnKey!Press.png"));
         keyBack = ImageIO.read(new File("./mnKeyBack.png"));
         keyBackHov = ImageIO.read(new File("./mnKeyBackPress.png"));
         nameBox = ImageIO.read(new File("./mnNameBox.png"));
         enterButt = ImageIO.read(new File("./mnEnterName.png"));
         enterButtHov = ImageIO.read(new File("./mnEnterNamePress.png"));
         levelsTitle3 = ImageIO.read(new File("./mnIntro3Title.png"));
         nextButt = ImageIO.read(new File("./mnNext.png"));
         nextButtHov = ImageIO.read(new File("./mnNextPress.png"));
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
      bg = intro1Bg.getScaledInstance(768, 554, Image.SCALE_DEFAULT);
      g.drawImage(bg, 0, 0, null);

      if (screen == 0) {

         title = levelsTitle1.getScaledInstance(640, 51, Image.SCALE_DEFAULT);
         g.drawImage(title, 70, 30, null);

         butt1 = mButt.getScaledInstance(295, 390, Image.SCALE_DEFAULT);
         if (hover1)
            butt1 = mButtHov.getScaledInstance(295, 390, Image.SCALE_DEFAULT);
         g.drawImage(butt1, 70, 110, null);

         butt2 = fButt.getScaledInstance(295, 390, Image.SCALE_DEFAULT);
         if (hover2)
            butt2 = fButtHov.getScaledInstance(295, 390, Image.SCALE_DEFAULT);
         g.drawImage(butt2, 400, 110, null);
      }
      if (screen == 1) {
         title = levelsTitle2.getScaledInstance(640, 51, Image.SCALE_DEFAULT);
         g.drawImage(title, 70, 30, null);

         butt1 = mButt.getScaledInstance(295, 390, Image.SCALE_DEFAULT);
         butt2 = fButt.getScaledInstance(295, 390, Image.SCALE_DEFAULT);
         if (Organizer.gen == 0)
            g.drawImage(butt1, 70, 110, null);
         else
            g.drawImage(butt2, 400, 110, null);

         butt3 = keyAHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover3)
            butt3 = keyA.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt3, 40 + keyAdj, 200, null);

         butt4 = keyB.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover4)
            butt4 = keyBHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt4, 80 + keyAdj, 200, null);
         butt5 = keyC.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover5)
            butt5 = keyCHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt5, 120 + keyAdj, 200, null);
         butt6 = keyD.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover6)
            butt6 = keyDHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt6, 160 + keyAdj, 200, null);
         butt7 = keyE.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover7)
            butt7 = keyEHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt7, 200 + keyAdj, 200, null);
         butt8 = keyF.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover8)
            butt8 = keyFHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt8, 240 + keyAdj, 200, null);
         butt9 = keyG.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover9)
            butt9 = keyGHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt9, 280 + keyAdj, 200, null);
         butt10 = keyH.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover10)
            butt10 = keyHHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt10, 320 + keyAdj, 200, null);

         butt11 = keyI.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover11)
            butt11 = keyIHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt11, 55 + 40 * 0 + keyAdj, 235, null);
         butt12 = keyJ.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover12)
            butt12 = keyJHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt12, 55 + 40 * 1 + keyAdj, 235, null);
         butt13 = keyK.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover13)
            butt13 = keyKHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt13, 55 + 40 * 2 + keyAdj, 235, null);
         butt14 = keyL.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover14)
            butt14 = keyLHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt14, 55 + 40 * 3 + keyAdj, 235, null);
         butt15 = keyM.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover15)
            butt15 = keyMHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt15, 55 + 40 * 4 + keyAdj, 235, null);
         butt16 = keyN.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover16)
            butt16 = keyNHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt16, 55 + 40 * 5 + keyAdj, 235, null);
         butt17 = keyO.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover17)
            butt17 = keyOHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt17, 55 + 40 * 6 + keyAdj, 235, null);
         butt18 = keyP.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover18)
            butt18 = keyPHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt18, 55 + 40 * 7 + keyAdj, 235, null);

         butt19 = keyQ.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover19)
            butt19 = keyQHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt19, 40 + 40 * 0 + keyAdj, 270, null);
         butt20 = keyR.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover20)
            butt20 = keyRHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt20, 40 + 40 * 1 + keyAdj, 270, null);
         butt21 = keyS.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover21)
            butt21 = keySHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt21, 40 + 40 * 2 + keyAdj, 270, null);
         butt22 = keyT.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover22)
            butt22 = keyTHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt22, 40 + 40 * 3 + keyAdj, 270, null);
         butt23 = keyU.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover23)
            butt23 = keyUHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt23, 40 + 40 * 4 + keyAdj, 270, null);
         butt24 = keyV.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover24)
            butt24 = keyVHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt24, 40 + 40 * 5 + keyAdj, 270, null);
         butt25 = keyW.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover25)
            butt25 = keyWHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt25, 40 + 40 * 6 + keyAdj, 270, null);
         butt26 = keyX.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover26)
            butt26 = keyXHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt26, 40 + 40 * 7 + keyAdj, 270, null);

         butt27 = keyY.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover27)
            butt27 = keyYHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt27, 55 + 40 * 0 + keyAdj, 305, null);
         butt28 = keyZ.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover28)
            butt28 = keyZHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt28, 55 + 40 * 1 + keyAdj, 305, null);
         butt29 = keySpace.getScaledInstance(158, 42, Image.SCALE_DEFAULT);
         if (hover29)
            butt29 = keySpaceHov.getScaledInstance(158, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt29, 55 + 40 * 2 + keyAdj, 305, null);
         butt30 = keyEx.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover30)
            butt30 = keyExHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt30, 55 + 40 * 6 + keyAdj, 305, null);
         butt31 = keyBack.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         if (hover31)
            butt31 = keyBackHov.getScaledInstance(38, 42, Image.SCALE_DEFAULT);
         g.drawImage(butt31, 55 + 40 * 7 + keyAdj, 305, null);

         box = nameBox.getScaledInstance(320, 42, Image.SCALE_DEFAULT);
         g.drawImage(box, 45 + keyAdj, 150, null);

         Font smallMonoFont = new Font("Monospaced", Font.PLAIN, 20);
         g.setFont(smallMonoFont);
         g.drawString(name, 65 + keyAdj, 177);

         butt32 = enterButt.getScaledInstance(314, 100, Image.SCALE_DEFAULT);
         if (hover32)
            butt32 = enterButtHov.getScaledInstance(314, 100, Image.SCALE_DEFAULT);
         g.drawImage(butt32, 49 + keyAdj, 365, null);
      }

      if (screen == 2) {
         title = levelsTitle3.getScaledInstance((int) (768 * counter), (int) (576 * counter),
               Image.SCALE_DEFAULT);
         g.drawImage(bg, 0, 0, null);

         if (counter < 1) {
            title = levelsTitle3.getScaledInstance((int) (768 * counter), (int) (576 * counter),
                  Image.SCALE_DEFAULT);
            g.drawImage(title, (int) (384 - 384 * counter), (int) (288 - 288 * counter), null);
            counter += 0.04;

         }
         if (counter >= 1) {
            title = levelsTitle3.getScaledInstance((int) (768), (int) (576), Image.SCALE_DEFAULT);
            g.drawImage(title, 0, 0, null);

            butt33 = nextButt.getScaledInstance(117, 63, Image.SCALE_DEFAULT);
            if (hover33)
               butt33 = nextButtHov.getScaledInstance(117, 63, Image.SCALE_DEFAULT);
            g.drawImage(butt33, 630, 470, null);
         }

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
    * Invoked when the mouse is clicked.
    *
    * @param e the MouseEvent containing information about the mouse click
    */
   public void mouseClicked(MouseEvent e) {
      if (screen == 0) {
         if (hover1 == true) {
            Organizer.gen = 0;
            keyAdj = 360;
         } else if (hover2 == true)
            Organizer.gen = 1;
         hover1 = false;
         hover2 = false;
         screen = 1;
      }
      if (screen == 1) {
         if (hover32 == true && name.length() != 0)
            screen = 2;
         if (hover31 == true)
            name = name.substring(0, name.length() - 1);
         if (name.length() == 23)
            ;
         else if (hover3 == true)
            name += "a";
         else if (hover4 == true)
            name += "b";
         else if (hover5 == true)
            name += "c";
         else if (hover6 == true)
            name += "d";
         else if (hover7 == true)
            name += "e";
         else if (hover8 == true)
            name += "f";
         else if (hover9 == true)
            name += "g";
         else if (hover10 == true)
            name += "h";
         else if (hover11 == true)
            name += "i";
         else if (hover12 == true)
            name += "j";
         else if (hover13 == true)
            name += "k";
         else if (hover14 == true)
            name += "l";
         else if (hover15 == true)
            name += "m";
         else if (hover16 == true)
            name += "n";
         else if (hover17 == true)
            name += "o";
         else if (hover18 == true)
            name += "p";
         else if (hover19 == true)
            name += "q";
         else if (hover20 == true)
            name += "r";
         else if (hover21 == true)
            name += "s";
         else if (hover22 == true)
            name += "t";
         else if (hover23 == true)
            name += "u";
         else if (hover24 == true)
            name += "v";
         else if (hover25 == true)
            name += "w";
         else if (hover26 == true)
            name += "x";
         else if (hover27 == true)
            name += "y";
         else if (hover28 == true)
            name += "z";
         else if (hover29 == true)
            name += " ";
         else if (hover30 == true)
            name += "!";

      }
      if (screen == 2 && hover33) {
         Organizer.changeScreen(5);
      }

   }

   /**
    * Invoked when the mouse moved to check coordinates.
    *
    * @param x the x coordinate of the mouse
    * @param y the y coordinate of the mouse
    */
   public void mouseMovedCheck(int x, int y) {
      if (x > 70 && x < 70 + 295 && y > 110 && y < 110 + 390) {
         hover1 = true;

      } else {
         hover1 = false;

      }
      if (x > 400 && x < 400 + 295 && y > 110 && y < 110 + 390) {
         hover2 = true;

      } else {
         hover2 = false;

      }
      if (x > 40 + keyAdj && x < 40 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover3 = true;

      } else {
         hover3 = false;

      }
      if (x > 80 + keyAdj && x < 80 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover4 = true;

      } else {
         hover4 = false;

      }
      if (x > 120 + keyAdj && x < 120 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover5 = true;

      } else {
         hover5 = false;

      }
      if (x > 160 + keyAdj && x < 160 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover6 = true;

      } else {
         hover6 = false;

      }
      if (x > 200 + keyAdj && x < 200 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover7 = true;

      } else {
         hover7 = false;

      }
      if (x > 240 + keyAdj && x < 240 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover8 = true;

      } else {
         hover8 = false;

      }
      if (x > 280 + keyAdj && x < 280 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover9 = true;

      } else {
         hover9 = false;

      }
      if (x > 320 + keyAdj && x < 320 + keyAdj + 38 && y > 200 && y < 200 + 42) {
         hover10 = true;

      } else {
         hover10 = false;

      }

      if (x > 55 + keyAdj + 40 * 0 && x < 55 + keyAdj + 40 * 0 + 38 && y > 235 && y < 235 + 42) {
         hover11 = true;

      } else {
         hover11 = false;

      }
      if (x > 55 + keyAdj + 40 * 1 && x < 55 + keyAdj + 40 * 1 + 38 && y > 235 && y < 235 + 42) {
         hover12 = true;

      } else {
         hover12 = false;

      }
      if (x > 55 + keyAdj + 40 * 2 && x < 55 + keyAdj + 40 * 2 + 38 && y > 235 && y < 235 + 42) {
         hover13 = true;

      } else {
         hover13 = false;

      }
      if (x > 55 + keyAdj + 40 * 3 && x < 55 + keyAdj + 40 * 3 + 38 && y > 235 && y < 235 + 42) {
         hover14 = true;

      } else {
         hover14 = false;

      }
      if (x > 55 + keyAdj + 40 * 4 && x < 55 + keyAdj + 40 * 4 + 38 && y > 235 && y < 235 + 42) {
         hover15 = true;

      } else {
         hover15 = false;

      }
      if (x > 55 + keyAdj + 40 * 5 && x < 55 + keyAdj + 40 * 5 + 38 && y > 235 && y < 235 + 42) {
         hover16 = true;

      } else {
         hover16 = false;

      }
      if (x > 55 + keyAdj + 40 * 6 && x < 55 + keyAdj + 40 * 6 + 38 && y > 235 && y < 235 + 42) {
         hover17 = true;

      } else {
         hover17 = false;

      }
      if (x > 55 + keyAdj + 40 * 7 && x < 55 + keyAdj + 40 * 7 + 38 && y > 235 && y < 235 + 42) {
         hover18 = true;

      } else {
         hover18 = false;

      }

      if (x > 40 + keyAdj + 40 * 0 && x < 40 + keyAdj + 40 * 0 + 38 && y > 270 && y < 270 + 42) {
         hover19 = true;

      } else {
         hover19 = false;

      }
      if (x > 40 + keyAdj + 40 * 1 && x < 40 + keyAdj + 40 * 1 + 38 && y > 270 && y < 270 + 42) {
         hover20 = true;

      } else {
         hover20 = false;

      }
      if (x > 40 + keyAdj + 40 * 2 && x < 40 + keyAdj + 40 * 2 + 38 && y > 270 && y < 270 + 42) {
         hover21 = true;

      } else {
         hover21 = false;

      }
      if (x > 40 + keyAdj + 40 * 3 && x < 40 + keyAdj + 40 * 3 + 38 && y > 270 && y < 270 + 42) {
         hover22 = true;

      } else {
         hover22 = false;

      }
      if (x > 40 + keyAdj + 40 * 4 && x < 40 + keyAdj + 40 * 4 + 38 && y > 270 && y < 270 + 42) {
         hover23 = true;

      } else {
         hover23 = false;

      }
      if (x > 40 + keyAdj + 40 * 5 && x < 40 + keyAdj + 40 * 5 + 38 && y > 270 && y < 270 + 42) {
         hover24 = true;

      } else {
         hover24 = false;

      }
      if (x > 40 + keyAdj + 40 * 6 && x < 40 + keyAdj + 40 * 6 + 38 && y > 270 && y < 270 + 42) {
         hover25 = true;

      } else {
         hover25 = false;

      }
      if (x > 40 + keyAdj + 40 * 7 && x < 40 + keyAdj + 40 * 7 + 38 && y > 270 && y < 270 + 42) {
         hover26 = true;

      } else {
         hover26 = false;

      }

      if (x > 55 + keyAdj + 40 * 0 && x < 55 + keyAdj + 40 * 0 + 38 && y > 305 && y < 305 + 42) {
         hover27 = true;

      } else {
         hover27 = false;

      }
      if (x > 55 + keyAdj + 40 * 1 && x < 55 + keyAdj + 40 * 1 + 38 && y > 305 && y < 305 + 42) {
         hover28 = true;

      } else {
         hover28 = false;

      }
      if (x > 55 + keyAdj + 40 * 2 && x < 55 + keyAdj + 40 * 2 + 158 && y > 305 && y < 305 + 42) {
         hover29 = true;

      } else {
         hover29 = false;

      }
      if (x > 55 + keyAdj + 40 * 6 && x < 55 + keyAdj + 40 * 6 + 38 && y > 305 && y < 305 + 42) {
         hover30 = true;

      } else {
         hover30 = false;

      }
      if (x > 55 + keyAdj + 40 * 7 && x < 55 + keyAdj + 40 * 7 + 38 && y > 305 && y < 305 + 42) {
         hover31 = true;

      } else {
         hover31 = false;

      }
      if (x > 50 + keyAdj && x < 50 + keyAdj + 314 && y > 365 && y < 365 + 100 && name.length() != 0) {
         hover32 = true;

      } else {
         hover32 = false;

      }
      if (x > 630 && x < 630 + 117 && y > 470 && y < 470 + 63) {
         hover33 = true;

      } else {
         hover33 = false;

      }

   }

   // Unused methods from the KeyListener, MouseListener, and MouseMotionListener
   // interfaces
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