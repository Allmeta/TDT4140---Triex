package tdt4140.gr1836.app.ui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("serial")
public class CardioWorkoutController extends JFrame {
	public CardioWorkoutController() {
		setLayout(new GridLayout(5, 5));
		add(new JLabel("Duration"));
		add(new JLabel("Intensity"));
		add(new JLabel("Preformance"));
		add(new JLabel("Shape"));
		add(new JLabel("Informaton"));
		}
	
	public static void main(String[] args) throws Exception {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm a");
		File file = new File("CardioWorkout.txt");
		if (!file.exists() || file.isDirectory()) {
			PrintWriter writer = new PrintWriter("CardioWorkout.txt", "UTF-8");
			writer.close();
			}
		
		final PrintWriter output = new PrintWriter(new FileWriter(file, true));
		output.println("\n" + sdf.format(cal.getTime()));
		JFrame frame = new CardioWorkoutController();
		frame.setTitle("Cardio Workout");
		
		final JTextField[] CardioWorkoutController = {
				new JTextField("Running"),
				new JTextField("Swimming"),
				new JTextField("Cross contry skiing"),
				new JTextField("Skating"),
				new JTextField("Cycling")
				};
		
		final JTextField[] Duration = new JTextField[3];
		final JTextField[] Intensity = new JTextField[3];
		final JTextField[] Preformance = new JTextField[3];
		final JTextField[] Shape = new JTextField[3];
		final JTextField[] Information = new JTextField[3];
		
		for (int i = 0; i < 3; i++) {
			frame.add(CardioWorkoutController[i]);
			frame.add(Duration[i]);
			frame.add(Intensity[i]);
			frame.add(Preformance[i]);
			frame.add(Shape[i]);
			frame.add(Information[i]);
			}
		
		output.close();
		System.exit(0);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}


