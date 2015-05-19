/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Block extends Entity
/*    */ {
/*    */   public static final int BLOCKSIZE = 84;
/*    */   protected BlockType blockType;
/*    */   protected int maxCrateHealth;
/*    */   protected int currentCrateHealth;
/*    */ 
/*    */   public Block(int x, int y, String imageLocation, BlockType blockType, Rectangle offsets)
/*    */   {
/* 16 */     super(x * 84, y * 84, imageLocation, null);
/* 17 */     this.blockType = blockType;
/* 18 */     this.hitbox.setSize(84.0F, 84.0F);
/* 19 */     this.hitbox.setOffsets(offsets);
/* 20 */     this.maxCrateHealth = 3;
/* 21 */     this.currentCrateHealth = this.maxCrateHealth;
/*    */   }
/*    */ 
/*    */   public void destroyBlock()
/*    */     throws SlickException
/*    */   {
/* 28 */     this.blockType = BlockType.Passable;
/* 29 */     this.image = null;
/*    */   }
/*    */ 
/*    */   public BlockType getBlockType()
/*    */   {
/* 34 */     return this.blockType;
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 40 */     this.image.draw(this.xCoord, this.yCoord, 1.0F);
/* 41 */     super.render(gc, g);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, int delta)
/*    */     throws SlickException, InterruptedException
/*    */   {
/* 48 */     super.update(gc, delta);
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Block
 * JD-Core Version:    0.6.2
 */