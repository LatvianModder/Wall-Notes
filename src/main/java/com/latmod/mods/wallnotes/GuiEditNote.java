package com.latmod.mods.wallnotes;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.input.Keyboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LatvianModder
 */
public class GuiEditNote extends GuiScreen
{
	public final BlockPos pos;
	public final EnumFacing facing;
	private final List<GuiTextField> textFields;

	public GuiEditNote(BlockPos p, EnumFacing f)
	{
		pos = p;
		facing = f;
		textFields = new ArrayList<>();
	}

	@Override
	public void initGui()
	{
		super.initGui();
		Keyboard.enableRepeatEvents(true);
		/*
		int i = width / 2;
		int j = height / 2;
		nameField = new GuiTextField(0, fontRenderer, i - 52, j - 6, 104, 12);
		nameField.setTextColor(-1);
		nameField.setDisabledTextColour(-1);
		nameField.setEnableBackgroundDrawing(false);
		//FIXME: nameField.setText(filter.getValue());
		nameField.setFocused(true);
		*/
	}

	@Override
	public void onGuiClosed()
	{
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		for (GuiTextField field : textFields)
		{
			if (field.textboxKeyTyped(typedChar, keyCode))
			{
				return;
			}
		}

		if (keyCode == Keyboard.KEY_RETURN)
		{
			/*String text = nameField.getText();
			FIXME: filter.setValue(text);

			mc.displayGuiScreen(null);

			if (mc.currentScreen == null)
			{
				mc.setIngameFocus();
			}*/
		}
		else
		{
			super.keyTyped(typedChar, keyCode);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		super.mouseClicked(mouseX, mouseY, mouseButton);

		for (GuiTextField field : textFields)
		{
			field.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		GlStateManager.disableLighting();
		GlStateManager.disableBlend();

		for (GuiTextField field : textFields)
		{
			field.drawTextBox();
		}
	}
}