/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.SlickException;
/*    */ 
/*    */ public class PunchProjectile extends Projectile
/*    */ {
/*  7 */   int lingerDuration = 50;
/*    */ 
/*    */   public PunchProjectile(float xSpawnLocation, float ySpawnLocation, Character character, World world) {
/* 10 */     super(xSpawnLocation, ySpawnLocation, world);
/* 11 */     this.owner = character;
/* 12 */     this.maxRange = 0.0F;
/* 13 */     this.damage = character.baseDamage;
/* 14 */     setHitboxSize(40.0F, 40.0F);
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, Graphics g)
/*    */     throws SlickException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, int delta)
/*    */     throws SlickException, InterruptedException
/*    */   {
/* 26 */     if (this.lingerDuration <= 0) {
/* 27 */       this.world.remove(this);
/*    */     }
/*    */     else
/* 30 */       this.lingerDuration -= delta;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     PunchProjectile
 * JD-Core Version:    0.6.2
 */