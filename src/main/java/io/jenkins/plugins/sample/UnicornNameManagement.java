package io.jenkins.plugins.sample;

import javax.annotation.CheckForNull;
import javax.servlet.ServletException;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.StaplerProxy;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.interceptor.RequirePOST;

import edu.umd.cs.findbugs.annotations.NonNull;

import hudson.Extension;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.ManagementLink;
import hudson.security.Permission;
import hudson.util.FormApply;
import jenkins.model.Jenkins;

@Extension
public class UnicornNameManagement extends ManagementLink {

    @CheckForNull
    @Override
    public String getIconFileName() {
        return Unicorn.ICON_URL+"/blue-unicorn.png";
    }

    @CheckForNull
    @Override
    public String getDisplayName() {
        return "Configure your unicorn name.";
    }

    @CheckForNull
    @Override
    public String getUrlName() {
        return "unicornNameManagement";
    }

    @Override
    public String getDescription() {
        return "Pick a sweet name for your unicorn !";
    }

    @RequirePOST
    public synchronized HttpResponse doConfigure(@NonNull StaplerRequest req) throws ServletException {

        String newName = req.getSubmittedForm().get("sweetName").toString();
        Unicorn myUnicorn = Jenkins.get().getExtensionList(Unicorn.class).get(0);
        myUnicorn.setName(newName);

        return FormApply.success(req.getContextPath() + "/manage" );
    }

    @CheckForNull
    @Override
    public Permission getRequiredPermission() {
        return Jenkins.CONFIGURE;
    }
}
