/*    */ public abstract class MapEntity extends Entity
/*    */ {
/*    */   public static final int BLOCKSIZE = 84;
/*    */   protected BlockType blockType;
/*    */ 
/*    */   public MapEntity(int x, int y, String imageLocation)
/*    */   {
/*  8 */     super(x, y, imageLocation, null);
/*    */   }
/*    */ 
/*    */   public void setPosition(int x, int y) {
/* 12 */     this.xCoord = x;
/* 13 */     this.yCoord = y;
/*    */   }
/*    */ 
/*    */   public BlockType getBlockType() {
/* 17 */     return this.blockType;
/*    */   }
/*    */ 
/*    */   public int getNumberOfPlayers() {
/* 21 */     return 0;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     MapEntity
 * JD-Core Version:    0.6.2
 */