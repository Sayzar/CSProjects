/*    */ import org.lwjgl.Sys;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.Input;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.BasicGameState;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class TitleState extends BasicGameState
/*    */ {
/* 19 */   Image[] images = new Image[2];
/* 20 */   Animation anime = new Animation();
/*    */   ControllerManager controllerManager;
/* 22 */   int stateID = -1;
/* 23 */   Image background = null;
/*    */   World world;
/*    */   private String message;
/*    */ 
/*    */   public TitleState(int stateID, ControllerManager controllerManager, World world)
/*    */   {
/* 29 */     this.stateID = stateID;
/* 30 */     this.controllerManager = controllerManager;
/* 31 */     this.world = world;
/* 32 */     this.message = "";
/*    */     try {
/* 34 */       this.background = new Image("assets/Art/title_screen.png");
/*    */     } catch (SlickException e) {
/* 36 */       Sys.alert("Could not open", "Missing Image");
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getID() {
/* 41 */     return this.stateID;
/*    */   }
/*    */ 
/*    */   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
/* 48 */     if (this.background != null)
/* 49 */       this.background.draw();
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, StateBasedGame sbg, int delta)
/*    */     throws SlickException
/*    */   {
/* 59 */     Input input = new Input(delta);
/*    */ 
/* 73 */     if (input.isKeyDown(28))
/* 74 */       sbg.enterState(1);
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     TitleState
 * JD-Core Version:    0.6.2
 */