package com.gui;

import javax.swing.filechooser.FileView;

import java.io.File;
import javax.swing.*;
public class ImagenFileVista extends FileView {
    ImageIcon fraseIcon = Utils.createImageIcon("/images/favicon.png");
    ImageIcon pdfIcon = Utils.createImageIcon("/images/pdf.png");
    
    public String getTypeDescription(File f) {
        String extension = Utils.getExtension(f);
        String type = null;
        if (extension != null) {
           if (extension.equals(Utils.carp)){
                type = "CARP Image";           
            } 
           if (extension.equals(Utils.pdf)){
               type = "PDF Image";           
           } 
        }
        return type;
    }

    public Icon getIcon(File f) {
        String extension = Utils.getExtension(f);
        Icon icon = null;

        if (extension != null) {
            if (extension.equals(Utils.carp)) 
                icon = fraseIcon;
            if (extension.equals(Utils.pdf)) 
                icon = pdfIcon;
           
        }
        return icon;
    }
    
    
}