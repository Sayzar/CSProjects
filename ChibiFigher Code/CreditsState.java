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
/*    */ public class CreditsState extends BasicGameState
/*    */ {
/*    */   private ControllerManager controllerManager;
/*    */   private int stateID;
/*    */   private Sound BGM;
/*    */   private Image background;
/*    */   private World world;
/*    */ 
/*    */   public CreditsState(int stateID, ControllerManager controllerManager, World world)
/*    */   {
/* 20 */     this.controllerManager = controllerManager;
/* 21 */     this.stateID = stateID;
/* 22 */     this.world = world;
/*    */   }
/*    */ 
/*    */   public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException
/*    */   {
/* 27 */     this.BGM = new Sound("assets/SFX/music/OurDestiny.wav");
/* 28 */     this.background = new Image("assets/Art/credits.png");
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 34 */     this.background.draw();
/* 35 */     g.setColor(Color.white);
/* 36 */     g.drawString("Press Space to Return to Main Menu", gc.getWidth() / 2 - 150, gc.getHeight() - 100);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, StateBasedGame sbg, int delta)
/*    */     throws SlickException
/*    */   {
/* 44 */     Input input = new Input(delta);
/* 45 */     if (!this.BGM.playing()) {
/* 46 */       this.BGM.play();
/*    */     }
/* 48 */     if (input.isKeyDown(57)) {
/* 49 */       this.BGM.stop();
/* 50 */       sbg.enterState(0);
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getID()
/*    */   {
/* 58 */     return this.stateID;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     CreditsState
 * JD-Core Version:    0.6.2
 */