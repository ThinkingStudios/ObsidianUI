package org.thinkingstudio.obsidianui.neoforge;


import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import org.thinkingstudio.obsidianui.ObsidianUI;

@Mod(ObsidianUI.MODID)
public class ObsidianUINeoForge {
    public ObsidianUINeoForge() {
        if (FMLLoader.getDist().isClient()) {
            ObsidianUI.clientInit();
        }
    }
}
