package nvcs_java.nvcs_components;

import java.util.HashMap;
import java.util.Map;

public class Tree {
    
    public String species;
    public Float riv;
    public String wetland;
    public String ruderal;
    public String exotic;
    public String softwoodhardwood;
    public String planted;
    public String tallytree;
    public Float spcov;
    public Map<String,Object> attrs; 

    public Tree(String species, String riv, String wetland, String ruderal, String exotic, String softwoodhardwood, String planted, String tallytree, String spcov) {
        this.species = species;
        this.riv = Float.parseFloat(riv);
        this.wetland = wetland;
        this.ruderal = ruderal;
        this.exotic = exotic;
        this.softwoodhardwood = softwoodhardwood;
        this.planted = planted;
        this.tallytree = tallytree;
        this.spcov = Float.parseFloat(spcov);

        this.attrs = new HashMap<>();
        this.attrs.put("species", species);
        this.attrs.put("riv", riv);
        this.attrs.put("wetland", wetland);
        this.attrs.put("ruderal", ruderal);
        this.attrs.put("exotic", exotic);
        this.attrs.put("softwoodhardwood", softwoodhardwood);
        this.attrs.put("planted", planted);
        this.attrs.put("tallytree", tallytree);
        this.attrs.put("spcov", spcov);
    }

    @Override
    public String toString() {
        return String.format("Tree(%s)", attrs);
    }

}
