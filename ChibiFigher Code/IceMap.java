/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class IceMap extends Map
/*    */ {
/*    */   public IceMap(World world, String backgroundFileLocation, String musicFileLocation)
/*    */   {
/* 11 */     super(world, backgroundFileLocation, musicFileLocation);
/*    */   }
/*    */ 
/*    */   public void buildMap()
/*    */   {
/* 25 */     addBlock(0, 7, "assets/Art/Stages/Volcano/icerightedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 26 */     addBlock(0, 2, "assets/Art/Stages/Volcano/icerightedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 27 */     addBlock(1, 7, "assets/Art/Stages/Volcano/icicles.png", BlockType.Lethal, 0, 21, 0, 21);
/* 28 */     addBlock(2, 7, "assets/Art/Stages/Volcano/icicles.png", BlockType.Lethal, 0, 21, 0, 21);
/* 29 */     addBlock(3, 7, "assets/Art/Stages/Volcano/icicles.png", BlockType.Lethal, 0, 21, 0, 21);
/* 30 */     addBlock(3, 4, "assets/Art/Stages/Volcano/iceplatform.png", BlockType.Passable, 0, 0, 0, 63);
/* 31 */     addBlock(2, 6, "assets/Art/Stages/Volcano/iceplatform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 33 */     addBlock(4, 7, "assets/Art/Stages/Volcano/iceleftedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 34 */     addBlock(5, 7, "assets/Art/Stages/Volcano/iceblock.png", BlockType.Impassable, 0, 0, 0, 8);
/* 35 */     addBlock(6, 7, "assets/Art/Stages/Volcano/icerightedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 36 */     addBlock(7, 7, "assets/Art/Stages/Volcano/icicles.png", BlockType.Lethal, 0, 21, 0, 21);
/* 37 */     addBlock(4, 4, "assets/Art/Stages/Volcano/iceleftedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 38 */     addBlock(5, 4, "assets/Art/Stages/Volcano/icerightedge.png", BlockType.Impassable, 0, 0, 0, 8);
/*    */ 
/* 41 */     addBlock(6, 3, "assets/Art/Stages/Volcano/iceplatform.png", BlockType.Passable, 0, 0, 0, 63);
/* 42 */     addBlock(7, 3, "assets/Art/Stages/Volcano/iceplatform.png", BlockType.Passable, 0, 0, 0, 63);
/* 43 */     addBlock(8, 3, "assets/Art/Stages/Volcano/iceplatform.png", BlockType.Passable, 0, 0, 0, 63);
/* 44 */     addBlock(9, 4, "assets/Art/Stages/Volcano/iceleftedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 45 */     addBlock(10, 4, "assets/Art/Stages/Volcano/icerightedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 46 */     addBlock(8, 7, "assets/Art/Stages/Volcano/iceleftedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 47 */     addBlock(9, 7, "assets/Art/Stages/Volcano/iceblock.png", BlockType.Impassable, 0, 0, 0, 8);
/* 48 */     addBlock(10, 7, "assets/Art/Stages/Volcano/icerightedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 49 */     addBlock(14, 2, "assets/Art/Stages/Volcano/iceleftedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 50 */     addBlock(11, 7, "assets/Art/Stages/Volcano/icicles.png", BlockType.Lethal, 0, 21, 0, 21);
/* 51 */     addBlock(11, 4, "assets/Art/Stages/Volcano/iceplatform.png", BlockType.Passable, 0, 0, 0, 63);
/* 52 */     addBlock(12, 7, "assets/Art/Stages/Volcano/icicles.png", BlockType.Lethal, 0, 21, 0, 21);
/* 53 */     addBlock(13, 7, "assets/Art/Stages/Volcano/icicles.png", BlockType.Lethal, 0, 21, 0, 21);
/* 54 */     addBlock(14, 7, "assets/Art/Stages/Volcano/iceleftedge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 55 */     addBlock(12, 6, "assets/Art/Stages/Volcano/iceplatform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 57 */     addBlock(5, 6, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 58 */     addBlock(9, 6, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 59 */     addBlock(4, 3, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 60 */     addBlock(10, 3, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/*    */ 
/* 62 */     setCharacterSpawns();
/* 63 */     setCrateSpawnPoints();
/*    */   }
/*    */ 
/*    */   protected void setCharacterSpawns()
/*    */   {
/* 70 */     this.spawnList = new ArrayList();
/* 71 */     this.spawnList.add(new Map.Location(this, 0, 1));
/* 72 */     this.spawnList.add(new Map.Location(this, 14, 1));
/* 73 */     this.spawnList.add(new Map.Location(this, 0, 6));
/* 74 */     this.spawnList.add(new Map.Location(this, 14, 6));
/*    */   }
/*    */   protected void setCrateSpawnPoints() {
/* 77 */     this.crateList = new ArrayList();
/* 78 */     this.crateList.add(new Map.Location(this, 4, 3));
/* 79 */     this.crateList.add(new Map.Location(this, 9, 6));
/* 80 */     this.crateList.add(new Map.Location(this, 5, 6));
/* 81 */     this.crateList.add(new Map.Location(this, 10, 3));
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     IceMap
 * JD-Core Version:    0.6.2
 */