package com.morecritters.mod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.resources.ResourceLocation;

/**
 * The 1.20.1 {@code ImageButton}: one texture with the hovered state {@code yDiffTex} pixels lower.
 * 1.21 buttons read sprites from the GUI atlas, but the atlas buttons of the mod are plain sheets.
 */
public class LegacyImageButton extends ImageButton {
    private final ResourceLocation texture;
    private final int xTexStart;
    private final int yTexStart;
    private final int yDiffTex;
    private final int textureWidth;
    private final int textureHeight;

    public LegacyImageButton(
        int x,
        int y,
        int width,
        int height,
        int xTexStart,
        int yTexStart,
        int yDiffTex,
        ResourceLocation texture,
        int textureWidth,
        int textureHeight,
        Button.OnPress onPress
    ) {
        super(x, y, width, height, new WidgetSprites(texture, texture), onPress);
        this.texture = texture;
        this.xTexStart = xTexStart;
        this.yTexStart = yTexStart;
        this.yDiffTex = yDiffTex;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int v = this.yTexStart;
        if (!this.isActive()) {
            v += this.yDiffTex * 2;
        } else if (this.isHoveredOrFocused()) {
            v += this.yDiffTex;
        }

        RenderSystem.enableDepthTest();
        guiGraphics.blit(this.texture, this.getX(), this.getY(), (float)this.xTexStart, (float)v, this.width, this.height, this.textureWidth, this.textureHeight);
    }
}
