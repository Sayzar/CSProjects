/*     */ import java.util.ArrayList;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.Sound;
/*     */ 
/*     */ public class LightningProjectile extends Projectile
/*     */ {
/*     */   private int lingerDuration;
/*     */   private Lightning caster;
/*     */ 
/*     */   public LightningProjectile(float xSpawnLocation, float ySpawnLocation, Item item, World world)
/*     */   {
/*  12 */     super(xSpawnLocation, ySpawnLocation, item, world);
/*     */ 
/*  14 */     this.lingerDuration = 20000;
/*  15 */     this.caster = ((Lightning)item);
/*     */   }
/*     */ 
/*     */   public void checkCollisions()
/*     */   {
/*  21 */     for (Character c : this.world.getCharacters())
/*     */     {
/*  23 */       if ((this.owner != c) && 
/*  24 */         (getHitbox().intersects(c.getHitbox())))
/*     */       {
/*  26 */         c.modifyHealth(getDamage());
/*  27 */         this.world.remove(this);
/*  28 */         this.caster.remove(this);
/*  29 */         ((Sound)this.world.punchHit.get((int)(3.0D * Math.random()))).play();
/*     */       }
/*     */     }
/*     */ 
/*  33 */     for (Block b : this.world.getBlocks())
/*  34 */       if ((getHitbox().intersects(b.getHitbox())) && 
/*  35 */         (b.blockType == BlockType.Crate)) {
/*  36 */         this.world.spawnItem(b);
/*  37 */         this.world.remove(b);
/*  38 */         this.world.remove(this);
/*  39 */         this.caster.remove(this);
/*  40 */         this.world.playRandomSound(this.world.punchHit);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void update(GameContainer gc, int delta)
/*     */     throws SlickException, InterruptedException
/*     */   {
/*  50 */     if (this.lingerDuration <= 0) {
/*  51 */       this.world.remove(this);
/*  52 */       this.caster.remove(this);
/*     */     }
/*     */     else {
/*  55 */       this.lingerDuration -= delta;
/*     */     }
/*     */ 
/* 124 */     setHitboxLocation(this.xCoord, this.yCoord);
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     LightningProjectile
 * JD-Core Version:    0.6.2
 */