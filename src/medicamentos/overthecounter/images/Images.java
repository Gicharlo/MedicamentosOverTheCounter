/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicamentos.overthecounter.images;

import java.io.File;

public class Images {
    private final File dorflex = new File("./src/medicamentos/overthecounter/images/Analgésico Dorflex 10 Comprimidos.png");
    private final File doril  = new File("./src/medicamentos/overthecounter/images/Doril Enxaqueca 18 Comprimidos.png");
    private final File dipirona  = new File("./src/medicamentos/overthecounter/images/Dipirona Sódica 500mg Genérico EMS 10 Comprimidos.png");
    private final File neosaldina = new File("@.../images/Neosaldina 20 drágeas.png");
    private final File aspirina = new File("@.../images/Analgésico Aspirina Adulto 500mg Bayer 10 Comprimidos.png");

    public Images(){
        
    }
    public File getDorflex() {
        return dorflex;
    }
    public File getDoril() {
        return doril;
    }
    public File getDipirona() {
        return dipirona;
    }

    public File getNeosaldina() {
        return neosaldina;
    }

    public File getAspirina() {
        return aspirina;
    }  
}
