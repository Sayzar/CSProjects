/*    */ import org.newdawn.slick.AppGameContainer;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class DisplayManager extends StateBasedGame
/*    */ {
/*    */   public static final int TITLESTATE = 0;
/*    */   public static final int HOWTOSTATE = 1;
/*    */   public static final int CHARACTERSELECTSTATE = 2;
/*    */   public static final int GAMEPLAYSTATE = 3;
/*    */   public static final int PAUSESTATE = 4;
/*    */   public static final int WINNERDISPLAYSTATE = 5;
/*    */   public static final int CREDITS = 6;
/*    */   private ControllerManager controllerManager;
/*    */   private World world;
/*    */ 
/*    */   public static void main(String[] args)
/*    */     throws SlickException
/*    */   {
/* 28 */     AppGameContainer app = 
/* 29 */       new AppGameContainer(new DisplayManager("Chibi Fighter"));
/* 30 */     app.setDisplayMode(1280, 720, false);
/* 31 */     app.setTargetFrameRate(60);
/* 32 */     app.start();
/*    */   }
/*    */ 
/*    */   public DisplayManager(String str) throws SlickException {
/* 36 */     super(str);
/*    */     try
/*    */     {
/* 39 */       this.controllerManager = new ControllerManager();
/* 40 */       this.controllerManager.createControllers();
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ 
/*    */   public void initStatesList(GameContainer gc)
/*    */     throws SlickException
/*    */   {
/* 52 */     this.world = new World(this.controllerManager);
/* 53 */     addState(new TitleState(0, this.controllerManager, this.world));
/* 54 */     addState(new HowToState(1, this.controllerManager, this.world));
/* 55 */     addState(new CharacterSelectState(2, this.controllerManager, this.world));
/* 56 */     addState(new GameplayState(3, this.controllerManager, this.world));
/* 57 */     addState(new PauseState(4, this.controllerManager, this.world));
/* 58 */     addState(new WinnerDisplayState(5, this.controllerManager, this.world));
/* 59 */     addState(new CreditsState(6, this.controllerManager, this.world));
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     DisplayManager
 * JD-Core Version:    0.6.2
 */