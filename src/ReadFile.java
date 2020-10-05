import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame {
    private JTextField addressBar;
    private JEditorPane display;

    //constructor

    public ReadFile() {
        super("My Browser");

        addressBar = new JTextField("Type here:");
        addressBar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        loadWebSite(event.getActionCommand());

                    }
                }
        );
        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent event) {
                        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                            loadWebSite(event.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(1280, 720);
        setVisible(true);


    }
    // load crap to display on the screen

    private void loadWebSite(String userText){
            String url = new String("https://www." + userText);
        try{
            display.setPage(url);
            addressBar.setText(url);
        }catch (Exception e){
            System.out.println("Cannot resolve URL");
        }

    }

}

