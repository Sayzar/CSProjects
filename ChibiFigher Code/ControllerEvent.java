/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ControllerEvent
/*    */ {
/*    */   private List<Boolean> buttonStates;
/*    */   private Button button;
/*    */   private float xAxisValue;
/*    */   private float yAxisValue;
/*    */   private Direction direction;
/*    */ 
/*    */   public ControllerEvent(Button button, float xAxisValue, float yAxisValue)
/*    */   {
/* 12 */     this.button = button;
/* 13 */     this.xAxisValue = xAxisValue;
/* 14 */     this.yAxisValue = yAxisValue;
/*    */   }
/*    */ 
/*    */   public ControllerEvent(List<Boolean> buttonStates, float xAxisValue, float yAxisValue) {
/* 18 */     this.buttonStates = buttonStates;
/* 19 */     this.xAxisValue = xAxisValue;
/* 20 */     this.yAxisValue = yAxisValue;
/*    */   }
/*    */ 
/*    */   public ControllerEvent() {
/* 24 */     this.buttonStates = new ArrayList();
/* 25 */     for (int i = 0; i < 10; i++)
/* 26 */       this.buttonStates.add(Boolean.valueOf(false));
/*    */   }
/*    */ 
/*    */   public void setButton(Button button)
/*    */   {
/* 31 */     this.button = button;
/*    */   }
/*    */   public void setXAxis(float xAxisValue) {
/* 34 */     this.xAxisValue = xAxisValue;
/*    */   }
/*    */   public void setYAxis(float yAxisValue) {
/* 37 */     this.yAxisValue = yAxisValue;
/*    */   }
/*    */   public float getXAxisValue() {
/* 40 */     return this.xAxisValue;
/*    */   }
/*    */   public float getYAxisValue() {
/* 43 */     return this.yAxisValue;
/*    */   }
/*    */ 
/*    */   public Button getButton() {
/* 47 */     return this.button;
/*    */   }
/*    */ 
/*    */   public List<Boolean> getButtonStates() {
/* 51 */     return this.buttonStates;
/*    */   }
/*    */ 
/*    */   public void addButtonState(Button button, boolean buttonPressed) {
/* 55 */     this.buttonStates.add(button.buttonID, Boolean.valueOf(buttonPressed));
/*    */   }
/*    */ 
/*    */   public boolean getButtonState(Button button) {
/* 59 */     return ((Boolean)this.buttonStates.get(button.buttonID)).booleanValue();
/*    */   }
/*    */ 
/*    */   public void setDirection(Direction dir) {
/* 63 */     this.direction = dir;
/*    */   }
/*    */ 
/*    */   public Direction getDirection() {
/* 67 */     return this.direction;
/*    */   }
/*    */ 
/*    */   public boolean hasButtonStates() {
/* 71 */     return this.buttonStates.size() != 0;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     ControllerEvent
 * JD-Core Version:    0.6.2
 */