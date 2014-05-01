/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.Timer;
/*     */ import org.newdawn.slick.Image;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.Sound;
/*     */ import org.newdawn.slick.geom.Rectangle;
/*     */ 
/*     */ public abstract class Map
/*     */ {
/*     */   World world;
/*     */   protected ArrayList<Map.Location> spawnList;
/*     */   protected ArrayList<Map.Location> crateList;
/*     */   private String backgroundFileLocation;
/*     */   private String musicFileLocation;
/*     */   private Sound BGM;
/*     */   private Image background;
/*     */   protected ArrayList<Block> blockList;
/*     */   protected Timer timer;
/*  29 */   protected int numberOfCrates = 4;
/*     */ 
/*     */   public Map(World world, String backgroundFileLocation, String musicFileLocation)
/*     */   {
/*  33 */     this.blockList = new ArrayList();
/*  34 */     this.world = world;
/*  35 */     this.backgroundFileLocation = backgroundFileLocation;
/*  36 */     this.musicFileLocation = musicFileLocation;
/*     */     try {
/*  38 */       setBackground(new Image(backgroundFileLocation));
/*  39 */       this.BGM = new Sound(musicFileLocation);
/*     */     }
/*     */     catch (SlickException e) {
/*  42 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Map()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void addBlock(int xCoordinate, int yCoordinate, String fileLocation, BlockType blockType, int xOffSet, int yOffSet, int sizeXOff, int sizeYOff)
/*     */   {
/*  54 */     Rectangle offsets = new Rectangle(xOffSet, 
/*  55 */       yOffSet, 
/*  56 */       sizeXOff, 
/*  57 */       sizeYOff);
/*  58 */     this.world.addBlock(new Block(xCoordinate, 
/*  59 */       yCoordinate, 
/*  60 */       fileLocation, 
/*  61 */       blockType, 
/*  62 */       offsets));
/*     */   }
/*     */ 
/*     */   public void addBlock(int xCoordinate, int yCoordinate, String fileLocation, BlockType blockType, Rectangle offsets)
/*     */   {
/*  67 */     this.world.addBlock(new Block(xCoordinate, 
/*  68 */       yCoordinate, 
/*  69 */       fileLocation, 
/*  70 */       blockType, 
/*  71 */       offsets));
/*     */   }
/*     */ 
/*     */   public void crateRespawn(Map.Location loc, String fileLocation, BlockType blockType, int xOffset, int yOffset, int sizeXOff, int sizeYOff)
/*     */   {
/*  76 */     Rectangle offsets = new Rectangle(xOffset, 
/*  77 */       yOffset, 
/*  78 */       sizeXOff, 
/*  79 */       sizeYOff);
/*  80 */     this.world.addBlock(new Block(loc.x, loc.y, 
/*  81 */       fileLocation, 
/*  82 */       blockType, 
/*  83 */       offsets));
/*     */   }
/*     */ 
/*     */   public abstract void buildMap();
/*     */ 
/*     */   public String getBackgroundFileLocation()
/*     */   {
/*  90 */     return this.backgroundFileLocation;
/*     */   }
/*     */ 
/*     */   public String getMusicFileLocation()
/*     */   {
/*  95 */     return this.musicFileLocation;
/*     */   }
/*     */   protected abstract void setCharacterSpawns();
/*     */ 
/*     */   protected abstract void setCrateSpawnPoints();
/*     */ 
/* 101 */   public ArrayList<Map.Location> getCharacterSpawns() { return this.spawnList; }
/*     */ 
/*     */   public ArrayList<Map.Location> getCrateSpawns() {
/* 104 */     return this.crateList;
/*     */   }
/*     */   public ArrayList<Block> getBlockList() {
/* 107 */     return this.blockList;
/*     */   }
/*     */ 
/*     */   public Image getBackground() {
/* 111 */     return this.background;
/*     */   }
/*     */ 
/*     */   public void setBackground(Image background) {
/* 115 */     this.background = background;
/*     */   }
/*     */ 
/*     */   public Sound getBGM() {
/* 119 */     return this.BGM;
/*     */   }
/*     */ 
/*     */   public void startTime() {
/* 123 */     this.timer = new Timer(15000, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 125 */         for (int i = 0; i < Map.this.crateList.size(); i++)
/* 126 */           Map.this.crateRespawn((Map.Location)Map.this.crateList.get(i), "assets/Art/Stages/genericcrate.png", BlockType.Crate, 0, 21, 0, 21);
/* 127 */         Map.this.timer.stop();
/*     */       }
/*     */     });
/* 129 */     this.timer.start();
/*     */ 
/* 131 */     this.numberOfCrates = 4;
/*     */   }
/*     */   public void stopTime() {
/* 134 */     this.timer.stop();
/*     */   }
/*     */ 
/*     */   public class Location
/*     */   {
/*     */     int x;
/*     */     int y;
/*     */ 
/*     */     protected Location(int x, int y)
/*     */     {
/*  16 */       this.x = x;
/*  17 */       this.y = y;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Map
 * JD-Core Version:    0.6.2
 */