package AgeTeller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class NewAgeTellerDesign extends JFrame implements ActionListener
{
    JLabel birthLabel,ageLabel,errorLabel,starLabel;
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
        birthDate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(birthDate);

        calc = new JButton();
        calc.setText("Calculate Age");
        calc.setBounds(200,180,180,30);
        calc.addActionListener(this);
        add(calc);

        ageLabel = new JLabel();
        ageLabel.setBounds(120,130,360,30);
        ageLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        add(ageLabel);

        errorLabel = new JLabel();
        errorLabel.setBounds(310,60,200,30);
        add(errorLabel);

        starLabel = new JLabel();
        starLabel.setBounds(120,100,300,30);
        starLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        add(starLabel);
    }
    public static void main(String[] args) {
        new NewAgeTellerDesign();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calc)
        {
            try
            {
            calculateAge();
            }
            catch (Exception exc)
            {
                errorLabel.setText("Please input valid Date of Birth!");
            }
        }

    }
    void calculateAge()
    {
        getUserDateOfBirth();
        convertStringToDateObject();
        calculateDifference();
        outputAge();
        starSign();
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
        ageOfUser = "You are "+years+ " years "+months+ " months and "+days+" days old!";
        ageLabel.setText(ageOfUser);
        if(months ==0 && days ==0)
        {
            JOptionPane.showMessageDialog(null,"Happy Birthday to You!");
        }
    }
    void starSign()
    {
        if ((dayOfBirth>=20 && monthOfBirth==01) || (dayOfBirth <=18 && monthOfBirth == 02))
        {
            starLabel.setText("You are an Aquarius.");
        }
        else if ((dayOfBirth>=19 && monthOfBirth ==02) || (dayOfBirth<=20 && monthOfBirth ==03))
        {
            starLabel.setText("You are a Pisces.");
        }
        else if ((dayOfBirth >=21 && monthOfBirth ==3) || (dayOfBirth <= 19 && monthOfBirth == 04))
        {
            starLabel.setText("You are an Aries.");
        }
        else if ((dayOfBirth >=20 && monthOfBirth ==04)||(dayOfBirth <= 20 && monthOfBirth == 05))
        {
            starLabel.setText("You are a Taurus.");
        }
        else if ((dayOfBirth>= 21 && monthOfBirth == 05) ||(dayOfBirth<=21 && monthOfBirth == 06))
        {
            starLabel.setText("You are a Gemini.");
        }
        else if ((dayOfBirth>=22 && monthOfBirth== 06)||(dayOfBirth<=22 && monthOfBirth ==07))
        {
            starLabel.setText("You are a Cancer.");
        }
        else if ((dayOfBirth>=23 && monthOfBirth==07)||(dayOfBirth<=22 && monthOfBirth == 8))
        {
            starLabel.setText("You are a Leo.");
        }
        else if ((dayOfBirth>=23 && monthOfBirth ==8)||(dayOfBirth<=22 && monthOfBirth ==9))
        {
            starLabel.setText("You are a Virgo.");
        }
        else if ((dayOfBirth>=23 && monthOfBirth == 9)||(dayOfBirth<=22 && monthOfBirth == 10))
        {
            starLabel.setText("You are a Libra.");
        }
        else if ((dayOfBirth>=23 && monthOfBirth==10)||(dayOfBirth<=21 && monthOfBirth == 11))
        {
            starLabel.setText("You are a Scorpio.");
        }
        else if ((dayOfBirth>=22 && monthOfBirth == 11)||(dayOfBirth<= 21 && monthOfBirth ==12))
        {
            starLabel.setText("You are a Sagittarius");
        }
        else if ((dayOfBirth>=22 && monthOfBirth == 12)||(dayOfBirth<= 19 && monthOfBirth ==01))
        {
            starLabel.setText("You are a Capricorn,");
        }
        else
        {
            starLabel.setText("No Star Sign!!!");
        }
    }
}
