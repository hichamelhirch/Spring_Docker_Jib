package org.sid.imc_spring_jib;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ImcService {

    public Map<String,String> calculate(ImcDTO data){
        double imc=data.poids()/Math.pow(data.taille(),2);
        imc=Math.round(imc*100)/100;
        String avis=this.analyse(imc);
        return Map.of("imc",String.valueOf(imc),
                "avis",avis);
    }

    public  String analyse(double imc) {
        if (imc < 16.5) {
            return "Maigreur - Risque élevé";
        } else if (imc >= 16.5 && imc < 18.5) {
            return "Maigreur - Risque accru";
        } else if (imc >= 18.5 && imc < 25) {
            return "Corpulence normale - Risque faible";
        } else if (imc >= 25 && imc < 30) {
            return "Surpoids ou pré-obésité - Risque accru";
        } else if (imc >= 30 && imc < 35) {
            return "Obésité modérée (classe I) - Risque élevé";
        } else if (imc >= 35 && imc < 40) {
            return "Obésité sévère (classe II) - Risque très élevé";
        } else {
            return "Obésité morbide (classe III) - Risque extrêmement élevé";
        }
    }
}
