/*    */ import org.lwjgl.LWJGLException;
/*    */ import org.lwjgl.input.Controller;
/*    */ import org.lwjgl.input.Controllers;
/*    */ 
/*    */ public class ControllerManager
/*    */ {
/*    */   private boolean[][] buttonWasPressed;
/*  9 */   private final float DEFAULT_DEAD_ZONE = 0.75F;
/*    */ 
/*    */   public void createControllers()
/*    */   {
/* 15 */     Controllers.destroy();
/*    */     try {
/* 17 */       Controllers.create();
/* 18 */       for (int i = 0; i < Controllers.getControllerCount(); i++) {
/* 19 */         Controller c = Controllers.getController(i);
/* 20 */         c.setXAxisDeadZone(0.75F);
/* 21 */         c.setYAxisDeadZone(0.75F);
/*    */       }
/* 23 */       this.buttonWasPressed = new boolean[getControllerCount()][Controllers.getController(0).getButtonCount()];
/*    */ 
/* 25 */       for (int c = 0; c < this.buttonWasPressed.length; c++)
/*    */       {
/* 27 */         for (int b = 0; b < this.buttonWasPressed[0].length; b++)
/* 28 */           this.buttonWasPressed[c][b] = 0;
/*    */       }
/*    */     }
/*    */     catch (LWJGLException localLWJGLException)
/*    */     {
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setDeadZones(float xDeadZone, float yDeadZone)
/*    */   {
/* 38 */     for (int i = 0; i < Controllers.getControllerCount(); i++) {
/* 39 */       Controller c = Controllers.getController(i);
/* 40 */       c.setXAxisDeadZone(xDeadZone);
/* 41 */       c.setYAxisDeadZone(yDeadZone);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void pollControllers() {
/* 46 */     for (int i = 0; i < Controllers.getControllerCount(); i++) {
/* 47 */       Controller c = Controllers.getController(i);
/* 48 */       c.poll();
/*    */     }
/*    */   }
/*    */ 
/*    */   public ControllerEvent getInput(int controllerIndex) {
/* 53 */     Controller c = Controllers.getController(controllerIndex);
/* 54 */     ControllerEvent ce = new ControllerEvent();
/* 55 */     if ((c.getXAxisValue() < -0.75D) && (c.getYAxisValue() > -0.75D) && (c.getYAxisValue() < 0.75D)) {
/* 56 */       ce.setDirection(Direction.LEFT);
/*    */     }
/* 58 */     else if ((c.getXAxisValue() > 0.75D) && (c.getYAxisValue() > -0.75D) && (c.getYAxisValue() < 0.75D)) {
/* 59 */       ce.setDirection(Direction.RIGHT);
/*    */     }
/* 61 */     else if ((c.getYAxisValue() < -0.75D) && (c.getXAxisValue() > -0.75D) && (c.getXAxisValue() < 0.75D)) {
/* 62 */       ce.setDirection(Direction.UP);
/*    */     }
/* 64 */     else if ((c.getYAxisValue() > 0.75D) && (c.getXAxisValue() > -0.75D) && (c.getXAxisValue() < 0.75D)) {
/* 65 */       ce.setDirection(Direction.DOWN);
/*    */     }
/* 67 */     for (Button button : Button.values()) {
/* 68 */       if (c.isButtonPressed(button.buttonID)) {
/* 69 */         if (this.buttonWasPressed[controllerIndex][button.buttonID] == 0) {
/* 70 */           ce.addButtonState(button, true);
/* 71 */           this.buttonWasPressed[controllerIndex][button.buttonID] = 1;
/*    */         }
/*    */       }
/*    */       else {
/* 75 */         this.buttonWasPressed[controllerIndex][button.buttonID] = 0;
/*    */       }
/*    */     }
/* 78 */     return ce;
/*    */   }
/*    */ 
/*    */   public Controller getController(int index) {
/* 82 */     return Controllers.getController(index);
/*    */   }
/*    */ 
/*    */   public int getControllerCount() {
/* 86 */     return Controllers.getControllerCount();
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     ControllerManager
 * JD-Core Version:    0.6.2
 */