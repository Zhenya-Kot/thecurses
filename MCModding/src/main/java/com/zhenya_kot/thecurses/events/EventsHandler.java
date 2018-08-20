package com.zhenya_kot.thecurses.events;

import java.util.Random;

import com.zhenya_kot.thecurses.TheCurses;
import com.zhenya_kot.thecurses.core.Curses;
import com.zhenya_kot.thecurses.helpers.CursesMathHelper;
import com.zhenya_kot.thecurses.items.ItemsRegister;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
//import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventsHandler {
	@SubscribeEvent
	public static void onLivingUpdate(LivingUpdateEvent e)
	{
		if(!e.getEntity().getEntityWorld().isRemote && e.getEntity() instanceof EntityPlayer && e.getEntity().getEntityWorld().getTotalWorldTime() % 20 == 0) {
			if (!e.getEntity().getEntityData().hasKey("cursetype")) e.getEntity().getEntityData().setByte("cursetype", (byte) 0);
			int cursetimer = e.getEntity().getEntityData().hasKey("cursetimer") ? e.getEntity().getEntityData().getInteger("cursetimer")+20 : 0;
			Random random = new Random(e.getEntity().getEntityWorld().getTotalWorldTime());
			int rint = random.nextInt(100000);
			if (cursetimer == 20*60*8) Curses.U3LC((EntityPlayer) e.getEntity());
			if (cursetimer >= 12000 && cursetimer < 24000) {
				if (rint < 60) { // 36% in all; for one 0.003%; real chance: 36%
					if (( (EntityPlayer) e.getEntityLiving()).inventory.hasItemStack(new ItemStack(ItemsRegister.PI1L)) || 
							( (EntityPlayer) e.getEntityLiving()).inventory.hasItemStack(new ItemStack(ItemsRegister.PI2L)) ||
							( (EntityPlayer) e.getEntityLiving()).inventory.hasItemStack(new ItemStack(ItemsRegister.PI3L))) {}
					else Curses.C1LC(random, e.getEntityLiving());
					if (TheCurses.DEBUG) System.out.println("!!! [EVENT HANDLER] CurseTimerVariable = " + cursetimer + "  CurseTimer NBT = " + e.getEntity().getEntityData().getInteger("cursetimer") + "  [EVENT HANDLER] !!!");
					cursetimer = 0;
				}
			} else if (cursetimer >= 24000 && cursetimer < 36000) {
				if (rint < 100) { // 60% in all; for one 0.005%; real chance: 38,4%
					if ((  (EntityPlayer) e.getEntityLiving()).inventory.hasItemStack(new ItemStack(ItemsRegister.PI2L)) ||
							( (EntityPlayer) e.getEntityLiving()).inventory.hasItemStack(new ItemStack(ItemsRegister.PI3L))) {}
					else Curses.C2LC(random, e.getEntityLiving());
					if (TheCurses.DEBUG) System.out.println("!!! [EVENT HANDLER] CurseTimerVariable = " + cursetimer + "  CurseTimer NBT = " + e.getEntity().getEntityData().getInteger("cursetimer") + "  [EVENT HANDLER] !!!");
					cursetimer = 0;
				}
			} else if (cursetimer >= 36000) {
				if (rint < 200) { // 120% in all; for one 0.01%; real chance: 25,6%
					if (( ( (EntityPlayer) e.getEntityLiving()).inventory.hasItemStack(new ItemStack(ItemsRegister.PI3L)))) {}
					else Curses.C3LC(random, e.getEntityLiving());
					if (TheCurses.DEBUG) System.out.println("!!! [EVENT HANDLER] CurseTimerVariable = " + cursetimer + "  CurseTimer NBT = " + e.getEntity().getEntityData().getInteger("cursetimer") + "  [EVENT HANDLER] !!!");
					cursetimer = 0;
				}
			}
			e.getEntity().getEntityData().setInteger("cursetimer", cursetimer);
		}
	}
	
	
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent e) {
		if (e.getEntity() instanceof EntityPlayer && e.getEntity().getEntityData().getByte("cursetype") == (byte) 1) {
			((EntityPlayer) e.getEntity()).sendMessage(new TextComponentString("You are cursed and can't travel beetwen dimensions!"));
			e.setCanceled(true); 
		}
	}
	
	@SubscribeEvent
	public static void onPlayerSleepInBed (PlayerSleepInBedEvent e) {
		if (e.getEntity().getEntityData().getByte("cursetype") == (byte) 2) {
			e.getEntityPlayer().sendMessage(new TextComponentString("You are cursed and can't sleep!"));
			e.setResult(EntityPlayer.SleepResult.OTHER_PROBLEM);
		}
	}
	
	@SubscribeEvent
	public static void onItemFished(ItemFishedEvent e) {
		if(e.getEntity().getEntityData().getByte("cursetype") == 3) {
			EntityZombie zombie = new EntityZombie(e.getEntity().world);
			Vec3i vec = CursesMathHelper.yawPitchToVector(e.getEntityPlayer().cameraYaw, e.getEntityPlayer().cameraPitch);
			BlockPos pos = e.getEntity().getPosition().add(vec.getX()*2, vec.getY()*2, vec.getZ()*2); 			
			zombie.setPositionAndRotation(pos.getX(), pos.getY(), pos.getZ(), CursesMathHelper.yawInvert(e.getEntityPlayer().cameraYaw), e.getEntityPlayer().cameraPitch);
			e.getEntity().world.spawnEntity(zombie);
			e.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onArrowLoose (ArrowLooseEvent e) {
		if(e.getEntity() instanceof EntityPlayer && e.getEntity().getEntityData().getByte("cursetype")  == 4) {
			e.getWorld().spawnEntity(new EntityTippedArrow(e.getWorld(), e.getEntityLiving().posX, e.getEntityLiving().posY+3, e.getEntityLiving().posZ)); 
			e.setCanceled(true);
		}
	}
}
