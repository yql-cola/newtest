package �ļ�����������;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class RenameTool extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 9068225199875097200L;
    private JPanel contentPane;
    private JTextField selectTextField;
    private JTextField beforeCutTextField;
    private JTextField afterCutTextField;
    private JTextField beforeReplaceTextField;
    private JTextField afterReplaceTextField;
    private JTextField fileTypeTextField;
    private JCheckBox choiceCheckBox;
    private JButton renameButton;
    private File[] selectFiles;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RenameTool frame = new RenameTool();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RenameTool() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel controlPanel = new JPanel();
        contentPane.add(controlPanel, BorderLayout.NORTH);
        controlPanel.setLayout(new GridLayout(4, 1, 5, 5));

        JPanel selectPanel = new JPanel();
        controlPanel.add(selectPanel);

        JLabel selectLabel = new JLabel("ѡ����ļ��У�");
        selectPanel.add(selectLabel);

        selectTextField = new JTextField();
        selectPanel.add(selectTextField);
        selectTextField.setColumns(18);

        JButton selectButton = new JButton("ѡ���ļ���");
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_selectButton_actionPerformed(e);
            }
        });
        selectPanel.add(selectButton);

        JPanel cutPanel = new JPanel();
        controlPanel.add(cutPanel);

        JLabel beforeCutLabel = new JLabel("��ȡǰ�ַ���");
        cutPanel.add(beforeCutLabel);

        beforeCutTextField = new JTextField();
        cutPanel.add(beforeCutTextField);
        beforeCutTextField.setColumns(10);

        JLabel afterCutLabel = new JLabel("��ȡ���ַ���");
        cutPanel.add(afterCutLabel);

        afterCutTextField = new JTextField();
        cutPanel.add(afterCutTextField);
        afterCutTextField.setColumns(10);

        JPanel replacePanel = new JPanel();
        controlPanel.add(replacePanel);

        JLabel beforeReplaceLabel = new JLabel("�滻ǰ�ַ���");
        replacePanel.add(beforeReplaceLabel);

        beforeReplaceTextField = new JTextField();
        replacePanel.add(beforeReplaceTextField);
        beforeReplaceTextField.setColumns(10);

        JLabel afterReplaceLabel = new JLabel("�滻���ַ���");
        replacePanel.add(afterReplaceLabel);

        afterReplaceTextField = new JTextField();
        replacePanel.add(afterReplaceTextField);
        afterReplaceTextField.setColumns(10);

        JPanel otherPanel = new JPanel();
        controlPanel.add(otherPanel);

        JLabel fileTypeLabel = new JLabel("�ļ����ͣ�");
        otherPanel.add(fileTypeLabel);

        fileTypeTextField = new JTextField();
        otherPanel.add(fileTypeTextField);
        fileTypeTextField.setColumns(17);

        choiceCheckBox = new JCheckBox("Ԥ��");
        choiceCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                do_choiceCheckBox_itemStateChanged(e);
            }
        });
        otherPanel.add(choiceCheckBox);

        renameButton = new JButton("Ԥ��");
        renameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_renameButton_actionPerformed(e);
            }
        });
        otherPanel.add(renameButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }

    protected void do_selectButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File directory = chooser.getSelectedFile();
            selectTextField.setText(directory.getAbsolutePath());
            selectFiles = directory.listFiles();
            for (File selectFile : selectFiles) {
                textArea.append(selectFile.getAbsolutePath() + "\n\r");
            }
        }
    }

    protected void do_choiceCheckBox_itemStateChanged(ItemEvent e) {
        if (choiceCheckBox.isSelected()) {
            choiceCheckBox.setText("������");
            renameButton.setText("������");
        } else {
            choiceCheckBox.setText("Ԥ��");
            renameButton.setText("Ԥ��");
        }
    }

    protected void do_renameButton_actionPerformed(ActionEvent e) {
        String beforeCut = beforeCutTextField.getText();// ��ý�ȡǰ�ַ���
        String afterCut = afterCutTextField.getText();// ��ý�ȡ���ַ���
        String beforeReplace = beforeReplaceTextField.getText();// ����滻ǰ�ַ���
        String afterReplace = afterReplaceTextField.getText();// ����滻���ַ���
        String fileType = fileTypeTextField.getText();// ����ļ�����
        if (selectFiles == null) {
            JOptionPane.showMessageDialog(this, "��ѡ���ļ������ļ��У�", "������Ϣ", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (selectFiles.length == 0) {
            JOptionPane.showMessageDialog(this, "ѡ���ļ���Ϊ���ļ��У�", "������Ϣ", JOptionPane.WARNING_MESSAGE);
            return;
        }
        textArea.setText("");// ����ı���������
        for (File selectFile : selectFiles) {
            String fileName = selectFile.getName();// ����ļ���
            if (!beforeCut.isEmpty()) {
                int beforeCutIndex = fileName.indexOf(beforeCut);// ��ý�ȡǰ�ַ�������λ��
                fileName = fileName.substring(beforeCutIndex + beforeCut.length());// ��ȡ�ַ���
            }
            if (!afterCut.isEmpty()) {
                int afterCutIndex = fileName.lastIndexOf(afterCut);// ��ý�ȡ���ַ�������λ��
                fileName = fileName.substring(0, afterCutIndex);// ��ȡ�ַ���
                if (fileType.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "�������ļ����ͣ�", "������Ϣ", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    if (fileType.contains(".")) {// �ж��û�������ļ������Ƿ������.��
                        fileName = fileName.concat(fileName);// �����ļ�����
                    } else {
                        fileName = fileName.concat("." + fileType);// �����ļ�����
                    }
                }
            } else if (!fileType.isEmpty()) {
                int fileTypeindex = fileName.lastIndexOf(".");// ����ļ���������λ��
                fileName = fileName.substring(0, fileTypeindex);// ��ȡ�ļ�����
                if (fileType.contains(".")) {// �ж��û�������ļ������Ƿ������.��
                    fileName = fileName.concat(fileName);// �����ļ�����
                } else {
                    fileName = fileName.concat("." + fileType);// �����ļ�����
                }
            }
            if (!(beforeReplace.isEmpty() && afterReplace.isEmpty())) {
                fileName = fileName.replace(beforeReplace, afterReplace);// �滻�ַ���
            }

            fileName = selectFile.getParent() + File.separator + fileName;// ����޸ĺ���ļ���
            if (choiceCheckBox.isSelected()) {
                textArea.append(fileName + "\n\r");// ���ı�������ʾ�������Ľ��
                selectFile.renameTo(new File(fileName));// �������ļ�
            } else {
                textArea.append(fileName + "\n\r");// �������ļ�

            }
        }
    }
}
