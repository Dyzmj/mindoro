package top.dyzmj.mindoro.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.ValidationInfo;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class CustomDialogWrapper extends DialogWrapper {

    private JTextField inputTextField;

    private CustomOkAction okAction;
    private DialogWrapperExitAction exitAction;

    public CustomDialogWrapper(){
        super(true);
        init();
        setTitle("Custom Dialog");
    }


    @Override
    protected @Nullable JComponent createCenterPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("This is custom dialog");
        label.setPreferredSize(new Dimension(100, 100));
        panel.add(label, BorderLayout.CENTER);
        inputTextField = new JTextField();
        panel.add(inputTextField, BorderLayout.NORTH);
        return panel;
    }

    @Override
    protected @Nullable ValidationInfo doValidate() {
        String text = inputTextField.getText();
        if (StringUtils.isNotBlank(text)){
            return new ValidationInfo("NPE check succ");
        }else {
            return new ValidationInfo("NPM check fail");
        }
    }

    @Override
    protected Action @NotNull [] createActions() {
        exitAction = new DialogWrapperExitAction("Custom cancel button", CANCEL_EXIT_CODE);
        okAction = new CustomOkAction();
        okAction.putValue(DialogWrapper.DEFAULT_ACTION, true);
        return new Action[]{okAction, exitAction};
    }

    protected class CustomOkAction extends DialogWrapperAction {

        protected CustomOkAction() {
            super("Custom OK Button");
        }



        @Override
        protected void doAction(ActionEvent e) {
            ValidationInfo validationInfo = doValidate();
            if (Objects.nonNull(validationInfo)){
                Messages.showMessageDialog(validationInfo.message,"check pass", Messages.getInformationIcon());
            }else {
                close(CANCEL_EXIT_CODE);
            }
        }
    }

}
