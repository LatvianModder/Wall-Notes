package com.latmod.mods.wallnotes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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

	@Mod.EventHandler
	public void onPreInit(FMLPreInitializationEvent event)
	{
	}
}