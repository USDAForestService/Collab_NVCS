package nvcs_components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nvcs_patterns.PatternList;

public class Plot {

    public String ident;
    public String rscd;
    public String state;
    public String ecoregion;
    public String plantation;
    public String hydric;
    public String riverine;
    public Float elevation;
    public Float balive;
    public Float fbcov;
    public Float grcov;
    public Float shcov;
    public Float ttcov;
    public Float ntcov;
    public List<Tree> trees;
    public Map<String,Object> attrs;
    
    public Plot(String ident, String rscd, String state, String ecoregion, String plantation, String hydric, String riverine, String elevation, String balive, String fbcov, String grcov, String shcov, String ttcov, String ntcov) {
        this.ident = ident != null ? ident : "";
        this.rscd = rscd != null ? rscd : "";
        this.state = state != null ? state : "";
        this.ecoregion = ecoregion != null ? ecoregion : "";
        this.plantation = plantation != null ? plantation : "";
        this.hydric = hydric != null ? hydric : "";
        this.riverine = riverine != null ? riverine : "";
        this.elevation = Float.parseFloat(elevation != null ? elevation : "0");
        this.balive = Float.parseFloat(balive != null ? balive : "0");
        this.fbcov = Float.parseFloat(fbcov != null ? fbcov : "0");
        this.grcov = Float.parseFloat(grcov != null ? grcov : "0");
        this.shcov = Float.parseFloat(shcov != null ? shcov : "0");
        this.ttcov = Float.parseFloat(ttcov != null ? ttcov : "0");
        this.ntcov = Float.parseFloat(ntcov != null ? ntcov : "0");
        this.trees = new ArrayList<>();

        this.attrs = new HashMap<>();
        this.attrs.put("ident", this.ident);
        this.attrs.put("rscd", this.rscd);
        this.attrs.put("state", this.state);
        this.attrs.put("ecoregion", this.ecoregion);
        this.attrs.put("plantation", this.plantation);
        this.attrs.put("hydric", this.hydric);
        this.attrs.put("riverine", this.riverine);
        this.attrs.put("elevation", this.elevation);
        this.attrs.put("balive", this.balive);
        this.attrs.put("fbcov", this.fbcov);
        this.attrs.put("grcov", this.grcov);
        this.attrs.put("shcov", this.shcov);
        this.attrs.put("ttcov", this.ttcov);
        this.attrs.put("ntcov", this.ntcov);
    }

    public boolean match(PatternList pattlist) {
        boolean result = pattlist.match_any(attrs);
        return result;
    }

    public double riv(PatternList pattlist) {
        float pct_riv;
        float match_riv = 0;
        float total_riv = 0;
        for (Tree tree : trees) {
            if (tree.species.equals("")) continue;
            total_riv += tree.riv;
            Map<String,Object> allAttrs = new HashMap<>();
            allAttrs.putAll(attrs);
            allAttrs.putAll(tree.attrs);
            if (pattlist.match_any(allAttrs)) {
                match_riv += tree.riv;
            }
        }
        if (total_riv == 0) {
            pct_riv = 0;
        }
        else {
            pct_riv = (match_riv / total_riv) * 100;
        }
        return Math.ceil(pct_riv * 100) / 100.0;
    }

    public double spcov(PatternList pattlist) {
        float match_spcov = 0;
        for (Tree tree : trees) {
            if (tree.species.equals("")) continue;
            Map<String,Object> allAttrs = new HashMap<>();
            allAttrs.putAll(attrs);
            allAttrs.putAll(tree.attrs);
            if (pattlist.match_any(allAttrs)) {
                match_spcov += tree.spcov;
            }
        }
        return Math.ceil(match_spcov * 100) / 100.0;
    }

    public float get_elevation() {
        return elevation;
    }

    public float get_balive() {
        return balive;
    }

    public float get_fbcov() {
        return fbcov;
    }

    public float get_grcov() {
        return grcov;
    }

    public float get_shcov() {
        return shcov;
    }

    public float get_ttcov() {
        return ttcov;
    }

    public float get_ntcov() {
        return ntcov;
    }

    @Override
    public String toString() {
        return String.format("Plot(%s)", attrs);
    }

}
