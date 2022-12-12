import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
	private String  nomJ1,nomJ2,motAlt,motprop1,motprop2,score1,score2;
	JTextField carac;
	Functions functions;
	int [] bonnus ;
    Gui(){
		JFrame frame = new JFrame();
		frame.setTitle("Word Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		//frame.setLayout(new GridLayout(9,3,10,10));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,2,10,10));
		panel.setBounds(180,100,500,400);
		JLabel title = new JLabel ("Bienvenue au Word Game  !");
		title.setBounds(280,50,300,50);
		title.setFont(new Font("Arial",Font.BOLD,18));
		title.setForeground(Color.BLUE);
		JLabel label0 = new JLabel ("");
		JLabel label1 = new JLabel (" Nom du Joueur 1");
		JLabel label2 = new JLabel (" Nom du Joueur 2");
		JLabel label3 = new JLabel (" Caractères affichés");
		JLabel label4 = new JLabel (" Mot proposé 1");
		JLabel label5 = new JLabel (" Mot proposé 2");
		JLabel label6 = new JLabel (" Score du joueur 1");
		JLabel label7 = new JLabel (" Score du joueur 2");
		JLabel label8 = new JLabel ("");
		JTextField nomjoueur1 = new JTextField("", 12);
		JTextField nomjoueur2 = new JTextField("", 12);
		 carac = new JTextField("", 12);
		JTextField mot1 = new JTextField("", 12);
		JTextField mot2 = new JTextField("", 12);

		JTextField sc1 = new JTextField("0",12);
		JTextField sc2 = new JTextField("0", 12);

		JButton btn = new JButton (" Calculer le Score ");
		JButton btnGnr= new JButton("générer les caractères");
		btnGnr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomJ1=nomjoueur1.getText();
				nomJ2=nomjoueur2.getText();
				functions =new Functions(nomJ1,nomJ2);
				carac.setText(functions.AffichRnd());

			}
		});
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				motprop1=mot1.getText();
				motprop2=mot2.getText();
			    bonnus=functions.calculScore(motprop1,motprop2);
				sc1.setText(String.valueOf(bonnus[0]));
				sc2.setText(String.valueOf(bonnus[1]));
                String jganie;
				if(bonnus[0] >=10 || bonnus[1] >= 10){
					if (bonnus[0] > bonnus [1])
						jganie="joueur 1";
					else
						jganie="joueur 2";
					JFrame frame = new JFrame();
					JOptionPane optionPane = new JOptionPane("le "+jganie+" a gagné ",JOptionPane.INFORMATION_MESSAGE);
					JDialog dialog = optionPane.createDialog("Résultat");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
				}

			}
		});

		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.RED);

		panel.add(label1);
		panel.add(nomjoueur1);

		panel.add(nomjoueur2);
		panel.add(label2);
		panel.add(nomjoueur2);
		panel.add(label8);
		panel.add(btnGnr);
		panel.add(label3);
		panel.add(carac);
		panel.add(label4);
		panel.add(mot1);
		panel.add(label5);
		panel.add(mot2);
		panel.add(label0);
		panel.add(btn);


		panel.add(label6);
		panel.add(sc1);

		panel.add(label7);
		panel.add(sc2);

		//JOptionPane.ShowConfirmDialog(null,"Tu veux quitter le jeu ?",fermer);




		frame.add(title);
		frame.add(panel);

		frame.setVisible(true);
		while (nomJ1 == null || nomJ2 ==null);
	}

	public String getNomJ1() {
		return nomJ1;
	}

	public void setNomJ1(String nomJ1) {
		this.nomJ1 = nomJ1;
	}

	public String getNomJ2() {
		return nomJ2;
	}

	public void setNomJ2(String nomJ2) {
		this.nomJ2 = nomJ2;
	}

	public String getMotAlt() {
		return motAlt;
	}

	public void setMotAlt(String motAlt) {
		this.motAlt = motAlt;
	}

	public String getMotprop1() {
		return motprop1;
	}

	public void setMotprop1(String motprop1) {
		this.motprop1 = motprop1;
	}

	public String getMotprop2() {
		return motprop2;
	}

	public void setMotprop2(String motprop2) {
		this.motprop2 = motprop2;
	}

	public String getScore1() {
		return score1;
	}

	public void setScore1(String score1) {
		this.score1 = score1;
	}

	public String getScore2() {
		return score2;
	}

	public void setScore2(String score2) {
		this.score2 = score2;
	}
}

