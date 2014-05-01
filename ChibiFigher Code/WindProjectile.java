/*    */ import java.util.ArrayList;
/*    */ import org.newdawn.slick.Sound;
/*    */ 
/*    */ public class WindProjectile extends Projectile
/*    */ {
/*    */   private float KBDistance;
/*    */ 
/*    */   public WindProjectile(float xSpawnLocation, float ySpawnLocation, Wind item, World world)
/*    */   {
/*  7 */     super(xSpawnLocation, ySpawnLocation, item, world);
/*  8 */     this.KBDistance = item.projectileKBDistance;
/*    */   }
/*    */ 
/*    */   public void checkCollisions()
/*    */   {
/* 13 */     for (Character c : this.world.getCharacters())
/*    */     {
/* 15 */       if ((this.owner != c) && 
/* 16 */         (getHitbox().intersects(c.getHitbox())))
/*    */       {
/* 18 */         c.modifyHealth(this.damage);
/* 19 */         if (this.xVelocity > 0.0F)
/* 20 */           c.knockBack(this.KBDistance, 3.0F);
/*    */         else
/* 22 */           c.knockBack(this.KBDistance, -3.0F);
/* 23 */         this.world.remove(this);
/* 24 */         ((Sound)this.world.punchHit.get((int)(3.0D * Math.random()))).play();
/*    */       }
/*    */     }
/*    */ 
/* 28 */     for (Block b : this.world.getBlocks())
/* 29 */       if (getHitbox().intersects(b.getHitbox()))
/* 30 */         if (b.blockType == BlockType.Impassable) {
/* 31 */           this.world.remove(this);
/*    */         }
/* 33 */         else if (b.blockType == BlockType.Crate) {
/* 34 */           this.world.spawnItem(b);
/* 35 */           this.world.playRandomSound(this.world.punchHit);
/* 36 */           this.world.remove(this);
/*    */         }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     WindProjectile
 * JD-Core Version:    0.6.2
 */