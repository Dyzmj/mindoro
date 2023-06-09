package top.dyzmj.mindoro.tab;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.tabs.JBTabs;
import com.intellij.ui.tabs.TabInfo;
import com.intellij.ui.tabs.impl.JBTabsImpl;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class JBTabDialogWrapper extends DialogWrapper {

    private final Project project;

    public JBTabDialogWrapper(Project project) {
        super(true);
        this.project = project;
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JBTabs tabs = new JBTabsImpl(project);
        JPanel firstTabPanel = new JPanel();
        firstTabPanel.add(new JLabel("First Tab"));
        TabInfo firstTabInfo = new TabInfo(firstTabPanel);
        firstTabInfo.setText("First Tab");

        tabs.addTab(firstTabInfo);

        JPanel secondTabPanel = new JPanel();
        secondTabPanel.add(new JLabel("Second Tab"));
        TabInfo secondTabInfo = new TabInfo(secondTabPanel);
        secondTabInfo.setText("Second Tab");

        tabs.addTab(secondTabInfo);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(tabs.getComponent(), BorderLayout.CENTER);
        return panel;
    }
}
