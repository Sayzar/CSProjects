/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Hitbox extends Rectangle
/*    */ {
/*    */   protected Rectangle offsets;
/*    */ 
/*    */   public Hitbox(float x, float y, float width, float height)
/*    */   {
/*  7 */     super(x, y, width, height);
/*  8 */     this.offsets = new Rectangle(0.0F, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   public void setOffsets(Rectangle offsets) {
/* 12 */     this.offsets = offsets;
/* 13 */     setBounds(this.x, this.y, this.width, this.height);
/*    */   }
/*    */ 
/*    */   public void setSize(float w, float h)
/*    */   {
/* 18 */     super.setSize(w - this.offsets.getWidth(), h - this.offsets.getHeight());
/*    */   }
/*    */ 
/*    */   public void setBounds(float x, float y, float w, float h)
/*    */   {
/* 23 */     this.x = (x + this.offsets.getX());
/* 24 */     this.y = (y + this.offsets.getY());
/* 25 */     this.width = (w - this.offsets.getWidth());
/* 26 */     this.height = (h - this.offsets.getHeight());
/*    */   }
/*    */ 
/*    */   public void setLocation(float x, float y)
/*    */   {
/* 31 */     super.setLocation(x + this.offsets.getX(), y + this.offsets.getY());
/*    */   }
/*    */ 
/*    */   public float getTop() {
/* 35 */     return this.y;
/*    */   }
/*    */ 
/*    */   public float getBottom() {
/* 39 */     return this.y + this.height;
/*    */   }
/*    */ 
/*    */   public float getLeft() {
/* 43 */     return this.x;
/*    */   }
/*    */ 
/*    */   public float getRight() {
/* 47 */     return this.x + this.width;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Hitbox
 * JD-Core Version:    0.6.2
 */