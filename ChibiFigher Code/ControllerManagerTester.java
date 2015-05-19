/*    */ import java.util.ArrayList;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.BasicGameState;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class ControllerManagerTester extends BasicGameState
/*    */ {
/*    */   ControllerManager cm;
/*    */   ArrayList<DummyCharacter> dummies;
/*    */ 
/*    */   public ControllerManagerTester(int state)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void init(GameContainer container, StateBasedGame game)
/*    */     throws SlickException
/*    */   {
/* 18 */     this.cm = new ControllerManager();
/* 19 */     this.dummies = new ArrayList();
/*    */ 
/* 21 */     for (int i = 0; i < this.cm.getControllerCount(); i++)
/* 22 */       this.dummies.add(new DummyCharacter(i));
/*    */   }
/*    */ 
/*    */   public void render(GameContainer container, StateBasedGame game, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 31 */     for (DummyCharacter c : this.dummies)
/* 32 */       c.render(container, g);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer container, StateBasedGame game, int delta)
/*    */     throws SlickException
/*    */   {
/* 40 */     this.cm.pollControllers();
/* 41 */     for (int i = 0; i < this.cm.getControllerCount(); i++)
/* 42 */       ((DummyCharacter)this.dummies.get(i)).update(container, delta, this.cm.getInput(i));
/*    */   }
/*    */ 
/*    */   public int getID()
/*    */   {
/* 50 */     return 0;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     ControllerManagerTester
 * JD-Core Version:    0.6.2
 */