package com.morecritters.mod.client.gui;

import com.morecritters.mod.client.gui.LegacyImageButton;
import com.morecritters.mod.client.gui.GuiEntityRenderer;
import net.neoforged.neoforge.network.PacketDistributor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.network.CritterAtlasBalloonRatButtonMessage;
import com.morecritters.mod.procedures.BalloonRatAtlasModelShowupProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasBalloonRatMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CritterAtlasBalloonRatScreen extends AbstractContainerScreen<CritterAtlasBalloonRatMenu> {
    private static final HashMap<String, Object> guistate = CritterAtlasBalloonRatMenu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    ImageButton imagebutton_arrow_left_1;
    ImageButton imagebutton_arrow_right_1;

    public CritterAtlasBalloonRatScreen(CritterAtlasBalloonRatMenu container, Inventory inventory, Component text) {
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
        if (BalloonRatAtlasModelShowupProcedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 61,
                this.topPos + 69,
                35,
                0.0F + (float)Math.atan((this.leftPos + 61 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 20 - mouseY) / 40.0),
                livingEntity
            );
        }

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
            ResourceLocation.parse("more_critters:textures/screens/regular_critter_background.png"),
            this.leftPos + 7,
            this.topPos + -2,
            0.0F,
            0.0F,
            112,
            100,
            112,
            100
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/text_balloon_rat_1.png"), this.leftPos + 4, this.topPos + 104, 0.0F, 0.0F, 130, 44, 130, 44
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/text_balloon_rat_2.png"), this.leftPos + 146, this.topPos + 2, 0.0F, 0.0F, 130, 152, 130, 152
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
                PacketDistributor.sendToServer(new CritterAtlasBalloonRatButtonMessage(0, this.x, this.y, this.z));
                CritterAtlasBalloonRatButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_left_1", this.imagebutton_arrow_left_1);
        this.addRenderableWidget(this.imagebutton_arrow_left_1);
        this.imagebutton_arrow_right_1 = new LegacyImageButton(this.leftPos + 259, this.topPos + 147, 18, 10, 0, 0, 10, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_arrow_right_1.png"), 18, 20, e -> {
                PacketDistributor.sendToServer(new CritterAtlasBalloonRatButtonMessage(1, this.x, this.y, this.z));
                CritterAtlasBalloonRatButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_right_1", this.imagebutton_arrow_right_1);
        this.addRenderableWidget(this.imagebutton_arrow_right_1);
    }
}
