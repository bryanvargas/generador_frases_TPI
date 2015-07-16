package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class Graficos extends JFrame{


	    public Graficos(){
	        setTitle("Como Hacer Graficos con Java");
	        setSize(800,600);
	        setLocationRelativeTo(null);
	       // setDefaultCloseOperation(EXIT_ON_CLOSE);
	        init();
	    }
	 
	    private void init() {
	    	JFreeChart Graficos;
	    	DefaultCategoryDataset Datos = new DefaultCategoryDataset();
	    	Datos.addValue(2, "Negocio 1", "Martes");
	    	Datos.addValue(3, "Negocio 1", "Miércoles");
	    	Datos.addValue(4, "Negocio 1", "Jueves");
	    	Datos.addValue(5, "Negocio 1", "Viernes");
	    	Datos.addValue(6, "Negocio 1", "Sábado");
	    	Datos.addValue(7, "Negocio 1", "Domingo");
	    	Datos.addValue(2, "Negocio 2", "Lunes");
	    	Datos.addValue(4, "Negocio 2", "Martes");
	    	Datos.addValue(6, "Negocio 2", "Miércoles");
	    	Datos.addValue(8, "Negocio 2", "Jueves");
	    	Datos.addValue(10, "Negocio 2", "Viernes");
	    	Datos.addValue(12, "Negocio 2", "Sábado");
	    	Datos.addValue(14, "Negocio 2", "Domingo");
	    	
	    	Graficos = ChartFactory.createBarChart("Visitas diarias",
	    			"Días", "Visitas", Datos,
	    			PlotOrientation.VERTICAL, true, true, false);
//	        panel = new JPanel();
//	        getContentPane().add(panel);
//	        // Fuente de Datos
//	        DefaultPieDataset defaultpiedataset = new DefaultPieDataset(); 
//	        defaultpiedataset.setValue("Programacion", new Double(41.200000000000003D)); 
//	        defaultpiedataset.setValue("Electronica", new Double(11D)); 
//	        defaultpiedataset.setValue("Hacking", new Double(19.5D)); 
//	        defaultpiedataset.setValue("SEO", new Double(30.5D)); 
//	        defaultpiedataset.setValue("Redes", new Double(2.0D)); 
//	 
//	        // Creando el Grafico
//	        JFreeChart chart = ChartFactory.createPieChart3D("Tematicas Blog", defaultpiedataset, true, true, false); 
//	        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot(); 
//	        pieplot3d.setDepthFactor(0.5); 
//	        pieplot3d.setStartAngle(290D); 
//	        pieplot3d.setDirection(Rotation.CLOCKWISE); 
//	        pieplot3d.setForegroundAlpha(0.5F); 
//	        
//	        // Mostrar Grafico
//	        ChartPanel chartPanel = new ChartPanel(chart);
//	        panel.add(chartPanel);
	    	ChartPanel Panel = new ChartPanel(Graficos);
	    	add(Panel);
	    }


	
}
