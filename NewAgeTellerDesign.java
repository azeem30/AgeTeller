package AgeTeller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class NewAgeTellerDesign extends JFrame implements ActionListener
{
    JLabel birthLabel,ageLabel;
    public JTextField birthDate;
    JButton calc;
    String dob,ageOfUser;
    String [] arr;
    int dayOfBirth,monthOfBirth,yearOfBirth,days,months,years;
    LocalDate birth;
    LocalDate today;
    NewAgeTellerDesign()
    {
        createFrame();
        addLabels();
        frameDetails();
    }
    void createFrame()
    {
        setSize(600,300);
        setTitle("Age Calculator");
    }
    void frameDetails()
    {
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void addLabels()
    {
        birthLabel = new JLabel();
        birthLabel.setText("Enter birth date (in DD-MM-YYYY format) : ");
        birthLabel.setBounds(50,30,300,30);
        add(birthLabel);

        birthDate = new JTextField();
        birthDate.setBounds(310,30,200,30);
        add(birthDate);

        calc = new JButton();
        calc.setText("Calculate Age");
        calc.setBounds(200,180,180,30);
        calc.addActionListener(this);
        add(calc);

        ageLabel = new JLabel();
        ageLabel.setBounds(120,130,360,30);
        ageLabel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(ageLabel);
    }
    public static void main(String[] args) {
        new NewAgeTellerDesign();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calc)
        {
            calculateAge();
        }
    }
    void calculateAge()
    {
        getUserDateOfBirth();
        convertStringToDateObject();
        calculateDifference();
        outputAge();
    }
    void getUserDateOfBirth()
    {
        dob = birthDate.getText();
    }
    void convertStringToDateObject()
    {
        arr = dob.split("-");
        dayOfBirth = Integer.parseInt(arr[0]);
        monthOfBirth = Integer.parseInt(arr[1]);
        yearOfBirth = Integer.parseInt(arr[2]);
        birth = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
    }
    void calculateDifference()
    {
        today = LocalDate.now();
        days = Period.between(birth,today).getDays();
        months = Period.between(birth,today).getMonths();
        years = Period.between(birth,today).getYears();
    }
    void outputAge()
    {
        ageOfUser = "You are "+years+ " years "+months+ " months "+" and "+days+" days old!";
        ageLabel.setText(ageOfUser);
    }
}
