package oop_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CarReservationSystem {

    private ArrayList<Customer> cus; // ArrayLists to manage customers, cars, and reservations
    private ArrayList<Car> cars;
    private ArrayList<Reservation> rtn;
    private WelcomeMessage welcome;

    public CarReservationSystem() { // Constructor initializes the ArrayLists and the welcome message
        cus = new ArrayList<>();
        cars = new ArrayList<>();
        rtn = new ArrayList<>();
        welcome = new WelcomeMessage();
    }

    public void addC(Customer customer) { // Method to add a customer to the list
        cus.add(customer);
    }

    public void addCar(Car car) { // Method to add a car to the list
        cars.add(car);
    }

    public void addR(Reservation r) { // Method to add a reservation to the list
        rtn.add(r);
    }

    public class WelcomeMessage extends JFrame implements ActionListener {

        JLabel lbl = new JLabel("Welcome to Vroom Car Agency!");
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200); //sets the colour of the frame
        private Color red = new Color(220, 90, 90); //sets the colour of the button
        JLabel displayI;
        ImageIcon image;

        public WelcomeMessage() {
            super("Welcome");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            image = new ImageIcon(getClass().getResource("bluecar.png"));

            Image scaledImage = image.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
            image = new ImageIcon(scaledImage);

            displayI = new JLabel(image);

            displayI.setBounds(50, 30, 250, 150); //sets the location of the image

            add(displayI, BorderLayout.CENTER); //adds image to the frame
            setLayout(null);

            lbl.setBounds(100, 20, 200, 20);
            btn.setBounds(120, 150, 130, 25);
            con.setBackground(babypink);
            add(lbl);
            add(btn);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE); //sets the colour of letters in the button 
            btn.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when 'X' button is clicked
            setSize(420, 230); //sets the size of frame
            setLocationRelativeTo(null); //sets the frame to be in the middle of the screen
            setVisible(true); //ensures the frame is visible
        }

        public void actionPerformed(ActionEvent e) {

            dispose(); //disposes current frame
            WelcomeMessage2 welcome2 = new WelcomeMessage2();
            welcome2.setVisible(true); //sets another frame to be visible

        }
    }

    public class WelcomeMessage2 extends JFrame implements ActionListener { // Welcome message frame retrieves username from user

        JLabel name = new JLabel("How should we address you?");
        JLabel name2 = new JLabel("Enter name: ");
        JTextField name3 = new JTextField(40);
        JButton btn2 = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);

        public WelcomeMessage2() {
            super("Welcome");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            con.setBackground(babypink);
            setLayout(null); //sets the location of the JLabels, JTextfields and buttons

            name.setBounds(120, 20, 200, 20);
            add(name);

            name2.setBounds(90, 40, 75, 20);
            add(name2);

            name3.setBounds(200, 40, 180, 20);
            add(name3);

            btn2.setBounds(200, 60, 130, 25);
            btn2.setBackground(red);
            btn2.setForeground(Color.WHITE);
            btn2.addActionListener(this);
            add(btn2);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(450, 150);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {

            try {
                if (name3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a username", "Error message", JOptionPane.ERROR_MESSAGE); //shows an error message if it is left empty
                    return;
                }
                String enteredun = name3.getText();
                UserName.setUserName(enteredun); //stores the username in UserName clas

                dispose();
                MainMenu mm = new MainMenu();
                mm.setVisible(true);

            } catch (Exception ee) {
                JOptionPane.showMessageDialog(this, "Invalid username", "Error message", JOptionPane.ERROR_MESSAGE);
                return;

            }

        }

    }

    public class MainMenu extends JFrame implements ActionListener { //Main Menu with 6 functions

        JLabel lbl = new JLabel("Hi, what would you like to do?");
        String userName;
        JButton btn1 = new JButton("Create an account");
        JButton btn2 = new JButton("Make reservation");
        JButton btn3 = new JButton("Edit reservation");
        JButton btn4 = new JButton("Cancel reservation");
        JButton btn5 = new JButton("View all reservation history");
        JButton btn6 = new JButton("Exit");
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color lav = new Color(206, 170, 224);
        private Color grey = new Color(80, 80, 80);

        public MainMenu() {
            super("Main Menu");
            makeFrame();
            showFrame();

        }

        public void makeFrame() {
            String un = UserName.getUserName(); //retrieves stores username from UserName class
            lbl.setText("Hi " + un + "," + " what would you like to do?");
            con.setBackground(grey);
            setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.add(lbl);
            add(panel, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new GridLayout(3, 2));

            btn1.addActionListener(this);
            btn2.addActionListener(this);
            btn3.addActionListener(this);
            btn4.addActionListener(this);
            btn5.addActionListener(this);
            btn6.addActionListener(this);
            con.setBackground(grey);
            btn1.setBackground(lav);
            btn1.setForeground(Color.BLACK);
            btn2.setBackground(darklav);
            btn2.setForeground(Color.BLACK);
            btn3.setBackground(darklav);
            btn3.setForeground(Color.BLACK);
            btn4.setBackground(lav);
            btn4.setForeground(Color.BLACK);
            btn5.setBackground(lav);
            btn5.setForeground(Color.BLACK);
            btn6.setBackground(darklav);
            btn6.setForeground(Color.BLACK);

            buttonPanel.add(btn1);
            buttonPanel.add(btn2);
            buttonPanel.add(btn3);
            buttonPanel.add(btn4);
            buttonPanel.add(btn5);
            buttonPanel.add(btn6);

            add(buttonPanel);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(450, 300);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) { //when each button is clicked, the respective frame is made visible
            Object source = e.getSource();
            if (source == btn1) {
                dispose();
                CreateAccount ca = new CreateAccount();
                ca.setVisible(true);
            } else if (source == btn2) {
                dispose();
                Login l = new Login();
                l.setVisible(true);
            } else if (source == btn3) {
                dispose();
                Login2 l2 = new Login2();
                l2.setVisible(true);
            } else if (source == btn4) {
                dispose();
                DeleteReservation re = new DeleteReservation();
                re.setVisible(true);
            } else if (source == btn5) {
                dispose();
                Identification view = new Identification();
                view.setVisible(true);
            } else if (source == btn6) {
                dispose();
                Exit ex = new Exit();
                ex.setVisible(true);
            }
        }

    }

    public class CreateAccount extends JFrame implements ActionListener { //collects user's personal details

        JLabel lbl = new JLabel("Please complete your profile");
        JLabel lbl2 = new JLabel("Full name");
        JLabel lbl3 = new JLabel("Age");
        JLabel lbl4 = new JLabel("Contact number");
        JLabel lbl5 = new JLabel("Customer ID");
        JLabel lbl6 = new JLabel("Password");
        JTextField name = new JTextField(20);
        JTextField age = new JTextField(20);
        JTextField cn = new JTextField("+60");
        JTextField id = new JTextField(20);
        JTextField pw = new JTextField(20);
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color lav = new Color(206, 170, 224);
        private Color red = new Color(220, 90, 90);

        public CreateAccount() {
            super("Create an account");

            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            add(lbl);
            lbl.setBounds(120, 20, 200, 20);

            add(lbl2);
            lbl2.setBounds(120, 60, 100, 20);

            add(name);
            name.setBounds(220, 60, 200, 20);

            add(lbl3);
            lbl3.setBounds(120, 90, 100, 20);

            add(age);
            age.setBounds(220, 90, 200, 20);

            add(lbl4);
            lbl4.setBounds(120, 120, 100, 20);

            add(cn);
            cn.setBounds(220, 120, 200, 20);

            add(lbl5);
            lbl5.setBounds(120, 150, 100, 20);

            add(id);
            id.setBounds(220, 150, 200, 20);

            add(lbl6);
            lbl6.setBounds(120, 180, 100, 20);

            add(pw);
            pw.setBounds(220, 180, 200, 20);

            add(btn);
            btn.setBounds(220, 210, 150, 20);
            con.setBackground(lav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);

        }

        public boolean uniqueCusID() { //ensures Customer ID created is unique
            for (Customer cust : cus) {
                if (id.getText().equals(cust.getCusID())) {
                    return false;
                }
            }
            return true;
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 300);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {

            try { //ensures customer's information follow the right format
                if (name.getText().isEmpty() || age.getText().isEmpty() || cn.getText().isEmpty() || id.getText().isEmpty() || pw.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String a = age.getText();
                int cusAge = Integer.parseInt(a);

                if (cusAge < 18) { //ensures age is 18 and above
                    JLabel errorMessage = new JLabel("You are required to be at least 18 years old to register!");
                    errorMessage.setForeground(Color.RED);

                    JOptionPane.showMessageDialog(null, errorMessage, "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String b = id.getText();
                if (!b.matches("\\d{4}")) { //ensures ID contains 4 digits
                    JOptionPane.showMessageDialog(this, "ID must contain 4 digits", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!uniqueCusID()) {
                    JOptionPane.showMessageDialog(this, "This ID already exists. Please enter new ID", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                String c = pw.getText();
                if (c.length() < 5) { //ensures password is at least 5 characters
                    JOptionPane.showMessageDialog(this, "Password must contain at least 5 characters", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Customer newCus = new Customer(name.getText(), cusAge, cn.getText(), id.getText(), pw.getText());
                cus.add(newCus);
                dispose();
                MainMenu mm = new MainMenu();
                mm.setVisible(true);

            } catch (NumberFormatException ee) { //shows error if non-digits are entered in a JTextfield which requires digits
                JOptionPane.showMessageDialog(this, "Incorrect format", "Error message", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    public class Login extends JFrame implements ActionListener { //requests for Customer ID and password

        JLabel cusid = new JLabel("Enter customer ID");
        JLabel passw = new JLabel("Enter password");
        JTextField Cusid = new JTextField(20);
        JPasswordField Passw = new JPasswordField(20);
        JButton btn = new JButton("Enter");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);

        public Login() {
            super("Identification");

            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            con.setBackground(babypink);
            setLayout(null);

            cusid.setBounds(120, 20, 200, 20);
            add(cusid);
            passw.setBounds(120, 40, 200, 20);
            add(passw);
            Cusid.setBounds(250, 20, 100, 20);
            add(Cusid);
            Passw.setBounds(250, 40, 100, 20);
            add(Passw);
            btn.setBounds(180, 70, 130, 25);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            add(btn);

        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 180);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            String enteredid = Cusid.getText();
            String enteredpw = Passw.getText();

            if (Cusid.getText().isEmpty() || Passw.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean correct = false; //ensures ID and password matches the ones in the ArrayList
            for (Customer user : cus) {
                if (user.getCusID().equals(enteredid) && user.getPassword().equals(enteredpw)) {
                    correct = true;
                    break;
                }

            }
            if (correct) {
                dispose();
                MakeReservation mr = new MakeReservation();
                mr.setVisible(true);
            } else {//ensures ID and password is valid
                JOptionPane.showMessageDialog(this, "Incorrect ID or password", "Error message", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public class Login2 extends JFrame implements ActionListener {

        JLabel cusid = new JLabel("Enter customer ID");
        JLabel passw = new JLabel("Enter password");
        JTextField Cusid = new JTextField(20);
        JPasswordField Passw = new JPasswordField(20);
        JButton btn = new JButton("Enter");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);

        public Login2() {
            super("Identification");

            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            con.setBackground(babypink);
            setLayout(null);

            cusid.setBounds(120, 20, 200, 20);
            add(cusid);
            passw.setBounds(120, 40, 200, 20);
            add(passw);
            Cusid.setBounds(250, 20, 100, 20);
            add(Cusid);
            Passw.setBounds(250, 40, 100, 20);
            add(Passw);
            btn.setBounds(180, 70, 130, 25);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            add(btn);

        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 180);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            String enteredid = Cusid.getText();
            String enteredpw = Passw.getText();

            if (Cusid.getText().isEmpty() || Passw.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean correct = false;
            for (Customer user : cus) {
                if (user.getCusID().equals(enteredid) && user.getPassword().equals(enteredpw)) {
                    correct = true;
                    break;
                }

            }
            if (correct) {
                dispose();
                EditReservation er = new EditReservation();
                er.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect ID or password", "Error message", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public class SuccessfulReservation extends JFrame implements ActionListener { //reveals the outcome of reservation

        JLabel title = new JLabel("Your reservation was successful!");

        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);
        JLabel displayI;
        ImageIcon image;

        public SuccessfulReservation() {
            super("Outcome message");

            makeFrame();
            showFrame();

        }

        public void makeFrame() {

            con.setBackground(babypink);
            setLayout(null);

            title.setBounds(100, 20, 200, 20);
            add(title);

            image = new ImageIcon(getClass().getResource("pinkcar.png"));

            Image scaledImage = image.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
            image = new ImageIcon(scaledImage);

            displayI = new JLabel(image);

            displayI.setBounds(50, 60, 250, 150);

            add(displayI, BorderLayout.CENTER);

            btn.setBounds(120, 240, 130, 25);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            add(btn);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(440, 340);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            dispose();
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        }

    }

    public class MakeReservation extends JFrame implements ActionListener { //allows user to pick a car

        JLabel title = new JLabel("Make a reservation: Pick a car");

        JLabel cart = new JLabel("Car Type");
        JLabel carb = new JLabel("Car Brand");
        JLabel carm = new JLabel("Car Model");
        JLabel carc = new JLabel("Car Category");
        JLabel carsc = new JLabel("Car Seat Capacity");
        JTextField type = new JTextField(20);
        JTextField category = new JTextField(20);
        JTextField brand = new JTextField(20);
        JTextField model = new JTextField(20);
        JTextField carseatcap = new JTextField(20);
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);

        public MakeReservation() {
            super("Make a reservation");

            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            add(title);
            title.setBounds(100, 10, 200, 20);

            add(cart);
            cart.setBounds(100, 40, 100, 20);

            add(type);
            type.setBounds(220, 40, 200, 20);

            add(carc);
            carc.setBounds(100, 130, 100, 20);

            add(category);
            category.setBounds(220, 130, 200, 20);

            add(carb);
            carb.setBounds(100, 70, 100, 20);

            add(brand);
            brand.setBounds(220, 70, 200, 20);

            add(carm);
            carm.setBounds(100, 100, 100, 20);

            add(model);
            model.setBounds(220, 100, 200, 20);

            add(carsc);
            carsc.setBounds(100, 160, 200, 20);

            add(carseatcap);
            carseatcap.setBounds(220, 160, 200, 20);

            add(btn);
            btn.setBounds(220, 190, 150, 20);
            con.setBackground(darklav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 270);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {

            try {
                String s = carseatcap.getText();
                int seatCap = Integer.parseInt(s);
                if (brand.getText().isEmpty() || model.getText().isEmpty() || carseatcap.getText().isEmpty() || type.getText().isEmpty() || category.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //ensures car type is either Manual or Automatic
                if (!type.getText().equalsIgnoreCase("Manual") && !type.getText().equalsIgnoreCase("Automatic")) {
                    JOptionPane.showMessageDialog(this, "Car type consists of either Manual or Automatic", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;

                } else if (seatCap > 12 || seatCap < 2) { //ensures the car seat capacity is between 2 and 12 seats
                    JOptionPane.showMessageDialog(this, "Car seat capacity should be between 2 and 12 seats", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Car newCar = new Car(type.getText(), brand.getText(), model.getText(), category.getText(), seatCap);
                cars.add(newCar); //a new car is added if all the criteria is fulfilled
                dispose();
                SuccessfulresID srID = new SuccessfulresID();
                srID.setVisible(true);

            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(this, "Incorrect format", "Error message", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    public class SuccessfulresID extends JFrame implements ActionListener {

        JLabel title = new JLabel("Your reservation ID has been sent to your phone number");
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);

        public SuccessfulresID() {
            super("Your reservation ID");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            title.setBounds(30, 20, 330, 20);
            btn.setBounds(110, 50, 150, 20);
            con.setBackground(darklav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            add(title);
            add(btn);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(390, 150);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
            MakeReservation2 mr2 = new MakeReservation2();
            mr2.setVisible(true);
        }

    }

    public class MakeReservation2 extends JFrame implements ActionListener { //allows user to set a date and time

        JLabel title = new JLabel("Make a reservation: Set a date and time");
        JLabel fr = new JLabel("From: ");
        JLabel to = new JLabel("To: ");
        JLabel date = new JLabel("Date");
        JLabel time = new JLabel("Time");
        JLabel date2 = new JLabel("Date");
        JLabel time2 = new JLabel("Time");
        JTextField Rid = new JTextField(20);
        JLabel rid = new JLabel("Reservation ID");

        JTextField Date = new JTextField(20);
        JTextField Time = new JTextField(20);
        JTextField Date2 = new JTextField(20);
        JTextField Time2 = new JTextField(20);

        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);

        public MakeReservation2() {
            super("Make a reservation");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            title.setBounds(50, 10, 300, 20);
            rid.setBounds(50, 30, 200, 20);
            Rid.setBounds(150, 30, 100, 20);

            fr.setBounds(50, 50, 50, 20);
            to.setBounds(220, 50, 50, 20);
            date.setBounds(50, 80, 50, 20);
            Date.setBounds(100, 80, 100, 20);

            date2.setBounds(220, 80, 50, 20);
            Date2.setBounds(270, 80, 100, 20);

            time.setBounds(50, 110, 50, 20);
            Time.setBounds(100, 110, 100, 20);

            time2.setBounds(220, 110, 50, 20);
            Time2.setBounds(270, 110, 100, 20);
            btn.setBounds(170, 150, 150, 20);
            add(rid);
            add(Rid);
            add(title);
            add(fr);
            add(to);
            add(date);
            add(time);
            add(date2);
            add(time2);
            add(Date);
            add(Time);
            add(Date2);
            add(Time2);
            add(btn);
            con.setBackground(darklav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(450, 250);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public boolean uniqueResID() { //ensures reservation ID is unique
            for (Reservation res : rtn) {
                if (Rid.getText().equals(res.getResID())) {
                    return false;
                }
            }
            return true;
        }

        public void actionPerformed(ActionEvent e) {

            try {

                if (Rid.getText().isEmpty() || Date.getText().isEmpty() || time.getText().isEmpty() || Date2.getText().isEmpty() || time2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!Rid.getText().matches("\\d{4}")) {
                    JOptionPane.showMessageDialog(this, "Reservation ID consists of 4 digits", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!uniqueResID()) { //ensures reservation ID is unique
                    JOptionPane.showMessageDialog(this, "This ID already exists. Please enter new ID", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                //ensures the date follows a specific format
                if (!Date.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") || !Date2.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                    JOptionPane.showMessageDialog(this, "Date should follow dd/mm/yyyy", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //ensures the end date is not before the start date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date pDate1 = dateFormat.parse(Date.getText());
                Date pDate2 = dateFormat.parse(Date2.getText());
                if (pDate2.before(pDate1)) {
                    JOptionPane.showMessageDialog(this, "End Date should not be before Start Date ", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                if (pDate1.getYear() < 123 || pDate2.getYear() < 123) { //ensures the year is 2023 onwards
                    JOptionPane.showMessageDialog(this, "Year should be from 2023 onwards", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String time = Time.getText();
                String time2 = Time2.getText();
                if (!time.matches("\\d{4}") || !time2.matches("\\d{4}")) { //ensures the time follows 24 hour system
                    JOptionPane.showMessageDialog(this, "Time should follow 24 hour system", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String t = Time.getText();
                double Time = Double.parseDouble(t);
                String t2 = Time2.getText();
                double Time2 = Double.parseDouble(t2);
                if (Time < 900 || Time > 1700) { //ensures the time is from 9 am to 5 pm
                    JOptionPane.showMessageDialog(this, "Our reservation bookings are open from 9 am to 5 pm only", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Time2 < 900 || Time2 > 1700) {
                    JOptionPane.showMessageDialog(this, "Our reservation bookings are open from 9 am to 5 pm only", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Reservation newR = new Reservation(Rid.getText(), Date.getText(), Time, Date2.getText(), Time2);
                rtn.add(newR); //adds a new reservation if all criteria has been fulfilled
                dispose();
                SuccessfulReservation sr = new SuccessfulReservation();
                sr.setVisible(true);

            } catch (ParseException | NumberFormatException ee) {
                JOptionPane.showMessageDialog(this, "Incorrect format", "Error message", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public class EditDT extends JFrame implements ActionListener { //allows user to edit the date and time

        JLabel title = new JLabel("Edit a reservation: Set a date and time");
        JLabel fr = new JLabel("From: ");
        JLabel to = new JLabel("To: ");
        JLabel date = new JLabel("Date");
        JLabel time = new JLabel("Time");
        JLabel date2 = new JLabel("Date");
        JLabel time2 = new JLabel("Time");
        JTextField Rid = new JTextField(20);
        JLabel rid = new JLabel("Reservation ID");
        JTextField Date = new JTextField(20);
        JTextField Time = new JTextField(20);
        JTextField Date2 = new JTextField(20);
        JTextField Time2 = new JTextField(20);
        JButton btn1 = new JButton("Click to continue");

        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);

        public EditDT() {
            super("Edit a reservation");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            title.setBounds(50, 10, 300, 20);
            rid.setBounds(50, 30, 200, 20);
            Rid.setBounds(150, 30, 100, 20);

            fr.setBounds(50, 50, 50, 20);
            to.setBounds(220, 50, 50, 20);
            date.setBounds(50, 80, 50, 20);
            Date.setBounds(100, 80, 100, 20);

            date2.setBounds(220, 80, 50, 20);
            Date2.setBounds(270, 80, 100, 20);

            time.setBounds(50, 110, 50, 20);
            Time.setBounds(100, 110, 100, 20);

            time2.setBounds(220, 110, 50, 20);
            Time2.setBounds(270, 110, 100, 20);
            btn1.setBounds(170, 150, 150, 20);

            add(rid);
            add(Rid);
            add(title);
            add(fr);
            add(to);
            add(date);
            add(time);
            add(date2);
            add(time2);
            add(Date);
            add(Time);
            add(Date2);
            add(Time2);
            add(btn1);

            con.setBackground(darklav);
            btn1.setBackground(red);
            btn1.setForeground(Color.WHITE);
            btn1.addActionListener(this);

        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(450, 250);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn1) {
                try {
                    if (Date.getText().isEmpty() || time.getText().isEmpty() || Date2.getText().isEmpty() || time2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!Date.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") || !Date2.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                        JOptionPane.showMessageDialog(this, "Date should follow dd/mm/yyyy", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date pDate1 = dateFormat.parse(Date.getText());
                    Date pDate2 = dateFormat.parse(Date2.getText());
                    if (pDate2.before(pDate1)) {
                        JOptionPane.showMessageDialog(this, "End Date should not be before Start Date ", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                    if (pDate1.getYear() < 123 || pDate2.getYear() < 123) {
                        JOptionPane.showMessageDialog(this, "Year should be from 2023 onwards", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String time = Time.getText();
                    String time2 = Time2.getText();
                    if (!time.matches("\\d{4}") || !time2.matches("\\d{4}")) {
                        JOptionPane.showMessageDialog(this, "Time should follow 24 hour system", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double Time = Double.parseDouble(time);
                    double Time2 = Double.parseDouble(time2);
                    if (Time < 900 || Time > 1700) {
                        JOptionPane.showMessageDialog(this, "Our reservation bookings are open from 9 am to 5 pm only", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (Time2 < 900 || Time2 > 1700) {
                        JOptionPane.showMessageDialog(this, "Our reservation bookings are open from 9 am to 5 pm only", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        String id = Rid.getText();
                        int index = findResIndex(id); //the reservation ID entered is used to locate its index in the ArrayList
                        if (index != -1) {
                            for (Reservation re : rtn) {
                                if (re != null) { //if all criteria has been met, the date and time are edited
                                    rtn.get(index).setStartTime(Time);
                                    rtn.get(index).setStartDate(Date.getText());
                                    rtn.get(index).setEndDate(Date2.getText());
                                    rtn.get(index).setEndTime(Time2);

                                }
                            }
                            dispose();
                            SuccessfulEdit se = new SuccessfulEdit();
                            se.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Reservation ID does not exist", "Error message", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                } catch (ParseException | NumberFormatException ee) {
                    JOptionPane.showMessageDialog(this, "Incorrect format", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public class EditBoth extends JFrame implements ActionListener { //allows user to edit car details

        JLabel title = new JLabel("Make a reservation: Pick a car");
        JLabel cart = new JLabel("Car Type");
        JLabel carb = new JLabel("Car Brand");
        JLabel carm = new JLabel("Car Model");
        JLabel carc = new JLabel("Car Category");
        JLabel carsc = new JLabel("Car Seat Capacity");
        JLabel rid = new JLabel("Reservation ID");
        JTextField Rid = new JTextField(20);
        JTextField type = new JTextField(20);
        JTextField category = new JTextField(20);
        JTextField brand = new JTextField(20);
        JTextField model = new JTextField(20);
        JTextField carseatcap = new JTextField(20);
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);
        private static Car editc;

        public EditBoth() {
            super("Edit a reservation");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            add(title);
            title.setBounds(100, 10, 200, 20);

            add(rid);
            rid.setBounds(100, 40, 100, 20);

            add(Rid);
            Rid.setBounds(200, 40, 100, 20);

            add(cart);
            cart.setBounds(100, 70, 100, 20);

            add(type);
            type.setBounds(220, 70, 200, 20);

            add(carc);
            carc.setBounds(100, 160, 100, 20);

            add(category);
            category.setBounds(220, 160, 200, 20);

            add(carb);
            carb.setBounds(100, 100, 100, 20);

            add(brand);
            brand.setBounds(220, 100, 200, 20);

            add(carm);
            carm.setBounds(100, 130, 100, 20);

            add(model);
            model.setBounds(220, 130, 200, 20);

            add(carsc);
            carsc.setBounds(100, 190, 200, 20);

            add(carseatcap);
            carseatcap.setBounds(220, 190, 200, 20);

            add(btn);
            btn.setBounds(220, 220, 150, 20);
            con.setBackground(darklav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 300);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn) {
                try {
                    if (Rid.getText().isEmpty() || brand.getText().isEmpty() || model.getText().isEmpty() || carseatcap.getText().isEmpty() || type.getText().isEmpty() || category.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!type.getText().equalsIgnoreCase("Manual") && !type.getText().equalsIgnoreCase("Automatic")) {
                        JOptionPane.showMessageDialog(this, "Car type consists of either Manual or Automatic", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;

                    } else if (Integer.parseInt(carseatcap.getText()) > 12 || Integer.parseInt(carseatcap.getText()) < 2) {
                        JOptionPane.showMessageDialog(this, "Car seat capacity should be  between 2 and 12 seats", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;

                    } else {

                        int index = findResIndex(Rid.getText());
                        if (index != -1) {
                            for (Car c : cars) { //the reservation ID entered is used to locate its index in the ArrayList
                                if (c != null) { //if all criteria has been met, the car details are edited
                                    cars.get(index).setCarType(type.getText());
                                    cars.get(index).setCarCat(category.getText());
                                    cars.get(index).setCarBrand(brand.getText());
                                    cars.get(index).setCarModel(model.getText());
                                    cars.get(index).setCarSeat(Integer.parseInt(carseatcap.getText()));
                                }
                            }
                            dispose();
                            EditBoth2 eb2 = new EditBoth2();
                            eb2.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Reservation ID does not exist", "Error message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(this, "Incorrect format", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public class EditBoth2 extends JFrame implements ActionListener {

        JLabel title = new JLabel("Edit a reservation: Set a date and time");
        JLabel fr = new JLabel("From: ");
        JLabel to = new JLabel("To: ");
        JLabel date = new JLabel("Date");
        JLabel time = new JLabel("Time");
        JLabel date2 = new JLabel("Date");
        JLabel time2 = new JLabel("Time");
        JLabel rid = new JLabel("Reservation ID");
        JTextField Rid = new JTextField(20);
        JTextField Date = new JTextField(20);
        JTextField Time = new JTextField(20);
        JTextField Date2 = new JTextField(20);
        JTextField Time2 = new JTextField(20);
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);
        private static Reservation editr;

        public EditBoth2() {
            super("Edit a reservation");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            title.setBounds(50, 10, 300, 20);
            rid.setBounds(50, 30, 200, 20);
            Rid.setBounds(150, 30, 100, 20);

            fr.setBounds(50, 50, 50, 20);
            to.setBounds(220, 50, 50, 20);

            date.setBounds(50, 80, 50, 20);
            Date.setBounds(100, 80, 100, 20);

            date2.setBounds(220, 80, 50, 20);
            Date2.setBounds(270, 80, 100, 20);

            time.setBounds(50, 110, 50, 20);
            Time.setBounds(100, 110, 100, 20);

            time2.setBounds(220, 110, 50, 20);
            Time2.setBounds(270, 110, 100, 20);
            btn.setBounds(170, 150, 150, 20);

            add(rid);
            add(Rid);
            add(title);
            add(fr);
            add(to);
            add(date);
            add(time);
            add(date2);
            add(time2);
            add(Date);
            add(Time);
            add(Date2);
            add(Time2);
            add(btn);
            con.setBackground(darklav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(450, 250);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn) {
                try {
                    if (Date.getText().isEmpty() || time.getText().isEmpty() || Date2.getText().isEmpty() || time2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!Date.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") || !Date2.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                        JOptionPane.showMessageDialog(this, "Date should follow dd/mm/yyyy", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date pDate1 = dateFormat.parse(Date.getText());
                    Date pDate2 = dateFormat.parse(Date2.getText());
                    if (pDate2.before(pDate1)) {
                        JOptionPane.showMessageDialog(this, "End Date should not be before Start Date ", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                    if (pDate1.getYear() < 123 || pDate2.getYear() < 123) {
                        JOptionPane.showMessageDialog(this, "Year should be from 2023 onwards", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String time = Time.getText();
                    String time2 = Time2.getText();
                    if (!time.matches("\\d{4}") || !time2.matches("\\d{4}")) {
                        JOptionPane.showMessageDialog(this, "Time should follow 24 hour system", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double Time = Double.parseDouble(time);
                    double Time2 = Double.parseDouble(time2);
                    if (Time < 900 || Time > 1700) {
                        JOptionPane.showMessageDialog(this, "Our reservation bookings are open from 9 am to 5 pm only", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (Time2 < 900 || Time2 > 1700) {
                        JOptionPane.showMessageDialog(this, "Our reservation bookings are open from 9 am to 5 pm only", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        String id = Rid.getText();
                        int index = findResIndex(id);
                        if (index != -1) {
                            for (Reservation re : rtn) {
                                if (re != null) {
                                    rtn.get(index).setStartTime(Time);
                                    rtn.get(index).setStartDate(Date.getText());
                                    rtn.get(index).setEndDate(Date2.getText());
                                    rtn.get(index).setEndTime(Time2);

                                }
                            }
                            dispose();
                            SuccessfulEdit success = new SuccessfulEdit();
                            success.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Reservation ID does not exist", "Error message", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                } catch (ParseException | NumberFormatException ee) {
                    JOptionPane.showMessageDialog(this, "Incorrect format", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    public class EditCar extends JFrame implements ActionListener {

        JLabel title = new JLabel("Make a reservation: Pick a car");
        JLabel cart = new JLabel("Car Type");
        JLabel carb = new JLabel("Car Brand");
        JLabel carm = new JLabel("Car Model");
        JLabel carc = new JLabel("Car Category");
        JLabel carsc = new JLabel("Car Seat Capacity");
        JTextField Rid = new JTextField(20);
        JLabel rid = new JLabel("Reservation ID");
        JTextField type = new JTextField(20);
        JTextField category = new JTextField(20);
        JTextField brand = new JTextField(20);
        JTextField model = new JTextField(20);
        JTextField carseatcap = new JTextField(20);
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);

        public EditCar() {
            super("Edit a reservation");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            add(title);
            title.setBounds(100, 10, 200, 20);

            add(rid);
            rid.setBounds(100, 40, 100, 20);

            add(Rid);
            Rid.setBounds(200, 40, 100, 20);

            add(cart);
            cart.setBounds(100, 70, 100, 20);

            add(type);
            type.setBounds(220, 70, 200, 20);

            add(carc);
            carc.setBounds(100, 160, 100, 20);

            add(category);
            category.setBounds(220, 160, 200, 20);

            add(carb);
            carb.setBounds(100, 100, 100, 20);

            add(brand);
            brand.setBounds(220, 100, 200, 20);

            add(carm);
            carm.setBounds(100, 130, 100, 20);

            add(model);
            model.setBounds(220, 130, 200, 20);

            add(carsc);
            carsc.setBounds(100, 190, 200, 20);

            add(carseatcap);
            carseatcap.setBounds(220, 190, 200, 20);

            add(btn);
            btn.setBounds(220, 220, 150, 20);
            con.setBackground(darklav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 300);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn) {

                try {
                    if (Rid.getText().isEmpty() || brand.getText().isEmpty() || model.getText().isEmpty() || carseatcap.getText().isEmpty() || type.getText().isEmpty() || category.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!type.getText().equalsIgnoreCase("Manual") && !type.getText().equalsIgnoreCase("Automatic")) {
                        JOptionPane.showMessageDialog(this, "Car type consists of either Manual or Automatic", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;

                    } else if (Integer.parseInt(carseatcap.getText()) > 12 || Integer.parseInt(carseatcap.getText()) < 2) {
                        JOptionPane.showMessageDialog(this, "Car seat capacity should be between 2 and 12 seats", "Error message", JOptionPane.ERROR_MESSAGE);
                        return;

                    } else {

                        int index = findResIndex(Rid.getText());
                        if (index != -1) {
                            for (Car c : cars) {
                                if (c != null) {
                                    cars.get(index).setCarType(type.getText());
                                    cars.get(index).setCarCat(category.getText());
                                    cars.get(index).setCarBrand(brand.getText());
                                    cars.get(index).setCarModel(model.getText());
                                    cars.get(index).setCarSeat(Integer.parseInt(carseatcap.getText()));
                                }
                            }
                            dispose();
                            SuccessfulEdit se = new SuccessfulEdit();
                            se.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Reserveration ID is not exits", "Error message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(this, "Incorrect format", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public class SuccessfulEdit extends JFrame implements ActionListener {

        JLabel title = new JLabel("Your reservation was edited");
        JButton btn = new JButton("Click to continue");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);

        public SuccessfulEdit() {
            super("Outcome message");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(new FlowLayout());
            con.setBackground(babypink);
            add(title);
            add(btn);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);

        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 100);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            dispose();
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        }
    }

    public class EditReservation extends JFrame implements ActionListener { //allows user to select which part of the reservation they would like to edit

        JLabel title = new JLabel("Edit reservation");
        JLabel ques = new JLabel("Which would you like to edit? ");
        JButton carbtn = new JButton("Car");
        JButton dt = new JButton("Date and time");
        JButton both = new JButton("Both");
        private Container con = getContentPane();
        private Color darklav = new Color(106, 60, 114);
        private Color lav = new Color(206, 170, 224);

        public EditReservation() {
            super("Edit a reservation");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            title.setBounds(50, 20, 300, 20);
            ques.setBounds(50, 50, 300, 20);
            carbtn.setBounds(50, 80, 80, 20);
            dt.setBounds(150, 80, 150, 20);
            both.setBounds(100, 110, 80, 20);
            add(title);
            add(ques);
            add(carbtn);
            add(dt);
            add(both);
            con.setBackground(lav);
            carbtn.setBackground(darklav);
            carbtn.setForeground(Color.BLACK);
            carbtn.addActionListener(this);
            dt.setBackground(darklav); //make this darkerrrr
            dt.setForeground(Color.BLACK);
            dt.addActionListener(this);
            both.setBackground(darklav);
            both.setForeground(Color.BLACK);
            both.addActionListener(this);

        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 200);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == carbtn) {
                dispose();
                EditCar ec = new EditCar();
                ec.setVisible(true);
            } else if (source == dt) {
                dispose();
                EditDT edt = new EditDT();
                edt.setVisible(true);
            } else if (source == both) {
                dispose();
                EditBoth eb = new EditBoth();
                eb.setVisible(true);

            }
        }
    }

    public class DeleteReservation extends JFrame implements ActionListener { //deletes reservation

        JLabel title = new JLabel("Identification ");
        JLabel title2 = new JLabel("Note: Enter your reservation id that you wish to cancel.");
        JLabel cusid = new JLabel("Enter customer ID");
        JLabel pass = new JLabel("Enter password");
        JLabel resID = new JLabel("Enter reservation ID");
        JTextField TextCusID = new JTextField(20);
        JPasswordField TextPass = new JPasswordField(20);
        JTextField TextResID = new JTextField(20);
        JButton btn = new JButton("Enter");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);

        public DeleteReservation() {
            super("Cancel reservation");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            con.setBackground(babypink);
            setLayout(null);
            title.setBounds(10, 5, 200, 20);
            add(title);
            title2.setBounds(10, 20, 450, 20);
            add(title2);
            cusid.setBounds(50, 50, 200, 20);
            add(cusid);
            pass.setBounds(50, 70, 200, 20);
            add(pass);
            resID.setBounds(50, 90, 200, 20);
            add(resID);
            TextCusID.setBounds(250, 50, 100, 20);
            add(TextCusID);
            TextPass.setBounds(250, 70, 100, 20);
            add(TextPass);
            TextResID.setBounds(250, 90, 100, 20);
            add(TextResID);
            btn.setBounds(130, 120, 130, 25);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            add(btn);
            btn.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 200);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn) {
                setVisible(true);

                String cusid = TextCusID.getText();
                String pw = TextPass.getText();
                String RID = TextResID.getText();

                if (TextCusID.getText().isEmpty() || TextPass.getText().isEmpty() || TextResID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                boolean correct = false;

                for (Customer user : cus) {

                    if (user.getCusID().equals(cusid) && user.getPassword().equals(pw)) {
                        correct = true;
                        break;
                    }
                }
                if (correct) {
                    int index = findResIndex(RID);
                    if (index != -1) {
                        int yes = JOptionPane.showConfirmDialog(this,
                                "Are you sure you would like to confirm cancellation?");
                        if (yes == JOptionPane.YES_OPTION) { //if it is clicked, the date and time and car details from that index is deleted
                            rtn.remove(index);
                            cars.remove(index);
                            JOptionPane.showMessageDialog(this,
                                    "Your reservation was cancelled");
                            dispose();
                            MainMenu mm = new MainMenu();
                            mm.setVisible(true);
                        } else if (yes == JOptionPane.NO_OPTION || yes == JOptionPane.CANCEL_OPTION) {
                            JOptionPane.showMessageDialog(this,
                                    "Cancellation was cancelled");
                        } else {
                            JOptionPane.showMessageDialog(this,
                                    "Invalid reservation ID",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Your reservation ID does not exist.", "Error message", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect ID or password", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public int findResIndex(String resrID) { //receives reservation ID, locates and returns its index if found
        for (int i = 0; i < rtn.size(); i++) {
            for (Reservation re : rtn) {
                if (rtn.get(i).getResID().equals(resrID)) {
                    return i;
                }
            }
        }
        return -1; //returns -1 if not found
    }

    public class Identification extends JFrame implements ActionListener {

        JLabel cusid = new JLabel("Enter customer ID");
        JLabel pass = new JLabel("Enter password");
        JTextField TextCusID = new JTextField(20);
        JPasswordField TextPass = new JPasswordField(20);
        JButton btn = new JButton("Enter");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);

        public Identification() {
            super("Identification");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            setLayout(null);
            cusid.setBounds(120, 20, 200, 20);
            add(cusid);
            pass.setBounds(120, 40, 200, 20);
            add(pass);
            TextCusID.setBounds(250, 20, 100, 20);
            add(TextCusID);
            TextPass.setBounds(250, 40, 100, 20);
            add(TextPass);
            btn.setBounds(180, 70, 130, 25);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            add(btn);
            con.setBackground(babypink);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 180);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            String idToCheck = TextCusID.getText();
            String pwTCcheck = TextPass.getText();

            if (TextCusID.getText().isEmpty() || TextPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean correct = false;
            for (Customer user : cus) {
                if (user.getCusID().equals(idToCheck) && user.getPassword().equals(pwTCcheck)) {
                    correct = true;
                    break;
                }
            }
            if (correct) {
                dispose();
                ViewReservation view = new ViewReservation();
                view.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect ID or password", "Error message", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public class ViewReservation extends JFrame implements ActionListener { //allows user to view reservation history

        JLabel title = new JLabel("View all reservation history");
        JLabel resID = new JLabel("Enter reservation ID");
        JTextField TextResID = new JTextField(20);
        JLabel cart = new JLabel("Car Type");
        JLabel carb = new JLabel("Car Brand");
        JLabel carm = new JLabel("Car Model");
        JLabel carc = new JLabel("Car Category");
        JLabel carsc = new JLabel("Car Seat Capacity");
        JLabel fr = new JLabel("From: ");
        JLabel to = new JLabel("To: ");
        JLabel date = new JLabel("Date");
        JLabel time = new JLabel("Time");
        JLabel date2 = new JLabel("Date");
        JLabel time2 = new JLabel("Time");
        JTextField type = new JTextField(20);
        JTextField category = new JTextField(20);
        JTextField brand = new JTextField(20);
        JTextField model = new JTextField(20);
        JTextField carseatcap = new JTextField(20);
        JTextField Date = new JTextField(20);
        JTextField Time = new JTextField(20);
        JTextField Date2 = new JTextField(20);
        JTextField Time2 = new JTextField(20);
        JButton btn2 = new JButton("View");
        JButton btn = new JButton("Close");
        //.setEditable(false);
        private Container con = getContentPane();
        private Color darklav = new Color(186, 150, 204);
        private Color red = new Color(220, 90, 90);

        private static Reservation re;

        public ViewReservation() {
            super("View reservation");
            makeFrame();
            showFrame();

        }

        public void makeFrame() {
            setLayout(null);
            title.setBounds(10, 5, 200, 20);
            add(title);

            resID.setBounds(10, 25, 200, 20);
            add(resID);

            TextResID.setBounds(250, 25, 100, 20);
            add(TextResID);

            cart.setBounds(100, 60, 100, 20);
            add(cart);

            type.setBounds(220, 60, 200, 20);
            add(type);

            carc.setBounds(100, 150, 100, 20);
            add(carc);

            category.setBounds(220, 150, 200, 20);
            add(category);

            carb.setBounds(100, 90, 100, 20);
            add(carb);

            brand.setBounds(220, 90, 200, 20);
            add(brand);

            carm.setBounds(100, 120, 100, 20);
            add(carm);

            model.setBounds(220, 120, 200, 20);
            add(model);

            carsc.setBounds(100, 180, 200, 20);
            add(carsc);

            carseatcap.setBounds(220, 180, 200, 20);
            add(carseatcap);

            fr.setBounds(80, 210, 50, 20);
            add(fr);

            to.setBounds(280, 210, 50, 20);
            add(to);

            date.setBounds(80, 240, 50, 20);
            add(date);

            Date.setBounds(130, 240, 100, 20);
            add(Date);

            date2.setBounds(280, 240, 50, 20);
            add(date2);
            Date2.setBounds(330, 240, 100, 20);
            add(Date2);

            time.setBounds(80, 270, 50, 20);
            add(time);
            Time.setBounds(130, 270, 100, 20);
            add(Time);

            time2.setBounds(280, 270, 50, 20);
            add(time2);
            Time2.setBounds(330, 270, 100, 20);
            add(Time2);
            btn.setBounds(370, 310, 150, 20);
            add(btn);
            btn2.setBounds(400, 25, 100, 20);
            add(btn2);

            con.setBackground(darklav);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            btn2.setBackground(red);
            btn2.setForeground(Color.WHITE);
            btn2.addActionListener(this);
        }

        public void showFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 400);
            setLocationRelativeTo(null);
            type.setEditable(false);
            category.setEditable(false);
            brand.setEditable(false);
            model.setEditable(false);
            carseatcap.setEditable(false);
            Date.setEditable(false);
            Time.setEditable(false);
            Date2.setEditable(false);
            Time2.setEditable(false);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn2) {
                String id = TextResID.getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill up your Reservation ID", "Error message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int index = findResIndex(id); //index is retrieved 
                if (index != -1) {
                    for (Car viewCar : cars) {

                        if (viewCar != null) { //its car details are displayed 
                            type.setText(cars.get(index).getCarType());
                            category.setText(cars.get(index).getCarCat());
                            brand.setText(cars.get(index).getCarBrand());
                            model.setText(cars.get(index).getCarModel());
                            carseatcap.setText(String.valueOf(cars.get(index).getCarSeat()));
                        }
                    }

                    for (Reservation re : rtn) {
                        if (re != null) { //its date and time details are displayed
                            Date.setText(rtn.get(index).getStartDate());
                            Date2.setText(rtn.get(index).getEndDate());
                            double sTime = rtn.get(index).getStartTime();
                            long roundSTime = Math.round(sTime);
                            Time.setText(String.valueOf(roundSTime));
                            double eTime = rtn.get(index).getEndTime();
                            long roundETime = Math.round(eTime);
                            Time2.setText(String.valueOf(roundETime));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Your reservation ID does not exist", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == btn) {
                dispose();
                MainMenu mm = new MainMenu();
                mm.setVisible(true);
            }
        }
    }

    public class Exit extends JFrame implements ActionListener { //allows user to exit the system

        JLabel lbl = new JLabel("Thank you for visiting Vroom Car agency!");
        JButton btn = new JButton("Click to exit");
        JButton btn2 = new JButton("Cancel");
        private Container con = getContentPane();
        private Color babypink = new Color(255, 218, 200);
        private Color red = new Color(220, 90, 90);
        JLabel displayI;
        ImageIcon image;

        public Exit() {
            super("Exit");
            makeFrame();
            showFrame();
        }

        public void makeFrame() {
            image = new ImageIcon(getClass().getResource("carflowers.png"));
            Image scaledImage = image.getImage().getScaledInstance(155, 140, Image.SCALE_SMOOTH);
            image = new ImageIcon(scaledImage);
            displayI = new JLabel(image);
            displayI.setBounds(50, 40, 250, 100);
            add(displayI, BorderLayout.CENTER);
            setLayout(null);
            lbl.setBounds(60, 20, 300, 20);
            btn.setBounds(180, 150, 160, 32);
            btn2.setBounds(50, 150, 100, 32);
            con.setBackground(babypink);
            add(lbl);
            add(btn);
            btn.setBackground(red);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            add(btn2);
            btn2.setBackground(red);
            btn2.setForeground(Color.WHITE);
            btn2.addActionListener(this);
        }

        public void showFrame() {

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(380, 250);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn) {
                dispose(); //system is terminated 
            } else if (e.getSource() == btn2) { //returns to main menu 
                dispose();
                MainMenu mm = new MainMenu();
                mm.setVisible(true);
            }

        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new CarReservationSystem();
        });

    }
}
