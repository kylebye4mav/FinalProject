package edu.lewisu.cs.kylevbye;

public class PlayerEntity extends MobileScreenObject implements Entity {
	
	///
	///	Field
	///
	
	private Image[] soulSprites;
	
	
	private float health;
	private float maxHealth;
	
	///
	///	Getters
	///
	
	public Image[] getSoulSprites() { return soulSprites; }
	
	@Override
	public float getHealth() { return health; }
	
	@Override
	public float getMaxHealth() { return maxHealth; }
	
	///
	///	Setters
	///
	
	public void setSoulSprites(Image[] soulSpritesIn) { soulSprites = soulSpritesIn; }
	
	@Override
	public void setHealth(float healthIn) { 
		health = healthIn; 
		if (health < 0f) health = 0f;
		if (health > maxHealth) health = maxHealth;
	}
	
	public void setMaxHealth(float maxHealthIn) { maxHealth = maxHealthIn; }
	
	///
	///	Soul Sprites
	///
	
	public class SoulSprites {
		
		public static final int DETERMINATION = 0;
		public static final int BRAVERY = 1;
		public static final int JUSTICE = 2;
		public static final int KINDNESS = 3;
		public static final int PATIENCE = 4;
		public static final int INTEGRITY = 5;
		public static final int PERSEVERANCE = 6;
		
	}
	
	///
	///	Functions
	///
	
	@Override
	public void attack(Entity otherIn, float damageIn) {
		
		otherIn.absorbDamage(damageIn);

	}
	
	@Override
	public void absorbDamage(float damageIn) {
		
		setHealth(health-damageIn);
		
	}
	
	public void selectSoulSprite(int soulSpriteIn) { 
		
		Image selectedSprite = soulSprites[soulSpriteIn];
		setTextureRegion(selectedSprite.getTextureRegion()); 
		setWidth(selectedSprite.getWidth());
		setHeight(selectedSprite.getHeight());
		
	} 
	
	///
	///	Constructors
	///
	
	public PlayerEntity(Image[] soulSprites) {
		
		super(soulSprites[0]);
		
	}
	
	///
	///	Destructor
	///
	
	public void dispose() {
		
		for (Image i : soulSprites) i.dispose();
		setMaxHealth(100);
		setHealth(maxHealth);
		
	}
	

}
