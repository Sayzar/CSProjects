/*    */ import java.util.ArrayList;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SpriteSheet;
/*    */ 
/*    */ public class CharacterDisplay
/*    */ {
/*    */   Image charDisplayBox;
/*    */   Animation charToDisplay;
/* 11 */   ArrayList<Image> displayBoxes = new ArrayList();
/*    */   int xPos;
/*    */   int yPos;
/*    */ 
/*    */   public CharacterDisplay(int xPos, int yPos)
/*    */   {
/* 15 */     this.xPos = xPos;
/* 16 */     this.yPos = yPos;
/*    */     try {
/* 18 */       this.displayBoxes.add(new Image("assets/Art/borderNiko.png"));
/* 19 */       this.displayBoxes.add(new Image("assets/Art/borderSable.png"));
/* 20 */       this.displayBoxes.add(null);
/*    */     }
/*    */     catch (Exception e) {
/* 23 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setCharDisplay(int i) {
/* 28 */     this.charDisplayBox = ((Image)this.displayBoxes.get(i));
/* 29 */     setCharToDisplay(0);
/*    */   }
/*    */ 
/*    */   public void setCharToDisplay(int color) {
/*    */     try {
/* 34 */       if (this.charDisplayBox.equals(this.displayBoxes.get(0))) {
/* 35 */         if (color == 0) {
/* 36 */           Image img = new Image("assets/Art/Characters/player1/stand-spritesheet.png");
/* 37 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 38 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/* 40 */         if (color == 1) {
/* 41 */           Image img = new Image("assets/Art/Characters/player2/stand-spritesheet.png");
/* 42 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 43 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/* 45 */         if (color == 2) {
/* 46 */           Image img = new Image("assets/Art/Characters/player3/stand-spritesheet.png");
/* 47 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 48 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/* 50 */         if (color == 3) {
/* 51 */           Image img = new Image("assets/Art/Characters/player4/stand-spritesheet.png");
/* 52 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 53 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/*    */       }
/* 56 */       if (this.charDisplayBox.equals(this.displayBoxes.get(1))) {
/* 57 */         if (color == 0) {
/* 58 */           Image img = new Image("assets/Art/Characters/sableRed/stand-spritesheet.png");
/* 59 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 60 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/* 62 */         if (color == 1) {
/* 63 */           Image img = new Image("assets/Art/Characters/sableBlue/stand-spritesheet.png");
/* 64 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 65 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/* 67 */         if (color == 2) {
/* 68 */           Image img = new Image("assets/Art/Characters/sableGreen/stand-spritesheet.png");
/* 69 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 70 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/* 72 */         if (color == 3) {
/* 73 */           Image img = new Image("assets/Art/Characters/sableYellow/stand-spritesheet.png");
/* 74 */           SpriteSheet spr = new SpriteSheet(img, img.getWidth() / 3, img.getHeight());
/* 75 */           this.charToDisplay = new Animation(spr, 150);
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 81 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void draw()
/*    */   {
/* 87 */     this.charDisplayBox.draw(this.xPos, this.yPos, 0.07F);
/* 88 */     if (this.charDisplayBox.equals(this.displayBoxes.get(0))) {
/* 89 */       this.charToDisplay.draw(this.xPos + 30, this.yPos + 90);
/*    */     }
/*    */     else
/* 92 */       this.charToDisplay.draw(this.xPos + 25, this.yPos + 50);
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     CharacterDisplay
 * JD-Core Version:    0.6.2
 */