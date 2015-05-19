/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import org.newdawn.slick.Color;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.Graphics;
/*     */ import org.newdawn.slick.Image;
/*     */ import org.newdawn.slick.Input;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.Sound;
/*     */ import org.newdawn.slick.state.BasicGameState;
/*     */ import org.newdawn.slick.state.StateBasedGame;
/*     */ 
/*     */ public class CharacterSelectState extends BasicGameState
/*     */ {
/*     */   private ControllerManager controllerManager;
/*  16 */   private int stateID = -1;
/*  17 */   private Sound BGM = null;
/*     */   private Image background;
/*  19 */   protected ArrayList<CharacterSelectState.Thumbnail> chars = new ArrayList();
/*  20 */   private World world = null;
/*  21 */   ArrayList<CharacterSelectState.Pointer> pointers = new ArrayList();
/*  22 */   ArrayList<CharacterDisplay> displays = new ArrayList();
/*     */ 
/*     */   public CharacterSelectState(int stateID, ControllerManager controllerManager, World world)
/*     */   {
/*  26 */     this.stateID = stateID;
/*  27 */     this.controllerManager = controllerManager;
/*  28 */     this.world = world;
/*     */   }
/*     */ 
/*     */   public void init(GameContainer gc, StateBasedGame sbg)
/*     */     throws SlickException
/*     */   {
/*  35 */     this.background = new Image("assets/Art/example.png");
/*  36 */     this.chars.add(new CharacterSelectState.Thumbnail("assets/Art/p1state.png", gc.getWidth() / 3, gc.getHeight() / 2));
/*  37 */     this.chars.add(new CharacterSelectState.Thumbnail("assets/Art/p2state.png", 2 * gc.getWidth() / 3, gc.getHeight() / 2));
/*  38 */     this.pointers.add(new CharacterSelectState.Pointer(0, 0, (CharacterSelectState.Thumbnail)this.chars.get(0), new Image("assets/Art/one.jpg")));
/*  39 */     this.pointers.add(new CharacterSelectState.Pointer(0, 1, (CharacterSelectState.Thumbnail)this.chars.get(1), new Image("assets/Art/two.png")));
/*  40 */     if (this.world.getNumberOfPlayers() == 2) {
/*  41 */       this.displays.add(new CharacterDisplay(0, 500));
/*  42 */       this.displays.add(new CharacterDisplay(1150, 500));
/*     */     }
/*  44 */     if (this.world.getNumberOfPlayers() == 3) {
/*  45 */       this.displays.add(new CharacterDisplay(0, 500));
/*  46 */       this.displays.add(new CharacterDisplay(500, 500));
/*  47 */       this.displays.add(new CharacterDisplay(1000, 600));
/*     */     }
/*  49 */     if (this.world.getNumberOfPlayers() == 4) {
/*  50 */       this.displays.add(new CharacterDisplay(0, 0));
/*  51 */       this.displays.add(new CharacterDisplay(1000, 0));
/*  52 */       this.displays.add(new CharacterDisplay(0, 500));
/*  53 */       this.displays.add(new CharacterDisplay(1000, 500));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
/*     */     throws SlickException
/*     */   {
/* 153 */     this.background.draw(0.0F, 0.0F);
/* 154 */     g.setColor(Color.black);
/* 155 */     g.drawString("So here's the story. You don't like the other person. You want to beat the crap", 200.0F, 10.0F);
/* 156 */     g.drawString("out of them. Why? I don't know, they stole your sweet roll or something.", 200.0F, 30.0F);
/* 157 */     g.drawString("For player one, use A and D to choose between the many character options we have.", 200.0F, 50.0F);
/* 158 */     g.drawString("When you've found your soul mate, press Q to confirm.", 200.0F, 70.0F);
/* 159 */     g.drawString("Now, you get to choose from our many color options, which pop out to the side, by using W and S.", 200.0F, 90.0F);
/* 160 */     g.drawString("That's ingenious, you say? Brilliant, even? You're damn right it is.", 200.0F, 110.0F);
/* 161 */     g.drawString("Once you've found something that matches your shoes, press Q again to confirm your choice.", 200.0F, 130.0F);
/* 162 */     g.drawString("But wait! What if you decide you want your character to be just the right (and only) shade of red?", 200.0F, 150.0F);
/* 163 */     g.drawString("Then press Q. E-Z P-Z. Reselect your color, and if you want a different character, press E.", 200.0F, 170.0F);
/* 164 */     g.drawString("For player two, I and K correspond to W and S, J and L correspond to A and D, Q and E correspond to U and O.", 200.0F, 190.0F);
/* 165 */     g.drawString("Now if you'll excuse me, I need to go wonder where I lost control of my life. Have fun.", 200.0F, 210.0F);
/* 166 */     for (CharacterSelectState.Thumbnail nail : this.chars) {
/* 167 */       nail.draw(nail.xPos, nail.yPos, nail.scale);
/* 168 */       if (nail.isSelected) {
/* 169 */         for (CharacterSelectState.Thumbnail.ColorNail colorNail : nail.colors) {
/* 170 */           if (colorNail.isSelected) {
/* 171 */             colorNail.isFocused = false;
/* 172 */             colorNail.draw(colorNail.xPos, colorNail.yPos, colorNail.scale + 0.25F);
/*     */           }
/* 174 */           if (colorNail.isFocused) {
/* 175 */             colorNail.draw(colorNail.xPos, colorNail.yPos, colorNail.scale + 0.15F);
/*     */           }
/* 178 */           else if (!colorNail.isSelected) {
/* 179 */             colorNail.draw(colorNail.xPos, colorNail.yPos, colorNail.scale);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 184 */       if (nail.setPointers.size() > 1) {
/* 185 */         int vertBufferSpace = 10;
/* 186 */         for (int i = 0; i < nail.setPointers.size(); i++) {
/* 187 */           ((CharacterSelectState.Pointer)nail.setPointers.get(i)).currentPos.draw(nail.xPos + nail.getWidth(), nail.yPos + vertBufferSpace * i, 0.5F);
/*     */         }
/*     */       }
/* 190 */       else if (nail.setPointers.size() == 1) {
/* 191 */         ((CharacterSelectState.Pointer)nail.setPointers.get(0)).currentPos.draw(nail.xPos + nail.getWidth(), nail.yPos, 0.5F);
/*     */       }
/*     */     }
/* 194 */     for (CharacterDisplay cDisplay : this.displays)
/* 195 */       if (cDisplay.charDisplayBox != null)
/* 196 */         cDisplay.draw();
/*     */   }
/*     */ 
/*     */   public void update(GameContainer gc, StateBasedGame sbg, int delta)
/*     */     throws SlickException
/*     */   {
/* 292 */     Input input = new Input(delta);
/*     */ 
/* 294 */     if (((input.isKeyDown(30)) || (input.isKeyDown(32))) && (!((CharacterSelectState.Pointer)this.pointers.get(0)).isSelected)) {
/* 295 */       ((CharacterSelectState.Pointer)this.pointers.get(0)).setCharPos();
/*     */     }
/* 297 */     if (((input.isKeyDown(36)) || (input.isKeyDown(38))) && (!((CharacterSelectState.Pointer)this.pointers.get(1)).isSelected)) {
/* 298 */       ((CharacterSelectState.Pointer)this.pointers.get(1)).setCharPos();
/*     */     }
/* 300 */     if ((input.isKeyDown(17)) && (((CharacterSelectState.Pointer)this.pointers.get(0)).isSelected) && (!((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen)) {
/* 301 */       if (!((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen)
/* 302 */         ((CharacterSelectState.Pointer)this.pointers.get(0)).setColorPos(true);
/* 303 */       ((CharacterDisplay)this.displays.get(0)).setCharToDisplay(((CharacterSelectState.Pointer)this.pointers.get(0)).colorPos);
/*     */     }
/* 305 */     if ((input.isKeyDown(31)) && (((CharacterSelectState.Pointer)this.pointers.get(0)).isSelected) && (!((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen)) {
/* 306 */       if (!((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen)
/* 307 */         ((CharacterSelectState.Pointer)this.pointers.get(0)).setColorPos(false);
/* 308 */       ((CharacterDisplay)this.displays.get(0)).setCharToDisplay(((CharacterSelectState.Pointer)this.pointers.get(0)).colorPos);
/*     */     }
/* 310 */     if ((input.isKeyDown(23)) && (((CharacterSelectState.Pointer)this.pointers.get(1)).isSelected) && (!((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen)) {
/* 311 */       if (!((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen)
/* 312 */         ((CharacterSelectState.Pointer)this.pointers.get(1)).setColorPos(true);
/* 313 */       ((CharacterDisplay)this.displays.get(1)).setCharToDisplay(((CharacterSelectState.Pointer)this.pointers.get(1)).colorPos);
/*     */     }
/* 315 */     if ((input.isKeyDown(37)) && (((CharacterSelectState.Pointer)this.pointers.get(1)).isSelected) && (!((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen)) {
/* 316 */       if (!((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen)
/* 317 */         ((CharacterSelectState.Pointer)this.pointers.get(1)).setColorPos(false);
/* 318 */       ((CharacterDisplay)this.displays.get(1)).setCharToDisplay(((CharacterSelectState.Pointer)this.pointers.get(1)).colorPos);
/*     */     }
/* 320 */     if (input.isKeyDown(16)) {
/* 321 */       if (((CharacterSelectState.Pointer)this.pointers.get(0)).isSelected) {
/* 322 */         if (((CharacterSelectState.Pointer)this.pointers.get(0)).colorSelected == null) {
/* 323 */           ((CharacterSelectState.Pointer)this.pointers.get(0)).colorSelected = ((CharacterSelectState.Pointer)this.pointers.get(0)).colorFocused;
/* 324 */           ((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen = true;
/* 325 */           selectionToChar((CharacterSelectState.Pointer)this.pointers.get(0));
/*     */         }
/*     */         else {
/* 328 */           ((CharacterSelectState.Pointer)this.pointers.get(0)).colorSelected = null;
/* 329 */           ((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen = false;
/* 330 */           ((CharacterSelectState.Pointer)this.pointers.get(0)).dir = null;
/*     */         }
/*     */       }
/*     */       else {
/* 334 */         ((CharacterSelectState.Pointer)this.pointers.get(0)).setSelect();
/* 335 */         ((CharacterDisplay)this.displays.get(0)).setCharDisplay(((CharacterSelectState.Pointer)this.pointers.get(0)).charPos);
/*     */       }
/*     */     }
/* 338 */     if (input.isKeyDown(22)) {
/* 339 */       if (((CharacterSelectState.Pointer)this.pointers.get(1)).isSelected) {
/* 340 */         if (((CharacterSelectState.Pointer)this.pointers.get(1)).colorSelected == null) {
/* 341 */           ((CharacterSelectState.Pointer)this.pointers.get(1)).colorSelected = ((CharacterSelectState.Pointer)this.pointers.get(1)).colorFocused;
/* 342 */           ((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen = true;
/* 343 */           selectionToChar((CharacterSelectState.Pointer)this.pointers.get(1));
/*     */         }
/*     */         else {
/* 346 */           ((CharacterSelectState.Pointer)this.pointers.get(1)).colorSelected = null;
/* 347 */           ((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen = false;
/* 348 */           ((CharacterSelectState.Pointer)this.pointers.get(1)).dir = null;
/*     */         }
/*     */       }
/*     */       else {
/* 352 */         ((CharacterSelectState.Pointer)this.pointers.get(1)).setSelect();
/* 353 */         ((CharacterDisplay)this.displays.get(1)).setCharDisplay(((CharacterSelectState.Pointer)this.pointers.get(1)).charPos);
/*     */       }
/*     */     }
/* 356 */     if ((input.isKeyDown(18)) && (((CharacterSelectState.Pointer)this.pointers.get(0)).isSelected)) {
/* 357 */       ((CharacterSelectState.Pointer)this.pointers.get(0)).setSelect();
/* 358 */       if (((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen) {
/* 359 */         ((CharacterSelectState.Pointer)this.pointers.get(0)).colorSelected.isSelected = false;
/* 360 */         ((CharacterSelectState.Pointer)this.pointers.get(0)).colorSelected.currentPointers.remove(this.pointers.get(0));
/* 361 */         ((CharacterSelectState.Pointer)this.pointers.get(0)).colorChosen = false;
/*     */       }
/* 363 */       ((CharacterDisplay)this.displays.get(0)).setCharDisplay(2);
/* 364 */       ((CharacterDisplay)this.displays.get(0)).charToDisplay = null;
/*     */     }
/* 366 */     if ((input.isKeyDown(24)) && (((CharacterSelectState.Pointer)this.pointers.get(1)).isSelected)) {
/* 367 */       ((CharacterSelectState.Pointer)this.pointers.get(1)).setSelect();
/* 368 */       if (((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen) {
/* 369 */         ((CharacterSelectState.Pointer)this.pointers.get(1)).colorSelected.isSelected = false;
/* 370 */         ((CharacterSelectState.Pointer)this.pointers.get(1)).colorSelected.currentPointers.remove(this.pointers.get(1));
/* 371 */         ((CharacterSelectState.Pointer)this.pointers.get(1)).colorChosen = false;
/*     */       }
/* 373 */       ((CharacterDisplay)this.displays.get(1)).setCharDisplay(2);
/* 374 */       ((CharacterDisplay)this.displays.get(1)).charToDisplay = null;
/*     */     }
/* 376 */     boolean allReady = true;
/* 377 */     for (CharacterSelectState.Pointer p : this.pointers) {
/* 378 */       if (!p.checkComplete()) {
/* 379 */         allReady = false;
/* 380 */         break;
/*     */       }
/*     */     }
/* 383 */     if (allReady) {
/* 384 */       ArrayList dirs = new ArrayList();
/* 385 */       for (CharacterSelectState.Pointer p : this.pointers)
/* 386 */         dirs.add(p.dir);
/*     */       try
/*     */       {
/* 389 */         this.world.init();
/*     */       }
/*     */       catch (IOException e) {
/* 392 */         e.printStackTrace();
/*     */       }
/* 394 */       this.world.setDirectories(dirs);
/* 395 */       this.world.loadChars();
/* 396 */       this.world.getBGM().loop();
/* 397 */       sbg.enterState(3);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 402 */       Thread.sleep(100L);
/*     */     }
/*     */     catch (InterruptedException e)
/*     */     {
/* 407 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void selectionToChar(CharacterSelectState.Pointer p) {
/* 412 */     if (p.imageSelected.equals(this.chars.get(0))) {
/* 413 */       if (p.colorSelected.equals(p.imageSelected.colors.get(0))) {
/* 414 */         p.dir = "player1";
/*     */       }
/* 416 */       if (p.colorSelected.equals(p.imageSelected.colors.get(1))) {
/* 417 */         p.dir = "player2";
/*     */       }
/* 419 */       if (p.colorSelected.equals(p.imageSelected.colors.get(2))) {
/* 420 */         p.dir = "player3";
/*     */       }
/* 422 */       if (p.colorSelected.equals(p.imageSelected.colors.get(3)))
/* 423 */         p.dir = "player4";
/*     */     }
/*     */     else
/*     */     {
/* 427 */       if (p.colorSelected.equals(p.imageSelected.colors.get(0))) {
/* 428 */         p.dir = "sableRed";
/*     */       }
/* 430 */       if (p.colorSelected.equals(p.imageSelected.colors.get(1))) {
/* 431 */         p.dir = "sableBlue";
/*     */       }
/* 433 */       if (p.colorSelected.equals(p.imageSelected.colors.get(2))) {
/* 434 */         p.dir = "sableGreen";
/*     */       }
/* 436 */       if (p.colorSelected.equals(p.imageSelected.colors.get(3)))
/* 437 */         p.dir = "sableYellow";
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getID()
/*     */   {
/* 446 */     return this.stateID;
/*     */   }
/*     */ 
/*     */   private class Pointer
/*     */   {
/*     */     int charPos;
/*     */     int colorPos;
/*     */     boolean isSelected;
/*     */     boolean colorChosen;
/*     */     String dir;
/*     */     Image currentPos;
/*     */     CharacterSelectState.Thumbnail imageSelected;
/*     */     CharacterSelectState.Thumbnail imageFocused;
/*     */     CharacterSelectState.Thumbnail.ColorNail colorSelected;
/*     */     CharacterSelectState.Thumbnail.ColorNail colorFocused;
/*     */ 
/*     */     public Pointer(int charPos, int colorPos, CharacterSelectState.Thumbnail image, Image currentPos)
/*     */     {
/* 212 */       this.charPos = 0;
/* 213 */       this.colorPos = colorPos;
/* 214 */       this.imageSelected = image;
/* 215 */       this.imageFocused = image;
/* 216 */       this.currentPos = currentPos;
/*     */     }
/*     */     public void setCharPos() {
/* 219 */       this.imageFocused.removePointer(this);
/* 220 */       this.charPos -= 1;
/* 221 */       if (this.charPos < 0) {
/* 222 */         this.charPos = 1;
/*     */       }
/* 224 */       this.imageFocused = ((CharacterSelectState.Thumbnail)CharacterSelectState.this.chars.get(this.charPos));
/* 225 */       this.imageFocused.addPointer(this);
/*     */     }
/*     */     public void setColorPos(boolean isUp) {
/* 228 */       if (this.colorFocused.currentPointers.size() == 1) {
/* 229 */         this.colorFocused.isFocused = false;
/*     */       }
/* 231 */       this.colorFocused.removePointer(this);
/* 232 */       if (isUp) {
/* 233 */         if (this.colorPos - 1 < 0) {
/* 234 */           this.colorPos = 3;
/*     */         }
/*     */         else {
/* 237 */           this.colorPos -= 1;
/*     */         }
/*     */ 
/*     */       }
/* 241 */       else if (this.colorPos + 1 > 3) {
/* 242 */         this.colorPos = 0;
/*     */       }
/*     */       else {
/* 245 */         this.colorPos += 1;
/*     */       }
/*     */ 
/* 248 */       this.colorFocused = ((CharacterSelectState.Thumbnail.ColorNail)this.imageSelected.colors.get(this.colorPos));
/* 249 */       this.colorFocused.addPointer(this);
/* 250 */       if (this.colorFocused.currentPointers.size() > 1) {
/* 251 */         setColorPos(isUp);
/*     */       }
/* 253 */       this.colorFocused.isFocused = true;
/*     */     }
/*     */ 
/*     */     public void setSelect() {
/* 257 */       if (this.isSelected) {
/* 258 */         this.isSelected = false;
/* 259 */         this.imageSelected.setSelect(this);
/*     */       }
/*     */       else {
/* 262 */         this.isSelected = true;
/* 263 */         this.imageSelected = ((CharacterSelectState.Thumbnail)CharacterSelectState.this.chars.get(this.charPos));
/* 264 */         this.colorFocused = ((CharacterSelectState.Thumbnail.ColorNail)this.imageSelected.colors.get(0));
/* 265 */         this.imageSelected.setSelect(this);
/*     */       }
/*     */     }
/*     */ 
/* 269 */     public void setSelectColor() { if (this.colorChosen) {
/* 270 */         this.colorChosen = false;
/* 271 */         this.colorSelected.setSelect(this);
/*     */       }
/*     */       else {
/* 274 */         this.colorChosen = true;
/* 275 */         setColorPos(false);
/* 276 */         this.colorSelected = ((CharacterSelectState.Thumbnail.ColorNail)this.imageSelected.colors.get(this.colorPos));
/* 277 */         this.colorSelected.setSelect(this);
/*     */       } }
/*     */ 
/*     */     public boolean checkComplete() {
/* 281 */       if (this.dir == null) {
/* 282 */         return false;
/*     */       }
/* 284 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class Thumbnail extends Image
/*     */   {
/*     */     int xPos;
/*     */     int yPos;
/*     */     float scale;
/*     */     boolean isSelected;
/*  62 */     ArrayList<Image> currentScheme = new ArrayList();
/*  63 */     ArrayList<CharacterSelectState.Thumbnail.ColorNail> colors = new ArrayList();
/*  64 */     ArrayList<CharacterSelectState.Pointer> setPointers = new ArrayList();
/*  65 */     ArrayList<CharacterSelectState.Pointer> selectPointers = new ArrayList();
/*     */ 
/*     */     public Thumbnail(String loc, int xPos, int yPos) throws SlickException {
/*  68 */       super();
/*  69 */       this.xPos = xPos;
/*  70 */       this.yPos = yPos;
/*  71 */       this.scale = 1.0F;
/*  72 */       this.colors.add(new CharacterSelectState.Thumbnail.ColorNail(xPos - 70, yPos, "assets/Art/p1state.png"));
/*  73 */       this.colors.add(new CharacterSelectState.Thumbnail.ColorNail(xPos - 70, yPos + 35, "assets/Art/p2state.png"));
/*  74 */       this.colors.add(new CharacterSelectState.Thumbnail.ColorNail(xPos - 70, yPos + 70, "assets/Art/p3state.png"));
/*  75 */       this.colors.add(new CharacterSelectState.Thumbnail.ColorNail(xPos - 70, yPos + 105, "assets/Art/p4state.png"));
/*  76 */       this.currentScheme.add(new Image("assets/Art/p1state.png"));
/*  77 */       this.currentScheme.add(new Image("assets/Art/p2state.png"));
/*  78 */       this.currentScheme.add(new Image("assets/Art/p3state.png"));
/*  79 */       this.currentScheme.add(new Image("assets/Art/p4state.png"));
/*     */     }
/*     */     public void setScale() {
/*  82 */       if (this.scale == 1.0F) {
/*  83 */         this.scale = 1.5F;
/*     */       }
/*     */       else
/*  86 */         this.scale = 1.0F;
/*     */     }
/*     */ 
/*     */     public void addPointer(CharacterSelectState.Pointer p)
/*     */     {
/*  91 */       this.setPointers.add(p);
/*     */     }
/*     */ 
/*     */     public void removePointer(CharacterSelectState.Pointer p) {
/*  95 */       this.setPointers.remove(p);
/*     */     }
/*     */ 
/*     */     public void setSelect(CharacterSelectState.Pointer p) {
/*  99 */       if ((this.isSelected) && (this.selectPointers.contains(p))) {
/* 100 */         this.selectPointers.remove(p);
/* 101 */         if (this.selectPointers.size() == 0) {
/* 102 */           setScale();
/* 103 */           this.isSelected = false;
/*     */         }
/*     */       }
/*     */       else {
/* 107 */         this.isSelected = true;
/* 108 */         if (this.selectPointers.size() == 0) {
/* 109 */           setScale();
/*     */         }
/* 111 */         this.selectPointers.add(p);
/*     */       }
/*     */     }
/*     */ 
/*     */     public class ColorNail extends Image
/*     */     {
/*     */       int xPos;
/*     */       int yPos;
/*     */       float scale;
/*     */       boolean isFocused;
/*     */       boolean isSelected;
/* 120 */       ArrayList<CharacterSelectState.Pointer> currentPointers = new ArrayList();
/* 121 */       CharacterSelectState.Pointer selectedPointer = null;
/*     */ 
/*     */       public ColorNail(int xPos, int yPos, String loc) throws SlickException {
/* 124 */         super();
/* 125 */         this.xPos = xPos;
/* 126 */         this.yPos = yPos;
/* 127 */         this.scale = 0.5F;
/*     */       }
/*     */       public void setSelect(CharacterSelectState.Pointer p) {
/* 130 */         if ((this.isSelected) && (this.selectedPointer.equals(p))) {
/* 131 */           this.isSelected = false;
/* 132 */           this.selectedPointer = null;
/*     */         }
/*     */         else {
/* 135 */           this.isSelected = true;
/* 136 */           this.selectedPointer = p;
/*     */         }
/*     */       }
/*     */ 
/* 140 */       public void addPointer(CharacterSelectState.Pointer p) { this.currentPointers.add(p); }
/*     */ 
/*     */       public void removePointer(CharacterSelectState.Pointer p) {
/* 143 */         this.currentPointers.remove(p);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     CharacterSelectState
 * JD-Core Version:    0.6.2
 */