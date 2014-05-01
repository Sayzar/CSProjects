/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.newdawn.slick.Animation;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.Graphics;
/*     */ import org.newdawn.slick.Image;
/*     */ import org.newdawn.slick.Input;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.geom.Rectangle;
/*     */ 
/*     */ public class Character extends Entity
/*     */ {
/*     */   public int HP;
/*     */   public int damage;
/*     */   public int healthRegen;
/*     */   public int baseDamage;
/*     */   public int numRows;
/*     */   public int numCols;
/*  15 */   final int maxHealth = 20;
/*     */   public String name;
/*     */   public String itemName;
/*     */   public double range;
/*     */   public double baseRange;
/*     */   boolean hasAuxItem;
/*     */   boolean hasItem;
/*     */   Item item;
/*     */   int wins;
/*     */   int jumpHeight;
/*     */   float xVelocity;
/*     */   float yVelocity;
/*     */   boolean isMovingUp;
/*     */   boolean isMovingRight;
/*     */   boolean isMovingLeft;
/*     */   boolean isMovingDown;
/*     */   boolean canMoveUp;
/*     */   boolean canMoveRight;
/*     */   boolean canMoveLeft;
/*     */   boolean canMoveDown;
/*     */   boolean jumpAvailable;
/*     */   boolean isJumpingLeft;
/*     */   boolean isJumpingRight;
/*     */   boolean movingLeft;
/*     */   boolean movingRight;
/*     */   boolean punchLeft;
/*     */   boolean punchRight;
/*  26 */   ArrayList<Animation> animationList = new ArrayList();
/*     */   Animation currentAnimation;
/*     */   private boolean isPunching;
/*     */   boolean isFacingRight;
/*     */   private boolean isJumping;
/*     */   private boolean isRunning;
/*     */   private boolean isKnockedBack;
/*     */   private float KBDistance;
/*     */   private boolean hit;
/*     */   private boolean isHit;
/*  36 */   private boolean canMove = true;
/*     */   private int timeElapsed;
/*     */   Projectile punchProjectile;
/*  41 */   int[] setOne = { 30, 17, 32, 31 };
/*  42 */   int[] setTwo = { 203, 200, 205, 208 };
/*     */   private double baseAttackCoolDown;
/*     */   private double attackCoolDown;
/*     */   public int playerID;
/*     */   int channelingTime;
/*     */   private int hitAnimationTime;
/*     */ 
/*     */   public Character(int x, int y, String player, World world)
/*     */   {
/*  53 */     super(x * 84 + 42, y * 84 + 84, player, world);
/*     */ 
/*  55 */     this.name = player;
/*  56 */     this.hasItem = false;
/*  57 */     this.baseAttackCoolDown = 600.0D;
/*  58 */     this.attackCoolDown = 0.0D;
/*     */ 
/*  60 */     this.HP = 100;
/*  61 */     this.baseDamage = 1;
/*  62 */     this.wins = 0;
/*  63 */     setHitboxSize(42.0F, 80.0F);
/*  64 */     this.item = null;
/*     */ 
/*  66 */     this.HP = 20;
/*  67 */     this.damage = 5;
/*  68 */     this.healthRegen = 1;
/*  69 */     this.itemName = null;
/*  70 */     this.jumpAvailable = true;
/*     */   }
/*     */ 
/*     */   public String displayHP()
/*     */   {
/*  80 */     return this.HP + "/" + 20;
/*     */   }
/*     */ 
/*     */   public int getHP()
/*     */   {
/*  86 */     return this.HP;
/*     */   }
/*     */ 
/*     */   public void modifyHealth(int deltaHealth)
/*     */   {
/*  91 */     this.HP -= deltaHealth;
/*  92 */     this.isHit = true;
/*  93 */     this.hitAnimationTime = 200;
/*     */   }
/*     */ 
/*     */   public int getDamage()
/*     */   {
/*  98 */     return this.damage;
/*     */   }
/*     */ 
/*     */   public void pickUpItem(Item item)
/*     */   {
/* 103 */     this.damage = item.damage;
/* 104 */     this.range = item.projectileRange;
/* 105 */     this.itemName = item.name;
/* 106 */     this.item = item;
/* 107 */     this.hasItem = true;
/* 108 */     item.setOwner(this);
/*     */   }
/*     */ 
/*     */   public void dropItem()
/*     */   {
/* 114 */     this.hasItem = false;
/* 115 */     this.damage = this.baseDamage;
/* 116 */     this.range = this.baseRange;
/* 117 */     this.itemName = null;
/* 118 */     this.item.setOwner(null);
/*     */   }
/*     */ 
/*     */   public void attack()
/*     */   {
/* 124 */     if (this.attackCoolDown <= 0.0D) {
/* 125 */       this.isPunching = true;
/* 126 */       this.channelingTime = 400;
/* 127 */       if (this.hasItem)
/*     */       {
/* 129 */         this.item.use(this.world);
/* 130 */         this.attackCoolDown = this.item.reloadTime;
/*     */       }
/*     */       else {
/* 133 */         if (this.isFacingRight) {
/* 134 */           this.punchProjectile = new PunchProjectile(this.hitbox.getCenterX(), this.hitbox.getY() + 20.0F, this, this.world);
/*     */         }
/*     */         else {
/* 137 */           this.punchProjectile = new PunchProjectile(this.hitbox.getCenterX() - 40.0F, this.hitbox.getY() + 20.0F, this, this.world);
/*     */         }
/* 139 */         this.world.getProjectiles().add(this.punchProjectile);
/* 140 */         this.attackCoolDown = this.baseAttackCoolDown;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void determineDirection()
/*     */   {
/* 149 */     if (this.xVelocity > 0.0F)
/*     */     {
/* 151 */       this.isMovingRight = true;
/* 152 */       this.isMovingLeft = false;
/*     */ 
/* 154 */       if (this.yVelocity > 0.0F)
/*     */       {
/* 156 */         this.isMovingUp = false;
/* 157 */         this.isMovingDown = true;
/*     */       }
/* 161 */       else if (this.yVelocity < 0.0F)
/*     */       {
/* 163 */         this.isMovingUp = true;
/* 164 */         this.isMovingDown = false;
/*     */       }
/*     */       else
/*     */       {
/* 170 */         this.isMovingUp = false;
/* 171 */         this.isMovingDown = false;
/*     */       }
/*     */     }
/* 174 */     else if (this.xVelocity < 0.0F)
/*     */     {
/* 176 */       this.isMovingRight = false;
/* 177 */       this.isMovingLeft = true;
/*     */ 
/* 179 */       if (this.yVelocity > 0.0F)
/*     */       {
/* 181 */         this.isMovingUp = false;
/* 182 */         this.isMovingDown = true;
/*     */       }
/* 186 */       else if (this.yVelocity < 0.0F)
/*     */       {
/* 188 */         this.isMovingUp = true;
/* 189 */         this.isMovingDown = false;
/*     */       }
/*     */       else
/*     */       {
/* 195 */         this.isMovingUp = false;
/* 196 */         this.isMovingDown = false;
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 202 */       this.isMovingLeft = false;
/* 203 */       this.isMovingRight = false;
/*     */ 
/* 205 */       if (this.yVelocity > 0.0F)
/*     */       {
/* 207 */         this.isMovingUp = false;
/* 208 */         this.isMovingDown = true;
/*     */       }
/* 212 */       else if (this.yVelocity < 0.0F)
/*     */       {
/* 214 */         this.isMovingUp = true;
/* 215 */         this.isMovingDown = false;
/*     */       }
/*     */       else
/*     */       {
/* 221 */         this.isMovingLeft = false;
/* 222 */         this.isMovingRight = false;
/* 223 */         this.isMovingUp = false;
/* 224 */         this.isMovingDown = false;
/* 225 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void loadAnimations() throws SlickException {
/* 231 */     this.jumpHeight = 0;
/*     */ 
/* 233 */     Image[] i = new Image[10];
/* 234 */     i[0] = new Image("assets/Art/Characters/" + this.name + "/jump-spritesheet.png");
/* 235 */     i[1] = new Image("assets/Art/Characters/" + this.name + "/punch-spritesheet.png");
/* 236 */     i[2] = new Image("assets/Art/Characters/" + this.name + "/stand-spritesheet.png");
/* 237 */     i[3] = new Image("assets/Art/Characters/" + this.name + "/run-spritesheet.png");
/* 238 */     i[4] = new Image("assets/Art/Characters/" + this.name + "/hurt-spritesheet.png");
/* 239 */     i[5] = new Image("assets/Art/Characters/" + this.name + "/jump-spritesheet.png").getFlippedCopy(true, false);
/* 240 */     i[6] = new Image("assets/Art/Characters/" + this.name + "/punch-spritesheet.png").getFlippedCopy(true, false);
/* 241 */     i[7] = new Image("assets/Art/Characters/" + this.name + "/stand-spritesheet.png").getFlippedCopy(true, false);
/* 242 */     i[8] = new Image("assets/Art/Characters/" + this.name + "/run-spritesheet.png").getFlippedCopy(true, false);
/* 243 */     i[9] = new Image("assets/Art/Characters/" + this.name + "/hurt-spritesheet.png").getFlippedCopy(true, false);
/* 244 */     int[] cols = { 4, 2, 3, 9, 2 };
/* 245 */     int count = 0;
/* 246 */     boolean toFlipped = false;
/* 247 */     for (Image img : i) {
/* 248 */       if ((img.equals(i[0])) || (img.equals(i[5]))) {
/* 249 */         img = img.getSubImage(0, 25, img.getWidth(), img.getHeight() - 25);
/*     */       }
/* 251 */       if (count == 5) {
/* 252 */         count = 0;
/* 253 */         toFlipped = true;
/*     */       }
/* 255 */       Image[] imagelist = new Image[cols[count]];
/* 256 */       int imageListTrack = 0;
/*     */ 
/* 258 */       if ((img.equals(i[3])) || (img.equals(i[8]))) {
/* 259 */         if (this.name.substring(0, 5).equals("sable")) {
/* 260 */           cols[count] = 7;
/*     */         }
/* 262 */         renderEnt(img, img.getWidth() / cols[count], img.getHeight(), 100);
/*     */       }
/*     */       else
/*     */       {
/* 266 */         renderEnt(img, img.getWidth() / cols[count], img.getHeight(), 300);
/* 267 */       }if (toFlipped) {
/* 268 */         for (int j = cols[count] - 1; j >= 0; j--) {
/* 269 */           imagelist[imageListTrack] = this.animation.getImage(j);
/* 270 */           imageListTrack++;
/*     */         }
/* 272 */         if (img.equals(i[8]))
/* 273 */           this.animation = new Animation(imagelist, 100);
/*     */         else {
/* 275 */           this.animation = new Animation(imagelist, 300);
/*     */         }
/*     */       }
/* 278 */       count++;
/*     */ 
/* 280 */       this.animation.stopAt(this.animation.getFrameCount());
/* 281 */       this.animationList.add(this.animation);
/*     */     }
/* 283 */     this.currentAnimation = ((Animation)this.animationList.get(2));
/*     */   }
/*     */ 
/*     */   public void render(GameContainer gc, Graphics g)
/*     */     throws SlickException
/*     */   {
/* 289 */     this.currentAnimation.draw(this.xCoord - this.currentAnimation.getWidth() / 2, this.yCoord - this.currentAnimation.getHeight());
/* 290 */     if (this.currentAnimation.isStopped()) {
/* 291 */       this.currentAnimation.restart();
/*     */     }
/*     */ 
/* 294 */     super.render(gc, g);
/*     */   }
/*     */ 
/*     */   private void setMovement()
/*     */   {
/* 299 */     if (this.xVelocity < 0.0F) {
/* 300 */       if (this.canMoveLeft) {
/* 301 */         this.xCoord += this.xVelocity;
/*     */       }
/*     */     }
/* 304 */     else if ((this.xVelocity > 0.0F) && 
/* 305 */       (this.canMoveRight)) {
/* 306 */       this.xCoord += this.xVelocity;
/*     */     }
/*     */ 
/* 309 */     if (this.yVelocity > 0.0F) {
/* 310 */       if (this.canMoveDown) {
/* 311 */         this.yCoord += this.yVelocity;
/*     */       }
/*     */     }
/* 314 */     else if ((this.yVelocity < 0.0F) && 
/* 315 */       (this.canMoveUp))
/* 316 */       this.yCoord += this.yVelocity;
/*     */   }
/*     */ 
/*     */   public void update(GameContainer gc, int delta)
/*     */     throws SlickException, InterruptedException
/*     */   {
/* 325 */     determineDirection();
/* 326 */     this.timeElapsed = delta;
/*     */ 
/* 328 */     if (this.isPunching) {
/* 329 */       if ((!this.isMovingUp) && (!this.isMovingDown)) {
/* 330 */         this.canMove = false;
/* 331 */         this.xVelocity = (this.yVelocity = 0.0F);
/*     */       }
/* 333 */       this.channelingTime -= delta;
/*     */ 
/* 335 */       if (this.channelingTime <= 0) {
/* 336 */         this.canMove = true;
/* 337 */         this.isPunching = false;
/*     */       }
/*     */     }
/* 340 */     if ((this.isHit) && (!this.isKnockedBack)) {
/* 341 */       this.hitAnimationTime -= delta;
/* 342 */       if (this.hitAnimationTime <= 0) {
/* 343 */         this.isHit = false;
/* 344 */         this.hitAnimationTime = 0;
/*     */       }
/*     */     }
/*     */ 
/* 348 */     if (this.canMove) {
/* 349 */       setMovement();
/*     */     }
/*     */ 
/* 352 */     if ((this.isKnockedBack) && (this.KBDistance > 0.0F)) {
/* 353 */       this.KBDistance -= Math.abs(this.xVelocity);
/*     */     }
/*     */     else {
/* 356 */       this.isKnockedBack = false;
/* 357 */       this.isJumping = (((this.canMoveDown) && (this.isMovingDown)) || ((this.isMovingUp) && (this.canMoveUp)) || ((this.isMovingUp) && (this.canMoveDown)) || ((!this.isMovingUp) && (this.canMoveDown)));
/* 358 */       this.jumpAvailable = (!this.canMoveDown);
/* 359 */       this.isRunning = ((!this.isJumping) && (this.xVelocity != 0.0F));
/*     */ 
/* 361 */       this.xVelocity = 0.0F;
/*     */     }
/*     */ 
/* 364 */     if ((!this.isKnockedBack) && (this.canMove)) {
/* 365 */       if (this.isMovingRight) {
/* 366 */         this.isFacingRight = true;
/*     */       }
/* 368 */       else if (this.isMovingLeft) {
/* 369 */         this.isFacingRight = false;
/*     */       }
/*     */     }
/* 372 */     selectAnimation(delta);
/* 373 */     setHitboxLocation(this.xCoord - this.hitbox.getWidth() / 2.0F, this.yCoord - this.hitbox.getHeight());
/*     */ 
/* 376 */     this.attackCoolDown -= delta;
/* 377 */     if (this.attackCoolDown < 0.0D) {
/* 378 */       this.attackCoolDown = 0.0D;
/*     */     }
/*     */ 
/* 381 */     this.canMoveUp = true;
/* 382 */     this.canMoveDown = true;
/* 383 */     this.canMoveRight = true;
/* 384 */     this.canMoveLeft = true;
/*     */   }
/*     */ 
/*     */   private void selectAnimation(int delta) {
/* 388 */     if (this.isFacingRight) {
/* 389 */       if ((this.isJumping) && (!this.jumpAvailable)) {
/* 390 */         if (this.currentAnimation != this.animationList.get(0))
/* 391 */           this.currentAnimation = ((Animation)this.animationList.get(0));
/*     */       }
/* 393 */       else if ((this.isPunching) && (!this.isJumping)) {
/* 394 */         if (this.currentAnimation != this.animationList.get(1))
/* 395 */           this.currentAnimation = ((Animation)this.animationList.get(1));
/*     */       }
/* 397 */       else if (this.isRunning) {
/* 398 */         if (this.currentAnimation != this.animationList.get(3)) {
/* 399 */           this.currentAnimation = ((Animation)this.animationList.get(3));
/*     */         }
/*     */       }
/* 402 */       else if ((this.isHit) || (this.isKnockedBack)) {
/* 403 */         if (this.currentAnimation != this.animationList.get(4)) {
/* 404 */           this.currentAnimation = ((Animation)this.animationList.get(4));
/*     */         }
/*     */       }
/* 407 */       else if ((this.isPunching) && (this.isJumping))
/*     */       {
/* 409 */         if (this.currentAnimation != this.animationList.get(1)) {
/* 410 */           this.currentAnimation = ((Animation)this.animationList.get(1));
/*     */         }
/*     */ 
/*     */       }
/* 414 */       else if (this.currentAnimation != this.animationList.get(2)) {
/* 415 */         this.currentAnimation = ((Animation)this.animationList.get(2));
/*     */       }
/*     */ 
/*     */     }
/* 422 */     else if ((this.isJumping) && (!this.jumpAvailable)) {
/* 423 */       if (this.currentAnimation != this.animationList.get(5))
/* 424 */         this.currentAnimation = ((Animation)this.animationList.get(5));
/*     */     }
/* 426 */     else if (this.isPunching) {
/* 427 */       if (this.currentAnimation != this.animationList.get(6))
/* 428 */         this.currentAnimation = ((Animation)this.animationList.get(6));
/*     */     }
/* 430 */     else if (this.isRunning) {
/* 431 */       if (this.currentAnimation != this.animationList.get(8)) {
/* 432 */         this.currentAnimation = ((Animation)this.animationList.get(8));
/*     */       }
/*     */     }
/* 435 */     else if ((this.isHit) || (this.isKnockedBack)) {
/* 436 */       if (this.currentAnimation != this.animationList.get(9)) {
/* 437 */         this.currentAnimation = ((Animation)this.animationList.get(9));
/*     */       }
/*     */     }
/* 440 */     else if ((this.isPunching) && (this.isJumping))
/*     */     {
/* 442 */       if (this.currentAnimation != this.animationList.get(6)) {
/* 443 */         this.currentAnimation = ((Animation)this.animationList.get(6));
/*     */       }
/*     */ 
/*     */     }
/* 447 */     else if (this.currentAnimation != this.animationList.get(7)) {
/* 448 */       this.currentAnimation = ((Animation)this.animationList.get(7));
/*     */     }
/*     */ 
/* 454 */     this.isJumping = false;
/*     */ 
/* 457 */     this.isRunning = false;
/*     */   }
/*     */ 
/*     */   public void setPlayerID(int playerID) {
/* 461 */     this.playerID = playerID;
/*     */   }
/*     */ 
/*     */   public void reset() {
/* 465 */     this.isJumping = false;
/* 466 */     this.isPunching = false;
/*     */ 
/* 468 */     this.isHit = false;
/* 469 */     this.isRunning = false;
/* 470 */     this.isMovingRight = false;
/* 471 */     this.isMovingUp = (this.isMovingRight = this.isMovingLeft = this.isMovingDown = 0);
/* 472 */     this.isKnockedBack = false;
/* 473 */     this.KBDistance = 0.0F;
/* 474 */     this.canMoveUp = (this.canMoveRight = this.canMoveLeft = this.canMoveDown = 0);
/* 475 */     this.isJumpingLeft = (this.isJumpingRight = this.movingLeft = this.movingRight = 0);
/* 476 */     this.xVelocity = 0.0F;
/* 477 */     this.yVelocity = 0.0F;
/* 478 */     this.hasAuxItem = false;
/* 479 */     this.hasItem = false;
/* 480 */     this.attackCoolDown = 0.0D;
/* 481 */     this.canMove = true;
/* 482 */     this.KBDistance = 0.0F;
/* 483 */     this.channelingTime = 0;
/* 484 */     this.hitAnimationTime = 0;
/*     */ 
/* 487 */     this.item = null;
/*     */ 
/* 489 */     this.HP = 20;
/*     */ 
/* 491 */     this.itemName = null;
/* 492 */     this.jumpAvailable = true;
/*     */   }
/*     */ 
/*     */   public void checkCollisions(GameContainer gc) {
/* 496 */     Rectangle r = new Rectangle(getHitbox().getX() + this.xVelocity, getHitbox().getY() + this.yVelocity, getHitbox().getWidth(), getHitbox().getHeight());
/* 497 */     for (Block b : getWorld().getBlocks()) {
/* 498 */       if (r.intersects(b.getHitbox())) {
/* 499 */         if (b.getBlockType() == BlockType.Lethal) {
/* 500 */           modifyHealth(getHP());
/*     */         }
/* 502 */         determineDirection();
/* 503 */         if ((this.isMovingLeft) && (b.getBlockType() != BlockType.Passable)) {
/* 504 */           if ((getHitbox().getLeft() >= b.getHitbox().getRight()) && 
/* 505 */             (getHitbox().getBottom() > b.getHitbox().getTop()))
/*     */           {
/* 507 */             this.canMoveLeft = false;
/* 508 */             this.isKnockedBack = false;
/*     */           }
/* 510 */           if ((this.isMovingUp) && (b.getBlockType() != BlockType.Passable)) {
/* 511 */             if (getHitbox().getTop() >= b.getHitbox().getBottom()) {
/* 512 */               this.yVelocity = 0.0F;
/* 513 */               this.yCoord = (b.getHitbox().getBottom() + getHitbox().getHeight());
/* 514 */               this.jumpAvailable = false;
/* 515 */               this.canMoveUp = false;
/*     */             }
/*     */           }
/* 518 */           else if (this.isMovingDown) {
/* 519 */             this.jumpAvailable = false;
/* 520 */             if (getHitbox().getBottom() <= b.getHitbox().getTop()) {
/* 521 */               this.yVelocity = 0.0F;
/* 522 */               this.yCoord = b.getHitbox().getTop();
/* 523 */               this.canMoveDown = false;
/* 524 */               this.jumpAvailable = true;
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/* 529 */         else if ((this.isMovingRight) && (b.getBlockType() != BlockType.Passable)) {
/* 530 */           if ((getHitbox().getRight() <= b.getHitbox().getLeft()) && 
/* 531 */             (getHitbox().getBottom() > b.getHitbox().getTop()))
/*     */           {
/* 533 */             this.canMoveRight = false;
/* 534 */             this.isKnockedBack = false;
/*     */           }
/* 536 */           if ((this.isMovingUp) && (b.getBlockType() != BlockType.Passable)) {
/* 537 */             if (getHitbox().getTop() >= b.getHitbox().getBottom()) {
/* 538 */               this.yVelocity = 0.0F;
/* 539 */               this.yCoord = (b.getHitbox().getBottom() + getHitbox().getHeight());
/* 540 */               this.jumpAvailable = false;
/* 541 */               this.canMoveUp = false;
/*     */             }
/*     */           }
/* 544 */           else if (this.isMovingDown) {
/* 545 */             this.jumpAvailable = false;
/* 546 */             if (getHitbox().getBottom() <= b.getHitbox().getTop()) {
/* 547 */               this.yVelocity = 0.0F;
/* 548 */               this.yCoord = b.getHitbox().getTop();
/* 549 */               this.canMoveDown = false;
/* 550 */               this.jumpAvailable = true;
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/* 555 */         else if ((this.isMovingUp) && (b.getBlockType() != BlockType.Passable)) {
/* 556 */           this.yVelocity = 0.0F;
/* 557 */           this.yCoord = (b.getHitbox().getBottom() + getHitbox().getHeight());
/* 558 */           this.jumpAvailable = false;
/* 559 */           this.canMoveUp = false;
/*     */         }
/* 561 */         else if (this.isMovingDown) {
/* 562 */           this.jumpAvailable = false;
/* 563 */           if (getHitbox().getBottom() <= b.getHitbox().getTop()) {
/* 564 */             this.yVelocity = 0.0F;
/* 565 */             this.yCoord = b.getHitbox().getTop();
/* 566 */             this.canMoveDown = false;
/* 567 */             this.jumpAvailable = true;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 572 */       if (r.getX() <= 0.0F) {
/* 573 */         this.canMoveLeft = false;
/* 574 */         this.isKnockedBack = false;
/*     */       }
/* 576 */       if (r.getX() + r.getWidth() >= gc.getWidth()) {
/* 577 */         this.canMoveRight = false;
/* 578 */         this.isKnockedBack = false;
/*     */       }
/* 580 */       if (r.getY() <= 0.0F) {
/* 581 */         this.canMoveUp = false;
/* 582 */         this.yVelocity = 0.0F;
/*     */       }
/* 584 */       if (r.getY() > gc.getHeight()) {
/* 585 */         modifyHealth(getHP());
/*     */       }
/*     */     }
/* 588 */     for (Item i : getWorld().getItemsOnMap())
/*     */     {
/* 590 */       if ((getHitbox().intersects(i.getHitbox())) && (!this.hasItem))
/*     */       {
/* 592 */         pickUpItem(i);
/* 593 */         getWorld().remove(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void handleInput(Input input) {
/* 599 */     if ((!this.isKnockedBack) && (!this.isHit))
/* 600 */       if (this.playerID == 0) {
/* 601 */         if (input.isKeyDown(30)) {
/* 602 */           this.xVelocity = -3.0F;
/* 603 */           this.canMoveLeft = true;
/*     */         }
/* 605 */         if ((input.isKeyDown(17)) && 
/* 606 */           (this.jumpAvailable)) {
/* 607 */           this.yVelocity = -7.5F;
/* 608 */           this.jumpAvailable = false;
/* 609 */           this.canMoveUp = true;
/*     */         }
/*     */ 
/* 613 */         if (input.isKeyDown(57)) {
/* 614 */           attack();
/*     */         }
/* 616 */         if (input.isKeyDown(16)) {
/* 617 */           for (Item i : getWorld().getItemsOnMap())
/*     */           {
/* 619 */             if (getHitbox().intersects(i.getHitbox()))
/*     */             {
/* 621 */               dropItem();
/* 622 */               pickUpItem(i);
/* 623 */               getWorld().remove(i);
/*     */             }
/*     */           }
/*     */         }
/* 627 */         if (input.isKeyDown(32)) {
/* 628 */           this.xVelocity = 3.0F;
/* 629 */           this.canMoveRight = true;
/*     */         }
/*     */       }
/* 632 */       else if (this.playerID == 1) {
/* 633 */         if ((input.isKeyDown(36)) || (input.isKeyDown(75))) {
/* 634 */           this.xVelocity = -3.0F;
/* 635 */           this.canMoveLeft = true;
/*     */         }
/* 637 */         if (((input.isKeyDown(23)) || (input.isKeyDown(72))) && 
/* 638 */           (this.jumpAvailable)) {
/* 639 */           this.yVelocity = -7.5F;
/* 640 */           this.jumpAvailable = false;
/* 641 */           this.canMoveUp = true;
/*     */         }
/*     */ 
/* 644 */         if ((input.isKeyDown(24)) || (input.isKeyDown(71))) {
/* 645 */           for (Item i : getWorld().getItemsOnMap())
/*     */           {
/* 647 */             if (getHitbox().intersects(i.getHitbox()))
/*     */             {
/* 649 */               dropItem();
/* 650 */               pickUpItem(i);
/* 651 */               getWorld().remove(i);
/*     */             }
/*     */           }
/*     */         }
/* 655 */         if ((input.isKeyDown(38)) || (input.isKeyDown(77))) {
/* 656 */           this.xVelocity = 3.0F;
/* 657 */           this.canMoveRight = true;
/*     */         }
/* 659 */         if ((input.isKeyDown(22)) || (input.isKeyDown(82)))
/* 660 */           attack();
/*     */       }
/*     */   }
/*     */ 
/*     */   public void knockBack(float distance, float velocity)
/*     */   {
/* 667 */     this.isPunching = false;
/* 668 */     this.canMove = true;
/* 669 */     this.channelingTime = 0;
/* 670 */     this.KBDistance = distance;
/* 671 */     this.xVelocity = velocity;
/* 672 */     this.isKnockedBack = true;
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Character
 * JD-Core Version:    0.6.2
 */