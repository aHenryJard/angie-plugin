package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.model.ItemGroup;
import hudson.model.Project;
import hudson.model.Run;
import hudson.model.TopLevelItem;
import hudson.model.TopLevelItemDescriptor;
import jenkins.model.Jenkins;

public class UnicornProject extends Project implements TopLevelItem {

    public UnicornProject(ItemGroup parent, String name) {
        super(parent, name);
    }

    @Override
    protected Class getBuildClass() {
        return null;
    }

    @Override
    protected void removeRun(Run run) {

    }

    @Override
    public TopLevelItemDescriptor getDescriptor() {
        return (UnicornProject.DescriptorImpl) Jenkins.get().getDescriptorOrDie(getClass());
    }

    @Extension
    public static class DescriptorImpl extends AbstractProjectDescriptor {
        @Override
        public TopLevelItem newInstance(ItemGroup parent, String name) {
            return new UnicornProject(parent, name);
        }

        @Override
        public String getDisplayName() {
            return "Vive les licornes !";
        }

    }
}
