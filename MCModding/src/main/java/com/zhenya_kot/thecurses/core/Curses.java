package com.zhenya_kot.thecurses.core;

import java.util.Random;

import com.zhenya_kot.thecurses.TheCurses;

import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.sound.SoundSetupEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class Curses {
	
	/**
	 * Effects
	 * 
	 * @param random
	 * @param entity
	 */
	public static void C1LC(Random random, EntityLivingBase e) {
		if (TheCurses.DEBUG) System.out.println("!!! [CURSES HANDLER] C1LC [CURSES HANDLER] !!!");
		EntityPlayer player  = (EntityPlayer) e;
		U3LC(player);
		player.sendMessage(new TextComponentString("You are cursed!"));	
		e.getEntityWorld().playSound(null, player.getPosition(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 0.3F, 0.5F);
		for (int i = 0; i < random.nextInt(3) + 1; i++) {
			switch (random.nextInt(13)) {
			case 0:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 30*20, 1, false, false));
				break;
			case 1:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 15*20, 4, false, false));
				break;
			case 2:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 10*20, 7, false, false));
				break;
			case 3:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 30*20, 1, false, false));
				break;
			case 4:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 10*20, 5, false, false));
				break;
			case 5:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 15*20, 129, false, false));
				break;
			case 6:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 30*20, 3, false, false));
				break;
			case 7:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 60*20, 1, false, false));
				break;
			case 8:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 10*20, 3, false, false));
				break;
			case 9:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 30*20, 1, false, false));
				break;
			case 10:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(25), 3*20, 2, false, false));
				break;
			case 11:
				e.addPotionEffect(new PotionEffect(Potion.getPotionById(27), 300*20, 1, false, false));
				break;
			case 12:
				e.setFire(7);
				break;
			}
		}
	}
	
	public static void U3LC(EntityPlayer player) {
		switch(player.getEntityData().getByte("cursetype")) {
		case 0:
			break;
		case 1:
			player.sendMessage(new TextComponentString("The curse has subsided and you can move again between dimensions"));
			break;
		case 2:
			player.sendMessage(new TextComponentString("The curse has subsided, have a nice sleep"));
			break;
		case 3:
			player.sendMessage(new TextComponentString("The curse has subsided, now fishing is safe"));
			break;
		case 4:
			player.sendMessage(new TextComponentString("The curse has subsided, now you can shoot safely"));
			break;
		}
		player.getEntityData().setByte("cursetype", (byte) 0);
	}

	/**
	 * One-times
	 * 
	 * @param random
	 * @param entity
	 */
	public static void C2LC(Random random, EntityLivingBase e) {
		if (TheCurses.DEBUG) System.out.println("!!! [CURSES HANDLER] C2LC [CURSES HANDLER] !!!");
		EntityPlayer player = (EntityPlayer) e;
		U3LC(player);
		player.sendMessage(new TextComponentString("You are cursed!"));	
		e.getEntityWorld().playSound(null, player.getPosition(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 0.3F, 0.5F);
		player.sendMessage(new TextComponentString("Beware!"));
		switch (random.nextInt(3)) {
		case 0:
			BlockPos e1 = e.getPosition().south(2);
			BlockPos e2 = e.getPosition().north(2).east(2);
			BlockPos e3 = e.getPosition().north(2).west(2);
			if (e.world.isAirBlock(e1) && e.world.isAirBlock(e1.up()) && e.world.isAirBlock(e2) && e.world.isAirBlock(e2.up()) && e.world.isAirBlock(e3) && e.world.isAirBlock(e3.up())) {
				Entity entity1, entity2, entity3;
				int rint1 = random.nextInt(10);
				if (rint1 < 5) {
					entity1 = new EntityZombie(e.world);
					entity2 = new EntityZombie(e.world);
					entity3 = new EntityZombie(e.world);
				} else if(rint1 < 8) {
					entity1 = new EntitySkeleton(e.world);
					entity2 = new EntitySkeleton(e.world);
					entity3 = new EntitySkeleton(e.world);
				} else if (rint1 == 8) {
					entity1 = new EntityCreeper(e.world);
					entity2 = new EntityCreeper(e.world);
					entity3 = new EntityCreeper(e.world);
				} else {
					entity1 = new EntityWitch(e.world);
					entity2 = new EntityWitch(e.world);
					entity3 = new EntityWitch(e.world);
				}
				entity1.setPosition( e1.getX(), e1.getY(), e1.getZ());
				entity2.setPosition( e2.getX(), e2.getY(), e2.getZ());
				entity3.setPosition( e3.getX(), e1.getY(), e3.getZ());
				e.world.spawnEntity( entity1 );
				e.world.spawnEntity( entity2 );
				e.world.spawnEntity( entity3 );
			} else {
				player.setHealth(random.nextInt(11)+5);
			}
			break;
		case 1:
			if (e.world.canSeeSky(e.getPosition())) {
				int rint1 = random.nextInt(5);
				EntityTippedArrow arrow = new EntityTippedArrow(e.world, e.posX, e.posY+15, e.posZ);
				EntityCow cow = new EntityCow(e.world);
				arrow.addVelocity(0.0, -1.0, 0.0);
				cow.setPosition(e.posX, e.posY+15, e.posZ);
				if (rint1 == 0) e.world.spawnEntity(new EntityLightningBolt(e.world, e.posX, e.posY, e.posZ, false));
				else if (rint1 <= 3) e.world.spawnEntity(arrow );
				else e.world.spawnEntity(cow);
			} else {
				player.setHealth(random.nextInt(11)+5);
			}
			break;
		case 2:
			int rint1 = random.nextInt(10);
			if (rint1 == 0) player.inventory.dropAllItems();
			else if (rint1 <= 3) player.getArmorInventoryList().forEach((v)->{
					player.dropItem(v.copy(), false);
					v.setCount(0);
				});
			else if (rint1 <= 7) {
				player.dropItem(player.getHeldItemMainhand().copy(), false);
				player.getHeldItemMainhand().setCount(0);
			} else {
				player.dropItem(player.getHeldItemOffhand().copy(), false);
				player.getHeldItemOffhand().setCount(0);
			}
		}
	}
	
	/**
	 * Long time
	 * 
	 * @param random
	 * @param entity
	 */
	public static void C3LC(Random random, EntityLivingBase e) {
		if (TheCurses.DEBUG) System.out.println("!!! [CURSES HANDLER] C3LC [CURSES HANDLER] !!!");
		U3LC((EntityPlayer) e);
		e.getEntityWorld().playSound(null, ((EntityPlayer) e).getPosition(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 0.3F, 0.5F);
		Random r = new Random();
		switch(r.nextInt(4)) {
		case 0:
			e.getEntityData().setByte("cursetype", (byte) 1);
			((EntityPlayer) e).sendMessage(new TextComponentString("You are cursed and can no longer move between dimensions!"));
			break;
		case 1:
			e.getEntityData().setByte("cursetype", (byte) 2);
			((EntityPlayer) e).sendMessage(new TextComponentString("You are cursed and can not fall asleep any more!"));
			break;
		case 2:
			e.getEntityData().setByte("cursetype", (byte) 3);
			((EntityPlayer) e).sendMessage(new TextComponentString("You are cursed, we do not advise you to fish!"));
			break;
		case 3:
			e.getEntityData().setByte("cursetype", (byte) 4);
			((EntityPlayer) e).sendMessage(new TextComponentString("You are cursed, we advise you not to shoot an arrow!"));
			break;
		}
	}
}
