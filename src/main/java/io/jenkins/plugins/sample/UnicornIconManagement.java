package io.jenkins.plugins.sample;

import javax.annotation.CheckForNull;
import javax.servlet.ServletException;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.interceptor.RequirePOST;
import edu.umd.cs.findbugs.annotations.NonNull;

import hudson.Extension;
import hudson.model.ManagementLink;
import hudson.util.FormApply;
import jenkins.model.Jenkins;

@Extension
public class UnicornIconManagement extends ManagementLink {

    @CheckForNull
    @Override
    public String getIconFileName() {
        return Unicorn.ICON_URL+"/rainbow-unicorn.png";
    }

    @CheckForNull
    @Override
    public String getDisplayName() {
        return "Administer your unicorn image";
    }

    @CheckForNull
    @Override
    public String getUrlName() {
        return "unicornIconManagement";
    }

    @Override
    public String getDescription() {
        return "Change your unicorn color !";
    }

    @RequirePOST
    public synchronized HttpResponse doConfigure(@NonNull StaplerRequest req) throws ServletException {

        String newIcon = req.getSubmittedForm().get("unicornIcon").toString();
        Unicorn myUnicorn = Jenkins.get().getExtensionList(Unicorn.class).get(0);
        myUnicorn.setIcon(newIcon);

        return FormApply.success(req.getContextPath() + "/manage" );
    }
}
