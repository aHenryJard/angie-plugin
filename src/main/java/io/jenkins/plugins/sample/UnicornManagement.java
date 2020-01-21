package io.jenkins.plugins.sample;

import javax.annotation.CheckForNull;

import org.jenkinsci.Symbol;

import hudson.Extension;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.ManagementLink;
import jenkins.model.Jenkins;

@Symbol("unicorn")
@Extension
public class UnicornManagement extends ManagementLink implements Describable<UnicornManagement> {

    @CheckForNull
    @Override
    public String getIconFileName() {
        return "/plugin/angie-unicorn/images/48x48/unicorn.png";
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

    @Override
    public Descriptor<UnicornManagement> getDescriptor() {
        return Jenkins.get().getDescriptorOrDie(getClass());
    }

    @Extension
    public static final class DescriptorImpl extends Descriptor<UnicornManagement> {
        /**
         * {@inheritDoc}
         */
        @Override
        public String getDisplayName() {
            return "Unicorn !";
        }
    }
}
