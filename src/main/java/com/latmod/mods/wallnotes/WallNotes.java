package com.latmod.mods.wallnotes;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

@Mod(
		modid = WallNotes.MOD_ID,
		name = WallNotes.MOD_NAME,
		version = WallNotes.VERSION,
		clientSideOnly = true
)
public class WallNotes
{
	public static final String MOD_ID = "wallnotes";
	public static final String MOD_NAME = "Wall Notes";
	public static final String VERSION = "0.0.0.wallnotes";

	public static KeyBinding KEY;

	@Mod.EventHandler
	public void onPreInit(FMLPreInitializationEvent event)
	{
		KEY = new KeyBinding("key.wallnotes", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_N, "key.categories.misc");
		ClientRegistry.registerKeyBinding(KEY);
	}
}