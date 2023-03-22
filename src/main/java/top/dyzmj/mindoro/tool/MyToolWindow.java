package top.dyzmj.mindoro.tool;

import com.intellij.openapi.wm.ToolWindow;
import top.dyzmj.mindoro.dialog.CustomDialogWrapper;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class MyToolWindow {

    private JButton hideButton;

    private JButton dialogButton;

    private JPanel myToolWindowContent;

    public MyToolWindow(ToolWindow toolWindow) {

        init();

        hideButton.addActionListener(e -> toolWindow.hide(null));
    }

    private void init() {
        JLabel datetimeLabel = new JLabel();
        datetimeLabel.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        dialogButton = new JButton("Event");
        dialogButton.addActionListener(e -> {
            if (new CustomDialogWrapper().showAndGet()) {
                System.out.println("show and get");
            }

        });

        hideButton = new JButton("Cancel");

        myToolWindowContent = new JPanel();
        myToolWindowContent.add(datetimeLabel);
        myToolWindowContent.add(dialogButton);
        myToolWindowContent.add(hideButton);
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }

}
