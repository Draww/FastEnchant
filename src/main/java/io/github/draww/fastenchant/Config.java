package io.github.draww.fastenchant;

import io.github.draww.fastenchant.utils.DConfig;

import java.io.File;

public class Config extends DConfig {

    public Config(final FastEnchant plugin) {
        super(new File(plugin.getDataFolder(), "config.yml").toPath());
    }

    private String config_version = "1";

    /* ------------------------------------------------------------------- */

    public String getVersion() {
        return config_version;
    }

    public void setVersion(String version) {
        this.config_version = version;
    }
}
