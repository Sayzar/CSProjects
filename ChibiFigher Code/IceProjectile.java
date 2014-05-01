/*     */ import java.util.ArrayList;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.Sound;
/*     */ 
/*     */ public class IceProjectile extends Projectile
/*     */ {
/*     */   private int lingerDuration;
/*     */   private boolean[] hasHit;
/*     */   private float KBDistance;
/*     */ 
/*     */   public IceProjectile(float xSpawnLocation, float ySpawnLocation, Item item, World world)
/*     */   {
/*  13 */     super(xSpawnLocation, ySpawnLocation, item, world);
/*     */ 
/*  15 */     this.lingerDuration = 700;
/*  16 */     this.hasHit = new boolean[world.getNumberOfPlayers()];
/*     */   }
/*     */ 
/*     */   public void checkCollisions()
/*     */   {
/*  22 */     for (Character c : this.world.getCharacters())
/*     */     {
/*  24 */       if ((this.hasHit[c.playerID] == 0) && 
/*  25 */         (this.owner != c) && 
/*  26 */         (getHitbox().intersects(c.getHitbox())))
/*     */       {
/*  28 */         c.modifyHealth(getDamage());
/*  29 */         this.hasHit[c.playerID] = true;
/*  30 */         if (this.isFlippedHorizontally) {
/*  31 */           this.KBDistance = (42.0F - (getHitbox().getX() - c.getHitbox().getX()));
/*  32 */           c.knockBack(this.KBDistance, -3.0F);
/*     */         }
/*     */         else {
/*  35 */           this.KBDistance = (42.0F - (getHitbox().getRight() - c.getHitbox().getX()));
/*  36 */           c.knockBack(this.KBDistance, 3.0F);
/*     */         }
/*     */ 
/*  40 */         ((Sound)this.world.punchHit.get((int)(3.0D * Math.random()))).play();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  45 */     for (Projectile p : this.world.getProjectiles())
/*     */     {
/*  47 */       if ((p != this) && (p.getOwner() != this.owner) && 
/*  48 */         (getHitbox().intersects(p.getHitbox())))
/*     */       {
/*  50 */         if (((p instanceof FireProjectile)) || ((p instanceof WindProjectile))) {
/*  51 */           p.owner = this.owner;
/*  52 */           p.xVelocity *= -1.0F;
/*  53 */           p.xSpawnLocation = p.xCoord;
/*  54 */           p.ySpawnLocation = p.yCoord;
/*  55 */           p.flip();
/*     */         }
/*     */         else {
/*  58 */           this.world.remove(p);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  63 */     for (Block b : this.world.getBlocks())
/*  64 */       if ((getHitbox().intersects(b.getHitbox())) && (b.blockType == BlockType.Crate)) {
/*  65 */         this.world.spawnItem(b);
/*  66 */         this.world.remove(b);
/*  67 */         this.world.playRandomSound(this.world.punchHit);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void update(GameContainer gc, int delta)
/*     */     throws SlickException, InterruptedException
/*     */   {
/*  76 */     if (this.lingerDuration <= 0) {
/*  77 */       this.world.remove(this);
/*     */     }
/*     */     else {
/*  80 */       this.lingerDuration -= delta;
/*     */     }
/*     */ 
/* 149 */     setHitboxLocation(this.xCoord, this.yCoord);
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     IceProjectile
 * JD-Core Version:    0.6.2
 */