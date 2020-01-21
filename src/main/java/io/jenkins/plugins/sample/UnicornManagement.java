package io.jenkins.plugins.sample;

import javax.annotation.CheckForNull;

import org.jenkinsci.Symbol;

import hudson.Extension;
import hudson.model.ManagementLink;

@Symbol("unicorn")
@Extension
public class UnicornManagement extends ManagementLink {

    @CheckForNull
    @Override
    public String getIconFileName() {
        return "help.png";
    }

    @CheckForNull
    @Override
    public String getDisplayName() {
        return "Unicorn";
    }

    @CheckForNull
    @Override
    public String getUrlName() {
        return "/unicorn";
    }

    @Override
    public String getDescription() {
        return "Because the world needs more unicorns !";
    }
}
