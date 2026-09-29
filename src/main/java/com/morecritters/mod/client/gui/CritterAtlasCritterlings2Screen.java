package com.morecritters.mod.client.gui;

import com.morecritters.mod.client.gui.LegacyImageButton;
import com.morecritters.mod.client.gui.GuiEntityRenderer;
import net.neoforged.neoforge.network.PacketDistributor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.network.CritterAtlasCritterlings2ButtonMessage;
import com.morecritters.mod.procedures.CritterlingShowup12Procedure;
import com.morecritters.mod.procedures.CritterlingShowup13Procedure;
import com.morecritters.mod.procedures.CritterlingShowup14Procedure;
import com.morecritters.mod.procedures.CritterlingShowup15Procedure;
import com.morecritters.mod.procedures.CritterlingShowup16Procedure;
import com.morecritters.mod.procedures.TickDisplayFlargProcedure;
import com.morecritters.mod.procedures.TickDisplayFresnoidProcedure;
import com.morecritters.mod.procedures.TickDisplayMangotriceProcedure;
import com.morecritters.mod.procedures.TickDisplayOlmerProcedure;
import com.morecritters.mod.procedures.TickDisplayPiranheedProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasCritterlings2Menu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CritterAtlasCritterlings2Screen extends AbstractContainerScreen<CritterAtlasCritterlings2Menu> {
    private static final HashMap<String, Object> guistate = CritterAtlasCritterlings2Menu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    ImageButton imagebutton_arrow_left_1;

    public CritterAtlasCritterlings2Screen(CritterAtlasCritterlings2Menu container, Inventory inventory, Component text) {
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
        if (CritterlingShowup12Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 31,
                this.topPos + 30,
                30,
                0.0F + (float)Math.atan((this.leftPos + 31 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + -19 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup13Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 71,
                this.topPos + 29,
                30,
                0.0F + (float)Math.atan((this.leftPos + 71 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + -20 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup14Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 113,
                this.topPos + 30,
                30,
                0.0F + (float)Math.atan((this.leftPos + 113 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + -19 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup15Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 31,
                this.topPos + 65,
                30,
                0.0F + (float)Math.atan((this.leftPos + 31 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 16 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup16Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 72,
                this.topPos + 65,
                30,
                0.0F + (float)Math.atan((this.leftPos + 72 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 16 - mouseY) / 40.0),
                livingEntity
            );
        }

        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (mouseX > this.leftPos + 19 && mouseX < this.leftPos + 43 && mouseY > this.topPos + 8 && mouseY < this.topPos + 32) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings_2.tooltip_ssbolmer_ss7found_in"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 60 && mouseX < this.leftPos + 84 && mouseY > this.topPos + 8 && mouseY < this.topPos + 32) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings_2.tooltip_ssbflarg_ss7found_in"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 101 && mouseX < this.leftPos + 125 && mouseY > this.topPos + 8 && mouseY < this.topPos + 32) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings_2.tooltip_ssbpiranheed_ss7found_in"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 19 && mouseX < this.leftPos + 43 && mouseY > this.topPos + 43 && mouseY < this.topPos + 67) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings_2.tooltip_ssbmangotrice_ss7found_in"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 60 && mouseX < this.leftPos + 84 && mouseY > this.topPos + 43 && mouseY < this.topPos + 67) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings_2.tooltip_ssbfresnoid_ss7found_in"), mouseX, mouseY
            );
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
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 15, this.topPos + 5, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 56, this.topPos + 5, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 97, this.topPos + 5, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 15, this.topPos + 40, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 56, this.topPos + 40, 0.0F, 0.0F, 32, 32, 32, 32
        );
        if (TickDisplayOlmerProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 46, this.topPos + 26, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayFlargProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 87, this.topPos + 26, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayPiranheedProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 128, this.topPos + 26, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayMangotriceProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 46, this.topPos + 61, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayFresnoidProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 87, this.topPos + 61, 0.0F, 0.0F, 8, 11, 8, 11
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
    }

    @Override
    public void init() {
        super.init();
        this.imagebutton_arrow_left_1 = new LegacyImageButton(this.leftPos + 2, this.topPos + 147, 18, 10, 0, 0, 10, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_arrow_left_1.png"), 18, 20, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCritterlings2ButtonMessage(0, this.x, this.y, this.z));
                CritterAtlasCritterlings2ButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_left_1", this.imagebutton_arrow_left_1);
        this.addRenderableWidget(this.imagebutton_arrow_left_1);
    }
}
