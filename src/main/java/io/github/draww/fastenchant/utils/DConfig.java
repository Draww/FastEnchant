package io.github.draww.fastenchant.utils;

import de.exlll.configlib.configs.yaml.BukkitYamlConfiguration;

import java.nio.file.Path;

public class DConfig extends BukkitYamlConfiguration {

    public DConfig(Path path) {
        super(path);
    }

    protected DConfig(Path path, BukkitYamlProperties properties) {
        super(path, properties);
    }

    public <T extends DConfig> T saveConfig() {
        this.save();
        return (T) this;
    }

    public <T extends DConfig> T loadAndSaveConfig() {
        this.loadAndSave();
        return (T) this;
    }

    public <T extends DConfig> T loadConfig() {
        this.load();
        return (T) this;
    }
}