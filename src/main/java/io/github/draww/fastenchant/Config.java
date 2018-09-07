package io.github.draww.fastenchant;

import de.exlll.configlib.annotation.Comment;
import io.github.draww.fastenchant.utils.DConfig;

import java.io.File;

public class Config extends DConfig {

    public Config(final FastEnchant plugin) {
        super(new File(plugin.getDataFolder(), "config.yml").toPath());
    }

    @Comment({
            "absolutely not recommended edit this option!",
            "if you want to update the config file, you can visit the project's github page."
    })
    private String config_version = "1";

    /* ------------------------------------------------------------------- */

    public String getVersion() {
        return config_version;
    }

    public void setVersion(String version) {
        this.config_version = version;
    }
}
