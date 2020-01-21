package io.jenkins.plugins.sample;

import org.kohsuke.stapler.StaplerProxy;

import hudson.Extension;

@Extension
public class Unicorn implements StaplerProxy {

    @Override
    public Object getTarget() {
        System.out.println("Get targeted unicorn");
        return this;
    }

}
