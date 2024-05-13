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
        JFrame f = new JFrame("ATM"); // Frame
///////////////////////////  Initialize Pages ////////////////////////////////////////////
        JPanel pagelanguage = new JPanel();
        JPanel pagepassword = new JPanel();
        JPanel pagemain = new JPanel();
        JPanel changepasspage = new JPanel();
        JPanel cash = new JPanel();
        JPanel withdrawalpage = new JPanel();
        JPanel transferpage = new JPanel();
        JPanel lastpage = new JPanel();
////////////////////////////////////////////////////////////////////////////////////////////////////  Language Page  /////////////////////////////////////////////////////////////////
        pagelanguage.setBounds(0, 0, 700, 700);
        pagelanguage.setBackground(Color.CYAN);
        pagelanguage.setLayout(null);
//////////////////////////////  English Button /////////////////////////////////////////
        JButton EnglishButton = new JButton("English ");
        EnglishButton.setBounds(0, 300, 100, 50);
        EnglishButton.setFont(new Font("Arial", Font.BOLD, 16));
        EnglishButton.setForeground(Color.BLACK);
        EnglishButton.setBackground(Color.lightGray);
        EnglishButton.setFocusable(false);
        EnglishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagelanguage.setVisible(false);
                pagemain.setVisible(true);
            }
        });
////////////////////////////// Persian Language Button /////////////////////////////////////////
        JButton persianButton = new JButton("فارسی ");
        persianButton.setBounds(600, 300, 100, 50);
        persianButton.setFont(new Font("Arial", Font.BOLD, 16));
        persianButton.setForeground(Color.BLACK);
        persianButton.setBackground(Color.lightGray);
        persianButton.setFocusable(false);
        persianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagelanguage.setVisible(false);
                pagepassword.setVisible(true);
            }
        });
///////////////////////////// Persian Language Text /////////////////////////////////////////
        JLabel persianLabel = new JLabel();
        persianLabel.setBounds(450, 315, 200, 20);
        persianLabel.setText("زبان خود را انتخاب کنید");
        persianLabel.setForeground(Color.BLACK);
        persianLabel.setFont(new Font("Arial", Font.BOLD, 16));
//////////////////////////////  English Label /////////////////////////////////////////
        JLabel EnglishLabel = new JLabel();
        EnglishLabel.setBounds(110, 315, 200, 20);
        EnglishLabel.setText("Choose Language ");
        EnglishLabel.setForeground(Color.BLACK);
        EnglishLabel.setFont(new Font("Arial", Font.BOLD, 14));

////////////////////////////////////////////////////////////////////////////////////////////////////  Password Page  ///////////////////////////////////////////////////
        pagepassword.setBounds(0, 0, 700, 700);
        pagepassword.setBackground(Color.CYAN);
        pagepassword.setLayout(null);
        pagepassword.setVisible(false);

 //////////////////////////////  Password Label /////////////////////////////////////////
        JLabel EnterPassLabel = new JLabel();
        EnterPassLabel.setBounds(300, 200, 200, 20);
        EnterPassLabel.setText("رمز خود را وارد کنید ");
        EnterPassLabel.setForeground(Color.BLACK);
        EnterPassLabel.setFont(new Font("Arial", Font.BOLD, 16));

//////////////////////////////  Password Input Field /////////////////////////////////////////
        JPasswordField EnterPassField = new JPasswordField();
        EnterPassField.setBounds(280, 250, 150, 30);

////////////////////////////// Password Submit Button /////////////////////////////////////////
        JButton SubmitButton = new JButton("ثبت ");
        SubmitButton.setBounds(300, 620, 100, 50);
        SubmitButton.setFont(new Font("Arial", Font.BOLD, 16));
//        SubmitButton.setVisible(false);
        SubmitButton.setForeground(Color.BLACK);
        SubmitButton.setBackground(Color.lightGray);
        SubmitButton.setFocusable(false);
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
        pagemain.setBounds(0, 0, 700, 700);
        pagemain.setBackground(Color.CYAN);
        pagemain.setLayout(null);
        pagemain.setVisible(false);

//////////////////////////////  Change Pass Button /////////////////////////////////////////
        JButton ChangePass = new JButton("تغییر رمز ");
        ChangePass.setBounds(570, 300, 110, 50);
        ChangePass.setFont(new Font("Arial", Font.BOLD, 16));
        ChangePass.setForeground(Color.BLACK);
        ChangePass.setBackground(Color.lightGray);
        ChangePass.setFocusable(false);
        ChangePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                changepasspage.setVisible(true);
            }
        });
//////////////////////////////  Withdrawal Button /////////////////////////////////////////
        JButton withdrawal = new JButton("برداشت وجه");
        withdrawal.setBounds(10, 300, 100, 50);
        withdrawal.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setBackground(Color.lightGray);
        withdrawal.setFocusable(false);
        withdrawal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                withdrawalpage.setVisible(true);
            }
        });

////////////////////////////// Inventory_announcement Button /////////////////////////////////////////
        JButton Inventory_announcement = new JButton("اعلام موجودی ");
        Inventory_announcement.setBounds(560, 400, 120, 50);
        Inventory_announcement.setFont(new Font("Arial", Font.BOLD, 16));
        Inventory_announcement.setForeground(Color.BLACK);
        Inventory_announcement.setBackground(Color.lightGray);
        Inventory_announcement.setFocusable(false);
        Inventory_announcement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                cash.setVisible(true);
            }
        });

////////////////////////////// Transfer Money Button  /////////////////////////////////////////
        JButton transfer = new JButton("کارت به کارت ");
        transfer.setBounds(10, 400, 120, 50);
        transfer.setFont(new Font("Arial", Font.BOLD, 16));
        transfer.setForeground(Color.BLACK);
        transfer.setBackground(Color.lightGray);
        transfer.setFocusable(false);
        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                transferpage.setVisible(true);
            }
        });

////////////////////////////// Back to First Page Button  /////////////////////////////////////////
        JButton BacktoFirstPage = new JButton("برگشت");
        BacktoFirstPage.setBounds(300, 600, 100, 50);
        BacktoFirstPage.setFont(new Font("Arial", Font.BOLD, 16));
        BacktoFirstPage.setBackground(new Color(51, 131, 156));
        BacktoFirstPage.setForeground(Color.black);
        BacktoFirstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                pagelanguage.setVisible(true);
            }
        });

//////////////////////////////////////////////////////////////////////////////////////////////////////////////  Change Password page  ////////////////////////////////////////////////////////////
        changepasspage.setBounds(0, 0, 700, 700);
        changepasspage.setBackground(Color.CYAN);
        changepasspage.setLayout(null);
        changepasspage.setVisible(false);

//////////////////////////////  New Password Label /////////////////////////////////////////
        JLabel EnterNewPassLabel = new JLabel();
        EnterNewPassLabel.setBounds(300, 200, 220, 20);
        EnterNewPassLabel.setText("رمز جدید خود را وارد کنید :");
        EnterNewPassLabel.setForeground(Color.BLACK);
        EnterNewPassLabel.setFont(new Font("Arial", Font.BOLD, 16));
//////////////////////////////  New Password Field /////////////////////////////////////////
        JPasswordField EnterNewPassField = new JPasswordField();
        EnterNewPassField.setBounds(300, 250, 150, 30);
//////////////////////////////  Submit New Pass Button /////////////////////////////////////////
        JButton submitnewpass = new JButton("تایید");
        submitnewpass.setBounds(280, 400, 100, 50);
        submitnewpass.setFont(new Font("Arial", Font.BOLD, 16));
        submitnewpass.setForeground(Color.BLACK);
        submitnewpass.setBackground(Color.lightGray);
        submitnewpass.setFocusable(false);
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
        JButton Backtolastpagenewpass = new JButton("برگشت");
        Backtolastpagenewpass.setBounds(380, 400, 100, 50);
        Backtolastpagenewpass.setFont(new Font("Arial", Font.BOLD, 16));
        Backtolastpagenewpass.setBackground(new Color(51, 131, 156));
        Backtolastpagenewpass.setForeground(Color.black);
        Backtolastpagenewpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changepasspage.setVisible(false);
                pagemain.setVisible(true);

            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////  Withdrawal Page  /////////////////////////////////////////////////////
        withdrawalpage.setBounds(0, 0, 700, 700);
        withdrawalpage.setBackground(Color.CYAN);
        withdrawalpage.setLayout(null);
        withdrawalpage.setVisible(false);

//////////////////////////////  Withdrawal Field Input /////////////////////////////////////////
        JTextField withdrawalfield = new JTextField();
        withdrawalfield.setBounds(280, 250, 150, 30);

//////////////////////////////  Withdrawal Submit Button /////////////////////////////////////////
        JButton withdrawalsubmit = new JButton("تایید ");
        withdrawalsubmit.setBounds(250, 500, 110, 50);
        withdrawalsubmit.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawalsubmit.setForeground(Color.BLACK);
        withdrawalsubmit.setBackground(Color.lightGray);
        withdrawalsubmit.setFocusable(false);
        withdrawalsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

//////////////////////////////  Withdrawal Text  /////////////////////////////////////////
        JLabel withdrawaltext = new JLabel();
        withdrawaltext.setBounds(280, 200, 300, 20);
        withdrawaltext.setText("مبلغ مورد نظر را وارد کنید :");
        withdrawaltext.setForeground(Color.BLACK);
        withdrawaltext.setFont(new Font("Arial", Font.BOLD, 16));

//////////////////////////////  Withdrawal Back Button /////////////////////////////////////////
        JButton withdrawalback = new JButton("برگشت");
        withdrawalback.setBounds(360, 500, 110, 50);
        withdrawalback.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawalback.setForeground(Color.BLACK);
        withdrawalback.setBackground(new Color(51, 131, 156));
        withdrawalback.setFocusable(false);
        withdrawalback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawalpage.setVisible(false);
                pagemain.setVisible(true);

            }
        });
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  Cash page  //////////////////////////////////////////////////////////
        cash.setBounds(0, 0, 700, 700);
        cash.setBackground(Color.CYAN);
        cash.setLayout(null);
        cash.setVisible(false);
//////////////////////////////  Cash Text /////////////////////////////////////////
        cashlabel = new JLabel();
        cashlabel.setBounds(350, 315, 300, 20);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String currency = formatter.format(cash_fee_withdrawal);
        cashlabel.setText(String.valueOf("موجودی حساب شما : " + currency));
        cashlabel.setForeground(Color.BLACK);
        cashlabel.setFont(new Font("Arial", Font.BOLD, 16));

//////////////////////////////  Cash Page Back Button /////////////////////////////////////////
        JButton Backtolastpagecash = new JButton("برگشت");
        Backtolastpagecash.setBounds(350, 400, 100, 50);
        Backtolastpagecash.setFont(new Font("Arial", Font.BOLD, 16));
        Backtolastpagecash.setForeground(Color.BLACK);
        Backtolastpagecash.setBackground(new Color(51, 131, 156));
        Backtolastpagecash.setFocusable(false);
        Backtolastpagecash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cash.setVisible(false);
                pagemain.setVisible(true);
            }
        });

//////////////////////////////  Cash Page Submit Button /////////////////////////////////////////
        JButton cashsubmit = new JButton("تایید ");
        cashsubmit.setBounds(250, 400, 100, 50);
        cashsubmit.setFont(new Font("Arial", Font.BOLD, 16));
        cashsubmit.setForeground(Color.BLACK);
        cashsubmit.setBackground(Color.lightGray);
        cashsubmit.setFocusable(false);
        cashsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cash.setVisible(false);
                lastpage.setVisible(true);
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  Transfer page  /////////////////////////////////////////////////////////////
        transferpage.setBounds(0, 0, 700, 700);
        transferpage.setBackground(Color.CYAN);
        transferpage.setLayout(null);
        transferpage.setVisible(false);
        transferpage.setVisible(false);
////////////////////////////// Transfer Card Input Field /////////////////////////////////////////
        JTextField transfercardnumberfield = new JTextField();
        transfercardnumberfield.setBounds(280, 400, 150, 30);
////////////////////////////// Transfer Money Input Field /////////////////////////////////////////
        JTextField transfermoneyfield = new JTextField();
        transfermoneyfield.setBounds(280, 250, 150, 30);
////////////////////////////// Transfer Card Text /////////////////////////////////////////
        JLabel transfercardnumberlabel = new JLabel();
        transfercardnumberlabel.setBounds(280, 350, 300, 20);
        transfercardnumberlabel.setText("شماره کارت مقصد را وارد کنید:");
        transfercardnumberlabel.setForeground(Color.BLACK);
        transfercardnumberlabel.setFont(new Font("Arial", Font.BOLD, 16));
////////////////////////////// Transfer Money Text /////////////////////////////////////////
        JLabel transfermoneylabel = new JLabel();
        transfermoneylabel.setBounds(280, 200, 300, 20);
        transfermoneylabel.setText("مبلغ مورد نظر را وارد کنید:");
        transfermoneylabel.setForeground(Color.BLACK);
        transfermoneylabel.setFont(new Font("Arial", Font.BOLD, 16));
////////////////////////////// Transfer Page Back Button /////////////////////////////////////////
        JButton transferback = new JButton("برگشت");
        transferback.setBounds(350, 500, 100, 50);
        transferback.setFont(new Font("Arial", Font.BOLD, 16));
        transferback.setBackground(new Color(51, 131, 156));
        transferback.setForeground(Color.black);
        transferback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferpage.setVisible(false);
                pagemain.setVisible(true);
            }
        });
////////////////////////////// Transfer Submit Button /////////////////////////////////////////
        JButton submittransfer = new JButton("تایید");
        submittransfer.setBounds(250, 500, 100, 50);
        submittransfer.setFont(new Font("Arial", Font.BOLD, 16));
        submittransfer.setForeground(Color.BLACK);
        submittransfer.setBackground(Color.lightGray);
        submittransfer.setFocusable(false);
        submittransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (transfercardnumberfield.getText().length() != 16)
                    JOptionPane.showMessageDialog(f, "شماره کارت صحیح نیست !", "شماره کارت", JOptionPane.WARNING_MESSAGE);
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////  Last page  ///////////////////////////////////////////////
        lastpage.setBounds(0, 0, 700, 700);
        lastpage.setBackground(Color.BLACK);
        lastpage.setLayout(null);
        lastpage.setVisible(false);
//////////////////////////////  Final Page Text /////////////////////////////////////////
        JLabel finalpagelabel = new JLabel();
        finalpagelabel.setBounds(250, 330, 200, 20);
        finalpagelabel.setText("عملیات با موفقیت انجام شد!");
        finalpagelabel.setForeground(Color.white);
        finalpagelabel.setFont(new Font("Arial", Font.BOLD, 16));
//////////////////////////////  Last Page Back Button /////////////////////////////////////////
        JButton backlastpage = new JButton("برگشت");
        backlastpage.setBounds(250, 550, 100, 50);
        backlastpage.setFont(new Font("Arial", Font.BOLD, 16));
        backlastpage.setForeground(Color.BLACK);
        backlastpage.setBackground(new Color(51, 131, 156));
        backlastpage.setFocusable(false);
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

//////////////////////////////  Password Page Components /////////////////////////////////////////
        pagepassword.add(EnterPassLabel);
        pagepassword.add(EnterPassField);
        pagepassword.add(SubmitButton);
//////////////////////////////  Main Page Components  /////////////////////////////////////////
        pagemain.add(ChangePass);
        pagemain.add(withdrawal);
        pagemain.add(Inventory_announcement);
        pagemain.add(transfer);
        pagemain.add(BacktoFirstPage);
//////////////////////////////  Change Password Page Components /////////////////////////////////////////
        changepasspage.add(EnterNewPassLabel);
        changepasspage.add(EnterNewPassField);
        changepasspage.add(submitnewpass);
        changepasspage.add(Backtolastpagenewpass);
//////////////////////////////  Withdrawal Page Components /////////////////////////////////////////
        withdrawalpage.add(withdrawalfield);
        withdrawalpage.add(withdrawalsubmit);
        withdrawalpage.add(withdrawaltext);
        withdrawalpage.add(withdrawalback);
//////////////////////////////  Cash Page Components /////////////////////////////////////////
        cash.add(cashlabel);
        cash.add(Backtolastpagecash);
        cash.add(cashsubmit);
//////////////////////////////  Transfer Page Components /////////////////////////////////////////
        transferpage.add(transfercardnumberfield);
        transferpage.add(transfermoneyfield);
        transferpage.add(transfercardnumberlabel);
        transferpage.add(transfermoneylabel);
        transferpage.add(transferback);
        transferpage.add(submittransfer);
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
}