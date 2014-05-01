/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class SpaceMap2 extends Map
/*    */ {
/*    */   String backgroundFileLocation;
/*    */ 
/*    */   public SpaceMap2(World world, String backgroundFileLocation, String musicFileLocation)
/*    */   {
/*  6 */     super(world, backgroundFileLocation, musicFileLocation);
/*    */   }
/*    */ 
/*    */   public void buildMap()
/*    */   {
/* 15 */     addBlock(0, 7, "assets/Art/Stages/Space/block2.png", BlockType.Impassable, 0, 0, 0, 8);
/* 16 */     addBlock(0, 2, "assets/Art/Stages/Space/block2.png", BlockType.Impassable, 0, 0, 0, 8);
/*    */ 
/* 18 */     addBlock(1, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/* 19 */     addBlock(2, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/* 20 */     addBlock(3, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*    */ 
/* 22 */     addBlock(3, 4, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 23 */     addBlock(2, 6, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*    */ 
/* 26 */     addBlock(4, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 27 */     addBlock(5, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 28 */     addBlock(6, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 29 */     addBlock(7, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/* 30 */     addBlock(4, 3, "assets/Art/Stages/genericCrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 31 */     addBlock(4, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 32 */     addBlock(5, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*    */ 
/* 35 */     addBlock(6, 3, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 36 */     addBlock(7, 3, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 37 */     addBlock(8, 3, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 38 */     addBlock(9, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 39 */     addBlock(10, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 40 */     addBlock(10, 3, "assets/Art/Stages/genericCrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 41 */     addBlock(8, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 42 */     addBlock(9, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 43 */     addBlock(10, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/* 44 */     addBlock(14, 2, "assets/Art/Stages/Space/block2.png", BlockType.Impassable, 0, 0, 0, 8);
/* 45 */     addBlock(11, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/* 46 */     addBlock(11, 4, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 47 */     addBlock(12, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/* 48 */     addBlock(13, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/* 49 */     addBlock(14, 7, "assets/Art/Stages/Space/block2.png", BlockType.Impassable, 0, 0, 0, 8);
/* 50 */     addBlock(12, 6, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/* 51 */     setCharacterSpawns();
/* 52 */     setCrateSpawnPoints();
/*    */   }
/*    */ 
/*    */   protected void setCharacterSpawns()
/*    */   {
/* 57 */     this.spawnList = new ArrayList();
/* 58 */     this.spawnList.add(new Map.Location(this, 0, 1));
/* 59 */     this.spawnList.add(new Map.Location(this, 14, 1));
/* 60 */     this.spawnList.add(new Map.Location(this, 0, 6));
/* 61 */     this.spawnList.add(new Map.Location(this, 14, 6));
/*    */   }
/*    */   protected void setCrateSpawnPoints() {
/* 64 */     this.crateList = new ArrayList();
/* 65 */     this.crateList.add(new Map.Location(this, 6, 13));
/* 66 */     this.crateList.add(new Map.Location(this, 7, 2));
/* 67 */     this.crateList.add(new Map.Location(this, 8, 13));
/* 68 */     this.crateList.add(new Map.Location(this, 4, 3));
/* 69 */     this.crateList.add(new Map.Location(this, 10, 3));
/*    */   }
/*    */ }
