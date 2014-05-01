/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.lwjgl.Sys;
/*     */ import org.newdawn.slick.Animation;
/*     */ import org.newdawn.slick.Color;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.Graphics;
/*     */ import org.newdawn.slick.Image;
/*     */ import org.newdawn.slick.Input;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.state.BasicGameState;
/*     */ import org.newdawn.slick.state.StateBasedGame;
/*     */ 
/*     */ public class GameplayState extends BasicGameState
/*     */ {
/*  16 */   int stateID = -1;
/*     */ 
/*  18 */   Character player = null;
/*  19 */   Character player2 = null;
/*     */   World world;
/*  21 */   Image[] uiImages = new Image[4];
/*     */   int inLine;
/*     */   int uiIntervals;
/*     */   private ControllerManager controllerManager;
/*     */ 
/*     */   public GameplayState(int stateID, ControllerManager controllerManager, World world)
/*     */   {
/*  29 */     this.stateID = stateID;
/*  30 */     this.controllerManager = controllerManager;
/*  31 */     this.world = world;
/*     */   }
/*     */ 
/*     */   public World getGameWorld() {
/*  35 */     return this.world;
/*     */   }
/*     */ 
/*     */   public void init(GameContainer gc, StateBasedGame sbg)
/*     */     throws SlickException
/*     */   {
/*  42 */     this.uiImages[0] = new Image("assets/Art/p1state.png");
/*  43 */     this.uiImages[1] = new Image("assets/Art/p2state.png");
/*  44 */     this.uiImages[2] = new Image("assets/Art/p3state.png");
/*  45 */     this.uiImages[3] = new Image("assets/Art/p4state.png");
/*  46 */     this.inLine = (gc.getHeight() - this.uiImages[0].getHeight() + 16);
/*     */   }
/*     */ 
/*     */   public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
/*     */     throws SlickException
/*     */   {
/*  54 */     this.world.render(gc, g);
/*     */ 
/*  56 */     g.setColor(Color.white);
/*  57 */     int dist = gc.getWidth() / 4;
/*  58 */     this.uiIntervals = (dist * 2);
/*     */ 
/*  60 */     for (int i = 0; i < this.world.getNumberOfPlayers(); i++) {
/*  61 */       this.uiImages[i].draw(dist - 168, this.inLine, 0.75F);
/*  62 */       this.uiImages[i].draw(dist - 84, this.inLine, 0.75F);
/*  63 */       this.uiImages[i].draw(dist, this.inLine, 0.75F);
/*  64 */       Character c = (Character)this.world.getPlayers().get(i);
/*  65 */       if (c.name.substring(0, 5).equals("sable"))
/*  66 */         c.currentAnimation.getCurrentFrame().draw(dist - 84, this.inLine - 20, 0.75F);
/*     */       else
/*  68 */         c.currentAnimation.getCurrentFrame().draw(dist - 84, this.inLine, 0.75F);
/*  69 */       if (c.hasItem) {
/*  70 */         c.item.image.draw(dist - 45, this.inLine + 4, 0.9F);
/*     */       }
/*  72 */       g.drawString(c.displayHP(), 
/*  73 */         dist + this.uiImages[i].getWidth() * 3 / 4 - 64, this.inLine + 16);
/*  74 */       this.world.getClass(); g.drawString(c.wins + "/" + 3, 
/*  75 */         dist - this.uiImages[i].getWidth(), this.inLine + 16);
/*  76 */       dist += this.uiIntervals;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void update(GameContainer gc, StateBasedGame sbg, int delta)
/*     */     throws SlickException
/*     */   {
/*  85 */     Input input = new Input(delta);
/*  86 */     if (input.isKeyDown(25)) {
/*  87 */       sbg.enterState(4);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  92 */       this.world.update(gc, delta);
/*     */     }
/*     */     catch (InterruptedException e)
/*     */     {
/*  96 */       Sys.alert("Something went wrong!", e.getMessage());
/*     */     }
/*  98 */     if (this.world.checkIsRoundOver()) {
/*  99 */       WinnerDisplayState wds = (WinnerDisplayState)sbg.getState(5);
/* 100 */       if (!this.world.getCharacters().isEmpty()) {
/* 101 */         Character c = (Character)this.world.getCharacters().get(0);
/* 102 */         c.wins += 1;
/* 103 */         wds.setPlayerList(this.world.getPlayers());
/* 104 */         wds.setWinner(c.playerID);
/*     */       }
/*     */       try {
/* 107 */         this.world.setNextRound();
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 111 */         Sys.alert("Something went wrong!", e.getMessage());
/*     */       }
/* 113 */       wds.setBackground(this.world.getBackground().copy());
/* 114 */       sbg.enterState(5);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getID()
/*     */   {
/* 125 */     return this.stateID;
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     GameplayState
 * JD-Core Version:    0.6.2
 */