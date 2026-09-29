package com.morecritters.mod.client.gui;

import com.morecritters.mod.client.gui.LegacyImageButton;
import com.morecritters.mod.client.gui.GuiEntityRenderer;
import net.neoforged.neoforge.network.PacketDistributor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.network.CritterAtlasCritterlingsButtonMessage;
import com.morecritters.mod.procedures.CritterlingShowup10Procedure;
import com.morecritters.mod.procedures.CritterlingShowup11Procedure;
import com.morecritters.mod.procedures.CritterlingShowup17Procedure;
import com.morecritters.mod.procedures.CritterlingShowup1Procedure;
import com.morecritters.mod.procedures.CritterlingShowup2Procedure;
import com.morecritters.mod.procedures.CritterlingShowup3Procedure;
import com.morecritters.mod.procedures.CritterlingShowup4Procedure;
import com.morecritters.mod.procedures.CritterlingShowup5Procedure;
import com.morecritters.mod.procedures.CritterlingShowup6Procedure;
import com.morecritters.mod.procedures.CritterlingShowup7Procedure;
import com.morecritters.mod.procedures.CritterlingShowup8Procedure;
import com.morecritters.mod.procedures.CritterlingShowup9Procedure;
import com.morecritters.mod.procedures.TickDisplayCubefrogProcedure;
import com.morecritters.mod.procedures.TickDisplayDominicProcedure;
import com.morecritters.mod.procedures.TickDisplayDungerProcedure;
import com.morecritters.mod.procedures.TickDisplayExpyProcedure;
import com.morecritters.mod.procedures.TickDisplayGillmunchProcedure;
import com.morecritters.mod.procedures.TickDisplayMothkidProcedure;
import com.morecritters.mod.procedures.TickDisplayOpalcrabProcedure;
import com.morecritters.mod.procedures.TickDisplayPlainswyrmProcedure;
import com.morecritters.mod.procedures.TickDisplayRollballProcedure;
import com.morecritters.mod.procedures.TickDisplayScowlProcedure;
import com.morecritters.mod.procedures.TickDisplaySnekProcedure;
import com.morecritters.mod.procedures.TickDisplayStalkProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasCritterlingsMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CritterAtlasCritterlingsScreen extends AbstractContainerScreen<CritterAtlasCritterlingsMenu> {
    private static final HashMap<String, Object> guistate = CritterAtlasCritterlingsMenu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    ImageButton imagebutton_arrow_left_1;
    ImageButton imagebutton_arrow_right_11;

    public CritterAtlasCritterlingsScreen(CritterAtlasCritterlingsMenu container, Inventory inventory, Component text) {
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
        if (CritterlingShowup1Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 168,
                this.topPos + 26,
                30,
                0.0F + (float)Math.atan((this.leftPos + 168 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + -23 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup2Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 209,
                this.topPos + 26,
                30,
                0.0F + (float)Math.atan((this.leftPos + 209 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + -23 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup3Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 250,
                this.topPos + 28,
                30,
                0.0F + (float)Math.atan((this.leftPos + 250 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + -21 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup4Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 168,
                this.topPos + 62,
                30,
                0.0F + (float)Math.atan((this.leftPos + 168 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 13 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup5Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 209,
                this.topPos + 65,
                30,
                0.0F + (float)Math.atan((this.leftPos + 209 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 16 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup6Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 250,
                this.topPos + 64,
                30,
                0.0F + (float)Math.atan((this.leftPos + 250 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 15 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup7Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 168,
                this.topPos + 97,
                30,
                0.0F + (float)Math.atan((this.leftPos + 168 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 48 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup8Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 209,
                this.topPos + 98,
                30,
                0.0F + (float)Math.atan((this.leftPos + 209 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 49 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup9Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 250,
                this.topPos + 100,
                30,
                0.0F + (float)Math.atan((this.leftPos + 250 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 51 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup10Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 168,
                this.topPos + 135,
                30,
                0.0F + (float)Math.atan((this.leftPos + 168 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 86 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup17Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 209,
                this.topPos + 135,
                30,
                0.0F + (float)Math.atan((this.leftPos + 209 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 86 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CritterlingShowup11Procedure.execute(this.world) instanceof LivingEntity livingEntity) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 250,
                this.topPos + 135,
                30,
                0.0F + (float)Math.atan((this.leftPos + 250 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 86 - mouseY) / 40.0),
                livingEntity
            );
        }

        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (mouseX > this.leftPos + 156 && mouseX < this.leftPos + 180 && mouseY > this.topPos + 8 && mouseY < this.topPos + 32) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_cubefrog_found_in_swamps"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 197 && mouseX < this.leftPos + 221 && mouseY > this.topPos + 8 && mouseY < this.topPos + 32) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbplainswyrm_ss7found_in_plains"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 238 && mouseX < this.leftPos + 262 && mouseY > this.topPos + 8 && mouseY < this.topPos + 32) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbdunger_ss7found_in_savannah_wa"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 156 && mouseX < this.leftPos + 180 && mouseY > this.topPos + 43 && mouseY < this.topPos + 67) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbsnek_ss7found_in_desert_wagon"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 197 && mouseX < this.leftPos + 221 && mouseY > this.topPos + 43 && mouseY < this.topPos + 67) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbexpy_ss7found_in_swamp_wagon"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 238 && mouseX < this.leftPos + 262 && mouseY > this.topPos + 43 && mouseY < this.topPos + 67) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbscowl_ss7found_in_snowy_wagon"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 156 && mouseX < this.leftPos + 180 && mouseY > this.topPos + 78 && mouseY < this.topPos + 102) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbrollbug_ss7found_in_swamps"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 197 && mouseX < this.leftPos + 221 && mouseY > this.topPos + 78 && mouseY < this.topPos + 102) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbopalcrab_ss7found_in_ocean_wag"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 238 && mouseX < this.leftPos + 262 && mouseY > this.topPos + 78 && mouseY < this.topPos + 102) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbmothkid_ss7found_in_taiga_wago"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 156 && mouseX < this.leftPos + 180 && mouseY > this.topPos + 113 && mouseY < this.topPos + 137) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbgillmunch_ss7found_in_ghost_sh"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 197 && mouseX < this.leftPos + 221 && mouseY > this.topPos + 113 && mouseY < this.topPos + 137) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbdominic_ss7found_in_closed_cri"), mouseX, mouseY
            );
        }

        if (mouseX > this.leftPos + 238 && mouseX < this.leftPos + 262 && mouseY > this.topPos + 113 && mouseY < this.topPos + 137) {
            guiGraphics.renderTooltip(
                this.font, Component.translatable("gui.more_critters.critter_atlas_critterlings.tooltip_ssbiolmer_ss7found_in_nauticrawl"), mouseX, mouseY
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
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 152, this.topPos + 5, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 193, this.topPos + 5, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 234, this.topPos + 5, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 152, this.topPos + 40, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 193, this.topPos + 40, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 234, this.topPos + 40, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 152, this.topPos + 75, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 193, this.topPos + 75, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"), this.leftPos + 234, this.topPos + 75, 0.0F, 0.0F, 32, 32, 32, 32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"),
            this.leftPos + 152,
            this.topPos + 110,
            0.0F,
            0.0F,
            32,
            32,
            32,
            32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"),
            this.leftPos + 193,
            this.topPos + 110,
            0.0F,
            0.0F,
            32,
            32,
            32,
            32
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/critterling_background.png"),
            this.leftPos + 234,
            this.topPos + 110,
            0.0F,
            0.0F,
            32,
            32,
            32,
            32
        );
        if (TickDisplayCubefrogProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 183, this.topPos + 26, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayPlainswyrmProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 224, this.topPos + 26, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayDungerProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 265, this.topPos + 26, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplaySnekProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 183, this.topPos + 61, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayExpyProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 224, this.topPos + 61, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayScowlProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 265, this.topPos + 61, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayRollballProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 183, this.topPos + 96, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayOpalcrabProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 224, this.topPos + 96, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayMothkidProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 265, this.topPos + 96, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayGillmunchProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 183, this.topPos + 131, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayStalkProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 224, this.topPos + 131, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        if (TickDisplayDominicProcedure.execute(this.entity)) {
            guiGraphics.blit(
                ResourceLocation.parse("more_critters:textures/screens/checkmark.png"), this.leftPos + 265, this.topPos + 131, 0.0F, 0.0F, 8, 11, 8, 11
            );
        }

        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/text_critterlings.png"), this.leftPos + 4, this.topPos + -3, 0.0F, 0.0F, 132, 152, 132, 152
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
                PacketDistributor.sendToServer(new CritterAtlasCritterlingsButtonMessage(0, this.x, this.y, this.z));
                CritterAtlasCritterlingsButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_left_1", this.imagebutton_arrow_left_1);
        this.addRenderableWidget(this.imagebutton_arrow_left_1);
        this.imagebutton_arrow_right_11 = new LegacyImageButton(this.leftPos + 259, this.topPos + 147, 18, 10, 0, 0, 10, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_arrow_right_11.png"), 18, 20, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCritterlingsButtonMessage(1, this.x, this.y, this.z));
                CritterAtlasCritterlingsButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_right_11", this.imagebutton_arrow_right_11);
        this.addRenderableWidget(this.imagebutton_arrow_right_11);
    }
}
