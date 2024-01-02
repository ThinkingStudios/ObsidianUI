package org.thinkingstudio.obsidianui.neoforge;


import net.neoforged.fml.common.Mod;
import org.thinkingstudio.obsidianui.ObsidianUI;

@Mod(ObsidianUI.MODID)
public class ObsidianUINeoForge {
    public ObsidianUINeoForge() {
        ObsidianUI.clientInit();
    }
}
