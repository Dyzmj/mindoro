package top.dyzmj.mindoro.splitter;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.JBSplitter;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class JBSplitterDialogWrapper extends DialogWrapper {

    private JBSplitter splitter;

    public JBSplitterDialogWrapper() {
        super(true);
        init();
        setTitle("JBSplitter");
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        splitter = new JBSplitter();
        JPanel firstPanel = new JPanel();
        firstPanel.add(new JLabel("First Panel"));
        firstPanel.setBorder(BorderFactory.createTitledBorder("First Panel"));
        splitter.setFirstComponent(firstPanel);

        JPanel secondPanel = new JPanel();
        secondPanel.add(new JLabel("Second Panel"));
        secondPanel.setBorder(BorderFactory.createTitledBorder("Second Panel"));
        splitter.setSecondComponent(secondPanel);


        splitter.setSplitterProportionKey("customProportionKey");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(splitter, BorderLayout.CENTER);
        return panel;
    }
}
