package com.morecritters.mod.client.gui;

import com.morecritters.mod.client.gui.LegacyImageButton;
import net.neoforged.neoforge.network.PacketDistributor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.network.CritterAtlasShriekbat2ButtonMessage;
import com.morecritters.mod.world.inventory.CritterAtlasShriekbat2Menu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CritterAtlasShriekbat2Screen extends AbstractContainerScreen<CritterAtlasShriekbat2Menu> {
    private static final HashMap<String, Object> guistate = CritterAtlasShriekbat2Menu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    ImageButton imagebutton_arrow_left_1;

    public CritterAtlasShriekbat2Screen(CritterAtlasShriekbat2Menu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 280;
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
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critter_atlas_open_2.png"),
            this.leftPos + -4,
            this.topPos + -6,
            0.0F,
            0.0F,
            287,
            178,
            287,
            178
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/text_shriekbat_3.png"), this.leftPos + 4, this.topPos + 3, 0.0F, 0.0F, 130, 152, 130, 152
        );
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
    }

    @Override
    public void init() {
        super.init();
        this.imagebutton_arrow_left_1 = new LegacyImageButton(this.leftPos + 2, this.topPos + 147, 18, 10, 0, 0, 10, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_arrow_left_1.png"), 18, 20, e -> {
                PacketDistributor.sendToServer(new CritterAtlasShriekbat2ButtonMessage(0, this.x, this.y, this.z));
                CritterAtlasShriekbat2ButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_left_1", this.imagebutton_arrow_left_1);
        this.addRenderableWidget(this.imagebutton_arrow_left_1);
    }
}
