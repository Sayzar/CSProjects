/*    */ import org.newdawn.slick.Color;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.Input;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.BasicGameState;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class PauseState extends BasicGameState
/*    */ {
/* 15 */   Image pauseMenu = null;
/* 16 */   private final String ST_CONTINUE = "CONTINUE";
/* 17 */   int stateID = -1;
/*    */   private ControllerManager controllerManager;
/*    */   private World world;
/*    */ 
/*    */   public PauseState(int stateID, ControllerManager controllerManager, World world)
/*    */   {
/* 22 */     this.stateID = stateID;
/* 23 */     this.controllerManager = controllerManager;
/* 24 */     this.world = world;
/*    */   }
/*    */ 
/*    */   public void init(GameContainer gc, StateBasedGame sbg)
/*    */     throws SlickException
/*    */   {
/* 31 */     this.pauseMenu = new Image("assets/Art/pause.png");
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 39 */     this.pauseMenu.draw(0.0F, 0.0F);
/* 40 */     g.setColor(Color.white);
/* 41 */     g.drawString("Press Escape to Unpause", gc.getWidth() / 2 - 100, gc.getHeight() / 2 + 100);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, StateBasedGame sbg, int delta)
/*    */     throws SlickException
/*    */   {
/* 48 */     Input input = new Input(delta);
/*    */ 
/* 50 */     if (input.isKeyDown(1))
/* 51 */       sbg.enterState(3);
/*    */   }
/*    */ 
/*    */   public int getID()
/*    */   {
/* 60 */     return this.stateID;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     PauseState
 * JD-Core Version:    0.6.2
 */