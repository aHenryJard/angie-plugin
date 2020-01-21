package io.jenkins.plugins.sample;

import javax.annotation.CheckForNull;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;

@Extension
public class Unicorn implements UnprotectedRootAction {

    public static final String ICON_URL = "/plugin/angie-unicorn/images/48x48/";
    public static final String FULL_URL = "/plugin/angie-unicorn/images/full/";
    private String iconFile = "rainbow-unicorn.png";
    private String name = "ChangeMyName";

    @CheckForNull
    @Override
    public String getIconFileName() {
        return ICON_URL+'/'+iconFile;
    }

    @CheckForNull
    @Override
    public String getDisplayName() {
        return name;
    }

    @CheckForNull
    @Override
    public String getUrlName() {
        return "unicorn";
    }

    public String getImage() {
        return FULL_URL+'/'+iconFile;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setIcon(String newIcon) {
        this.iconFile = newIcon;
    }
}
