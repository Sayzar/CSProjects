/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SpaceMap extends Map
/*     */ {
/*     */   public SpaceMap(World world, String backgroundFileLocation, String musicFileLocation)
/*     */   {
/*  10 */     super(world, backgroundFileLocation, musicFileLocation);
/*     */   }
/*     */ 
/*     */   public void buildMap()
/*     */   {
/*  19 */     addBlock(0, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  20 */     addBlock(0, 1, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  21 */     addBlock(0, 2, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  22 */     addBlock(0, 3, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  23 */     addBlock(0, 4, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  24 */     addBlock(0, 5, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  25 */     addBlock(0, 6, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  26 */     addBlock(0, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*     */ 
/*  28 */     addBlock(1, 3, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*  29 */     addBlock(1, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  30 */     addBlock(1, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  32 */     addBlock(2, 3, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*  33 */     addBlock(2, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  35 */     addBlock(3, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*     */ 
/*  37 */     addBlock(4, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  38 */     addBlock(4, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  39 */     addBlock(4, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*     */ 
/*  41 */     addBlock(5, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  42 */     addBlock(5, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  43 */     addBlock(5, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  45 */     addBlock(6, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  46 */     addBlock(6, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  47 */     addBlock(6, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  49 */     addBlock(7, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  50 */     addBlock(7, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  52 */     addBlock(8, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  53 */     addBlock(8, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  54 */     addBlock(8, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  56 */     addBlock(9, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  57 */     addBlock(9, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  58 */     addBlock(9, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  60 */     addBlock(10, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  61 */     addBlock(10, 4, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  62 */     addBlock(10, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*     */ 
/*  64 */     addBlock(11, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*     */ 
/*  66 */     addBlock(12, 3, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*  67 */     addBlock(12, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  69 */     addBlock(13, 3, "assets/Art/Stages/Space/platform.png", BlockType.Passable, 0, 0, 0, 63);
/*  70 */     addBlock(13, 6, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  71 */     addBlock(13, 7, "assets/Art/Stages/Space/laser-hori.png", BlockType.Lethal, 0, 15, 0, 30);
/*     */ 
/*  73 */     addBlock(14, 0, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*  74 */     addBlock(14, 1, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  75 */     addBlock(14, 2, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  76 */     addBlock(14, 3, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  77 */     addBlock(14, 4, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  78 */     addBlock(14, 5, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  79 */     addBlock(14, 6, "assets/Art/Stages/Space/laser-vert.png", BlockType.Lethal, 15, 0, 30, 0);
/*  80 */     addBlock(14, 7, "assets/Art/Stages/Space/block.png", BlockType.Impassable, 0, 0, 0, 8);
/*     */ 
/*  82 */     addBlock(4, 6, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/*  83 */     addBlock(10, 6, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/*  84 */     addBlock(5, 3, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/*  85 */     addBlock(9, 3, "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/*  86 */     setCharacterSpawns();
/*  87 */     setCrateSpawnPoints();
/*     */   }
/*     */ 
/*     */   protected void setCharacterSpawns()
/*     */   {
/*  94 */     this.spawnList = new ArrayList();
/*  95 */     this.spawnList.add(new Map.Location(this, 2, 1));
/*  96 */     this.spawnList.add(new Map.Location(this, 12, 1));
/*  97 */     this.spawnList.add(new Map.Location(this, 1, 5));
/*  98 */     this.spawnList.add(new Map.Location(this, 13, 5));
/*     */   }
/*     */   protected void setCrateSpawnPoints() {
/* 101 */     this.crateList = new ArrayList();
/* 102 */     this.crateList.add(new Map.Location(this, 4, 6));
/* 103 */     this.crateList.add(new Map.Location(this, 5, 3));
/* 104 */     this.crateList.add(new Map.Location(this, 9, 3));
/* 105 */     this.crateList.add(new Map.Location(this, 10, 6));
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     SpaceMap
 * JD-Core Version:    0.6.2
 */