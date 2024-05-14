import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class ATM {
    public static long cash_fee_withdrawal = 56350000;
    public static char[] pass = "1234".toCharArray();
    public static JLabel cashlabel;

    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("Test3.jpg");
        JLabel BackGround = new JLabel("", image, JLabel.CENTER);
        BackGround.setBounds(0, 0, 700, 500);

        JFrame f = new JFrame("ATM"); // Frame
///////////////////////////  Initialize Pages ////////////////////////////////////////////
        JPanel pagelanguage = createPanel(0, 0, 700, 700, Color.CYAN, true);
        JPanel pagepassword = createPanel(0, 0, 700, 700, new Color(9, 93, 176), false);
        JPanel pagemain = createPanel(0, 0, 700, 700, Color.DARK_GRAY, false);
        JPanel changepasspage = createPanel(0, 0, 700, 700, new Color(9, 93, 176), false);
        JPanel cash = createPanel(0, 0, 700, 700,new Color(9, 93, 176), false);
        JPanel withdrawalpage = createPanel(0, 0, 700, 700, new Color(9, 93, 176), false);
        JPanel transferpage = createPanel(0, 0, 700, 700, new Color(9, 93, 176), false);
        JPanel lastpage = createPanel(0, 0, 700, 700, Color.BLACK, false);
////////////////////////////////////////////////////////////////////////////////////////////////////  Language Page  /////////////////////////////////////////////////////////////////

//////////////////////////////  English Button /////////////////////////////////////////
        JButton EnglishButton = createButton("English ", 0, 300, 100, 50, 16, Color.black, Color.lightGray);
        EnglishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagelanguage.setVisible(false);
                pagemain.setVisible(true);
            }
        });
////////////////////////////// Persian Language Button /////////////////////////////////////////
        JButton persianButton = createButton("فارسی ", 600, 300, 100, 50, 16, Color.black, Color.lightGray);
        persianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagelanguage.setVisible(false);
                pagepassword.setVisible(true);
            }
        });
///////////////////////////// Persian Language Text /////////////////////////////////////////
        JLabel persianLabel = createLabel(450, 315, 200, 20, "زبان خود را انتخاب کنید", Color.BLACK, 16);

//////////////////////////////  English Label /////////////////////////////////////////
        JLabel EnglishLabel = new JLabel();
        EnglishLabel.setBounds(110, 315, 200, 20);
        EnglishLabel.setText("Choose Language ");
        EnglishLabel.setForeground(Color.BLACK);
        EnglishLabel.setFont(new Font("Arial", Font.BOLD, 14));

////////////////////////////////////////////////////////////////////////////////////////////////////  Password Page  //////////////////////////////////////////////////

//////////////////////////////  Password Label /////////////////////////////////////////
        JLabel EnterPassLabel = createLabel(300, 200, 200, 20, "رمز خود را وارد کنید ", Color.WHITE, 20);

//////////////////////////////  Password Input Field /////////////////////////////////////////
        JPasswordField EnterPassField = new JPasswordField();
        EnterPassField.setBounds(300, 250, 150, 30);

////////////////////////////// Password Submit Button /////////////////////////////////////////
        JButton SubmitButton = createButton("ثبت ", 300, 620, 100, 50, 16, Color.WHITE, new Color(51, 131, 156));
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (EnterPassField.getPassword().length == 0)
                    JOptionPane.showMessageDialog(f, "رمز خود را وارد کنید", "رمز", JOptionPane.WARNING_MESSAGE);
                else if (!Arrays.equals(pass, EnterPassField.getPassword())) {
                    JOptionPane.showMessageDialog(f, "رمز اشتباه است ", "رمز", JOptionPane.WARNING_MESSAGE);
                } else {
                    pass = EnterPassField.getPassword();
                    pagepassword.setVisible(false);
                    pagemain.setVisible(true);

                }
            }
        });
////////////////////////////////////////////////////////////////////////////////////////////////////  Main Page  ////////////////////////////////////////////////////////////

//////////////////////////////  Change Pass Button /////////////////////////////////////////
        JButton ChangePass = createButton("تغییر رمز ", 570, 300, 110, 50, 16, Color.black, Color.lightGray);

        ChangePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                changepasspage.setVisible(true);
            }
        });
//////////////////////////////  Withdrawal Button /////////////////////////////////////////
        JButton withdrawal = createButton("برداشت وجه", 10, 300, 100, 50, 16, Color.black, Color.lightGray);
        withdrawal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                withdrawalpage.setVisible(true);
            }
        });

////////////////////////////// Inventory_announcement Button /////////////////////////////////////////
        JButton Inventory_announcement = createButton("اعلام موجودی ", 560, 400, 120, 50, 16, Color.black, Color.lightGray);
        Inventory_announcement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                cash.setVisible(true);
            }
        });

////////////////////////////// Transfer Money Button  /////////////////////////////////////////
        JButton transfer = createButton("کارت به کارت ", 10, 400, 120, 50, 16, Color.black, Color.lightGray);
        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                transferpage.setVisible(true);
            }
        });

////////////////////////////// Back to First Page Button  /////////////////////////////////////////
        JButton BacktoFirstPage = createButton("برگشت", 300, 600, 100, 50, 16, Color.black, new Color(51, 131, 156));
        BacktoFirstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                pagelanguage.setVisible(true);
            }
        });

//////////////////////////////////////////////////////////////////////////////////////////////////  Change Password page  ////////////////////////////////////////////////////////////

//////////////////////////////  New Password Label /////////////////////////////////////////
        JLabel EnterNewPassLabel = createLabel(300, 200, 220, 20, "رمز جدید خود را وارد کنید :", Color.white, 20);

//////////////////////////////  New Password Field /////////////////////////////////////////
        JPasswordField EnterNewPassField = new JPasswordField();
        EnterNewPassField.setBounds(320, 250, 150, 30);
//////////////////////////////  Submit New Pass Button /////////////////////////////////////////
        JButton submitnewpass = createButton("تایید", 280, 600, 100, 50, 16, Color.black, Color.lightGray);
        submitnewpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EnterNewPassField.getPassword().length == 0)
                    JOptionPane.showMessageDialog(f, "رمز جدید خود را وارد کنید", "رمز", JOptionPane.WARNING_MESSAGE);
                else if (Arrays.equals(pass, EnterNewPassField.getPassword())) {
                    JOptionPane.showMessageDialog(f, "رمز تکراری است !", "رمز", JOptionPane.WARNING_MESSAGE);
                } else {
                    pass = EnterNewPassField.getPassword();
                    changepasspage.setVisible(false);
                    lastpage.setVisible(true);
                }

            }
        });
//////////////////////////////  New Pass Page Back Button /////////////////////////////////////////
        JButton Backtolastpagenewpass = createButton("برگشت", 380, 600, 100, 50, 16, Color.black, new Color(51, 131, 156));
        Backtolastpagenewpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changepasspage.setVisible(false);
                pagemain.setVisible(true);

            }
        });
/////////////////////////////////////////////////////////////////////////////////////  Withdrawal Page  /////////////////////////////////////////////////////

//////////////////////////////  Withdrawal Field Input /////////////////////////////////////////
        JTextField withdrawalfield = new JTextField();
        withdrawalfield.setBounds(300, 250, 150, 30);

//////////////////////////////  Withdrawal Submit Button /////////////////////////////////////////
        JButton withdrawalsubmit = createButton("تایید", 250, 600, 110, 50, 16, Color.black, Color.lightGray);
        withdrawalsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (withdrawalfield.getText().isEmpty())
                    JOptionPane.showMessageDialog(f, "مبلغ مورد نظر را وارد کنید :", "ّبرداشت", JOptionPane.WARNING_MESSAGE);
                else {
                    if (cash_fee_withdrawal - Long.parseLong(withdrawalfield.getText()) < 0)
                        JOptionPane.showMessageDialog(f, "موجودی کافی نیست !", "موجودی", JOptionPane.WARNING_MESSAGE);
                    else {
                        withdrawalpage.setVisible(false);
                        lastpage.setVisible(true);
                        String withdrawalamoutstr = withdrawalfield.getText();
                        cash_fee_withdrawal -= Long.parseLong(withdrawalamoutstr);
                        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                        String currency = formatter.format(cash_fee_withdrawal);
                        cashlabel.setText("موجودی حساب شما : " + currency);
                        withdrawalfield.setText(null);
                    }

                }
            }
        });


//////////////////////////////  Withdrawal Text  /////////////////////////////////////////
        JLabel withdrawaltext = createLabel(280, 200, 300, 20, "مبلغ مورد نظر را وارد کنید :", Color.WHITE, 20);

//////////////////////////////  Withdrawal Back Button /////////////////////////////////////////
        JButton withdrawalback = createButton("برگشت", 360, 600, 110, 50, 16, Color.black, new Color(51, 131, 156));
        withdrawalback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawalpage.setVisible(false);
                pagemain.setVisible(true);

            }
        });
/////////////////////////////////////////////////////////////////////////////////////  Cash page  //////////////////////////////////////////////////////////

//////////////////////////////  Cash Text /////////////////////////////////////////

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String currency = formatter.format(cash_fee_withdrawal);
        cashlabel = createLabel(350, 315, 300, 20, "موجودی حساب شما : " + currency, Color.white, 20);

//////////////////////////////  Cash Page Back Button /////////////////////////////////////////
        JButton Backtolastpagecash = createButton("برگشت", 350, 600, 100, 50, 16, Color.black, new Color(51, 131, 156));
        Backtolastpagecash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cash.setVisible(false);
                pagemain.setVisible(true);
            }
        });

//////////////////////////////  Cash Page Submit Button /////////////////////////////////////////
        JButton cashsubmit = createButton("تایید", 250, 600, 100, 50, 16, Color.black, Color.lightGray);
        cashsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cash.setVisible(false);
                lastpage.setVisible(true);
            }
        });

//////////////////////////////////////////////////////////////////////////////////////  Transfer page  /////////////////////////////////////////////////////////////

////////////////////////////// Transfer Card Input Field /////////////////////////////////////////
        JTextField transfercardnumberfield = new JTextField();
        transfercardnumberfield.setBounds(300, 400, 150, 30);
////////////////////////////// Transfer Money Input Field /////////////////////////////////////////
        JTextField transfermoneyfield = new JTextField();
        transfermoneyfield.setBounds(300, 250, 150, 30);
////////////////////////////// Transfer Card Text /////////////////////////////////////////
        JLabel transfercardnumberlabel = createLabel(280, 350, 300, 20, "شماره کارت مقصد را وارد کنید:", Color.WHITE, 20);

////////////////////////////// Transfer Money Text /////////////////////////////////////////
        JLabel transfermoneylabel = createLabel(280, 200, 300, 20, "مبلغ مورد نظر را وارد کنید:", Color.WHITE, 20);

////////////////////////////// Transfer Page Back Button /////////////////////////////////////////
        JButton transferback = createButton("برگشت", 350, 600, 100, 50, 16, Color.black, new Color(51, 131, 156));
        transferback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferpage.setVisible(false);
                pagemain.setVisible(true);
            }
        });
////////////////////////////// Transfer Submit Button /////////////////////////////////////////
        JButton submittransfer = createButton("تایید", 250, 600, 100, 50, 16, Color.BLACK, Color.lightGray);
        submittransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (transfercardnumberfield.getText().length() != 16)
                    JOptionPane.showMessageDialog(f, "شماره کارت صحیح نیست !", "شماره کارت", JOptionPane.WARNING_MESSAGE);
                else if (transfermoneyfield.getText().isEmpty())
                    JOptionPane.showMessageDialog(f, "ملبغ مورد نظر را وارد کنید", "کارت به کارت", JOptionPane.WARNING_MESSAGE);
                else if (cash_fee_withdrawal - Long.parseLong(transfermoneyfield.getText()) < 0)
                    JOptionPane.showMessageDialog(f, "موجودی کافی نیست !", "موجودی", JOptionPane.WARNING_MESSAGE);
                else {
                    transferpage.setVisible(false);
                    lastpage.setVisible(true);
                    String transfermoneystr = transfermoneyfield.getText();
                    cash_fee_withdrawal -= Long.parseLong(transfermoneystr);
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                    String currency = formatter.format(cash_fee_withdrawal);
                    cashlabel.setText(String.valueOf("موجودی حساب شما : " + currency));
                    transfermoneyfield.setText(null);
                }
            }
        });

/////////////////////////////////////////////////////////////////////////////////  Last page  ///////////////////////////////////////////////

//////////////////////////////  Final Page Text /////////////////////////////////////////
        JLabel finalpagelabel = createLabel(250, 330, 200, 20, "عملیات با موفقیت انجام شد!", Color.white, 16);

//////////////////////////////  Last Page Back Button /////////////////////////////////////////
        JButton backlastpage = createButton("برگشت", 250, 550, 100, 50, 16, Color.BLACK, new Color(51, 131, 156));
        backlastpage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastpage.setVisible(false);
                pagemain.setVisible(true);
            }
        });


//////////////////////////////  Language Page Components /////////////////////////////////////////

        pagelanguage.add(EnglishButton);
        pagelanguage.add(persianButton);
        pagelanguage.add(persianLabel);
        pagelanguage.add(EnglishLabel);
        //  pagelanguage.add(newbutton);
//////////////////////////////  Password Page Components /////////////////////////////////////////
        pagepassword.add(EnterPassLabel);
        pagepassword.add(EnterPassField);
        pagepassword.add(SubmitButton);
        pagepassword.add(BackGround);
//////////////////////////////  Main Page Components  /////////////////////////////////////////
        pagemain.add(ChangePass);
        pagemain.add(withdrawal);
        pagemain.add(Inventory_announcement);
        pagemain.add(transfer);
        pagemain.add(BacktoFirstPage);

//////////////////////////////  Change Password Page Components /////////////////////////////////////////

        ImageIcon imageChangePassword = new ImageIcon("Test3.jpg");
        JLabel BackGroundChangePassword = new JLabel("", imageChangePassword, JLabel.CENTER);
        BackGroundChangePassword.setBounds(0, 0, 700, 500);

        changepasspage.add(EnterNewPassLabel);
        changepasspage.add(EnterNewPassField);
        changepasspage.add(submitnewpass);
        changepasspage.add(Backtolastpagenewpass);

        changepasspage.add(BackGroundChangePassword);
//////////////////////////////  Withdrawal Page Components /////////////////////////////////////////

        ImageIcon imagewithdrawal = new ImageIcon("Test3.jpg");
        JLabel backgroundimagewithdrawal = new JLabel("", imagewithdrawal, JLabel.CENTER);
        backgroundimagewithdrawal.setBounds(0, 0, 700, 500);

        withdrawalpage.add(withdrawalfield);
        withdrawalpage.add(withdrawalsubmit);
        withdrawalpage.add(withdrawaltext);
        withdrawalpage.add(withdrawalback);
        withdrawalpage.add(backgroundimagewithdrawal);

//////////////////////////////  Cash Page Components /////////////////////////////////////////

        ImageIcon imageCash = new ImageIcon("Test3.jpg");
        JLabel BackGroundimageCash = new JLabel("", imageCash, JLabel.CENTER);
        BackGroundimageCash.setBounds(0, 0, 700, 500);

        cash.add(cashlabel);
        cash.add(Backtolastpagecash);
        cash.add(cashsubmit);
        cash.add(BackGroundimageCash);

//////////////////////////////  Transfer Page Components /////////////////////////////////////////

        ImageIcon imagetransferpage = new ImageIcon("Test3.jpg");
        JLabel BackGroundtransferpage  = new JLabel("", imagetransferpage, JLabel.CENTER);
        BackGroundtransferpage.setBounds(0, 0, 700, 500);

        transferpage.add(transfercardnumberfield);
        transferpage.add(transfermoneyfield);
        transferpage.add(transfercardnumberlabel);
        transferpage.add(transfermoneylabel);
        transferpage.add(transferback);
        transferpage.add(submittransfer);
        transferpage.add(BackGroundtransferpage);
//////////////////////////////  Last Page Components /////////////////////////////////////////
        lastpage.add(finalpagelabel);
        lastpage.add(backlastpage);
//////////////////////////////  Frame Components /////////////////////////////////////////
        f.add(pagelanguage);
        f.add(pagepassword);
        f.add(pagemain);
        f.add(changepasspage);
        f.add(cash);
        f.add(withdrawalpage);
        f.add(transferpage);
        f.add(lastpage);

        f.setSize(700, 700);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //////////////////////////////  Create Components /////////////////////////////////////////
    public static JButton createButton(String text, int x, int y, int width, int height, int font_size
            , Color Foreground, Color Background) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.BOLD, font_size));
        button.setForeground(Foreground);
        button.setBackground(Background);
        button.setFocusable(false);

        return button;
    }

    public static JPanel createPanel(int x, int y, int width, int height, Color Background, boolean set_visible) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(Background);
        panel.setLayout(null);
        panel.setVisible(set_visible);
        return panel;
    }

    public static JLabel createLabel(int x, int y, int width, int height, String text, Color Foreground, int font_size) {
        JLabel jLabel = new JLabel();
        jLabel.setBounds(x, y, width, height);
        jLabel.setText(text);
        jLabel.setForeground(Foreground);
        jLabel.setFont(new Font("Arial", Font.BOLD, font_size));

        return jLabel;
    }

}