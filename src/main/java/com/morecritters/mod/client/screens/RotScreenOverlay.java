package com.morecritters.mod.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.morecritters.mod.procedures.RotScreenDisplayOverlayIngameProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RenderGuiEvent.Pre;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(Dist.CLIENT)
public class RotScreenOverlay {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(Pre event) {
        int w = event.getGuiGraphics().guiWidth();
        int h = event.getGuiGraphics().guiHeight();
        Level world = null;
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Player entity = Minecraft.getInstance().player;
        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }

        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        if (RotScreenDisplayOverlayIngameProcedure.execute(entity)) {
            event.getGuiGraphics()
                .blit(ResourceLocation.parse("more_critters:textures/screens/rot_splatter1.png"), w / 2 + -221, h / 2 + -129, 0.0F, 0.0F, 200, 200, 200, 200);
            event.getGuiGraphics()
                .blit(ResourceLocation.parse("more_critters:textures/screens/rot_splatter2.png"), w / 2 + 21, h / 2 + -118, 0.0F, 0.0F, 200, 200, 200, 200);
            event.getGuiGraphics()
                .blit(ResourceLocation.parse("more_critters:textures/screens/rot_splatter3.png"), w / 2 + -86, h / 2 + -74, 0.0F, 0.0F, 200, 200, 200, 200);
        }

        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
