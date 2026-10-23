package com.morecritters.mod.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftScreenMixin {
    @Unique
    private Screen morecritters$deferredAtlasClose;

    @Unique
    private boolean morecritters$closingAtlas;

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    private void morecritters$deferAtlasClose(Screen next, CallbackInfo ci) {
        if (this.morecritters$closingAtlas) {
            return;
        }
        Minecraft minecraft = (Minecraft) (Object) this;
        if (next != null || !morecritters$isAtlas(minecraft.screen)) {
            return;
        }
        if (this.morecritters$deferredAtlasClose != null) {
            ci.cancel();
            return;
        }
        Screen open = minecraft.screen;
        this.morecritters$deferredAtlasClose = open;
        ci.cancel();
        minecraft.execute(() -> {
            Screen pending = this.morecritters$deferredAtlasClose;
            this.morecritters$deferredAtlasClose = null;
            if (pending != null && minecraft.screen == pending) {
                this.morecritters$closingAtlas = true;
                try {
                    minecraft.setScreen(null);
                } finally {
                    this.morecritters$closingAtlas = false;
                }
            }
        });
    }

    @Unique
    private static boolean morecritters$isAtlas(Screen screen) {
        return screen != null && screen.getClass().getName().startsWith("com.morecritters.mod.client.gui.CritterAtlas");
    }
}
