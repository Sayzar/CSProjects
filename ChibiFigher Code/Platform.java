/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ 
/*    */ public class Platform extends MapEntity
/*    */ {
/*    */   int distance;
/*    */ 
/*    */   public Platform(int x, int y, String imageLocation)
/*    */   {
/*  8 */     super(x, y, imageLocation);
/*    */   }
/*    */ 
/*    */   public void setTravelDistance(int distance) {
/* 12 */     this.distance = distance;
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, Graphics g)
/*    */   {
/* 18 */     this.image.draw(this.xCoord, this.yCoord);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, int delta)
/*    */     throws SlickException, InterruptedException
/*    */   {
/* 25 */     super.update(gc, delta);
/* 26 */     this.xCoord = ((float)(this.xCoord + Math.sin(Math.toRadians(delta)) * this.distance));
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Platform
 * JD-Core Version:    0.6.2
 */