/*    */ import org.lwjgl.Sys;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.Color;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.Input;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.BasicGameState;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class HowToState extends BasicGameState
/*    */ {
/* 17 */   Image[] images = new Image[2];
/* 18 */   Animation anime = new Animation();
/*    */   ControllerManager controllerManager;
/* 20 */   int stateID = -1;
/* 21 */   Image background = null;
/*    */   World world;
/*    */   private String message;
/*    */ 
/*    */   public HowToState(int stateID, ControllerManager controllerManager, World world)
/*    */   {
/* 27 */     this.stateID = stateID;
/* 28 */     this.controllerManager = controllerManager;
/* 29 */     this.world = world;
/*    */     try {
/* 31 */       this.background = new Image("assets/Art/howto.png");
/*    */     }
/*    */     catch (SlickException e) {
/* 34 */       Sys.alert("Something went wrong!", e.getMessage());
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getID() {
/* 39 */     return this.stateID;
/*    */   }
/*    */ 
/*    */   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
/* 46 */     if (this.background != null)
/* 47 */       this.background.draw();
/* 48 */     g.setColor(Color.white);
/* 49 */     g.drawString("Press Space to Start", 50.0F, 50.0F);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
/*    */   {
/* 54 */     Input input = new Input(delta);
/* 55 */     if (input.isKeyDown(57))
/*    */     {
/* 57 */       sbg.enterState(2);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     HowToState
 * JD-Core Version:    0.6.2
 */