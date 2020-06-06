package com.example.VZoo;

import com.example.VZoo.entities.Animais;
import com.example.VZoo.entities.Habitats;

import java.util.List;

public class Satisfacao {

    public static int calcular(Animais animalQueQuerSaberASatisfacao) {
        return 20 + igual(animalQueQuerSaberASatisfacao) - diferente(animalQueQuerSaberASatisfacao) + espaco(animalQueQuerSaberASatisfacao);
    }

    private static int igual(Animais animalQueQuerSaberQuantosAnimaisIguais)
    {
        Habitats habitatDoAnimalQueQuerSaberIguais = animalQueQuerSaberQuantosAnimaisIguais.getHabitat();
        List<Animais> animaisDoMesmoHabitat = habitatDoAnimalQueQuerSaberIguais.getAnimais();

        int contadorDeAnimaisDaMesmaEspecie = 0;

        for (Animais animalQueResideNoMesmoHabitat : animaisDoMesmoHabitat) {
            if (animalQueResideNoMesmoHabitat.getEspecie().equals(animalQueQuerSaberQuantosAnimaisIguais.getEspecie())) {
                contadorDeAnimaisDaMesmaEspecie++;
            }
        }

        // Não se conta com o próprio
        contadorDeAnimaisDaMesmaEspecie--;

        return 3 * contadorDeAnimaisDaMesmaEspecie;
    }

    private static int diferente(Animais animalQueQuerSaberDiferentes) {
        String especieDoAnimalOriginal = animalQueQuerSaberDiferentes.getEspecie();
        Habitats habitatDoAnimalOriginal = animalQueQuerSaberDiferentes.getHabitat();

        List<Animais> animaisDoMesmoHabitat = habitatDoAnimalOriginal.getAnimais();

        int contadorDeAnimaisDiferentes = 0;

        for (int i = 0; i < animaisDoMesmoHabitat.size(); i++) {
            Animais animalQueQueroComparar = animaisDoMesmoHabitat.get(i);
            String especieDoOutroAnimal = animalQueQueroComparar.getEspecie();

            if (!(especieDoAnimalOriginal.equals(especieDoOutroAnimal))) {
                contadorDeAnimaisDiferentes++;
            }
        }

        return 2 * contadorDeAnimaisDiferentes;
    }

    private static int espaco(Animais animalQueMoraNoHabitat) {
        // Saber o número de animais nesse Habitat - População
        // Arredondar (Area / População)

        Habitats habitatOndeMoraOAnimal = animalQueMoraNoHabitat.getHabitat();
        int areaDoHabitat = habitatOndeMoraOAnimal.getArea();
        int numeroDeAnimaisNoHabitat = habitatOndeMoraOAnimal.getAnimais().size();

        int arredondamento = Math.round(areaDoHabitat / numeroDeAnimaisNoHabitat);

        return  arredondamento;
    }
}
