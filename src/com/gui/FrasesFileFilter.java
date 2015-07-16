package com.gui;

import java.io.File;
import javax.swing.filechooser.*;


public class FrasesFileFilter extends FileFilter {

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String $extension = Utils.getExtension(f);
        
        if ($extension == null) {return false;}		
		if ($extension.equals("carp")) {return true;}
		if ($extension.equals("txt")) {return true;}
		if ($extension.equals("pdf")) {return true;}

        return false;
    }

   
    public String getDescription() {
        return "CARP File (*.carp)";
    }
}
