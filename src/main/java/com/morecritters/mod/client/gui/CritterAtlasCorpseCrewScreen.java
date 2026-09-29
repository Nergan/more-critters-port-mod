package com.morecritters.mod.client.gui;

import com.morecritters.mod.client.gui.LegacyImageButton;
import com.morecritters.mod.client.gui.GuiEntityRenderer;
import net.neoforged.neoforge.network.PacketDistributor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.network.CritterAtlasCorpseCrewButtonMessage;
import com.morecritters.mod.procedures.CorpseCaptainAtlasModelShowupProcedure;
import com.morecritters.mod.procedures.CorpseLookoutAtlasModelShowupProcedure;
import com.morecritters.mod.procedures.CorpseMateAtlasModelShowupProcedure;
import com.morecritters.mod.procedures.CorpseParrotAtlasModelShowupProcedure;
import com.morecritters.mod.procedures.CorpseQuartermasterAtlasModelShowupProcedure;
import com.morecritters.mod.procedures.CorpseShowup1Procedure;
import com.morecritters.mod.procedures.CorpseShowup2Procedure;
import com.morecritters.mod.procedures.CorpseShowup3Procedure;
import com.morecritters.mod.procedures.CorpseShowup4Procedure;
import com.morecritters.mod.procedures.CorpseShowup5Procedure;
import com.morecritters.mod.procedures.CorpseShowup6Procedure;
import com.morecritters.mod.procedures.CorpseTankAtlasModelShowupProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasCorpseCrewMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CritterAtlasCorpseCrewScreen extends AbstractContainerScreen<CritterAtlasCorpseCrewMenu> {
    private static final HashMap<String, Object> guistate = CritterAtlasCorpseCrewMenu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    ImageButton imagebutton_arrow_left_1;
    ImageButton imagebutton_arrow_right_1;
    ImageButton imagebutton_num_button1_0;
    ImageButton imagebutton_num_button2_0;
    ImageButton imagebutton_num_button3_0;
    ImageButton imagebutton_num_button4_0;
    ImageButton imagebutton_num_button5_0;
    ImageButton imagebutton_num_button_6_0;

    public CritterAtlasCorpseCrewScreen(CritterAtlasCorpseCrewMenu container, Inventory inventory, Component text) {
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
        if (CorpseMateAtlasModelShowupProcedure.execute(this.world) instanceof LivingEntity livingEntity && CorpseShowup1Procedure.execute(this.entity)) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 62,
                this.topPos + 83,
                30,
                0.0F + (float)Math.atan((this.leftPos + 62 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 34 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CorpseQuartermasterAtlasModelShowupProcedure.execute(this.world) instanceof LivingEntity livingEntity
            && CorpseShowup2Procedure.execute(this.entity)) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 62,
                this.topPos + 83,
                30,
                0.0F + (float)Math.atan((this.leftPos + 62 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 34 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CorpseTankAtlasModelShowupProcedure.execute(this.world) instanceof LivingEntity livingEntity && CorpseShowup3Procedure.execute(this.entity)) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 62,
                this.topPos + 83,
                30,
                0.0F + (float)Math.atan((this.leftPos + 62 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 34 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CorpseCaptainAtlasModelShowupProcedure.execute(this.world) instanceof LivingEntity livingEntity && CorpseShowup4Procedure.execute(this.entity)) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 62,
                this.topPos + 83,
                30,
                0.0F + (float)Math.atan((this.leftPos + 62 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 34 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CorpseParrotAtlasModelShowupProcedure.execute(this.world) instanceof LivingEntity livingEntity && CorpseShowup5Procedure.execute(this.entity)) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 62,
                this.topPos + 83,
                30,
                0.0F + (float)Math.atan((this.leftPos + 62 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 34 - mouseY) / 40.0),
                livingEntity
            );
        }

        if (CorpseLookoutAtlasModelShowupProcedure.execute(this.world) instanceof LivingEntity livingEntity && CorpseShowup6Procedure.execute(this.entity)) {
            GuiEntityRenderer.renderEntityInInventoryFollowsAngle(
                guiGraphics,
                this.leftPos + 62,
                this.topPos + 83,
                30,
                0.0F + (float)Math.atan((this.leftPos + 62 - mouseX) / 40.0),
                (float)Math.atan((this.topPos + 34 - mouseY) / 40.0),
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
            ResourceLocation.parse("more_critters:textures/screens/text_corpse_crew_1.png"), this.leftPos + 4, this.topPos + 104, 0.0F, 0.0F, 130, 44, 130, 44
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/text_corpse_crew_2.png"), this.leftPos + 144, this.topPos + 3, 0.0F, 0.0F, 130, 152, 130, 152
        );
        guiGraphics.blit(
            ResourceLocation.parse("more_critters:textures/screens/miniboss_critter_background.png"),
            this.leftPos + 7,
            this.topPos + -2,
            0.0F,
            0.0F,
            112,
            100,
            112,
            100
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
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(0, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_left_1", this.imagebutton_arrow_left_1);
        this.addRenderableWidget(this.imagebutton_arrow_left_1);
        this.imagebutton_arrow_right_1 = new LegacyImageButton(this.leftPos + 259, this.topPos + 147, 18, 10, 0, 0, 10, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_arrow_right_1.png"), 18, 20, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(1, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_right_1", this.imagebutton_arrow_right_1);
        this.addRenderableWidget(this.imagebutton_arrow_right_1);
        this.imagebutton_num_button1_0 = new LegacyImageButton(this.leftPos + 121, this.topPos + -1, 10, 12, 0, 0, 12, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_num_button1_0.png"), 10, 24, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(2, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_num_button1_0", this.imagebutton_num_button1_0);
        this.addRenderableWidget(this.imagebutton_num_button1_0);
        this.imagebutton_num_button2_0 = new LegacyImageButton(this.leftPos + 121, this.topPos + 13, 10, 12, 0, 0, 12, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_num_button2_0.png"), 10, 24, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(3, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_num_button2_0", this.imagebutton_num_button2_0);
        this.addRenderableWidget(this.imagebutton_num_button2_0);
        this.imagebutton_num_button3_0 = new LegacyImageButton(this.leftPos + 121, this.topPos + 27, 10, 12, 0, 0, 12, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_num_button3_0.png"), 10, 24, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(4, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_num_button3_0", this.imagebutton_num_button3_0);
        this.addRenderableWidget(this.imagebutton_num_button3_0);
        this.imagebutton_num_button4_0 = new LegacyImageButton(this.leftPos + 121, this.topPos + 55, 10, 12, 0, 0, 12, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_num_button4_0.png"), 10, 24, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(5, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_num_button4_0", this.imagebutton_num_button4_0);
        this.addRenderableWidget(this.imagebutton_num_button4_0);
        this.imagebutton_num_button5_0 = new LegacyImageButton(this.leftPos + 121, this.topPos + 69, 10, 12, 0, 0, 12, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_num_button5_0.png"), 10, 24, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(6, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 6, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_num_button5_0", this.imagebutton_num_button5_0);
        this.addRenderableWidget(this.imagebutton_num_button5_0);
        this.imagebutton_num_button_6_0 = new LegacyImageButton(this.leftPos + 121, this.topPos + 41, 10, 12, 0, 0, 12, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_num_button_6_0.png"), 10, 24, e -> {
                PacketDistributor.sendToServer(new CritterAtlasCorpseCrewButtonMessage(7, this.x, this.y, this.z));
                CritterAtlasCorpseCrewButtonMessage.handleButtonAction(this.entity, 7, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_num_button_6_0", this.imagebutton_num_button_6_0);
        this.addRenderableWidget(this.imagebutton_num_button_6_0);
    }
}
