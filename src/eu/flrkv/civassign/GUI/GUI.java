package eu.flrkv.civassign.GUI;

import eu.flrkv.civassign.CivUtils.Civilization;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Insets;

public class GUI extends JFrame implements ActionListener{
    //Attribute
    private ArrayList<Civilization> civilizationList;

    //GUI Attribute
    private JButton randomCivilization;
    private JLabel labelEmpire;
    private JLabel labelLeader;
    private JPanel panel = new JPanel();

    //GUI
    public GUI(){
        super("CIV6 Zivilisationen-Generator");
        generateBox();
        generateRandomCivilizationButton();
        generateLabelEmpire();
        generateLabelLeader();
    }

    private void generateBox(){
        this.setSize(200, 200);
        this.setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    private void generateRandomCivilizationButton(){
        randomCivilization = new JButton("Zivilisation generieren");
        randomCivilization.setBounds(200, 100, 250, 200);
        randomCivilization.addActionListener(this);
        this.add(randomCivilization);
    }


    private void generateLabelEmpire() {
        labelEmpire = new JLabel("n/A");
        labelEmpire.setVisible(false);
        this.add(labelEmpire);
    }

    private void setLabelEmpireText(String txt){
        labelEmpire.setText(txt);
        labelEmpire.setVisible(true);
    }

    private void generateLabelLeader() {
        labelLeader = new JLabel("n/A");
        labelLeader.setVisible(false);
        this.add(labelLeader);
    }

    private void setLabelLeaderText(String txt){
        labelLeader.setText(txt);
        labelLeader.setVisible(true);
    }

    public void ArrayToList(Civilization[] civs){
        civilizationList = new ArrayList<>(Arrays.asList(civs));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == randomCivilization){
            Collections.shuffle(civilizationList);
            try {
                this.setLabelEmpireText("Ihre Zivilisation: " + civilizationList.get(0).getEmpire());
                this.setLabelLeaderText("Ihr Anführer: " + civilizationList.get(0).getLeader());
                civilizationList.remove(0);
            } catch(IndexOutOfBoundsException e) {
                this.setLabelEmpireText("DU HURENSOHN!");
                this.setLabelLeaderText("DIE LISTE IST SCHON LEER!");
            }
        }
    }
}