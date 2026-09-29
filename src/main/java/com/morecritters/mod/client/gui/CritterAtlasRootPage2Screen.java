package com.morecritters.mod.client.gui;

import com.morecritters.mod.client.gui.LegacyImageButton;
import net.neoforged.neoforge.network.PacketDistributor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.network.CritterAtlasRootPage2ButtonMessage;
import com.morecritters.mod.world.inventory.CritterAtlasRootPage2Menu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CritterAtlasRootPage2Screen extends AbstractContainerScreen<CritterAtlasRootPage2Menu> {
    private static final HashMap<String, Object> guistate = CritterAtlasRootPage2Menu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    ImageButton imagebutton_button_shadelet_0;
    ImageButton imagebutton_button_treeplet_0;
    ImageButton imagebutton_button_nervoid_0;
    ImageButton imagebutton_button_corpse_crew_0;
    ImageButton imagebutton_arrow_left_1;
    ImageButton imagebutton_button_gravedigger_0;
    ImageButton imagebutton_button_armossillo_0;
    ImageButton imagebutton_button_ramchu_0;
    ImageButton imagebutton_button_dripper_0;
    ImageButton imagebutton_button_custodian_0;

    public CritterAtlasRootPage2Screen(CritterAtlasRootPage2Menu container, Inventory inventory, Component text) {
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
        if (mouseX > this.leftPos + 16 && mouseX < this.leftPos + 40 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_shadelet"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 47 && mouseX < this.leftPos + 71 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_treeplet"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 78 && mouseX < this.leftPos + 102 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_nervoid"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 109 && mouseX < this.leftPos + 133 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_corpse_crew"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 16 && mouseX < this.leftPos + 40 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_gravedigger"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 47 && mouseX < this.leftPos + 71 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_armossillo"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 78 && mouseX < this.leftPos + 102 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_ramchu"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 109 && mouseX < this.leftPos + 133 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_dripper"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 16 && mouseX < this.leftPos + 40 && mouseY > this.topPos + 72 && mouseY < this.topPos + 96) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page_2.tooltip_custodian"), mouseX, mouseY);
        }
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
        this.imagebutton_button_shadelet_0 = new LegacyImageButton(this.leftPos + 16, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_shadelet_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(0, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_shadelet_0", this.imagebutton_button_shadelet_0);
        this.addRenderableWidget(this.imagebutton_button_shadelet_0);
        this.imagebutton_button_treeplet_0 = new LegacyImageButton(this.leftPos + 47, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_treeplet_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(1, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_treeplet_0", this.imagebutton_button_treeplet_0);
        this.addRenderableWidget(this.imagebutton_button_treeplet_0);
        this.imagebutton_button_nervoid_0 = new LegacyImageButton(this.leftPos + 78, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_nervoid_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(2, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_nervoid_0", this.imagebutton_button_nervoid_0);
        this.addRenderableWidget(this.imagebutton_button_nervoid_0);
        this.imagebutton_button_corpse_crew_0 = new LegacyImageButton(this.leftPos + 109, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_corpse_crew_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(3, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_corpse_crew_0", this.imagebutton_button_corpse_crew_0);
        this.addRenderableWidget(this.imagebutton_button_corpse_crew_0);
        this.imagebutton_arrow_left_1 = new LegacyImageButton(this.leftPos + 6, this.topPos + 142, 18, 10, 0, 0, 10, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_arrow_left_1.png"), 18, 20, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(4, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_left_1", this.imagebutton_arrow_left_1);
        this.addRenderableWidget(this.imagebutton_arrow_left_1);
        this.imagebutton_button_gravedigger_0 = new LegacyImageButton(this.leftPos + 16, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_gravedigger_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(5, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_gravedigger_0", this.imagebutton_button_gravedigger_0);
        this.addRenderableWidget(this.imagebutton_button_gravedigger_0);
        this.imagebutton_button_armossillo_0 = new LegacyImageButton(this.leftPos + 47, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_armossillo_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(6, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 6, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_armossillo_0", this.imagebutton_button_armossillo_0);
        this.addRenderableWidget(this.imagebutton_button_armossillo_0);
        this.imagebutton_button_ramchu_0 = new LegacyImageButton(this.leftPos + 78, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_ramchu_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(7, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 7, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_ramchu_0", this.imagebutton_button_ramchu_0);
        this.addRenderableWidget(this.imagebutton_button_ramchu_0);
        this.imagebutton_button_dripper_0 = new LegacyImageButton(this.leftPos + 109, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_dripper_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(8, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 8, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_dripper_0", this.imagebutton_button_dripper_0);
        this.addRenderableWidget(this.imagebutton_button_dripper_0);
        this.imagebutton_button_custodian_0 = new LegacyImageButton(this.leftPos + 16, this.topPos + 71, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_custodian_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPage2ButtonMessage(9, this.x, this.y, this.z));
                CritterAtlasRootPage2ButtonMessage.handleButtonAction(this.entity, 9, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_custodian_0", this.imagebutton_button_custodian_0);
        this.addRenderableWidget(this.imagebutton_button_custodian_0);
    }
}
