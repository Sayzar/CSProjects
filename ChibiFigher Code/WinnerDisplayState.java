/*    */ import java.util.List;
/*    */ import org.newdawn.slick.Color;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.Input;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.Sound;
/*    */ import org.newdawn.slick.state.BasicGameState;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class WinnerDisplayState extends BasicGameState
/*    */ {
/*    */   private ControllerManager controllerManager;
/* 15 */   private int stateID = -1;
/*    */   private int winner;
/*    */   private List<Character> players;
/*    */   private Image background;
/*    */   private Character winningPlayer;
/*    */   private World world;
/*    */ 
/*    */   public WinnerDisplayState(int stateID, ControllerManager controllerManager, World world)
/*    */   {
/* 23 */     this.controllerManager = controllerManager;
/* 24 */     this.stateID = stateID;
/* 25 */     this.world = world;
/*    */   }
/*    */ 
/*    */   public void setWinner(int winnerID) {
/* 29 */     this.winner = winnerID;
/* 30 */     this.winningPlayer = ((Character)this.players.get(this.winner));
/* 31 */     this.world = this.winningPlayer.world;
/*    */   }
/*    */   public void setPlayerList(List<Character> players) {
/* 34 */     this.players = players;
/*    */   }
/*    */ 
/*    */   public void init(GameContainer arg0, StateBasedGame arg1)
/*    */     throws SlickException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 47 */     if ((this.world.getMap() instanceof IceMap))
/* 48 */       g.setColor(Color.black);
/*    */     else
/* 50 */       g.setColor(Color.white);
/* 51 */     if (getBackground() != null) {
/* 52 */       getBackground().draw();
/*    */     }
/* 54 */     if (this.winningPlayer != null) {
/* 55 */       this.world.getClass(); if (this.winningPlayer.wins >= 3) {
/* 56 */         Image victoryMessage = new Image("assets/Art/p" + (this.winner + 1) + "wins.png");
/* 57 */         victoryMessage.draw(gc.getWidth() / 2 - victoryMessage.getWidth() / 2, gc.getHeight() / 2 - 100);
/* 58 */         g.drawString("Press Enter to Continue", gc.getWidth() / 2 - 125, gc.getHeight() / 2 + 100);
/*    */       }
/*    */       else {
/* 61 */         Image victoryMessage = new Image("assets/Art/p" + (this.winner + 1) + "wins.png");
/* 62 */         victoryMessage.draw(gc.getWidth() / 2 - victoryMessage.getWidth() / 2, gc.getHeight() / 2 - 100);
/* 63 */         g.drawString("Press Enter to Start Next Round", gc.getWidth() / 2 - 125, gc.getHeight() / 2 + 100);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, StateBasedGame sbg, int delta)
/*    */     throws SlickException
/*    */   {
/* 71 */     Input input = new Input(delta);
/*    */ 
/* 73 */     if (input.isKeyDown(28)) {
/* 74 */       this.winningPlayer.world.getClass(); if (this.winningPlayer.wins >= 3) {
/* 75 */         this.winningPlayer.world.getBGM().stop();
/* 76 */         sbg.enterState(6);
/*    */       }
/*    */       else {
/* 79 */         sbg.enterState(3);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getID()
/*    */   {
/* 88 */     return this.stateID;
/*    */   }
/*    */ 
/*    */   public Image getBackground() {
/* 92 */     return this.background;
/*    */   }
/*    */ 
/*    */   public void setBackground(Image background) {
/* 96 */     this.background = background;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     WinnerDisplayState
 * JD-Core Version:    0.6.2
 */