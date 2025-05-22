package nvcs_components;

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
        this.species = species != null ? species : "";
        this.riv = Float.parseFloat(riv != null ? riv : "0");
        this.wetland = wetland != null ? wetland : "";
        this.ruderal = ruderal != null ? ruderal : "";
        this.exotic = exotic != null ? exotic : "";
        this.softwoodhardwood = softwoodhardwood != null ? softwoodhardwood : "";
        this.planted = planted != null ? planted : "";
        this.tallytree = tallytree != null ? tallytree : "";
        this.spcov = Float.parseFloat(spcov != null ? spcov : "0");

        this.attrs = new HashMap<>();
        this.attrs.put("species", this.species);
        this.attrs.put("riv", this.riv);
        this.attrs.put("wetland", this.wetland);
        this.attrs.put("ruderal", this.ruderal);
        this.attrs.put("exotic", this.exotic);
        this.attrs.put("softwoodhardwood", this.softwoodhardwood);
        this.attrs.put("planted", this.planted);
        this.attrs.put("tallytree", this.tallytree);
        this.attrs.put("spcov", this.spcov);
    }

    @Override
    public String toString() {
        return String.format("Tree(%s)", attrs);
    }

}
