package ir.university.toosi.tms.view;

import ir.university.toosi.tms.controller.LanguageAction;

import javax.swing.*;
import java.awt.*;

/**
 * @author : Hamed Hatami , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSJDesktop extends JDesktopPane {

    Image image = new ImageIcon("D:\\Layering.jpg").getImage();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
    }
}
