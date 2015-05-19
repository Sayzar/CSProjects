/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class LavaMap extends Map
/*    */ {
/*    */   public LavaMap(World world, String backgroundFileLocation, String musicFileLocation)
/*    */   {
/*  9 */     super(world, backgroundFileLocation, musicFileLocation);
/*    */   }
/*    */ 
/*    */   public void buildMap()
/*    */   {
/* 23 */     addBlock(0, 7, "assets/Art/Stages/Volcano/submergededge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 24 */     addBlock(0, 2, "assets/Art/Stages/Volcano/edge-right.png", BlockType.Impassable, 0, 0, 0, 8);
/* 25 */     addBlock(1, 7, "assets/Art/Stages/Volcano/lava.png", BlockType.Lethal, 0, 21, 0, 21);
/* 26 */     addBlock(2, 7, "assets/Art/Stages/Volcano/lava.png", BlockType.Lethal, 0, 21, 0, 21);
/* 27 */     addBlock(3, 7, "assets/Art/Stages/Volcano/lava.png", BlockType.Lethal, 0, 21, 0, 21);
/* 28 */     addBlock(3, 4, "assets/Art/Stages/Volcano/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 29 */     addBlock(2, 6, "assets/Art/Stages/Volcano/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 31 */     addBlock(4, 7, "assets/Art/Stages/Volcano/submerged-left.png", BlockType.Impassable, 0, 0, 0, 8);
/* 32 */     addBlock(5, 7, "assets/Art/Stages/Volcano/submergedblock.png", BlockType.Impassable, 0, 0, 0, 8);
/* 33 */     addBlock(6, 7, "assets/Art/Stages/Volcano/submergededge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 34 */     addBlock(7, 7, "assets/Art/Stages/Volcano/lava.png", BlockType.Lethal, 0, 21, 0, 21);
/* 35 */     addBlock(4, 4, "assets/Art/Stages/Volcano/edge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 36 */     addBlock(5, 4, "assets/Art/Stages/Volcano/edge-right.png", BlockType.Impassable, 0, 0, 0, 8);
/*    */ 
/* 38 */     addBlock(4, 0, "assets/Art/Stages/Volcano/stalactites-leftedge.png", BlockType.Lethal, 0, 0, 0, 21);
/* 39 */     addBlock(5, 0, "assets/Art/Stages/Volcano/stalactites.png", BlockType.Lethal, 0, 0, 0, 21);
/* 40 */     addBlock(6, 0, "assets/Art/Stages/Volcano/stalactites.png", BlockType.Lethal, 0, 0, 0, 21);
/* 41 */     addBlock(7, 0, "assets/Art/Stages/Volcano/stalactites.png", BlockType.Lethal, 0, 0, 0, 21);
/* 42 */     addBlock(8, 0, "assets/Art/Stages/Volcano/stalactites.png", BlockType.Lethal, 0, 0, 0, 21);
/* 43 */     addBlock(9, 0, "assets/Art/Stages/Volcano/stalactites.png", BlockType.Lethal, 0, 0, 0, 21);
/* 44 */     addBlock(10, 0, "assets/Art/Stages/Volcano/stalactites-rightedge.png", BlockType.Lethal, 0, 0, 0, 21);
/*    */ 
/* 46 */     addBlock(6, 3, "assets/Art/Stages/Volcano/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 47 */     addBlock(7, 3, "assets/Art/Stages/Volcano/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 48 */     addBlock(8, 3, "assets/Art/Stages/Volcano/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 49 */     addBlock(9, 4, "assets/Art/Stages/Volcano/edge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 50 */     addBlock(10, 4, "assets/Art/Stages/Volcano/edge-right.png", BlockType.Impassable, 0, 0, 0, 8);
/* 51 */     addBlock(8, 7, "assets/Art/Stages/Volcano/submerged-left.png", BlockType.Impassable, 0, 0, 0, 8);
/* 52 */     addBlock(9, 7, "assets/Art/Stages/Volcano/submergedblock.png", BlockType.Impassable, 0, 0, 0, 8);
/* 53 */     addBlock(10, 7, "assets/Art/Stages/Volcano/submergededge.png", BlockType.Impassable, 0, 0, 0, 8);
/* 54 */     addBlock(11, 7, "assets/Art/Stages/Volcano/lava.png", BlockType.Lethal, 0, 21, 0, 21);
/* 55 */     addBlock(12, 7, "assets/Art/Stages/Volcano/lava.png", BlockType.Lethal, 0, 21, 0, 21);
/* 56 */     addBlock(13, 7, "assets/Art/Stages/Volcano/lava.png", BlockType.Lethal, 0, 21, 0, 21);
/* 57 */     addBlock(14, 7, "assets/Art/Stages/Volcano/submerged-left.png", BlockType.Impassable, 0, 0, 0, 8);
/* 58 */     addBlock(12, 6, "assets/Art/Stages/Volcano/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 59 */     addBlock(11, 4, "assets/Art/Stages/Volcano/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 60 */     addBlock(14, 2, "assets/Art/Stages/Volcano/edge.png", BlockType.Impassable, 0, 0, 0, 8);
/*    */ 
/* 62 */     addBlock(4, 3, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 63 */     addBlock(10, 3, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 64 */     addBlock(9, 6, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 65 */     addBlock(5, 6, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/*    */ 
/* 68 */     setCharacterSpawns();
/* 69 */     setCrateSpawnPoints();
/*    */   }
/*    */ 
/*    */   protected void setCharacterSpawns()
/*    */   {
/* 78 */     this.spawnList = new ArrayList();
/* 79 */     this.spawnList.add(new Map.Location(this, 0, 1));
/* 80 */     this.spawnList.add(new Map.Location(this, 14, 1));
/* 81 */     this.spawnList.add(new Map.Location(this, 0, 6));
/* 82 */     this.spawnList.add(new Map.Location(this, 14, 6));
/*    */   }
/*    */   protected void setCrateSpawnPoints() {
/* 85 */     this.crateList = new ArrayList();
/* 86 */     this.crateList.add(new Map.Location(this, 4, 3));
/* 87 */     this.crateList.add(new Map.Location(this, 9, 6));
/* 88 */     this.crateList.add(new Map.Location(this, 5, 6));
/* 89 */     this.crateList.add(new Map.Location(this, 10, 3));
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     LavaMap
 * JD-Core Version:    0.6.2
 */