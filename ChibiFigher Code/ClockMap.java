/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ClockMap extends Map
/*    */ {
/*    */   public ClockMap(World world, String backgroundFileLocation, String musicFileLocation)
/*    */   {
/*  6 */     super(world, backgroundFileLocation, musicFileLocation);
/*    */   }
/*    */ 
/*    */   public void buildMap()
/*    */   {
/* 26 */     addBlock(1, 4, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 28 */     addBlock(2, 4, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 30 */     addBlock(3, 1, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 31 */     addBlock(3, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/*    */ 
/* 33 */     addBlock(4, 1, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 34 */     addBlock(4, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/*    */ 
/* 36 */     addBlock(5, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 37 */     addBlock(5, 1, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 38 */     addBlock(5, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 39 */     addBlock(5, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/*    */ 
/* 41 */     addBlock(6, 3, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 42 */     addBlock(6, 4, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 43 */     addBlock(6, 5, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 45 */     addBlock(7, 3, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 46 */     addBlock(7, 4, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 47 */     addBlock(7, 5, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 49 */     addBlock(8, 3, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 50 */     addBlock(8, 4, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 51 */     addBlock(8, 5, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 53 */     addBlock(9, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 54 */     addBlock(9, 1, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 55 */     addBlock(9, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 56 */     addBlock(9, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/*    */ 
/* 58 */     addBlock(10, 1, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 59 */     addBlock(10, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/*    */ 
/* 61 */     addBlock(11, 1, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/* 62 */     addBlock(11, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 0);
/*    */ 
/* 64 */     addBlock(12, 4, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 66 */     addBlock(13, 4, "assets/Art/Stages/Clock/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 68 */     setCharacterSpawns();
/*    */   }
/*    */   public void setCharacterSpawns() {
/* 71 */     this.spawnList = new ArrayList();
/* 72 */     this.spawnList.add(new Map.Location(this, 0, 1));
/* 73 */     this.spawnList.add(new Map.Location(this, 14, 1));
/* 74 */     this.spawnList.add(new Map.Location(this, 0, 6));
/* 75 */     this.spawnList.add(new Map.Location(this, 14, 6));
/*    */   }
/*    */ 
/*    */   protected void setCrateSpawnPoints()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     ClockMap
 * JD-Core Version:    0.6.2
 */