package com.morecritters.mod.client.gui;

import com.morecritters.mod.client.gui.LegacyImageButton;
import net.neoforged.neoforge.network.PacketDistributor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.network.CritterAtlasRootPageButtonMessage;
import com.morecritters.mod.world.inventory.CritterAtlasRootPageMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CritterAtlasRootPageScreen extends AbstractContainerScreen<CritterAtlasRootPageMenu> {
    private static final HashMap<String, Object> guistate = CritterAtlasRootPageMenu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    ImageButton imagebutton_button_bunbug_0;
    ImageButton imagebutton_button_snowflake_spider_0;
    ImageButton imagebutton_button_shriekbat_0;
    ImageButton imagebutton_button_creeblossom_0;
    ImageButton imagebutton_button_bouncelizard_0;
    ImageButton imagebutton_button_stincarp_0;
    ImageButton imagebutton_button_balloon_rat_0;
    ImageButton imagebutton_button_warptrap_0;
    ImageButton imagebutton_button_shimmerwing_0;
    ImageButton imagebutton_button_mightshroom_0;
    ImageButton imagebutton_button_bomb_jelly_1;
    ImageButton imagebutton_button_avoider_1;
    ImageButton imagebutton_button_iropod_1;
    ImageButton imagebutton_button_blubberfish_1;
    ImageButton imagebutton_button_kelpire_1;
    ImageButton imagebutton_button_nauticrawl_1;
    ImageButton imagebutton_arrow_right_1;
    ImageButton imagebutton_button_critterling_0;
    ImageButton imagebutton_partyhat_icon1;

    public CritterAtlasRootPageScreen(CritterAtlasRootPageMenu container, Inventory inventory, Component text) {
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
        if (mouseX > this.leftPos + 149 && mouseX < this.leftPos + 173 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_bunbug"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 179 && mouseX < this.leftPos + 203 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_snowflake_spider"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 209 && mouseX < this.leftPos + 233 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_shriekbat"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 239 && mouseX < this.leftPos + 263 && mouseY > this.topPos + 12 && mouseY < this.topPos + 36) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_creeblossom"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 149 && mouseX < this.leftPos + 173 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_bouncelizard"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 179 && mouseX < this.leftPos + 203 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_stincarp"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 209 && mouseX < this.leftPos + 233 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_balloon_rat"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 239 && mouseX < this.leftPos + 263 && mouseY > this.topPos + 42 && mouseY < this.topPos + 66) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_warptrap"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 149 && mouseX < this.leftPos + 173 && mouseY > this.topPos + 72 && mouseY < this.topPos + 96) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_shimmerwing"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 179 && mouseX < this.leftPos + 203 && mouseY > this.topPos + 72 && mouseY < this.topPos + 96) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_mightshroom"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 209 && mouseX < this.leftPos + 233 && mouseY > this.topPos + 72 && mouseY < this.topPos + 96) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_bomb_jelly"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 239 && mouseX < this.leftPos + 263 && mouseY > this.topPos + 72 && mouseY < this.topPos + 96) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_avoider"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 149 && mouseX < this.leftPos + 173 && mouseY > this.topPos + 103 && mouseY < this.topPos + 127) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_iropod"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 179 && mouseX < this.leftPos + 203 && mouseY > this.topPos + 103 && mouseY < this.topPos + 127) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_blubberfish"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 209 && mouseX < this.leftPos + 233 && mouseY > this.topPos + 103 && mouseY < this.topPos + 127) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_kelpire"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 239 && mouseX < this.leftPos + 263 && mouseY > this.topPos + 103 && mouseY < this.topPos + 127) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_nauticrawl"), mouseX, mouseY);
        }

        if (mouseX > this.leftPos + 146 && mouseX < this.leftPos + 170 && mouseY > this.topPos + 131 && mouseY < this.topPos + 155) {
            guiGraphics.renderTooltip(this.font, Component.translatable("gui.more_critters.critter_atlas_root_page.tooltip_critterlings"), mouseX, mouseY);
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
            ResourceLocation.parse("more_critters:textures/screens/text_root.png"), this.leftPos + 6, this.topPos + 3, 0.0F, 0.0F, 130, 152, 130, 152
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
        this.imagebutton_button_bunbug_0 = new LegacyImageButton(this.leftPos + 149, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_bunbug_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(0, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_bunbug_0", this.imagebutton_button_bunbug_0);
        this.addRenderableWidget(this.imagebutton_button_bunbug_0);
        this.imagebutton_button_snowflake_spider_0 = new LegacyImageButton(this.leftPos + 179, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_snowflake_spider_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(1, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_snowflake_spider_0", this.imagebutton_button_snowflake_spider_0);
        this.addRenderableWidget(this.imagebutton_button_snowflake_spider_0);
        this.imagebutton_button_shriekbat_0 = new LegacyImageButton(this.leftPos + 209, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_shriekbat_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(2, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_shriekbat_0", this.imagebutton_button_shriekbat_0);
        this.addRenderableWidget(this.imagebutton_button_shriekbat_0);
        this.imagebutton_button_creeblossom_0 = new LegacyImageButton(this.leftPos + 239, this.topPos + 11, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_creeblossom_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(3, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_creeblossom_0", this.imagebutton_button_creeblossom_0);
        this.addRenderableWidget(this.imagebutton_button_creeblossom_0);
        this.imagebutton_button_bouncelizard_0 = new LegacyImageButton(this.leftPos + 149, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_bouncelizard_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(4, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_bouncelizard_0", this.imagebutton_button_bouncelizard_0);
        this.addRenderableWidget(this.imagebutton_button_bouncelizard_0);
        this.imagebutton_button_stincarp_0 = new LegacyImageButton(this.leftPos + 179, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_stincarp_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(5, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_stincarp_0", this.imagebutton_button_stincarp_0);
        this.addRenderableWidget(this.imagebutton_button_stincarp_0);
        this.imagebutton_button_balloon_rat_0 = new LegacyImageButton(this.leftPos + 209, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_balloon_rat_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(6, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 6, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_balloon_rat_0", this.imagebutton_button_balloon_rat_0);
        this.addRenderableWidget(this.imagebutton_button_balloon_rat_0);
        this.imagebutton_button_warptrap_0 = new LegacyImageButton(this.leftPos + 239, this.topPos + 41, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_warptrap_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(7, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 7, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_warptrap_0", this.imagebutton_button_warptrap_0);
        this.addRenderableWidget(this.imagebutton_button_warptrap_0);
        this.imagebutton_button_shimmerwing_0 = new LegacyImageButton(this.leftPos + 149, this.topPos + 71, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_shimmerwing_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(8, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 8, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_shimmerwing_0", this.imagebutton_button_shimmerwing_0);
        this.addRenderableWidget(this.imagebutton_button_shimmerwing_0);
        this.imagebutton_button_mightshroom_0 = new LegacyImageButton(this.leftPos + 179, this.topPos + 71, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_mightshroom_0.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(9, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 9, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_mightshroom_0", this.imagebutton_button_mightshroom_0);
        this.addRenderableWidget(this.imagebutton_button_mightshroom_0);
        this.imagebutton_button_bomb_jelly_1 = new LegacyImageButton(this.leftPos + 209, this.topPos + 71, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_bomb_jelly_1.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(10, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 10, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_bomb_jelly_1", this.imagebutton_button_bomb_jelly_1);
        this.addRenderableWidget(this.imagebutton_button_bomb_jelly_1);
        this.imagebutton_button_avoider_1 = new LegacyImageButton(this.leftPos + 239, this.topPos + 71, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_avoider_1.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(11, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 11, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_avoider_1", this.imagebutton_button_avoider_1);
        this.addRenderableWidget(this.imagebutton_button_avoider_1);
        this.imagebutton_button_iropod_1 = new LegacyImageButton(this.leftPos + 149, this.topPos + 102, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_iropod_1.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(12, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 12, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_iropod_1", this.imagebutton_button_iropod_1);
        this.addRenderableWidget(this.imagebutton_button_iropod_1);
        this.imagebutton_button_blubberfish_1 = new LegacyImageButton(this.leftPos + 179, this.topPos + 102, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_blubberfish_1.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(13, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 13, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_blubberfish_1", this.imagebutton_button_blubberfish_1);
        this.addRenderableWidget(this.imagebutton_button_blubberfish_1);
        this.imagebutton_button_kelpire_1 = new LegacyImageButton(this.leftPos + 209, this.topPos + 102, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_kelpire_1.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(14, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 14, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_kelpire_1", this.imagebutton_button_kelpire_1);
        this.addRenderableWidget(this.imagebutton_button_kelpire_1);
        this.imagebutton_button_nauticrawl_1 = new LegacyImageButton(this.leftPos + 239, this.topPos + 102, 24, 26, 0, 0, 26, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_nauticrawl_1.png"), 24, 52, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(15, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 15, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_nauticrawl_1", this.imagebutton_button_nauticrawl_1);
        this.addRenderableWidget(this.imagebutton_button_nauticrawl_1);
        this.imagebutton_arrow_right_1 = new LegacyImageButton(this.leftPos + 254, this.topPos + 141, 18, 10, 0, 0, 10, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_arrow_right_1.png"), 18, 20, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(16, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 16, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_arrow_right_1", this.imagebutton_arrow_right_1);
        this.addRenderableWidget(this.imagebutton_arrow_right_1);
        this.imagebutton_button_critterling_0 = new LegacyImageButton(this.leftPos + 149, this.topPos + 133, 17, 19, 0, 0, 19, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_button_critterling_0.png"), 17, 38, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(17, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 17, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_button_critterling_0", this.imagebutton_button_critterling_0);
        this.addRenderableWidget(this.imagebutton_button_critterling_0);
        this.imagebutton_partyhat_icon1 = new LegacyImageButton(this.leftPos + -11, this.topPos + -13, 17, 17, 0, 0, 17, ResourceLocation.parse("more_critters:textures/screens/atlas/imagebutton_partyhat_icon1.png"), 17, 34, e -> {
                PacketDistributor.sendToServer(new CritterAtlasRootPageButtonMessage(18, this.x, this.y, this.z));
                CritterAtlasRootPageButtonMessage.handleButtonAction(this.entity, 18, this.x, this.y, this.z);
            });
        guistate.put("button:imagebutton_partyhat_icon1", this.imagebutton_partyhat_icon1);
        this.addRenderableWidget(this.imagebutton_partyhat_icon1);
    }
}
