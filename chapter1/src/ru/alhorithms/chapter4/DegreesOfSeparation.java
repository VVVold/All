package ru.alhorithms.chapter4;

public class DegreesOfSeparation {

    DegreesOfSeparation(String v, String w, SymbolGraph SG) {
        if (!SG.contain(v) || !SG.contain(w)) System.out.println("Такой путь не может быть найден");
        else {
            Graph G = SG.G();
            BreadthFirstPath bsp = new BreadthFirstPath(G, SG.index(v));
            if (bsp.hasPathTo(SG.index(w))) {
                bsp.pathTo(SG.index(w));
                for (int i : bsp.pathTo(SG.index(w)))
                    System.out.println( i + ". " + SG.name(i));
            } else System.out.println("Путь не найден");
        }
    }
}
