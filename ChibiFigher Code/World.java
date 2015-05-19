/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.swing.Timer;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.Graphics;
/*     */ import org.newdawn.slick.Image;
/*     */ import org.newdawn.slick.Input;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.Sound;
/*     */ 
/*     */ public class World
/*     */ {
/*  14 */   public final int winsNeeded = 3;
/*     */   private List<Block> blocks;
/*     */   private List<Platform> platforms;
/*     */   private List<Projectile> projectiles;
/*     */   private List<Character> characters;
/*     */   private List<Item> items;
/*     */   private List<Item> itemsOnMap;
/*     */   private List<Map> maps;
/*     */   private Map map;
/*     */   private ArrayList<String> charLocs;
/*  27 */   private IceMap iceMap = new IceMap(this, "assets/Art/Backgrounds/bg_ice.png", "assets/SFX/music/Ice.wav");
/*  28 */   private LavaMap lavaMap = new LavaMap(this, "assets/Art/Backgrounds/bg_lava.png", "assets/SFX/music/Volcano.wav");
/*  29 */   private SpaceMap spaceMap = new SpaceMap(this, "assets/Art/Backgrounds/bg_space.png", "assets/SFX/music/Space.wav");
/*     */   private ControllerManager controllerManager;
/*     */   private Image background;
/*     */   public ArrayList<Sound> punchHit;
/*     */   public ArrayList<Sound> punchMiss;
/*     */   private int numberOfPlayers;
/*     */   private List<Character> players;
/*     */   private Sound BGM;
/*     */   private List<Entity> entitiesToRemove;
/*     */ 
/*     */   public World(ControllerManager cm)
/*     */   {
/*  42 */     this.controllerManager = cm;
/*  43 */     this.numberOfPlayers = 2;
/*     */   }
/*     */ 
/*     */   public void init()
/*     */     throws IOException, SlickException
/*     */   {
/*  49 */     this.blocks = new ArrayList();
/*  50 */     this.platforms = new ArrayList();
/*  51 */     this.projectiles = new ArrayList();
/*  52 */     this.characters = new ArrayList();
/*  53 */     this.entitiesToRemove = new ArrayList();
/*  54 */     this.items = new ArrayList();
/*  55 */     this.itemsOnMap = new ArrayList();
/*  56 */     this.maps = new ArrayList();
/*  57 */     this.charLocs = new ArrayList();
/*     */ 
/*  59 */     this.iceMap.buildMap();
/*  60 */     this.map = this.iceMap;
/*  61 */     loadSounds();
/*  62 */     setBackgroundImage();
/*     */   }
/*     */ 
/*     */   public void setDirectories(ArrayList<String> locs)
/*     */   {
/*  68 */     this.charLocs = locs;
/*     */   }
/*     */ 
/*     */   public void loadChars() throws SlickException {
/*  72 */     List characterSpawns = this.map.getCharacterSpawns();
/*  73 */     this.players = new ArrayList();
/*  74 */     for (int i = 0; i < getNumberOfPlayers(); i++) {
/*  75 */       int j = i + 1;
/*  76 */       Map.Location loc = (Map.Location)characterSpawns.get(i);
/*     */ 
/*  78 */       Character c = new Character(loc.x, loc.y, (String)this.charLocs.get(i), this);
/*  79 */       c.setPlayerID(i);
/*  80 */       c.loadAnimations();
/*  81 */       c.renderEnt(c.image, c.image.getWidth() / 3, c.image.getHeight(), 300);
/*  82 */       getPlayers().add(c);
/*  83 */       this.characters.add(c);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void loadSounds()
/*     */     throws SlickException
/*     */   {
/*  90 */     setBGM(this.map.getBGM());
/*     */ 
/*  92 */     Sound punchHit1 = new Sound("assets/SFX/punch1Final.wav");
/*  93 */     Sound punchHit2 = new Sound("assets/SFX/punch2Final.wav");
/*  94 */     Sound punchHit3 = new Sound("assets/SFX/punch3Final.wav");
/*  95 */     Sound punchMiss1 = new Sound("assets/SFX/punchMiss1Final.wav");
/*  96 */     Sound punchMiss2 = new Sound("assets/SFX/punchMiss2Final.wav");
/*  97 */     Sound punchMiss3 = new Sound("assets/SFX/punchMiss3Final.wav");
/*  98 */     Sound bonesCrack = new Sound("assets/SFX/bonesCrackFinal.wav");
/*  99 */     Sound breakCrate = new Sound("assets/SFX/breakCrateFinal.wav");
/* 100 */     Sound clockBell = new Sound("assets/SFX/clockBellFinal.wav");
/* 101 */     Sound earthquake = new Sound("assets/SFX/earthquakesFinal.wav");
/* 102 */     Sound clockPulse = new Sound("assets/SFX/clockPulseFinal.wav");
/* 103 */     Sound rockHammer = new Sound("assets/SFX/rockHammerFinal.wav");
/* 104 */     Sound run = new Sound("assets/SFX/runFinal.wav");
/* 105 */     Sound shock = new Sound("assets/SFX/shockFinal.wav");
/* 106 */     Sound spikes = new Sound("assets/SFX/spikesFallFinal.wav");
/* 107 */     Sound ice = new Sound("assets/SFX/iceFinal.wav");
/* 108 */     Sound movingSteel = new Sound("assets/SFX/movingSteelFinal.wav");
/*     */ 
/* 110 */     this.punchHit = new ArrayList();
/* 111 */     this.punchMiss = new ArrayList();
/*     */ 
/* 113 */     this.punchHit.add(punchHit1);
/* 114 */     this.punchHit.add(punchHit2);
/* 115 */     this.punchHit.add(punchHit3);
/*     */ 
/* 117 */     this.punchMiss.add(punchMiss1);
/* 118 */     this.punchMiss.add(punchMiss2);
/* 119 */     this.punchMiss.add(punchMiss3);
/*     */   }
/*     */ 
/*     */   public void playRandomSound(ArrayList<Sound> soundList)
/*     */   {
/* 127 */     ((Sound)soundList.get((int)(soundList.size() * Math.random()))).play(); } 
/*     */   public void update(GameContainer gc, int delta) throws SlickException, InterruptedException {
	
}
/* 165 */   public void render(GameContainer gc, Graphics g) throws SlickException { getBackground().draw();
/*     */ 
/* 167 */     for (Item i : this.itemsOnMap)
/*     */     {
/* 169 */       i.render(gc, g);
/*     */     }
/*     */ 
/* 172 */     for (Block b : this.blocks) {
/* 173 */       b.render(gc, g);
/*     */     }
/* 175 */     for (Projectile p : this.projectiles) {
/* 176 */       p.render(gc, g);
/*     */     }
/*     */ 
/* 179 */     for (Character c : this.characters)
/* 180 */       if (c.getHP() > 0)
/* 181 */         c.render(gc, g);
/*     */   }
/*     */ 
/*     */   public void checkForCollisions(GameContainer gc)
/*     */   {
/* 187 */     for (Character c : this.characters) {
/* 188 */       c.checkCollisions(gc);
/*     */     }
/* 190 */     for (Projectile p : this.projectiles) {
/* 191 */       p.checkCollisions();
/*     */     }
/* 193 */     removeEntities();
/*     */   }
/*     */ 
/*     */   public void addBlock(Block block)
/*     */   {
/* 245 */     this.blocks.add(block);
/*     */   }
/*     */ 
/*     */   public void remove(Entity entity) {
/* 249 */     this.entitiesToRemove.add(entity);
/*     */   }
/*     */ 
/*     */   private void removeEntities() {
/* 253 */     for (Entity e : this.entitiesToRemove) {
/* 254 */       if ((e instanceof Projectile)) {
/* 255 */         this.projectiles.remove(e);
/*     */       }
/* 257 */       else if ((e instanceof Character)) {
/* 258 */         this.characters.remove(e);
/*     */       }
/* 260 */       else if ((e instanceof Block)) {
/* 261 */         Block b = (Block)e;
/* 262 */         if (b.getBlockType() == BlockType.Crate)
/* 263 */           this.map.numberOfCrates -= 1;
/* 264 */         this.blocks.remove(e);
/*     */       }
/* 266 */       else if ((e instanceof Item)) {
/* 267 */         this.itemsOnMap.remove(e);
/*     */       }
/*     */     }
/* 270 */     this.entitiesToRemove.clear();
/*     */   }
/*     */ 
/*     */   public void setNumberOfPlayers(int numberOfPlayers) {
/* 274 */     this.numberOfPlayers = numberOfPlayers;
/*     */   }
/*     */ 
/*     */   public void setBGM(Sound BGM) {
/* 278 */     this.BGM = BGM;
/*     */   }
/*     */ 
/*     */   public Item chooseRandomItem() {
/* 282 */     int itemID = (int)(5.0D * Math.random());
/* 283 */     switch (itemID) { case 0:
/* 284 */       itemID = 0; return new Earth(0.0F, 0.0F, "assets/Art/Transformations/icons/hammer.png", this);
/*     */     case 1:
/* 285 */       itemID = 1; return new Fire(0.0F, 0.0F, "assets/Art/Transformations/icons/bow.png", this);
/*     */     case 2:
/* 286 */       itemID = 2; return new Ice(0.0F, 0.0F, "assets/Art/Transformations/icons/shield.png", this);
/*     */     case 3:
/* 287 */       itemID = 3; return new Lightning(0.0F, 0.0F, "assets/Art/Transformations/icons/dagger.png", this);
/*     */     case 4:
/* 288 */       itemID = 4; return new Wind(0.0F, 0.0F, "assets/Art/Transformations/icons/fan.png", this); }
/* 289 */     return null;
/*     */   }
/*     */ 
/*     */   public void spawnItem(Block b)
/*     */   {
/* 294 */     Item item = chooseRandomItem();
/* 295 */     item.setLocation(b.getX() + (b.getImage().getWidth() - item.getImage().getWidth()) / 2, 
/* 296 */       b.getY() + (b.getImage().getHeight() - item.getImage().getHeight()) / 2);
/* 297 */     item.setYSpawnLocation(item.getY());
/* 298 */     this.itemsOnMap.add(item);
/* 299 */     remove(b);
/*     */   }
/*     */ 
/*     */   public void setNextRound() throws IOException, SlickException
/*     */   {
/*     */     try
/*     */     {
/* 306 */       if (this.map.timer.isRunning())
/* 307 */         this.map.stopTime();
/*     */     }
/*     */     catch (NullPointerException localNullPointerException) {
/*     */     }
/* 311 */     this.blocks = new ArrayList();
/* 312 */     this.platforms = new ArrayList();
/* 313 */     this.projectiles = new ArrayList();
/* 314 */     this.itemsOnMap = new ArrayList();
/* 315 */     this.map = getNextMap();
/* 316 */     this.map.crateList = new ArrayList();
/* 317 */     this.map.buildMap();
/*     */ 
/* 322 */     for (int i = 0; i < getNumberOfPlayers(); i++) {
/* 323 */       Character c = (Character)getPlayers().get(i);
/* 324 */       c.reset();
/* 325 */       Map.Location loc = (Map.Location)this.map.getCharacterSpawns().get(i);
/* 326 */       c.setLocation(loc.x * 84 + 42, loc.y * 84 + 42);
/* 327 */       c.setHitboxLocation(c.xCoord - c.hitbox.getWidth() / 2.0F, c.yCoord - c.hitbox.getHeight());
/*     */     }
/* 329 */     this.characters = new ArrayList(getPlayers());
/* 330 */     setBackgroundImage();
/* 331 */     getBGM().stop();
/* 332 */     setBGM(this.map.getBGM());
/* 333 */     getBGM().loop();
/*     */   }
/*     */ 
/*     */   public boolean checkIsRoundOver() {
/* 337 */     return this.characters.size() <= 1;
/*     */   }
/*     */ 
/*     */   public List<Block> getBlocks()
/*     */   {
/* 344 */     return this.blocks;
/*     */   }
/*     */ 
/*     */   public List<Projectile> getProjectiles()
/*     */   {
/* 349 */     return this.projectiles;
/*     */   }
/*     */ 
/*     */   public List<Character> getCharacters()
/*     */   {
/* 354 */     return this.characters;
/*     */   }
/*     */ 
/*     */   public List<Item> getItemsOnMap() {
/* 358 */     return this.itemsOnMap;
/*     */   }
/*     */ 
/*     */   public Map getMap()
/*     */   {
/* 363 */     return this.map;
/*     */   }
/*     */ 
/*     */   private void setBackgroundImage() {
/* 367 */     this.background = this.map.getBackground();
/*     */   }
/*     */ 
/*     */   private Map getNextMap() {
/* 371 */     if ((this.map instanceof IceMap)) {
/* 372 */       return this.lavaMap;
/*     */     }
/* 374 */     if ((this.map instanceof LavaMap)) {
/* 375 */       return this.spaceMap;
/*     */     }
/*     */ 
/* 378 */     return this.iceMap;
/*     */   }
/*     */ 
/*     */   public Image getBackground()
/*     */   {
/* 384 */     return this.background;
/*     */   }
/*     */ 
/*     */   public Sound getBGM() {
/* 388 */     return this.BGM;
/*     */   }
/*     */ 
/*     */   public List<Character> getPlayers() {
/* 392 */     return this.players;
/*     */   }
/*     */ 
/*     */   public int getNumberOfPlayers() {
/* 396 */     return this.numberOfPlayers;
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     World
 * JD-Core Version:    0.6.2
 */