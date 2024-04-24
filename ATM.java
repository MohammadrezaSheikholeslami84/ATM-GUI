import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class ATM {
    public static long cash_fee_withdrawal = 56350000;
    public static String pass;
    public static void main(String[] args) {
        JFrame f = new JFrame("ATM"); // Frame
///////////////////////////  Initialize Pages ////////////////////////////////////////////
        JPanel pagelanguage=new JPanel();
        JPanel pagepassword=new JPanel();
        JPanel pagemain=new JPanel();
        JPanel changepasspage = new JPanel();
        JPanel cash = new JPanel();
        JPanel withdrawalpage = new JPanel();
        JPanel transferpage = new JPanel();
        JPanel lastpage = new JPanel();

///////////////////////////  Language Page  ////////////////////////////////////////////
        pagelanguage.setBounds(0,0,700,700);
        pagelanguage.setBackground(Color.CYAN);
        pagelanguage.setLayout(null);
///////////////////////////  Password Page  ////////////////////////////
        pagepassword.setBounds(0,0,700,700);
        pagepassword.setBackground(Color.CYAN);
        pagepassword.setLayout(null);
        pagepassword.setVisible(false);
//////////////////////////  Main Page  ///////////////////////////////
        pagemain.setBounds(0,0,700,700);
        pagemain.setBackground(Color.CYAN);
        pagemain.setLayout(null);
        pagemain.setVisible(false);
////////////////////////////  Change Password page  ////////////////////////////////
        changepasspage.setBounds(0,0,700,700);
        changepasspage.setBackground(Color.CYAN);
        changepasspage.setLayout(null);
        changepasspage.setVisible(false);
///////////////////////////  Withdrawal Page  ///////////////////////////////
        withdrawalpage.setBounds(0,0,700,700);
        withdrawalpage.setBackground(Color.CYAN);
        withdrawalpage.setLayout(null);
        withdrawalpage.setVisible(false);
////////////////////////////  Cash page  ///////////////////////////////////////////
        cash.setBounds(0,0,700,700);
        cash.setBackground(Color.CYAN);
        cash.setLayout(null);
        cash.setVisible(false);
////////////////////////////  Tranfer page  ///////////////////////////////////////////
        transferpage.setBounds(0,0,700,700);
        transferpage.setBackground(Color.CYAN);
        transferpage.setLayout(null);
        transferpage.setVisible(false);
        transferpage.setVisible(false);
//////////////////////////////  Last page  /////////////////////////////////////////
        lastpage.setBounds(0,0,700,700);
        lastpage.setBackground(Color.BLACK);
        lastpage.setLayout(null);
        lastpage.setVisible(false);
//////////////////////////////  English Button /////////////////////////////////////////
        JButton  EnglishButton = new JButton("English ");
        EnglishButton.setBounds(0, 300, 100, 50);
        EnglishButton.setFont(new Font("Arial",Font.BOLD,16));
        EnglishButton.setForeground(Color.BLACK);
        EnglishButton.setBackground(Color.lightGray);
        EnglishButton.setFocusable(false);
        EnglishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(700, 700);
            }
        });
//////////////////////////////  English Label /////////////////////////////////////////
        JLabel EnglishLabel = new JLabel();
        EnglishLabel.setBounds(110, 315, 200, 20);
        EnglishLabel.setText("Choose Language ");
        EnglishLabel.setForeground(Color.BLACK);
        EnglishLabel.setFont(new Font("Arial",Font.BOLD,14));
//////////////////////////////  Password Label /////////////////////////////////////////
        JLabel EnterPassLabel = new JLabel();
        EnterPassLabel.setBounds(300, 200, 200, 20);
        EnterPassLabel.setText("رمز خود را وارد کنید ");
        EnterPassLabel.setForeground(Color.BLACK);
        EnterPassLabel.setFont(new Font("Arial",Font.BOLD,16));
        EnterPassLabel.setVisible(false);
//////////////////////////////  Password Input Field /////////////////////////////////////////
        JPasswordField EnterPassField = new JPasswordField();
        EnterPassField.setBounds(280, 250, 150, 30);
        EnterPassField.setVisible(false);
//////////////////////////////  New Password Label /////////////////////////////////////////
        JLabel EnterNewPassLabel = new JLabel();
        EnterNewPassLabel.setBounds(300, 200, 220, 20);
        EnterNewPassLabel.setText("رمز جدید خود را وارد کنید :");
        EnterNewPassLabel.setForeground(Color.BLACK);
        EnterNewPassLabel.setFont(new Font("Arial",Font.BOLD,16));
        EnterNewPassLabel.setVisible(false);
//////////////////////////////  New Password Field /////////////////////////////////////////
        JPasswordField EnterNewPassField = new JPasswordField();
        EnterNewPassField.setBounds(300, 250, 150, 30);
        EnterNewPassField.setVisible(false);
//////////////////////////////  Final Page Text /////////////////////////////////////////
        JLabel finalpagelabel = new JLabel();
        finalpagelabel.setBounds(250, 330, 200, 20);
        finalpagelabel.setText("عملیات با موفقیت انجام شد!");
        finalpagelabel.setForeground(Color.white);
        finalpagelabel.setFont(new Font("Arial",Font.BOLD,16));
        finalpagelabel.setVisible(false);
//////////////////////////////  Last Page Back Button /////////////////////////////////////////
        JButton backlastpage = new JButton("برگشت");
        backlastpage.setBounds(250, 550, 100, 50);
        backlastpage.setFont(new Font("Arial",Font.BOLD,16));
        backlastpage.setVisible(false);
        backlastpage.setForeground(Color.BLACK);
        backlastpage.setBackground(new Color(51,131,156));
        backlastpage.setFocusable(false);
        backlastpage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastpage.setVisible(false);
                pagemain.setVisible(true);

            }
        });
//////////////////////////////  Submit New Pass Button /////////////////////////////////////////
        JButton submitnewpass = new JButton("تایید");
        submitnewpass.setBounds(280, 400, 100, 50);
        submitnewpass.setFont(new Font("Arial",Font.BOLD,16));
        submitnewpass.setVisible(false);
        submitnewpass.setForeground(Color.BLACK);
        submitnewpass.setBackground(Color.lightGray);
        submitnewpass.setFocusable(false);
        submitnewpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(EnterNewPassField.getPassword().length == 0)
                    JOptionPane.showMessageDialog(f,"رمز جدید خود را وارد کنید","رمز",JOptionPane.WARNING_MESSAGE);
                else if (pass.equals(Arrays.toString(EnterNewPassField.getPassword()))) {
                    JOptionPane.showMessageDialog(f,"رمز تکراری است !","رمز",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    pass = Arrays.toString(EnterNewPassField.getPassword());
                    changepasspage.setVisible(false);
                    EnterNewPassLabel.setVisible(false);
                    EnterNewPassField.setVisible(false);
                    finalpagelabel.setVisible(true);
                    lastpage.setVisible(true);
                    backlastpage.setVisible(true);
                }

            }
        });
//////////////////////////////  New Pass Page Back Button /////////////////////////////////////////
        JButton Backtolastpagenewpass = new JButton("برگشت");
        Backtolastpagenewpass.setBounds(380, 400, 100, 50);
        Backtolastpagenewpass.setFont(new Font("Arial",Font.BOLD,16));
        Backtolastpagenewpass.setBackground(new Color(51,131,156));
        Backtolastpagenewpass.setForeground(Color.black);
        Backtolastpagenewpass.setVisible(false);
        Backtolastpagenewpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changepasspage.setVisible(false);
                EnterNewPassLabel.setVisible(false);
                EnterNewPassField.setVisible(false);
                pagemain.setVisible(true);

            }
        });
//////////////////////////////  Change Pass Button /////////////////////////////////////////
        JButton ChangePass = new JButton("تغییر رمز ");
        ChangePass.setBounds(570, 300, 110, 50);
        ChangePass.setFont(new Font("Arial",Font.BOLD,16));
        ChangePass.setVisible(false);
        ChangePass.setForeground(Color.BLACK);
        ChangePass.setBackground(Color.lightGray);
        ChangePass.setFocusable(false);
        ChangePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                changepasspage.setVisible(true);
                EnterNewPassLabel.setVisible(true);
                EnterNewPassField.setVisible(true);
                submitnewpass.setVisible(true);
                Backtolastpagenewpass.setVisible(true);

            }
        });
//////////////////////////////  Withdrawal Field Input /////////////////////////////////////////
        JTextField withdrawalfield = new JTextField();
        withdrawalfield.setBounds(280, 250, 150, 30);
        withdrawalfield.setVisible(false);
//////////////////////////////  Withdrawal Back Button /////////////////////////////////////////
        JButton withdrawalback = new JButton("برگشت");
        withdrawalback.setBounds(360, 500, 110, 50);
        withdrawalback.setFont(new Font("Arial",Font.BOLD,16));
        withdrawalback.setVisible(false);
        withdrawalback.setForeground(Color.BLACK);
        withdrawalback.setBackground(new Color(51,131,156));
        withdrawalback.setFocusable(false);
        withdrawalback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawalpage.setVisible(false);
                pagemain.setVisible(true);

            }
        });
        //////////////////////////////  Cash Text /////////////////////////////////////////
        JLabel cashlabel = new JLabel();
        cashlabel.setBounds(350, 315, 300, 20);
        NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.US);
        String currency=formatter.format(cash_fee_withdrawal);
        cashlabel.setText(String.valueOf( "موجودی حساب شما : " +  currency ));
        cashlabel.setForeground(Color.BLACK);
        cashlabel.setFont(new Font("Arial",Font.BOLD,16));
        cashlabel.setVisible(false);
//////////////////////////////  Withdrawal Submit Button /////////////////////////////////////////
        JButton withdrawalsubmit = new JButton("تایید ");
        withdrawalsubmit.setBounds(250, 500, 110, 50);
        withdrawalsubmit.setFont(new Font("Arial",Font.BOLD,16));
        withdrawalsubmit.setVisible(false);
        withdrawalsubmit.setForeground(Color.BLACK);
        withdrawalsubmit.setBackground(Color.lightGray);
        withdrawalsubmit.setFocusable(false);
        withdrawalsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cash_fee_withdrawal - Long.parseLong(withdrawalfield.getText()) < 0)
                    JOptionPane.showMessageDialog(f,"موجودی کافی نیست !","موجودی",JOptionPane.WARNING_MESSAGE);
                else {
                    withdrawalpage.setVisible(false);
                    lastpage.setVisible(true);
                    finalpagelabel.setVisible(true);
                    backlastpage.setVisible(true);
                    String withdrawalamoutstr = withdrawalfield.getText();
                    cash_fee_withdrawal -= Long.parseLong(withdrawalamoutstr);
                    NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.US);
                    String currency=formatter.format(cash_fee_withdrawal);
                    cashlabel.setText("موجودی حساب شما : " + currency );
                    withdrawalfield.setText(null);
                }

            }
        });
//////////////////////////////  Withdrawal Text  /////////////////////////////////////////
        JLabel withdrawaltext = new JLabel();
        withdrawaltext.setBounds(280, 200, 300, 20);
        withdrawaltext.setText("مبلغ مورد نظر را وارد کنید :");
        withdrawaltext.setForeground(Color.BLACK);
        withdrawaltext.setFont(new Font("Arial",Font.BOLD,16));
        withdrawaltext.setVisible(false);
//////////////////////////////  Withdrawal Button /////////////////////////////////////////
        JButton withdrawal = new JButton("برداشت وجه");
        withdrawal.setBounds(10, 300, 100, 50);
        withdrawal.setFont(new Font("Arial",Font.BOLD,16));
        withdrawal.setVisible(false);
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setBackground(Color.lightGray);
        withdrawal.setFocusable(false);
        withdrawal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                withdrawalpage.setVisible(true);
                withdrawalfield.setVisible(true);
                withdrawalsubmit.setVisible(true);
                withdrawaltext.setVisible(true);
                withdrawalback.setVisible(true);
            }
        });

//////////////////////////////  Cash Page Back Button /////////////////////////////////////////
        JButton Backtolastpagecash = new JButton("برگشت");
        Backtolastpagecash.setBounds(350, 400, 100, 50);
        Backtolastpagecash.setFont(new Font("Arial",Font.BOLD,16));
        Backtolastpagecash.setVisible(false);
        Backtolastpagecash.setForeground(Color.BLACK);
        Backtolastpagecash.setBackground(new Color(51,131,156));
        Backtolastpagecash.setFocusable(false);
        Backtolastpagecash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cash.setVisible(false);
                cashlabel.setVisible(false);
                Backtolastpagecash.setVisible(false);
                pagemain.setVisible(true);
            }
        });
//////////////////////////////  Cash Page Submit Button /////////////////////////////////////////
        JButton cashsubmit = new JButton("تایید ");
        cashsubmit.setBounds(250, 400, 100, 50);
        cashsubmit.setFont(new Font("Arial",Font.BOLD,16));
        cashsubmit.setVisible(false);
        cashsubmit.setForeground(Color.BLACK);
        cashsubmit.setBackground(Color.lightGray);
        cashsubmit.setFocusable(false);
        cashsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cash.setVisible(false);
                lastpage.setVisible(true);
                finalpagelabel.setVisible(true);
                backlastpage.setVisible(true);
            }
        });
////////////////////////////// Inventory_announcement Button /////////////////////////////////////////
        JButton Inventory_announcement = new JButton("اعلام موجودی ");
        Inventory_announcement.setBounds(560, 400, 120, 50);
        Inventory_announcement.setFont(new Font("Arial",Font.BOLD,16));
        Inventory_announcement.setVisible(false);
        Inventory_announcement.setForeground(Color.BLACK);
        Inventory_announcement.setBackground(Color.lightGray);
        Inventory_announcement.setFocusable(false);
        Inventory_announcement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                cash.setVisible(true);
                cashlabel.setVisible(true);
                Backtolastpagecash.setVisible(true);
                cashsubmit.setVisible(true);
            }
        });
////////////////////////////// Transfer Money Text /////////////////////////////////////////
        JLabel transfermoneylabel = new JLabel();
        transfermoneylabel.setBounds(280, 200, 300, 20);
        transfermoneylabel.setText("مبلغ مورد نظر را وارد کنید:");
        transfermoneylabel.setForeground(Color.BLACK);
        transfermoneylabel.setFont(new Font("Arial",Font.BOLD,16));
        transfermoneylabel.setVisible(false);
////////////////////////////// Transfer Money Input Field /////////////////////////////////////////
        JTextField transfermoneyfield = new JTextField();
        transfermoneyfield.setBounds(280, 250, 150, 30);
        transfermoneyfield.setVisible(false);
////////////////////////////// Transfer Card Text /////////////////////////////////////////
        JLabel transfercardnumberlabel = new JLabel();
        transfercardnumberlabel.setBounds(280, 350, 300, 20);
        transfercardnumberlabel.setText("شماره کارت مقصد را وارد کنید:");
        transfercardnumberlabel.setForeground(Color.BLACK);
        transfercardnumberlabel.setFont(new Font("Arial",Font.BOLD,16));
        transfercardnumberlabel.setVisible(false);
////////////////////////////// Transfer Card Input Field /////////////////////////////////////////
        JTextField transfercardnumberfield = new JTextField();
        transfercardnumberfield.setBounds(280, 400, 150, 30);
        transfercardnumberfield.setVisible(false);
////////////////////////////// Transfer Submit Button /////////////////////////////////////////
        JButton submittransfer = new JButton("تایید");
        submittransfer.setBounds(250, 500, 100, 50);
        submittransfer.setFont(new Font("Arial",Font.BOLD,16));
        submittransfer.setVisible(false);
        submittransfer.setForeground(Color.BLACK);
        submittransfer.setBackground(Color.lightGray);
        submittransfer.setFocusable(false);
        submittransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(transfercardnumberfield.getText().length() != 16)
                    JOptionPane.showMessageDialog(f,"شماره کارت صحیح نیست !","شماره کارت",JOptionPane.WARNING_MESSAGE);
                else if(cash_fee_withdrawal - Long.parseLong(transfermoneyfield.getText()) < 0)
                    JOptionPane.showMessageDialog(f,"موجودی کافی نیست !","موجودی",JOptionPane.WARNING_MESSAGE);
                else
                {
                    transferpage.setVisible(false);
                    lastpage.setVisible(true);
                    finalpagelabel.setVisible(true);
                    backlastpage.setVisible(true);
                    String transfermoneystr = transfermoneyfield.getText();
                    cash_fee_withdrawal -= Long.parseLong(transfermoneystr);
                    NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.US);
                    String currency=formatter.format(cash_fee_withdrawal);
                    cashlabel.setText(String.valueOf("موجودی حساب شما : " + currency ));
                    transfermoneyfield.setText(null);
                }
            }
        });
////////////////////////////// Transfer Page Back Button /////////////////////////////////////////
        JButton  transferback = new JButton("برگشت");
        transferback.setBounds(350, 500, 100, 50);
        transferback.setFont(new Font("Arial",Font.BOLD,16));
        transferback.setBackground(new Color(51,131,156));
        transferback.setForeground(Color.black);
        transferback.setVisible(false);
        transferback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferpage.setVisible(false);
                pagemain.setVisible(true);
            }
        });
////////////////////////////// Transfer Money Button  /////////////////////////////////////////
        JButton transfer = new JButton("کارت به کارت ");
        transfer.setBounds(10, 400, 120, 50);
        transfer.setFont(new Font("Arial",Font.BOLD,16));
        transfer.setVisible(false);
        transfer.setForeground(Color.BLACK);
        transfer.setBackground(Color.lightGray);
        transfer.setFocusable(false);
        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagemain.setVisible(false);
                transferpage.setVisible(true);
                transfermoneyfield.setVisible(true);
                transfercardnumberfield.setVisible(true);
                transfercardnumberlabel.setVisible(true);
                transfermoneylabel.setVisible(true);
                transferback.setVisible(true);
                submittransfer.setVisible(true);
            }
        });
////////////////////////////// Back to First Page Button  /////////////////////////////////////////
        JButton BacktoFirstPage = new JButton("برگشت");
        BacktoFirstPage.setBounds(300, 600, 100, 50);
        BacktoFirstPage.setFont(new Font("Arial",Font.BOLD,16));
        BacktoFirstPage.setBackground(new Color(51,131,156));
        BacktoFirstPage.setForeground(Color.black);
        BacktoFirstPage.setVisible(false);
        BacktoFirstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BacktoFirstPage.setVisible(false);
                pagemain.setVisible(false);
                pagelanguage.setVisible(true);
            }
        });
////////////////////////////// Password Submit Button /////////////////////////////////////////
        JButton SubmitButton = new JButton("ثبت ");
        SubmitButton.setBounds(300, 620, 100, 50);
        SubmitButton.setFont(new Font("Arial",Font.BOLD,16));
        SubmitButton.setVisible(false);
        SubmitButton.setForeground(Color.BLACK);
        SubmitButton.setBackground(Color.lightGray);
        SubmitButton.setFocusable(false);
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(EnterPassField.getPassword().length == 0)
                    JOptionPane.showMessageDialog(f,"رمز خود را وارد کنید","رمز",JOptionPane.WARNING_MESSAGE);
                else {
                    pass = Arrays.toString(EnterPassField.getPassword());
                    pagepassword.setVisible(false);
                    EnterPassField.setVisible(false);
                    SubmitButton.setVisible(false);
                    EnterPassLabel.setVisible(false);
                    EnterPassField.setVisible(false);
                    pagemain.setVisible(true);
                    ChangePass.setVisible(true);
                    withdrawal.setVisible(true);
                    Inventory_announcement.setVisible(true);
                    transfer.setVisible(true);
                    BacktoFirstPage.setVisible(true);
                }


            }
        });
////////////////////////////// Persion Language Button /////////////////////////////////////////
        JButton PersionButton = new JButton("فارسی ");
        PersionButton.setBounds(600, 300, 100, 50);
        PersionButton.setFont(new Font("Arial",Font.BOLD,16));
        PersionButton.setForeground(Color.BLACK);
        PersionButton.setBackground(Color.lightGray);
        PersionButton.setFocusable(false);
        PersionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagelanguage.setVisible(false);
                pagepassword.setVisible(true);
                EnterPassField.setVisible(true);
                EnterPassLabel.setVisible(true);
                SubmitButton.setVisible(true);
            }
        });
////////////////////////////// Persion Language Text /////////////////////////////////////////
        JLabel PersionLabel = new JLabel();
        PersionLabel.setBounds(450, 315, 200, 20);
        PersionLabel.setText("زبان خود را انتخاب کنید");
        PersionLabel.setForeground(Color.BLACK);
        PersionLabel.setFont(new Font("Arial",Font.BOLD,16));
//////////////////////////////  Language Page Components /////////////////////////////////////////
        pagelanguage.add(EnglishButton);
        pagelanguage.add(PersionButton);
        pagelanguage.add(PersionLabel);
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
