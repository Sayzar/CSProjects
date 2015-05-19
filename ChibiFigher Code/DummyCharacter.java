/*    */ import java.util.ArrayList;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class DummyCharacter
/*    */ {
/*    */   int x;
/*    */   int y;
/*    */   int controllerID;
/*    */   private ArrayList<String> strings;
/*    */ 
/*    */   public DummyCharacter(int i)
/*    */   {
/* 16 */     this.controllerID = i;
/* 17 */     this.strings = new ArrayList();
/*    */   }
/*    */ 
/*    */   public void update(GameContainer container, int delta, ControllerEvent controllerEvent) throws SlickException
/*    */   {
/* 22 */     if ((controllerEvent.getXAxisValue() < -0.75D) && (controllerEvent.getYAxisValue() > -0.75D) && (controllerEvent.getYAxisValue() < 0.75D)) {
/* 23 */       this.x -= 1;
/*    */     }
/*    */ 
/* 26 */     if ((controllerEvent.getXAxisValue() > 0.75D) && (controllerEvent.getYAxisValue() > -0.75D) && (controllerEvent.getYAxisValue() < 0.75D)) {
/* 27 */       this.x += 1;
/*    */     }
/*    */ 
/* 30 */     if ((controllerEvent.getYAxisValue() < 0.75D) && (controllerEvent.getYAxisValue() < -0.75D) && (controllerEvent.getYAxisValue() < 0.75D)) {
/* 31 */       this.y -= 1;
/*    */     }
/*    */ 
/* 34 */     if ((controllerEvent.getYAxisValue() > 0.75D) && (controllerEvent.getXAxisValue() > -0.75D) && (controllerEvent.getXAxisValue() < 0.75D)) {
/* 35 */       this.y += 1;
/*    */     }
/*    */ 
/* 38 */     this.strings = new ArrayList();
/* 39 */     for (Button button : Button.values())
/* 40 */       if (controllerEvent.getButtonState(button))
/* 41 */         this.strings.add("ButtonID: " + button + " is Pressed");
/*    */   }
/*    */ 
/*    */   public void render(GameContainer container, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 48 */     g.draw(new Rectangle(this.x, this.y, 100.0F, 100.0F));
/* 49 */     int z = 0;
/* 50 */     for (String str : this.strings) {
/* 51 */       g.drawString(str, 100.0F, 100 * z);
/* 52 */       z++;
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     DummyCharacter
 * JD-Core Version:    0.6.2
 */