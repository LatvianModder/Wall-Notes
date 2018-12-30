package com.latmod.mods.wallnotes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.toasts.SystemToast;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author LatvianModder
 */
@Mod.EventBusSubscriber(modid = WallNotes.MOD_ID, value = Side.CLIENT)
public class WallNotesEventHandler
{
	@SubscribeEvent
	public static void onKeyEvent(InputEvent.KeyInputEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();
		RayTraceResult ray = mc.objectMouseOver;

		if (ray != null && ray.typeOfHit == RayTraceResult.Type.BLOCK && WallNotes.KEY.isPressed())
		{
			if (ray.sideHit.getAxis() != EnumFacing.Axis.Y && mc.world.isSideSolid(ray.getBlockPos(), ray.sideHit))
			{
				mc.displayGuiScreen(new GuiEditNote(ray.getBlockPos(), ray.sideHit));
			}
			else
			{
				mc.getToastGui().add(new SystemToast(SystemToast.Type.TUTORIAL_HINT, new TextComponentTranslation("wallnotes.cant_place"), null));
			}
		}
	}
}