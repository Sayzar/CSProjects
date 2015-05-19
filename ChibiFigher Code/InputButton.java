/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.Input;
/*    */ 
/*    */ public class InputButton
/*    */ {
/*    */   int xPos;
/*    */   int yPos;
/*    */   private Image img;
/*    */   GameContainer gc;
/*    */ 
/*    */   public InputButton(int x, int y, Image i, GameContainer gc)
/*    */   {
/* 12 */     this.xPos = x;
/* 13 */     this.yPos = y;
/* 14 */     this.img = i;
/* 15 */     this.gc = gc;
/*    */   }
/*    */   public boolean withinBounds(Input input) {
/* 18 */     if ((input.getMouseX() < this.xPos + this.img.getWidth()) && 
/* 19 */       (input.getMouseX() > this.xPos))
/*    */     {
/* 21 */       return true;
/*    */     }
/* 23 */     return false;
/*    */   }
/*    */   public int getWidth() {
/* 26 */     return this.img.getWidth();
/*    */   }
/*    */   public int getHeight() {
/* 29 */     return this.img.getHeight();
/*    */   }
/*    */   public Image getImage() {
/* 32 */     return this.img;
/*    */   }
/*    */   public void setXpos() {
/* 35 */     this.xPos = (this.gc.getWidth() / 2 - this.img.getWidth() / 2);
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     InputButton
 * JD-Core Version:    0.6.2
 */