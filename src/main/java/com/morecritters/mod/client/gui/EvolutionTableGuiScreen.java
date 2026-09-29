package com.morecritters.mod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.procedures.ArrowDisplay1Procedure;
import com.morecritters.mod.procedures.ArrowDisplay2Procedure;
import com.morecritters.mod.procedures.ArrowDisplay3Procedure;
import com.morecritters.mod.world.inventory.EvolutionTableGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EvolutionTableGuiScreen extends AbstractContainerScreen<EvolutionTableGuiMenu> {
    private static final HashMap<String, Object> guistate = EvolutionTableGuiMenu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    private static final ResourceLocation texture = ResourceLocation.parse("more_critters:textures/screens/evolution_table_gui.png");

    public EvolutionTableGuiScreen(EvolutionTableGuiMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        if (ArrowDisplay1Procedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/evolution_arrow_1.png"), this.leftPos + 45, this.topPos + 20, 0.0F, 0.0F, 86, 59, 86, 59
            );
        }

        if (ArrowDisplay2Procedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/evolution_arrow_2.png"), this.leftPos + 45, this.topPos + 20, 0.0F, 0.0F, 86, 59, 86, 59
            );
        }

        if (ArrowDisplay3Procedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/evolution_arrow_3.png"), this.leftPos + 45, this.topPos + 20, 0.0F, 0.0F, 86, 59, 86, 59
            );
        }

        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        } else {
            return super.keyPressed(key, b, c);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Component.translatable("gui.more_critters.evolution_table_gui.label_evolution_table"), 7, 6, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
    }
}
